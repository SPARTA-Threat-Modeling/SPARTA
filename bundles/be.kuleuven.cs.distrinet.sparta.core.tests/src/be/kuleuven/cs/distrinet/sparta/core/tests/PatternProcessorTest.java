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

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.patterns.PatternProcessor;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog;

/**
 * Tests for the threat-type-catalog pattern-dependency traversal
 * ({@link PatternProcessor#dependencyOrder}). The recursion previously recursed on the
 * parent catalog instead of the dependency, causing a {@code StackOverflowError} for any
 * catalog with a dependency and never detecting real cycles.
 */
public class PatternProcessorTest {

	private final SpartaModelFactory factory = SpartaModelFactory.eINSTANCE;

	private ThreatTypeCatalog catalog(String pkg) {
		ThreatTypeCatalog c = factory.createThreatTypeCatalog();
		c.setPackage(pkg);
		return c;
	}

	private static Set<ThreatTypeCatalog> nothingProcessed() {
		return new HashSet<>();
	}

	@Test
	public void singleCatalogWithoutDependencies() {
		ThreatTypeCatalog a = catalog("a");
		List<ThreatTypeCatalog> order = PatternProcessor.dependencyOrder(a, nothingProcessed());
		assertEquals(Collections.singletonList(a), order);
	}

	/** A -> B -> C must be processed dependencies first: [C, B, A]. */
	@Test
	public void linearChainIsDependencyFirst() {
		ThreatTypeCatalog a = catalog("a");
		ThreatTypeCatalog b = catalog("b");
		ThreatTypeCatalog c = catalog("c");
		a.getPatternDependencies().add(b);
		b.getPatternDependencies().add(c);

		List<ThreatTypeCatalog> order = PatternProcessor.dependencyOrder(a, nothingProcessed());

		assertEquals(java.util.Arrays.asList(c, b, a), order);
	}

	/** Diamond A -> B, A -> C, B -> D, C -> D: D appears once, before B/C, which precede A. */
	@Test
	public void diamondVisitsSharedDependencyOnce() {
		ThreatTypeCatalog a = catalog("a");
		ThreatTypeCatalog b = catalog("b");
		ThreatTypeCatalog c = catalog("c");
		ThreatTypeCatalog d = catalog("d");
		a.getPatternDependencies().add(b);
		a.getPatternDependencies().add(c);
		b.getPatternDependencies().add(d);
		c.getPatternDependencies().add(d);

		List<ThreatTypeCatalog> order = PatternProcessor.dependencyOrder(a, nothingProcessed());

		assertEquals("each catalog processed exactly once", 4, order.size());
		assertEquals(1, Collections.frequency(order, d));
		assertTrue("D before B", order.indexOf(d) < order.indexOf(b));
		assertTrue("D before C", order.indexOf(d) < order.indexOf(c));
		assertTrue("B before A", order.indexOf(b) < order.indexOf(a));
		assertTrue("C before A", order.indexOf(c) < order.indexOf(a));
	}

	/** A self-dependency is a cycle and must be rejected (previously silently recursed). */
	@Test(expected = IllegalArgumentException.class)
	public void selfCycleIsRejected() {
		ThreatTypeCatalog a = catalog("a");
		a.getPatternDependencies().add(a);
		PatternProcessor.dependencyOrder(a, nothingProcessed());
	}

	/** A two-node cycle A -> B -> A must be rejected rather than overflowing the stack. */
	@Test(expected = IllegalArgumentException.class)
	public void twoNodeCycleIsRejected() {
		ThreatTypeCatalog a = catalog("a");
		ThreatTypeCatalog b = catalog("b");
		a.getPatternDependencies().add(b);
		b.getPatternDependencies().add(a);
		PatternProcessor.dependencyOrder(a, nothingProcessed());
	}

	/** Catalogs already processed (and their dependencies) are skipped. */
	@Test
	public void alreadyProcessedDependencyIsSkipped() {
		ThreatTypeCatalog a = catalog("a");
		ThreatTypeCatalog b = catalog("b");
		a.getPatternDependencies().add(b);

		Set<ThreatTypeCatalog> processed = new HashSet<>();
		processed.add(b);

		List<ThreatTypeCatalog> order = PatternProcessor.dependencyOrder(a, processed);

		assertEquals(Collections.singletonList(a), order);
	}
}
