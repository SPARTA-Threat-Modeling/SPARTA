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

import org.apache.commons.math3.distribution.BetaDistribution;

/**
 * Calculate Clopper-Pearson interval using beta-distribution
 * @author laurens
 *
 */
public class BinomialConfidence {
	
	private BinomialConfidence() {}
	
	/**
	 * Calculate Clopper-Pearson interval using the beta-distribution.
	 * 
	 * @param successes - the number of successes in the experiment.
	 * @param sampleSize - the sample size
	 * @param alpha - the confidence, for example for 95%, provide an alpha of 0.05.
	 * @return a double[] with the interval boundaries at indices 0 and 1.
	 */
	public static double[] calcClopperPearsonInt(double  successes, double sampleSize, double alpha) {
		if (successes == 0)
			return new double[] {0, 1.0- Math.pow(alpha/2, 1/sampleSize) };
		else if (successes == sampleSize)
			return new double[] {Math.pow(alpha/2, 1/sampleSize), 1.0};
		
		double[] confInt = new double[2];
		
		BetaDistribution bdMin = new BetaDistribution(successes, sampleSize - successes + 1);
		BetaDistribution bdMax = new BetaDistribution(successes + 1, sampleSize - successes);
		
		confInt[0] = bdMin.inverseCumulativeProbability(alpha/2);
		confInt[1] = bdMax.inverseCumulativeProbability(1 - alpha/2);
		
		
		return confInt;
	}

}
