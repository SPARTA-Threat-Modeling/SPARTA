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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowEntityImpl#getSend <em>Send</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowEntityImpl#getReceive <em>Receive</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataFlowEntityImpl extends DFDContainerImpl implements DataFlowEntity {
	/**
	 * The cached value of the '{@link #getSend() <em>Send</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSend()
	 * @generated
	 * @ordered
	 */
	protected EList<SenderSpecifiable> send;

	/**
	 * The cached value of the '{@link #getReceive() <em>Receive</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceive()
	 * @generated
	 * @ordered
	 */
	protected EList<RecipientSpecifiable> receive;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.DATA_FLOW_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SenderSpecifiable> getSend() {
		if (send == null) {
			send = new EObjectWithInverseResolvingEList<SenderSpecifiable>(SenderSpecifiable.class, this, SpartaModelPackage.DATA_FLOW_ENTITY__SEND, SpartaModelPackage.SENDER_SPECIFIABLE__SENDER);
		}
		return send;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RecipientSpecifiable> getReceive() {
		if (receive == null) {
			receive = new EObjectWithInverseResolvingEList<RecipientSpecifiable>(RecipientSpecifiable.class, this, SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE, SpartaModelPackage.RECIPIENT_SPECIFIABLE__RECIPIENT);
		}
		return receive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.DATA_FLOW_ENTITY__SEND:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSend()).basicAdd(otherEnd, msgs);
			case SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReceive()).basicAdd(otherEnd, msgs);
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
			case SpartaModelPackage.DATA_FLOW_ENTITY__SEND:
				return ((InternalEList<?>)getSend()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE:
				return ((InternalEList<?>)getReceive()).basicRemove(otherEnd, msgs);
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
			case SpartaModelPackage.DATA_FLOW_ENTITY__SEND:
				return getSend();
			case SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE:
				return getReceive();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpartaModelPackage.DATA_FLOW_ENTITY__SEND:
				getSend().clear();
				getSend().addAll((Collection<? extends SenderSpecifiable>)newValue);
				return;
			case SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE:
				getReceive().clear();
				getReceive().addAll((Collection<? extends RecipientSpecifiable>)newValue);
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
			case SpartaModelPackage.DATA_FLOW_ENTITY__SEND:
				getSend().clear();
				return;
			case SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE:
				getReceive().clear();
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
			case SpartaModelPackage.DATA_FLOW_ENTITY__SEND:
				return send != null && !send.isEmpty();
			case SpartaModelPackage.DATA_FLOW_ENTITY__RECEIVE:
				return receive != null && !receive.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataFlowEntityImpl
