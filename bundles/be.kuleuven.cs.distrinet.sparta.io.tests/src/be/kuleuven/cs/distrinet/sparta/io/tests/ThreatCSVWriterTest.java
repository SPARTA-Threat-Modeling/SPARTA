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

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.io.ThreatCSVWriter;

/**
 * Tests for {@link ThreatCSVWriter#escapeField(String)}: each field
 * must be quoted and embedded double quotes doubled per RFC 4180, so that values
 * containing a quote or the {@code ;} delimiter cannot break the CSV structure.
 */
public class ThreatCSVWriterTest {

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
}
