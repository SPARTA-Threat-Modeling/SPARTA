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

import static be.kuleuven.cs.distrinet.sparta.io.templates.TemplateUtils.BY_RISK;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.util.LaTeX;

public class ThreatsTemplate extends Template<List<? extends Threat>> {
	private ThreatsTemplate() {
		super("threats.txt");
	}

	private static final String ITEMS = "$$THREAT_ITEMS$$";
	private static final String TYPE = "$$TYPE$$";

	public static final ThreatsTemplate INSTANCE = new ThreatsTemplate();

	public static String fill(List<? extends Threat> list) {
		return INSTANCE.instantiate(list);
	}

	@Override
	public String instantiate(List<? extends Threat> threats) {
		if (threats.isEmpty()) {
			return "% no threats";
		}
		String items = threats.stream().sorted(BY_RISK.reversed()).map(ThreatItemTemplate::fill)
				.collect(Collectors.joining("\n"));
		// The type name ends up in \section{...}, so it needs the same LaTeX
		// escaping as the per-threat fields.
		String type = LaTeX.latexEscape(threats.get(0).getThreatTypeName());
		return TemplateUtils.substitute(getTemplate(), Map.of(TYPE, type, ITEMS, items));
	}
}
