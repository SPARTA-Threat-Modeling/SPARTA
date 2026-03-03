/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.cli;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import jakarta.inject.Singleton;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchBackendFactoryProvider;
import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchEMFBackendFactory;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactoryProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import be.kuleuven.cs.distrinet.sparta.cli.cmd.GenericCliCmd;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.Help;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.Exporter;
import be.kuleuven.cs.distrinet.sparta.core.Engine;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.util.SpartaModelResourceFactoryImpl;

/**
 * Command line processor. Every {@link GenericCliCmd} and {@link Exporter} can
 * provide a list of options and will be called with the provided arguments to
 * check if they need to perform any action.
 *
 * @author Laurens
 *
 */
@Singleton
public class SpartaCliProcessor implements CliProcessor {

	private static final Logger logger = LoggerFactory.getLogger(SpartaCliProcessor.class);
	private final Options options;
	private final Set<GenericCliCmd> gens;
	private final Set<Exporter> exporters;
	private final CommandLineParser parser = new DefaultParser();
	private final Option optVerbose;
	private final Option optInput;
	private final Option optTreeInput;

	/**
	 * Create a new SpartaCliProcessor.
	 *
	 * @param gens Set of generic command such as help, about, etc.
	 * @param exporters Set of potential exporters to provide export functionality to csv, xlsx, etc.
	 */
	@Inject
	public SpartaCliProcessor(Set<GenericCliCmd> gens, Set<Exporter> exporters) {
		this.gens = gens;
		this.exporters = exporters;
		logger.debug("Initializing Sparta CLI processor...");
		options = new Options();
		gens.stream().forEach(this::registerGeneric);
		exporters.stream().forEach(this::registerExporter);
		optVerbose = new Option("v", "verbose", false, "Provide verbose output");
		optInput = new Option("i", "input", true, "Model to analyze");
		optTreeInput = new Option("it", "inputtree", true, "Threat Tree to process");
		options.addOption(optVerbose);
		options.addOption(optInput);
		options.addOption(optTreeInput);
	}

	/**
	 * Process the provided command line arguments.
	 *
	 * @param args the cli arguments
	 */
	@Override
	public void process(String[] args) {
		CommandLine cmd = null;

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			logger.error("Error parsing commands: {}", e.getMessage());
			new Help(() -> this).process(null);
			System.exit(1);
		}

		for (GenericCliCmd c : gens) {
			c.process(cmd);
		}

		if (cmd.hasOption(optInput.getOpt())) {

			setupEMFStandalone();
			setupVIATRAStandalone();

			List<Threat> results;

			String target = cmd.getOptionValue(optInput.getOpt());
			results = runThreatAnalysis(target);

			for (Exporter c : exporters) {
				c.process(cmd, results);
			}
		}

	}

	/**
	 * Run a threat analysis on user-specified model. The model file is retrieved from the cli arguments.
	 * @param target the model
	 * @return the resulting list of threats
	 */
	public static  List<Threat> runThreatAnalysis(String target) {
		List<Threat> results;
		logger.info("Running SPARTA Analysis ...");


		logger.debug("Cwd: {}",System.getProperty("user.dir"));

		ResourceSet resourceSet = loadModel(target);
		Engine e = new Engine(resourceSet);

		results = e.runAnalysis(resourceSet);

		results.stream().map(Threat::toString).forEach(t -> logger.debug("Threat: {}", t));

		return results;
	}

	
	/**
	 * Load a model from the provided filename. This is a helper method that returns the ResourceSet.
	 * It does not run the threat analysis. To load a model and run the threat analysis use  runThreatAnalysis.
	 * 
	 * @param target the filename of the model
	 * @return the ResourceSet with the model.
	 */
	public static ResourceSet loadModel(String target) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(System.getProperty("user.dir") + "/" + target);
		Resource resource = resourceSet.getResource(fileURI, true);
		try {
			resource.load(null);
		} catch (IOException e1) {
			logger.error("Error loading resource: {}", e1.getMessage());
		}
		EcoreUtil.resolveAll(resource);

		DFDModel m = resource.getContents().stream().filter(DFDModel.class::isInstance).map(DFDModel.class::cast)
				.findAny().orElse(null);
		logger.debug("Loaded DFD Model: {}", m == null ? "" : m.getName());

		resourceSet.getAllContents().forEachRemaining(el -> {
			if (el instanceof ThreatType)
				logger.trace("Active Threat Type: {}", ((ThreatType) el).getName());
		});
		resourceSet.getAllContents().forEachRemaining(el -> {
			if (el instanceof ThreatSpecification)
				logger.trace("Active Threat Type Specification: {}", ((ThreatSpecification) el).getName());
		});
		return resourceSet;
	}

	/**
	 * Register the exporter with this cli processor. Its options will be taken into account.
	 * @param exporter the exporter to register
	 */
	private void registerExporter(Exporter exporter) {
		logger.debug("Registering exporter: {}", exporter.getClass().getSimpleName());
		Arrays.stream(exporter.getOptions()).forEach(options::addOption);
	}
	/**
	 * Register a generic command with this cli processor. Its options will be taken into account.
	 * @param genCmd the {@link GenericCliCmd} to register
	 */
	public void registerGeneric(GenericCliCmd genCmd) {
		logger.debug("Registering generic: {}", genCmd.getClass().getSimpleName());
		Arrays.stream(genCmd.getOptions()).forEach(options::addOption);

	}

	/**
	 * Setup VIATRA for running it outside of an eclipse instance.
	 */
	public static void setupVIATRAStandalone() {
		// register ecore
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ReteBackendFactory.INSTANCE.getClass();
		ViatraQueryEngineOptions.setSystemDefaultBackends(ReteBackendFactory.INSTANCE, ReteBackendFactory.INSTANCE, LocalSearchEMFBackendFactory.INSTANCE);
		logger.info("LS: {}", new LocalSearchBackendFactoryProvider().isSystemDefaultEngine());
		logger.info("Rete: {}", new ReteBackendFactoryProvider().isSystemDefaultEngine());
	}

	/**
	 * Setup EMF for running it outside of an eclipse instance.
	 */
	public static void setupEMFStandalone() {
		// trigger package registration
		logger.debug("Securitydfd package registration");
		SpartaModelPackage.eINSTANCE.eClass();

		logger.debug("Registering XMI resource factory");
		// Register resource factory
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("securitydfd", new SpartaModelResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("sparta", new SpartaModelResourceFactoryImpl());

	}


	@Override
	public Options getOptions() {
		return options;
	}

}
