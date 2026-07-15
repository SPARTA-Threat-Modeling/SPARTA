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

import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.IRiskModel;
import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.SpartaRiskModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Class representing a security or privacy threat instance. This class requires a
 * {@link IPatternMatch} from which the required information is retrieved to
 * populate the threat's properties.
 * 
 * @author Laurens
 *
 */
public class Threat implements IThreat, IInteractionThreat {

	protected final IRiskModel riskModel;

	protected final IPatternMatch patternMatch;
	protected DFDElement threatenedElement;
	protected ThreatType threatType;
	protected String matchType;
	protected DataFlow dataFlow;
	protected String message;


	protected Threat(IPatternMatch match, IRiskModel model) {
		this.patternMatch = match;
		this.riskModel = model;
	}
	
	/**
	 * Create a new Threat instance.
	 * 
	 * @param x the {@link IPatternMatch} from which the required information is
	 *          retrieved to populate the threat's properties.
	 */
	public Threat(IPatternMatch x) {
		nf.setMaximumFractionDigits(2);
		this.patternMatch = x;
		setupBindings();
		this.riskModel = new SpartaRiskModel();
	}


	public IPatternMatch getPatternMatch() {
		return patternMatch;
	}

	public DFDElement getThreatenedElement() {
		return threatenedElement;
	}

	public ThreatType getThreatType() {
		return threatType;
	}
	
	public String getMatchType() {
		return matchType;
	}

	public DataFlow getDataFlow() {
		return dataFlow;
	}

	public ModelElement getDataFlowFrom() {
		return dataFlow != null ? dataFlow.getSender() : null;
	}

	public ModelElement getDataFlowTo() {
		return dataFlow != null ? dataFlow.getRecipient() : null;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public Double getVulnerability() {
		return riskModel.getVulnerability()[1];
	}

	public Double getVulnerability_lower() {
		return riskModel.getVulnerability()[0];
	}

	public Double getVulnerability_upper() {
		return riskModel.getVulnerability()[2];
	}

	@Override
	public Double getRisk() {
		return riskModel.getRisk()[1];
	}

	public Double getRisk_lower() {
		return riskModel.getRisk()[0];
	}

	public Double getRisk_upper() {
		return riskModel.getRisk()[2];
	}

	@Override
	public Double getPotentialRisk() {
		return riskModel.getPotentialRisk();
	}

	public Double getSle() {
		return riskModel.getSle()[1];
	}

	public Double getTef() {
		return riskModel.getTef()[1];
	}

	public Double getLef() {
		return riskModel.getLef()[1];
	}

	protected String getElementName(String propertyName) {
		Object o = patternMatch.get(propertyName);
		return "" + ((o instanceof DFDElement) ? ((DFDElement) o).getName() : "" + o);
	}

	protected ModelElement getModelElement(String propertyName) {
		Object o = patternMatch.get(propertyName);
		if (o instanceof ModelElement) {
			return (ModelElement) o;
		}
		throw new IllegalArgumentException();
	}

	protected DataFlow getDataFlowElement() {
		Object o = patternMatch.get("df");
		if (o instanceof DataFlow) {
			return (DataFlow) o;
		}
		throw new IllegalArgumentException();
	}

	protected ThreatType getThreatTypeElement() {
		Object tt = patternMatch.get("t");
		if (tt instanceof ThreatType) {
			return (ThreatType) tt;
		}
		throw new IllegalArgumentException();
	}

	private void setupBindings() {
		threatenedElement = (DFDElement) getModelElement("location");
		if (threatenedElement instanceof DataFlow) {
			dataFlow = (DataFlow) threatenedElement;
		} else {
			dataFlow = getDataFlowElement();
		}
		threatType = getThreatTypeElement();
		
        String type = "";
        type += dataFlow.getSender().getClass().getSimpleName().substring(0,dataFlow.getSender().getClass().getSimpleName().length()-4).replaceAll("[^A-Z]", "");
        type += dataFlow.getSender().equals(threatenedElement) ? "*" : "";
        type += "-DF" + (dataFlow.equals(threatenedElement) ? "*" : "") + "->";
        type += dataFlow.getRecipient().getClass().getSimpleName().substring(0,dataFlow.getRecipient().getClass().getSimpleName().length()-4).replaceAll("[^A-Z]", "");
        type += dataFlow.getRecipient().equals(threatenedElement) ? "*" : "";
        matchType = type;
	}

	/**
	 * Perform Risk calculation
	 * 
	 * Overall formula: LEF x LM
	 */
	public void performRiskCalculation(RiskAssessmentLoopConfiguration loopConfiguration) {
		if (threatenedElement == null)
			return;

		riskModel.calculateRisk(this, loopConfiguration);

	}




	

	protected final NumberFormat nf = DecimalFormat.getInstance();

	@Override
	public String toString() {
		return "" + threatType.getName() + " threat on " + threatenedElement + " with a risk of " + nf.format(getRisk())
				+ " (" + nf.format(getRisk_lower()) + "," + nf.format(getRisk_upper()) + ")";
	}


	@Override
	public String getDataFlowName() {
		return (this.getDataFlow() != null) ? this.getDataFlow().getName() : "";
	}


	@Override
	public String getDataFlowFromName() {
		return this.getDataFlowFrom() != null ? this.getDataFlowFrom().getName() : "";
	}


	@Override
	public String getDataFlowToName() {
		return this.getDataFlowTo()!= null ? this.getDataFlowTo().getName() : "";
	}


	@Override
	public String getThreatTypeName() {
		return this.getThreatType() != null ? this.getThreatType().getName() : "";
	}


	@Override
	public String getThreatenedElementName() {
		return this.getThreatenedElement() != null ? this.getThreatenedElement().getName() : "";
	}


	@Override
	public String getThreatenedElementTypeName() {
		return this.getThreatenedElement() != null ? this.getThreatenedElement().getClass().getSimpleName().substring(0, this.getThreatenedElement().getClass().getSimpleName().length()-4) : "";
	}
	
	@Override
	public String getThreatenedElementId() {
		return this.getThreatenedElement() != null ? "" + this.getThreatenedElement().hashCode() : "";
	}

	@Override
	public String getThreatName() {
		return getThreatTypeName();
	}

	@Override
	public String getDescription() {
		return toString();
	}
	

}
