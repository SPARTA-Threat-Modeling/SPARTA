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

import java.io.File;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import be.kuleuven.cs.distrinet.sparta.analysis.Activator;
import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;
import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;
import be.kuleuven.cs.distrinet.sparta.io.ReportWriter;

public class ReportExportHandler extends AbstractAnalysisExportHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		if (!checkResultsAvailable(shell)) {
			return null;
		}
		List<ObservableThreat> threats = analysedThreats();
		IProject project = analysedProject();

		IFolder reportFolder = project.getFolder("report");
		File path = reportFolder.getLocation().toFile();

		boolean exported = false;
		try {
			ReportWriter writer = new ReportWriter();
			// Reuse the diagram layout the user arranged in the Sirius editor by handing the
			// project's .aird to the (headless) report generator.
			File aird = findAird(project);
			if (aird != null) {
				writer.setAird(aird);
			}
			writer.performExport(path, ThreatAnalysisService.getInstance().getResource().getResourceSet(), threats);
			exported = true;
		} catch (Exception e1) {
			Activator activator = Activator.getDefault();
			if (activator != null) {
				activator.getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Failed to export the threat report", e1));
			}
			MessageDialog.openError(shell, "Report export failed",
					"Could not export the report: " + e1.getMessage());
		}

		if (exported) {
			// Surface the report folder in the workspace and tell the user where it landed.
			try {
				reportFolder.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException ignore) {
				// non-fatal: the report is written, only the workspace view is stale
			}
			MessageDialog.openInformation(shell, "Report export complete",
					"Threat report exported to:\n" + reportFolder.getFullPath().toString());
		}
		return null;
	}

	/**
	 * Find the first {@code .aird} representations file in the project (its layout feeds the
	 * report's Data Flow Diagram). Returns {@code null} if none is found or on any error - the
	 * report is still generated, just without the diagram.
	 */
	private File findAird(IProject project) {
		try {
			File[] found = new File[1];
			project.accept(resource -> {
				if (found[0] != null) {
					return false;
				}
				if (resource.getType() == IResource.FILE && "aird".equals(resource.getFileExtension())) {
					found[0] = resource.getLocation().toFile();
					return false;
				}
				return true;
			});
			return found[0];
		} catch (CoreException e) {
			return null;
		}
	}

}
