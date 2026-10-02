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

import java.util.Arrays;

import org.apache.commons.math3.distribution.BetaDistribution;
import org.apache.commons.math3.random.RandomGenerator;

import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;

/**
 * Implementation of the beta pert distribution as in R, using the beta distribution from the apache commons project.
 * https://cran.r-project.org/web/packages/mc2d/mc2d.pdf
 *
 */
public class BetaPERT {
	
	private double min;
	private double range;
	private BetaDistribution bDist;

	public BetaPERT(Estimate e) {
		this(e.getMinimum(), e.getProbable(), e.getMaximum(), e.getConfidence());
	}
	
	public BetaPERT(double min, double mode, double max) {
		this(min, mode, max, 4);
	}
	
	public BetaPERT(double min, double mode, double max, double lambda) {
		this(min, mode, max, lambda, null);
	}

	/**
	 * Create a BetaPERT distribution that samples through the provided random
	 * generator, enabling deterministic (seeded) sampling in tests.
	 *
	 * @param min - the minimum
	 * @param mode - the most probable value
	 * @param max - the maximum
	 * @param lambda - the confidence in the estimate (must be non-negative)
	 * @param rng - the random generator to sample with, or {@code null} for the
	 *              commons-math default (the previous, unseeded behavior)
	 */
	public BetaPERT(double min, double mode, double max, double lambda, RandomGenerator rng) {
		setup(min, mode, max, lambda, rng);
	}

	private void setup(double min, double mode, double max, double lambda, RandomGenerator rng) {
		if (min > max || mode > max || mode < min)
			throw new IllegalArgumentException("Invalid BetaPERT estimate: expected min <= mode <= max, got min="
					+ min + ", mode=" + mode + ", max=" + max);
		if (lambda < 0)
			throw new IllegalArgumentException(
					"Invalid BetaPERT confidence (lambda): expected a non-negative value, got " + lambda);

		this.min = min;
		range = max - min;

		if (range == 0) {
			// Degenerate estimate (min == max == mode): the distribution is a point
			// mass at min. Skip the beta computation, which would divide by zero and
			// yield NaN samples.
			bDist = null;
			return;
		}

		double alpha1 = 1 + lambda * (mode - min)/(max - min);
		double alpha2 = 1 + lambda * (max - mode)/(max - min);

		bDist = rng == null ? new BetaDistribution(alpha1, alpha2) : new BetaDistribution(rng, alpha1, alpha2);
	}


	public double[] sample(int n) {
		if (bDist == null) {
			// point mass at min (see setup): every sample is exactly min
			double[] result = new double[n];
			Arrays.fill(result, min);
			return result;
		}
		return Arrays.stream(bDist.sample(n)).map(x -> x * range + min).toArray();
	}
	
}
