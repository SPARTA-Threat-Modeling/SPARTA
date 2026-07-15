/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.analysis.util.RiskBoundaries;

/**
 * Unit tests for the risk-boundary math extracted from
 * {@code ColouredObservableMapLabelProvider#calcRiskBoundaries}.
 * The empty-list case now maps to a {@code max} of 0 (via
 * {@code OptionalDouble#orElse(0)}), which must hit the well-defined fallback
 * scale instead of throwing {@code NoSuchElementException}.
 */
public class RiskBoundariesTest {

	@Test
	public void positiveMaxHalvesToMedian() {
		assertArrayEquals(new double[] { 0, 5000, 10000 }, RiskBoundaries.compute(10000), 1e-9);
		assertArrayEquals(new double[] { 0, 50, 100 }, RiskBoundaries.compute(100), 1e-9);
	}

	@Test
	public void zeroMaxUsesFallbackScale() {
		assertArrayEquals(new double[] { -1, 0, 1 }, RiskBoundaries.compute(0), 1e-9);
	}

	@Test
	public void negativeMaxUsesFallbackScale() {
		assertArrayEquals(new double[] { -1, 0, 1 }, RiskBoundaries.compute(-42), 1e-9);
	}
}
