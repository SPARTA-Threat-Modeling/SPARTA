/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.threatanalysis.tests;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Test double for {@link Threat} used by the aggregation tests. It skips {@code
 * setupBindings} via the protected {@code Threat(IPatternMatch, IRiskModel)} constructor,
 * sets the threat type / threatened element directly, and returns fixed per-instance risk
 * values (overriding the risk-model-backed getters) so distributions across a collection
 * can be asserted deterministically.
 */
public class StubThreat extends Threat {

	private final double risk;
	private final double potentialRisk;

	public StubThreat(ThreatType threatType, DFDElement threatenedElement, double risk, double potentialRisk) {
		super(null, null);
		this.threatType = threatType;
		this.threatenedElement = threatenedElement;
		this.risk = risk;
		this.potentialRisk = potentialRisk;
	}

	@Override
	public Double getRisk() {
		return risk;
	}

	@Override
	public Double getPotentialRisk() {
		return potentialRisk;
	}
}
