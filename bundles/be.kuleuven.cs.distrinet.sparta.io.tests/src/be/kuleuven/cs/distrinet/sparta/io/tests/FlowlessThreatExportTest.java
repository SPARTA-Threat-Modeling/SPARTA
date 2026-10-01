/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.io.ThreatTextWriter;
import be.kuleuven.cs.distrinet.sparta.io.templates.ThreatItemDiagramTemplate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Regression tests for exporting element-based (flow-less) threats: {@code Threat.dataFlow}
 * is legitimately null for patterns without a data flow parameter (e.g. STRIDE-per-element
 * catalogs), and the exports must not throw for such threats.
 */
public class FlowlessThreatExportTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	private static StubThreat flowlessThreat() {
		ThreatType type = FACTORY.createThreatType();
		type.setName("Elevation of Privilege");
		Process element = FACTORY.createProcess();
		element.setName("AuthService");
		return new StubThreat(type, element, null, new StubRiskModel());
	}

	@Test
	public void fileNameSuggestionHandlesThreatWithoutDataFlow() {
		// The data flow part is simply empty; no NPE on the missing flow.
		assertEquals("Elevation of Privilege_AuthService_.txt",
				ThreatTextWriter.fileNameSuggestion(flowlessThreat()));
	}

	@Test
	public void diagramTemplateRendersElementOnlyDiagramWithoutDataFlow() {
		String diagram = ThreatItemDiagramTemplate.fill(flowlessThreat());

		// An element-only tikz diagram: the threatened element, highlighted, and no
		// leftover placeholders or flow arrow.
		assertTrue(diagram, diagram.contains("\\begin{tikzpicture}"));
		assertTrue(diagram, diagram.contains("process, red"));
		assertTrue(diagram, diagram.contains("AuthService"));
		assertFalse(diagram, diagram.contains("$$"));
		assertFalse(diagram, diagram.contains("\\draw"));
	}
}
