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

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.io.ThreatCSVWriter;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Tests for {@link ThreatCSVWriter#escapeField(String)}: each field
 * must be quoted and embedded double quotes doubled per RFC 4180, so that values
 * containing a quote or the {@code ;} delimiter cannot break the CSV structure.
 * Also covers the end-to-end header and data rows (column set/order, the
 * ModelElement-to-name mapping, locale-invariant number formatting, and escaping).
 */
public class ThreatCSVWriterTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	private static final String HEADER = "\"Type\";\"Name\";\"Location\";\"Flow From\";\"Data Flow\";"
			+ "\"Flow To\";\"Vulnerability\";\"Risk\";\"Risk (lower)\";\"Risk (upper)\";\"Risk (potential)\"";

	@Test
	public void plainValueIsQuoted() {
		assertEquals("\"abc\"", ThreatCSVWriter.escapeField("abc"));
	}

	@Test
	public void emptyValueIsQuoted() {
		assertEquals("\"\"", ThreatCSVWriter.escapeField(""));
	}

	@Test
	public void nullValueBecomesEmptyQuoted() {
		assertEquals("\"\"", ThreatCSVWriter.escapeField(null));
	}

	/** An embedded double quote must be doubled. */
	@Test
	public void embeddedQuoteIsDoubled() {
		assertEquals("\"a\"\"b\"", ThreatCSVWriter.escapeField("a\"b"));
	}

	@Test
	public void multipleEmbeddedQuotesAreDoubled() {
		assertEquals("\"\"\"quoted\"\"\"", ThreatCSVWriter.escapeField("\"quoted\""));
	}

	/** The {@code ;} delimiter inside a value must survive, wrapped in quotes. */
	@Test
	public void embeddedDelimiterIsPreserved() {
		assertEquals("\"a;b\"", ThreatCSVWriter.escapeField("a;b"));
	}

	@Test
	public void embeddedQuoteAndDelimiterTogether() {
		assertEquals("\"a;\"\"b\"\";c\"", ThreatCSVWriter.escapeField("a;\"b\";c"));
	}

	@Test
	public void writeHeaderEmitsTheDefaultColumnSetInOrder() throws IOException {
		StringWriter sw = new StringWriter();
		try (ThreatCSVWriter writer = new ThreatCSVWriter(sw)) {
			writer.writeHeader();
		}
		assertEquals(HEADER + System.lineSeparator(), sw.toString());
	}

	// --- Formula-injection guard (OWASP CSV injection) on data fields ---

	@Test
	public void valueStartingWithEqualsIsFormulaGuarded() {
		assertEquals("\"'=1+2\"", ThreatCSVWriter.escapeFieldValue("=1+2"));
	}

	@Test
	public void valueStartingWithPlusIsFormulaGuarded() {
		assertEquals("\"'+cmd\"", ThreatCSVWriter.escapeFieldValue("+cmd"));
	}

	@Test
	public void valueStartingWithMinusIsFormulaGuarded() {
		assertEquals("\"'-cmd\"", ThreatCSVWriter.escapeFieldValue("-cmd"));
	}

	@Test
	public void valueStartingWithAtIsFormulaGuarded() {
		assertEquals("\"'@SUM(A1)\"", ThreatCSVWriter.escapeFieldValue("@SUM(A1)"));
	}

	@Test
	public void valueStartingWithTabIsFormulaGuarded() {
		assertEquals("\"'\t=1+2\"", ThreatCSVWriter.escapeFieldValue("\t=1+2"));
	}

	@Test
	public void valueStartingWithCarriageReturnIsFormulaGuarded() {
		assertEquals("\"'\r=1+2\"", ThreatCSVWriter.escapeFieldValue("\r=1+2"));
	}

	/**
	 * Documented decision: a negative-looking numeric value such as {@code -5} is
	 * ALSO guarded ({@code '-5}), because {@code -} is a formula trigger and
	 * safety takes precedence. The default numeric columns are unaffected in
	 * practice: risks and vulnerabilities are non-negative, pre-formatted strings.
	 */
	@Test
	public void negativeLookingNumberIsGuardedByDesign() {
		assertEquals("\"'-5\"", ThreatCSVWriter.escapeFieldValue("-5"));
	}

	/** A benign numeric field (no leading trigger character) stays untouched. */
	@Test
	public void benignNumericValueIsNotGuarded() {
		assertEquals("\"1234.5678\"", ThreatCSVWriter.escapeFieldValue("1234.5678"));
	}

	@Test
	public void guardedValueStillGetsRfc4180QuoteEscaping() {
		assertEquals("\"'=a\"\"b\"", ThreatCSVWriter.escapeFieldValue("=a\"b"));
	}

	@Test
	public void nullAndEmptyValuesAreNotGuarded() {
		assertEquals("\"\"", ThreatCSVWriter.escapeFieldValue(null));
		assertEquals("\"\"", ThreatCSVWriter.escapeFieldValue(""));
	}

	/** Headers are exporter-controlled and must stay unguarded. */
	@Test
	public void headerFieldsAreNotFormulaGuarded() {
		assertEquals("\"=Header\"", ThreatCSVWriter.escapeField("=Header"));
	}

	/** End-to-end: a model name starting with a trigger character is guarded in the row. */
	@Test
	public void writeGuardsFieldValuesStartingWithATriggerCharacter() throws IOException {
		ThreatType type = FACTORY.createThreatType();
		type.setName("Spoofing");
		Process sender = FACTORY.createProcess();
		sender.setName("=2+5+cmd|' /C calc'!A0");
		ExternalEntity recipient = FACTORY.createExternalEntity();
		recipient.setName("EE1");
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName("F1");
		flow.setSender(sender);
		flow.setRecipient(recipient);

		StubThreat threat = new StubThreat(type, sender, flow, new StubRiskModel());

		StringWriter sw = new StringWriter();
		try (ThreatCSVWriter writer = new ThreatCSVWriter(sw)) {
			writer.write(threat);
		}

		String expectedRow = "\"Spoofing\";\"Spoofing\";\"'=2+5+cmd|' /C calc'!A0\";\"'=2+5+cmd|' /C calc'!A0\";"
				+ "\"F1\";\"EE1\";\"0.2\";\"20\";\"10\";\"30\";\"100\"";
		assertEquals(expectedRow + System.lineSeparator(), sw.toString());
	}

	/** Risks of 1000 or more must not carry grouping separators (1,234.5678 breaks parsers). */
	@Test
	public void largeRisksAreFormattedWithoutGroupingSeparators() throws IOException {
		ThreatType type = FACTORY.createThreatType();
		type.setName("Spoofing");
		Process sender = FACTORY.createProcess();
		sender.setName("P1");
		ExternalEntity recipient = FACTORY.createExternalEntity();
		recipient.setName("EE1");
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName("F1");
		flow.setSender(sender);
		flow.setRecipient(recipient);

		StubThreat threat = new StubThreat(type, sender, flow, new StubRiskModel() {
			@Override
			public double[] getRisk() {
				return new double[] { 1000, 1234.5678, 987654.321 };
			}
		});

		StringWriter sw = new StringWriter();
		try (ThreatCSVWriter writer = new ThreatCSVWriter(sw)) {
			writer.write(threat);
		}

		String expectedRow = "\"Spoofing\";\"Spoofing\";\"P1\";\"P1\";\"F1\";\"EE1\";"
				+ "\"0.2\";\"1234.5678\";\"1000\";\"987654.321\";\"100\"";
		assertEquals(expectedRow + System.lineSeparator(), sw.toString());
	}

	@Test
	public void writeEmitsAQuotedRowPreservingTheDelimiterInsideAField() throws IOException {
		ThreatType type = FACTORY.createThreatType();
		type.setName("Spoofing");
		Process sender = FACTORY.createProcess();
		sender.setName("P1");
		ExternalEntity recipient = FACTORY.createExternalEntity();
		recipient.setName("EE1");
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName("flow;1"); // embedded delimiter must survive, wrapped in quotes
		flow.setSender(sender);
		flow.setRecipient(recipient);

		StubThreat threat = new StubThreat(type, sender, flow, new StubRiskModel());

		StringWriter sw = new StringWriter();
		try (ThreatCSVWriter writer = new ThreatCSVWriter(sw)) {
			writer.write(threat);
		}

		String expectedRow = "\"Spoofing\";\"Spoofing\";\"P1\";\"P1\";\"flow;1\";\"EE1\";"
				+ "\"0.2\";\"20\";\"10\";\"30\";\"100\"";
		assertEquals(expectedRow + System.lineSeparator(), sw.toString());
	}
}
