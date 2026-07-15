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

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.io.convert.YmlToEmfConverter;

/**
 * Tests for {@link YmlToEmfConverter#parseDataFlowEndpoints(String)}. A data-flow
 * entry used to be split blindly on {@code "->"} and indexed
 * with {@code [0]}/{@code [1]}, throwing {@link ArrayIndexOutOfBoundsException}
 * on malformed input. Parsing now validates the separator and endpoints.
 */
public class YmlToEmfConverterTest {

	@Test
	public void parsesSimpleEntry() {
		assertArrayEquals(new String[] { "A", "B" }, YmlToEmfConverter.parseDataFlowEndpoints("A->B"));
	}

	@Test
	public void trimsWhitespaceAroundEndpoints() {
		assertArrayEquals(new String[] { "A", "B" }, YmlToEmfConverter.parseDataFlowEndpoints("  A -> B  "));
	}

	@Test
	public void allowsMultiWordEndpoints() {
		assertArrayEquals(new String[] { "Web Server", "Data Store" },
				YmlToEmfConverter.parseDataFlowEndpoints("Web Server->Data Store"));
	}

	/** An entry without a separator must be rejected, not throw AIOOBE. */
	@Test(expected = IllegalArgumentException.class)
	public void rejectsMissingSeparator() {
		YmlToEmfConverter.parseDataFlowEndpoints("AB");
	}

	/** An entry with more than one separator is ambiguous and rejected. */
	@Test(expected = IllegalArgumentException.class)
	public void rejectsMultipleSeparators() {
		YmlToEmfConverter.parseDataFlowEndpoints("A->B->C");
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsEmptySender() {
		YmlToEmfConverter.parseDataFlowEndpoints("->B");
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsEmptyRecipient() {
		YmlToEmfConverter.parseDataFlowEndpoints("A->");
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsBlankEndpoint() {
		YmlToEmfConverter.parseDataFlowEndpoints("A->   ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsNull() {
		YmlToEmfConverter.parseDataFlowEndpoints(null);
	}
}
