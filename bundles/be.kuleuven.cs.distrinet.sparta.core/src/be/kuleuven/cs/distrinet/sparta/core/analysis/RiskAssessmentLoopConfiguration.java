/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import be.kuleuven.cs.distrinet.sparta.core.Engine;
import be.kuleuven.cs.distrinet.sparta.core.model.Attacker;
import be.kuleuven.cs.distrinet.sparta.queries.AttackerProfileQueries;
import be.kuleuven.cs.distrinet.sparta.queries.AttackerProfiles;
import be.kuleuven.cs.distrinet.sparta.queries.DataQueries;
import be.kuleuven.cs.distrinet.sparta.queries.DataSubjects;
import be.kuleuven.cs.distrinet.sparta.queries.DataTypeAssignments;
import be.kuleuven.cs.distrinet.sparta.queries.DfdElement;
import be.kuleuven.cs.distrinet.sparta.queries.PersonalDataTypes;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType;


/**
 * This class is used to manage the different loops as part of the risk assessment.
 * This includes the different DFDElements, attacker profiles, personal data types, etc. over which the risk analysis has to iterate.
 *
 */
public class RiskAssessmentLoopConfiguration {

	private static final Logger LOGGER = Logger.getLogger(RiskAssessmentLoopConfiguration.class.getName());

	private static final String DEFAULT_ATTACKER_NAME = "Opportunist";

	private Set<AttackerProfile> attackerProfiles;
	private Set<DataSubjectType> dataSubjects;
	private Set<PersonalDataType> dataTypes;
	private Set<DFDElement> dfdElements;
	private Map<DFDElement, Set<PersonalDataType>> dfdDataTypes;

	/**
	 * Create a new, empty risk-assessment loop configuration. Each {@link Engine}
	 * owns its own instance (see {@link Engine#getLoopConfiguration()}) so that
	 * concurrent or successive analyses on different models no longer share mutable
	 * loop state through a global singleton.
	 */
	public RiskAssessmentLoopConfiguration() {
	}

	/**
	 * Use the provided {@link ViatraQueryEngine} to query a model for attacker
	 * profile, datatypes and dfd elements to support the risk calculation.
	 * 
	 * @param engine {@link ViatraQueryEngine} to use
	 */
	public void setUpLoopParameters(Engine engine) {
		// Initialise every collection up front so that a query failure below cannot leave
		// dataSubjects/dataTypes null (which would NPE in the getters).
		attackerProfiles = new HashSet<>();
		dataSubjects = new HashSet<>();
		dataTypes = new HashSet<>();
		dfdDataTypes = new HashMap<>();
		dfdElements = new HashSet<>();

		try {
			AttackerProfiles.Matcher apm = engine.getMatcherOnEngine(AttackerProfileQueries.instance()::getAttackerProfiles);
			DataSubjects.Matcher dsm = engine.getMatcherOnEngine(DataQueries.instance()::getDataSubjects);
			DataTypeAssignments.Matcher dtam = engine.getMatcherOnEngine(DataQueries.instance()::getDataTypeAssignments);
			PersonalDataTypes.Matcher dtm = engine.getMatcherOnEngine(DataQueries.instance()::getPersonalDataTypes);

			Set<AttackerProfile> aps = apm.getAllValuesOfap();
			attackerProfiles.addAll(aps);
		
			dtam.forEachMatch((DataTypeAssignments.Match m) -> {

				Set<PersonalDataType> dts = dfdDataTypes.get(m.getDfdel());
				if (dts == null)
					dts = new HashSet<>();
				dts.add(m.getDt());
				dfdDataTypes.put(m.getDfdel(), dts);

			});

			dataSubjects = dsm.getAllValuesOfds();
			dataTypes = dtm.getAllValuesOfdt();

			DfdElement.Matcher dfdel = engine.getMatcherOnEngine(DataQueries.instance()::getDfdElement);
			dfdElements.addAll(dfdel.getAllValuesOfdfdel());

		} catch (ViatraQueryException e) {
			LOGGER.log(Level.SEVERE, e, () -> "Failed to set up risk-assessment loop parameters from the model");
		}

		// Fall back to a default attacker profile when the model declares none.
		if (attackerProfiles.isEmpty()) {
			attackerProfiles.add(defaultAttackerProfile());
		}

	}

	/**
	 * @return the default "opportunist" attacker profile used when a model declares no
	 *         attacker profiles of its own (threat-capability / contact-frequency /
	 *         probability-of-action estimates as min, probable, max, confidence).
	 */
	private static Attacker defaultAttackerProfile() {
		return new Attacker(DEFAULT_ATTACKER_NAME,
				0, 15, 35, 2, // threat capability
				4, 12, 24, 4, // contact frequency
				0, 0.1, 0.3, 4); // probability of action
	}

	/**
	 * Get the set of attacker profiles to consider
	 * 
	 * @return the set of attacker profiles to take into account
	 */
	public Set<AttackerProfile> getAttackerProfiles() {
		return new HashSet<>(attackerProfiles);
	}

	/**
	 * Get the set of data subject types to consider
	 * 
	 * @return the set of data subject types
	 */
	public Set<DataSubjectType> getDataSubjectTypes() {
		return new HashSet<>(dataSubjects);
	}

	/**
	 * Get the set of personal data types to consider
	 * 
	 * @return the set of personal data types
	 */
	public Set<PersonalDataType> getPersonalDataTypes() {
		return new HashSet<>(dataTypes);
	}

	/**
	 * Get the set of dfd elements in the model.
	 * 
	 * @return the dfd elements
	 */
	public Set<DFDElement> getDfdElements() {
		return new HashSet<>(dfdElements);
	}

	/**
	 * Get the map of dfd elements and the associated personal data types linked to
	 * those elements.
	 * 
	 * @return map of dfd elements and their associated personal data types
	 */
	public Map<DFDElement, Set<PersonalDataType>> getDfdDataTypes() {
		return new HashMap<>(dfdDataTypes);
	}

}
