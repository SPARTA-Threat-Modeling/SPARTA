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
 * Pure computation of the {min, med, max} risk boundaries used to drive the
 * colour scale of the threat list. Extracted to be unit testable and to make
 * the empty-list / non-positive fallback explicit.
 *
 * @author Laurens
 */
public final class RiskBoundaries {

	private RiskBoundaries() {
	}

	/**
	 * Computes the colour-scale boundaries for a given maximum potential risk.
	 *
	 * @param max the maximum potential risk over all threats (0 when the list is
	 *            empty)
	 * @return a {@code {min, med, max}} array; a fixed {@code {-1, 0, 1}} fallback
	 *         is returned when {@code max <= 0} to keep the scale well defined
	 */
	public static double[] compute(double max) {
		if (max <= 0) {
			return new double[] { -1, 0, 1 };
		}
		double min = 0;
		double med = (min + max) / 2;
		return new double[] { min, med, max };
	}
}
