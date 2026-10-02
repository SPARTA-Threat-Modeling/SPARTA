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

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.InternalEObject;
import org.junit.Before;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.analysis.service.RiskDependencies;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;

/**
 * Tests for {@link RiskDependencies}: which model objects a threat's risk depends on, and which
 * changes belong to which objects, as used for incremental risk recalculation.
 */
public class RiskDependenciesTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	/** A threat on a given element and flow, without a pattern match or risk model. */
	private static final class TestThreat extends Threat {
		TestThreat(ThreatType type, DFDElement element, DataFlow flow) {
			super(null, null);
			this.threatType = type;
			this.threatenedElement = element;
			this.dataFlow = flow;
		}
	}

	private TrustBoundaryContainer boundary;
	private Process api;
	private ExternalEntity user;
	private DataFlow login;
	private ThreatType spoofing;
	private OrCompositeThreatType family;

	@Before
	public void setUp() {
		DFDModel model = FACTORY.createDFDModel();
		boundary = FACTORY.createTrustBoundaryContainer();
		api = FACTORY.createProcess();
		user = FACTORY.createExternalEntity();
		model.getContainedElements().add(boundary);
		boundary.getContainedElements().add(api);
		model.getContainedElements().add(user);
		login = FACTORY.createDataFlow();
		login.setSender(api);
		login.setRecipient(user);
		model.getContainedElements().add(login);

		family = FACTORY.createOrCompositeThreatType();
		spoofing = FACTORY.createThreatType();
		family.getSubThreatTypes().add(spoofing);
	}

	@Test
	public void involvedObjectsCoverTheElementsTheTypeAndAllCountermeasuresOfBoundRoles() {
		CounterMeasure mitigating = FACTORY.createCounterMeasure();
		mitigating.getMitigates().add(spoofing);
		CounterMeasure unrelated = FACTORY.createCounterMeasure();
		Role role = FACTORY.createRole();
		role.getSubjected().add(mitigating);
		role.getSubjected().add(unrelated);
		Solution solution = FACTORY.createSolution();
		RoleBinding binding = FACTORY.createRoleBinding();
		binding.setBinds(role);
		solution.getRolebinding().add(binding);
		binding.getBindsTo().add(login);

		Set<?> involved = RiskDependencies.involvedObjects(new TestThreat(spoofing, login, login));

		assertTrue(involved.containsAll(List.of(login, api, user, spoofing, family, binding, role)));
		// Also the countermeasure that does not mitigate now: changing it could make it apply.
		assertTrue(involved.containsAll(List.of(mitigating, unrelated)));
		assertFalse("structural containers are not involved", involved.contains(boundary));
	}

	@Test
	public void aChangeBelongsToItsContainersUpToTheNearestDfdElementOrThreatType() {
		// Data contained in an element belongs to that element...
		AttackerProfile profile = FACTORY.createAttackerProfile();
		assertEquals(List.of(api), RiskDependencies.owners(api));
		// ...but containment between DFD elements is structure: api's change does not reach the boundary.
		assertFalse(RiskDependencies.owners(api).contains(boundary));
		assertFalse(RiskDependencies.owners(spoofing).contains(family));
		assertEquals(List.of(profile), RiskDependencies.owners(profile));
	}

	@Test
	public void attackerProfilesAndDataTypesAffectAllThreats() {
		AttackerModel attackers = FACTORY.createAttackerModel();
		AttackerProfile profile = FACTORY.createAttackerProfile();
		attackers.getAttackerProfiles().add(profile);

		assertTrue(RiskDependencies.affectsAllThreats(profile));
		assertTrue(RiskDependencies.affectsAllThreats(FACTORY.createPersonalDataType()));
		assertTrue(RiskDependencies.affectsAllThreats(FACTORY.createDataSubjectType()));
		assertFalse(RiskDependencies.affectsAllThreats(api));
	}

	@Test
	public void namesDescriptionsAndTouchesAreIrrelevant() {
		InternalEObject element = (InternalEObject) api;
		assertTrue(RiskDependencies.isIrrelevant(new ENotificationImpl(element, Notification.SET,
				SpartaModelPackage.Literals.MODEL_ELEMENT__NAME, "old", "new")));
		assertTrue(RiskDependencies.isIrrelevant(new ENotificationImpl(element, Notification.SET,
				SpartaModelPackage.Literals.MODEL_ELEMENT__DESCRIPTION, "old", "new")));
		assertTrue(RiskDependencies.isIrrelevant(new ENotificationImpl(element, Notification.SET,
				SpartaModelPackage.Literals.ASSET__BOUND, "same", "same")));
		assertFalse(RiskDependencies.isIrrelevant(new ENotificationImpl(element, Notification.ADD,
				SpartaModelPackage.Literals.ASSET__BOUND, null, FACTORY.createRoleBinding())));
	}
}
