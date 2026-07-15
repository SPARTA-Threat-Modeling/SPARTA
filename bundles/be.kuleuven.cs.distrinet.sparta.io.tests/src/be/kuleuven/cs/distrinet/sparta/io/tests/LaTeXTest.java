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

import be.kuleuven.cs.distrinet.sparta.io.util.LaTeX;

/**
 * Tests for {@link LaTeX#latexEscape(String)}. Verifies that every
 * LaTeX special character is escaped, including the previously missing
 * {@code ^}, {@code <} and {@code >}.
 */
public class LaTeXTest {

	@Test
	public void nullBecomesEmpty() {
		assertEquals("", LaTeX.latexEscape(null));
	}

	@Test
	public void emptyStaysEmpty() {
		assertEquals("", LaTeX.latexEscape(""));
	}

	@Test
	public void plainTextIsUnchanged() {
		assertEquals("plain text 123", LaTeX.latexEscape("plain text 123"));
	}

	@Test
	public void backslashIsEscaped() {
		assertEquals("a\\textbackslash b", LaTeX.latexEscape("a\\b"));
	}

	@Test
	public void underscoreIsEscaped() {
		assertEquals("a\\_b", LaTeX.latexEscape("a_b"));
	}

	@Test
	public void ampersandIsEscaped() {
		assertEquals("a\\&b", LaTeX.latexEscape("a&b"));
	}

	@Test
	public void dollarIsEscaped() {
		assertEquals("a\\$b", LaTeX.latexEscape("a$b"));
	}

	@Test
	public void percentIsEscaped() {
		assertEquals("a\\%b", LaTeX.latexEscape("a%b"));
	}

	@Test
	public void hashIsEscaped() {
		assertEquals("a\\#b", LaTeX.latexEscape("a#b"));
	}

	@Test
	public void bracesAreEscaped() {
		assertEquals("a\\{b\\}c", LaTeX.latexEscape("a{b}c"));
	}

	@Test
	public void tildeIsEscaped() {
		assertEquals("a\\textasciitilde b", LaTeX.latexEscape("a~b"));
	}

	/** {@code ^} previously left unescaped, breaking LaTeX compilation. */
	@Test
	public void caretIsEscaped() {
		assertEquals("a\\textasciicircum b", LaTeX.latexEscape("a^b"));
	}

	/** {@code <} previously left unescaped. */
	@Test
	public void lessThanIsEscaped() {
		assertEquals("a\\textless b", LaTeX.latexEscape("a<b"));
	}

	/** {@code >} previously left unescaped. */
	@Test
	public void greaterThanIsEscaped() {
		assertEquals("a\\textgreater b", LaTeX.latexEscape("a>b"));
	}

	/**
	 * The backslash replacement itself must not be re-escaped by later rules: a
	 * standalone {@code ^} must not turn its inserted backslash into
	 * {@code \textbackslash}.
	 */
	@Test
	public void replacementsAreNotDoubleEscaped() {
		assertEquals("\\textasciicircum ", LaTeX.latexEscape("^"));
		assertEquals("\\textless ", LaTeX.latexEscape("<"));
		assertEquals("\\textgreater ", LaTeX.latexEscape(">"));
	}

	@Test
	public void combinedSpecialCharacters() {
		assertEquals("50\\%\\_x\\textasciicircum 2", LaTeX.latexEscape("50%_x^2"));
	}
}
