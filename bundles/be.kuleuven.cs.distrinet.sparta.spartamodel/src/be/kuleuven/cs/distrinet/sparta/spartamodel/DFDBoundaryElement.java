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
 * A representation of the model object '<em><b>DFD Boundary Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDBoundaryElement#getCrossingFlows <em>Crossing Flows</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDFDBoundaryElement()
 * @model abstract="true"
 * @generated
 */
public interface DFDBoundaryElement extends DFDContainer {
	/**
	 * Returns the value of the '<em><b>Crossing Flows</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Crossing Flows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Crossing Flows</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDFDBoundaryElement_CrossingFlows()
	 * @model
	 * @generated
	 */
	EList<DataFlow> getCrossingFlows();

} // DFDBoundaryElement
