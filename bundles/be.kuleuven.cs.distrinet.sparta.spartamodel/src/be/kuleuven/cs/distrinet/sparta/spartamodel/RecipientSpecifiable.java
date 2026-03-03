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
 * A representation of the model object '<em><b>Recipient Specifiable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipientSpecifiedBy <em>Recipient Specified By</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipient <em>Recipient</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRecipientSpecifiable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface RecipientSpecifiable extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Recipient Specified By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification#getSpecifiesRecipientOf <em>Specifies Recipient Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipient Specified By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recipient Specified By</em>' reference.
	 * @see #setRecipientSpecifiedBy(RecipientSpecification)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRecipientSpecifiable_RecipientSpecifiedBy()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification#getSpecifiesRecipientOf
	 * @model opposite="specifiesRecipientOf"
	 * @generated
	 */
	RecipientSpecification getRecipientSpecifiedBy();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipientSpecifiedBy <em>Recipient Specified By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recipient Specified By</em>' reference.
	 * @see #getRecipientSpecifiedBy()
	 * @generated
	 */
	void setRecipientSpecifiedBy(RecipientSpecification value);

	/**
	 * Returns the value of the '<em><b>Recipient</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipient</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recipient</em>' reference.
	 * @see #setRecipient(DataFlowEntity)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRecipientSpecifiable_Recipient()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getReceive
	 * @model opposite="receive" required="true"
	 * @generated
	 */
	DataFlowEntity getRecipient();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipient <em>Recipient</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recipient</em>' reference.
	 * @see #getRecipient()
	 * @generated
	 */
	void setRecipient(DataFlowEntity value);

} // RecipientSpecifiable
