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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.analysis.BetaPERT;

/**
 * Tests for {@link BetaPERT}, in particular the degenerate (min == max) boundary
 * that previously divided by zero and produced NaN samples.
 */
public class BetaPERTTest {

	private static final int N = 1000;

	/**
	 * Regression: min == max == mode must not divide by zero. The distribution
	 * degenerates to a point mass at min, so every sample equals min and none is NaN.
	 */
	@Test
	public void pointMassWhenMinEqualsMax() {
		double[] samples = new BetaPERT(5, 5, 5).sample(N);
		assertEquals(N, samples.length);
		for (double v : samples) {
			assertFalse("degenerate estimate must not yield NaN", Double.isNaN(v));
			assertEquals(5.0, v, 0.0);
		}
	}

	/**
	 * Regression: the null-difficulty countermeasure substitute is
	 * {@code CustomEstimate(100, 100, 100, 100)} - a degenerate estimate. It must
	 * yield an all-100 sample (an "impenetrable" countermeasure), not NaN.
	 */
	@Test
	public void pointMassAtHundred() {
		double[] samples = new BetaPERT(100, 100, 100, 100).sample(N);
		for (double v : samples) {
			assertEquals(100.0, v, 0.0);
		}
	}

	/** A non-degenerate estimate produces finite samples within [min, max]. */
	@Test
	public void samplesWithinBounds() {
		double min = 2;
		double max = 10;
		double[] samples = new BetaPERT(min, 6, max).sample(N);
		for (double v : samples) {
			assertFalse(Double.isNaN(v));
			assertTrue("sample >= min", v >= min - 1e-9);
			assertTrue("sample <= max", v <= max + 1e-9);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsMinGreaterThanMax() {
		new BetaPERT(10, 5, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsModeAboveMax() {
		new BetaPERT(0, 20, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsModeBelowMin() {
		new BetaPERT(5, 1, 10);
	}
}
