/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.model;

import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.SpartaRiskModel;
import be.kuleuven.cs.distrinet.sparta.core.patterns.ThreatPatternConversion;
import be.kuleuven.cs.distrinet.sparta.core.patterns.ThreatPatternMatchMetadata;

/**
 * Observable threat which contains the threat data to enable automatic updating
 * in SPARTA's threat analysis views.
 * 
 * @author Laurens
 *
 */
public class PatternThreat extends Threat {


	private final ThreatPatternMatchMetadata metadata;
	private final ThreatPatternConversion conversion;


	public PatternThreat(IPatternMatch x, ThreatPatternMatchMetadata meta) {
		super(x, new SpartaRiskModel());
		nf.setMaximumFractionDigits(2);
		this.metadata = meta;
		this.conversion = new ThreatPatternConversion(meta.getThreatPattern(), x);
		setupBindings();
	}


	@Override
	public String getDescription() {
		String description = conversion.getDescription();
		if (description == null) {
			return "Description missing.";
		}
		return description;
	}
	
	public String getFullDescription() {
		String description = conversion.getDescription();
		String longDescription = conversion.getLongDescription();
		if (description == null && longDescription == null) {
			return "Description missing.";
		} else if (description == null) {
			return longDescription;
		} else if ( longDescription == null ){
			return description;
		}
		return "Type: " + getThreatTypeName() + "\n" +
				"Threat: " + getThreatName() + "\n" +
				"Description: " + description + "\n" +
				"Risk: " + this.getRisk() + "\n" +
				"Vulnerability: " + this.getVulnerability() + "\n" +
				"Single Loss Event: " + this.getSle() + "\n" +
				"\n" + 
				"Info: " +	longDescription;
	}

	private void setupBindings() {
		threatType = metadata.getThreatType();
		threatenedElement = conversion.getThreatLocation();
		dataFlow = conversion.getDataFlow();

		if (dataFlow == null) {
			// Element-based match (pattern without a data flow parameter, e.g.
			// STRIDE-per-element catalogs): label with the threatened element only.
			matchType = threatenedElement != null ? typeAbbreviation(threatenedElement) + "*" : "";
			return;
		}

		String type = "";
		type += typeAbbreviation(dataFlow.getSender());
		type += dataFlow.getSender() != null && dataFlow.getSender().equals(threatenedElement) ? "*" : "";
		type += "-DF" + (dataFlow.equals(threatenedElement) ? "*" : "") + "->";
		type += typeAbbreviation(dataFlow.getRecipient());
		type += dataFlow.getRecipient() != null && dataFlow.getRecipient().equals(threatenedElement) ? "*" : "";
		matchType = type;
	}

	/**
	 * Abbreviated element type for match-type labels, e.g. ProcessImpl -> "P",
	 * DataStoreImpl -> "DS", ExternalEntityImpl -> "EE". Null-safe ("?" for
	 * unresolved references).
	 */
	private static String typeAbbreviation(Object element) {
		if (element == null) {
			return "?";
		}
		String name = element.getClass().getSimpleName();
		if (name.endsWith("Impl")) {
			name = name.substring(0, name.length() - 4);
		}
		return name.replaceAll("[^A-Z]", "");
	}


	@Override
	public String getThreatName() {
		return conversion.processAndReplaceParams(metadata.getThreatType().getName());
	}

	@Override
	public String getThreatTypeName() {
		return conversion.processAndReplaceParams(metadata.getThreatAncestor().getName());
	}

}
