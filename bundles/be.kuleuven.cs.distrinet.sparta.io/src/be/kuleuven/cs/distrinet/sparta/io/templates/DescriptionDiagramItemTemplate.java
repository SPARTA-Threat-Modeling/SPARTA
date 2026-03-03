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

import java.io.File;

import org.eclipse.sirius.diagram.ui.business.api.DiagramExportResult;
import org.eclipse.sirius.viewpoint.DRepresentation;

public class DescriptionDiagramItemTemplate extends Template<DRepresentation> {

	protected DescriptionDiagramItemTemplate() {
		super("descriptiondiagram_item.txt");
	}
	
	public static final DescriptionDiagramItemTemplate INSTANCE = new DescriptionDiagramItemTemplate();
	private static final String DIAGRAM_TITLE = "$$DIAGRAM_TITLE$$";

	public static String fill() {
		return INSTANCE.instantiate();
	}

	@Override
	public String instantiate(DRepresentation diagram) {
		String title = diagram.getName();
		
		return getTemplate().replace(DIAGRAM_TITLE, title);
	}
	
	public String instantiate() {
		return getTemplate();
	}

}
