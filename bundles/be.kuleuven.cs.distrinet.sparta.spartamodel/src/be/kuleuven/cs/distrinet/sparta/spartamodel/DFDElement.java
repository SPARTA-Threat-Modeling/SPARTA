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
 * A representation of the model object '<em><b>DFD Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement#getSecurityannotation <em>Securityannotation</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement#getDfdelementannotation <em>Dfdelementannotation</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDFDElement()
 * @model abstract="true"
 * @generated
 */
public interface DFDElement extends Asset {
	/**
	 * Returns the value of the '<em><b>Securityannotation</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Securityannotation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Securityannotation</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDFDElement_Securityannotation()
	 * @model containment="true"
	 * @generated
	 */
	EList<SecurityAnnotation> getSecurityannotation();

	/**
	 * Returns the value of the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation}.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation#getDfdelement <em>Dfdelement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dfdelementannotation</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDFDElement_Dfdelementannotation()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation#getDfdelement
	 * @model opposite="dfdelement"
	 * @generated
	 */
	EList<DFDElementAnnotation> getDfdelementannotation();

} // DFDElement
