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

import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Subject Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSubjectTypeImpl#getDfdelement <em>Dfdelement</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSubjectTypeImpl#getPersonaldatatype <em>Personaldatatype</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSubjectTypeImpl#getSensitivity <em>Sensitivity</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSubjectTypeImpl#getNbrOfSubjects <em>Nbr Of Subjects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataSubjectTypeImpl extends MinimalEObjectImpl.Container implements DataSubjectType {
	/**
	 * The cached value of the '{@link #getDfdelement() <em>Dfdelement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDfdelement()
	 * @generated
	 * @ordered
	 */
	protected EList<DFDElement> dfdelement;

	/**
	 * The cached value of the '{@link #getPersonaldatatype() <em>Personaldatatype</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersonaldatatype()
	 * @generated
	 * @ordered
	 */
	protected EList<PersonalDataType> personaldatatype;

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
	 * The cached value of the '{@link #getNbrOfSubjects() <em>Nbr Of Subjects</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbrOfSubjects()
	 * @generated
	 * @ordered
	 */
	protected Estimate nbrOfSubjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSubjectTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.DATA_SUBJECT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DFDElement> getDfdelement() {
		if (dfdelement == null) {
			dfdelement = new EObjectWithInverseResolvingEList.ManyInverse<DFDElement>(DFDElement.class, this, SpartaModelPackage.DATA_SUBJECT_TYPE__DFDELEMENT, SpartaModelPackage.DFD_ELEMENT__DFDELEMENTANNOTATION);
		}
		return dfdelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PersonalDataType> getPersonaldatatype() {
		if (personaldatatype == null) {
			personaldatatype = new EObjectResolvingEList<PersonalDataType>(PersonalDataType.class, this, SpartaModelPackage.DATA_SUBJECT_TYPE__PERSONALDATATYPE);
		}
		return personaldatatype;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_SUBJECT_TYPE__SENSITIVITY, oldSensitivity, newSensitivity);
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
				msgs = ((InternalEObject)sensitivity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.DATA_SUBJECT_TYPE__SENSITIVITY, null, msgs);
			if (newSensitivity != null)
				msgs = ((InternalEObject)newSensitivity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.DATA_SUBJECT_TYPE__SENSITIVITY, null, msgs);
			msgs = basicSetSensitivity(newSensitivity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_SUBJECT_TYPE__SENSITIVITY, newSensitivity, newSensitivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate getNbrOfSubjects() {
		return nbrOfSubjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNbrOfSubjects(Estimate newNbrOfSubjects, NotificationChain msgs) {
		Estimate oldNbrOfSubjects = nbrOfSubjects;
		nbrOfSubjects = newNbrOfSubjects;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS, oldNbrOfSubjects, newNbrOfSubjects);
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
	public void setNbrOfSubjects(Estimate newNbrOfSubjects) {
		if (newNbrOfSubjects != nbrOfSubjects) {
			NotificationChain msgs = null;
			if (nbrOfSubjects != null)
				msgs = ((InternalEObject)nbrOfSubjects).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS, null, msgs);
			if (newNbrOfSubjects != null)
				msgs = ((InternalEObject)newNbrOfSubjects).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS, null, msgs);
			msgs = basicSetNbrOfSubjects(newNbrOfSubjects, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS, newNbrOfSubjects, newNbrOfSubjects));
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
			case SpartaModelPackage.DATA_SUBJECT_TYPE__DFDELEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDfdelement()).basicAdd(otherEnd, msgs);
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
			case SpartaModelPackage.DATA_SUBJECT_TYPE__DFDELEMENT:
				return ((InternalEList<?>)getDfdelement()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.DATA_SUBJECT_TYPE__SENSITIVITY:
				return basicSetSensitivity(null, msgs);
			case SpartaModelPackage.DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS:
				return basicSetNbrOfSubjects(null, msgs);
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
			case SpartaModelPackage.DATA_SUBJECT_TYPE__DFDELEMENT:
				return getDfdelement();
			case SpartaModelPackage.DATA_SUBJECT_TYPE__PERSONALDATATYPE:
				return getPersonaldatatype();
			case SpartaModelPackage.DATA_SUBJECT_TYPE__SENSITIVITY:
				return getSensitivity();
			case SpartaModelPackage.DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS:
				return getNbrOfSubjects();
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
			case SpartaModelPackage.DATA_SUBJECT_TYPE__DFDELEMENT:
				getDfdelement().clear();
				getDfdelement().addAll((Collection<? extends DFDElement>)newValue);
				return;
			case SpartaModelPackage.DATA_SUBJECT_TYPE__PERSONALDATATYPE:
				getPersonaldatatype().clear();
				getPersonaldatatype().addAll((Collection<? extends PersonalDataType>)newValue);
				return;
			case SpartaModelPackage.DATA_SUBJECT_TYPE__SENSITIVITY:
				setSensitivity((Estimate)newValue);
				return;
			case SpartaModelPackage.DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS:
				setNbrOfSubjects((Estimate)newValue);
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
			case SpartaModelPackage.DATA_SUBJECT_TYPE__DFDELEMENT:
				getDfdelement().clear();
				return;
			case SpartaModelPackage.DATA_SUBJECT_TYPE__PERSONALDATATYPE:
				getPersonaldatatype().clear();
				return;
			case SpartaModelPackage.DATA_SUBJECT_TYPE__SENSITIVITY:
				setSensitivity((Estimate)null);
				return;
			case SpartaModelPackage.DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS:
				setNbrOfSubjects((Estimate)null);
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
			case SpartaModelPackage.DATA_SUBJECT_TYPE__DFDELEMENT:
				return dfdelement != null && !dfdelement.isEmpty();
			case SpartaModelPackage.DATA_SUBJECT_TYPE__PERSONALDATATYPE:
				return personaldatatype != null && !personaldatatype.isEmpty();
			case SpartaModelPackage.DATA_SUBJECT_TYPE__SENSITIVITY:
				return sensitivity != null;
			case SpartaModelPackage.DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS:
				return nbrOfSubjects != null;
		}
		return super.eIsSet(featureID);
	}

} //DataSubjectTypeImpl
