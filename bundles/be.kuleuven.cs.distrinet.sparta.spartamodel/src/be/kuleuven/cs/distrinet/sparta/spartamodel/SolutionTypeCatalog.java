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
 * A representation of the model object '<em><b>Solution Type Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionTypeCatalog#getSolutionTypes <em>Solution Types</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSolutionTypeCatalog()
 * @model
 * @generated
 */
public interface SolutionTypeCatalog extends SpartaResource {
	/**
	 * Returns the value of the '<em><b>Solution Types</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution Types</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSolutionTypeCatalog_SolutionTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<SolutionType> getSolutionTypes();

} // SolutionTypeCatalog
