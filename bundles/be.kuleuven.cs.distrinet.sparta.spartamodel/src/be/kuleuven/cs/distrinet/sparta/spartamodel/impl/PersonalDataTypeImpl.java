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

import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Personal Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.PersonalDataTypeImpl#getSensitivity <em>Sensitivity</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.PersonalDataTypeImpl#getNbrOfRecords <em>Nbr Of Records</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.PersonalDataTypeImpl#getRetention <em>Retention</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonalDataTypeImpl extends DataTypeImpl implements PersonalDataType {
	/**
	 * The cached value of the '{@link #getSensitivity() <em>Sensitivity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSensitivity()
	 * @generated
	 * @ordered
	 */
	protected Estimate sensitivity;
	/**
	 * The cached value of the '{@link #getNbrOfRecords() <em>Nbr Of Records</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbrOfRecords()
	 * @generated
	 * @ordered
	 */
	protected Estimate nbrOfRecords;
	/**
	 * The cached value of the '{@link #getRetention() <em>Retention</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetention()
	 * @generated
	 * @ordered
	 */
	protected Estimate retention;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonalDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.PERSONAL_DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate getSensitivity() {
		return sensitivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSensitivity(Estimate newSensitivity, NotificationChain msgs) {
		Estimate oldSensitivity = sensitivity;
		sensitivity = newSensitivity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.PERSONAL_DATA_TYPE__SENSITIVITY, oldSensitivity, newSensitivity);
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
	public void setSensitivity(Estimate newSensitivity) {
		if (newSensitivity != sensitivity) {
			NotificationChain msgs = null;
			if (sensitivity != null)
				msgs = ((InternalEObject)sensitivity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.PERSONAL_DATA_TYPE__SENSITIVITY, null, msgs);
			if (newSensitivity != null)
				msgs = ((InternalEObject)newSensitivity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.PERSONAL_DATA_TYPE__SENSITIVITY, null, msgs);
			msgs = basicSetSensitivity(newSensitivity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.PERSONAL_DATA_TYPE__SENSITIVITY, newSensitivity, newSensitivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate getNbrOfRecords() {
		return nbrOfRecords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNbrOfRecords(Estimate newNbrOfRecords, NotificationChain msgs) {
		Estimate oldNbrOfRecords = nbrOfRecords;
		nbrOfRecords = newNbrOfRecords;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.PERSONAL_DATA_TYPE__NBR_OF_RECORDS, oldNbrOfRecords, newNbrOfRecords);
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
	public void setNbrOfRecords(Estimate newNbrOfRecords) {
		if (newNbrOfRecords != nbrOfRecords) {
			NotificationChain msgs = null;
			if (nbrOfRecords != null)
				msgs = ((InternalEObject)nbrOfRecords).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.PERSONAL_DATA_TYPE__NBR_OF_RECORDS, null, msgs);
			if (newNbrOfRecords != null)
				msgs = ((InternalEObject)newNbrOfRecords).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.PERSONAL_DATA_TYPE__NBR_OF_RECORDS, null, msgs);
			msgs = basicSetNbrOfRecords(newNbrOfRecords, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.PERSONAL_DATA_TYPE__NBR_OF_RECORDS, newNbrOfRecords, newNbrOfRecords));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate getRetention() {
		return retention;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRetention(Estimate newRetention, NotificationChain msgs) {
		Estimate oldRetention = retention;
		retention = newRetention;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.PERSONAL_DATA_TYPE__RETENTION, oldRetention, newRetention);
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
	public void setRetention(Estimate newRetention) {
		if (newRetention != retention) {
			NotificationChain msgs = null;
			if (retention != null)
				msgs = ((InternalEObject)retention).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.PERSONAL_DATA_TYPE__RETENTION, null, msgs);
			if (newRetention != null)
				msgs = ((InternalEObject)newRetention).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.PERSONAL_DATA_TYPE__RETENTION, null, msgs);
			msgs = basicSetRetention(newRetention, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.PERSONAL_DATA_TYPE__RETENTION, newRetention, newRetention));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.PERSONAL_DATA_TYPE__SENSITIVITY:
				return basicSetSensitivity(null, msgs);
			case SpartaModelPackage.PERSONAL_DATA_TYPE__NBR_OF_RECORDS:
				return basicSetNbrOfRecords(null, msgs);
			case SpartaModelPackage.PERSONAL_DATA_TYPE__RETENTION:
				return basicSetRetention(null, msgs);
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
			case SpartaModelPackage.PERSONAL_DATA_TYPE__SENSITIVITY:
				return getSensitivity();
			case SpartaModelPackage.PERSONAL_DATA_TYPE__NBR_OF_RECORDS:
				return getNbrOfRecords();
			case SpartaModelPackage.PERSONAL_DATA_TYPE__RETENTION:
				return getRetention();
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
			case SpartaModelPackage.PERSONAL_DATA_TYPE__SENSITIVITY:
				setSensitivity((Estimate)newValue);
				return;
			case SpartaModelPackage.PERSONAL_DATA_TYPE__NBR_OF_RECORDS:
				setNbrOfRecords((Estimate)newValue);
				return;
			case SpartaModelPackage.PERSONAL_DATA_TYPE__RETENTION:
				setRetention((Estimate)newValue);
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
			case SpartaModelPackage.PERSONAL_DATA_TYPE__SENSITIVITY:
				setSensitivity((Estimate)null);
				return;
			case SpartaModelPackage.PERSONAL_DATA_TYPE__NBR_OF_RECORDS:
				setNbrOfRecords((Estimate)null);
				return;
			case SpartaModelPackage.PERSONAL_DATA_TYPE__RETENTION:
				setRetention((Estimate)null);
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
			case SpartaModelPackage.PERSONAL_DATA_TYPE__SENSITIVITY:
				return sensitivity != null;
			case SpartaModelPackage.PERSONAL_DATA_TYPE__NBR_OF_RECORDS:
				return nbrOfRecords != null;
			case SpartaModelPackage.PERSONAL_DATA_TYPE__RETENTION:
				return retention != null;
		}
		return super.eIsSet(featureID);
	}

} //PersonalDataTypeImpl
