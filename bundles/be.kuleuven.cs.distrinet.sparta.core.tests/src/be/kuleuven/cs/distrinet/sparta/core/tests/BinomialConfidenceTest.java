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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.analysis.BinomialConfidence;

/**
 * Tests for {@link BinomialConfidence#calcClopperPearsonInt}, including the two
 * closed-form edge cases (0 successes / all successes) and the general beta-based interval.
 */
public class BinomialConfidenceTest {

	private static final double ALPHA = 0.05;
	private static final double DELTA = 1e-3;

	/** Zero successes: lower bound is exactly 0, upper is the closed-form rule-of-three-like value. */
	@Test
	public void zeroSuccesses() {
		double[] ci = BinomialConfidence.calcClopperPearsonInt(0, 10, ALPHA);
		assertEquals(0.0, ci[0], 0.0);
		assertEquals(1.0 - Math.pow(ALPHA / 2, 1.0 / 10), ci[1], DELTA);
		assertTrue(ci[1] > 0 && ci[1] < 1);
	}

	/** All successes: upper bound is exactly 1, lower is the closed-form value. */
	@Test
	public void allSuccesses() {
		double[] ci = BinomialConfidence.calcClopperPearsonInt(10, 10, ALPHA);
		assertEquals(Math.pow(ALPHA / 2, 1.0 / 10), ci[0], DELTA);
		assertEquals(1.0, ci[1], 0.0);
		assertTrue(ci[0] > 0 && ci[0] < 1);
	}

	/** General case: a symmetric two-sided interval that brackets the point estimate 0.5. */
	@Test
	public void balancedSampleGivesSymmetricInterval() {
		double[] ci = BinomialConfidence.calcClopperPearsonInt(5, 10, ALPHA);
		assertTrue("lower > 0", ci[0] > 0);
		assertTrue("upper < 1", ci[1] < 1);
		assertTrue("lower < 0.5 < upper", ci[0] < 0.5 && ci[1] > 0.5);
		assertTrue("interval roughly symmetric about 0.5",
				Math.abs((0.5 - ci[0]) - (ci[1] - 0.5)) < 0.05);
		// known Clopper-Pearson values for 5/10 at 95%: ~[0.187, 0.813]
		assertEquals(0.187, ci[0], 0.02);
		assertEquals(0.813, ci[1], 0.02);
	}

	/** A larger sample at the same proportion yields a tighter interval. */
	@Test
	public void largerSampleTightensInterval() {
		double[] small = BinomialConfidence.calcClopperPearsonInt(5, 10, ALPHA);
		double[] large = BinomialConfidence.calcClopperPearsonInt(50, 100, ALPHA);
		double smallWidth = small[1] - small[0];
		double largeWidth = large[1] - large[0];
		assertTrue("larger sample should tighten the interval", largeWidth < smallWidth);
	}
}
