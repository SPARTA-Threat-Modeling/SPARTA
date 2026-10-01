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
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import be.kuleuven.cs.distrinet.sparta.analysis.vql.VqlPatternEditDialog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog;

/**
 * Opens the {@link VqlPatternEditDialog} on the selected {@link ThreatPattern} and, on OK,
 * writes the edited pattern list back through the {@link EditingDomain} that owns the
 * pattern, so the change is undoable and marks the owner dirty.
 *
 * <p>The domain is resolved from the pattern itself rather than from the active editor: the
 * command is offered on any popup (e.g. the Model Explorer, with no or an unrelated editor
 * active), and catalogs opened in a Sirius session belong to that session's transactional
 * domain, whose command stack wraps the edit in the required write transaction. Patterns with
 * no owning domain are not edited, since a direct mutation would either fail outside a
 * transaction or never be saved.
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

		Shell shell = HandlerUtil.getActiveShell(event);
		// Resolve the domain before opening the dialog so the user does not lose their edits.
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(pattern);
		if (domain == null) {
			MessageDialog.openError(shell, "Cannot edit VQL pattern",
					"The pattern is not open in an editor or modeling session. Open its catalog and try again.");
			return null;
		}
		if (pattern.eResource() != null && domain.isReadOnly(pattern.eResource())) {
			MessageDialog.openError(shell, "Cannot edit VQL pattern", "The pattern's catalog is read-only.");
			return null;
		}

		VqlPatternEditDialog dialog = new VqlPatternEditDialog(shell, pattern.getName(), buildContext(pattern),
				pattern.getPatterns());
		if (dialog.open() != Window.OK) {
			return null;
		}

		List<String> newPatterns = dialog.getResult();
		if (newPatterns.equals(pattern.getPatterns())) {
			return null;
		}
		Command cmd = SetCommand.create(domain, pattern, SpartaModelPackage.Literals.THREAT_PATTERN__PATTERNS,
				newPatterns);
		if (!cmd.canExecute()) {
			MessageDialog.openError(shell, "Cannot edit VQL pattern", "The edited patterns could not be applied.");
			return null;
		}
		domain.getCommandStack().execute(cmd);
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
