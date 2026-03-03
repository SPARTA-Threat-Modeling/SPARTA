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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Personal Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getSensitivity <em>Sensitivity</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getNbrOfRecords <em>Nbr Of Records</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getRetention <em>Retention</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getPersonalDataType()
 * @model
 * @generated
 */
public interface PersonalDataType extends DataType {

	/**
	 * Returns the value of the '<em><b>Sensitivity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensitivity</em>' containment reference.
	 * @see #setSensitivity(Estimate)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getPersonalDataType_Sensitivity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Estimate getSensitivity();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getSensitivity <em>Sensitivity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sensitivity</em>' containment reference.
	 * @see #getSensitivity()
	 * @generated
	 */
	void setSensitivity(Estimate value);

	/**
	 * Returns the value of the '<em><b>Nbr Of Records</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nbr Of Records</em>' containment reference.
	 * @see #setNbrOfRecords(Estimate)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getPersonalDataType_NbrOfRecords()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Estimate getNbrOfRecords();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getNbrOfRecords <em>Nbr Of Records</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nbr Of Records</em>' containment reference.
	 * @see #getNbrOfRecords()
	 * @generated
	 */
	void setNbrOfRecords(Estimate value);

	/**
	 * Returns the value of the '<em><b>Retention</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retention</em>' containment reference.
	 * @see #setRetention(Estimate)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getPersonalDataType_Retention()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Estimate getRetention();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getRetention <em>Retention</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retention</em>' containment reference.
	 * @see #getRetention()
	 * @generated
	 */
	void setRetention(Estimate value);
} // PersonalDataType
