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

import java.util.List;
import java.util.stream.Collectors;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import static be.kuleuven.cs.distrinet.sparta.io.templates.TemplateUtils.BY_RISK;

public class ThreatsTemplate extends Template<List<? extends Threat>> {
	public ThreatsTemplate() {
		super("threats.txt");
	}

	private static final String ITEMS = "$$THREAT_ITEMS$$";
	private static final String TYPE = "$$TYPE$$";
	
	public static final ThreatsTemplate INSTANCE = new ThreatsTemplate();


	@Override
	public String instantiate(List<? extends Threat> threats) {
		if (threats.isEmpty()) {
			return "% no threats";
		}
		ThreatItemTemplate it = new ThreatItemTemplate();
		String items = threats.stream().sorted(BY_RISK.reversed()).map(it::instantiate).collect(Collectors.joining("\n"));
		String type = threats.stream().findAny().get().getThreatTypeName();
		return getTemplate().replace(TYPE,type).replace(ITEMS, items);
	}


	public static String fill(List<? extends Threat> list) {
		return INSTANCE.instantiate(list);
	}
}