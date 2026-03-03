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
 * A representation of the model object '<em><b>Data Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataModel#getDataModelElements <em>Data Model Elements</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataModel()
 * @model
 * @generated
 */
public interface DataModel extends SpartaResource {
	/**
	 * Returns the value of the '<em><b>Data Model Elements</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Model Elements</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataModel_DataModelElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataModelElement> getDataModelElements();

} // DataModel
