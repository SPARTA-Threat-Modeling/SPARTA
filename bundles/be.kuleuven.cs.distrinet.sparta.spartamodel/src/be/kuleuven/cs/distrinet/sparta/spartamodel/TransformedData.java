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
 * A representation of the model object '<em><b>Transformed Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getDecKey <em>Dec Key</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getEncKey <em>Enc Key</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getDatatype <em>Datatype</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getTransformedData()
 * @model
 * @generated
 */
public interface TransformedData extends DataType {
	/**
	 * Returns the value of the '<em><b>Dec Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dec Key</em>' reference.
	 * @see #setDecKey(DataType)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getTransformedData_DecKey()
	 * @model
	 * @generated
	 */
	DataType getDecKey();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getDecKey <em>Dec Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dec Key</em>' reference.
	 * @see #getDecKey()
	 * @generated
	 */
	void setDecKey(DataType value);

	/**
	 * Returns the value of the '<em><b>Enc Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enc Key</em>' reference.
	 * @see #setEncKey(DataType)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getTransformedData_EncKey()
	 * @model
	 * @generated
	 */
	DataType getEncKey();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getEncKey <em>Enc Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enc Key</em>' reference.
	 * @see #getEncKey()
	 * @generated
	 */
	void setEncKey(DataType value);

	/**
	 * Returns the value of the '<em><b>Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datatype</em>' reference.
	 * @see #setDatatype(DataType)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getTransformedData_Datatype()
	 * @model required="true"
	 * @generated
	 */
	DataType getDatatype();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getDatatype <em>Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datatype</em>' reference.
	 * @see #getDatatype()
	 * @generated
	 */
	void setDatatype(DataType value);

} // TransformedData
