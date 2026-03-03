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
 * A representation of the model object '<em><b>Recipient Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification#getSpecifiesRecipientOf <em>Specifies Recipient Of</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRecipientSpecification()
 * @model
 * @generated
 */
public interface RecipientSpecification extends RecipientSpecifiable {
	/**
	 * Returns the value of the '<em><b>Specifies Recipient Of</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipientSpecifiedBy <em>Recipient Specified By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specifies Recipient Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specifies Recipient Of</em>' reference.
	 * @see #setSpecifiesRecipientOf(RecipientSpecifiable)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getRecipientSpecification_SpecifiesRecipientOf()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipientSpecifiedBy
	 * @model opposite="recipientSpecifiedBy" required="true"
	 * @generated
	 */
	RecipientSpecifiable getSpecifiesRecipientOf();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification#getSpecifiesRecipientOf <em>Specifies Recipient Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specifies Recipient Of</em>' reference.
	 * @see #getSpecifiesRecipientOf()
	 * @generated
	 */
	void setSpecifiesRecipientOf(RecipientSpecifiable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DataFlow getDataFlow();

} // RecipientSpecification
