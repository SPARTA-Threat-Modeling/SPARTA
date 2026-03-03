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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * This class provides analysis methods to analyze entire collections of
 * {@link Threat}s, not individual {@link Threat}s.
 * 
 * @author Laurens
 *
 */
public class ThreatAggregationAnalysis {

	private static final NumberFormat nf = DecimalFormat.getInstance();

	private final Collection<Threat> threats;

	/**
	 * Create a new {@link ThreatAggregationAnalysis} object to retrieve statistics
	 * on a collection of {@link Threat}s.
	 * 
	 * @param threats the collection of threats resulting from a threat elicitation.
	 */
	public ThreatAggregationAnalysis(Collection<Threat> threats) {
		this.threats = (threats != null) ? threats : new ArrayList<>();
	}

	/**
	 * Analyze a collection of threats and print out the results.
	 * 
	 * @deprecated Instead of this generic analysis method, users are encouraged to
	 *             create a new {@link ThreatAggregationAnalysis} objects and
	 *             retrieve the required statistics from those objects.
	 * @param threats the collection of {@link Threat}s to analyze.
	 */
	@Deprecated
	public static void analyze(Collection<Threat> threats) {
		new ThreatAggregationAnalysis(threats).analyzeAndPrint();

	}

	private void analyzeAndPrint() {
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);

		double totalPotential = threats.stream().mapToDouble(Threat::getPotentialRisk).sum();
		double actual = threats.stream().mapToDouble(Threat::getRisk).sum();

