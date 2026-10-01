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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.analysis.Mitigation;
import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskCalculation;
import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.SpartaRiskModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Asset;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Tests for the countermeasure selection ({@link RiskCalculation#mitigations}) that the risk
 * model records on each threat, called the way {@link SpartaRiskModel} calls it: with the
 * role bindings on the threatened element.
 */
public class MitigationsTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	private ExternalEntity user;
	private Process api;
	private ThreatType type;

	@Before
	public void setUp() {
		user = FACTORY.createExternalEntity();
		user.setName("User");
		api = FACTORY.createProcess();
		api.setName("API");
		type = FACTORY.createThreatType();
		type.setName("Spoofing");
	}

	private static DataFlow flow(String name, Process sender, ExternalEntity recipient) {
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName(name);
		flow.setSender(sender);
		flow.setRecipient(recipient);
		return flow;
	}

	/** The mitigations for a threat of {@link #type} on the given flow. */
	private List<Mitigation> mitigationsOn(DataFlow flow) {
		return RiskCalculation.mitigations(flow, type, flow.getBound());
	}

	private static List<String> solutionNames(List<Mitigation> mitigations) {
		return mitigations.stream().map(m -> m.solution().getName()).collect(Collectors.toList());
	}

	@Test
	public void onlyCountermeasuresForTheThreatTypeOnTheThreatenedElementAreSelected() {
		DataFlow login = flow("login", api, user);
		ThreatType tampering = FACTORY.createThreatType();
		tampering.setName("Tampering");

		CounterMeasure auth = countermeasure(type, null);
		Solution auth1 = solution("auth-1");
		bind(auth1, auth, login);
		bind(solution("sig-1"), countermeasure(tampering, null), login);
		// Bound to the sender, not the threatened element: does not reduce this threat.
		bind(solution("auth-2"), countermeasure(type, null), api);

		List<Mitigation> mitigations = mitigationsOn(login);

		assertEquals(1, mitigations.size());
		assertSame(auth, mitigations.get(0).counterMeasure());
		assertSame(auth1, mitigations.get(0).solution());
	}

	@Test
	public void mitigationIsMatchedThroughCompositesAndSuperTypeIds() {
		OrCompositeThreatType spoofingFamily = FACTORY.createOrCompositeThreatType();
		spoofingFamily.setName("Spoofing family");
		spoofingFamily.setId("SPOOF");
		spoofingFamily.getSubThreatTypes().add(type);
		DataFlow login = flow("login", api, user);

		bind(solution("via-ref"), countermeasure(spoofingFamily, null), login);
		CounterMeasure byId = countermeasure(null, null);
		byId.getMitigatedThreatTypeID().add("SPOOF");
		bind(solution("via-id"), byId, login);
		CounterMeasure otherId = countermeasure(null, null);
		otherId.getMitigatedThreatTypeID().add("TAMPER");
		bind(solution("unrelated"), otherId, login);

		assertEquals(Arrays.asList("via-ref", "via-id"), solutionNames(mitigationsOn(login)));
	}

	@Test
	public void scopedCountermeasuresOnlyCountWhenTheFlowIsBoundToTheScope() {
		DataFlow login = flow("login", api, user);
		DataFlow other = flow("other", api, user);
		Role channel = FACTORY.createRole();
		Solution tls = solution("tls-1");
		bind(tls, countermeasure(type, channel), login, other);
		bindRole(tls, channel, login);

		assertEquals(Arrays.asList("tls-1"), solutionNames(mitigationsOn(login)));
		assertTrue(mitigationsOn(other).isEmpty());
	}

	@Test
	public void bindingOutsideASolutionHasNoSolution() {
		RoleBinding loose = FACTORY.createRoleBinding();
		assertNull(new Mitigation(loose, countermeasure(type, null)).solution());
	}

	@Test
	public void recordedMitigationsRequireARiskCalculation() {
		assertThrows(IllegalStateException.class, () -> new SpartaRiskModel().getMitigations());
	}

	private static Solution solution(String name) {
		Solution s = FACTORY.createSolution();
		s.setName(name);
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
