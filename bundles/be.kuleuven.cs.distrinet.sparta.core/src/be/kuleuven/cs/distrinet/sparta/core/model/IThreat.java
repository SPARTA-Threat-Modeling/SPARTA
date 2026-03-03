/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
/**
 * 
 */
package be.kuleuven.cs.distrinet.sparta.core.model;

/**
 * High-level threat description.
 * 
 * @author Laurens
 *
 */
public interface IThreat {
	
	String getThreatTypeName();
	String getThreatName();
	String getDescription();

	Double getVulnerability();

	Double getRisk();

	Double getPotentialRisk();

	String getThreatenedElementName();
	
	String getThreatenedElementTypeName();
	
	String getThreatenedElementId();

}