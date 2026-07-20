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

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Minimal test double for {@link Threat}. It uses the protected
 * {@code Threat(IPatternMatch, IRiskModel)} constructor (which does not run
 * {@code setupBindings}) with {@code null} arguments, then populates the
 * protected {@code threatType}/{@code threatenedElement}/{@code dataFlow} fields
 * directly, so the string/identity helpers on {@link Threat} can be exercised
 * without a live VIATRA match or risk model.
 */
public class StubThreat extends Threat {

	public StubThreat(ThreatType threatType, DFDElement threatenedElement, DataFlow dataFlow) {
		super(null, null);
		this.threatType = threatType;
		this.threatenedElement = threatenedElement;
		this.dataFlow = dataFlow;
	}

	/** Expose the protected static abbreviation helper for direct testing. */
	public static String abbreviate(Object element) {
		return typeAbbreviation(element);
	}
}
