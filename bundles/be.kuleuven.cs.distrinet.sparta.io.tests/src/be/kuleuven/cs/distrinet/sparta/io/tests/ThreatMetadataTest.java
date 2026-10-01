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
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.analysis.Mitigation;
import be.kuleuven.cs.distrinet.sparta.io.ThreatCSVWriter;
import be.kuleuven.cs.distrinet.sparta.io.ThreatExportColumns;
import be.kuleuven.cs.distrinet.sparta.io.ThreatMetadata;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;

/**
 * Tests for the export formatting in {@link ThreatMetadata} and the metadata columns. The
 * structure and the countermeasure selection themselves are tested in core
 * ({@code DfdStructureTest}, {@code MitigationsTest}); here the mitigations come from a
 * {@link StubRiskModel}, as if recorded by the risk calculation.
 */
public class ThreatMetadataTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	// Model: root > [ EE "User", TB "DMZ" > [ TB "Backend" > [ Process "API" > [ Process "Worker" ] ] ] ]
	private ExternalEntity user;
	private Process api;
	private Process worker;
	private ThreatType type;

	@Before
	public void setUp() {
		DFDModel model = FACTORY.createDFDModel();
		user = FACTORY.createExternalEntity();
		user.setName("User");
		TrustBoundaryContainer dmz = FACTORY.createTrustBoundaryContainer();
		dmz.setName("DMZ");
		TrustBoundaryContainer backend = FACTORY.createTrustBoundaryContainer();
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

	private StubThreat threatOn(DataFlow flow, Mitigation... mitigations) {
		return new StubThreat(type, flow, flow, new StubRiskModel(Arrays.asList(mitigations)));
	}

	@Test
	public void trustBoundaryPathListsEnclosingBoundariesOutermostFirst() {
		assertEquals("DMZ > Backend", ThreatMetadata.trustBoundaryPath(api));
		assertEquals("DMZ > Backend", ThreatMetadata.trustBoundaryPath(worker));
		assertEquals("", ThreatMetadata.trustBoundaryPath(user));
	}

	@Test
	public void solutionsAreNamedByTypeFallingBackToTheirOwnNameAndDuplicatesCollapse() {
		SolutionType auth = type("Authentication");
		StubThreat threat = threatOn(flow("login", api, user),
				mitigation(solution("auth-1", auth)),
				mitigation(solution("auth-2", auth)),
				mitigation(solution("untyped", null)));

		assertEquals(Arrays.asList("Authentication", "untyped"), new ArrayList<>(ThreatMetadata.solutionNames(threat)));
		assertEquals("Authentication, untyped", ThreatMetadata.solutions(threat));
	}

	@Test
	public void mitigationsOutsideASolutionAreNotNamed() {
		assertTrue(ThreatMetadata.solutionNames(threatOn(flow("login", api, user), mitigation(null))).isEmpty());
	}

	@Test
	public void csvWithMetadataAppendsColumnsAfterDefaults() throws IOException {
		StubThreat threat = threatOn(flow("login", api, user), mitigation(solution("auth-1", type("Authentication"))));

		StringWriter sw = new StringWriter();
		try (ThreatCSVWriter writer = new ThreatCSVWriter(sw, ThreatExportColumns.withMetadata())) {
			writer.writeHeader();
			writer.write(threat);
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

	/** A mitigation through a new role binding of {@code solution} ({@code null}: no solution). */
	private static Mitigation mitigation(Solution solution) {
		Role role = FACTORY.createRole();
		CounterMeasure cm = FACTORY.createCounterMeasure();
		role.getSubjected().add(cm);
		RoleBinding rb = FACTORY.createRoleBinding();
		rb.setBinds(role);
		if (solution != null) {
			solution.getRolebinding().add(rb);
		}
		return new Mitigation(rb, cm);
	}
}
