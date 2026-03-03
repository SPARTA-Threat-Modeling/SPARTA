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

import org.eclipse.sirius.viewpoint.DRepresentation;

public class DescriptionDiagramTemplate extends Template<List<DRepresentation>> {

	protected DescriptionDiagramTemplate() {
		super("descriptiondiagrams.txt");
	}
	
	public static final DescriptionDiagramTemplate INSTANCE = new DescriptionDiagramTemplate();
	private static final String ITEMS = "$$DIAGRAM_ITEMS$$";

	public static String fill() {
		return INSTANCE.instantiate();
	}

	@Override
	public String instantiate(List<DRepresentation> diagrams) {
		if (diagrams.isEmpty()) {
			return "% no diagrams";
		}
		DescriptionDiagramItemTemplate it = new DescriptionDiagramItemTemplate();
		String items = diagrams.stream().map(it::instantiate).collect(Collectors.joining("\n"));
		return getTemplate().replace(ITEMS, items);
	}
	
	public String instantiate() {
		return getTemplate();
	}

}
