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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.viatra.addon.databinding.runtime.adapter.MatcherProperties;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.IRiskModel;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Observable threat which contains the threat data to enable automatic updating
 * in SPARTA's threat analysis views.
 * 
 * @author Laurens
 *
 */
public class ObservableThreat extends Threat {

	protected WritableValue<String> threatenedElementName = new WritableValue<String>();
	protected WritableValue<String> threatName = new WritableValue<String>();
	protected WritableValue<String> threatTypeName = new WritableValue<String>();
	protected WritableValue<String> flowName = new WritableValue<String>();
	protected WritableValue<String> message = new WritableValue<String>();

	protected WritableValue<Double> vulnerability = new WritableValue<Double>();
	protected WritableValue<Double> vulnerability_lower = new WritableValue<Double>();
	protected WritableValue<Double> vulnerability_upper = new WritableValue<Double>();
	protected WritableValue<Double> risk = new WritableValue<Double>();
	protected WritableValue<Double> risk_lower = new WritableValue<Double>();
	protected WritableValue<Double> risk_upper = new WritableValue<Double>();
	protected WritableValue<Double> potentialRisk = new WritableValue<Double>();

	protected WritableValue<Double> sle = new WritableValue<Double>();
	protected WritableValue<Double> tef = new WritableValue<Double>();
	protected WritableValue<Double> lef = new WritableValue<Double>();
	protected String sender = "";
	protected String recipient = "";


	private static final NumberFormat CF = DecimalFormat.getInstance(Locale.forLanguageTag("nl-BE"));
	private static final NumberFormat RF = DecimalFormat.getInstance();

	public ObservableThreat(DataBindingContext dbc, IPatternMatch x) {
		super(x);
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
		CF.setGroupingUsed(true);
		CF.setMaximumFractionDigits(2);
		RF.setGroupingUsed(false);
		RF.setMaximumFractionDigits(4);
		processMatch();

	}

	public void processMatch() {
		DFDElement threatenedElement = (DFDElement) patternMatch.get("location");
		DataFlow flow;
		if (threatenedElement instanceof DataFlow)
			flow = (DataFlow) threatenedElement;
		else
			flow = (DataFlow) patternMatch.get("df");
		ThreatType tt = (ThreatType) patternMatch.get("t");

		DFDElement sender = flow.getSender();
		DFDElement recipient = flow.getRecipient();

		String type = "";
		type += sender.getClass().getSimpleName().substring(0, sender.getClass().getSimpleName().length() - 4)
				.replaceAll("[^A-Z]", "");
		type += sender.equals(threatenedElement) ? "*" : "";
		type += "-DF" + (flow.equals(threatenedElement) ? "*" : "") + "->";
		type += recipient.getClass().getSimpleName().substring(0, recipient.getClass().getSimpleName().length() - 4)
				.replaceAll("[^A-Z]", "");
		type += recipient.equals(threatenedElement) ? "*" : "";
		matchType = type;
		this.sender = sender.getName();
		this.recipient = recipient.getName();
	}

	public ObservableThreat(IPatternMatch fromObject) {
		super(fromObject);
	}

	protected ObservableThreat(IPatternMatch x, IRiskModel riskModel) {
		super(x,riskModel);
	}

	public String getThreat() {
		return threatName.getValue();
	}
	

	@Override
	public String getThreatName() {
		return getThreat();
	}

	
	public String getThreatTypeName() {
		return threatTypeName.getValue();
	}

	public void setThreat(String threat) {
		this.threatName.setValue(threat);
	}

	public void setThreatTypeName(String threat) {
		this.threatTypeName.setValue(threat);
	}
	
	public String getFlow() {
		return flowName.getValue();
	}

	public void setFlow(String flow) {
		this.flowName.setValue(flow);
	}

	public String getMessage() {
		return message.getValue();
	}

	public void setMessage(String message) {
		this.message.setValue(message);
	}

	public String getVulnerabilityString() {
		return RF.format(vulnerability.getValue());
	}

