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
 * A representation of the model object '<em><b>Sender Specifiable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSenderSpecifiedBy <em>Sender Specified By</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSender <em>Sender</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSenderSpecifiable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SenderSpecifiable extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Sender Specified By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification#getSpecifiesSenderOf <em>Specifies Sender Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender Specified By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender Specified By</em>' reference.
	 * @see #setSenderSpecifiedBy(SenderSpecification)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSenderSpecifiable_SenderSpecifiedBy()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification#getSpecifiesSenderOf
	 * @model opposite="specifiesSenderOf"
	 * @generated
	 */
	SenderSpecification getSenderSpecifiedBy();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSenderSpecifiedBy <em>Sender Specified By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender Specified By</em>' reference.
	 * @see #getSenderSpecifiedBy()
	 * @generated
	 */
	void setSenderSpecifiedBy(SenderSpecification value);

	/**
	 * Returns the value of the '<em><b>Sender</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getSend <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender</em>' reference.
	 * @see #setSender(DataFlowEntity)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getSenderSpecifiable_Sender()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getSend
	 * @model opposite="send" required="true"
	 * @generated
	 */
	DataFlowEntity getSender();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSender <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(DataFlowEntity value);

} // SenderSpecifiable
