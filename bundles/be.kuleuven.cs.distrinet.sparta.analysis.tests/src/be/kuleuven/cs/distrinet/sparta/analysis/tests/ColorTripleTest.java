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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.analysis.util.ColorTriple;

/**
 * Unit tests for the pure colour-interpolation logic extracted from
 * {@code ColouredObservableMapLabelProvider}. These cover
 * {@link ColorTriple#validColor()} and {@link ColorTriple#interPol}, which
 * previously lived in a private inner {@code Triple} class and could not be
 * tested in isolation.
 */
public class ColorTripleTest {

	@Test
	public void validColorAcceptsInRangeChannels() {
		assertTrue(new ColorTriple(0, 0, 0).validColor());
		assertTrue(new ColorTriple(255, 255, 255).validColor());
		assertTrue(new ColorTriple(46, 204, 113).validColor());
	}

	@Test
	public void validColorRejectsOutOfRangeChannels() {
		assertFalse(new ColorTriple(-1, 0, 0).validColor());
		assertFalse(new ColorTriple(0, 256, 0).validColor());
		assertFalse(new ColorTriple(0, 0, 300).validColor());
	}

	@Test
	public void interpolationAtZeroReturnsFirstColour() {
		ColorTriple low = new ColorTriple(46, 204, 113);
		ColorTriple med = new ColorTriple(230, 126, 34);
		ColorTriple result = ColorTriple.interPol(low, med, 0.0);
		assertEquals(low, result);
	}

	@Test
	public void interpolationAtOneReturnsSecondColour() {
		ColorTriple low = new ColorTriple(46, 204, 113);
		ColorTriple med = new ColorTriple(230, 126, 34);
		ColorTriple result = ColorTriple.interPol(low, med, 1.0);
		assertEquals(med, result);
	}

	@Test
	public void interpolationAtMidpointBlendsChannels() {
		ColorTriple low = new ColorTriple(46, 204, 113);
		ColorTriple med = new ColorTriple(230, 126, 34);
		ColorTriple result = ColorTriple.interPol(low, med, 0.5);
		// (int) truncation of (0.5*a + 0.5*b) per channel.
		assertEquals(138, result.getX());
		assertEquals(165, result.getY());
		assertEquals(73, result.getZ());
		assertTrue(result.validColor());
	}

	@Test
	public void equalsAndHashCodeAreConsistent() {
		ColorTriple a = new ColorTriple(1, 2, 3);
		ColorTriple b = new ColorTriple(1, 2, 3);
		ColorTriple c = new ColorTriple(3, 2, 1);
		assertEquals(a, b);
		assertEquals(a.hashCode(), b.hashCode());
		assertNotEquals(a, c);
	}
}
