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

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import be.kuleuven.cs.distrinet.sparta.core.analysis.Mitigation;
import be.kuleuven.cs.distrinet.sparta.core.model.DfdStructure;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;

/**
 * Export formatting of a threat's context, used as extra export columns, see
 * {@link ThreatExportColumns#withMetadata()}. The facts themselves come from core: the
 * structure from {@link DfdStructure}, and the mitigating solutions from
 * {@link Threat#getMitigations()}, i.e. exactly the countermeasures the risk calculation
 * applied.
 */
public final class ThreatMetadata {

	private ThreatMetadata() {
	}

	/** The enclosing trust boundaries' names, outermost first, joined with {@code " > "}. */
	public static String trustBoundaryPath(EObject element) {
		return DfdStructure.trustBoundaries(element).stream().map(ModelElement::getName)
				.map(n -> Objects.toString(n, "")).collect(Collectors.joining(" > "));
	}

	/**
	 * The distinct solutions whose countermeasures the risk calculation applied to the threat.
	 * Each solution is reported by the name of its solution type, falling back to the
	 * solution's own name when no type is set.
	 */
	public static Set<String> solutionNames(Threat threat) {
		Set<String> names = new LinkedHashSet<>();
		for (Mitigation mitigation : threat.getMitigations()) {
			Solution solution = mitigation.solution();
			if (solution == null) {
				continue;
			}
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
}
