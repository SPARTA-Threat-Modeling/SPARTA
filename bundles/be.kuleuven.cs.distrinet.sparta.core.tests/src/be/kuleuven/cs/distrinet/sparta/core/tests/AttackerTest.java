/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.model.Attacker;
import be.kuleuven.cs.distrinet.sparta.core.model.CustomEstimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;

/**
 * Tests for the standalone-analysis model helpers {@link CustomEstimate} and
 * {@link Attacker}. Their getters return the values passed to the constructor (they
 * deliberately do not rely on EMF reflective state), and this pins that contract.
 */
public class AttackerTest {

	private static final double EPS = 1e-9;

	@Test
	public void customEstimateExposesConstructorValues() {
		CustomEstimate e = new CustomEstimate(1, 2, 3, 4);
		assertEquals(1.0, e.getMinimum(), EPS);
		assertEquals(2.0, e.getProbable(), EPS);
		assertEquals(3.0, e.getMaximum(), EPS);
		assertEquals(4.0, e.getConfidence(), EPS);
		assertEquals("", e.getName());
	}

	@Test
	public void customEstimateKeepsName() {
		CustomEstimate e = new CustomEstimate(0, 0, 1, 2, "likelihood");
		assertEquals("likelihood", e.getName());
	}

	@Test
	public void attackerExposesNameAndEstimates() {
		Attacker a = new Attacker("Opportunist",
				0, 15, 35, 2, // threat capability
				4, 12, 24, 4, // contact frequency
				0, 0.1, 0.3, 4); // probability of action

		assertEquals("Opportunist", a.getName());

		Estimate tcap = a.getThreatCapability();
		assertNotNull(tcap);
		assertEquals(0.0, tcap.getMinimum(), EPS);
		assertEquals(35.0, tcap.getMaximum(), EPS);

		assertEquals(4.0, a.getContactFrequency().getMinimum(), EPS);
		assertEquals(24.0, a.getContactFrequency().getMaximum(), EPS);
		assertEquals(0.3, a.getProbabilityOfAction().getMaximum(), EPS);
	}

	@Test
	public void attackerAcceptsExplicitEstimates() {
		Attacker a = new Attacker("x", new CustomEstimate(1, 2, 3, 4),
				new CustomEstimate(5, 6, 7, 8), new CustomEstimate(9, 10, 11, 12));
		assertEquals(1.0, a.getThreatCapability().getMinimum(), EPS);
		assertEquals(5.0, a.getContactFrequency().getMinimum(), EPS);
		assertEquals(9.0, a.getProbabilityOfAction().getMinimum(), EPS);
	}

	@Test
	public void insiderListIsEmptyByDefault() {
		Attacker a = new Attacker("x", new CustomEstimate(0, 0, 0, 0),
				new CustomEstimate(0, 0, 0, 0), new CustomEstimate(0, 0, 0, 0));
		assertNotNull(a.getInsider());
		assertTrue(a.getInsider().isEmpty());
	}

	/** minComparator orders attackers by the minimum of their threat-capability estimate. */
	@Test
	public void minComparatorOrdersByThreatCapabilityMinimum() {
		Attacker low = new Attacker("low", new CustomEstimate(1, 5, 9, 4),
				new CustomEstimate(0, 0, 0, 0), new CustomEstimate(0, 0, 0, 0));
		Attacker high = new Attacker("high", new CustomEstimate(7, 8, 9, 4),
				new CustomEstimate(0, 0, 0, 0), new CustomEstimate(0, 0, 0, 0));

		List<Attacker> attackers = new ArrayList<>();
		attackers.add(high);
		attackers.add(low);
		attackers.sort(Attacker.minComparator());

		assertEquals("low", attackers.get(0).getName());
		assertEquals("high", attackers.get(1).getName());
	}
}
