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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.analysis.StatsUtil;

/**
 * Tests for the pure statistical helpers in {@link StatsUtil}. This class was not
 * refactored, but its methods underpin the whole risk calculation and had no coverage.
 */
public class StatsUtilTest {

	private static final double EPS = 1e-9;

	@Test
	public void maxAndMin() {
		double[] v = { 3, 1, 4, 1, 5, 9, 2 };
		assertEquals(9.0, StatsUtil.max(v), EPS);
		assertEquals(1.0, StatsUtil.min(v), EPS);
	}

	@Test
	public void maxAndMinWithNegatives() {
		double[] v = { -3, -1, -4 };
		assertEquals(-1.0, StatsUtil.max(v), EPS);
		assertEquals(-4.0, StatsUtil.min(v), EPS);
	}

	@Test
	public void medianOddLength() {
		assertEquals(2.0, StatsUtil.median(new double[] { 3, 1, 2 }), EPS);
	}

	@Test
	public void medianEvenLengthAveragesMiddleTwo() {
		assertEquals(2.5, StatsUtil.median(new double[] { 4, 1, 3, 2 }), EPS);
	}

	@Test
	public void medianIsOrderIndependent() {
		assertEquals(30.0, StatsUtil.median(new double[] { 50, 10, 30, 20, 40 }), EPS);
	}

	@Test
	public void ebeMultiply() {
		assertArrayEquals(new double[] { 8, 15, 0 }, StatsUtil.ebeMult(new double[] { 2, 3, 7 }, new double[] { 4, 5, 0 }), EPS);
	}

	@Test
	public void scalarProduct() {
		assertArrayEquals(new double[] { 2, 4, 6 }, StatsUtil.scalProd(new double[] { 1, 2, 3 }, 2), EPS);
	}

	/** Attack succeeds (1) iff capability >= difficulty, element-wise; ties (0) count as success. */
	@Test
	public void calcVulnerabilitySingleCountermeasure() {
		double[] result = StatsUtil.calcVulnerability(new double[] { 5, 2, 8 }, new double[] { 3, 4, 8 });
		assertArrayEquals(new double[] { 1, 0, 1 }, result, EPS);
	}

	/** Sequential: the attack only succeeds when capability beats EVERY countermeasure. */
	@Test
	public void calcSeqVulnerabilityRequiresBeatingAllCountermeasures() {
		double[] tcap = { 5, 5 };
		double[] cm1 = { 3, 6 };
		double[] cm2 = { 4, 4 };
		double[] result = StatsUtil.calcSeqVulnerability(tcap, cm1, cm2);
		// sample 0: 5>=3 and 5>=4 -> 1 ; sample 1: 5<6 -> 0
		assertArrayEquals(new double[] { 1, 0 }, result, EPS);
	}

	/** mode with an explicit bin count returns a value near the peak of the distribution. */
	@Test
	public void modeWithExplicitBinsFindsPeak() {
		double[] v = { 1, 7, 7, 7, 7, 7, 7, 7, 7, 10 };
		double mode = StatsUtil.mode(v, 10);
		assertTrue("mode should be finite", Double.isFinite(mode));
		assertTrue("mode should be near the peak (7), was " + mode, Math.abs(mode - 7.0) < 1.5);
	}

	// NOTE: the single-argument StatsUtil.mode(double[]) computes numbins = length/100, which
	// is 0 for arrays shorter than 100 elements and yields a non-finite result. That known
	// edge case is intentionally not asserted here; add coverage once it is fixed.
}
