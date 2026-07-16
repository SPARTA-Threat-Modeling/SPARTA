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

import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;

/**
 * Modified handler from
 * org.eclipse.viatra.query.tooling.ui.queryexplorer.handlers.LoadResourceSetHandler
 * 
 * @author laurenss
 *
 */
public class ClearHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ThreatAnalysisService.getInstance().clear();
		
		return null;
	}
	
	
	

}
