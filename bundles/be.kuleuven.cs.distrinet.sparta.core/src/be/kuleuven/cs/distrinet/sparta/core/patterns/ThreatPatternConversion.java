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

import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern;

public class ThreatPatternConversion {

	private final ThreatPattern meta;
	private final IPatternMatch match;
	
	private static final Pattern p = Pattern.compile("<\\$(\\w+)(\\.*(\\w+))*\\$>");
	
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
		try {
			Matcher m = p.matcher(src);
			return m.replaceAll(this::processMatch);
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	protected String processMatch(MatchResult mr) {
		if (mr.group(3) != null) {
			return getProperty(mr);
		} else {
			return ((ModelElement)match.get(mr.group(1))).getName();
		}
	}
	
	protected String getProperty(MatchResult mr) {
		if ("type".equalsIgnoreCase(mr.group(3))) {
			ModelElement el = ((ModelElement)match.get(mr.group(1)));
			String n = el.getClass().getSimpleName();
			return n.substring(0,n.length() - 4);
		} else {
			return "UNSUPPORTED ATTRIBUTE";
		}
	}
	
	protected <T> T getElementFromMatch(Class<? extends T> clz, String name) {
		Object el = match.get(name);
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

