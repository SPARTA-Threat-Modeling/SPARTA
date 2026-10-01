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

import java.util.LinkedHashMap;
import java.util.function.Function;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

/**
 * The column sets shared by the tabular threat exports ({@link ThreatCSVWriter},
 * {@link ThreatXlsxOutputStream}, ...), so that the CSV and XLSX exports have equivalent
 * content. Each call returns a fresh, mutable, ordered map.
 */
public final class ThreatExportColumns {

	private ThreatExportColumns() {
	}

	/** The default columns: threat, location, flow and risk. */
	public static LinkedHashMap<String, Function<Threat, ? extends Object>> defaults() {
		LinkedHashMap<String, Function<Threat, ? extends Object>> properties = new LinkedHashMap<>();
		properties.put("Type", Threat::getThreatTypeName);
		properties.put("Name", Threat::getThreatName);
		properties.put("Location", Threat::getThreatenedElement);
		properties.put("Flow From", Threat::getDataFlowFrom);
		properties.put("Data Flow", Threat::getDataFlow);
		properties.put("Flow To", Threat::getDataFlowTo);
		properties.put("Vulnerability", Threat::getVulnerability);
		properties.put("Risk", Threat::getRisk);
		properties.put("Risk (lower)", Threat::getRisk_lower);
		properties.put("Risk (upper)", Threat::getRisk_upper);
		properties.put("Risk (potential)", Threat::getPotentialRisk);
		return properties;
	}

	/**
	 * The {@link #defaults() default} columns followed by structural metadata from
	 * {@link ThreatMetadata}: trust-boundary crossing and nesting depth, the parents and
	 * enclosing trust boundaries of both flow endpoints, and the solution types mitigating the threat.
	 */
	public static LinkedHashMap<String, Function<Threat, ? extends Object>> withMetadata() {
		LinkedHashMap<String, Function<Threat, ? extends Object>> properties = defaults();
		properties.put("Crosses Trust Boundary", ThreatMetadata::crossesTrustBoundary);
		properties.put("Trust Boundary Depth (min)", ThreatMetadata::minTrustBoundaryDepth);
		properties.put("Trust Boundary Depth (max)", ThreatMetadata::maxTrustBoundaryDepth);
		properties.put("Flow From Parent", t -> ThreatMetadata.parent(t.getDataFlowFrom()));
		properties.put("Flow To Parent", t -> ThreatMetadata.parent(t.getDataFlowTo()));
		properties.put("Flow From Trust Boundaries", t -> ThreatMetadata.trustBoundaryPath(t.getDataFlowFrom()));
		properties.put("Flow To Trust Boundaries", t -> ThreatMetadata.trustBoundaryPath(t.getDataFlowTo()));
		properties.put("Mitigating Solutions", ThreatMetadata::solutions);
		return properties;
	}
}
