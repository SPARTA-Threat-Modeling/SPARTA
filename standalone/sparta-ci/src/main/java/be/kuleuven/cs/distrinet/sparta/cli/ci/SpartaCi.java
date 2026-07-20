/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
/**
 *
 */
package be.kuleuven.cs.distrinet.sparta.cli.ci;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import be.kuleuven.cs.distrinet.sparta.cli.PathResolver;
import be.kuleuven.cs.distrinet.sparta.cli.SpartaCliProcessor;
import be.kuleuven.cs.distrinet.sparta.cli.SpartaServerClient;
import be.kuleuven.cs.distrinet.sparta.core.model.IInteractionThreat;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.convert.YmlToEmfConverter;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaResource;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.util.SpartaModelResourceFactoryImpl;

/**
 * Simple class to run sparta in a CI context. This processes a .sparta.yml file
 * to determine which model to load and to which CTAM server to send the
 * analysis results.
 *
 * <p>The flow is split into {@link #readConfig(File)} (parse {@code .sparta.yml} + resolve the
 * git commit), {@link #analyze(CiConfiguration)} (load the model, run the analysis and
 * serialize the result), and the server submission. {@code main} orchestrates them and owns
 * the process exit codes, which keeps the analysis pipeline testable without a live server.
 *
 * @author Laurens
 *
 */
public class SpartaCi {

	private static final Logger logger = LoggerFactory.getLogger(SpartaCi.class);
	private static final String YML_CONF_FILE = ".sparta.yml";

	/**
	 * Data class containing the analysis results of a SPARTA CI run.
	 * @author Laurens
	 *
	 */
	public static class AnalysisResults {
		/**
		 * Create a new AnalysisResults object with the specified list of threats and the specified model.
		 *
		 * @param threatList the list of threats.
		 * @param model the model xmi as text
		 */
		public AnalysisResults(List<IInteractionThreat> threatList, String model) {
			this.threatList = threatList;
			this.model = model;
		}

		private List<IInteractionThreat> threatList;
		private String model;

		@JsonSerialize(as = List.class, contentAs = IInteractionThreat.class)
		public List<IInteractionThreat> getThreatList() {
			return threatList;
		}

		public String getModel() {
			return model;
		}

	}


	/**
	 * Run SPARTA in a CI context.
	 * @param args command line arguments; SpartaCI currently does not have any cli args.
	 */
	public static void main(String[] args) {
		logger.info("Reading SPARTA yml config");
		File wd = new File(System.getProperty("user.dir"));

		CiConfiguration conf;
		try {
			conf = readConfig(wd);
		} catch (FileNotFoundException e) {
			logger.error("Did not find SPARTA ci configuration.");
			System.exit(1);
			return;
		}

		AnalysisResults results = analyze(conf);
		if (results == null) {
			System.exit(1);
			return;
		}

		// Submit via the shared client (same implementation the CLI exporter uses).
		boolean ok = SpartaServerClient.submit(
				conf.getServer().getUrl(),
				conf.getServer().getToken(),
				conf.getOverrideCommit(),
				writer -> new ObjectMapper().writer().writeValue(writer, results));
		if (!ok) {
			System.exit(1);
		}
	}

	/**
	 * Parse the {@code .sparta.yml} configuration from {@code workingDir} and, if the file
	 * sits inside a git repository, resolve the current HEAD commit onto the configuration.
	 *
	 * @param workingDir the directory containing the {@code .sparta.yml} file.
	 * @return the parsed configuration.
	 * @throws FileNotFoundException if there is no {@code .sparta.yml} in {@code workingDir}.
	 */
	public static CiConfiguration readConfig(File workingDir) throws FileNotFoundException {
		Representer representer = new Representer(new DumperOptions());
		representer.getPropertyUtils().setSkipMissingProperties(true);
		Yaml yaml = new Yaml(new Constructor(CiConfiguration.class, new LoaderOptions()), representer);
		File yml = new File(workingDir, YML_CONF_FILE);
		CiConfiguration conf = yaml.load(new FileInputStream(yml));

		logger.info("Input model: {}", conf.getInput().getModel());
		logger.info("Submitting to server: {}", conf.getServer().getUrl());

		FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
		repositoryBuilder.readEnvironment().findGitDir(yml);
		if (repositoryBuilder.getGitDir() != null) {
			logger.info("Found git repository: {}", repositoryBuilder.getGitDir());
			try {
				Repository repository = repositoryBuilder.build();
				ObjectId head = repository.resolve("HEAD");
				if (head != null) {
					conf.setOverrideCommit(head.getName());
					logger.info("Found commit: {}", head.getName());
				}
			} catch (IOException e) {
				logger.error("Error reading git repository: {}", e.getMessage(), e);
			}
		}
		return conf;
	}

