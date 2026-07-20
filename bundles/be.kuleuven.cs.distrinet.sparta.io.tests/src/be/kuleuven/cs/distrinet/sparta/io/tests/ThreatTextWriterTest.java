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
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.io.ThreatTextWriter;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Tests for {@link ThreatTextWriter}: the filename suggestion (which sanitizes non-word
 * runs) and the {@code key:\tvalue} line output, including the risk-model-backed numeric
 * columns formatted through the writer's locale-invariant {@code NumberFormat}.
 */
public class ThreatTextWriterTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	private static ThreatType threatType(String name) {
		ThreatType t = FACTORY.createThreatType();
		t.setName(name);
		return t;
	}

	private static Process process(String name) {
		Process p = FACTORY.createProcess();
		p.setName(name);
		return p;
	}

	@Test
	public void fileNameSuggestionCollapsesNonWordRunsAndAppendsExtension() {
		ThreatType type = threatType("Info Disclosure");
		Process element = process("DB#1");
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName("X->Y");

		StubThreat threat = new StubThreat(type, element, flow, new StubRiskModel());

		// Fields are joined with '_' (a word char, kept), then every run of non-word
		// characters (space, '#', '->') collapses to a single space; '.txt' is appended.
		assertEquals("Info Disclosure_DB 1_X Y.txt", ThreatTextWriter.fileNameSuggestion(threat));
	}

	@Test
	public void writeEmitsKeyTabValueLinesIncludingFormattedRiskColumns() throws IOException {
		ThreatType type = threatType("Spoofing");
		Process sender = process("P1");
		ExternalEntity recipient = FACTORY.createExternalEntity();
		recipient.setName("EE1");
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName("login");
		flow.setSender(sender);
		flow.setRecipient(recipient);

		StubThreat threat = new StubThreat(type, sender, flow, new StubRiskModel());

		StringWriter sw = new StringWriter();
		try (ThreatTextWriter writer = new ThreatTextWriter(sw)) {
			writer.write(threat);
		}
		String out = sw.toString();

		assertTrue(out, out.contains("Type:\tSpoofing"));
		assertTrue(out, out.contains("Location:\tP1"));
		assertTrue(out, out.contains("Flow From:\tP1"));
		assertTrue(out, out.contains("Data Flow:\tlogin"));
		assertTrue(out, out.contains("Flow To:\tEE1"));
		// Numeric columns read index [1] of the risk model arrays and are formatted with a
		// locale-invariant NumberFormat (decimal point, no grouping, trailing zeros dropped).
		assertTrue(out, out.contains("Vulnerability:\t0.2"));
		assertTrue(out, out.contains("Risk:\t20"));
		assertTrue(out, out.contains("Risk (potential):\t100"));
	}
}
