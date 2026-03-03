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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
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
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import be.kuleuven.cs.distrinet.sparta.cli.SpartaCliProcessor;
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

		Representer representer = new Representer();
		representer.getPropertyUtils().setSkipMissingProperties(true);
		Yaml yaml = new Yaml(new Constructor(CiConfiguration.class), representer);
		File yml = new File(wd, YML_CONF_FILE);
		try {
			CiConfiguration conf = yaml.load(new FileInputStream(yml));

			logger.info("Input model: {}", conf.getInput().getModel());
			logger.info("Submitting to server: {}", conf.getServer().getUrl());

			FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
			repositoryBuilder.readEnvironment().findGitDir(yml);

			if (repositoryBuilder.getGitDir() != null) {
				logger.info("Found git repository: {}", repositoryBuilder.getGitDir());
				Repository repository;
				try {
					repository = repositoryBuilder.build();
					ObjectId head = repository.resolve("HEAD");
					if (head != null) {
						conf.setOverrideCommit(head.getName());
						logger.info("Found commit: {}", head.getName());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			String model = conf.getInput().getModel();
			if (model.endsWith("txt")) {
				try {
					new YmlToEmfConverter(model);
					model = "dfd.securitydfd";
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			SpartaCliProcessor.setupEMFStandalone();
			SpartaCliProcessor.setupVIATRAStandalone();

			List<Threat> results;
			results = SpartaCliProcessor.runThreatAnalysis(model);

			ResourceSet modelRes = SpartaCliProcessor.loadModel(model);
			EcoreUtil.resolveAll(modelRes);
			DFDModel dfdModel = modelRes
					.getResource(URI.createFileURI(System.getProperty("user.dir") + "/" + model), false).getContents()
					.stream().filter(DFDModel.class::isInstance).map(DFDModel.class::cast).findAny().orElse(null);

//
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
			String out = "";
			try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
				Map opts = new HashMap();
				opts.put(XMIResource.OPTION_ENCODING, "UTF-8");
				res.save(baos, opts);
				out = baos.toString(StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				URL url = new URL(conf.getServer().getUrl());
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setRequestProperty("token", conf.getServer().getToken());
				con.setRequestProperty("commitId", conf.getOverrideCommit());
				con.setDoOutput(true);

				try (OutputStream os = con.getOutputStream();
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
					ObjectMapper mapper = new ObjectMapper();
					mapper.writer().writeValue(bw, new AnalysisResults(
							results.stream().map(IInteractionThreat.class::cast).collect(Collectors.toList()), out));

				} catch (IOException e1) {
					logger.error("Error writing json: {}", e1.getMessage());
					e1.printStackTrace();
				}
				try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
					StringBuilder response = new StringBuilder();
					String responseLine = null;
					while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
					}
					logger.info(response.toString());
				}

			} catch (IOException eI) {
				eI.printStackTrace();
				logger.error("IOError submitting to SPARTA Server: ", eI.getMessage());
			}
			logger.info("SPARTA Server submission finished.");

		} catch (FileNotFoundException e) {
			logger.error("Did not find SPARTA ci configuration.");
		}
	}
}
