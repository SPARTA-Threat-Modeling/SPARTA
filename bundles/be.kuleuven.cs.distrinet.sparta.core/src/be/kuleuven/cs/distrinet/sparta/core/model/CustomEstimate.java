/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.model;

import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EstimateImpl;

/**
 * Custom Estimate implementation, used when new estimates need to be created during the
 * analysis (for example, parameterizing default attacker profiles).
 *
 * <p>Values are stored in the generated EMF features via the inherited setters rather than
 * in shadow fields, so reflective access ({@code eGet}) and the typed getters stay
 * consistent.
 *
 * @author Laurens
 */
public class CustomEstimate extends EstimateImpl implements Estimate {

	/**
	 * Create a new custom estimate. This class provides the parameters for the modified PERT distribution.
	 *
	 * @param min  - the minimum
	 * @param prob - the most probable value
	 * @param max  - the maximum
	 * @param conf - the confidence in the estimate
	 */
	public CustomEstimate(double min, double prob, double max, double conf) {
		this(min, prob, max, conf, "");
	}

	/**
	 * Create a new custom estimate. This class provides the parameters for the modified PERT distribution.
	 *
	 * @param min  - the minimum
	 * @param prob - the most probable value
	 * @param max  - the maximum
	 * @param conf - the confidence in the estimate
	 * @param name - the name of the estimate
	 */
	public CustomEstimate(double min, double prob, double max, double conf, String name) {
		setMinimum(min);
		setProbable(prob);
		setMaximum(max);
		setConfidence(conf);
		setName(name);
	}

}
