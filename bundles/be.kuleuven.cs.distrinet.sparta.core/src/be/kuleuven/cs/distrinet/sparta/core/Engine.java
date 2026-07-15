/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.viatra.query.patternlanguage.emf.util.PatternParsingResults;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactoryProvider;

import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
import be.kuleuven.cs.distrinet.sparta.core.model.PatternThreat;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.core.patterns.PatternProcessor;
import be.kuleuven.cs.distrinet.sparta.core.patterns.ThreatPatternMatchMetadata;

/**
 * This is the core SPARTA Threat Elicitation Engine.
 * It uses the {@link ViatraQueryEngine} internally to elicit threats in an eclipse emf model.
 * @author Laurens
 */
public class Engine implements AutoCloseable {

	private final AdvancedViatraQueryEngine vqe;

	/**
	 * The risk-assessment loop configuration owned by this engine. Kept per-engine
	 * (rather than a global singleton) so that analyses of different models do not
	 * corrupt each other's loop parameters.
	 */
	private final RiskAssessmentLoopConfiguration loopConfiguration = new RiskAssessmentLoopConfiguration();

	
	/**
	 * Construct a new SPARTA threat elicitation engine for the given resource set.
	 * Make sure the resource set contains information on the threat types to elicit;
	 * otherwise, the elicitation engine will not have any threats to find.
	 * 
	 * @param resource - the resource set to analyze for threats
	 */
	public Engine(ResourceSet resource) {
		// create an *unmanaged* engine to ensure that no one else is going
		// to use our engine
		
		// local search does not work from command line when run outside eclipse
		ViatraQueryEngineOptions options = ViatraQueryEngineOptions.
				defineOptions().
		                withDefaultBackend((new ReteBackendFactoryProvider()).getFactory()). // this line is needed in 1.4 due to bug 507777
				build();
		vqe = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(resource),options);

		// Initializing Xtext-based resource parser
		// Do not use if VIATRA Query tooling is loaded!
		EMFPatternLanguageStandaloneSetup.doSetup();
	}
	
	public Engine(EMFScope scope) {
		// create an *unmanaged* engine to ensure that no one else is going
		// to use our engine
		
		// local search does not work from command line when run outside eclipse
		ViatraQueryEngineOptions options = ViatraQueryEngineOptions.
				defineOptions().
		                withDefaultBackend((new ReteBackendFactoryProvider()).getFactory()). // this line is needed in 1.4 due to bug 507777
				build();
		vqe = AdvancedViatraQueryEngine.createUnmanagedEngine(scope,options);

		// Initializing Xtext-based resource parser
		// Do not use if VIATRA Query tooling is loaded!
		EMFPatternLanguageStandaloneSetup.doSetup();
	}
	
	/**
	 * Get the default set of viatra query engine pattern matchers.
	 * @return List of functions to apply on the engine to obtain the querymatchers.
	 */
	public List<Function<ViatraQueryEngine, ViatraQueryMatcher<? extends IPatternMatch>>> getPatternMatchers() {
		List<Function<ViatraQueryEngine,ViatraQueryMatcher<? extends IPatternMatch>>> ms = new ArrayList<>();
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.FlowComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ProcessToProcessComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ProcessToExternalEntityComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ProcessToDataStoreComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.DataStoreToProcessComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.DataStoreToDataStoreComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.DataStoreToExternalEntityComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ExternalEntityToProcessComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ExternalEntityToDataStoreComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ExternalEntityToExternalEntityComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.FlowThroughComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ProcessThroughProcessComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ProcessThroughExternalEntityComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ProcessThroughDataStoreComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.DataStoreThroughProcessComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.DataStoreThroughDataStoreComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.DataStoreThroughExternalEntityComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ExternalEntityThroughProcessComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ExternalEntityThroughDataStoreComm.Matcher::on);
	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.ExternalEntityThroughExternalEntityComm.Matcher::on);
