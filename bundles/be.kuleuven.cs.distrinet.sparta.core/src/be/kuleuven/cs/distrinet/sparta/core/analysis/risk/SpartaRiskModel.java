/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.analysis.risk;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import be.kuleuven.cs.distrinet.sparta.core.analysis.BetaPERT;
import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskCalculation;
import be.kuleuven.cs.distrinet.sparta.core.analysis.StatsUtil;
import be.kuleuven.cs.distrinet.sparta.core.model.CustomEstimate;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * The Sparta Risk model.
 * 
 * @author Laurens
 *
 */
public class SpartaRiskModel implements IRiskModel {

	private static final int DEFAULT_SAMPLES = 1000;

	protected double[][][][] riskMatrix;
	protected double[][][][] sleMatrix;
	protected double[][][][] potRiskMatrix;
	protected double[][][][] vulnMatrix;
	protected double[][][][] lefMatrix;
	protected double[][][][] tefMatrix;
	protected double[][][] applicabilityMatrix;

	protected double[] vulnerability;
	protected double[] risk;
	protected double potentialRisk;

	protected double[] sle;
	protected double[] tef;
	protected double[] lef;

	public void calculateRisk(Threat threat) {
		calculateRisk(threat, DEFAULT_SAMPLES);
	}

	public void calculateRisk(Threat threat, int samples) {

		DFDElement threatenedElement = threat.getThreatenedElement();
		List<RoleBinding> countermeasureBindings = threatenedElement.getBound();
		DataFlow dataFlow = threat.getDataFlow();
		ThreatType threatType = threat.getThreatType();

		/*
		 * Overall formula LEF x LM LEF = TEF x vuln TEF = CF x ProbAct CF ~
		 * AttackerType ProbAct ~ AttackerType, ThreatType LM expected valuation
		 */
		// build up matrix for the different loops

		// SC (outside this instance), TT (instantiated), AP DST DT

		RiskAssessmentLoopConfiguration ralc = RiskAssessmentLoopConfiguration.getInstance();

		AttackerProfile[] aps = ralc.getAttackerProfiles().toArray(new AttackerProfile[] {});
		DataSubjectType[] dsts = ralc.getDataSubjectTypes().toArray(new DataSubjectType[] {});
		PersonalDataType[] pdts = ralc.getPersonalDataTypes().toArray(new PersonalDataType[] {});
		Map<DFDElement, Set<PersonalDataType>> correspondences = ralc.getDfdDataTypes();

		// final dimension is 3: lower, expected, and upper

		int matDsts = dsts.length + 1;
		int matPdts = pdts.length + 1;

		riskMatrix = new double[aps.length][matDsts][matPdts][3];
		sleMatrix = new double[aps.length][matDsts][matPdts][3];
		potRiskMatrix = new double[aps.length][matDsts][matPdts][3];
		vulnMatrix = new double[aps.length][matDsts][matPdts][3];
		lefMatrix = new double[aps.length][matDsts][matPdts][3];
		tefMatrix = new double[aps.length][matDsts][matPdts][3];
		applicabilityMatrix = new double[aps.length][matDsts][matPdts];

		for (int ap = 0; ap < aps.length; ap++) {

			for (int dst = 0; dst < dsts.length; dst++) {

				for (int pdt = 0; pdt < pdts.length; pdt++) {
					// only try to calculate risk, when the personal data of the considered type is
					// present at the dfd element
					if (correspondences.containsKey(threatenedElement)
							&& correspondences.get(threatenedElement).contains(pdts[pdt])
							&& dsts[dst].getPersonaldatatype() != null && dsts[dst].getPersonaldatatype().contains(pdts[pdt]))
						calculateRisk(threatenedElement, dataFlow, threatType, countermeasureBindings, aps[ap], dsts[dst],
								pdts[pdt], ap, dst, pdt, samples);
					else
						riskMatrix[ap][dst][pdt] = new double[] { 0, 0, 0 };

				}

			}
			calculateRisk(threatenedElement, dataFlow, threatType, countermeasureBindings, aps[ap], null, null, ap, dsts.length,
					pdts.length, samples);

		}

		this.risk = RiskCalculation.aggregateMatrix(riskMatrix);

		// pot
		double[] pot = RiskCalculation.aggregateMatrix(potRiskMatrix);
		this.potentialRisk = (pot[1]);
		// vuln
		vulnerability = RiskCalculation.aggregateAvgMatrix(vulnMatrix,applicabilityMatrix);
		// sle
		sle = RiskCalculation.aggregateMatrix(sleMatrix);
		lef = RiskCalculation.aggregateAvgMatrix(lefMatrix,applicabilityMatrix);

		// TEF depends only on (threat type, attacker profile): within one attacker every
		// data-subject/data-type cell holds the same value, so summing all cells would
		// over-count it. Instead sum one TEF per attacker profile (that attacker's
		// unconditional asset-impact cell). Combining more attackers must raise the total
		// threat event frequency, so we sum across attackers rather than averaging - which
		// would wash out attackers with very different frequencies. (Fixes the previous bug
		// where this.tef kept only the last cell's value.)
		double[] tefTotal = new double[3];
		for (int ap = 0; ap < aps.length; ap++) {
			double[] attackerTef = tefMatrix[ap][dsts.length][pdts.length];
			tefTotal[0] += attackerTef[0];
			tefTotal[1] += attackerTef[1];
			tefTotal[2] += attackerTef[2];
		}
		this.tef = tefTotal;
	}

