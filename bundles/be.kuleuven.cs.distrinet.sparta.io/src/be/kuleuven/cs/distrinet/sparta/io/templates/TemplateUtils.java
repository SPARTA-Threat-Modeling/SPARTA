/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.templates;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

public class TemplateUtils {

	public static final Comparator<? super Threat> BY_NAME = Comparator
			.comparing(e -> (e.toString() != null ? e.toString().toLowerCase(Locale.ROOT) : ""));
	/** By risk, ascending; a threat whose risk was not calculated sorts as risk 0. */
	public static final Comparator<? super Threat> BY_RISK = Comparator
			.comparing(e -> (e.isRiskCalculated() && e.getRisk() != null ? e.getRisk() : 0d));
	public static final Comparator<Threat> BY_TYPE_NAME = Comparator
			.comparing(e -> (e.getThreatTypeName() != null ? e.getThreatTypeName().toLowerCase(Locale.ROOT) : ""));

	private static final Pattern PLACEHOLDER = Pattern.compile("\\$\\$[A-Z_]+\\$\\$");

	/**
	 * Read a template resource from the bundle's {@code templates/} folder.
	 *
	 * @param filename the template file name, e.g. {@code "report.txt"}
	 * @return the template text
	 * @throws UncheckedIOException if the resource is missing or unreadable, so
	 *                              the failure propagates to the caller instead
	 *                              of silently embedding an error marker in the
	 *                              generated report
	 */
	public static String readTemplate(String filename) {
		String resource = "templates/" + filename;
		try (InputStream file = Template.class.getClassLoader().getResourceAsStream(resource)) {
			if (file == null) {
				throw new UncheckedIOException(new IOException("Template resource not found: " + resource));
			}
			return IOUtils.toString(file, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new UncheckedIOException("Could not read template: " + resource, e);
		}
	}

	/**
	 * Fill in every {@code $$PLACEHOLDER$$} occurrence in a single pass. Unlike
	 * chained {@link String#replace}, substituted values are never re-scanned,
	 * so a value that itself contains a placeholder-like string (e.g. an element
	 * named {@code $$TYPE$$}) is not expanded again, and the template text is
	 * copied only once. Placeholders without an entry in the map are left as-is.
	 *
	 * @param template     the template text
	 * @param replacements placeholder (including the {@code $$} delimiters) to
	 *                     replacement value
	 * @return the instantiated text
	 */
	public static String substitute(String template, Map<String, String> replacements) {
		Matcher matcher = PLACEHOLDER.matcher(template);
		StringBuilder result = new StringBuilder();
		while (matcher.find()) {
			String replacement = replacements.get(matcher.group());
			matcher.appendReplacement(result,
					Matcher.quoteReplacement(replacement != null ? replacement : matcher.group()));
		}
		matcher.appendTail(result);
		return result.toString();
	}
}
