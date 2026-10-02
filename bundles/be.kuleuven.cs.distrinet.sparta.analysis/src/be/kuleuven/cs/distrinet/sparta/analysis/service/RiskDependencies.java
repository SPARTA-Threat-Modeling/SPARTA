/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Asset;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * Which model changes can affect which threats' risk, so that a change recalculates exactly
 * those threats and leaves the (Monte Carlo sampled) figures of all others untouched.
 *
 * <p>A threat depends on its <em>involved objects</em> (see {@link #involvedObjects}) and on
 * everything they contain, such as estimates and annotations. Containment between DFD elements
 * (e.g. a trust boundary containing a process) or between threat types is structure, not data:
 * a change belongs to the nearest enclosing DFD element or threat type only (see
 * {@link #owners}). Matches appearing or disappearing are handled by the query engine itself;
 * this only covers changes to the risk inputs of existing threats.</p>
 */
public final class RiskDependencies {

	private RiskDependencies() {
	}

	/**
	 * The objects a threat's risk depends on: every element of its pattern match (so generic
	 * and custom patterns are covered), the threatened element, the data flow and its endpoints,
	 * the threat type and its enclosing types, and for each involved asset its role bindings,
	 * their roles and all countermeasures of those roles (not only the ones that currently
	 * mitigate, since a change to a countermeasure can make it apply).
	 */
	public static Set<EObject> involvedObjects(Threat threat) {
		Set<EObject> involved = new LinkedHashSet<>();
		IPatternMatch match = threat.getPatternMatch();
		if (match != null) {
			for (String parameter : match.parameterNames()) {
				if (match.get(parameter) instanceof EObject object) {
					involved.add(object);
				}
			}
		}
		addIfPresent(involved, threat.getThreatenedElement());
		addIfPresent(involved, threat.getDataFlow());
		addIfPresent(involved, threat.getDataFlowFrom());
		addIfPresent(involved, threat.getDataFlowTo());
		for (EObject type = threat.getThreatType(); type instanceof AbstractThreatType; type = type.eContainer()) {
			involved.add(type);
		}
		for (EObject object : new ArrayList<>(involved)) {
			if (object instanceof Asset asset) {
				for (RoleBinding binding : asset.getBound()) {
					involved.add(binding);
					Role role = binding.getBinds();
					if (role != null) {
						involved.add(role);
						involved.addAll(role.getSubjected());
					}
				}
			}
		}
		return involved;
	}

	/**
	 * The objects a change to {@code changed} belongs to: {@code changed} itself and its
	 * containers, up to and including the nearest DFD element or threat type.
	 */
	public static List<EObject> owners(EObject changed) {
		List<EObject> owners = new ArrayList<>();
		for (EObject current = changed; current != null; current = current.eContainer()) {
			owners.add(current);
			if (current instanceof DFDElement || current instanceof AbstractThreatType) {
				break;
			}
		}
		return owners;
	}

	/**
	 * Whether a change to {@code changed} can affect every threat: attacker profiles and the
	 * data subject and personal data types feed the risk of all threats.
	 */
	public static boolean affectsAllThreats(EObject changed) {
		for (EObject current = changed; current != null; current = current.eContainer()) {
			if (current instanceof AttackerModel || current instanceof AttackerProfile
					|| current instanceof DataSubjectType || current instanceof DataType) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Whether a notification cannot affect any risk: touches, adapter bookkeeping, and the
	 * presentation-only name and description of model elements.
	 */
	public static boolean isIrrelevant(Notification notification) {
		if (notification.isTouch() || notification.getEventType() == Notification.REMOVING_ADAPTER) {
			return true;
		}
		Object feature = notification.getFeature();
		return feature == SpartaModelPackage.Literals.MODEL_ELEMENT__NAME
				|| feature == SpartaModelPackage.Literals.MODEL_ELEMENT__DESCRIPTION;
	}

	private static void addIfPresent(Set<EObject> set, EObject object) {
		if (object != null) {
			set.add(object);
		}
	}
}
