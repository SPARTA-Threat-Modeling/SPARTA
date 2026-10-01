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


import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern;

/**
 * Renders the (long) description of a {@link ThreatPattern} for a concrete
 * {@link IPatternMatch} by substituting parameter placeholders with values from
 * the match.
 *
 * <p>Placeholder syntax:
 * <ul>
 * <li>{@code <$name$>} — replaced with the name ({@link ModelElement#getName()})
 * of the match parameter called {@code name};</li>
 * <li>{@code <$name.type$>} — replaced with the model type of that parameter
 * (the element's class name without the EMF {@code Impl} suffix, e.g.
 * {@code Process}). {@code type} is the only supported attribute; any other
 * attribute renders as {@code UNSUPPORTED ATTRIBUTE}.</li>
 * </ul>
 *
 * <p>Substitution is literal: replacement values containing regex-special
 * characters such as {@code $} or {@code \} are inserted as-is. When a
 * placeholder references a parameter that is absent from the match (or that is
 * not a {@link ModelElement}), it renders as the visible marker
 * {@code <unknown: name>} instead of failing the whole conversion.
 */
public class ThreatPatternConversion {

	private final ThreatPattern meta;
	private final IPatternMatch match;
	
	// Matches <$name$> and dotted paths such as <$name.attr$>: a name followed by zero or
	// more ".word" segments. group(1) is the name; group(3) is the last (attribute) segment.
	private static final Pattern p = Pattern.compile("<\\$(\\w+)(\\.(\\w+))*\\$>");
	
	public ThreatPatternConversion(ThreatPattern meta, IPatternMatch match) {
		this.meta = meta;
		this.match = match;
	}
	

	public String getDescription() {
		return processAndReplaceParams(meta.getDescription());
		
	}
	
	public String getLongDescription() {
		return processAndReplaceParams(StreamSupport.stream(meta.getLongDescription().spliterator(), false).collect(Collectors.joining("\n")));
	}
	
	public String processAndReplaceParams(String src) {
		if (src == null) {
			return null;
		}
		Matcher m = p.matcher(src);
		// Quote each replacement so element names containing '$' or '\' are inserted
		// literally instead of being interpreted as group references by appendReplacement.
		return m.replaceAll(mr -> Matcher.quoteReplacement(processMatch(mr)));
	}

	protected String processMatch(MatchResult mr) {
		if (mr.group(3) != null) {
			return getProperty(mr);
		}
		ModelElement el = getElementFromMatch(ModelElement.class, mr.group(1));
		if (el == null || el.getName() == null) {
			return unknownMarker(mr.group(1));
		}
		return el.getName();
	}

	protected String getProperty(MatchResult mr) {
		if ("type".equalsIgnoreCase(mr.group(3))) {
			ModelElement el = getElementFromMatch(ModelElement.class, mr.group(1));
			if (el == null) {
				return unknownMarker(mr.group(1));
			}
			return Threat.simpleTypeName(el);
		} else {
			return "UNSUPPORTED ATTRIBUTE";
		}
	}

	/** Visible fallback for a placeholder whose parameter cannot be resolved from the match. */
	private static String unknownMarker(String paramName) {
		return "<unknown: " + paramName + ">";
	}

	protected <T> T getElementFromMatch(Class<? extends T> clz, String name) {
		Object el = match == null ? null : match.get(name);
		if (clz.isInstance(el))
			return clz.cast(el);
		return null;
	}
	
	public DFDElement getThreatLocation() {
		DFDElement threatened = getElementFromMatch(DFDElement.class, map("location"));
		if (threatened == null) {
			threatened = getElementFromMatch(DFDElement.class, "location");
		}
		if (threatened == null) {
			threatened = getElementFromMatch(DFDElement.class, "threatened");
		}
		return threatened;		
	}
	public DataFlow getDataFlow() {
		DataFlow df = getElementFromMatch(DataFlow.class, map("flow"));
		if (df == null) {
			df = getElementFromMatch(DataFlow.class, "flow");
		} 
		if (df == null) {
			return getElementFromMatch(DataFlow.class, "df");
		} 
		
		return df;
		
	}
	
	protected String map(String name) {
		String n = meta.getMapping().get(name);
		return n== null ? name : n;
	}


}

