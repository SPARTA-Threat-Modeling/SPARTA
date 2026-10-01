/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.analysis;

import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;

/**
 * A countermeasure the risk calculation applies to a threat, together with the role binding
 * through which it applies (see {@link RiskCalculation#mitigations}).
 *
 * @param binding        the role binding on the threatened element whose role is subjected to
 *                       the countermeasure
 * @param counterMeasure the countermeasure that mitigates the threat's type in its context
 */
public record Mitigation(RoleBinding binding, CounterMeasure counterMeasure) {

	/** @return the solution the binding belongs to, or {@code null} if it is not part of one */
	public Solution solution() {
		return binding.eContainer() instanceof Solution solution ? solution : null;
	}
}
