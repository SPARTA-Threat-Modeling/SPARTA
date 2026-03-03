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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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


	private static final NumberFormat CF = DecimalFormat.getInstance(Locale.forLanguageTag("nl-BE"));
	private static final NumberFormat RF = DecimalFormat.getInstance();

	public PatternThreat(IPatternMatch x, ThreatPatternMatchMetadata meta) {
		super(x, new SpartaRiskModel());
		nf.setMaximumFractionDigits(2);
		this.metadata = meta;
		this.conversion = new ThreatPatternConversion(meta.getThreatPattern(), x);
		setupBindings();
		CF.setGroupingUsed(true);
		CF.setMaximumFractionDigits(2);
		RF.setGroupingUsed(false);
		RF.setMaximumFractionDigits(4);
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

		String type = "";
        type += dataFlow.getSender().getClass().getSimpleName().substring(0,dataFlow.getSender().getClass().getSimpleName().length()-4).replaceAll("[^A-Z]", "");
        type += dataFlow.getSender().equals(threatenedElement) ? "*" : "";
        type += "-DF" + (dataFlow.equals(threatenedElement) ? "*" : "") + "->";
        type += dataFlow.getRecipient().getClass().getSimpleName().substring(0,dataFlow.getRecipient().getClass().getSimpleName().length()-4).replaceAll("[^A-Z]", "");
        type += dataFlow.getRecipient().equals(threatenedElement) ? "*" : "";
        matchType = type;
		
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
