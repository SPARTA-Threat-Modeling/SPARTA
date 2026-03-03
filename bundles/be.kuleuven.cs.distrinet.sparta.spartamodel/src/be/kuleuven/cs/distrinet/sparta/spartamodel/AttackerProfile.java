/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
/**
 */
package be.kuleuven.cs.distrinet.sparta.spartamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attacker Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getThreatCapability <em>Threat Capability</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getProbabilityOfAction <em>Probability Of Action</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getContactFrequency <em>Contact Frequency</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getInsider <em>Insider</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAttackerProfile()
 * @model
 * @generated
 */
public interface AttackerProfile extends SecurityElement {
	/**
	 * Returns the value of the '<em><b>Threat Capability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threat Capability</em>' containment reference.
	 * @see #setThreatCapability(Estimate)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAttackerProfile_ThreatCapability()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Estimate getThreatCapability();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getThreatCapability <em>Threat Capability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threat Capability</em>' containment reference.
	 * @see #getThreatCapability()
	 * @generated
	 */
	void setThreatCapability(Estimate value);

	/**
	 * Returns the value of the '<em><b>Probability Of Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability Of Action</em>' containment reference.
	 * @see #setProbabilityOfAction(Estimate)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAttackerProfile_ProbabilityOfAction()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Estimate getProbabilityOfAction();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getProbabilityOfAction <em>Probability Of Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability Of Action</em>' containment reference.
	 * @see #getProbabilityOfAction()
	 * @generated
	 */
	void setProbabilityOfAction(Estimate value);

	/**
	 * Returns the value of the '<em><b>Contact Frequency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contact Frequency</em>' containment reference.
	 * @see #setContactFrequency(Estimate)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAttackerProfile_ContactFrequency()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Estimate getContactFrequency();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getContactFrequency <em>Contact Frequency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contact Frequency</em>' containment reference.
	 * @see #getContactFrequency()
	 * @generated
	 */
	void setContactFrequency(Estimate value);

	/**
	 * Returns the value of the '<em><b>Insider</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insider</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAttackerProfile_Insider()
	 * @model
	 * @generated
	 */
	EList<DFDElement> getInsider();

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAttackerProfile_Enabled()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

} // AttackerProfile
