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

import java.util.HashMap;
import java.util.HashSet;
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

	Set<ThreatTypeCatalog> processing,processed;
	
	private final Engine engine;
	private final PatternParser parser;
	
	public PatternProcessor(Engine engine) {
		this.engine = engine;
		this.parser = PatternParserBuilder.instance()
				.withLibrary(URI.createURI(PatternProcessor.class.getClassLoader().getResource("be/kuleuven/cs/distrinet/sparta/queries/DFDQueries.vql").toString(), false))
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
		
		processThreatTypeCatalogPatterns(catalog,ctxt);
	}
	
	private final Set<PatternParsingResults> helperPatterns = new HashSet<>();
	private final Map<ThreatPatternMatchMetadata,PatternParsingResults> threatPatterns = new HashMap();
	
	private void processHelperPatterns(ThreatTypeCatalog catalog, PatternProcessingContext ctxt) {
		PatternParsingResults parseResults;
		parseResults = parser.parse(ctxt.instantiatePattern(catalog.getHelperPatterns().stream().collect(Collectors.joining("\n"))));
		helperPatterns.add(parseResults);
		System.out.println(parseResults);
	}

	private void processThreatTypeCatalogPatterns(ThreatTypeCatalog catalog, PatternProcessingContext ctxt) {
		if (processed.contains(catalog))
			return;
		for (ThreatTypeCatalog dep : catalog.getPatternDependencies()) {
			if (processing.contains(dep))
				throw new IllegalArgumentException("Cyclic dependencies in threat type catalog dependencies; this is not supported.");
			processing.add(catalog);
			processThreatTypeCatalogPatterns(catalog, ctxt);
		}
		Set<ThreatType> threattypes = engine.getMatcherOnEngine(ThreatTypeCatalogThreatTypesWithNonEmptyPatterns.Matcher::on)
			.getAllMatches(ThreatTypeCatalogThreatTypesWithNonEmptyPatterns.Match.newMatch(catalog, null))
			.stream().map(ThreatTypeCatalogThreatTypesWithNonEmptyPatterns.Match::getThreatType).collect(Collectors.toSet());
		for (ThreatType t : threattypes) {
			for (ThreatPattern tp : t.getThreatpattern()) {
				PatternParsingResults parseResults = parser.parse(ctxt.instantiatePattern(tp.getPatterns().stream().collect(Collectors.joining("\n"))));
				addThreatTypePatternList(new ThreatPatternMatchMetadata(t,tp),parseResults);
			}
		}
		processed.add(catalog);
	}
	
	private void addThreatTypePatternList(ThreatPatternMatchMetadata t, PatternParsingResults patterns) {
		threatPatterns.put(t,patterns);
	}

	public Map<ThreatPatternMatchMetadata,PatternParsingResults> parsePatterns(ResourceSet resourceSet) {
		processing = new HashSet<>();
		processed = new HashSet<>();
		Set<ThreatTypeCatalog> patternCatalogs = engine.getMatcherOnEngine(IsThreatTypeCatalog.Matcher::on).getAllMatches().stream().map(IsThreatTypeCatalog.Match::getCatalog).collect(Collectors.toSet());
		for (ThreatTypeCatalog ttc: patternCatalogs) {
			processThreatTypeCatalog(ttc);
		}
		return threatPatterns;
	}
}
