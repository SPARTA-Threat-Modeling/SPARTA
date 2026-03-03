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
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recipient Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RecipientSpecificationImpl#getRecipientSpecifiedBy <em>Recipient Specified By</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RecipientSpecificationImpl#getRecipient <em>Recipient</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RecipientSpecificationImpl#getSpecifiesRecipientOf <em>Specifies Recipient Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecipientSpecificationImpl extends FlowElementImpl implements RecipientSpecification {
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
	 * The cached value of the '{@link #getSpecifiesRecipientOf() <em>Specifies Recipient Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiesRecipientOf()
	 * @generated
	 * @ordered
	 */
	protected RecipientSpecifiable specifiesRecipientOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecipientSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.RECIPIENT_SPECIFICATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY, oldRecipientSpecifiedBy, recipientSpecifiedBy));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY, oldRecipientSpecifiedBy, newRecipientSpecifiedBy);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY, newRecipientSpecifiedBy, newRecipientSpecifiedBy));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT, oldRecipient, recipient));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT, oldRecipient, newRecipient);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT, newRecipient, newRecipient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecipientSpecifiable getSpecifiesRecipientOf() {
		if (specifiesRecipientOf != null && specifiesRecipientOf.eIsProxy()) {
			InternalEObject oldSpecifiesRecipientOf = (InternalEObject)specifiesRecipientOf;
			specifiesRecipientOf = (RecipientSpecifiable)eResolveProxy(oldSpecifiesRecipientOf);
			if (specifiesRecipientOf != oldSpecifiesRecipientOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF, oldSpecifiesRecipientOf, specifiesRecipientOf));
			}
		}
		return specifiesRecipientOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientSpecifiable basicGetSpecifiesRecipientOf() {
		return specifiesRecipientOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifiesRecipientOf(RecipientSpecifiable newSpecifiesRecipientOf, NotificationChain msgs) {
		RecipientSpecifiable oldSpecifiesRecipientOf = specifiesRecipientOf;
		specifiesRecipientOf = newSpecifiesRecipientOf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF, oldSpecifiesRecipientOf, newSpecifiesRecipientOf);
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
	public void setSpecifiesRecipientOf(RecipientSpecifiable newSpecifiesRecipientOf) {
		if (newSpecifiesRecipientOf != specifiesRecipientOf) {
			NotificationChain msgs = null;
			if (specifiesRecipientOf != null)
				msgs = ((InternalEObject)specifiesRecipientOf).eInverseRemove(this, SpartaModelPackage.RECIPIENT_SPECIFIABLE__RECIPIENT_SPECIFIED_BY, RecipientSpecifiable.class, msgs);
			if (newSpecifiesRecipientOf != null)
				msgs = ((InternalEObject)newSpecifiesRecipientOf).eInverseAdd(this, SpartaModelPackage.RECIPIENT_SPECIFIABLE__RECIPIENT_SPECIFIED_BY, RecipientSpecifiable.class, msgs);
			msgs = basicSetSpecifiesRecipientOf(newSpecifiesRecipientOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF, newSpecifiesRecipientOf, newSpecifiesRecipientOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataFlow getDataFlow() {
		return this.specifiesRecipientOf.getDataFlow();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY:
				if (recipientSpecifiedBy != null)
					msgs = ((InternalEObject)recipientSpecifiedBy).eInverseRemove(this, SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF, RecipientSpecification.class, msgs);
				return basicSetRecipientSpecifiedBy((RecipientSpecification)otherEnd, msgs);
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT:
				if (recipient != null)
					msgs = ((InternalEObject)recipient).eInverseRemove(this, SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE, DataFlowEntity.class, msgs);
				return basicSetRecipient((DataFlowEntity)otherEnd, msgs);
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF:
				if (specifiesRecipientOf != null)
					msgs = ((InternalEObject)specifiesRecipientOf).eInverseRemove(this, SpartaModelPackage.RECIPIENT_SPECIFIABLE__RECIPIENT_SPECIFIED_BY, RecipientSpecifiable.class, msgs);
				return basicSetSpecifiesRecipientOf((RecipientSpecifiable)otherEnd, msgs);
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
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY:
				return basicSetRecipientSpecifiedBy(null, msgs);
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT:
				return basicSetRecipient(null, msgs);
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF:
				return basicSetSpecifiesRecipientOf(null, msgs);
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
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY:
				if (resolve) return getRecipientSpecifiedBy();
				return basicGetRecipientSpecifiedBy();
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT:
				if (resolve) return getRecipient();
				return basicGetRecipient();
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF:
				if (resolve) return getSpecifiesRecipientOf();
				return basicGetSpecifiesRecipientOf();
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
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY:
				setRecipientSpecifiedBy((RecipientSpecification)newValue);
				return;
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT:
				setRecipient((DataFlowEntity)newValue);
				return;
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF:
				setSpecifiesRecipientOf((RecipientSpecifiable)newValue);
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
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY:
				setRecipientSpecifiedBy((RecipientSpecification)null);
				return;
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT:
				setRecipient((DataFlowEntity)null);
				return;
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF:
				setSpecifiesRecipientOf((RecipientSpecifiable)null);
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
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY:
				return recipientSpecifiedBy != null;
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__RECIPIENT:
				return recipient != null;
			case SpartaModelPackage.RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF:
				return specifiesRecipientOf != null;
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
			case SpartaModelPackage.RECIPIENT_SPECIFICATION___GET_DATA_FLOW:
				return getDataFlow();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RecipientSpecificationImpl
