/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.math3.linear.ArrayRealVector;

import be.kuleuven.cs.distrinet.sparta.core.model.CustomEstimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * RiskAssessment class containing a number of static risk calculation methods
 * to assist in performing a threat's risk calculation.
 * 
 * @author Laurens
 *
 */
public class RiskCalculation {

	// 1-alpha = confidence; significance alpha/2
	private static final double CLOPPER_PEARSON_ALPHA = 0.05;

	private RiskCalculation() {
	}

	/**
	 * Calculate the vulnerability from a (binary) vector of attack success/failures
	 * 
	 * @param vulnerability binary victor indicating an attacks success or failure
	 * @return Single vulnerability number
	 */
	public static double calculateVulnerability(double[] vulnerability) {
		return Arrays.stream(vulnerability).average().getAsDouble();
	}

	/**
	 * Calculate the Clopper-Pearson vulnerability confidence interval
	 * 
	 * @param vulnerability binary vector indicating an attacks success or failure
	 * @return double[] containing {lower, expected, upper}
	 */
	public static double[] calculateVulnerabilityConfidenceInterval(double[] vulnerability) {
		double[] conf = new double[3];
		conf[1] = calculateVulnerability(vulnerability);
		double[] bounds = BinomialConfidence.calcClopperPearsonInt(Arrays.stream(vulnerability).sum(),
				vulnerability.length, CLOPPER_PEARSON_ALPHA);
		conf[0] = bounds[0];
		conf[2] = bounds[1];
		return conf;
	}

	/**
	 * 
	 * @param tef frequency array
	 * @return double[] containing {min, average, max}
	 */
	public static double[] calculateBoundaries(double[] tef) {
		double[] result = new double[3];
		result[0] = Arrays.stream(tef).min().getAsDouble();
		result[1] = Arrays.stream(tef).average().getAsDouble();
		result[2] = Arrays.stream(tef).max().getAsDouble();
		return result;
	}

	/**
	 * Calculate the threat event frequency. This depends on the contact frequency
	 * and the probability of action.
	 * 
	 * The contact frequency depends on the AttackerType.
	 * 
	 * The probability of action depends on the AttackerType
	 * 
	 * These values could be scaled according to the {@link ThreatType}, for example
	 * an attacker may be more likely to attempt an denial of service. This is
	 * currently not implemented.
	 * 
	 * @param tt           - the threat type
	 * @param attackerType - the attacker profile
	 * @param samples	   - the number of samples to use
	 * @return the threat event frequency array
	 */
	public static double[] calculateTefArray(ThreatType tt, AttackerProfile attackerType, int samples) {
		double[] cfSamples = new BetaPERT(attackerType.getContactFrequency()).sample(samples);
		double[] paSamples = new BetaPERT(attackerType.getProbabilityOfAction()).sample(samples);
		if (Arrays.stream(cfSamples).anyMatch(Double::isNaN)) {
			throw new IllegalStateException("NaN in contact-frequency samples for threat type " + tt.getName());
		}
		if (Arrays.stream(paSamples).anyMatch(Double::isNaN)) {
			throw new IllegalStateException("NaN in probability-of-action samples for threat type " + tt.getName());
		}
		double[] probVect = StatsUtil.ebeMult(cfSamples, paSamples);
		if (Arrays.stream(probVect).anyMatch(Double::isNaN)) {
			throw new IllegalStateException("NaN in threat-event-frequency for threat type " + tt.getName());
		}
		return probVect;
	}

