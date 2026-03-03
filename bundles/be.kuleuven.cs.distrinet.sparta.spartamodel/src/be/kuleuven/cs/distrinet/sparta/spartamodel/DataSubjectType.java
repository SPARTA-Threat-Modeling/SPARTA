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
 * A representation of the model object '<em><b>Data Subject Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getPersonaldatatype <em>Personaldatatype</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getSensitivity <em>Sensitivity</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getNbrOfSubjects <em>Nbr Of Subjects</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataSubjectType()
 * @model
 * @generated
 */
public interface DataSubjectType extends DataModelElement {

	/**
	 * Returns the value of the '<em><b>Personaldatatype</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Personaldatatype</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataSubjectType_Personaldatatype()
	 * @model
	 * @generated
	 */
	EList<PersonalDataType> getPersonaldatatype();

	/**
	 * Returns the value of the '<em><b>Sensitivity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensitivity</em>' containment reference.
	 * @see #setSensitivity(Estimate)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataSubjectType_Sensitivity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Estimate getSensitivity();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getSensitivity <em>Sensitivity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sensitivity</em>' containment reference.
	 * @see #getSensitivity()
	 * @generated
	 */
	void setSensitivity(Estimate value);

	/**
	 * Returns the value of the '<em><b>Nbr Of Subjects</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nbr Of Subjects</em>' containment reference.
	 * @see #setNbrOfSubjects(Estimate)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataSubjectType_NbrOfSubjects()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Estimate getNbrOfSubjects();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getNbrOfSubjects <em>Nbr Of Subjects</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nbr Of Subjects</em>' containment reference.
	 * @see #getNbrOfSubjects()
	 * @generated
	 */
	void setNbrOfSubjects(Estimate value);
} // DataSubjectType