	public void setVulnerability(double vulnerability) {
		this.vulnerability.setValue(vulnerability);
	}

	public String getVulnerability_lowerString() {
		return RF.format(vulnerability_lower.getValue());
	}

	public void setVulnerability_lower(double vulnerability_lower) {
		this.vulnerability_lower.setValue(vulnerability_lower);
	}

	public String getVulnerability_upperString() {
		return RF.format(vulnerability_upper.getValue());
	}

	public void setVulnerability_upper(double vulnerability_upper) {
		this.vulnerability_upper.setValue(vulnerability_upper);
	}

	public String getRiskString() {
		return CF.format(risk.getValue());
	}

	public void setRisk(double risk) {
		this.risk.setValue(risk);
	}

	public String getPotentialRiskString() {
		return CF.format(potentialRisk.getValue());
	}

	public void setPotentialRisk(double risk) {
		this.potentialRisk.setValue(risk);
	}

	public String getRisk_lowerString() {
		return CF.format(risk_lower.getValue());
	}

	public void setRisk_lower(double risk) {
		this.risk_lower.setValue(risk);
	}

	public String getRisk_upperString() {
		return CF.format(risk_upper.getValue());
	}

	public void setRisk_upper(double risk) {
		this.risk_upper.setValue(risk);
	}

	public String getSleString() {
		return CF.format(sle.getValue());
	}

	public void setSle(double sle) {
		this.sle.setValue(sle);
	}

	public String getTefString() {
		return RF.format(tef.getValue());
	}

	public void setTef(double tef) {
		this.tef.setValue(tef);
	}

	public String getLefString() {
		return RF.format(lef.getValue());
	}

	public void setLef(double lef) {
		this.lef.setValue(lef);
	}

	public double getRiskAsDouble() {
		return this.risk.getValue();
	}

	public double getPotentialRiskAsDouble() {
		return this.potentialRisk.getValue();
	}

	public double getRisk_lowerAsDouble() {
		return this.risk_lower.getValue();
	}

	public double getRisk_upperAsDouble() {
		return this.risk_upper.getValue();
	}

	public double getVulnerabilityAsDouble() {
		return this.vulnerability.getValue();
	}

	public double getVulnerability_lowerAsDouble() {
		return this.vulnerability_lower.getValue();
	}

	public double getVulnerability_upperAsDouble() {
		return this.vulnerability_upper.getValue();
	}

	public double getSleAsDouble() {
		return sle.getValue();
	}

	public double getTefAsDouble() {
		return tef.getValue();
	}

	public double getLefAsDouble() {
		return lef.getValue();
	}

	public String getMatchType() {

		return matchType;
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	@SuppressWarnings("rawtypes")
	protected IObservableValue getMatchObservable(String propertyName) {
		try {
			return MatcherProperties.getObservableValue(patternMatch.specification(), patternMatch, propertyName);
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			throw npe;
		}
	}

	@SuppressWarnings("unchecked")
	private void setupBindings(DataBindingContext ctx) {
		ctx.bindValue(threatenedElementName, getMatchObservable("location"));
		if (patternMatch.get("location") instanceof DataFlow) {
			ctx.bindValue(flowName, getMatchObservable("location"));
		} else {
			ctx.bindValue(flowName, getMatchObservable("df"));
		}
		ctx.bindValue(threatName, getMatchObservable("t"));

		try {
			performRiskCalculation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void performRiskCalculation() {
		super.performRiskCalculation();
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

	private double[][][][] riskMatrix;
	private double[][][][] sleMatrix;
	private double[][][][] potRiskMatrix;
	private double[][][][] vulnMatrix;
	private double[][][][] lefMatrix;
	private double[][][] applicabilityMatrix;

	public double[][][][] getRiskMatrix() {
		return riskMatrix;
	}

	public String getDescription() {
		return "Estimated annual risk of " + getRisk() + "\n" +
				"A single loss event of " + getSle() + "\n" +
				"Frequency of loss events: " + getLef() + "\n";
	}
	public String getFullDescription() {
		return getDescription();
	}
}