	private void calculateRisk(DFDElement threatenedElement, DataFlow flow, ThreatType tt,
			List<RoleBinding> countermeasureBindings, AttackerProfile attackerProfile, DataSubjectType dataSubjectType,
			PersonalDataType personalDataType, int apIdx, int dstIdx, int pdtIdx, int samples) {
		/*
		 * Overall formula LEF x LM LEF = TEF x vuln TEF = CF x ProbAct CF ~
		 * AttackerType ProbAct ~ AttackerType, ThreatType LM expected valuation
		 */

		double[] lefInterval = new double[3];

		double[] tefSamples = RiskCalculation.calculateTefArray(tt, attackerProfile, samples);
		double[] tefInterval = RiskCalculation.calculateBoundaries(tefSamples);

		tefMatrix[apIdx][dstIdx][pdtIdx] = tefInterval;

		double[] vulnerability = RiskCalculation.calculateVulnerabilityArray(threatenedElement, flow, tt,
				countermeasureBindings, attackerProfile, samples);
		double[] vulnerabilityConfidenceInterval = RiskCalculation
				.calculateVulnerabilityConfidenceInterval(vulnerability);
		vulnMatrix[apIdx][dstIdx][pdtIdx] = vulnerabilityConfidenceInterval;


		lefInterval = StatsUtil.ebeMult(tefInterval, vulnerabilityConfidenceInterval);

		double[] valuation = null;

		if (personalDataType != null && dataSubjectType != null) {
			// calculate probable loss magnitude
			// PV = DTS x NR x RP x DST x NDS

			double[] dts = RiskCalculation.getSamplesFromNullableZero(personalDataType.getSensitivity(), samples);

			double[] nr = RiskCalculation.getSamplesFromNullableNeutral(personalDataType.getNbrOfRecords(), samples);

			double[] rp = RiskCalculation.getSamplesFromNullableNeutral(personalDataType.getRetention(), samples);

			double[] dst = RiskCalculation.getSamplesFromNullableZero(dataSubjectType.getSensitivity(), samples);

			double[] nds = RiskCalculation.getSamplesFromNullableNeutral(dataSubjectType.getNbrOfSubjects(), samples);

			valuation = Arrays.asList(dts, nr, rp, dst, nds).stream().reduce(RiskCalculation.identity(samples), StatsUtil::ebeMult);
		} else {
			
			Estimate e = threatenedElement.getEstimate(tt);
			
			if ( e != null) {
				valuation = (new BetaPERT(e)).sample(samples);
			} else {
				// no applicable estimate on element itself - check data types
				Set<Estimate> dtEstimates = threatenedElement.getDfdelementannotation().stream()
						.filter(x -> x instanceof DataType).map(x -> (DataType) x)
						.map(dt -> dt.getEstimate(tt))
						.filter(Objects::nonNull)
						.collect(Collectors.toSet());
				
				// if multiple applicable data types / estimates, sum of valuations
				if (!dtEstimates.isEmpty()) {
					for (Estimate dte: dtEstimates ) {
						double[] dtValuation = (new BetaPERT(dte)).sample(samples);
						valuation = sumValuations(valuation, dtValuation);
					}
				}
			}
			
			if (valuation == null) {
				// no relevant estimates found: assign default estimate
				e = new CustomEstimate(0, 0, 1, 0);
				valuation = (new BetaPERT(e)).sample(samples);
			}
		}

		double[] expectedValuation = new double[] { StatsUtil.min(valuation), StatsUtil.median(valuation),
				StatsUtil.max(valuation) };

		sleMatrix[apIdx][dstIdx][pdtIdx] = expectedValuation;
		potRiskMatrix[apIdx][dstIdx][pdtIdx] = StatsUtil.ebeMult(tefInterval, expectedValuation);
		lefMatrix[apIdx][dstIdx][pdtIdx] = lefInterval;

		riskMatrix[apIdx][dstIdx][pdtIdx] = new double[] { lefInterval[0] * expectedValuation[0],
				lefInterval[1] * expectedValuation[1], lefInterval[2] * expectedValuation[2] };

		// since this method is only called when the personal data of the considered
		// type is present at the dfd element
		// keep track of it in a separate matrix to assist in later aggregations
		// this also holds for the final dst/pdt index to collect the asset value impact
		applicabilityMatrix[apIdx][dstIdx][pdtIdx] = 1;
	}
	
	private double[] sumValuations(double[] a, double[] b) {
		// (may be null if both a and b are null)
		if (a == null) return b;
		if (b == null) return a;
		
		double[] result = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] + b[i];
		}
		return result;
	}

	@Override
	public double[] getVulnerability() {
		return this.vulnerability;
	}

	@Override
	public double[] getRisk() {
		return this.risk;
	}

	@Override
	public double getPotentialRisk() {
		return potentialRisk;
	}

	@Override
	public double[] getSle() {
		return sle;
	}

	@Override
	public double[] getTef() {
		return tef;
	}

	@Override
	public double[] getLef() {
		return lef;
	}

}
