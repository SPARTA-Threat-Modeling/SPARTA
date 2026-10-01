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

/** One diagram subsection in the "Diagrams" section: a title plus its (TikZ) body. */
public class DescriptionDiagramItemTemplate extends Template<Object> {

	private static final String TITLE = "$$DIAGRAM_TITLE$$";
	private static final String BODY = "$$DIAGRAM_BODY$$";

	protected DescriptionDiagramItemTemplate() {
		super("descriptiondiagram_item.txt");
	}

	public static final DescriptionDiagramItemTemplate INSTANCE = new DescriptionDiagramItemTemplate();

	public static String fill(String title, String body) {
		return INSTANCE.getTemplate().replace(TITLE, title == null ? "" : title).replace(BODY,
				body == null ? "" : body);
	}

	@Override
	public String instantiate(Object o) {
		return getTemplate();
	}
}
