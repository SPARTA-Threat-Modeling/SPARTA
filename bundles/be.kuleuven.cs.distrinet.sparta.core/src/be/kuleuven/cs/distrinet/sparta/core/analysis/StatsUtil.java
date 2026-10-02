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
	 * Validate that an input array is non-null and non-empty; the statistical
	 * operations below are undefined on empty input and would otherwise surface an
	 * obscure {@code NoSuchElementException} from the stream terminal operation.
	 *
	 * @param values - the array to validate
	 * @param operation - the name of the operation, used in the exception message
	 */
	private static void requireNonEmpty(double[] values, String operation) {
		if (values == null || values.length == 0) {
			throw new IllegalArgumentException(operation + " requires a non-empty array");
		}
	}

	/**
	 * Calculate the maximum value in a double[].
	 * @param values - the double[] to use
	 * @return the maximum
	 */
	public static double max(double[] values) {
		requireNonEmpty(values, "max");
		return Arrays.stream(values).reduce(Double::max).getAsDouble();
	}

	/**
	 * Calculate the minimum value in a double[].
	 * @param values - the double[] to use
	 * @return the minimum
	 */
	public static double min(double[] values) {
		requireNonEmpty(values, "min");
		return Arrays.stream(values).reduce(Double::min).getAsDouble();
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
		requireNonEmpty(values, "mode");
		// Guard against a zero (or negative) bin count - e.g. the single-argument
		// mode() computes values.length/100, which is 0 for arrays shorter than 100
		// elements and would make binwidth infinite/NaN.
		final int bins = Math.max(numbins, 1);
		double max = max(values);
		double min = min(values);

		double binwidth = (max - min) / bins;

		// The last bin is right-closed: values equal to max are clamped into bin
		// bins-1 instead of landing in an extra zero-width overflow bin, whose center
		// (min + (bins + 0.5) * binwidth) would exceed the data maximum.
		double[] bincounts = new double[bins];
		Arrays.stream(values).forEach((double v) -> bincounts[Math.min((int) ((v - min) / binwidth), bins - 1)]++);

		return min + ((new ArrayRealVector(bincounts)).getMaxIndex() + 0.5) * binwidth;
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
		requireNonEmpty(valuation, "median");
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
