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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDBoundaryElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DFD Boundary Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDBoundaryElementImpl#getCrossingFlows <em>Crossing Flows</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DFDBoundaryElementImpl extends DFDContainerImpl implements DFDBoundaryElement {
	/**
	 * The cached value of the '{@link #getCrossingFlows() <em>Crossing Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrossingFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlow> crossingFlows;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFDBoundaryElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.DFD_BOUNDARY_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataFlow> getCrossingFlows() {
		if (crossingFlows == null) {
			crossingFlows = new EObjectResolvingEList<DataFlow>(DataFlow.class, this, SpartaModelPackage.DFD_BOUNDARY_ELEMENT__CROSSING_FLOWS);
		}
		return crossingFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpartaModelPackage.DFD_BOUNDARY_ELEMENT__CROSSING_FLOWS:
				return getCrossingFlows();
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
			case SpartaModelPackage.DFD_BOUNDARY_ELEMENT__CROSSING_FLOWS:
				getCrossingFlows().clear();
				getCrossingFlows().addAll((Collection<? extends DataFlow>)newValue);
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
			case SpartaModelPackage.DFD_BOUNDARY_ELEMENT__CROSSING_FLOWS:
				getCrossingFlows().clear();
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
			case SpartaModelPackage.DFD_BOUNDARY_ELEMENT__CROSSING_FLOWS:
				return crossingFlows != null && !crossingFlows.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DFDBoundaryElementImpl
