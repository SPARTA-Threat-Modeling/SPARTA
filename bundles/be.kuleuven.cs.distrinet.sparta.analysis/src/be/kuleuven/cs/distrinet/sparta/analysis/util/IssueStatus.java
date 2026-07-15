/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.util;

/**
 * Pure decision helper for the pattern-diagnostics colouring: a diagnostic with
 * no issue text is considered "resolved" (green), anything else is an error
 * (red). Extracted so the decision can be unit tested without SWT.
 *
 * @author Laurens
 */
public final class IssueStatus {

	private IssueStatus() {
	}

	/**
	 * @param issue the issue text (from {@code Issue.toString()}), may be
	 *              {@code null}
	 * @return {@code true} when there is no issue, i.e. the diagnostic is resolved
	 */
	public static boolean isResolved(String issue) {
		return issue == null || issue.isEmpty();
	}
}
