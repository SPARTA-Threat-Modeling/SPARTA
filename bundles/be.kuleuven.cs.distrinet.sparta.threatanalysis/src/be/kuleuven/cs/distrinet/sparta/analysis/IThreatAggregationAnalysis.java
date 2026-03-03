/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import be.kuleuven.cs.distrinet.sparta.core.model.IThreat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * This interface provides the analysis API to analyze entire collections of
 * {@link IThreat}s, not individual {@link IThreat}s.
 *
 * @author Laurens
 *
 */
public class IThreatAggregationAnalysis {

	private static final NumberFormat nf = DecimalFormat.getInstance();

	private final Collection<? extends IThreat> threats;

	/**
	 * Create a new {@link IThreatAggregationAnalysis} object to retrieve statistics
	 * on a collection of {@link IThreat}s.
	 *
	 * @param IThreats the collection of IThreats resulting from a IThreat elicitation.
	 */
	public IThreatAggregationAnalysis(Collection<? extends IThreat> threats) {
		this.threats = (threats != null) ? threats : new ArrayList<>();
	}

	/**
	 * Get the total risk of the IThreats.
	 *
	 * @return the total risk
	 */
	public double getTotalRisk() {
		totalRisk = (totalRisk == null) ? threats.stream().mapToDouble(IThreat::getRisk).sum() : totalRisk;
		return totalRisk;
	}

	private Double totalRisk = null;

	/**
	 * Get the total potential risk of the IThreats (assuming fully vulnerable).
	 *
	 * @return the total potential risk (each IThreat is assumed to be fully
	 *         vulnerable)
	 */
	public double getTotalPotentialRisk() {
		return threats.stream().mapToDouble(IThreat::getPotentialRisk).sum();
	}

	/**
	 * Get a percentage of the total risk reduction.
	 *
	 * @return the percentage of risk reduced
	 */
	public double getTotalRiskReductionPct() {
		return (getTotalPotentialRisk() - getTotalRisk()) / getTotalPotentialRisk();
	}

	/**
	 * Get the risk aggregated per IThreat type.
	 *
	 * @return the summed risk for every IThreat type
	 */
	public Map<String, Double> getRiskPerThreatType() {
		return threats.stream().collect(Collectors.toMap(IThreat::getThreatTypeName, IThreat::getRisk, Double::sum));
	}

	/**
	 * Get the potential risk aggregated per IThreat type.
	 *
	 * @return the summed potential risk for every IThreat type
	 */
	public Map<String, Double> getPotentialRiskPerThreatType() {
		return threats.stream().collect(Collectors.toMap(IThreat::getThreatTypeName, IThreat::getPotentialRisk, Double::sum));
	}

	/**
	 * Get the risk reduction percentage per IThreat type.
	 *
	 * @return the risk reduction percentage for every IThreat type
	 */
	public Map<String, Double> getRiskReductionPctPerThreatType() {
		if (riskReductionPctPerThreatType == null)
			riskReductionPctPerThreatType = getPotentialRiskPerThreatType().entrySet().stream().collect(Collectors
					.toMap(Entry::getKey, e -> (e.getValue() - getRiskPerThreatType().get(e.getKey())) / e.getValue()));
		return riskReductionPctPerThreatType;
	}

	private Map<String, Double> riskReductionPctPerThreatType = null;

	/**
	 * Get the risk aggregated per {@link ModelElement} type. The
	 * {@link ModelElement} type is much broader than the {@link DFDElement}
	 * which is usually IThreatened. This enables future IThreat types to be
	 * applicable to other elements such as data types.
	 *
	 * @return the summed risk per {@link ModelElement} type
	 */
	public Map<String, Double> getRiskPerModelElementType() {
		return threats.stream().collect(
				Collectors.toMap((IThreat t) -> t.getThreatenedElementName(), IThreat::getRisk, Double::sum));
	}

