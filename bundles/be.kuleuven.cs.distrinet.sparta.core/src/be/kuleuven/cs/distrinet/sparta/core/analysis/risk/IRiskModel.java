/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.analysis.risk;

import java.util.List;

import be.kuleuven.cs.distrinet.sparta.core.analysis.Mitigation;
import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

/**
 * Risk model interface. The different parts of the risk return double[] arrays
 * as a set of samples may be returned.
 * <p>
 * Index convention: every {@code double[]} returned by the getters below is a
 * three-element interval where index {@code 0} is the lower bound, index
 * {@code 1} is the expected value, and index {@code 2} is the upper bound.
 * <p>
 * The getters are only meaningful after {@link #calculateRisk} has run;
 * implementations may throw an {@link IllegalStateException} when a value is
 * requested before the risk has been calculated.
 *
 * @author Laurens
 *
 */
public interface IRiskModel {

	/**
	 * Calculate the risk for the provided threat.
	 *
	 * @param threat            The threat for which the risk has to be calculated.
	 * @param loopConfiguration the loop configuration (attacker profiles, data
	 *                          types, dfd elements) to iterate over, owned by the
	 *                          analysing {@link be.kuleuven.cs.distrinet.sparta.core.Engine}.
	 */
	public void calculateRisk(Threat threat, RiskAssessmentLoopConfiguration loopConfiguration);

	/**
	 * Whether {@link #calculateRisk} has run, i.e. whether the getters below return values.
	 * Callers that may see uncalculated threats check this rather than catching the
	 * {@link IllegalStateException} the getters may throw.
	 *
	 * @return true once the risk has been calculated
	 */
	public boolean isCalculated();

	/**
	 * Get the vulnerability measured between 0 and 1.
	 * 
	 * @return the vulnerability
	 */
	public double[] getVulnerability();

	/**
	 * Get the risk.
	 * 
	 * @return the risk
	 */
	public double[] getRisk();

	/**
	 * Get the potential risk. This is the risk if fully vulnerable.
	 * 
	 * @return
	 */
	public double getPotentialRisk();

	/**
	 * Get the single loss event.
	 * 
	 * @return the single loss event
	 */
	public double[] getSle();

	/**
	 * Get the threat event frequency
	 * 
	 * @return the threat event frequency
	 */
	public double[] getTef();

	/**
	 * Get the loss event frequency
	 * 
	 * @return the loss event frequency
	 */
	public double[] getLef();

	/**
	 * Get the countermeasures that were applied to reduce the vulnerability, with the role
	 * bindings they apply through.
	 *
	 * @return the mitigations, empty when none apply
	 */
	public List<Mitigation> getMitigations();

}