/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.cli.runtime;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.viatra.query.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchBackendFactoryProvider;
import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchEMFBackendFactory;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactoryProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.cli.PathResolver;
import be.kuleuven.cs.distrinet.sparta.core.Engine;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.util.SpartaModelResourceFactoryImpl;

/**
 * Shared standalone (non-OSGi) SPARTA runtime. Bootstraps EMF and VIATRA outside of an
 * Eclipse instance, loads SPARTA models and runs the threat analysis. Both the CLI
 * ({@code SpartaCli}) and the CI runner ({@code SpartaCi}) use this one implementation
 * instead of reaching into each other's command-line plumbing.
 *
 * @author Laurens
 *
 */
public final class StandaloneRuntime {

	private static final Logger logger = LoggerFactory.getLogger(StandaloneRuntime.class);

	private StandaloneRuntime() {
		// utility class, no instances
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
		// secondary/generated model extension
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("spartamodel", new SpartaModelResourceFactoryImpl());
		// generic XMI fallback so unknown extensions (e.g. .xmi) still load
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().putIfAbsent("*", new XMIResourceFactoryImpl());

	}

	/**
	 * Setup VIATRA for running it outside of an eclipse instance.
	 */
	public static void setupVIATRAStandalone() {
		// register ecore
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		// Register the VIATRA pattern-language grammar, its EPackages and .vql resource
		// factory in the global EMF registry. Outside OSGi this is not done by the plugin
		// registry, so without it the pattern parser fails to resolve the PatternLanguage
		// EPackage ("Unresolved proxy ...PatternModel") when PatternProcessor is built.
		EMFPatternLanguageStandaloneSetup.doSetup();
		ViatraQueryEngineOptions.setSystemDefaultBackends(ReteBackendFactory.INSTANCE, ReteBackendFactory.INSTANCE, LocalSearchEMFBackendFactory.INSTANCE);
		logger.info("LS: {}", new LocalSearchBackendFactoryProvider().isSystemDefaultEngine());
		logger.info("Rete: {}", new ReteBackendFactoryProvider().isSystemDefaultEngine());
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
		URI fileURI = PathResolver.toFileURI(System.getProperty("user.dir"), target);
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
	 * Run a threat analysis on user-specified model. The model file is retrieved from the cli arguments.
	 * @param target the model
	 * @return the resulting list of threats
	 */
	public static List<Threat> runThreatAnalysis(String target) {
		return runThreatAnalysis(loadModel(target));
	}

	/**
	 * Run a threat analysis on an already-loaded model. Reusing a
	 * {@link ResourceSet} avoids parsing the same model more than once.
	 *
	 * @param resourceSet the resource set containing the loaded model
	 * @return the resulting list of threats
	 */
	public static List<Threat> runThreatAnalysis(ResourceSet resourceSet) {
		logger.info("Running SPARTA Analysis ...");
		logger.debug("Cwd: {}", System.getProperty("user.dir"));

		Engine e = new Engine(resourceSet);

		List<Threat> results = e.runAnalysis(resourceSet);

		results.stream().map(Threat::toString).forEach(t -> logger.debug("Threat: {}", t));

		return results;
	}
}
