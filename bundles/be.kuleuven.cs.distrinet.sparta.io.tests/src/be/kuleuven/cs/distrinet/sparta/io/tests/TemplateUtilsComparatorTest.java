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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.SpartaRiskModel;
import be.kuleuven.cs.distrinet.sparta.io.templates.TemplateUtils;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Tests for the threat comparators in {@link TemplateUtils}. {@code BY_RISK}
 * orders the report's threat items, so its null-risk handling matters: the
 * risk is null until the risk calculation has run, and such threats must sort
 * as risk 0 instead of throwing.
 */
public class TemplateUtilsComparatorTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	private static StubThreat threatOfType(String typeName) {
		ThreatType type = FACTORY.createThreatType();
		type.setName(typeName);
		Process element = FACTORY.createProcess();
		element.setName("P1");
		return new StubThreat(type, element, null, new StubRiskModel());
	}

	/** A threat whose real risk model has not been calculated: reading its risk throws. */
	private static StubThreat uncalculatedThreat() {
		ThreatType type = FACTORY.createThreatType();
		type.setName("Spoofing");
		Process element = FACTORY.createProcess();
		element.setName("P1");
		return new StubThreat(type, element, null, new SpartaRiskModel());
	}

	private static StubThreat threatWithRisk(Double risk) {
		ThreatType type = FACTORY.createThreatType();
		type.setName("Spoofing");
		Process element = FACTORY.createProcess();
		element.setName("P1");
		return new StubThreat(type, element, null, new StubRiskModel()) {
			@Override
			public Double getRisk() {
				return risk;
			}
		};
	}

	@Test
	public void byRiskOrdersAscendingByPointEstimate() {
		assertTrue(TemplateUtils.BY_RISK.compare(threatWithRisk(10d), threatWithRisk(20d)) < 0);
		assertTrue(TemplateUtils.BY_RISK.compare(threatWithRisk(20d), threatWithRisk(10d)) > 0);
		assertEquals(0, TemplateUtils.BY_RISK.compare(threatWithRisk(10d), threatWithRisk(10d)));
	}

	/** A threat whose risk was not calculated sorts as risk 0, without throwing. */
	@Test
	public void byRiskTreatsAnUncalculatedRiskAsZero() {
		assertEquals(0, TemplateUtils.BY_RISK.compare(uncalculatedThreat(), threatWithRisk(0d)));
		assertTrue(TemplateUtils.BY_RISK.compare(uncalculatedThreat(), threatWithRisk(10d)) < 0);
		assertTrue(TemplateUtils.BY_RISK.compare(threatWithRisk(10d), uncalculatedThreat()) > 0);
	}

	@Test
	public void byTypeNameComparesCaseInsensitively() {
		assertTrue(TemplateUtils.BY_TYPE_NAME.compare(threatOfType("alpha"), threatOfType("BETA")) < 0);
		assertTrue(TemplateUtils.BY_TYPE_NAME.compare(threatOfType("BETA"), threatOfType("alpha")) > 0);
		assertEquals(0, TemplateUtils.BY_TYPE_NAME.compare(threatOfType("Spoofing"), threatOfType("sPOOFING")));
	}

	/** A type without a name sorts first (as the empty string), without throwing. */
	@Test
	public void byTypeNameOrdersUnnamedTypesFirst() {
		assertTrue(TemplateUtils.BY_TYPE_NAME.compare(threatOfType(null), threatOfType("Spoofing")) < 0);
		assertTrue(TemplateUtils.BY_TYPE_NAME.compare(threatOfType("Spoofing"), threatOfType(null)) > 0);
	}

	@Test
	public void byNameComparesThreatDescriptionsCaseInsensitively() {
		// toString() starts with the threat type name; case must not matter.
		assertTrue(TemplateUtils.BY_NAME.compare(threatOfType("alpha"), threatOfType("BETA")) < 0);
		assertTrue(TemplateUtils.BY_NAME.compare(threatOfType("BETA"), threatOfType("alpha")) > 0);
	}
}
