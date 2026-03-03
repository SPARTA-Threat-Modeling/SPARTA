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
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Role#getSubjected <em>Subjected</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Role#getBindingTypes <em>Binding Types</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends SecurityElement {
	/**
	 * Returns the value of the '<em><b>Subjected</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure}.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subjected</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subjected</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRole_Subjected()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getSubject
	 * @model opposite="subject"
	 * @generated
	 */
	EList<CounterMeasure> getSubjected();

	/**
	 * Returns the value of the '<em><b>Binding Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Class}<code>&lt;? extends be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Types</em>' attribute list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRole_BindingTypes()
	 * @model
	 * @generated
	 */
	EList<Class<? extends DFDElement>> getBindingTypes();

} // Role
