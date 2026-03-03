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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFD Element Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation#getDfdelement <em>Dfdelement</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDFDElementAnnotation()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface DFDElementAnnotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Dfdelement</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement}.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement#getDfdelementannotation <em>Dfdelementannotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dfdelement</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDFDElementAnnotation_Dfdelement()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement#getDfdelementannotation
	 * @model opposite="dfdelementannotation"
	 * @generated
	 */
	EList<DFDElement> getDfdelement();

} // DFDElementAnnotation
