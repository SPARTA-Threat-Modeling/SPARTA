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
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.swt.widgets.Display;
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
 * <p>Threading model: all {@link WritableValue}s are explicitly bound to the
 * SWT display realm (rather than the constructing thread's default realm,
 * which only exists on the display thread), so instances can be constructed
 * on any thread. In the normal flow the ThreatAnalysisService builds its
 * databinding graph on the UI thread, so conversion - and therefore
 * construction and the initial value population - happens on the realm; VIATRA
 * may however deliver later match updates on other threads, so every value
 * mutation goes through {@link #setOnRealm(WritableValue, Object)}, which
 * applies it directly when on the realm and via {@code Realm.asyncExec}
 * otherwise. Getters are meant for the UI thread (JFace bindings and label
 * providers).
 *
 * <p>Because off-realm mutations are queued while on-realm ones apply
 * immediately, a value written from both sides could otherwise be overwritten
 * by an older queued write. The risk figures of one
 * {@link #performRiskCalculation risk calculation} are therefore published
 * together, and a queued publication is dropped once a newer calculation has
 * been published.
 *
 * @author Laurens
 *
 */
public class ObservableThreat extends Threat {

	protected WritableValue<String> threatenedElementName = new WritableValue<String>(uiRealm(), null, null);
	protected WritableValue<String> threatName = new WritableValue<String>(uiRealm(), null, null);
	protected WritableValue<String> threatTypeName = new WritableValue<String>(uiRealm(), null, null);
	protected WritableValue<String> flowName = new WritableValue<String>(uiRealm(), null, null);
	protected WritableValue<String> message = new WritableValue<String>(uiRealm(), null, null);

	protected WritableValue<Double> vulnerability = new WritableValue<Double>(uiRealm(), 0d, null);
	protected WritableValue<Double> vulnerability_lower = new WritableValue<Double>(uiRealm(), 0d, null);
	protected WritableValue<Double> vulnerability_upper = new WritableValue<Double>(uiRealm(), 0d, null);
	protected WritableValue<Double> risk = new WritableValue<Double>(uiRealm(), 0d, null);
	protected WritableValue<Double> risk_lower = new WritableValue<Double>(uiRealm(), 0d, null);
	protected WritableValue<Double> risk_upper = new WritableValue<Double>(uiRealm(), 0d, null);
	protected WritableValue<Double> potentialRisk = new WritableValue<Double>(uiRealm(), 0d, null);

	protected WritableValue<Double> sle = new WritableValue<Double>(uiRealm(), 0d, null);
	protected WritableValue<Double> tef = new WritableValue<Double>(uiRealm(), 0d, null);
	protected WritableValue<Double> lef = new WritableValue<Double>(uiRealm(), 0d, null);

	/** The display realm, looked up once (the workbench has a single display). */
	private static volatile Realm cachedUiRealm;

	/**
	 * @return the realm of the SWT display thread, on which all values live. Note that
	 *         {@link Display#getDefault()} creates a display bound to the calling thread if none
	 *         exists yet, so instances must not be created before the workbench display (e.g. in
	 *         headless code).
	 */
	private static Realm uiRealm() {
		Realm realm = cachedUiRealm;
		if (realm == null) {
			realm = DisplayRealm.getRealm(Display.getDefault());
			cachedUiRealm = realm;
		}
		return realm;
	}

	/** Incremented per risk calculation; see {@link #performRiskCalculation}. */
	private final AtomicLong riskGeneration = new AtomicLong();

	/**
	 * Apply a value mutation on the observable's realm: directly when already
	 * running on it, asynchronously otherwise (e.g. VIATRA delivering a match
	 * update on a non-UI thread). Off-realm callers get eventual consistency;
	 * the realm serialises all mutations and change notifications.
	 */
	protected static <T> void setOnRealm(WritableValue<T> observable, T value) {
		Realm realm = observable.getRealm();
		if (realm.isCurrent()) {
			observable.setValue(value);
		} else {
			realm.asyncExec(() -> {
				if (!observable.isDisposed()) {
					observable.setValue(value);
				}
			});
		}
	}

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
		// The numeric values start at 0d via their field initialisers, so no
		// realm-bound setValue calls are needed here.
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
		setOnRealm(threatName, threat);
	}

	public void setThreatTypeName(String threat) {
		setOnRealm(threatTypeName, threat);
	}
	
	public String getFlow() {
		return flowName.getValue();
	}

	public void setFlow(String flow) {
		setOnRealm(flowName, flow);
	}

	public String getMessage() {
		return message.getValue();
	}

	public void setMessage(String message) {
		setOnRealm(this.message, message);
	}

	public String getVulnerabilityString() {
		return formatRisk(vulnerability.getValue());
	}

	public void setVulnerability(double vulnerability) {
		setOnRealm(this.vulnerability, vulnerability);
	}

	public String getVulnerability_lowerString() {
		return formatRisk(vulnerability_lower.getValue());
	}

	public void setVulnerability_lower(double vulnerability_lower) {
		setOnRealm(this.vulnerability_lower, vulnerability_lower);
	}

	public String getVulnerability_upperString() {
		return formatRisk(vulnerability_upper.getValue());
	}

	public void setVulnerability_upper(double vulnerability_upper) {
		setOnRealm(this.vulnerability_upper, vulnerability_upper);
	}

	public String getRiskString() {
		return formatCurrency(risk.getValue());
	}

	public void setRisk(double risk) {
		setOnRealm(this.risk, risk);
	}

	public String getPotentialRiskString() {
		return formatCurrency(potentialRisk.getValue());
	}

	public void setPotentialRisk(double risk) {
		setOnRealm(potentialRisk, risk);
	}

	public String getRisk_lowerString() {
		return formatCurrency(risk_lower.getValue());
	}

	public void setRisk_lower(double risk) {
		setOnRealm(risk_lower, risk);
	}

	public String getRisk_upperString() {
		return formatCurrency(risk_upper.getValue());
	}

	public void setRisk_upper(double risk) {
		setOnRealm(risk_upper, risk);
	}

	public String getSleString() {
		return formatCurrency(sle.getValue());
	}

	public void setSle(double sle) {
		setOnRealm(this.sle, sle);
	}

	public String getTefString() {
		return formatRisk(tef.getValue());
	}

	public void setTef(double tef) {
		setOnRealm(this.tef, tef);
	}

	public String getLefString() {
		return formatRisk(lef.getValue());
	}

	public void setLef(double lef) {
		setOnRealm(this.lef, lef);
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
		// Snapshot this calculation's figures and publish them in one realm runnable, so
		// they are applied together, and only if no newer calculation was published since
		// (an older off-realm publication may still be queued when an on-realm one runs).
		Double newRisk = super.getRisk();
		Double newRiskLower = super.getRisk_lower();
		Double newRiskUpper = super.getRisk_upper();
		Double newPotentialRisk = super.getPotentialRisk();
		Double newSle = super.getSle();
		Double newVulnerability = super.getVulnerability();
		Double newVulnerabilityLower = super.getVulnerability_lower();
		Double newVulnerabilityUpper = super.getVulnerability_upper();
		Double newLef = super.getLef();
		long generation = riskGeneration.incrementAndGet();
		Runnable publish = () -> {
			if (generation != riskGeneration.get() || risk.isDisposed()) {
				return;
			}
			risk.setValue(newRisk);
			risk_lower.setValue(newRiskLower);
			risk_upper.setValue(newRiskUpper);
			potentialRisk.setValue(newPotentialRisk);
			sle.setValue(newSle);
			vulnerability.setValue(newVulnerability);
			vulnerability_lower.setValue(newVulnerabilityLower);
			vulnerability_upper.setValue(newVulnerabilityUpper);
			lef.setValue(newLef);
		};
		Realm realm = risk.getRealm();
		if (realm.isCurrent()) {
			publish.run();
		} else {
			realm.asyncExec(publish);
		}
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