	/**
	 * Get the potential risk aggregated per {@link ModelElement} type. The
	 * {@link ModelElement} type is much broader than the {@link DFDElement}
	 * which is usually IThreatened. This enables future IThreat types to be
	 * applicable to other elements such as data types.
	 *
	 * @return the summed potential risk per {@link ModelElement} type
	 */
	public Map<String, Double> getPotentialRiskPerModelElementType() {
		return threats.stream().collect(Collectors.toMap((IThreat t) -> t.getThreatenedElementName(),
				IThreat::getPotentialRisk, Double::sum));
	}

	/**
	 * Get the risk reduction per {@link ModelElement} type. The
	 * {@link ModelElement} type is much broader than the {@link DFDElement}
	 * which is usually IThreatened. This enables future IThreat types to be
	 * applicable to other elements such as data types.
	 *
	 * @return the risk reductionper {@link ModelElement} type
	 */
	public Map<String, Double> getRiskReductionPctPerModelElementType() {
		if (riskReductionPctPerModelElementType == null)
			riskReductionPctPerModelElementType = getPotentialRiskPerModelElementType().entrySet().stream()
					.collect(Collectors.toMap(Entry::getKey,
							e -> (e.getValue() - getRiskPerModelElementType().get(e.getKey())) / e.getValue()));
		return riskReductionPctPerModelElementType;
	}

	private Map<String, Double> riskReductionPctPerModelElementType;

	/**
	 * Get the {@link IThreat} count per {@link ThreatType}.
	 *
	 * @return the IThreat count per IThreat type
	 */
	public Map<String, Long> getThreatCountPerThreatType() {
		if (threatCountPerThreatType == null)
			threatCountPerThreatType = threats.stream()
					.collect(Collectors.groupingBy(IThreat::getThreatTypeName, Collectors.counting()));
		return threatCountPerThreatType;
	}

	private Map<String, Long> threatCountPerThreatType;

	/**
	 * Get the {@link IThreat} count percentage per {@link ThreatType}.
	 *
	 * @return the IThreat count percentage per IThreat type
	 */
	public Map<String, Double> getThreatCountPctPerThreatType() {
		if (threatCountPctPerThreatType == null)
			threatCountPctPerThreatType = threats.stream()
					.collect(Collectors.groupingBy(IThreat::getThreatTypeName, Collectors.counting())).entrySet().stream()
					.collect(Collectors.toMap(Entry::getKey, e -> e.getValue() * 1d / getThreatCount()));
		return threatCountPctPerThreatType;
	}

	private Map<String, Double> threatCountPctPerThreatType;

	/**
	 * Get the {@link IThreat} count per {@link ModelElement} type.
	 *
	 * @return the IThreat count per ModelElement type
	 */
	public Map<String, Long> getThreatCountPerModelElementType() {
		if (threatCountPerModelElementType == null)
			threatCountPerModelElementType = threats.stream().collect(
					Collectors.groupingBy((IThreat t) -> t.getThreatenedElementTypeName(), Collectors.counting()));
		return threatCountPerModelElementType;
	}

	private Map<String, Long> threatCountPerModelElementType;

	/**
	 * Get the {@link IThreat} count percentage per {@link ModelElement} type.
	 *
	 * @return the IThreat count percentage per ModelElement type
	 */
	public Map<String, Double> getThreatCountPctPerModelElementType() {
		if (threatCountPctPerModelElementType == null)
			threatCountPctPerModelElementType = threats.stream()
					.collect(Collectors.groupingBy((IThreat t) -> t.getThreatenedElementName(),
							Collectors.counting()))
					.entrySet().stream()
					.collect(Collectors.toMap(Entry::getKey, e -> e.getValue() * 1d / getThreatCount()));
		;
		return threatCountPctPerModelElementType;
	}

	private Map<String, Double> threatCountPctPerModelElementType;

	/**
	 * Get the total IThreat count.
	 *
	 * @return the total IThreat count
	 */
	public long getThreatCount() {
		if (threatCount == null)
			threatCount = threats.stream().count();
		return threatCount;
	}

	private Long threatCount;

	/**
	 * Get the IThreat type count. This counts the number of types that are
	 * encountered, not how many IThreats of those types are in the set (this can be
	 * retrieved using {@link #getIThreatCountPerThreatType()}).
	 *
	 * @return the IThreat type count
	 */
	public long getThreatTypeCount() {
		if (threatTypeCount == null)
			threatTypeCount = getThreatTypes().stream().count();
		return threatTypeCount;
	}