	/**
	 * Calculate the vulnerability for flow, threattype, countermeasures and
	 * attacker profile
	 * 
	 * @param threatenedElement      - the threatened DFDElement
	 * @param flow                   - the data flow (for the context in which the
	 *                               threat applies)
	 * @param tt                     - the threat type
	 * @param countermeasureBindings - list of bound countermeasures
	 * @param attacker               - the attacker profile
	 * @param samples				 - the number of samples to use
	 * @return binary vulnerability array double[SAMPLES]
	 */
	public static double[] calculateVulnerabilityArray(DFDElement threatenedElement, DataFlow flow, ThreatType tt,
			List<RoleBinding> countermeasureBindings, AttackerProfile attacker, int samples) {
		// Calculate vulnerability
		// Should be reduced if there are countermeasures present, that are sufficient
		// to combat the attacker.
		double[] vulnerability = new double[samples];

		// first check if we have an insider
		if (attacker.getInsider().contains(threatenedElement)) {
			Arrays.fill(vulnerability, 1);
			return vulnerability;
		}

		// find all countermeasures

		List<CounterMeasure> cms = getCounterMeasures(flow, tt, countermeasureBindings);

		if (cms.isEmpty()) {
			Arrays.fill(vulnerability, 1);
			return vulnerability;
		}
		// there are countermeasures, calculate their effects
		double[] attackSamples = (new BetaPERT(attacker.getThreatCapability())).sample(samples);

		if (cms.size() == 1) {
			CounterMeasure counter = cms.get(0);
			Estimate diff = counter.getDifficulty();
			if (diff == null) // diff is null, estimate
				diff = new CustomEstimate(100, 100, 100, 100);
			vulnerability = StatsUtil.calcVulnerability(attackSamples, (new BetaPERT(diff)).sample(samples));

		} else {
			double[][] diffMat = new double[cms.size()][samples];
			for (int i = 0; i < cms.size(); i++) {
				Estimate diff = cms.get(i).getDifficulty();
				if (diff == null) // diff is null, estimate
					diff = new CustomEstimate(100, 100, 100, 100);
				diffMat[i] = (new BetaPERT(diff)).sample(samples);
			}
			vulnerability = StatsUtil.calcSeqVulnerability(attackSamples, diffMat);
		}

		return vulnerability;
	}

	private static List<CounterMeasure> getCounterMeasures(DataFlow flow, ThreatType tt,
			List<RoleBinding> countermeasureBindings) {
		return countermeasureBindings.parallelStream()
				.flatMap(b -> b.getBinds().getSubjected().stream()
						.filter( cm ->
						(cm.getMitigates().stream().flatMap( att -> getAllLeaves(att).stream() ).collect(Collectors.toSet()).contains(tt))
						||
						! Collections.disjoint(cm.getMitigatedThreatTypeID(), getAllAncestors(tt).stream().map(att -> att.getId()).collect(Collectors.toList())))
						)
				.filter(cm -> (cm.getScope().isEmpty()
						|| (!flow.getBound().isEmpty() && flow.getBound().stream()
								.anyMatch(rb -> rb.getBinds() != null
										&& cm.getScope().stream().anyMatch(r -> r.equals(rb.getBinds()))))))
				.collect(Collectors.toList());
	}
	

	private static List<ThreatType> getAllLeaves(AbstractThreatType att) {
		List<ThreatType> result = new ArrayList<ThreatType>();
		
		// att is a (leaf) ThreatType
		if (att instanceof ThreatType) {
			result.add((ThreatType) att);
			return result;
		}
		
		// att is a CompositeThreatType
		if (att instanceof CompositeThreatType) {
			for (AbstractThreatType child: ((CompositeThreatType) att).getSubThreatTypes()) {
				result.addAll(getAllLeaves(child));
			}
			return result;
		}
		
		// att is another (unsupported) subclass of AbstractThreatType:
		// return the (empty) accumulator rather than null so callers can addAll() safely
		return result;
	}
	
	private static List<AbstractThreatType> getAllAncestors(AbstractThreatType att) {
		List<AbstractThreatType> result = new ArrayList<AbstractThreatType>();
		result.add(att);
		
		AbstractThreatType parent = att.getSuperThreatType();
		if (parent == null) {
			return result;
		} else {
			result.addAll(getAllAncestors(parent));
			return result;
		}
		
	}

