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
 * A representation of the model object '<em><b>Role Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding#getBinds <em>Binds</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding#getBindsTo <em>Binds To</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRoleBinding()
 * @model
 * @generated
 */
public interface RoleBinding extends SecurityElement {
	/**
	 * Returns the value of the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds</em>' reference.
	 * @see #setBinds(Role)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRoleBinding_Binds()
	 * @model
	 * @generated
	 */
	Role getBinds();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding#getBinds <em>Binds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binds</em>' reference.
	 * @see #getBinds()
	 * @generated
	 */
	void setBinds(Role value);

	/**
	 * Returns the value of the '<em><b>Binds To</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset}.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getBound <em>Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds To</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRoleBinding_BindsTo()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getBound
	 * @model opposite="bound"
	 * @generated
	 */
	EList<Asset> getBindsTo();

} // RoleBinding
