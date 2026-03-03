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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;
import be.kuleuven.cs.distrinet.sparta.analysis.views.ThreatAnalysis;
import be.kuleuven.cs.distrinet.sparta.io.ThreatCSVWriter;

public class CSVExportHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ThreatAnalysis ta = ThreatAnalysis.getInstance(activeWorkbenchWindow);
		List<ObservableThreat> threats = ta.getThreatList().stream().map(ObservableThreat.class::cast).collect(Collectors.toList());

		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(ta.getLoadedResource().getURI().toPlatformString(true))).getProject();
		
		
		try (ThreatCSVWriter tw = new ThreatCSVWriter(new BufferedWriter(new FileWriter(project.getFile("threats.csv").getLocation().toFile())))) {
			tw.writeHeader();
			tw.write(threats.toArray(new ObservableThreat[] {}));

		} catch (IOException e1) {
			System.err.println(e1);
		}
		return null;
	}

}
