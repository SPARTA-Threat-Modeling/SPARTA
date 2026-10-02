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

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
import be.kuleuven.cs.distrinet.sparta.core.analysis.risk.SpartaRiskModel;
import be.kuleuven.cs.distrinet.sparta.core.model.Attacker;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Tests for {@link SpartaRiskModel}'s aggregation, in particular the TEF
 * aggregation across attacker profiles: it must SUM one TEF per attacker profile
 * rather than keep only the last cell's value (the bug fixed in
 * {@code SpartaRiskModel.calculateRisk}).
 */
public class SpartaRiskModelTest {

	private static final int SAMPLES = 200;

	/**
	 * Loop configuration with fixed contents, bypassing the VIATRA query setup
	 * that normally populates it from a live model.
	 */
	private static final class FixedLoopConfiguration extends RiskAssessmentLoopConfiguration {

		private final Set<AttackerProfile> attackers;

		FixedLoopConfiguration(Set<AttackerProfile> attackers) {
			this.attackers = attackers;
		}

		@Override
		public Set<AttackerProfile> getAttackerProfiles() {
			return new HashSet<>(attackers);
		}

		@Override
		public Set<DataSubjectType> getDataSubjectTypes() {
			return Collections.emptySet();
		}

		@Override
		public Set<PersonalDataType> getPersonalDataTypes() {
			return Collections.emptySet();
		}

		@Override
		public Set<DFDElement> getDfdElements() {
			return Collections.emptySet();
		}

		@Override
		public Map<DFDElement, Set<PersonalDataType>> getDfdDataTypes() {
			return Collections.emptyMap();
		}
	}

	/**
	 * Regression: with two attacker profiles the aggregated TEF must equal the sum
	 * of both attackers' expected TEF (contact frequency x probability of action),
	 * not just the last attacker's value. Degenerate (point-mass) CF/PoA estimates
	 * make each attacker's TEF exact: A contributes 2 * 0.5 = 1, B contributes
	 * 3 * 1 = 3, so the total is {4, 4, 4}.
	 */
	@Test
	public void tefIsSummedAcrossAttackerProfiles() {
		SpartaModelFactory f = SpartaModelFactory.eINSTANCE;
		ThreatType tt = f.createThreatType();
		DataFlow flow = f.createDataFlow();
		DFDElement element = f.createDataStore();

		Attacker a = new Attacker("A",
				10, 10, 10, 4, // threat capability (point mass)
				2, 2, 2, 4, // contact frequency (point mass)
				0.5, 0.5, 0.5, 4); // probability of action (point mass)
		Attacker b = new Attacker("B",
				10, 10, 10, 4,
				3, 3, 3, 4,
				1, 1, 1, 4);

		Set<AttackerProfile> attackers = new HashSet<>(Arrays.asList(a, b));

		SpartaRiskModel model = new SpartaRiskModel();
		model.calculateRisk(new StubThreat(tt, element, flow), new FixedLoopConfiguration(attackers), SAMPLES);

		assertArrayEquals(new double[] { 4, 4, 4 }, model.getTef(), 1e-9);
	}
}
