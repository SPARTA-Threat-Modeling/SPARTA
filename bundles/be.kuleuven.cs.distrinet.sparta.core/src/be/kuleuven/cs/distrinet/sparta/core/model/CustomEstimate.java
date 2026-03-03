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
 * Custom Estimate implementation, when new estimates need to be created during the analysis.
 * For example, in parameterizing default attacker profiles.
 * 
 * @author Laurens
 */
public class CustomEstimate extends EstimateImpl implements Estimate{

	private final double minimum;
	private final double probable;
	private final double maximum;
	private final double confidence;
	private String name;
	
	
	/**
	 * Create a new custom estimate. This class provides the parameters for the modified PERT distribution.
	 * 
	 * @param min - the minimum
	 * @param prob - the most probable value
	 * @param max - the maximum
	 * @param conf - the confidence in the estimate
	 */
	public CustomEstimate(double min, double prob, double max, double conf) {
		this(min,prob,max,conf,"");
	}
	
	/**
	 * Create a new custom estimate. This class provides the parameters for the modified PERT distribution.
	 * 
	 * @param min - the minimum
	 * @param prob - the most probable value
	 * @param max - the maximum
	 * @param conf - the confidence in the estimate
	 * @param name - the name of the estimate
	 */
	public CustomEstimate(double min, double prob, double max, double conf, String name) {
		this.minimum = min;
		this.probable = prob;
		this.maximum = max;
		this.confidence = conf;
		setName(name);
	}
	
	
	/**
	 * @return the minimum of the estimate
	 */
	public double getMinimum() {
		return minimum;
	}

	/**
	 * @return the most probable value of the estimate
	 */
	public double getProbable() {
		return probable;
	}


	/**
	 * @return the maximum of the estimate
	 */
	public double getMaximum() {
		return maximum;
	}


	/**
	 * @return the confidence in the estimate
	 */
	public double getConfidence() {
		return confidence;
	}

	/**
	 * @return the name of the estimate
	 */
	@Override
	public String getName() {
		return name;
	}


	/**
	 * Set the name of the estimate.
	 * 
	 * @param value - the new name of the estimate.
	 */
	@Override
	public void setName(String value) {
		this.name = value;
		
	}


}