//	    ms.add(be.kuleuven.cs.distrinet.sparta.queries.FlowThroughElementComm.Matcher::on);
		return ms;
	}
	
	
	/**
	 * Run the analysis with the default set of pattern matchers and the ones obtained from catalogs in the ResourceSet with which the Engine was initialized.
	 * @return The list of threats found in the model provided to the engine.
	 */
	public List<Threat> runAnalysis(ResourceSet rs) {
		// Custom patterns in the ResourceSet
		Map<ThreatPatternMatchMetadata,PatternParsingResults> parseResults = new PatternProcessor(this).parsePatterns(rs);
		List<Threat> threats = runAnalysis(parseResults);

		// Default patterns
		threats.addAll(runAnalysis(getPatternMatchers()));

		// Risk
		loopConfiguration.setUpLoopParameters(this);
		threats.forEach(t -> t.performRiskCalculation(loopConfiguration));

		return threats;
	}

	/**
	 * Run the threat analysis using a custom set of pattern matchers.
	 * Each of the functions will be applied on the query engine to obtain the pattern matchers.
	 * The resulting pattern matches will be converted into {@link Threat}s provided in the results.
	 * @param matchers the pattern matchers to apply on the viatra query engine. These are actually functions that, when applied on a ViatraQueryEngine, return a ViatraQueryMatcher.
	 * @return The resulting list of {@link Threat}s found in the provided model.
	 */
	public List<Threat> runAnalysis(List<Function<ViatraQueryEngine,ViatraQueryMatcher<? extends IPatternMatch>>> matchers) {
		loopConfiguration.setUpLoopParameters(this);
		final ArrayList<Threat> threats = new ArrayList<>();
		matchers.stream().map(f -> f.apply(vqe))
		.forEach(vqm -> {
			vqm.streamAllMatches().map(Threat::new).forEach(threats::add);

		}); 
		threats.forEach(t -> t.performRiskCalculation(loopConfiguration));
		return threats;
	}
	
	/**
	 * Run the threat analysis using a custom set of parsed patterns.
	 * Matchers are extracted from the parsed patterns and applied on the query engine to obtain the pattern matches
	 * The resulting pattern matches will be converted into {@link Threat}s provided in the results.
	 * @param parseResults The collection of parsed patterns.
	 * @return The resulting list of {@link Threat}s found in the provided model.
	 */
	public List<Threat> runAnalysis(Map<ThreatPatternMatchMetadata,PatternParsingResults> parseResults) {

		List<Threat> threats = new ArrayList<>();

		for (Entry<ThreatPatternMatchMetadata,PatternParsingResults> entry : parseResults.entrySet()) {
			StreamSupport.stream(entry.getValue().getQuerySpecifications().spliterator(),false)
				.map(qs -> getVQMatchers(qs))
				.filter(vqm -> vqm != null)
				.forEach(vqm -> {
					threats.addAll(vqm.getAllMatches().stream().map(x -> new PatternThreat(x, entry.getKey())).collect(Collectors.toSet()));
				});
		}
		return threats;
	}

	private ViatraQueryMatcher<? extends IPatternMatch> getVQMatchers(IQuerySpecification<?> qs) {
		try {
			return getVQMatcherOnEngine(qs::getMatcher);
		} catch (ViatraQueryException e) {
			return null;
		}
	}

	public void dispose() {
		vqe.dispose();

	}

	/**
	 * @return the risk-assessment loop configuration owned by this engine. Callers
	 *         that drive the risk calculation outside {@link #runAnalysis(ResourceSet)}
	 *         (e.g. the UI's observable-threat conversion) must populate it via
	 *         {@link RiskAssessmentLoopConfiguration#setUpLoopParameters(Engine)} and
	 *         pass it to each threat's {@code performRiskCalculation}.
	 */
	public RiskAssessmentLoopConfiguration getLoopConfiguration() {
		return loopConfiguration;
	}

	/**
	 * Dispose the underlying VIATRA query engine. Allows the engine to be used with
	 * try-with-resources; equivalent to {@link #dispose()}.
	 */
	@Override
	public void close() {
		dispose();
	}
	@Deprecated
	public ViatraQueryEngine getQueryEngine() {
		return vqe;
	}
	
	public ViatraQueryMatcher<?> getVQMatcherOnEngine(Function<ViatraQueryEngine, ViatraQueryMatcher<?>> func) {
		return func.apply(vqe);
	}
	
	public <T extends BasePatternMatch, E extends BaseMatcher<T>> E getMatcherOnEngine(Function<ViatraQueryEngine, BaseMatcher<T>> func) {
		return (E) func.apply(vqe);
	}

}
