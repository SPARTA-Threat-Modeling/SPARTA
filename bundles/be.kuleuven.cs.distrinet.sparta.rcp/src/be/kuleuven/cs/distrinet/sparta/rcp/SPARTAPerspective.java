/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.rcp;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class SPARTAPerspective implements IPerspectiveFactory {

	private static final String PROJECT_EXPLORER = "org.eclipse.ui.navigator.ProjectExplorer";
	private static final String THREAT_ANALYSIS = "be.kuleuven.cs.distrinet.sparta.analysis.views.ThreatAnalysis";
	private static final String PROPERTY_SHEET = "org.eclipse.ui.views.PropertySheet";
	private static final String PROBLEM_VIEW = "org.eclipse.ui.views.ProblemView";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);

		// Project Explorer on the left of the editor area.
		layout.addView(PROJECT_EXPLORER, IPageLayout.LEFT, 0.15f, editorArea);

		// Threat Analysis on the right of the editor area.
		layout.addView(THREAT_ANALYSIS, IPageLayout.RIGHT, 0.66f, editorArea);

		// Property Sheet and Problems stacked in a folder below the editor area.
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.75f, editorArea);
		bottom.addView(PROPERTY_SHEET);
		bottom.addView(PROBLEM_VIEW);
	}

}
