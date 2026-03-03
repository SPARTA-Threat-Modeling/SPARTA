/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.patterns;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

public class ThreatPatternMatchMetadata {

	private final ThreatType threatType;
	private final AbstractThreatType ancestor;
	private final ThreatPattern threatPattern;
	
	public ThreatPatternMatchMetadata(ThreatType type, ThreatPattern pattern) {
		this.threatType = type;
		this.threatPattern = pattern;
		this.ancestor = type.getThreatTypeAncestor();
	}

	public ThreatType getThreatType() {
		return threatType;
	}

	public ThreatPattern getThreatPattern() {
		return threatPattern;
	}
	
	public AbstractThreatType getThreatAncestor() {
		return ancestor;
	}
	
}
