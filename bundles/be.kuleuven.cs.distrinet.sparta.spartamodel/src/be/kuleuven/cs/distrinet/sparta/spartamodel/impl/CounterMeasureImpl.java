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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Counter Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl#getMitigates <em>Mitigates</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl#getSecuritysubobjective <em>Securitysubobjective</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl#getDifficulty <em>Difficulty</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl#getMitigatedThreatTypeID <em>Mitigated Threat Type ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CounterMeasureImpl extends SecurityElementImpl implements CounterMeasure {
	/**
	 * The cached value of the '{@link #getMitigates() <em>Mitigates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMitigates()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractThreatType> mitigates;

	/**
	 * The cached value of the '{@link #getSecuritysubobjective() <em>Securitysubobjective</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecuritysubobjective()
	 * @generated
	 * @ordered
	 */
	protected EList<CounterMeasure> securitysubobjective;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> scope;

	/**
	 * The cached value of the '{@link #getSubject() <em>Subject</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> subject;

	/**
	 * The cached value of the '{@link #getDifficulty() <em>Difficulty</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDifficulty()
	 * @generated
	 * @ordered
	 */
	protected Estimate difficulty;

	/**
	 * The cached value of the '{@link #getMitigatedThreatTypeID() <em>Mitigated Threat Type ID</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMitigatedThreatTypeID()
	 * @generated
	 * @ordered
	 */
	protected EList<String> mitigatedThreatTypeID;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CounterMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.COUNTER_MEASURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractThreatType> getMitigates() {
		if (mitigates == null) {
			mitigates = new EObjectResolvingEList<AbstractThreatType>(AbstractThreatType.class, this, SpartaModelPackage.COUNTER_MEASURE__MITIGATES);
		}
		return mitigates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CounterMeasure> getSecuritysubobjective() {
		if (securitysubobjective == null) {
			securitysubobjective = new EObjectContainmentEList<CounterMeasure>(CounterMeasure.class, this, SpartaModelPackage.COUNTER_MEASURE__SECURITYSUBOBJECTIVE);
		}
		return securitysubobjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Role> getScope() {
		if (scope == null) {
			scope = new EObjectResolvingEList<Role>(Role.class, this, SpartaModelPackage.COUNTER_MEASURE__SCOPE);
		}
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Role> getSubject() {
		if (subject == null) {
			subject = new EObjectWithInverseResolvingEList.ManyInverse<Role>(Role.class, this, SpartaModelPackage.COUNTER_MEASURE__SUBJECT, SpartaModelPackage.ROLE__SUBJECTED);
		}
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate getDifficulty() {
		return difficulty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDifficulty(Estimate newDifficulty, NotificationChain msgs) {
		Estimate oldDifficulty = difficulty;
		difficulty = newDifficulty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.COUNTER_MEASURE__DIFFICULTY, oldDifficulty, newDifficulty);
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
	public void setDifficulty(Estimate newDifficulty) {
		if (newDifficulty != difficulty) {
			NotificationChain msgs = null;
			if (difficulty != null)
				msgs = ((InternalEObject)difficulty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.COUNTER_MEASURE__DIFFICULTY, null, msgs);
			if (newDifficulty != null)
				msgs = ((InternalEObject)newDifficulty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.COUNTER_MEASURE__DIFFICULTY, null, msgs);
			msgs = basicSetDifficulty(newDifficulty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.COUNTER_MEASURE__DIFFICULTY, newDifficulty, newDifficulty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getMitigatedThreatTypeID() {
		if (mitigatedThreatTypeID == null) {
			mitigatedThreatTypeID = new EDataTypeUniqueEList<String>(String.class, this, SpartaModelPackage.COUNTER_MEASURE__MITIGATED_THREAT_TYPE_ID);
		}
		return mitigatedThreatTypeID;
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
			case SpartaModelPackage.COUNTER_MEASURE__SUBJECT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubject()).basicAdd(otherEnd, msgs);
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
			case SpartaModelPackage.COUNTER_MEASURE__SECURITYSUBOBJECTIVE:
				return ((InternalEList<?>)getSecuritysubobjective()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.COUNTER_MEASURE__SUBJECT:
				return ((InternalEList<?>)getSubject()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.COUNTER_MEASURE__DIFFICULTY:
				return basicSetDifficulty(null, msgs);
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
			case SpartaModelPackage.COUNTER_MEASURE__MITIGATES:
				return getMitigates();
			case SpartaModelPackage.COUNTER_MEASURE__SECURITYSUBOBJECTIVE:
				return getSecuritysubobjective();
			case SpartaModelPackage.COUNTER_MEASURE__SCOPE:
				return getScope();
			case SpartaModelPackage.COUNTER_MEASURE__SUBJECT:
				return getSubject();
			case SpartaModelPackage.COUNTER_MEASURE__DIFFICULTY:
				return getDifficulty();
			case SpartaModelPackage.COUNTER_MEASURE__MITIGATED_THREAT_TYPE_ID:
				return getMitigatedThreatTypeID();
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
			case SpartaModelPackage.COUNTER_MEASURE__MITIGATES:
				getMitigates().clear();
				getMitigates().addAll((Collection<? extends AbstractThreatType>)newValue);
				return;
			case SpartaModelPackage.COUNTER_MEASURE__SECURITYSUBOBJECTIVE:
				getSecuritysubobjective().clear();
				getSecuritysubobjective().addAll((Collection<? extends CounterMeasure>)newValue);
				return;
			case SpartaModelPackage.COUNTER_MEASURE__SCOPE:
				getScope().clear();
				getScope().addAll((Collection<? extends Role>)newValue);
				return;
			case SpartaModelPackage.COUNTER_MEASURE__SUBJECT:
				getSubject().clear();
				getSubject().addAll((Collection<? extends Role>)newValue);
				return;
			case SpartaModelPackage.COUNTER_MEASURE__DIFFICULTY:
				setDifficulty((Estimate)newValue);
				return;
			case SpartaModelPackage.COUNTER_MEASURE__MITIGATED_THREAT_TYPE_ID:
				getMitigatedThreatTypeID().clear();
				getMitigatedThreatTypeID().addAll((Collection<? extends String>)newValue);
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
			case SpartaModelPackage.COUNTER_MEASURE__MITIGATES:
				getMitigates().clear();
				return;
			case SpartaModelPackage.COUNTER_MEASURE__SECURITYSUBOBJECTIVE:
				getSecuritysubobjective().clear();
				return;
			case SpartaModelPackage.COUNTER_MEASURE__SCOPE:
				getScope().clear();
				return;
			case SpartaModelPackage.COUNTER_MEASURE__SUBJECT:
				getSubject().clear();
				return;
			case SpartaModelPackage.COUNTER_MEASURE__DIFFICULTY:
				setDifficulty((Estimate)null);
				return;
			case SpartaModelPackage.COUNTER_MEASURE__MITIGATED_THREAT_TYPE_ID:
				getMitigatedThreatTypeID().clear();
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
			case SpartaModelPackage.COUNTER_MEASURE__MITIGATES:
				return mitigates != null && !mitigates.isEmpty();
			case SpartaModelPackage.COUNTER_MEASURE__SECURITYSUBOBJECTIVE:
				return securitysubobjective != null && !securitysubobjective.isEmpty();
			case SpartaModelPackage.COUNTER_MEASURE__SCOPE:
				return scope != null && !scope.isEmpty();
			case SpartaModelPackage.COUNTER_MEASURE__SUBJECT:
				return subject != null && !subject.isEmpty();
			case SpartaModelPackage.COUNTER_MEASURE__DIFFICULTY:
				return difficulty != null;
			case SpartaModelPackage.COUNTER_MEASURE__MITIGATED_THREAT_TYPE_ID:
				return mitigatedThreatTypeID != null && !mitigatedThreatTypeID.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (mitigatedThreatTypeID: ");
		result.append(mitigatedThreatTypeID);
		result.append(')');
		return result.toString();
	}

} //CounterMeasureImpl
