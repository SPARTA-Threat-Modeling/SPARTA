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

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import be.kuleuven.cs.distrinet.sparta.analysis.vql.VqlPatternEditDialog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog;

/**
 * Opens the {@link VqlPatternEditDialog} on the selected {@link ThreatPattern} and, on OK,
 * writes the edited pattern list back through the tree editor's {@link EditingDomain}
 * (so the change is undoable and marks the editor dirty). Falls back to a direct model
 * edit if no editing domain is available.
 */
public class EditVqlPatternHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) {
		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		Object first = selection.getFirstElement();
		if (!(first instanceof ThreatPattern)) {
			return null;
		}
		ThreatPattern pattern = (ThreatPattern) first;

		EditingDomain domain = null;
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (editor instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider) editor).getEditingDomain();
		}

		Shell shell = HandlerUtil.getActiveShell(event);
		VqlPatternEditDialog dialog = new VqlPatternEditDialog(shell, pattern.getName(), buildContext(pattern),
				pattern.getPatterns());
		if (dialog.open() != Window.OK) {
			return null;
		}

		List<String> newPatterns = dialog.getResult();
		if (domain != null) {
			Command cmd = SetCommand.create(domain, pattern, SpartaModelPackage.Literals.THREAT_PATTERN__PATTERNS,
					newPatterns);
			domain.getCommandStack().execute(cmd);
		} else {
			pattern.getPatterns().clear();
			pattern.getPatterns().addAll(newPatterns);
		}
		return null;
	}

	/**
	 * Build the read-only {@code package}/{@code import} preamble from the enclosing
	 * {@link ThreatTypeCatalog}, mirroring what {@code PatternProcessor} prepends when it
	 * parses a pattern body at runtime.
	 */
	private String buildContext(ThreatPattern pattern) {
		EObject container = pattern.eContainer();
		while (container != null && !(container instanceof ThreatTypeCatalog)) {
			container = container.eContainer();
		}
		if (!(container instanceof ThreatTypeCatalog)) {
			return "";
		}
		ThreatTypeCatalog catalog = (ThreatTypeCatalog) container;
		StringBuilder sb = new StringBuilder();
		if (catalog.getPackage() != null && !catalog.getPackage().isBlank()) {
			sb.append("package ").append(catalog.getPackage()).append("\n");
		}
		for (String imp : catalog.getImports()) {
			sb.append(imp).append("\n");
		}
		return sb.toString();
	}
}
