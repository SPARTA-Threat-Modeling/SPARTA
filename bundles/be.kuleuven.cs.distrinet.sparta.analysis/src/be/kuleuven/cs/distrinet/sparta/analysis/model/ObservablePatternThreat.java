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
		this.risk.setValue(0d);
		this.potentialRisk.setValue(0d);
		this.risk_lower.setValue(0d);
		this.risk_upper.setValue(0d);
		this.vulnerability.setValue(0d);
		this.vulnerability_lower.setValue(0d);
		this.vulnerability_upper.setValue(0d);
		this.lef.setValue(0d);
		this.tef.setValue(0d);
		this.sle.setValue(0d);
		setupBindings(dbc);

	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	@Override
	public String getThreatenedElementName() {
		return super.getThreatenedElementName();
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
		threatenedElementName.setValue(threatenedElement.getName());
		dataFlow = conversion.getDataFlow();
		if (dataFlow != null) {
			flowName.setValue(dataFlow.getName());
		} else {
			flowName.setValue("");
		}
		try {
			performRiskCalculation(loopConfiguration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void performRiskCalculation(RiskAssessmentLoopConfiguration loopConfiguration) {
		super.performRiskCalculation(loopConfiguration);
		this.risk.setValue(super.getRisk());
		this.risk_lower.setValue(super.getRisk_lower());
		this.risk_upper.setValue(super.getRisk_upper());
		this.potentialRisk.setValue(super.getPotentialRisk());
		this.sle.setValue(super.getSle());
		this.vulnerability.setValue(super.getVulnerability());
		this.vulnerability_lower.setValue(super.getVulnerability_lower());
		this.vulnerability_upper.setValue(super.getVulnerability_upper());
		this.lef.setValue(super.getLef());
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