	/**
	 * Calculate the loss event frequency array. This function returns a multi
	 * dimension double array; result[0] is a double[samples] array with the lower
	 * vulnerability value result[1] is a double[samples] array with the expected
	 * vulnerability value result[2] is a double[samples] array with the upper
	 * vulnerability value
	 * 
	 * @param tefSamples                      - the array of threat event frequency
	 *                                        samples
	 * @param vulnerabilityConfidenceInterval - double[] of the vulnerability
	 *                                        {lower, expected, upper}
	 * @param samples						  - the number of samples to use
	 * @return the loss event frequency confidence interval {lower, expected, upper}
	 */
	public static double[][] calculateLefArray(double[] tefSamples, double[] vulnerabilityConfidenceInterval, int samples) {
		ArrayRealVector lower = (new ArrayRealVector(samples)).mapToSelf(e -> e + vulnerabilityConfidenceInterval[0]);
		ArrayRealVector expected = (new ArrayRealVector(samples))
				.mapToSelf(e -> e + vulnerabilityConfidenceInterval[1]);
		ArrayRealVector upper = (new ArrayRealVector(samples)).mapToSelf(e -> e + vulnerabilityConfidenceInterval[2]);

		double[][] result = new double[3][samples];

		result[0] = StatsUtil.ebeMult(tefSamples, lower.toArray());
		result[1] = StatsUtil.ebeMult(tefSamples, expected.toArray());
		result[2] = StatsUtil.ebeMult(tefSamples, upper.toArray());

		return result;
	}
	
	/**
	 * This method reduces an four dimensional matrix (with the fourth dimension containing [lower,expected,upper],
	 * to a three value array containing the sum of, respectively, the lower, expected, and upper values.
	 * @param matrix
	 * @return
	 */
	public static double[] aggregateMatrix(double[][][][] matrix) {
		double totalL = 0, total = 0, totalU = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				for (int k = 0; k < matrix[i][j].length; k++) {
					totalL += matrix[i][j][k][0];
					total += matrix[i][j][k][1];
					totalU += matrix[i][j][k][2];
				}
			}
		}
		return new double[] { totalL, total, totalU };
	}

	/**
	 * This method reduces an four dimensional matrix (with the fourth dimension containing [lower,expected,upper],
	 * to a three value array containing the average of, respectively, the lower, expected, and upper values.
	 * To prevent averaging with 0 values for entries for which there is actually NA, the applicabilityMatrix for the same index.
	 * This means that only entries matrix[i][j][k] are averaged for which applicabilityMatrix[i][j][k]!=0
	 * @param matrix
	 * @param applicabilityMatrix
	 * @return
	 */
	public static double[] aggregateAvgMatrix(double[][][][] matrix, double[][][] applicabilityMatrix) {
		double ctr = 0;
		double totalL = 0, total = 0, totalU = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				for (int k = 0; k < matrix[i][j].length; k++) {
					// check if risk is not Null
					if (applicabilityMatrix[i][j][k] != 0) {
						ctr++;
						totalL += matrix[i][j][k][0];
						total += matrix[i][j][k][1];
						totalU += matrix[i][j][k][2];
					}
				}
			}
		}
		if (ctr == 0)
			ctr = 1;
		return new double[] { totalL / ctr, total / ctr, totalU / ctr };
	}
	
	/**
	 * Get n samples from an estimate distribution. In case of null, samples are all 1.
	 * 
	 * @param estimate the estimate for which samples have to be calculated
	 * @param n the number of samples
	 * @return the samples themselves
	 */
	public static double[] getSamplesFromNullableNeutral(Estimate estimate, int n) {
		if (estimate != null)
			return (new BetaPERT(estimate)).sample(n);
		return RiskCalculation.identity(n);
	}

	/**
	 * Get n samples from an estimate distribution. In case of null, samples are all 0.
	 * 
	 * @param estimate the estimate for which samples have to be calculated
	 * @param n the number of samples
	 * @return the samples themselves
	 */
	public static double[] getSamplesFromNullableZero(Estimate estimate, int n) {
		if (estimate == null)
			return new double[n];
		return (new BetaPERT(estimate)).sample(n);
	}

	/**
	 * Get n identity samples (all 1).
	 * 
	 * @param n the number of samples
	 * @return the samples themselves
	 */
	public static double[] identity(int n) {
		double[] i = new double[n];
		for (int idx=0; idx < n; idx++) {
			i[idx] = 1;
		}
		return i;
	}

}
