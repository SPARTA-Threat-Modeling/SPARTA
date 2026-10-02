/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.model;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
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
public class ObservablePatternThreat extends ObservableThreat {


	private final ThreatPatternMatchMetadata metadata;
	private final ThreatPatternConversion conversion;

	public ObservablePatternThreat(DataBindingContext dbc, IPatternMatch x, ThreatPatternMatchMetadata meta,
			RiskAssessmentLoopConfiguration loopConfiguration) {
		super(x, new SpartaRiskModel(), loopConfiguration);
		this.metadata = meta;
		this.conversion = new ThreatPatternConversion(meta.getThreatPattern(), x);
		// The numeric values start at 0d via their field initialisers, so no
		// realm-bound setValue calls are needed here.
		setupBindings(dbc);

	}

	@Override
	public String getFlow() {
		if (dataFlow == null) {
			return "";
		}
		return dataFlow.getName();
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
				"Threat: " + getThreat() + "\n" +
				"Description: " + description + "\n" +
				"Risk: " + this.getRiskString() + "\n" +
				"Vulnerability: " + this.getVulnerabilityString() + "\n" +
				"Single Loss Event: " + this.getSleString() + "\n" +
				"\n" + 
				"Info: " +	longDescription;
	}

	private void setupBindings(DataBindingContext ctx) {
		setThreat(conversion.processAndReplaceParams(metadata.getThreatType().getName()));
		setThreatTypeName(conversion.processAndReplaceParams(metadata.getThreatAncestor().getName()));
		threatType = metadata.getThreatType();
		threatenedElement = conversion.getThreatLocation();
		setOnRealm(threatenedElementName, threatenedElement.getName());
		dataFlow = conversion.getDataFlow();
		if (dataFlow != null) {
			setOnRealm(flowName, dataFlow.getName());
		} else {
			setOnRealm(flowName, "");
		}
		try {
			performRiskCalculation(loopConfiguration);
		} catch (Exception e) {
			logRiskCalculationFailure(e);
		}
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
