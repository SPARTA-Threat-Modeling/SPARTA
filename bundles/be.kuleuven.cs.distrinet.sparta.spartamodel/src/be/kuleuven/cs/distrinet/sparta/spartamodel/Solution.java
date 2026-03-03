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
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Solution#getSecuritypattern <em>Securitypattern</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Solution#getRolebinding <em>Rolebinding</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSolution()
 * @model
 * @generated
 */
public interface Solution extends SecurityElement {
	/**
	 * Returns the value of the '<em><b>Securitypattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Securitypattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Securitypattern</em>' reference.
	 * @see #setSecuritypattern(SolutionType)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSolution_Securitypattern()
	 * @model
	 * @generated
	 */
	SolutionType getSecuritypattern();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Solution#getSecuritypattern <em>Securitypattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Securitypattern</em>' reference.
	 * @see #getSecuritypattern()
	 * @generated
	 */
	void setSecuritypattern(SolutionType value);

	/**
	 * Returns the value of the '<em><b>Rolebinding</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rolebinding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rolebinding</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSolution_Rolebinding()
	 * @model containment="true"
	 * @generated
	 */
	EList<RoleBinding> getRolebinding();

} // Solution
