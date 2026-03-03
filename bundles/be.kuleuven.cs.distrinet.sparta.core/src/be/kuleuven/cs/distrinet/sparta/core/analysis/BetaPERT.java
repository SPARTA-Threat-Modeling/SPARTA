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
		setup(min, mode, max, lambda);
	}
	
	private void setup(double min, double mode, double max, double lambda) {
		if (min > max || mode > max || mode < min)
			throw new IllegalArgumentException("Invalid arguments");
		
		this.min = min;
		range = max - min;
		
		double alpha1 = 1 + lambda * (mode - min)/(max - min);
		double alpha2 = 1 + lambda * (max - mode)/(max - min);
		
		bDist = new BetaDistribution(alpha1, alpha2);
	}
	
	
	public double[] sample(int n) {
		return Arrays.stream(bDist.sample(n)).parallel().map(x -> x * range + min).toArray();
	}
	
}
