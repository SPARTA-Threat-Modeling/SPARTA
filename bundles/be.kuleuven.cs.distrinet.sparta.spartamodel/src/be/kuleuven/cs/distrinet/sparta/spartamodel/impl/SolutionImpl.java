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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionImpl#getSecuritypattern <em>Securitypattern</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionImpl#getRolebinding <em>Rolebinding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionImpl extends SecurityElementImpl implements Solution {
	/**
	 * The cached value of the '{@link #getSecuritypattern() <em>Securitypattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecuritypattern()
	 * @generated
	 * @ordered
	 */
	protected SolutionType securitypattern;

	/**
	 * The cached value of the '{@link #getRolebinding() <em>Rolebinding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRolebinding()
	 * @generated
	 * @ordered
	 */
	protected EList<RoleBinding> rolebinding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.SOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SolutionType getSecuritypattern() {
		if (securitypattern != null && securitypattern.eIsProxy()) {
			InternalEObject oldSecuritypattern = (InternalEObject)securitypattern;
			securitypattern = (SolutionType)eResolveProxy(oldSecuritypattern);
			if (securitypattern != oldSecuritypattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.SOLUTION__SECURITYPATTERN, oldSecuritypattern, securitypattern));
			}
		}
		return securitypattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolutionType basicGetSecuritypattern() {
		return securitypattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecuritypattern(SolutionType newSecuritypattern) {
		SolutionType oldSecuritypattern = securitypattern;
		securitypattern = newSecuritypattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.SOLUTION__SECURITYPATTERN, oldSecuritypattern, securitypattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RoleBinding> getRolebinding() {
		if (rolebinding == null) {
			rolebinding = new EObjectContainmentEList<RoleBinding>(RoleBinding.class, this, SpartaModelPackage.SOLUTION__ROLEBINDING);
		}
		return rolebinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.SOLUTION__ROLEBINDING:
				return ((InternalEList<?>)getRolebinding()).basicRemove(otherEnd, msgs);
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
			case SpartaModelPackage.SOLUTION__SECURITYPATTERN:
				if (resolve) return getSecuritypattern();
				return basicGetSecuritypattern();
			case SpartaModelPackage.SOLUTION__ROLEBINDING:
				return getRolebinding();
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
			case SpartaModelPackage.SOLUTION__SECURITYPATTERN:
				setSecuritypattern((SolutionType)newValue);
				return;
			case SpartaModelPackage.SOLUTION__ROLEBINDING:
				getRolebinding().clear();
				getRolebinding().addAll((Collection<? extends RoleBinding>)newValue);
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
			case SpartaModelPackage.SOLUTION__SECURITYPATTERN:
				setSecuritypattern((SolutionType)null);
				return;
			case SpartaModelPackage.SOLUTION__ROLEBINDING:
				getRolebinding().clear();
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
			case SpartaModelPackage.SOLUTION__SECURITYPATTERN:
				return securitypattern != null;
			case SpartaModelPackage.SOLUTION__ROLEBINDING:
				return rolebinding != null && !rolebinding.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SolutionImpl
