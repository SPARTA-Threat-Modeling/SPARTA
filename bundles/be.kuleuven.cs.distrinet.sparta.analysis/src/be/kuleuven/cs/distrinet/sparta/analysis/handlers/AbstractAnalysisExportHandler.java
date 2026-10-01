/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;
import be.kuleuven.cs.distrinet.sparta.analysis.service.AnalysisStateSourceProvider;
import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;

/**
 * Base for the export commands. Exports read the current results from
 * {@link ThreatAnalysisService} rather than from the ThreatAnalysis view, so they work from
 * the main menu and toolbar even when the view is closed.
 *
 * <p>The commands are only enabled while results exist (see
 * {@link AnalysisStateSourceProvider}); {@link #checkResultsAvailable(Shell)} is the
 * fallback for a handler executed without consulting enablement.
 */
public abstract class AbstractAnalysisExportHandler extends AbstractHandler {

	/**
	 * @return {@code true} if analysis results are available; otherwise tells the user to run
	 *         the analysis first and returns {@code false}.
	 */
	protected static boolean checkResultsAvailable(Shell shell) {
		if (ThreatAnalysisService.getInstance().hasResults()) {
			return true;
		}
		MessageDialog.openInformation(shell, "No analysis results",
				"There are no analysis results to export. Open a SPARTA model and run Load and Analyze Model first.");
		return false;
	}

	/** @return the project containing the analysed model. Requires results to be available. */
	protected static IProject analysedProject() {
		return ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(ThreatAnalysisService.getInstance().getResource().getURI().toPlatformString(true)))
				.getProject();
	}

	/** @return a snapshot of the current threats. Requires results to be available. */
	protected static List<ObservableThreat> analysedThreats() {
		return new ArrayList<>(ThreatAnalysisService.getInstance().observableThreatList());
	}
}
