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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.analysis.util.IssueStatus;

/**
 * Unit tests for the fixed pattern-diagnostics colouring decision.
 * The old code compared issue strings with {@code ==}, so the "no issue" (green)
 * branch was dead and every row was coloured red. The extracted
 * {@link IssueStatus#isResolved(String)} uses value equality / emptiness.
 */
public class IssueStatusTest {

	@Test
	public void nullIssueIsResolved() {
		assertTrue(IssueStatus.isResolved(null));
	}

	@Test
	public void emptyIssueIsResolved() {
		assertTrue(IssueStatus.isResolved(""));
	}

	@Test
	public void nonEmptyIssueIsNotResolved() {
		assertFalse(IssueStatus.isResolved("some parse error"));
	}

	/**
	 * A string built at runtime (not interned) that equals the empty string must
	 * still be treated as resolved. Under the old {@code == ""} check this
	 * returned {@code false}, which is exactly the regression this guards against.
	 */
	@Test
	public void runtimeConstructedEmptyStringIsResolved() {
		String issue = new StringBuilder().toString();
		assertTrue(IssueStatus.isResolved(issue));
	}
}
