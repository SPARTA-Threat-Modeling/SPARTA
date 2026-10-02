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

import java.util.Map;

/** The "Diagrams" section wrapping one or more diagram items. */
public class DescriptionDiagramsTemplate extends Template<Object> {

	private static final String ITEM = "$$DIAGRAM_ITEM$$";

	private DescriptionDiagramsTemplate() {
		super("descriptiondiagrams.txt");
	}

	public static final DescriptionDiagramsTemplate INSTANCE = new DescriptionDiagramsTemplate();

	public static String fill(String items) {
		return TemplateUtils.substitute(INSTANCE.getTemplate(), Map.of(ITEM, items == null ? "" : items));
	}

	@Override
	public String instantiate(Object o) {
		return getTemplate();
	}
}
