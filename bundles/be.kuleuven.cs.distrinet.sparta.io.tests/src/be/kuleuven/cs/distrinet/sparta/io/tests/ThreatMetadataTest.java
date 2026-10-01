/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.io.ThreatCSVWriter;
import be.kuleuven.cs.distrinet.sparta.io.ThreatExportColumns;
import be.kuleuven.cs.distrinet.sparta.io.ThreatMetadata;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Asset;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;

public class ThreatMetadataTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	// Model: root > [ EE "User", TB "DMZ" > [ TB "Backend" > [ Process "API" > [ Process "Worker" ] ] ] ]
	private ExternalEntity user;
	private TrustBoundaryContainer dmz;
	private TrustBoundaryContainer backend;
	private Process api;
	private Process worker;
	private ThreatType type;

	@Before
	public void setUp() {
		DFDModel model = FACTORY.createDFDModel();
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

		model.getContainedElements().add(user);
		model.getContainedElements().add(dmz);
		dmz.getContainedElements().add(backend);
		backend.getContainedElements().add(api);
		api.getContainedElements().add(worker);

		type = FACTORY.createThreatType();
		type.setName("Spoofing");
	}

	private static DataFlow flow(String name, DataFlowEntity sender, DataFlowEntity recipient) {
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName(name);
		flow.setSender(sender);
		flow.setRecipient(recipient);
		return flow;
	}

	private StubThreat threatOn(DataFlow flow) {
		return new StubThreat(type, flow, flow, new StubRiskModel());
	}

	@Test
	public void flowFromRootIntoNestedBoundariesCrossesAndReportsDepthRange() {
		StubThreat threat = threatOn(flow("login", api, user));

		assertTrue(ThreatMetadata.crossesTrustBoundary(threat));
		assertEquals(Integer.valueOf(0), ThreatMetadata.minTrustBoundaryDepth(threat));
		assertEquals(Integer.valueOf(2), ThreatMetadata.maxTrustBoundaryDepth(threat));
		assertSame(backend, ThreatMetadata.parent(api));
		assertNull(ThreatMetadata.parent(user));
		assertEquals("DMZ > Backend", ThreatMetadata.trustBoundaryPath(api));
		assertEquals("", ThreatMetadata.trustBoundaryPath(user));
	}

	@Test
	public void flowWithinSameBoundariesDoesNotCrossEvenWhenParentsDiffer() {
		// Worker's parent is a process, not a boundary: still the same two trust boundaries.
		StubThreat threat = threatOn(flow("job", worker, api));

		assertFalse(ThreatMetadata.crossesTrustBoundary(threat));
		assertEquals(Integer.valueOf(2), ThreatMetadata.minTrustBoundaryDepth(threat));
		assertEquals(Integer.valueOf(2), ThreatMetadata.maxTrustBoundaryDepth(threat));
		assertSame(api, ThreatMetadata.parent(worker));
	}

	@Test
	public void elementThreatWithoutFlowUsesThreatenedElementAndLeavesCrossingEmpty() {
		StubThreat threat = new StubThreat(type, worker, null, new StubRiskModel());

		assertNull(ThreatMetadata.crossesTrustBoundary(threat));
		assertEquals(Integer.valueOf(2), ThreatMetadata.minTrustBoundaryDepth(threat));
		assertEquals(Integer.valueOf(2), ThreatMetadata.maxTrustBoundaryDepth(threat));
	}

	@Test
	public void onlySolutionsMitigatingTheThreatTypeOnTheThreatenedElementAreReported() {
		DataFlow login = flow("login", api, user);
		ThreatType tampering = FACTORY.createThreatType();
		tampering.setName("Tampering");

		bind(solution("auth-1", type("Authentication")), countermeasure(type, null), login);
		bind(solution("sig-1", type("Signing")), countermeasure(tampering, null), login);
		// Bound to the sender, not the threatened element: not used by the risk model either.
		bind(solution("auth-2", type("Other Authentication")), countermeasure(type, null), api);

		assertEquals(Arrays.asList("Authentication"), new ArrayList<>(ThreatMetadata.solutionNames(threatOn(login))));
	}

	@Test
	public void mitigationIsMatchedThroughCompositesAndSuperTypeIds() {
		OrCompositeThreatType spoofingFamily = FACTORY.createOrCompositeThreatType();
		spoofingFamily.setName("Spoofing family");
		spoofingFamily.setId("SPOOF");
		spoofingFamily.getSubThreatTypes().add(type);
		DataFlow login = flow("login", api, user);

		bind(solution("via-ref", type("By Composite Reference")), countermeasure(spoofingFamily, null), login);
		CounterMeasure byId = countermeasure(null, null);
		byId.getMitigatedThreatTypeID().add("SPOOF");
		bind(solution("via-id", type("By Super Type Id")), byId, login);
		CounterMeasure otherId = countermeasure(null, null);
		otherId.getMitigatedThreatTypeID().add("TAMPER");
		bind(solution("unrelated", type("Unrelated Id")), otherId, login);

		assertEquals(Arrays.asList("By Composite Reference", "By Super Type Id"),
				new ArrayList<>(ThreatMetadata.solutionNames(threatOn(login))));
	}

	@Test
	public void scopedCountermeasuresOnlyCountWhenTheFlowIsBoundToTheScope() {
		DataFlow login = flow("login", api, user);
		DataFlow other = flow("other", api, user);
		Role channel = FACTORY.createRole();
		Solution tls = solution("tls-1", type("Secure Channel"));
		bind(tls, countermeasure(type, channel), login, other);
		bindRole(tls, channel, login);

		assertEquals(Arrays.asList("Secure Channel"), new ArrayList<>(ThreatMetadata.solutionNames(threatOn(login))));
		assertTrue(ThreatMetadata.solutionNames(threatOn(other)).isEmpty());
	}

	@Test
	public void untypedSolutionFallsBackToItsOwnNameAndDuplicatesCollapse() {
		DataFlow login = flow("login", api, user);
		SolutionType auth = type("Authentication");
		bind(solution("auth-1", auth), countermeasure(type, null), login);
		bind(solution("auth-2", auth), countermeasure(type, null), login);
		bind(solution("untyped", null), countermeasure(type, null), login);

		assertEquals(Arrays.asList("Authentication", "untyped"),
				new ArrayList<>(ThreatMetadata.solutionNames(threatOn(login))));
	}

	@Test
	public void csvWithMetadataAppendsColumnsAfterDefaults() throws IOException {
		DataFlow login = flow("login", api, user);
		bind(solution("auth-1", type("Authentication")), countermeasure(type, null), login);

		StringWriter sw = new StringWriter();
		try (ThreatCSVWriter writer = new ThreatCSVWriter(sw, ThreatExportColumns.withMetadata())) {
			writer.writeHeader();
			writer.write(threatOn(login));
		}
		String[] lines = sw.toString().split("\\R");
		List<String> header = Arrays.asList(lines[0].split(";"));
		List<String> row = Arrays.asList(lines[1].split(";"));

		assertEquals(ThreatExportColumns.defaults().size() + 8, header.size());
		assertEquals("\"Flow From\"", header.get(3));
		assertEquals("\"true\"", row.get(header.indexOf("\"Crosses Trust Boundary\"")));
		assertEquals("\"0\"", row.get(header.indexOf("\"Trust Boundary Depth (min)\"")));
		assertEquals("\"2\"", row.get(header.indexOf("\"Trust Boundary Depth (max)\"")));
		assertEquals("\"Backend\"", row.get(header.indexOf("\"Flow From Parent\"")));
		assertEquals("\"\"", row.get(header.indexOf("\"Flow To Parent\"")));
		assertEquals("\"DMZ > Backend\"", row.get(header.indexOf("\"Flow From Trust Boundaries\"")));
		assertEquals("\"Authentication\"", row.get(header.indexOf("\"Mitigating Solutions\"")));
	}

	private static SolutionType type(String name) {
		SolutionType t = FACTORY.createSolutionType();
		t.setName(name);
		return t;
	}

	private static Solution solution(String name, SolutionType type) {
		Solution s = FACTORY.createSolution();
		s.setName(name);
		s.setSecuritypattern(type);
		return s;
	}

	private static CounterMeasure countermeasure(AbstractThreatType mitigates, Role scope) {
		CounterMeasure cm = FACTORY.createCounterMeasure();
		if (mitigates != null) {
			cm.getMitigates().add(mitigates);
		}
		if (scope != null) {
			cm.getScope().add(scope);
		}
		return cm;
	}

	/** Bind a new role, subject to {@code cm}, of {@code solution} to the given assets. */
	private static void bind(Solution solution, CounterMeasure cm, Asset... assets) {
		Role role = FACTORY.createRole();
		role.getSubjected().add(cm);
		bindRole(solution, role, assets);
	}

	private static void bindRole(Solution solution, Role role, Asset... assets) {
		RoleBinding rb = FACTORY.createRoleBinding();
		rb.setBinds(role);
		solution.getRolebinding().add(rb);
		rb.getBindsTo().addAll(Arrays.asList(assets));
	}
}
