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
import be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sender Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SenderSpecificationImpl#getSenderSpecifiedBy <em>Sender Specified By</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SenderSpecificationImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SenderSpecificationImpl#getSpecifiesSenderOf <em>Specifies Sender Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SenderSpecificationImpl extends FlowElementImpl implements SenderSpecification {
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
	 * The cached value of the '{@link #getSpecifiesSenderOf() <em>Specifies Sender Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiesSenderOf()
	 * @generated
	 * @ordered
	 */
	protected SenderSpecifiable specifiesSenderOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SenderSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.SENDER_SPECIFICATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.SENDER_SPECIFICATION__SENDER_SPECIFIED_BY, oldSenderSpecifiedBy, senderSpecifiedBy));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.SENDER_SPECIFICATION__SENDER_SPECIFIED_BY, oldSenderSpecifiedBy, newSenderSpecifiedBy);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.SENDER_SPECIFICATION__SENDER_SPECIFIED_BY, newSenderSpecifiedBy, newSenderSpecifiedBy));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.SENDER_SPECIFICATION__SENDER, oldSender, sender));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.SENDER_SPECIFICATION__SENDER, oldSender, newSender);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.SENDER_SPECIFICATION__SENDER, newSender, newSender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SenderSpecifiable getSpecifiesSenderOf() {
		if (specifiesSenderOf != null && specifiesSenderOf.eIsProxy()) {
			InternalEObject oldSpecifiesSenderOf = (InternalEObject)specifiesSenderOf;
			specifiesSenderOf = (SenderSpecifiable)eResolveProxy(oldSpecifiesSenderOf);
			if (specifiesSenderOf != oldSpecifiesSenderOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF, oldSpecifiesSenderOf, specifiesSenderOf));
			}
		}
		return specifiesSenderOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SenderSpecifiable basicGetSpecifiesSenderOf() {
		return specifiesSenderOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifiesSenderOf(SenderSpecifiable newSpecifiesSenderOf, NotificationChain msgs) {
		SenderSpecifiable oldSpecifiesSenderOf = specifiesSenderOf;
		specifiesSenderOf = newSpecifiesSenderOf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF, oldSpecifiesSenderOf, newSpecifiesSenderOf);
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
	public void setSpecifiesSenderOf(SenderSpecifiable newSpecifiesSenderOf) {
		if (newSpecifiesSenderOf != specifiesSenderOf) {
			NotificationChain msgs = null;
			if (specifiesSenderOf != null)
				msgs = ((InternalEObject)specifiesSenderOf).eInverseRemove(this, SpartaModelPackage.SENDER_SPECIFIABLE__SENDER_SPECIFIED_BY, SenderSpecifiable.class, msgs);
			if (newSpecifiesSenderOf != null)
				msgs = ((InternalEObject)newSpecifiesSenderOf).eInverseAdd(this, SpartaModelPackage.SENDER_SPECIFIABLE__SENDER_SPECIFIED_BY, SenderSpecifiable.class, msgs);
			msgs = basicSetSpecifiesSenderOf(newSpecifiesSenderOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF, newSpecifiesSenderOf, newSpecifiesSenderOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataFlow getDataFlow() {
		return this.specifiesSenderOf.getDataFlow();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER_SPECIFIED_BY:
				if (senderSpecifiedBy != null)
					msgs = ((InternalEObject)senderSpecifiedBy).eInverseRemove(this, SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF, SenderSpecification.class, msgs);
				return basicSetSenderSpecifiedBy((SenderSpecification)otherEnd, msgs);
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER:
				if (sender != null)
					msgs = ((InternalEObject)sender).eInverseRemove(this, SpartaModelPackage.DATA_FLOW_ENTITY__SEND, DataFlowEntity.class, msgs);
				return basicSetSender((DataFlowEntity)otherEnd, msgs);
			case SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF:
				if (specifiesSenderOf != null)
					msgs = ((InternalEObject)specifiesSenderOf).eInverseRemove(this, SpartaModelPackage.SENDER_SPECIFIABLE__SENDER_SPECIFIED_BY, SenderSpecifiable.class, msgs);
				return basicSetSpecifiesSenderOf((SenderSpecifiable)otherEnd, msgs);
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
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER_SPECIFIED_BY:
				return basicSetSenderSpecifiedBy(null, msgs);
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER:
				return basicSetSender(null, msgs);
			case SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF:
				return basicSetSpecifiesSenderOf(null, msgs);
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
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER_SPECIFIED_BY:
				if (resolve) return getSenderSpecifiedBy();
				return basicGetSenderSpecifiedBy();
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER:
				if (resolve) return getSender();
				return basicGetSender();
			case SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF:
				if (resolve) return getSpecifiesSenderOf();
				return basicGetSpecifiesSenderOf();
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
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER_SPECIFIED_BY:
				setSenderSpecifiedBy((SenderSpecification)newValue);
				return;
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER:
				setSender((DataFlowEntity)newValue);
				return;
			case SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF:
				setSpecifiesSenderOf((SenderSpecifiable)newValue);
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
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER_SPECIFIED_BY:
				setSenderSpecifiedBy((SenderSpecification)null);
				return;
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER:
				setSender((DataFlowEntity)null);
				return;
			case SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF:
				setSpecifiesSenderOf((SenderSpecifiable)null);
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
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER_SPECIFIED_BY:
				return senderSpecifiedBy != null;
			case SpartaModelPackage.SENDER_SPECIFICATION__SENDER:
				return sender != null;
			case SpartaModelPackage.SENDER_SPECIFICATION__SPECIFIES_SENDER_OF:
				return specifiesSenderOf != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SpartaModelPackage.SENDER_SPECIFICATION___GET_DATA_FLOW:
				return getDataFlow();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SenderSpecificationImpl
