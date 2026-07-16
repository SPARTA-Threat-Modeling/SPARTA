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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.viatra.addon.databinding.runtime.adapter.MatcherProperties;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import be.kuleuven.cs.distrinet.sparta.analysis.Activator;
import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.IRiskModel;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;

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
	/** Loop configuration owned by the analysing engine; used to drive the risk calculation. */
	protected RiskAssessmentLoopConfiguration loopConfiguration;
	protected String sender = "";
	protected String recipient = "";


	/** Single source of truth for the currency locale used across the analysis views. */
	public static final Locale CURRENCY_LOCALE = Locale.forLanguageTag("nl-BE");

	/**
	 * {@link NumberFormat} is not thread-safe, but threats are converted on VIATRA
	 * engine callbacks (off the UI thread) while getters are called on the UI
	 * thread. A {@link ThreadLocal}, configured once, gives every thread its own
	 * formatter instance without reconfiguring shared state per construction.
	 */
	private static final ThreadLocal<NumberFormat> CF = ThreadLocal.withInitial(() -> {
		NumberFormat nf = DecimalFormat.getInstance(CURRENCY_LOCALE);
		nf.setGroupingUsed(true);
		nf.setMaximumFractionDigits(2);
		return nf;
	});
	private static final ThreadLocal<NumberFormat> RF = ThreadLocal.withInitial(() -> {
		NumberFormat nf = DecimalFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMaximumFractionDigits(4);
		return nf;
	});

	protected static String formatCurrency(double value) {
		return CF.get().format(value);
	}

	protected static String formatRisk(double value) {
		return RF.get().format(value);
	}

	/**
	 * @return a freshly configured currency formatter (grouping, exactly two
	 *         fraction digits) using the shared {@link #CURRENCY_LOCALE}. Intended
	 *         for callers such as the analysis view header that need their own
	 *         formatter instance.
	 */
	public static NumberFormat newCurrencyFormat() {
		NumberFormat nf = DecimalFormat.getInstance(CURRENCY_LOCALE);
		nf.setGroupingUsed(true);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		return nf;
	}

	public ObservableThreat(DataBindingContext dbc, IPatternMatch x, RiskAssessmentLoopConfiguration loopConfiguration) {
		super(x);
		this.loopConfiguration = loopConfiguration;
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
		processMatch();

	}

	public void processMatch() {
		Object location = patternMatch.get("location");
		DFDElement threatenedElement = (location instanceof DFDElement) ? (DFDElement) location : null;

		DataFlow flow;
		if (threatenedElement instanceof DataFlow) {
			flow = (DataFlow) threatenedElement;
		} else {
			Object df = patternMatch.get("df");
			flow = (df instanceof DataFlow) ? (DataFlow) df : null;
		}

		if (flow == null) {
			// Element-based match (pattern without a data flow parameter): label
			// with the threatened element only, matching PatternThreat.setupBindings.
			matchType = threatenedElement != null ? typeAbbreviation(threatenedElement) + "*" : "";
			return;
		}

		DFDElement sender = flow.getSender();
		DFDElement recipient = flow.getRecipient();

		StringBuilder type = new StringBuilder();
		type.append(typeAbbreviation(sender));
		type.append(sender != null && sender.equals(threatenedElement) ? "*" : "");
		type.append("-DF").append(flow.equals(threatenedElement) ? "*" : "").append("->");
		type.append(typeAbbreviation(recipient));
		type.append(recipient != null && recipient.equals(threatenedElement) ? "*" : "");
		matchType = type.toString();

		this.sender = sender != null ? sender.getName() : "";
		this.recipient = recipient != null ? recipient.getName() : "";
	}

	protected ObservableThreat(IPatternMatch x, IRiskModel riskModel, RiskAssessmentLoopConfiguration loopConfiguration) {
		super(x,riskModel);
		this.loopConfiguration = loopConfiguration;
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
		return formatRisk(vulnerability.getValue());
	}

	public void setVulnerability(double vulnerability) {
		this.vulnerability.setValue(vulnerability);
	}

	public String getVulnerability_lowerString() {
		return formatRisk(vulnerability_lower.getValue());
	}

	public void setVulnerability_lower(double vulnerability_lower) {
		this.vulnerability_lower.setValue(vulnerability_lower);
	}

	public String getVulnerability_upperString() {
		return formatRisk(vulnerability_upper.getValue());
	}

	public void setVulnerability_upper(double vulnerability_upper) {
		this.vulnerability_upper.setValue(vulnerability_upper);
	}

	public String getRiskString() {
		return formatCurrency(risk.getValue());
	}

	public void setRisk(double risk) {
		this.risk.setValue(risk);
	}

	public String getPotentialRiskString() {
		return formatCurrency(potentialRisk.getValue());
	}

	public void setPotentialRisk(double risk) {
		this.potentialRisk.setValue(risk);
	}

	public String getRisk_lowerString() {
		return formatCurrency(risk_lower.getValue());
	}

	public void setRisk_lower(double risk) {
		this.risk_lower.setValue(risk);
	}

	public String getRisk_upperString() {
		return formatCurrency(risk_upper.getValue());
	}

	public void setRisk_upper(double risk) {
		this.risk_upper.setValue(risk);
	}

	public String getSleString() {
		return formatCurrency(sle.getValue());
	}

	public void setSle(double sle) {
		this.sle.setValue(sle);
	}

	public String getTefString() {
		return formatRisk(tef.getValue());
	}

	public void setTef(double tef) {
		this.tef.setValue(tef);
	}

	public String getLefString() {
		return formatRisk(lef.getValue());
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
		return MatcherProperties.getObservableValue(patternMatch.specification(), patternMatch, propertyName);
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
			performRiskCalculation(loopConfiguration);
		} catch (Exception e) {
			logRiskCalculationFailure(e);
		}
	}

	/** Report a risk-calculation failure to the platform log rather than stderr. */
	protected void logRiskCalculationFailure(Exception e) {
		Activator activator = Activator.getDefault();
		if (activator != null) {
			activator.getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Risk calculation failed for threat on '" + getThreatenedElementName() + "'", e));
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

	public String getDescription() {
		return "Estimated annual risk of " + getRisk() + "\n" +
				"A single loss event of " + getSle() + "\n" +
				"Frequency of loss events: " + getLef() + "\n";
	}
	public String getFullDescription() {
		return getDescription();
	}
}
