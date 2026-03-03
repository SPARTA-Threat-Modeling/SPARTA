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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Composite Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SingleCompositeConditionImpl#getSubcondition <em>Subcondition</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SingleCompositeConditionImpl extends CompositeConditionImpl implements SingleCompositeCondition {
	/**
	 * The cached value of the '{@link #getSubcondition() <em>Subcondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubcondition()
	 * @generated
	 * @ordered
	 */
	protected AbstractCondition subcondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleCompositeConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.SINGLE_COMPOSITE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractCondition getSubcondition() {
		return subcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubcondition(AbstractCondition newSubcondition, NotificationChain msgs) {
		AbstractCondition oldSubcondition = subcondition;
		subcondition = newSubcondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.SINGLE_COMPOSITE_CONDITION__SUBCONDITION, oldSubcondition, newSubcondition);
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
	public void setSubcondition(AbstractCondition newSubcondition) {
		if (newSubcondition != subcondition) {
			NotificationChain msgs = null;
			if (subcondition != null)
				msgs = ((InternalEObject)subcondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.SINGLE_COMPOSITE_CONDITION__SUBCONDITION, null, msgs);
			if (newSubcondition != null)
				msgs = ((InternalEObject)newSubcondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.SINGLE_COMPOSITE_CONDITION__SUBCONDITION, null, msgs);
			msgs = basicSetSubcondition(newSubcondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.SINGLE_COMPOSITE_CONDITION__SUBCONDITION, newSubcondition, newSubcondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.SINGLE_COMPOSITE_CONDITION__SUBCONDITION:
				return basicSetSubcondition(null, msgs);
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
			case SpartaModelPackage.SINGLE_COMPOSITE_CONDITION__SUBCONDITION:
				return getSubcondition();
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
			case SpartaModelPackage.SINGLE_COMPOSITE_CONDITION__SUBCONDITION:
				setSubcondition((AbstractCondition)newValue);
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
			case SpartaModelPackage.SINGLE_COMPOSITE_CONDITION__SUBCONDITION:
				setSubcondition((AbstractCondition)null);
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
			case SpartaModelPackage.SINGLE_COMPOSITE_CONDITION__SUBCONDITION:
				return subcondition != null;
		}
		return super.eIsSet(featureID);
	}

} //SingleCompositeConditionImpl
