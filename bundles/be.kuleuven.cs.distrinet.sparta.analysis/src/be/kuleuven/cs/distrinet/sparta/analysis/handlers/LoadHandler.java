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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.viatra.query.runtime.api.IModelConnectorTypeEnum;
import org.eclipse.viatra.query.runtime.ui.modelconnector.AdapterUtil;
import org.eclipse.viatra.query.runtime.ui.modelconnector.EMFModelConnector;
import org.eclipse.viatra.query.runtime.ui.modelconnector.IModelConnector;

import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;

/**
 * Modified handler from
 * org.eclipse.viatra.query.tooling.ui.queryexplorer.handlers.LoadResourceSetHandler
 * 
 * @author laurenss
 *
 */
public class LoadHandler extends AbstractHandler {

	private static final String TITLE = "Load and Analyze Model";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		Shell shell = activeWorkbenchWindow.getShell();

		IEditorPart editorPart = activeWorkbenchWindow.getActivePage() != null
				? activeWorkbenchWindow.getActivePage().getActiveEditor() : null;
		if (editorPart == null) {
			MessageDialog.openInformation(shell, TITLE,
					"No active editor found. Open a SPARTA model or diagram editor first.");
			return null;
		}
		if (editorPart instanceof DDiagramEditor) {
			DDiagramEditor editor = (DDiagramEditor) editorPart;
			DRepresentation rep = editor.getRepresentation();
			if (rep instanceof DSemanticDecorator) {
				EObject root = ((DSemanticDecorator) rep).getTarget();
				Resource rs = root != null ? root.eResource() : null;
				if (rs != null) {
					load(shell, rs, editor);
					return null;
				}
			}
		}
		IModelConnector modelConnector = AdapterUtil.getModelConnectorFromIEditorPart(editorPart);
		if (modelConnector instanceof EMFModelConnector) {
			modelConnector.loadModel(IModelConnectorTypeEnum.RESOURCE);
			Resource resource = (Resource) modelConnector.getNotifier(IModelConnectorTypeEnum.RESOURCE);
			if (resource != null) {
				boolean tracked = editorPart instanceof be.kuleuven.cs.distrinet.sparta.spartamodel.presentation.SpartaModelEditor
						|| editorPart instanceof DDiagramEditor;
				load(shell, resource, tracked ? editorPart : null);
				return null;
			}
		}
		MessageDialog.openInformation(shell, TITLE,
				"The active editor does not show a SPARTA model. Open a SPARTA model or diagram editor first.");
		return null;
	}

	/**
	 * Start analysing the resource. The analysis runs in a background job, which reports its own
	 * failures and, once it succeeded, attaches {@code editor} (if any) so later edits refresh
	 * the results. A model that cannot be analysed at all is refused right away; that is
	 * reported here.
	 */
	private static void load(Shell shell, Resource resource, IEditorPart editor) {
		IStatus status = ThreatAnalysisService.getInstance().load(resource, editor);
		if (!status.isOK()) {
			ErrorDialog.openError(shell, TITLE, "The model could not be analysed.", status);
		}
	}

}
