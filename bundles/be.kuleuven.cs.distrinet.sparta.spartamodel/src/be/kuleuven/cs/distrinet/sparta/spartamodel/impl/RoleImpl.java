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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleImpl#getSubjected <em>Subjected</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleImpl#getBindingTypes <em>Binding Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleImpl extends SecurityElementImpl implements Role {
	/**
	 * The cached value of the '{@link #getSubjected() <em>Subjected</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubjected()
	 * @generated
	 * @ordered
	 */
	protected EList<CounterMeasure> subjected;

	/**
	 * The cached value of the '{@link #getBindingTypes() <em>Binding Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Class<? extends DFDElement>> bindingTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CounterMeasure> getSubjected() {
		if (subjected == null) {
			subjected = new EObjectWithInverseResolvingEList.ManyInverse<CounterMeasure>(CounterMeasure.class, this, SpartaModelPackage.ROLE__SUBJECTED, SpartaModelPackage.COUNTER_MEASURE__SUBJECT);
		}
		return subjected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Class<? extends DFDElement>> getBindingTypes() {
		if (bindingTypes == null) {
			bindingTypes = new EDataTypeUniqueEList<Class<? extends DFDElement>>(Class.class, this, SpartaModelPackage.ROLE__BINDING_TYPES);
		}
		return bindingTypes;
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
			case SpartaModelPackage.ROLE__SUBJECTED:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubjected()).basicAdd(otherEnd, msgs);
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
			case SpartaModelPackage.ROLE__SUBJECTED:
				return ((InternalEList<?>)getSubjected()).basicRemove(otherEnd, msgs);
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
			case SpartaModelPackage.ROLE__SUBJECTED:
				return getSubjected();
			case SpartaModelPackage.ROLE__BINDING_TYPES:
				return getBindingTypes();
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
			case SpartaModelPackage.ROLE__SUBJECTED:
				getSubjected().clear();
				getSubjected().addAll((Collection<? extends CounterMeasure>)newValue);
				return;
			case SpartaModelPackage.ROLE__BINDING_TYPES:
				getBindingTypes().clear();
				getBindingTypes().addAll((Collection<? extends Class<? extends DFDElement>>)newValue);
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
			case SpartaModelPackage.ROLE__SUBJECTED:
				getSubjected().clear();
				return;
			case SpartaModelPackage.ROLE__BINDING_TYPES:
				getBindingTypes().clear();
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
			case SpartaModelPackage.ROLE__SUBJECTED:
				return subjected != null && !subjected.isEmpty();
			case SpartaModelPackage.ROLE__BINDING_TYPES:
				return bindingTypes != null && !bindingTypes.isEmpty();
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
		result.append(" (bindingTypes: ");
		result.append(bindingTypes);
		result.append(')');
		return result.toString();
	}

} //RoleImpl
