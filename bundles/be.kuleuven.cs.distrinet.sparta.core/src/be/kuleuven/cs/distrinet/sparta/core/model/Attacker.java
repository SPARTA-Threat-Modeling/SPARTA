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

import java.util.Comparator;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl;

/**
 * Custom attacker implementation to use when no attacker profiles are specified in the provided model.
 *
 * <p>Values are stored in the generated EMF features via the inherited setters rather than in
 * shadow fields, so reflective access ({@code eGet}) and the typed getters stay consistent, and
 * {@link #getInsider()} returns the model's own (stable) containment list.
 *
 * @author Laurens
 */
public class Attacker extends AttackerProfileImpl implements AttackerProfile {

	/**
	 *  Create a new attacker profile.
	 *
	 * @param name - the name of the attacker profile.
	 * @param tcapMin - the minimum threat capability of the attacker.
	 * @param tcapProb - the most probable threat capability of the attacker.
	 * @param tcapMax - the maximum threat capability of the attacker.
	 * @param tcapConf - the confidence threat capability of the attacker.
	 * @param cfMin - the minimum contact frequency of the attacker.
	 * @param cfProb - the most probable contact frequency of the attacker.
	 * @param cfMax - the maximum contact frequency of the attacker.
	 * @param cfConf - the confidence contact frequency of the attacker.
	 * @param paMin - the minimum probability of action of the attacker.
	 * @param paProb - the most probable probability of action of the attacker.
	 * @param paMax - the maximum probability of action of the attacker.
	 * @param paConf - the confidence probability of action of the attacker.
	 */
	public Attacker(String name, double tcapMin, double tcapProb, double tcapMax, double tcapConf, double cfMin, double cfProb, double cfMax, double cfConf, double paMin, double paProb, double paMax, double paConf) {
		this(name, new CustomEstimate(tcapMin, tcapProb, tcapMax, tcapConf), new CustomEstimate(cfMin, cfProb, cfMax, cfConf), new CustomEstimate(paMin, paProb, paMax, paConf));
	}

	/**
	 * Create a new attacker profile.
	 *
	 * @param name - the name of the attacker profile
	 * @param tcap - an {@link Estimate} specifying the threat capability of the attacker.
	 * @param cf - an {@link Estimate} specifying the contact frequency of the attacker.
	 * @param pa - an {@link Estimate} specifying the probability of action of the attacker.
	 */
	public Attacker(String name, Estimate tcap, Estimate cf, Estimate pa) {
		setName(name);
		setThreatCapability(tcap);
		setContactFrequency(cf);
		setProbabilityOfAction(pa);
	}

	/**
	 * Get a comparator to sort the attackers according to the minimum of their threat capability {@link Estimate}s.
	 * @return the min-based comparator
	 */
	public static Comparator<Attacker> minComparator() {
		return Comparator.comparingDouble(a -> a.getThreatCapability().getMinimum());
	}

}
