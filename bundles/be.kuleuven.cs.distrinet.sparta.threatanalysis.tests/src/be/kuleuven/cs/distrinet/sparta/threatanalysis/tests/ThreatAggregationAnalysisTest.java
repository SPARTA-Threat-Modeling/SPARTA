/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.threatanalysis.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.analysis.ThreatAggregationAnalysis;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Tests for {@link ThreatAggregationAnalysis}, the collection-level statistics used to
 * summarize an elicitation. The fixture is three threats over two threat types and two
 * threatened elements (one shared), so every per-type / per-element aggregation, count,
 * distinct-set, reduction percentage, and the risk categorization can be checked against
 * hand-computed values. Threats are {@link StubThreat}s with fixed risk / potential risk.
 */
public class ThreatAggregationAnalysisTest {

	private static final double EPS = 1e-9;
	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	private ThreatType spoofing;
	private ThreatType tampering;
	private Process p1;
	private DataStore ds1;
	private ThreatAggregationAnalysis analysis;

	@Before
	public void setUp() {
		spoofing = FACTORY.createThreatType();
		spoofing.setName("Spoofing");
		tampering = FACTORY.createThreatType();
		tampering.setName("Tampering");

		p1 = FACTORY.createProcess();
		p1.setName("P1");
		ds1 = FACTORY.createDataStore();
		ds1.setName("DS1");

		// Two Spoofing threats on P1 (risk 10 & 20, potential 100 each) and one Tampering
		// threat on DS1 (risk 30, potential 200).
		List<Threat> threats = Arrays.asList(
				new StubThreat(spoofing, p1, 10, 100),
				new StubThreat(spoofing, p1, 20, 100),
				new StubThreat(tampering, ds1, 30, 200));
		analysis = new ThreatAggregationAnalysis(threats);
	}

	@Test
	public void totalsSumAcrossAllThreats() {
		assertEquals(60.0, analysis.getTotalRisk(), EPS);
		assertEquals(400.0, analysis.getTotalPotentialRisk(), EPS);
	}

	@Test
	public void totalRiskReductionIsFractionOfPotentialAvoided() {
		// (400 - 60) / 400
		assertEquals(0.85, analysis.getTotalRiskReductionPct(), EPS);
	}

	@Test
	public void riskIsSummedPerThreatType() {
		Map<ThreatType, Double> risk = analysis.getRiskPerThreatType();
		assertEquals(30.0, risk.get(spoofing), EPS);
		assertEquals(30.0, risk.get(tampering), EPS);

		Map<ThreatType, Double> potential = analysis.getPotentialRiskPerThreatType();
		assertEquals(200.0, potential.get(spoofing), EPS);
		assertEquals(200.0, potential.get(tampering), EPS);
	}

	@Test
	public void riskReductionPctPerThreatType() {
		Map<ThreatType, Double> reduction = analysis.getRiskReductionPctPerThreatType();
		// Spoofing: (200 - 30) / 200 ; Tampering: (200 - 30) / 200
		assertEquals(0.85, reduction.get(spoofing), EPS);
		assertEquals(0.85, reduction.get(tampering), EPS);
	}

	@Test
	public void threatCountsAndPercentagesPerThreatType() {
		assertEquals(3L, analysis.getThreatCount());

		Map<ThreatType, Long> counts = analysis.getThreatCountPerThreatType();
		assertEquals(2L, counts.get(spoofing).longValue());
		assertEquals(1L, counts.get(tampering).longValue());

		Map<ThreatType, Double> pct = analysis.getThreatCountPctPerThreatType();
		assertEquals(2.0 / 3.0, pct.get(spoofing), EPS);
		assertEquals(1.0 / 3.0, pct.get(tampering), EPS);
	}

	@Test
	public void distinctThreatTypes() {
		assertEquals(2L, analysis.getThreatTypeCount());
		assertEquals(2, analysis.getThreatTypes().size());
	}

	@Test
	public void riskAndCountsPerModelElementType() {
		Map<Class<? extends ModelElement>, Double> riskByType = analysis.getRiskPerModelElementType();
		assertEquals(30.0, riskByType.get(p1.getClass()), EPS);
		assertEquals(30.0, riskByType.get(ds1.getClass()), EPS);

		Map<Class<? extends ModelElement>, Long> countByType = analysis.getThreatCountPerModelElementType();
		assertEquals(2L, countByType.get(p1.getClass()).longValue());
		assertEquals(1L, countByType.get(ds1.getClass()).longValue());

		assertEquals(2L, analysis.getDFDElementTypeCount());
		assertEquals(2, analysis.getModelElementTypes().size());
	}

	@Test
	public void threatCountsPerModelElement() {
		Map<ModelElement, Long> perElement = analysis.getThreatCountPerModelElement();
		assertEquals(2L, perElement.get(p1).longValue());
		assertEquals(1L, perElement.get(ds1).longValue());

		// Average threats per (distinct) element: (2 + 1) / 2 elements.
		assertEquals(1.5, analysis.getAverageThreatCounterPerElement(), EPS);
	}

	@Test
	public void distinctElementCountsAndAveragePerElementType() {
		// Each element type is backed by a single distinct element here.
		Map<Class<? extends ModelElement>, Long> typeCount = analysis.getModelElementTypeCount();
		assertEquals(1L, typeCount.get(p1.getClass()).longValue());
		assertEquals(1L, typeCount.get(ds1.getClass()).longValue());

		// threats-of-type / distinct-elements-of-type: Process 2/1, DataStore 1/1.
		Map<Class<? extends ModelElement>, Double> avg = analysis.getAverageThreatCountPerModelElementType();
		assertEquals(2.0, avg.get(p1.getClass()), EPS);
		assertEquals(1.0, avg.get(ds1.getClass()), EPS);
	}

	@Test
	public void categorizeBucketsRiskAgainstTheMaximumPotential() {
		// maxPotential = 200, classes = 4 -> bucket width 50; bucket = round(risk / 50).
		Threat lowRisk = new StubThreat(spoofing, p1, 10, 100); // round(0.2) = 0
		Threat midRisk = new StubThreat(tampering, ds1, 30, 200); // round(0.6) = 1
		ThreatAggregationAnalysis a = new ThreatAggregationAnalysis(Arrays.asList(lowRisk, midRisk));
		assertEquals(0, a.categorize(lowRisk, 4));
		assertEquals(1, a.categorize(midRisk, 4));
	}

	@Test
	public void nullCollectionIsTreatedAsEmpty() {
		ThreatAggregationAnalysis empty = new ThreatAggregationAnalysis(null);
		assertEquals(0L, empty.getThreatCount());
		assertEquals(0.0, empty.getTotalRisk(), EPS);
		assertEquals(0.0, empty.getTotalPotentialRisk(), EPS);
	}

	@Test
	public void emptyCollectionHasNoThreats() {
		ThreatAggregationAnalysis empty = new ThreatAggregationAnalysis(Collections.emptyList());
		assertEquals(0L, empty.getThreatCount());
		assertEquals(0.0, empty.getTotalRisk(), EPS);
		assertEquals(0, empty.getThreatTypes().size());
	}
}