	/**
	 * Load the configured model, run the threat analysis and serialize the (pattern-stripped)
	 * DFD model, producing the payload that would be submitted to the server. Performs no
	 * network I/O, so it is safe to run without a CTAM server.
	 *
	 * @param conf the CI configuration.
	 * @return the analysis results (threats + serialized model), or {@code null} if the model
	 *         could not be converted, contained no {@link DFDModel}, or failed to serialize.
	 */
	public static AnalysisResults analyze(CiConfiguration conf) {
		String model = conf.getInput().getModel();
		if (model.endsWith("txt")) {
			try {
				new YmlToEmfConverter(model);
				model = "dfd.securitydfd";
			} catch (IOException e) {
				logger.error("Error converting model to EMF: {}", e.getMessage(), e);
				return null;
			}
		}

		SpartaCliProcessor.setupEMFStandalone();
		SpartaCliProcessor.setupVIATRAStandalone();

		// Load the model once and reuse the ResourceSet for both the analysis and the
		// DFDModel extraction, rather than parsing the model multiple times.
		ResourceSet modelRes = SpartaCliProcessor.loadModel(model);
		List<Threat> results = SpartaCliProcessor.runThreatAnalysis(modelRes);
		EcoreUtil.resolveAll(modelRes);
		DFDModel dfdModel = modelRes
				.getResource(PathResolver.toFileURI(System.getProperty("user.dir"), model), false).getContents()
				.stream().filter(DFDModel.class::isInstance).map(DFDModel.class::cast).findAny().orElse(null);

		if (dfdModel == null) {
			logger.error("No DFDModel found in model '{}'; aborting.", model);
			return null;
		}

		ResourceSet newRes = new ResourceSetImpl();
		newRes.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sparta",
				new SpartaModelResourceFactoryImpl());
		Resource res = newRes.createResource(URI.createURI("tmp.sparta"));
		dfdModel.getContainedElements()
				.addAll(modelRes.getResources().stream().flatMap(r -> r.getContents().stream())
						.filter(el -> !dfdModel.equals(el)).filter(SpartaResource.class::isInstance)
						.map(SpartaResource.class::cast).collect(Collectors.toList()));
		List<ThreatSpecification> specs = new ArrayList<>();
		List<ThreatType> types = new ArrayList<>();
		dfdModel.eAllContents().forEachRemaining(o -> {
			if (o instanceof ThreatSpecification) {
				specs.add((ThreatSpecification) o);
			}
			if (o instanceof ThreatType) {
				types.add((ThreatType) o);
			}
		});
		specs.stream().forEach(s -> {
			s.getPatterns().clear();
			s.getTypes().clear();
		});
		types.stream().forEach(t -> t.getPatterns().clear());
		res.getContents().add(dfdModel);

		String out;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			Map<Object, Object> opts = new HashMap<>();
			opts.put(XMIResource.OPTION_ENCODING, "UTF-8");
			res.save(baos, opts);
			out = baos.toString(StandardCharsets.UTF_8);
		} catch (IOException e) {
			logger.error("Error serializing model: {}", e.getMessage(), e);
			return null;
		}

		List<IInteractionThreat> threats = results.stream().map(IInteractionThreat.class::cast)
				.collect(Collectors.toList());
		return new AnalysisResults(threats, out);
	}
}
