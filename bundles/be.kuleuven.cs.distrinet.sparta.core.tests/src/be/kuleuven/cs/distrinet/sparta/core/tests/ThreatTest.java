/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;

/**
 * Tests for the pure string / identity helpers on {@link be.kuleuven.cs.distrinet.sparta.core.model.Threat}
 * that do not need a live VIATRA match: the element-type abbreviation, the
 * threatened-element type name, the stable element id, and the null-safe
 * data-flow name accessors. Exercised through {@link StubThreat}.
 */
public class ThreatTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	@Test
	public void typeAbbreviationKeepsOnlyCapitalsAfterStrippingImpl() {
		Process process = FACTORY.createProcess();
		DataStore dataStore = FACTORY.createDataStore();
		ExternalEntity externalEntity = FACTORY.createExternalEntity();

		// ProcessImpl -> "Process" -> "P"; DataStoreImpl -> "DS"; ExternalEntityImpl -> "EE".
		assertEquals("P", StubThreat.abbreviate(process));
		assertEquals("DS", StubThreat.abbreviate(dataStore));
		assertEquals("EE", StubThreat.abbreviate(externalEntity));
	}

	@Test
	public void typeAbbreviationIsNullSafe() {
		assertEquals("?", StubThreat.abbreviate(null));
	}

	@Test
	public void threatenedElementTypeNameStripsImplSuffix() {
		Process process = FACTORY.createProcess();
		StubThreat threat = new StubThreat(null, process, null);
		assertEquals("Process", threat.getThreatenedElementTypeName());
	}

	@Test
	public void threatenedElementTypeNameEmptyWhenNoElement() {
		StubThreat threat = new StubThreat(null, null, null);
		assertEquals("", threat.getThreatenedElementTypeName());
	}

	@Test
	public void threatenedElementNameFallsBackToEmpty() {
		StubThreat withoutElement = new StubThreat(null, null, null);
		assertEquals("", withoutElement.getThreatenedElementName());

		Process process = FACTORY.createProcess();
		process.setName("Web Server");
		StubThreat withElement = new StubThreat(null, process, null);
		assertEquals("Web Server", withElement.getThreatenedElementName());
	}

	@Test
	public void dataFlowNameAccessorsAreNullSafeWhenNoFlow() {
		StubThreat threat = new StubThreat(null, null, null);
		assertEquals("", threat.getDataFlowName());
		assertEquals("", threat.getDataFlowFromName());
		assertEquals("", threat.getDataFlowToName());
	}

	@Test
	public void dataFlowNameAccessorsReadSenderAndRecipient() {
		Process sender = FACTORY.createProcess();
		sender.setName("A");
		ExternalEntity recipient = FACTORY.createExternalEntity();
		recipient.setName("B");
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName("A-to-B");
		flow.setSender(sender);
		flow.setRecipient(recipient);

		StubThreat threat = new StubThreat(null, null, flow);
		assertEquals("A-to-B", threat.getDataFlowName());
		assertEquals("A", threat.getDataFlowFromName());
		assertEquals("B", threat.getDataFlowToName());
	}

	@Test
	public void threatenedElementIdEmptyWhenNoElement() {
		StubThreat threat = new StubThreat(null, null, null);
		assertEquals("", threat.getThreatenedElementId());
	}

	@Test
	public void threatenedElementIdIsANonEmptyStableUriForADetachedElement() {
		Process process = FACTORY.createProcess();
		process.setName("P1");
		StubThreat threat = new StubThreat(null, process, null);

		// Not contained in a resource, so the id falls back to the EMF URI; it must be
		// non-empty and stable across repeated calls on the same element.
		String id = threat.getThreatenedElementId();
		assertNotNull(id);
		assertFalse(id.isEmpty());
		assertEquals(id, threat.getThreatenedElementId());
	}
}
