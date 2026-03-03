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
 * A representation of the model object '<em><b>Single Composite Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition#getSubcondition <em>Subcondition</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSingleCompositeCondition()
 * @model abstract="true"
 * @generated
 */
public interface SingleCompositeCondition extends CompositeCondition {
	/**
	 * Returns the value of the '<em><b>Subcondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subcondition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subcondition</em>' containment reference.
	 * @see #setSubcondition(AbstractCondition)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSingleCompositeCondition_Subcondition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractCondition getSubcondition();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition#getSubcondition <em>Subcondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subcondition</em>' containment reference.
	 * @see #getSubcondition()
	 * @generated
	 */
	void setSubcondition(AbstractCondition value);

} // SingleCompositeCondition
