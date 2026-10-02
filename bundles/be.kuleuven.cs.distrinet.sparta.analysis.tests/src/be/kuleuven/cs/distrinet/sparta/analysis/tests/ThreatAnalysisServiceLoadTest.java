/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;

/**
 * The service must report why a model cannot be analysed, so the Load command can tell the
 * user instead of failing silently.
 */
public class ThreatAnalysisServiceLoadTest {

	@Test
	public void loadWithoutAModelReportsAnError() {
		IStatus status = ThreatAnalysisService.getInstance().load(null);

		assertEquals(IStatus.ERROR, status.getSeverity());
		assertFalse(ThreatAnalysisService.getInstance().hasResults());
	}

	@Test
	public void loadOfAModelOutsideTheWorkspaceReportsAnError() {
		URI outside = URI.createFileURI(new File("outside-workspace.sparta").getAbsolutePath());
		IStatus status = ThreatAnalysisService.getInstance().load(new XMIResourceImpl(outside));

		assertEquals(IStatus.ERROR, status.getSeverity());
		assertTrue(status.getMessage(), status.getMessage().contains("is not a resource in the workspace"));
		assertFalse(ThreatAnalysisService.getInstance().hasResults());
	}
}
