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

import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.IRiskModel;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

/**
 * Deterministic {@link IRiskModel} test double returning fixed [lower, mid, upper] sample
 * arrays, so the writers can be asserted against exact, stable values. The {@link Threat}
 * getters read index [1] for the point estimate ({@code getRisk}, {@code getVulnerability},
 * …) and indices [0]/[2] for the bounds.
 */
public class StubRiskModel implements IRiskModel {

	@Override
	public void calculateRisk(Threat threat, RiskAssessmentLoopConfiguration loopConfiguration) {
		// no-op: values are fixed below
	}

	@Override
	public double[] getVulnerability() {
		return new double[] { 0.1, 0.2, 0.3 };
	}

	@Override
	public double[] getRisk() {
		return new double[] { 10, 20, 30 };
	}

	@Override
	public double getPotentialRisk() {
		return 100;
	}

	@Override
	public double[] getSle() {
		return new double[] { 1000, 2000, 3000 };
	}

	@Override
	public double[] getTef() {
		return new double[] { 0.5, 1.0, 1.5 };
	}

	@Override
	public double[] getLef() {
		return new double[] { 0.4, 0.8, 1.2 };
	}
}
