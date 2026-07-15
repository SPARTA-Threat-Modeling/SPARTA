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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskCalculation;
import be.kuleuven.cs.distrinet.sparta.core.model.Attacker;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Tests for {@link RiskCalculation}: the pure aggregation helpers plus the
 * threat-event-frequency path, which previously threw {@code AssertionError} on a
 * degenerate (min == max) estimate.
 */
public class RiskCalculationTest {

	@Test
	public void aggregateMatrixSumsEachTier() {
		double[][][][] m = new double[2][1][1][3];
		m[0][0][0] = new double[] { 1, 2, 3 };
		m[1][0][0] = new double[] { 4, 5, 6 };
		assertArrayEquals(new double[] { 5, 7, 9 }, RiskCalculation.aggregateMatrix(m), 1e-9);
	}

	@Test
	public void aggregateAvgMatrixAveragesApplicableCells() {
		double[][][][] m = new double[2][1][1][3];
		m[0][0][0] = new double[] { 2, 4, 6 };
		m[1][0][0] = new double[] { 4, 8, 12 };
		double[][][] applicability = new double[2][1][1];
		applicability[0][0][0] = 1;
		applicability[1][0][0] = 1;
		assertArrayEquals(new double[] { 3, 6, 9 }, RiskCalculation.aggregateAvgMatrix(m, applicability), 1e-9);
	}

	/** The {@code ctr == 0} guard: no applicable cells must not divide by zero. */
	@Test
	public void aggregateAvgMatrixGuardsAgainstNoApplicableCells() {
		double[][][][] m = new double[1][1][1][3];
		m[0][0][0] = new double[] { 5, 5, 5 };
		double[][][] applicability = new double[1][1][1]; // all zero
		assertArrayEquals(new double[] { 0, 0, 0 }, RiskCalculation.aggregateAvgMatrix(m, applicability), 1e-9);
	}

	@Test
	public void boundariesReturnMinAvgMax() {
		double[] b = RiskCalculation.calculateBoundaries(new double[] { 1, 2, 3, 4 });
		assertEquals(1.0, b[0], 1e-9);
		assertEquals(2.5, b[1], 1e-9);
		assertEquals(4.0, b[2], 1e-9);
	}

	@Test
	public void identityIsAllOnes() {
		assertArrayEquals(new double[] { 1, 1, 1, 1 }, RiskCalculation.identity(4), 0.0);
	}

	@Test
	public void nullEstimateSampling() {
		assertArrayEquals(new double[] { 0, 0, 0 }, RiskCalculation.getSamplesFromNullableZero(null, 3), 0.0);
		assertArrayEquals(new double[] { 1, 1, 1 }, RiskCalculation.getSamplesFromNullableNeutral(null, 3), 0.0);
	}

	/**
	 * Regression: a degenerate (min == max) contact-frequency and
	 * probability-of-action estimate must no longer throw an {@code AssertionError}
	 * but instead yield a finite, non-NaN threat-event-frequency vector.
	 * Here cf == 5 (point mass) and poa == 0.5 (point mass), so every TEF value is 2.5.
	 */
	@Test
	public void degenerateAttackerEstimatesYieldFiniteTef() {
		AttackerProfile attacker = new Attacker("test",
				0, 1, 2, 4, // threat capability
				5, 5, 5, 4, // contact frequency (degenerate)
				0.5, 0.5, 0.5, 4); // probability of action (degenerate)
		ThreatType tt = SpartaModelFactory.eINSTANCE.createThreatType();

		double[] tef = RiskCalculation.calculateTefArray(tt, attacker, 500);

		assertEquals(500, tef.length);
		for (double v : tef) {
			assertFalse("degenerate estimate must not yield NaN TEF", Double.isNaN(v));
			assertEquals(2.5, v, 1e-9);
		}
	}
}
