/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.vql;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;

/**
 * Rule-based syntax colorer for the VIATRA query (VQL) pattern language. Highlights
 * keywords, {@code //} and {@code /* *}{@code /} comments, string literals, numbers
 * and {@code @annotations}. This is a lexical highlighter only - it performs no
 * semantic validation (see {@code PatternProcessor} for runtime parsing).
 */
public class VqlTokenScanner extends RuleBasedScanner {

	static final RGB KEYWORD = new RGB(127, 0, 85);
	static final RGB COMMENT = new RGB(63, 127, 95);
	static final RGB STRING = new RGB(42, 0, 255);
	static final RGB ANNOTATION = new RGB(100, 100, 100);
	static final RGB NUMBER = new RGB(0, 100, 120);
	static final RGB DEFAULT = new RGB(0, 0, 0);

	/** VQL / EMFPatternLanguage keywords. */
	private static final String[] KEYWORDS = { "package", "import", "pattern", "private", "shareable", "search",
			"incremental", "find", "neg", "count", "sum", "min", "max", "avg", "or", "check", "eval", "java",
			"epackage" };

	public VqlTokenScanner(VqlColorManager colorManager) {
		IToken keyword = new Token(new TextAttribute(colorManager.getColor(KEYWORD), null, SWT.BOLD));
		IToken comment = new Token(new TextAttribute(colorManager.getColor(COMMENT)));
		IToken string = new Token(new TextAttribute(colorManager.getColor(STRING)));
		IToken annotation = new Token(new TextAttribute(colorManager.getColor(ANNOTATION)));
		IToken number = new Token(new TextAttribute(colorManager.getColor(NUMBER)));
		IToken other = new Token(new TextAttribute(colorManager.getColor(DEFAULT)));

		setDefaultReturnToken(other);

		List<IRule> rules = new ArrayList<>();
		// Comments first so that keywords inside them are not recolored.
		rules.add(new EndOfLineRule("//", comment));
		rules.add(new MultiLineRule("/*", "*/", comment, (char) 0, true));
		// String literals.
		rules.add(new SingleLineRule("\"", "\"", string, '\\'));
		// @-annotations (e.g. @Constraint, @QueryBasedFeature).
		rules.add(new WordRule(new AnnotationDetector(), annotation));
		// Keywords.
		WordRule keywords = new WordRule(new IdentifierDetector(), other);
		for (String k : KEYWORDS) {
			keywords.addWord(k, keyword);
		}
		rules.add(keywords);
		// Numbers.
		rules.add(new NumberRule(number));
		// Whitespace.
		rules.add(new WhitespaceRule(new VqlWhitespaceDetector()));

		setRules(rules.toArray(new IRule[0]));
	}

	private static final class IdentifierDetector implements IWordDetector {
		@Override
		public boolean isWordStart(char c) {
			return Character.isJavaIdentifierStart(c);
		}

		@Override
		public boolean isWordPart(char c) {
			return Character.isJavaIdentifierPart(c);
		}
	}

	private static final class AnnotationDetector implements IWordDetector {
		@Override
		public boolean isWordStart(char c) {
			return c == '@';
		}

		@Override
		public boolean isWordPart(char c) {
			return Character.isJavaIdentifierPart(c) || c == '.';
		}
	}

	private static final class VqlWhitespaceDetector implements IWhitespaceDetector {
		@Override
		public boolean isWhitespace(char c) {
			return c == ' ' || c == '\t' || c == '\n' || c == '\r';
		}
	}

	/** Minimal numeric-literal rule (integers and decimals). */
	private static final class NumberRule implements IRule {
		private final IToken token;

		NumberRule(IToken token) {
			this.token = token;
		}

		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			int c = scanner.read();
			if (c != ICharacterScanner.EOF && Character.isDigit((char) c)) {
				do {
					c = scanner.read();
				} while (c != ICharacterScanner.EOF && (Character.isDigit((char) c) || c == '.'));
				scanner.unread();
				return token;
			}
			scanner.unread();
			return Token.UNDEFINED;
		}
	}
}
