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
 * A representation of the model object '<em><b>Data Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSet#getDatatype <em>Datatype</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataSet()
 * @model
 * @generated
 */
public interface DataSet extends DataModelElement {
	/**
	 * Returns the value of the '<em><b>Datatype</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datatype</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataSet_Datatype()
	 * @model
	 * @generated
	 */
	EList<DataType> getDatatype();

} // DataSet
