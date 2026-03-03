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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.util.LaTeX;

public class ThreatItemTemplate extends Template<Threat> {
	public ThreatItemTemplate() {
		super("threat_item.txt");
	}

	private static final String NAME = "$$NAME$$";
	private static final String LABEL = "$$LABEL$$";
	private static final String ID = "$$ID$$";
	private static final String TYPE = "$$TYPE$$";
	private static final String DESCRIPTION = "$$DESCRIPTION$$";
	private static final String ELEMENTS = "$$ELEMENTS$$";
	private static final String AFFECTED = "$$AFFECTED$$";
	private static final String RISK = "$$RISK$$";
	private static final String DIAGRAM = "$$DIAGRAM$$";


	public static final ThreatItemTemplate INSTANCE = new ThreatItemTemplate();

	public static String fill(Threat x) {
		return INSTANCE.instantiate(x);
	}

	@Override
	public String instantiate(Threat x) {
		String name = LaTeX.latexEscape(x.getThreatName());
		List<String> els = new ArrayList<>();
		els.add(x.getDataFlowFromName());
		els.add(x.getDataFlowName());
		els.add(x.getDataFlowToName());
		
		return getTemplate().replace(NAME, name)
				.replace(LABEL, x.getThreatenedElementId())
				.replace(ID, x.getThreatenedElementId())
				.replace(DIAGRAM, ThreatItemDiagramTemplate.fill(x))
				.replace(TYPE, LaTeX.latexEscape(x.getThreatTypeName()))
				.replace(DESCRIPTION, LaTeX.latexEscape(x.getDescription()))
				.replace(ELEMENTS, els.stream().map(LaTeX::latexEscape).collect(Collectors.joining(", ")))
				.replace(AFFECTED, x.getThreatenedElementName())
				.replace(RISK, "" + x.getRisk());
	}
	
}
