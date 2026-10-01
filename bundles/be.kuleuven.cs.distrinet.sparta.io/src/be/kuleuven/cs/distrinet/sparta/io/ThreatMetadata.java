/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskCalculation;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;

/**
 * Structural metadata about a threat's context in the DFD (trust boundaries, nesting,
 * parents, relevant solutions), derived purely from the EMF containment hierarchy. Used as
 * extra export columns, see {@link ThreatExportColumns#withMetadata()}.
 *
 * <p>All methods are null-tolerant: when a threat has no data flow (or a flow has no
 * sender/recipient) the corresponding value is {@code null} or empty, which the writers
 * export as an empty cell.</p>
 */
public final class ThreatMetadata {

	private ThreatMetadata() {
	}

	/**
	 * Whether the threat's data flow crosses a trust boundary, i.e. the sender and the
	 * recipient are not enclosed by exactly the same trust boundaries. This mirrors the
	 * {@code flowContainerDiff} pattern used by the threat queries.
	 *
	 * @return {@code null} when the threat has no flow with both a sender and a recipient
	 */
	public static Boolean crossesTrustBoundary(Threat threat) {
		ModelElement from = threat.getDataFlowFrom();
		ModelElement to = threat.getDataFlowTo();
		if (from == null || to == null) {
			return null;
		}
		return !new LinkedHashSet<>(trustBoundaries(from)).equals(new LinkedHashSet<>(trustBoundaries(to)));
	}

	/**
	 * The lowest trust-boundary nesting depth among the involved elements (0 = not inside
	 * any trust boundary). The involved elements are the flow's sender and recipient, or the
	 * threatened element itself when the threat is not tied to a flow.
	 */
	public static Integer minTrustBoundaryDepth(Threat threat) {
		return involvedEndpoints(threat).stream().map(e -> trustBoundaries(e).size()).min(Integer::compare)
				.orElse(null);
	}

	/** The highest trust-boundary nesting depth among the involved elements, see {@link #minTrustBoundaryDepth}. */
	public static Integer maxTrustBoundaryDepth(Threat threat) {
		return involvedEndpoints(threat).stream().map(e -> trustBoundaries(e).size()).max(Integer::compare)
				.orElse(null);
	}

	/**
	 * The direct DFD parent (trust boundary, or process for a decomposed process) of the
	 * given element, or {@code null} when it sits at the root of the model.
	 */
	public static DFDElement parent(EObject element) {
		if (element == null) {
			return null;
		}
		EObject container = element.eContainer();
		return container instanceof DFDElement ? (DFDElement) container : null;
	}

	/**
	 * The trust boundaries enclosing the given element, outermost first.
	 */
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

	/** The enclosing trust boundaries' names, outermost first, joined with {@code " > "}. */
	public static String trustBoundaryPath(EObject element) {
		return trustBoundaries(element).stream().map(ModelElement::getName).map(n -> Objects.toString(n, ""))
				.collect(Collectors.joining(" > "));
	}

	/**
	 * The distinct solutions relevant to the threat: those with a role bound to the threatened
	 * element whose countermeasures mitigate the threat's type within the threat's data flow.
	 * This is the same selection the risk calculation uses to reduce the vulnerability (see
	 * {@link RiskCalculation#mitigates} and {@link RiskCalculation#isInScope}), so threat types
	 * are matched through composites, super types and id-only references alike. Each solution
	 * is reported by the name of its solution type, falling back to the solution's own name
	 * when no type is set.
	 */
	public static Set<String> solutionNames(Threat threat) {
		Set<String> names = new LinkedHashSet<>();
		DFDElement element = threat.getThreatenedElement();
		ThreatType type = threat.getThreatType();
		if (element == null || type == null) {
			return names;
		}
		for (RoleBinding binding : element.getBound()) {
			if (!(binding.eContainer() instanceof Solution) || binding.getBinds() == null) {
				continue;
			}
			boolean relevant = binding.getBinds().getSubjected().stream()
					.anyMatch(cm -> RiskCalculation.mitigates(cm, type) && RiskCalculation.isInScope(cm, threat.getDataFlow()));
			if (!relevant) {
				continue;
			}
			Solution solution = (Solution) binding.eContainer();
			String name = solution.getSecuritypattern() != null ? solution.getSecuritypattern().getName()
					: solution.getName();
			if (name != null && !name.isEmpty()) {
				names.add(name);
			}
		}
		return names;
	}

	/** {@link #solutionNames} joined with {@code ", "}. */
	public static String solutions(Threat threat) {
		return String.join(", ", solutionNames(threat));
	}

	private static List<EObject> involvedEndpoints(Threat threat) {
		List<EObject> endpoints = new ArrayList<>();
		DataFlow flow = threat.getDataFlow();
		if (flow != null) {
			if (threat.getDataFlowFrom() != null) {
				endpoints.add(threat.getDataFlowFrom());
			}
			if (threat.getDataFlowTo() != null) {
				endpoints.add(threat.getDataFlowTo());
			}
		} else if (threat.getThreatenedElement() != null) {
			endpoints.add(threat.getThreatenedElement());
		}
		return endpoints;
	}
}
