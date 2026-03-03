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
 * A representation of the model object '<em><b>Data Flow Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getSend <em>Send</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getReceive <em>Receive</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataFlowEntity()
 * @model abstract="true"
 * @generated
 */
public interface DataFlowEntity extends DFDContainer {
	/**
	 * Returns the value of the '<em><b>Send</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable}.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Send</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Send</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataFlowEntity_Send()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSender
	 * @model opposite="sender"
	 * @generated
	 */
	EList<SenderSpecifiable> getSend();

	/**
	 * Returns the value of the '<em><b>Receive</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable}.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipient <em>Recipient</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receive</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receive</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getDataFlowEntity_Receive()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipient
	 * @model opposite="recipient"
	 * @generated
	 */
	EList<RecipientSpecifiable> getReceive();

} // DataFlowEntity
