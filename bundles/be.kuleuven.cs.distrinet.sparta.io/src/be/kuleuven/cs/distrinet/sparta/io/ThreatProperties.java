/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;

/**
 * Shared factory for the threat-property maps used by both the
 * {@link ThreatWriter} (character-based) and {@link ThreatOutputStream}
 * (byte-based) export hierarchies, so the {@link ModelElement}-to-name unwrapping exists in
 * exactly one place; the default column set comes from {@link ThreatExportColumns#defaults()}.
 *
 * <p>
 * The two factory methods make the single intended difference between the
 * hierarchies explicit:
 * <ul>
 * <li>{@link #forText(Map)} additionally formats {@link Double} values as
 * locale-invariant strings (max. 4 fraction digits, <em>no</em> grouping
 * separators) for text-based outputs such as CSV, where a grouped value like
 * {@code 1,234.5678} would corrupt downstream numeric parsing;</li>
 * <li>{@link #forTypedOutput(Map)} leaves {@link Double} values untouched so
 * that typed sinks (e.g. xlsx numeric cells) receive the raw number.</li>
 * </ul>
 */
final class ThreatProperties {

	private ThreatProperties() {
		// static factory only
	}

	/**
	 * Property map for text-based outputs: {@link ModelElement} results are
	 * unwrapped to their names and {@link Double} results are formatted with a
	 * root-locale, grouping-free {@link NumberFormat} (max. 4 fraction digits).
	 *
	 * @param properties the caller-supplied properties, or {@code null} for the
	 *                   default set
	 * @return a new, mutable property map
	 */
	static LinkedHashMap<String, Function<Threat, ? extends Object>> forText(
			Map<String, Function<Threat, ? extends Object>> properties) {
		LinkedHashMap<String, Function<Threat, ? extends Object>> result = forTypedOutput(properties);
		final NumberFormat nf = NumberFormat.getInstance(Locale.ROOT);
		nf.setMaximumFractionDigits(4);
		// Grouping separators (1,234.5678) would corrupt numeric parsing of the
		// CSV/text exports downstream; emit 1234.5678 instead.
		nf.setGroupingUsed(false);
		for (String key : result.keySet()) {
			result.compute(key, (k, v) -> {
				return v.andThen(o -> ((o instanceof Double) ? nf.format(o) : o));
			});
		}
		return result;
	}

	/**
	 * Property map for typed outputs (e.g. xlsx): {@link ModelElement} results are
	 * unwrapped to their names, but {@link Double} results are deliberately left
	 * as raw numbers so the sink can write typed (numeric) cells.
	 *
	 * @param properties the caller-supplied properties, or {@code null} for the
	 *                   default set
	 * @return a new, mutable property map
	 */
	static LinkedHashMap<String, Function<Threat, ? extends Object>> forTypedOutput(
			Map<String, Function<Threat, ? extends Object>> properties) {
		LinkedHashMap<String, Function<Threat, ? extends Object>> result = new LinkedHashMap<>();
		result.putAll(properties != null ? properties : ThreatExportColumns.defaults());
		for (String key : result.keySet()) {
			result.compute(key, (k, v) -> {
				return v.andThen(o -> ((o instanceof ModelElement) ? ((ModelElement) o).getName() : o));
			});
		}
		return result;
	}

}