		Map<ThreatType, Double> actT = threats.stream()
				.collect(Collectors.toMap(Threat::getThreatType, Threat::getRisk, Double::sum));
		Map<ThreatType, Double> potT = threats.stream()
				.collect(Collectors.toMap(Threat::getThreatType, Threat::getPotentialRisk, Double::sum));
	}

	/**
	 * Get the total risk of the threats.
	 * 
	 * @return the total risk
	 */
	public double getTotalRisk() {
		totalRisk = (totalRisk == null) ? threats.stream().mapToDouble(Threat::getRisk).sum() : totalRisk;
		return totalRisk;
	}

	private Double totalRisk = null;

	/**
	 * Get the total potential risk of the threats (assuming fully vulnerable).
	 * 
	 * @return the total potential risk (each threat is assumed to be fully
	 *         vulnerable)
	 */
	public double getTotalPotentialRisk() {
		return threats.stream().mapToDouble(Threat::getPotentialRisk).sum();
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
	 * Get the risk aggregated per threat type.
	 * 
	 * @return the summed risk for every threat type
	 */
	public Map<ThreatType, Double> getRiskPerThreatType() {
		return threats.stream().collect(Collectors.toMap(Threat::getThreatType, Threat::getRisk, Double::sum));
	}

	/**
	 * Get the potential risk aggregated per threat type.
	 * 
	 * @return the summed potential risk for every threat type
	 */
	public Map<ThreatType, Double> getPotentialRiskPerThreatType() {
		return threats.stream().collect(Collectors.toMap(Threat::getThreatType, Threat::getPotentialRisk, Double::sum));
	}

	/**
	 * Get the risk reduction percentage per threat type.
	 * 
	 * @return the risk reduction percentage for every threat type
	 */
	public Map<ThreatType, Double> getRiskReductionPctPerThreatType() {
		if (riskReductionPctPerThreatType == null)
			riskReductionPctPerThreatType = getPotentialRiskPerThreatType().entrySet().stream().collect(Collectors
					.toMap(Entry::getKey, e -> (e.getValue() - getRiskPerThreatType().get(e.getKey())) / e.getValue()));
		return riskReductionPctPerThreatType;
	}

	private Map<ThreatType, Double> riskReductionPctPerThreatType = null;

	/**
	 * Get the risk aggregated per {@link ModelElement} type. The
	 * {@link ModelElement} type is much broader than the {@link DFDElement}
	 * which is usually threatened. This enables future threat types to be
	 * applicable to other elements such as data types.
	 * 
	 * @return the summed risk per {@link ModelElement} type
	 */
	public Map<Class<? extends ModelElement>, Double> getRiskPerModelElementType() {
		return threats.stream().collect(
				Collectors.toMap((Threat t) -> t.getThreatenedElement().getClass(), Threat::getRisk, Double::sum));
	}

	/**
	 * Get the potential risk aggregated per {@link ModelElement} type. The
	 * {@link ModelElement} type is much broader than the {@link DFDElement}
	 * which is usually threatened. This enables future threat types to be
	 * applicable to other elements such as data types.
	 * 
	 * @return the summed potential risk per {@link ModelElement} type
	 */
	public Map<Class<? extends ModelElement>, Double> getPotentialRiskPerModelElementType() {
		return threats.stream().collect(Collectors.toMap((Threat t) -> t.getThreatenedElement().getClass(),
				Threat::getPotentialRisk, Double::sum));
	}

	/**
	 * Get the risk reduction per {@link ModelElement} type. The
	 * {@link ModelElement} type is much broader than the {@link DFDElement}
	 * which is usually threatened. This enables future threat types to be
	 * applicable to other elements such as data types.
	 * 
	 * @return the risk reductionper {@link ModelElement} type
	 */
	public Map<Class<? extends ModelElement>, Double> getRiskReductionPctPerModelElementType() {
		if (riskReductionPctPerModelElementType == null)
			riskReductionPctPerModelElementType = getPotentialRiskPerModelElementType().entrySet().stream()
					.collect(Collectors.toMap(Entry::getKey,
							e -> (e.getValue() - getRiskPerModelElementType().get(e.getKey())) / e.getValue()));
		return riskReductionPctPerModelElementType;
	}

	private Map<Class<? extends ModelElement>, Double> riskReductionPctPerModelElementType;

	/**
	 * Get the {@link Threat} count per {@link ThreatType}.
	 * 
	 * @return the threat count per threat type
	 */
	public Map<ThreatType, Long> getThreatCountPerThreatType() {
		if (threatCountPerThreatType == null)
			threatCountPerThreatType = threats.stream()
					.collect(Collectors.groupingBy(Threat::getThreatType, Collectors.counting()));
		return threatCountPerThreatType;
	}

	private Map<ThreatType, Long> threatCountPerThreatType;

	/**
	 * Get the {@link Threat} count percentage per {@link ThreatType}.
	 * 
	 * @return the threat count percentage per threat type
	 */
	public Map<ThreatType, Double> getThreatCountPctPerThreatType() {
		if (threatCountPctPerThreatType == null)
			threatCountPctPerThreatType = threats.stream()
					.collect(Collectors.groupingBy(Threat::getThreatType, Collectors.counting())).entrySet().stream()
					.collect(Collectors.toMap(Entry::getKey, e -> e.getValue() * 1d / getThreatCount()));
		return threatCountPctPerThreatType;
	}

	private Map<ThreatType, Double> threatCountPctPerThreatType;

	/**
	 * Get the {@link Threat} count per {@link ModelElement} type.
	 * 
	 * @return the threat count per ModelElement type
	 */
	public Map<Class<? extends ModelElement>, Long> getThreatCountPerModelElementType() {
		if (threatCountPerModelElementType == null)
			threatCountPerModelElementType = threats.stream().collect(
					Collectors.groupingBy((Threat t) -> t.getThreatenedElement().getClass(), Collectors.counting()));
		return threatCountPerModelElementType;
	}

	private Map<Class<? extends ModelElement>, Long> threatCountPerModelElementType;

	/**
	 * Get the {@link Threat} count percentage per {@link ModelElement} type.
	 * 
	 * @return the threat count percentage per ModelElement type
	 */
	public Map<Class<? extends ModelElement>, Double> getThreatCountPctPerModelElementType() {
		if (threatCountPctPerModelElementType == null)
			threatCountPctPerModelElementType = threats.stream()
					.collect(Collectors.groupingBy((Threat t) -> t.getThreatenedElement().getClass(),
							Collectors.counting()))
					.entrySet().stream()
					.collect(Collectors.toMap(Entry::getKey, e -> e.getValue() * 1d / getThreatCount()));
		;
		return threatCountPctPerModelElementType;
	}

	private Map<Class<? extends ModelElement>, Double> threatCountPctPerModelElementType;

	/**
	 * Get the total threat count.
	 * 
	 * @return the total threat count
	 */
	public long getThreatCount() {
		if (threatCount == null)
			threatCount = threats.stream().count();
		return threatCount;
	}

	private Long threatCount;

	/**
	 * Get the threat type count. This counts the number of types that are
	 * encountered, not how many threats of those types are in the set (this can be
	 * retrieved using {@link #getThreatCountPerThreatType()}).
	 * 
	 * @return the threat type count
	 */
	public long getThreatTypeCount() {
		if (threatTypeCount == null)
			threatTypeCount = getThreatTypes().stream().count();
		return threatTypeCount;
	}

	private Long threatTypeCount;

	/**
	 * Get the dfdelementtype count. This counts the number of types that are
	 * encountered, not how many threats of those types are in the set (this can be
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
	 * Get the list of threat types encountered in the results
	 * 
	 * @return the list of threat types
	 */
	public List<ThreatType> getThreatTypes() {
		if (threatTypes == null)
			threatTypes = threats.stream().map(Threat::getThreatType).distinct().collect(Collectors.toList());
		return threatTypes;
	}

	private List<ThreatType> threatTypes;

	/**
	 * Get the list of threatened {@link ModelElement} types encountered in the
	 * results.
	 * 
	 * @return the list of modelElement types
	 */
	public List<Class<? extends ModelElement>> getModelElementTypes() {
		if (modelElementTypes == null)
			modelElementTypes = threats.stream().map(Threat::getThreatenedElement).map(ModelElement::getClass)
					.distinct().collect(Collectors.toList());
		return modelElementTypes;
	}

	private List<Class<? extends ModelElement>> modelElementTypes;

	/**
	 * Get the threat count per model element.
	 * 
	 * @return the threat count for every element
	 */
	public Map<ModelElement, Long> getThreatCountPerModelElement() {
		if (threatCountPerModelElement == null)
			threatCountPerModelElement = threats.stream()
					.collect(Collectors.groupingBy((Threat t) -> t.getThreatenedElement(),
							Collectors.counting()));
		;
		return threatCountPerModelElement;
	}

	private Map<ModelElement, Long> threatCountPerModelElement;
	
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}
	
	/**
	 * Get element type counts.
	 * @return the number of elements for every model element type
	 */
	public Map<Class<? extends ModelElement>, Long> getModelElementTypeCount() {
		if (modelElementTypeCount == null)
			modelElementTypeCount = threats.stream().filter(distinctByKey(Threat::getThreatenedElement))
					.collect(Collectors.groupingBy((Threat t) -> t.getThreatenedElement().getClass(),Collectors.counting()))
		;
		return modelElementTypeCount;
	}

	private Map<Class<? extends ModelElement>, Long> modelElementTypeCount;
	
	/**
	 * Get the average threat count per element type.
	 * @return the average threat count per element type.
	 */
	public Map<Class<? extends ModelElement>, Double> getAverageThreatCountPerModelElementType() {
		if (averageThreatCountPerModelElementType == null)
			averageThreatCountPerModelElementType = getThreatCountPerModelElementType().entrySet().stream()
					.collect(Collectors.toMap(Entry::getKey, e -> e.getValue() *1d / getModelElementTypeCount().get(e.getKey())))
		;
		return averageThreatCountPerModelElementType;
	}

	private Map<Class<? extends ModelElement>, Double> averageThreatCountPerModelElementType;
	
	/**
	 * Get the average threat count per element
	 * 
	 * @return the average number of threats per element
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
	public int categorize(Threat threat, int classes) {
		if (maxPot == null) {
			maxPot = threats.stream().mapToDouble(Threat::getPotentialRisk).max().orElse(1d);
		}
		return (int) Math.round(threat.getRisk()/ (maxPot/classes));
	}
	private Double maxPot;

}
