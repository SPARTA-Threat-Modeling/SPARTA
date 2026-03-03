/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.service;

/**
 * Listener interface to be notified of changes to the threat analysis results.
 * @author Laurens
 *
 */
public interface AnalysisListener {

	public void analysisResultsAvailable();
	
	public void invalidatePreviousBindings();
	
}
