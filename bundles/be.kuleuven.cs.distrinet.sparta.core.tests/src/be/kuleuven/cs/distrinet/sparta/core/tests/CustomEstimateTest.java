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

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.model.CustomEstimate;

/**
 * Tests for {@link CustomEstimate}. Values must land in the generated EMF features (via the
 * inherited setters) so that both the typed getters and reflective {@code eGet} access stay
 * consistent — the point of the class's rewrite to extend {@code EstimateImpl}.
 */
public class CustomEstimateTest {

	private static final double EPS = 1e-9;

	@Test
	public void fullConstructorStoresEveryFeature() {
		CustomEstimate estimate = new CustomEstimate(1.5, 2.5, 4.0, 0.9, "capability");
		assertEquals(1.5, estimate.getMinimum(), EPS);
		assertEquals(2.5, estimate.getProbable(), EPS);
		assertEquals(4.0, estimate.getMaximum(), EPS);
		assertEquals(0.9, estimate.getConfidence(), EPS);
		assertEquals("capability", estimate.getName());
	}

	@Test
	public void shortConstructorDefaultsNameToEmpty() {
		CustomEstimate estimate = new CustomEstimate(0.0, 1.0, 2.0, 0.5);
		assertEquals(0.0, estimate.getMinimum(), EPS);
		assertEquals(1.0, estimate.getProbable(), EPS);
		assertEquals(2.0, estimate.getMaximum(), EPS);
		assertEquals(0.5, estimate.getConfidence(), EPS);
		assertEquals("", estimate.getName());
	}

	@Test
	public void featuresAreReadableReflectivelyViaEmf() {
		CustomEstimate estimate = new CustomEstimate(3.0, 5.0, 7.0, 0.8, "reflective");
		// eGet must agree with the typed getters, confirming values are stored in the
		// generated features rather than in shadow fields.
		assertEquals(3.0, (double) (Double) estimate.eGet(estimate.eClass().getEStructuralFeature("minimum")), EPS);
		assertEquals(7.0, (double) (Double) estimate.eGet(estimate.eClass().getEStructuralFeature("maximum")), EPS);
		assertEquals("reflective", estimate.eGet(estimate.eClass().getEStructuralFeature("name")));
	}
}
