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

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/**
 * This class provides a number of simple statistical helper functions.
 * @author Laurens
 *
 */
public class StatsUtil {
	
	private StatsUtil() {}

	/**
	 * Calculate the maximum value in a double[].
	 * @param values - the double[] to use
	 * @return the maximum
	 */
	public static double max(double[] values) {
		return Arrays.stream(values).parallel().reduce(Double::max).getAsDouble();
	}
	
	/**
	 * Calculate the minimum value in a double[].
	 * @param values - the double[] to use
	 * @return the minimum
	 */
	public static double min(double[] values) {
		return Arrays.stream(values).parallel().reduce(Double::min).getAsDouble();
	}
	
	/**
	 * Calculate the mode of a double[].
	 * @param values - the double[] to use
	 * @return the mode
	 */
	public static double mode(double[] values) {
		return mode(values, values.length/100);
	}
	
	/**
	 * Calculate the mode of a double[].
	 * @param values - the double[] to use
	 * @param numbins - the number of bins to use for counting
	 * @return the mode
	 */
	public static double mode(double[] values, int numbins) {
		// Guard against a zero (or negative) bin count - e.g. the single-argument
		// mode() computes values.length/100, which is 0 for arrays shorter than 100
		// elements and would make binwidth infinite/NaN.
		if (numbins < 1) {
			numbins = 1;
		}
		double max = max(values);
		double min = min(values);

		double binwidth = (max - min) / numbins;
		
		double[] bincounts = new double[numbins+1];
		Arrays.stream(values).forEach((double v) -> bincounts[(int) ((v-min)/binwidth)]++ );
		
		return min + ((new ArrayRealVector(bincounts)).getMaxIndex() + 0.5) *binwidth;
	}
	
	/**
	 * Calculate the vulnerability of set of attack attempts.
	 * 
	 * @param tcap - the threat capabilities
	 * @param diffs - the difficulties of the countermeasure
	 * @return a double[] with 0/1 indicating whether the attack attempt was successful or not
	 */
	public static double[] calcVulnerability(double[] tcap, double[] diffs) {
		ArrayRealVector v1 = new ArrayRealVector(tcap);
		ArrayRealVector v2 = new ArrayRealVector(diffs);
		return Arrays.stream(v1.subtract(v2).toArray()).map(x -> x >= 0 ? 1 : 0).toArray();
	}
	
	/**
	 * Calculate the vulnerability of set of attack attempts.
	 * 
	 * @param tcap - the threat capabilities
	 * @param diffs - the difficulties of multiple countermeasures
	 * @return a double[] with 0/1 indicating whether the attack attempt was successful or not
	 */
	public static double[] calcSeqVulnerability(double[] tcap, double[]... diffs) {
		RealMatrix tcapMat = new Array2DRowRealMatrix(diffs.length, tcap.length);
		for (int i = 0;i < diffs.length; i++) {
			tcapMat.setRow(i, tcap);
		}
		RealMatrix diffMat = new Array2DRowRealMatrix(diffs);
		
		RealMatrix vulnMat = tcapMat.subtract(diffMat);

		RealVector vuln = new ArrayRealVector(tcap.length);
		
		for (int i = 0; i < vulnMat.getColumnDimension(); i++) {
			vuln.addToEntry(i, vulnMat.getColumnVector(i).getMinValue() >= 0 ? 1 : 0);
		}
		return vuln.toArray();
	}

	
	/**
	 * Provide the element-by-element multiplication of double[]
	 * @param value1 - first array
	 * @param value2 - second array
	 * @return The element-wise product of the two arrays.
	 */
	public static double[] ebeMult(double[] value1, double[] value2) {
		ArrayRealVector v1 = new ArrayRealVector(value1);
		ArrayRealVector v2 = new ArrayRealVector(value2);
		
		return v1.ebeMultiply(v2).toArray();
		
	}

	/**
	 * Get the median element of a double[]
	 * @param valuation the double[] from which to retrieve the median
	 * @return the median of the double[]
	 */
	public static double median(double[] valuation) {
		if (valuation.length % 2 == 0) {
			return Arrays.stream(valuation).sorted().skip(valuation.length/2L-1).limit(2).average().getAsDouble();
		} else {
			return Arrays.stream(valuation).sorted().skip(valuation.length/2).limit(1).average().getAsDouble();
		}
	}
	
	
	/**
	 * Do a scalar multiplication of a double[] vector.
	 * @param vect - the vector
	 * @param mult - the scalar
	 * @return the scalar product
	 */
	public static double[] scalProd(double[] vect, double mult) {
		return (new ArrayRealVector(vect)).mapMultiply(mult).toArray();
	}
}
