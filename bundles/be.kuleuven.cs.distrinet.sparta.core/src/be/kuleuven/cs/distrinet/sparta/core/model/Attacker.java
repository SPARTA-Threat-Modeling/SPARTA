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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl;

/**
 * Custom attacker implementation to use when no attacker profiles are specified in the provided model.
 * 
 * @author Laurens
 */
public class Attacker extends AttackerProfileImpl implements AttackerProfile {

	private String name;
	private Estimate threatCapability;
	private Estimate contactFrequency;
	private Estimate probabilityOfAction;
	
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
		this.setName(name);
		this.threatCapability = tcap;
		this.contactFrequency = cf;
		this.probabilityOfAction = pa;
	}
	

	
	/**
	 * Set the name of the attacker profile.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the name of the attacker profile.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get an {@link Estimate} representing the threat capability of the attacker profile.
	 */
	public Estimate getThreatCapability() {
		return threatCapability;
	}

	
	/**
	 * Set the threat capability estimate of the attacker profile.
	 */
	public void setThreatCapability(Estimate threatCapability) {
		this.threatCapability = threatCapability;
	}

	/**
	 * Get an {@link Estimate} representing the contact frequency of the attacker profile.
	 */
	public Estimate getContactFrequency() {
		return contactFrequency;
	}

	/**
	 * Set the contact frequency estimate of the attacker profile.
	 */
	public void setContactFrequency(Estimate contactFrequency) {
		this.contactFrequency = contactFrequency;
	}

	/**
	 * Get an {@link Estimate} representing the probability of action of the attacker profile.
	 */
	public Estimate getProbabilityOfAction() {
		return probabilityOfAction;
	}

	/**
	 * Set the probability of action estimate of the attacker profile.
	 */
	public void setProbabilityOfAction(Estimate probabilityOfAction) {
		this.probabilityOfAction = probabilityOfAction;
	}

	/**
	 * Get a comparator to sort the attackers according to the minimum of their threat capability {@link Estimate}s.
	 * @return the min-based comparator
	 */
	public static Comparator<Attacker> minComparator() {
		return new Comparator<Attacker>() {

			@Override
			public int compare(Attacker o1, Attacker o2) {
				return Double.compare(o1.getThreatCapability().getMinimum(), o2.getThreatCapability().getMinimum());
			}
		};
	}

	/**
	 * Get the list of elements for which this attacker profile is considered to be an insider.
	 * This list if empty by default in this custom attacker profile implementation.
	 */
	@Override
	public EList<DFDElement> getInsider() {
		return new BasicEList<DFDElement>();
	}




}
