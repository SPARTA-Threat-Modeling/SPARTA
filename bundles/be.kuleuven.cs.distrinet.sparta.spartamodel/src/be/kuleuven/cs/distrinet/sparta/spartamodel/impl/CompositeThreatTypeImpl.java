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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Threat Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CompositeThreatTypeImpl#getSubThreatTypes <em>Sub Threat Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CompositeThreatTypeImpl extends AbstractThreatTypeImpl implements CompositeThreatType {
	/**
	 * The cached value of the '{@link #getSubThreatTypes() <em>Sub Threat Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubThreatTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractThreatType> subThreatTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeThreatTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.COMPOSITE_THREAT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractThreatType> getSubThreatTypes() {
		if (subThreatTypes == null) {
			subThreatTypes = new EObjectContainmentWithInverseEList<AbstractThreatType>(AbstractThreatType.class, this, SpartaModelPackage.COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES, SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE);
		}
		return subThreatTypes;
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
			case SpartaModelPackage.COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubThreatTypes()).basicAdd(otherEnd, msgs);
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
			case SpartaModelPackage.COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES:
				return ((InternalEList<?>)getSubThreatTypes()).basicRemove(otherEnd, msgs);
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
			case SpartaModelPackage.COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES:
				return getSubThreatTypes();
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
			case SpartaModelPackage.COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES:
				getSubThreatTypes().clear();
				getSubThreatTypes().addAll((Collection<? extends AbstractThreatType>)newValue);
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
			case SpartaModelPackage.COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES:
				getSubThreatTypes().clear();
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
			case SpartaModelPackage.COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES:
				return subThreatTypes != null && !subThreatTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeThreatTypeImpl
