/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Util class to perform some LaTeX escaping for exporting.
 * 
 * @author Laurens
 *
 */
public class LaTeX {
	/**
	 * Helper function to construct a function to escape a latex sequence. This
	 * function can then be concatenated or applied to strings that require
	 * escaping.
	 * 
	 * @param e The pattern that must be escaped.
	 * @param r The replacement.
	 * @return
	 */
	public static Function<String, String> ltxEscape(String e, String r) {
		return (in) -> {
			return in.replaceAll(Pattern.quote(e), Matcher.quoteReplacement(r));
		};
	}

	private static final Function<String, String> ltxEscaper;

	static {
		List<Function<String, String>> funs = new ArrayList<>();
		funs.add(ltxEscape("\\", "\\textbackslash "));
		funs.add(ltxEscape("_", "\\_"));
		funs.add(ltxEscape("&", "\\&"));
		funs.add(ltxEscape("$", "\\$"));
		funs.add(ltxEscape("%", "\\%"));
		funs.add(ltxEscape("#", "\\#"));
		funs.add(ltxEscape("{", "\\{"));
		funs.add(ltxEscape("}", "\\}"));
		funs.add(ltxEscape("~", "\\textasciitilde "));
		ltxEscaper = funs.stream().reduce(Function.identity(), (f1, f2) -> {
			return (i) -> f2.apply(f1.apply(i));
		});
	}

	/**
	 * Escape the LaTeX characters in the provided text.
	 * Currently \,_,&,$,%,#,{,}, and ~ are escaped.
	 * @param text the text which requires escaping.
	 * @return The escaped text.
	 */
	public static String latexEscape(String text) {
		if (text == null || text.isEmpty()) {
			return "";
		}
		return ltxEscaper.apply(text);
	}
}
