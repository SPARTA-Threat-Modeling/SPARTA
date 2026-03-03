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

import be.kuleuven.cs.distrinet.sparta.spartamodel.DataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformed Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TransformedDataImpl#getDecKey <em>Dec Key</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TransformedDataImpl#getEncKey <em>Enc Key</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TransformedDataImpl#getDatatype <em>Datatype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformedDataImpl extends DataTypeImpl implements TransformedData {
	/**
	 * The cached value of the '{@link #getDecKey() <em>Dec Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecKey()
	 * @generated
	 * @ordered
	 */
	protected DataType decKey;

	/**
	 * The cached value of the '{@link #getEncKey() <em>Enc Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncKey()
	 * @generated
	 * @ordered
	 */
	protected DataType encKey;

	/**
	 * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatype()
	 * @generated
	 * @ordered
	 */
	protected DataType datatype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformedDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.TRANSFORMED_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getDecKey() {
		if (decKey != null && decKey.eIsProxy()) {
			InternalEObject oldDecKey = (InternalEObject)decKey;
			decKey = (DataType)eResolveProxy(oldDecKey);
			if (decKey != oldDecKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.TRANSFORMED_DATA__DEC_KEY, oldDecKey, decKey));
			}
		}
		return decKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetDecKey() {
		return decKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDecKey(DataType newDecKey) {
		DataType oldDecKey = decKey;
		decKey = newDecKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.TRANSFORMED_DATA__DEC_KEY, oldDecKey, decKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getEncKey() {
		if (encKey != null && encKey.eIsProxy()) {
			InternalEObject oldEncKey = (InternalEObject)encKey;
			encKey = (DataType)eResolveProxy(oldEncKey);
			if (encKey != oldEncKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.TRANSFORMED_DATA__ENC_KEY, oldEncKey, encKey));
			}
		}
		return encKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetEncKey() {
		return encKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEncKey(DataType newEncKey) {
		DataType oldEncKey = encKey;
		encKey = newEncKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.TRANSFORMED_DATA__ENC_KEY, oldEncKey, encKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getDatatype() {
		if (datatype != null && datatype.eIsProxy()) {
			InternalEObject oldDatatype = (InternalEObject)datatype;
			datatype = (DataType)eResolveProxy(oldDatatype);
			if (datatype != oldDatatype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.TRANSFORMED_DATA__DATATYPE, oldDatatype, datatype));
			}
		}
		return datatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetDatatype() {
		return datatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDatatype(DataType newDatatype) {
		DataType oldDatatype = datatype;
		datatype = newDatatype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.TRANSFORMED_DATA__DATATYPE, oldDatatype, datatype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpartaModelPackage.TRANSFORMED_DATA__DEC_KEY:
				if (resolve) return getDecKey();
				return basicGetDecKey();
			case SpartaModelPackage.TRANSFORMED_DATA__ENC_KEY:
				if (resolve) return getEncKey();
				return basicGetEncKey();
			case SpartaModelPackage.TRANSFORMED_DATA__DATATYPE:
				if (resolve) return getDatatype();
				return basicGetDatatype();
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
			case SpartaModelPackage.TRANSFORMED_DATA__DEC_KEY:
				setDecKey((DataType)newValue);
				return;
			case SpartaModelPackage.TRANSFORMED_DATA__ENC_KEY:
				setEncKey((DataType)newValue);
				return;
			case SpartaModelPackage.TRANSFORMED_DATA__DATATYPE:
				setDatatype((DataType)newValue);
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
			case SpartaModelPackage.TRANSFORMED_DATA__DEC_KEY:
				setDecKey((DataType)null);
				return;
			case SpartaModelPackage.TRANSFORMED_DATA__ENC_KEY:
				setEncKey((DataType)null);
				return;
			case SpartaModelPackage.TRANSFORMED_DATA__DATATYPE:
				setDatatype((DataType)null);
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
			case SpartaModelPackage.TRANSFORMED_DATA__DEC_KEY:
				return decKey != null;
			case SpartaModelPackage.TRANSFORMED_DATA__ENC_KEY:
				return encKey != null;
			case SpartaModelPackage.TRANSFORMED_DATA__DATATYPE:
				return datatype != null;
		}
		return super.eIsSet(featureID);
	}

} //TransformedDataImpl
