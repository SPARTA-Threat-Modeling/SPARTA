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
import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import be.kuleuven.cs.distrinet.sparta.analysis.Activator;
import be.kuleuven.cs.distrinet.sparta.analysis.views.ThreatAnalysis;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatExportColumns;

/**
 * Exports the threats currently shown in the {@link ThreatAnalysis} view to a table file in
 * the root of the analysed model's project. Subclasses only provide the file name and the
 * writer, so the CSV and XLSX exports share the same columns
 * ({@link ThreatExportColumns#withMetadata()}) and user feedback.
 */
public abstract class AbstractThreatTableExportHandler extends AbstractHandler {

	/** @return the name of the file to create in the project root, e.g. {@code threats.csv} */
	protected abstract String fileName();

	/** @return a short format label used in messages, e.g. {@code CSV} */
	protected abstract String formatName();

	/** Write the threats to {@code file}, using {@link ThreatExportColumns#withMetadata()}. */
	protected abstract void export(File file, Threat[] threats) throws IOException;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ThreatAnalysis ta = ThreatAnalysis.getInstance(activeWorkbenchWindow);
		List<? extends Threat> threats = ta.getThreatList();

		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(ta.getLoadedResource().getURI().toPlatformString(true))).getProject();

		IFile outFile = project.getFile(fileName());
		boolean exported = false;
		try {
			export(outFile.getLocation().toFile(), threats.toArray(new Threat[] {}));
			exported = true;
		} catch (IOException e1) {
			Activator activator = Activator.getDefault();
			if (activator != null) {
				activator.getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Failed to export threats to " + formatName(), e1));
			}
			MessageDialog.openError(activeWorkbenchWindow.getShell(), formatName() + " export failed",
					"Could not write " + fileName() + ": " + e1.getMessage());
		}

		if (exported) {
			// Surface the new file in the workspace and tell the user where it landed.
			try {
				outFile.refreshLocal(IResource.DEPTH_ZERO, null);
			} catch (CoreException ignore) {
				// non-fatal: the file is written, only the workspace view is stale
			}
			MessageDialog.openInformation(activeWorkbenchWindow.getShell(), formatName() + " export complete",
					threats.size() + " threat(s) exported to:\n" + outFile.getFullPath().toString());
		}
		return null;
	}

}
