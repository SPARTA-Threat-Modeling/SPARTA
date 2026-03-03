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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityAnnotation;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DFD Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDElementImpl#getSecurityannotation <em>Securityannotation</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDElementImpl#getDfdelementannotation <em>Dfdelementannotation</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DFDElementImpl extends AssetImpl implements DFDElement {
	/**
	 * The cached value of the '{@link #getSecurityannotation() <em>Securityannotation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityannotation()
	 * @generated
	 * @ordered
	 */
	protected EList<SecurityAnnotation> securityannotation;

	/**
	 * The cached value of the '{@link #getDfdelementannotation() <em>Dfdelementannotation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDfdelementannotation()
	 * @generated
	 * @ordered
	 */
	protected EList<DFDElementAnnotation> dfdelementannotation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFDElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.DFD_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SecurityAnnotation> getSecurityannotation() {
		if (securityannotation == null) {
			securityannotation = new EObjectContainmentEList<SecurityAnnotation>(SecurityAnnotation.class, this, SpartaModelPackage.DFD_ELEMENT__SECURITYANNOTATION);
		}
		return securityannotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DFDElementAnnotation> getDfdelementannotation() {
		if (dfdelementannotation == null) {
			dfdelementannotation = new EObjectWithInverseResolvingEList.ManyInverse<DFDElementAnnotation>(DFDElementAnnotation.class, this, SpartaModelPackage.DFD_ELEMENT__DFDELEMENTANNOTATION, SpartaModelPackage.DFD_ELEMENT_ANNOTATION__DFDELEMENT);
		}
		return dfdelementannotation;
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
			case SpartaModelPackage.DFD_ELEMENT__DFDELEMENTANNOTATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDfdelementannotation()).basicAdd(otherEnd, msgs);
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
			case SpartaModelPackage.DFD_ELEMENT__SECURITYANNOTATION:
				return ((InternalEList<?>)getSecurityannotation()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.DFD_ELEMENT__DFDELEMENTANNOTATION:
				return ((InternalEList<?>)getDfdelementannotation()).basicRemove(otherEnd, msgs);
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
			case SpartaModelPackage.DFD_ELEMENT__SECURITYANNOTATION:
				return getSecurityannotation();
			case SpartaModelPackage.DFD_ELEMENT__DFDELEMENTANNOTATION:
				return getDfdelementannotation();
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
			case SpartaModelPackage.DFD_ELEMENT__SECURITYANNOTATION:
				getSecurityannotation().clear();
				getSecurityannotation().addAll((Collection<? extends SecurityAnnotation>)newValue);
				return;
			case SpartaModelPackage.DFD_ELEMENT__DFDELEMENTANNOTATION:
				getDfdelementannotation().clear();
				getDfdelementannotation().addAll((Collection<? extends DFDElementAnnotation>)newValue);
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
			case SpartaModelPackage.DFD_ELEMENT__SECURITYANNOTATION:
				getSecurityannotation().clear();
				return;
			case SpartaModelPackage.DFD_ELEMENT__DFDELEMENTANNOTATION:
				getDfdelementannotation().clear();
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
			case SpartaModelPackage.DFD_ELEMENT__SECURITYANNOTATION:
				return securityannotation != null && !securityannotation.isEmpty();
			case SpartaModelPackage.DFD_ELEMENT__DFDELEMENTANNOTATION:
				return dfdelementannotation != null && !dfdelementannotation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DFDElementImpl
