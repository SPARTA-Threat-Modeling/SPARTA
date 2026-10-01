/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.SpartaRiskModel;
import be.kuleuven.cs.distrinet.sparta.io.json.CQThreat;
import be.kuleuven.cs.distrinet.sparta.io.json.CQThreat.Severity;
import be.kuleuven.cs.distrinet.sparta.io.templates.ThreatItemTemplate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Regression tests for exporting threats whose risk was never calculated. The real
 * {@link SpartaRiskModel} throws on its getters until {@code calculateRisk} has run, so the
 * exports must check {@code Threat.isRiskCalculated()} rather than expect a null risk.
 */
public class UncalculatedRiskExportTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	private static StubThreat uncalculatedThreat() {
		ThreatType type = FACTORY.createThreatType();
		type.setName("Spoofing");
		Process element = FACTORY.createProcess();
		element.setName("API");
		return new StubThreat(type, element, null, new SpartaRiskModel());
	}

	@Test
	public void threatWithAnUncalculatedRiskModelReportsItAsNotCalculated() {
		assertFalse(uncalculatedThreat().isRiskCalculated());
		assertTrue(new StubThreat(null, FACTORY.createProcess(), null, new StubRiskModel()).isRiskCalculated());
	}

	@Test
	public void reportItemShowsAPlaceholderRisk() {
		String item = ThreatItemTemplate.fill(uncalculatedThreat());

		assertTrue(item, item.contains("\\item[Risk] --"));
	}

	@Test
	public void codeQualityThreatDefaultsToTheLowestSeverity() {
		// The aggregation analysis is only consulted for calculated risks.
		assertEquals(Severity.values()[0], new CQThreat(uncalculatedThreat(), null).getSeverity());
	}
}
