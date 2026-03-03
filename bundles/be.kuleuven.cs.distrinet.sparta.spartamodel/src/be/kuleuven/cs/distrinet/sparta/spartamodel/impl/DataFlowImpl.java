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
package be.kuleuven.cs.distrinet.sparta.spartamodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowImpl#getSenderSpecifiedBy <em>Sender Specified By</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowImpl#getRecipientSpecifiedBy <em>Recipient Specified By</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowImpl#getRecipient <em>Recipient</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataFlowImpl extends FlowElementImpl implements DataFlow {
	/**
	 * The cached value of the '{@link #getSenderSpecifiedBy() <em>Sender Specified By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenderSpecifiedBy()
	 * @generated
	 * @ordered
	 */
	protected SenderSpecification senderSpecifiedBy;

	/**
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected DataFlowEntity sender;

	/**
	 * The cached value of the '{@link #getRecipientSpecifiedBy() <em>Recipient Specified By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecipientSpecifiedBy()
	 * @generated
	 * @ordered
	 */
	protected RecipientSpecification recipientSpecifiedBy;

	/**
	 * The cached value of the '{@link #getRecipient() <em>Recipient</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecipient()
	 * @generated
	 * @ordered
	 */
	protected DataFlowEntity recipient;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.DATA_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SenderSpecification getSenderSpecifiedBy() {
		if (senderSpecifiedBy != null && senderSpecifiedBy.eIsProxy()) {
			InternalEObject oldSenderSpecifiedBy = (InternalEObject)senderSpecifiedBy;
			senderSpecifiedBy = (SenderSpecification)eResolveProxy(oldSenderSpecifiedBy);
			if (senderSpecifiedBy != oldSenderSpecifiedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.DATA_FLOW__SENDER_SPECIFIED_BY, oldSenderSpecifiedBy, senderSpecifiedBy));
			}
		}
		return senderSpecifiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SenderSpecification basicGetSenderSpecifiedBy() {
		return senderSpecifiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSenderSpecifiedBy(SenderSpecification newSenderSpecifiedBy, NotificationChain msgs) {
		SenderSpecification oldSenderSpecifiedBy = senderSpecifiedBy;
		senderSpecifiedBy = newSenderSpecifiedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_FLOW__SENDER_SPECIFIED_BY, oldSenderSpecifiedBy, newSenderSpecifiedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSenderSpecifiedBy(SenderSpecification newSenderSpecifiedBy) {
		if (newSenderSpecifiedBy != senderSpecifiedBy) {
			NotificationChain msgs = null;
			if (senderSpecifiedBy != null)
				msgs = ((InternalEObject)senderSpecifiedBy).eInverseRemove(this, SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF, SenderSpecification.class, msgs);
			if (newSenderSpecifiedBy != null)
				msgs = ((InternalEObject)newSenderSpecifiedBy).eInverseAdd(this, SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF, SenderSpecification.class, msgs);
			msgs = basicSetSenderSpecifiedBy(newSenderSpecifiedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_FLOW__SENDER_SPECIFIED_BY, newSenderSpecifiedBy, newSenderSpecifiedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataFlowEntity getSender() {
		if (sender != null && sender.eIsProxy()) {
			InternalEObject oldSender = (InternalEObject)sender;
			sender = (DataFlowEntity)eResolveProxy(oldSender);
			if (sender != oldSender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.DATA_FLOW__SENDER, oldSender, sender));
			}
		}
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowEntity basicGetSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSender(DataFlowEntity newSender, NotificationChain msgs) {
		DataFlowEntity oldSender = sender;
		sender = newSender;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_FLOW__SENDER, oldSender, newSender);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSender(DataFlowEntity newSender) {
		if (newSender != sender) {
			NotificationChain msgs = null;
			if (sender != null)
				msgs = ((InternalEObject)sender).eInverseRemove(this, SpartaModelPackage.DATA_FLOW_ENTITY__SEND, DataFlowEntity.class, msgs);
			if (newSender != null)
				msgs = ((InternalEObject)newSender).eInverseAdd(this, SpartaModelPackage.DATA_FLOW_ENTITY__SEND, DataFlowEntity.class, msgs);
			msgs = basicSetSender(newSender, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_FLOW__SENDER, newSender, newSender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecipientSpecification getRecipientSpecifiedBy() {
		if (recipientSpecifiedBy != null && recipientSpecifiedBy.eIsProxy()) {
			InternalEObject oldRecipientSpecifiedBy = (InternalEObject)recipientSpecifiedBy;
			recipientSpecifiedBy = (RecipientSpecification)eResolveProxy(oldRecipientSpecifiedBy);
			if (recipientSpecifiedBy != oldRecipientSpecifiedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY, oldRecipientSpecifiedBy, recipientSpecifiedBy));
			}
		}
		return recipientSpecifiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientSpecification basicGetRecipientSpecifiedBy() {
		return recipientSpecifiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecipientSpecifiedBy(RecipientSpecification newRecipientSpecifiedBy, NotificationChain msgs) {
		RecipientSpecification oldRecipientSpecifiedBy = recipientSpecifiedBy;
		recipientSpecifiedBy = newRecipientSpecifiedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY, oldRecipientSpecifiedBy, newRecipientSpecifiedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecipientSpecifiedBy(RecipientSpecification newRecipientSpecifiedBy) {
		if (newRecipientSpecifiedBy != recipientSpecifiedBy) {
			NotificationChain msgs = null;
			if (recipientSpecifiedBy != null)
				msgs = ((InternalEObject)recipientSpecifiedBy).eInverseRemove(this, SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF, RecipientSpecification.class, msgs);
			if (newRecipientSpecifiedBy != null)
				msgs = ((InternalEObject)newRecipientSpecifiedBy).eInverseAdd(this, SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF, RecipientSpecification.class, msgs);
			msgs = basicSetRecipientSpecifiedBy(newRecipientSpecifiedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY, newRecipientSpecifiedBy, newRecipientSpecifiedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataFlowEntity getRecipient() {
		if (recipient != null && recipient.eIsProxy()) {
			InternalEObject oldRecipient = (InternalEObject)recipient;
			recipient = (DataFlowEntity)eResolveProxy(oldRecipient);
			if (recipient != oldRecipient) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.DATA_FLOW__RECIPIENT, oldRecipient, recipient));
			}
		}
		return recipient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowEntity basicGetRecipient() {
		return recipient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecipient(DataFlowEntity newRecipient, NotificationChain msgs) {
		DataFlowEntity oldRecipient = recipient;
		recipient = newRecipient;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_FLOW__RECIPIENT, oldRecipient, newRecipient);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecipient(DataFlowEntity newRecipient) {
		if (newRecipient != recipient) {
			NotificationChain msgs = null;
			if (recipient != null)
				msgs = ((InternalEObject)recipient).eInverseRemove(this, SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE, DataFlowEntity.class, msgs);
			if (newRecipient != null)
				msgs = ((InternalEObject)newRecipient).eInverseAdd(this, SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE, DataFlowEntity.class, msgs);
			msgs = basicSetRecipient(newRecipient, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_FLOW__RECIPIENT, newRecipient, newRecipient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataFlow getDataFlow() {
		return this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.DATA_FLOW__SENDER_SPECIFIED_BY:
				if (senderSpecifiedBy != null)
					msgs = ((InternalEObject)senderSpecifiedBy).eInverseRemove(this, SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF, SenderSpecification.class, msgs);
				return basicSetSenderSpecifiedBy((SenderSpecification)otherEnd, msgs);
			case SpartaModelPackage.DATA_FLOW__SENDER:
				if (sender != null)
					msgs = ((InternalEObject)sender).eInverseRemove(this, SpartaModelPackage.DATA_FLOW_ENTITY__SEND, DataFlowEntity.class, msgs);
				return basicSetSender((DataFlowEntity)otherEnd, msgs);
			case SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY:
				if (recipientSpecifiedBy != null)
					msgs = ((InternalEObject)recipientSpecifiedBy).eInverseRemove(this, SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF, RecipientSpecification.class, msgs);
				return basicSetRecipientSpecifiedBy((RecipientSpecification)otherEnd, msgs);
			case SpartaModelPackage.DATA_FLOW__RECIPIENT:
				if (recipient != null)
					msgs = ((InternalEObject)recipient).eInverseRemove(this, SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE, DataFlowEntity.class, msgs);
				return basicSetRecipient((DataFlowEntity)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.DATA_FLOW__SENDER_SPECIFIED_BY:
				return basicSetSenderSpecifiedBy(null, msgs);
			case SpartaModelPackage.DATA_FLOW__SENDER:
				return basicSetSender(null, msgs);
			case SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY:
				return basicSetRecipientSpecifiedBy(null, msgs);
			case SpartaModelPackage.DATA_FLOW__RECIPIENT:
				return basicSetRecipient(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpartaModelPackage.DATA_FLOW__SENDER_SPECIFIED_BY:
				if (resolve) return getSenderSpecifiedBy();
				return basicGetSenderSpecifiedBy();
			case SpartaModelPackage.DATA_FLOW__SENDER:
				if (resolve) return getSender();
				return basicGetSender();
			case SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY:
				if (resolve) return getRecipientSpecifiedBy();
				return basicGetRecipientSpecifiedBy();
			case SpartaModelPackage.DATA_FLOW__RECIPIENT:
				if (resolve) return getRecipient();
				return basicGetRecipient();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpartaModelPackage.DATA_FLOW__SENDER_SPECIFIED_BY:
				setSenderSpecifiedBy((SenderSpecification)newValue);
				return;
			case SpartaModelPackage.DATA_FLOW__SENDER:
				setSender((DataFlowEntity)newValue);
				return;
			case SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY:
				setRecipientSpecifiedBy((RecipientSpecification)newValue);
				return;
			case SpartaModelPackage.DATA_FLOW__RECIPIENT:
				setRecipient((DataFlowEntity)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SpartaModelPackage.DATA_FLOW__SENDER_SPECIFIED_BY:
				setSenderSpecifiedBy((SenderSpecification)null);
				return;
			case SpartaModelPackage.DATA_FLOW__SENDER:
				setSender((DataFlowEntity)null);
				return;
			case SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY:
				setRecipientSpecifiedBy((RecipientSpecification)null);
				return;
			case SpartaModelPackage.DATA_FLOW__RECIPIENT:
				setRecipient((DataFlowEntity)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SpartaModelPackage.DATA_FLOW__SENDER_SPECIFIED_BY:
				return senderSpecifiedBy != null;
			case SpartaModelPackage.DATA_FLOW__SENDER:
				return sender != null;
			case SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY:
				return recipientSpecifiedBy != null;
			case SpartaModelPackage.DATA_FLOW__RECIPIENT:
				return recipient != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == RecipientSpecifiable.class) {
			switch (derivedFeatureID) {
				case SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY: return SpartaModelPackage.RECIPIENT_SPECIFIABLE__RECIPIENT_SPECIFIED_BY;
				case SpartaModelPackage.DATA_FLOW__RECIPIENT: return SpartaModelPackage.RECIPIENT_SPECIFIABLE__RECIPIENT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == RecipientSpecifiable.class) {
			switch (baseFeatureID) {
				case SpartaModelPackage.RECIPIENT_SPECIFIABLE__RECIPIENT_SPECIFIED_BY: return SpartaModelPackage.DATA_FLOW__RECIPIENT_SPECIFIED_BY;
				case SpartaModelPackage.RECIPIENT_SPECIFIABLE__RECIPIENT: return SpartaModelPackage.DATA_FLOW__RECIPIENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SpartaModelPackage.DATA_FLOW___GET_DATA_FLOW:
				return getDataFlow();
		}
		return super.eInvoke(operationID, arguments);
	}

} //DataFlowImpl
