/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.tests;

import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.IRiskModel;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Test double for {@link Threat} used by the writer tests. It uses the protected
 * {@code Threat(IPatternMatch, IRiskModel)} constructor (skipping {@code setupBindings})
 * with a supplied {@link IRiskModel}, then sets the protected model fields directly, so the
 * writers can be exercised against fully controlled values without a live VIATRA match.
 */
public class StubThreat extends Threat {

	public StubThreat(ThreatType threatType, DFDElement threatenedElement, DataFlow dataFlow, IRiskModel riskModel) {
		super(null, riskModel);
		this.threatType = threatType;
		this.threatenedElement = threatenedElement;
		this.dataFlow = dataFlow;
	}
}
