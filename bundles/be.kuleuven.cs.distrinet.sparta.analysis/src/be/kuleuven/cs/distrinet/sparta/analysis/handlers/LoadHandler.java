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
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
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

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		IEditorPart editorPart = activeWorkbenchWindow.getActivePage().getActiveEditor();
		if (editorPart instanceof DDiagramEditor) {
			DDiagramEditor editor = (DDiagramEditor) editorPart;
			editor.addPropertyListener(ThreatAnalysisService.getInstance());
			DRepresentation rep = editor.getRepresentation();
			if (rep instanceof DSemanticDecorator) {
				EObject root = ((DSemanticDecorator) rep).getTarget();
				Resource rs = root.eResource();
				ThreatAnalysisService.getInstance().load(rs);
				return null;
			}
		}
		if (editorPart instanceof be.kuleuven.cs.distrinet.sparta.spartamodel.presentation.SpartaModelEditor) {
			editorPart.addPropertyListener(ThreatAnalysisService.getInstance());
			
		}
		IModelConnector modelConnector = AdapterUtil.getModelConnectorFromIEditorPart(editorPart);
		if (modelConnector instanceof EMFModelConnector) {
			modelConnector.loadModel(IModelConnectorTypeEnum.RESOURCE);
			Resource resource = (Resource) modelConnector.getNotifier(IModelConnectorTypeEnum.RESOURCE);
			ThreatAnalysisService.getInstance().load(resource);
		}
		return null;
	}

}
