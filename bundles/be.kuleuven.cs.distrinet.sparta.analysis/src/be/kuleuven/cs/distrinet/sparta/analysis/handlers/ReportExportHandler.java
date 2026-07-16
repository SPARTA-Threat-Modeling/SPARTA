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
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import be.kuleuven.cs.distrinet.sparta.analysis.Activator;
import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;
import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;
import be.kuleuven.cs.distrinet.sparta.io.ReportWriter;

public class ReportExportHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<ObservableThreat> threats = ThreatAnalysisService.getInstance().observableThreatList().stream().map(ObservableThreat.class::cast).collect(Collectors.toList());
		
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(ThreatAnalysisService.getInstance().getResource().getURI().toPlatformString(true))).getProject();
		
		File path = project.getFolder("report").getLocation().toFile();
		
		try {
			(new ReportWriter()).performExport(path, ThreatAnalysisService.getInstance().getResource().getResourceSet(), threats);
		} catch (Exception e1) {
			Activator activator = Activator.getDefault();
			if (activator != null) {
				activator.getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Failed to export the threat report", e1));
			}
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			Shell shell = window != null ? window.getShell() : null;
			MessageDialog.openError(shell, "Report export failed",
					"Could not export the report: " + e1.getMessage());
		}
		return null;
	}


}
