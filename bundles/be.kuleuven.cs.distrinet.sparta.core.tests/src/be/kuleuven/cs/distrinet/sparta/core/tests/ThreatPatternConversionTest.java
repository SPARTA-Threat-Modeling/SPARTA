/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.regex.MatchResult;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.patterns.ThreatPatternConversion;

/**
 * Tests for the parameter-token substitution in
 * {@link ThreatPatternConversion#processAndReplaceParams(String)}. The token grammar is
 * {@code <$name$>} with optional dotted attribute segments {@code <$name.attr$>}; group(1)
 * is the name and group(3) is the last (attribute) segment.
 *
 * <p>The match-dependent lookups ({@code processMatch}) are overridden here so the regex
 * itself — which tokens it recognises and how it extracts the name/attribute groups — can
 * be verified without constructing a live VIATRA {@code IPatternMatch}. The end-to-end
 * match-backed substitution is covered by the engine integration test.
 */
public class ThreatPatternConversionTest {

	/** Renders each recognised token as {@code {name}} or {@code {name:attr}} for assertions. */
	private static final class EchoConversion extends ThreatPatternConversion {
		EchoConversion() {
			super(null, null);
		}

		@Override
		protected String processMatch(MatchResult mr) {
			return mr.group(3) != null ? "{" + mr.group(1) + ":" + mr.group(3) + "}" : "{" + mr.group(1) + "}";
		}
	}

	private final EchoConversion conversion = new EchoConversion();

	@Test
	public void nullSourceReturnsNull() {
		assertNull(conversion.processAndReplaceParams(null));
	}

	@Test
	public void textWithoutTokensIsUnchanged() {
		assertEquals("plain description, no tokens", conversion.processAndReplaceParams("plain description, no tokens"));
	}

	@Test
	public void singleNameTokenIsReplaced() {
		assertEquals("{sender}", conversion.processAndReplaceParams("<$sender$>"));
	}

	@Test
	public void tokenIsReplacedInSurroundingText() {
		assertEquals("Data flows from {sender} onward.",
				conversion.processAndReplaceParams("Data flows from <$sender$> onward."));
	}

	@Test
	public void dottedAttributeTokenExposesLastSegment() {
		assertEquals("{location:type}", conversion.processAndReplaceParams("<$location.type$>"));
	}

	@Test
	public void multiSegmentAttributeUsesTheFinalSegment() {
		assertEquals("{a:c}", conversion.processAndReplaceParams("<$a.b.c$>"));
	}

	@Test
	public void multipleAdjacentTokensAreEachReplaced() {
		assertEquals("{x}{y}", conversion.processAndReplaceParams("<$x$><$y$>"));
	}

	@Test
	public void malformedPseudoTokensAreNotMatched() {
		// Empty name, whitespace name, and a trailing dot with no attribute are not valid
		// tokens, so the text is left verbatim rather than being substituted.
		assertEquals("<$$>", conversion.processAndReplaceParams("<$$>"));
		assertEquals("<$ $>", conversion.processAndReplaceParams("<$ $>"));
		assertEquals("<$a.$>", conversion.processAndReplaceParams("<$a.$>"));
	}
}
