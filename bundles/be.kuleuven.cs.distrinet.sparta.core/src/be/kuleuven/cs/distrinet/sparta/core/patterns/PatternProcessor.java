/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.patternlanguage.emf.util.PatternParser;
import org.eclipse.viatra.query.patternlanguage.emf.util.PatternParserBuilder;
import org.eclipse.viatra.query.patternlanguage.emf.util.PatternParsingResults;

import be.kuleuven.cs.distrinet.sparta.core.Engine;
import be.kuleuven.cs.distrinet.sparta.queries.IsThreatTypeCatalog;
import be.kuleuven.cs.distrinet.sparta.queries.ThreatTypeCatalogThreatTypesWithNonEmptyPatterns;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog;

public class PatternProcessor {

	Set<ThreatTypeCatalog> processed;
	
	private final Engine engine;
	private final PatternParser parser;
	
	private static final String VQL_LIBRARY = "be/kuleuven/cs/distrinet/sparta/queries/DFDQueries.vql";

	public PatternProcessor(Engine engine) {
		this.engine = engine;
		java.net.URL library = PatternProcessor.class.getClassLoader().getResource(VQL_LIBRARY);
		if (library == null) {
			throw new IllegalStateException("Required VQL library not found on the classpath: " + VQL_LIBRARY);
		}
		this.parser = PatternParserBuilder.instance()
				.withLibrary(URI.createURI(library.toString(), false))
				.build();
	}
	
	private static class PatternProcessingContext {
		private final String packageName;
		private final String imports;
		public PatternProcessingContext(String packageName, String imports) {
			this.packageName = packageName;
			this.imports = imports;
		}
		public String instantiatePattern(String patternBody) {
			return new StringBuilder("package ").append(packageName).append("\n")
					.append(imports).append("\n")
					.append(patternBody)
					.toString();
		}
	}
	
	private void processThreatTypeCatalog(ThreatTypeCatalog catalog) {
		PatternProcessingContext ctxt = new PatternProcessingContext(catalog.getPackage(),catalog.getImports().stream().collect(Collectors.joining("\n")));
		
		processHelperPatterns(catalog, ctxt);

		processThreatTypeCatalogPatterns(catalog);
	}
	
	private final Set<PatternParsingResults> helperPatterns = new HashSet<>();
	private final Map<ThreatPatternMatchMetadata,PatternParsingResults> threatPatterns = new HashMap<>();
	
	private void processHelperPatterns(ThreatTypeCatalog catalog, PatternProcessingContext ctxt) {
		PatternParsingResults parseResults;
		parseResults = parser.parse(ctxt.instantiatePattern(catalog.getHelperPatterns().stream().collect(Collectors.joining("\n"))));
		helperPatterns.add(parseResults);
	}

	private void processThreatTypeCatalogPatterns(ThreatTypeCatalog catalog) {
		for (ThreatTypeCatalog c : dependencyOrder(catalog, processed)) {
			PatternProcessingContext ctxt = new PatternProcessingContext(c.getPackage(),
					c.getImports().stream().collect(Collectors.joining("\n")));
			Set<ThreatType> threattypes = engine.getMatcherOnEngine(ThreatTypeCatalogThreatTypesWithNonEmptyPatterns.Matcher::on)
				.getAllMatches(ThreatTypeCatalogThreatTypesWithNonEmptyPatterns.Match.newMatch(c, null))
				.stream().map(ThreatTypeCatalogThreatTypesWithNonEmptyPatterns.Match::getThreatType).collect(Collectors.toSet());
			for (ThreatType t : threattypes) {
				for (ThreatPattern tp : t.getThreatpattern()) {
					PatternParsingResults parseResults = parser.parse(ctxt.instantiatePattern(tp.getPatterns().stream().collect(Collectors.joining("\n"))));
					addThreatTypePatternList(new ThreatPatternMatchMetadata(t,tp),parseResults);
				}
			}
			processed.add(c);
		}
	}

	/**
	 * Compute the transitive pattern-dependency closure of {@code root} in
	 * dependency-first order: every catalog appears after all catalogs it (transitively)
	 * depends on. Catalogs contained in {@code alreadyProcessed} - and their
	 * dependencies - are skipped. Cyclic dependencies are unsupported and rejected.
	 *
	 * <p>This traversal is intentionally free of engine/parser state so it can be unit
	 * tested in isolation.
	 *
	 * @param root             the catalog to start the traversal from
	 * @param alreadyProcessed catalogs already handled, to be skipped
	 * @return the catalogs to process, dependencies first, without duplicates
	 * @throws IllegalArgumentException if a dependency cycle is detected
	 */
	public static List<ThreatTypeCatalog> dependencyOrder(ThreatTypeCatalog root,
			Set<ThreatTypeCatalog> alreadyProcessed) {
		List<ThreatTypeCatalog> order = new ArrayList<>();
		visitDependencies(root, alreadyProcessed, new HashSet<>(), new LinkedHashSet<>(), order);
		return order;
	}

	private static void visitDependencies(ThreatTypeCatalog catalog, Set<ThreatTypeCatalog> alreadyProcessed,
			Set<ThreatTypeCatalog> visited, Set<ThreatTypeCatalog> onStack, List<ThreatTypeCatalog> order) {
		if (alreadyProcessed.contains(catalog) || visited.contains(catalog))
			return;
		if (!onStack.add(catalog))
			throw new IllegalArgumentException(
					"Cyclic dependencies in threat type catalog dependencies; this is not supported.");
		for (ThreatTypeCatalog dep : catalog.getPatternDependencies()) {
			visitDependencies(dep, alreadyProcessed, visited, onStack, order);
		}
		onStack.remove(catalog);
		visited.add(catalog);
		order.add(catalog);
	}
	
	private void addThreatTypePatternList(ThreatPatternMatchMetadata t, PatternParsingResults patterns) {
		threatPatterns.put(t,patterns);
	}

	public Map<ThreatPatternMatchMetadata,PatternParsingResults> parsePatterns(ResourceSet resourceSet) {
		processed = new HashSet<>();
		Set<ThreatTypeCatalog> patternCatalogs = engine.getMatcherOnEngine(IsThreatTypeCatalog.Matcher::on).getAllMatches().stream().map(IsThreatTypeCatalog.Match::getCatalog).collect(Collectors.toSet());
		for (ThreatTypeCatalog ttc: patternCatalogs) {
			processThreatTypeCatalog(ttc);
		}
		return threatPatterns;
	}
}
