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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imported Threat Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ImportedThreatConditionImpl#getThreattype <em>Threattype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportedThreatConditionImpl extends AImportedConditionImpl implements ImportedThreatCondition {
	/**
	 * The cached value of the '{@link #getThreattype() <em>Threattype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreattype()
	 * @generated
	 * @ordered
	 */
	protected ThreatType threattype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportedThreatConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.IMPORTED_THREAT_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThreatType getThreattype() {
		if (threattype != null && threattype.eIsProxy()) {
			InternalEObject oldThreattype = (InternalEObject)threattype;
			threattype = (ThreatType)eResolveProxy(oldThreattype);
			if (threattype != oldThreattype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.IMPORTED_THREAT_CONDITION__THREATTYPE, oldThreattype, threattype));
			}
		}
		return threattype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatType basicGetThreattype() {
		return threattype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThreattype(ThreatType newThreattype) {
		ThreatType oldThreattype = threattype;
		threattype = newThreattype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.IMPORTED_THREAT_CONDITION__THREATTYPE, oldThreattype, threattype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpartaModelPackage.IMPORTED_THREAT_CONDITION__THREATTYPE:
				if (resolve) return getThreattype();
				return basicGetThreattype();
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
			case SpartaModelPackage.IMPORTED_THREAT_CONDITION__THREATTYPE:
				setThreattype((ThreatType)newValue);
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
			case SpartaModelPackage.IMPORTED_THREAT_CONDITION__THREATTYPE:
				setThreattype((ThreatType)null);
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
			case SpartaModelPackage.IMPORTED_THREAT_CONDITION__THREATTYPE:
				return threattype != null;
		}
		return super.eIsSet(featureID);
	}

} //ImportedThreatConditionImpl