	private Long threatTypeCount;

	/**
	 * Get the dfdelementtype count. This counts the number of types that are
	 * encountered, not how many IThreats of those types are in the set (this can be
	 * retrieved using {@link #getThreatCountPerModelElementType()}).
	 *
	 * @return the dfdelementtype count
	 */
	public long getDFDElementTypeCount() {
		if (dfdElementTypeCount == null)
			dfdElementTypeCount = getModelElementTypes().stream().count();
		return dfdElementTypeCount;
	}

	private Long dfdElementTypeCount;

	/**
	 * Get the list of IThreat types encountered in the results
	 *
	 * @return the list of IThreat types
	 */
	public List<String> getThreatTypes() {
		if (threatTypes == null)
			threatTypes = threats.stream().map(IThreat::getThreatTypeName).distinct().collect(Collectors.toList());
		return threatTypes;
	}

	private List<String> threatTypes;

	/**
	 * Get the list of IThreatened {@link ModelElement} types encountered in the
	 * results.
	 *
	 * @return the list of dfdmodelelement types
	 */
	public List<String> getModelElementTypes() {
		if (dfdModelElementTypes == null)
			dfdModelElementTypes = threats.stream().map(IThreat::getThreatenedElementName)
					.distinct().collect(Collectors.toList());
		return dfdModelElementTypes;
	}

	private List<String> dfdModelElementTypes;

	/**
	 * Get the IThreat count per model element.
	 *
	 * @return the IThreat count for every element
	 */
	public Map<String, Long> getThreatCountPerModelElement() {
		if (threatCountPerModelElement == null)
			threatCountPerModelElement = threats.stream()
					.collect(Collectors.groupingBy((IThreat t) -> t.getThreatenedElementName(),
							Collectors.counting()));
		;
		return threatCountPerModelElement;
	}

	private Map<String, Long> threatCountPerModelElement;

	/**
	 * Get element type counts.
	 * Since the input for the analysis has only the name of the elements and their type,
	 * it relies on the elementid to determine uniqueness.
	 * @return the number of elements for every model element type
	 */
	public Map<String, Long> getModelElementTypeCount() {
		if (dFDModelElementTypeCount == null)
			dFDModelElementTypeCount = threats.stream().filter(ThreatAggregationAnalysis.distinctByKey(IThreat::getThreatenedElementId))
					.collect(Collectors.groupingBy((IThreat t) -> t.getThreatenedElementTypeName(),Collectors.counting()))
		;
		return dFDModelElementTypeCount;
	}

	private Map<String, Long> dFDModelElementTypeCount;

	/**
	 * Get the average IThreat count per element type.
	 * @return the average IThreat count per element type.
	 */
	public Map<String, Double> getAverageThreatCountPerModelElementType() {
		if (averageThreatCountPerModelElementType == null)
			averageThreatCountPerModelElementType = getThreatCountPerModelElementType().entrySet().stream()
					.collect(Collectors.toMap(Entry::getKey, e -> e.getValue() *1d / getModelElementTypeCount().get(e.getKey())))
		;
		return averageThreatCountPerModelElementType;
	}

	private Map<String, Double> averageThreatCountPerModelElementType;

	/**
	 * Get the average IThreat count per element
	 *
	 * @return the average number of IThreats per element
	 */
	public Double getAverageThreatCounterPerElement() {
		if (averageThreatCounterPerElement == null) {
			averageThreatCounterPerElement = getThreatCountPerModelElement().values().stream().mapToDouble(Long::doubleValue).average().orElse(0d);
		}
		return averageThreatCounterPerElement;
	}
	private Double averageThreatCounterPerElement;

	/**
	 *
	 * @param threat
	 * @param classes
	 * @return
	 */
	public int categorize(IThreat threat, int classes) {
		if (maxPot == null) {
			maxPot = threats.stream().mapToDouble(IThreat::getPotentialRisk).max().orElse(1d);
		}
		return (int) Math.round(threat.getRisk()/ (maxPot/classes));
	}
	private Double maxPot;

}
