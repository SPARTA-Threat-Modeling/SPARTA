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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactoryProvider;
import org.junit.Before;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.model.DfdStructure;
import be.kuleuven.cs.distrinet.sparta.queries.FlowContainerDiff;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;

/**
 * Tests for {@link DfdStructure}, including that its trust-boundary crossing agrees with the
 * {@code flowContainerDiff} query used by the threat patterns.
 */
public class DfdStructureTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	// Model: root > [ EE "User", TB "DMZ" > [ TB "Backend" > [ Process "API" > [ Process "Worker" ] ] ],
	//                TB "Partner" > [ EE "Bank" ] ]
	private DFDModel model;
	private ExternalEntity user;
	private TrustBoundaryContainer dmz;
	private TrustBoundaryContainer backend;
	private Process api;
	private Process worker;
	private ExternalEntity bank;
	private ThreatType type;

	@Before
	public void setUp() {
		model = FACTORY.createDFDModel();
		user = FACTORY.createExternalEntity();
		user.setName("User");
		dmz = FACTORY.createTrustBoundaryContainer();
		dmz.setName("DMZ");
		backend = FACTORY.createTrustBoundaryContainer();
		backend.setName("Backend");
		api = FACTORY.createProcess();
		api.setName("API");
		worker = FACTORY.createProcess();
		worker.setName("Worker");
		TrustBoundaryContainer partner = FACTORY.createTrustBoundaryContainer();
		partner.setName("Partner");
		bank = FACTORY.createExternalEntity();
		bank.setName("Bank");

		model.getContainedElements().add(user);
		model.getContainedElements().add(dmz);
		dmz.getContainedElements().add(backend);
		backend.getContainedElements().add(api);
		api.getContainedElements().add(worker);
		model.getContainedElements().add(partner);
		partner.getContainedElements().add(bank);

		type = FACTORY.createThreatType();
		type.setName("Spoofing");
	}

	private DataFlow flow(String name, DataFlowEntity sender, DataFlowEntity recipient) {
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName(name);
		flow.setSender(sender);
		flow.setRecipient(recipient);
		model.getContainedElements().add(flow);
		return flow;
	}

	private StubThreat threatOn(DataFlow flow) {
		return new StubThreat(type, flow, flow);
	}

	@Test
	public void trustBoundariesParentsAndDepthFollowContainment() {
		assertEquals(List.of(dmz, backend), DfdStructure.trustBoundaries(worker));
		assertEquals(2, DfdStructure.trustBoundaryDepth(worker));
		assertEquals(0, DfdStructure.trustBoundaryDepth(user));
		assertSame(backend, DfdStructure.parent(api));
		assertSame(api, DfdStructure.parent(worker));
		assertNull(DfdStructure.parent(user));
	}

	@Test
	public void flowFromRootIntoNestedBoundariesCrossesAndReportsDepthRange() {
		StubThreat threat = threatOn(flow("login", api, user));

		assertTrue(DfdStructure.crossesTrustBoundary(threat));
		assertEquals(Integer.valueOf(0), DfdStructure.minTrustBoundaryDepth(threat));
		assertEquals(Integer.valueOf(2), DfdStructure.maxTrustBoundaryDepth(threat));
	}

	@Test
	public void flowWithinSameBoundariesDoesNotCrossEvenWhenParentsDiffer() {
		// Worker's parent is a process, not a boundary: still the same two trust boundaries.
		StubThreat threat = threatOn(flow("job", worker, api));

		assertFalse(DfdStructure.crossesTrustBoundary(threat));
		assertEquals(Integer.valueOf(2), DfdStructure.minTrustBoundaryDepth(threat));
		assertEquals(Integer.valueOf(2), DfdStructure.maxTrustBoundaryDepth(threat));
	}

	@Test
	public void elementThreatWithoutFlowUsesThreatenedElementAndLeavesCrossingEmpty() {
		StubThreat threat = new StubThreat(type, worker, null);

		assertNull(DfdStructure.crossesTrustBoundary(threat));
		assertEquals(List.of(worker), DfdStructure.involvedElements(threat));
		assertEquals(Integer.valueOf(2), DfdStructure.minTrustBoundaryDepth(threat));
		assertEquals(Integer.valueOf(2), DfdStructure.maxTrustBoundaryDepth(threat));
	}

	/**
	 * The threat patterns decide boundary crossings with the {@code flowContainerDiff} query;
	 * the exported "Crosses Trust Boundary" column must agree with it.
	 */
	@Test
	public void crossingAgreesWithFlowContainerDiffQuery() {
		List<DataFlow> flows = List.of(
				flow("login", api, user),
				flow("reply", user, api),
				flow("job", worker, api),
				flow("pay", api, bank),
				flow("statement", bank, user),
				flow("self", user, user));

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = new XMIResourceImpl(URI.createURI("mem:/dfdstructure.xmi"));
		resourceSet.getResources().add(resource);
		resource.getContents().add(model);

		// The generated query needs no pattern parsing, so a plain engine with the same backend
		// as the analysis Engine suffices.
		AdvancedViatraQueryEngine engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(resourceSet),
				ViatraQueryEngineOptions.defineOptions()
						.withDefaultBackend(new ReteBackendFactoryProvider().getFactory()).build());
		try {
			FlowContainerDiff.Matcher matcher = FlowContainerDiff.Matcher.on(engine);
			int crossing = 0;
			for (DataFlow flow : flows) {
				boolean expected = matcher.hasMatch(flow.getSender(), flow.getRecipient());
				assertEquals(flow.getName(), expected,
						DfdStructure.crossesTrustBoundary(flow.getSender(), flow.getRecipient()));
				crossing += expected ? 1 : 0;
			}
			// Guard against a vacuous pass: the fixture has both crossing and internal flows.
			assertTrue(crossing > 0 && crossing < flows.size());
		} finally {
			engine.dispose();
		}
	}
}
