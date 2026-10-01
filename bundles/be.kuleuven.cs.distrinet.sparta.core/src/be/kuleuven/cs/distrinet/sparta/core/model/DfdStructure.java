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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;

/**
 * Structural facts about where DFD elements and threats sit in the model: enclosing trust
 * boundaries, nesting depth, direct parents and trust-boundary crossings. Derived purely from
 * the EMF containment hierarchy, so usable by any consumer (view, exports, report, CI).
 *
 * <p>All methods are null-tolerant: when a threat has no data flow (or a flow has no
 * sender/recipient) the corresponding value is {@code null} or empty.</p>
 */
public final class DfdStructure {

	private DfdStructure() {
	}

	/**
	 * The direct DFD parent (trust boundary, or process for a decomposed process) of the given
	 * element, or {@code null} when it sits at the root of the model.
	 */
	public static DFDElement parent(EObject element) {
		if (element == null) {
			return null;
		}
		EObject container = element.eContainer();
		return container instanceof DFDElement ? (DFDElement) container : null;
	}

	/** The trust boundaries enclosing the given element, outermost first. */
	public static List<TrustBoundaryContainer> trustBoundaries(EObject element) {
		if (element == null) {
			return Collections.emptyList();
		}
		List<TrustBoundaryContainer> result = new ArrayList<>();
		for (EObject current = element.eContainer(); current != null; current = current.eContainer()) {
			if (current instanceof TrustBoundaryContainer) {
				result.add(0, (TrustBoundaryContainer) current);
			}
		}
		return result;
	}

	/** The number of trust boundaries enclosing the given element (0 = not inside any). */
	public static int trustBoundaryDepth(EObject element) {
		return trustBoundaries(element).size();
	}

	/**
	 * Whether a flow between the two elements crosses a trust boundary, i.e. they are not
	 * enclosed by exactly the same trust boundaries. This matches the {@code flowContainerDiff}
	 * pattern used by the threat queries for a flow's direct sender and recipient; the pattern
	 * additionally considers the endpoints reached through sender/recipient specifications.
	 */
	public static boolean crossesTrustBoundary(EObject from, EObject to) {
		return !new LinkedHashSet<>(trustBoundaries(from)).equals(new LinkedHashSet<>(trustBoundaries(to)));
	}

	/**
	 * Whether the threat's data flow crosses a trust boundary, see
	 * {@link #crossesTrustBoundary(EObject, EObject)}.
	 *
	 * @return {@code null} when the threat has no flow with both a sender and a recipient
	 */
	public static Boolean crossesTrustBoundary(Threat threat) {
		ModelElement from = threat.getDataFlowFrom();
		ModelElement to = threat.getDataFlowTo();
		if (from == null || to == null) {
			return null;
		}
		return crossesTrustBoundary(from, to);
	}

	/**
	 * The lowest trust-boundary nesting depth among the threat's involved elements: the flow's
	 * sender and recipient, or the threatened element itself when the threat is not tied to a
	 * flow.
	 *
	 * @return {@code null} when there is no involved element
	 */
	public static Integer minTrustBoundaryDepth(Threat threat) {
		return involvedElements(threat).stream().map(DfdStructure::trustBoundaryDepth).min(Integer::compare)
				.orElse(null);
	}

	/** The highest trust-boundary nesting depth among the involved elements, see {@link #minTrustBoundaryDepth}. */
	public static Integer maxTrustBoundaryDepth(Threat threat) {
		return involvedElements(threat).stream().map(DfdStructure::trustBoundaryDepth).max(Integer::compare)
				.orElse(null);
	}

	/**
	 * The elements a threat involves: the data flow's sender and recipient, or the threatened
	 * element itself when the threat is not tied to a flow.
	 */
	public static List<EObject> involvedElements(Threat threat) {
		List<EObject> elements = new ArrayList<>();
		DataFlow flow = threat.getDataFlow();
		if (flow != null) {
			if (threat.getDataFlowFrom() != null) {
				elements.add(threat.getDataFlowFrom());
			}
			if (threat.getDataFlowTo() != null) {
				elements.add(threat.getDataFlowTo());
			}
		} else if (threat.getThreatenedElement() != null) {
			elements.add(threat.getThreatenedElement());
		}
		return elements;
	}
}
