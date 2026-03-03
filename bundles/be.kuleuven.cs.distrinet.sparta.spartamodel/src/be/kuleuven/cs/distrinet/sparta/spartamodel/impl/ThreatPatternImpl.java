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

import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Threat Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatPatternImpl#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatPatternImpl#getPatterns <em>Patterns</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatPatternImpl#getMapping <em>Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThreatPatternImpl extends ModelElementImpl implements ThreatPattern {
	/**
	 * The cached value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongDescription()
	 * @generated
	 * @ordered
	 */
	protected EList<String> longDescription;

	/**
	 * The cached value of the '{@link #getPatterns() <em>Patterns</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<String> patterns;

	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> mapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreatPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.THREAT_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getLongDescription() {
		if (longDescription == null) {
			longDescription = new EDataTypeUniqueEList<String>(String.class, this, SpartaModelPackage.THREAT_PATTERN__LONG_DESCRIPTION);
		}
		return longDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getPatterns() {
		if (patterns == null) {
			patterns = new EDataTypeUniqueEList<String>(String.class, this, SpartaModelPackage.THREAT_PATTERN__PATTERNS);
		}
		return patterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getMapping() {
		if (mapping == null) {
			mapping = new EcoreEMap<String,String>(SpartaModelPackage.Literals.ESTRING_TO_ESTRING_MAP, EStringToEStringMapImpl.class, this, SpartaModelPackage.THREAT_PATTERN__MAPPING);
		}
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.THREAT_PATTERN__MAPPING:
				return ((InternalEList<?>)getMapping()).basicRemove(otherEnd, msgs);
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
			case SpartaModelPackage.THREAT_PATTERN__LONG_DESCRIPTION:
				return getLongDescription();
			case SpartaModelPackage.THREAT_PATTERN__PATTERNS:
				return getPatterns();
			case SpartaModelPackage.THREAT_PATTERN__MAPPING:
				if (coreType) return getMapping();
				else return getMapping().map();
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
			case SpartaModelPackage.THREAT_PATTERN__LONG_DESCRIPTION:
				getLongDescription().clear();
				getLongDescription().addAll((Collection<? extends String>)newValue);
				return;
			case SpartaModelPackage.THREAT_PATTERN__PATTERNS:
				getPatterns().clear();
				getPatterns().addAll((Collection<? extends String>)newValue);
				return;
			case SpartaModelPackage.THREAT_PATTERN__MAPPING:
				((EStructuralFeature.Setting)getMapping()).set(newValue);
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
			case SpartaModelPackage.THREAT_PATTERN__LONG_DESCRIPTION:
				getLongDescription().clear();
				return;
			case SpartaModelPackage.THREAT_PATTERN__PATTERNS:
				getPatterns().clear();
				return;
			case SpartaModelPackage.THREAT_PATTERN__MAPPING:
				getMapping().clear();
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
			case SpartaModelPackage.THREAT_PATTERN__LONG_DESCRIPTION:
				return longDescription != null && !longDescription.isEmpty();
			case SpartaModelPackage.THREAT_PATTERN__PATTERNS:
				return patterns != null && !patterns.isEmpty();
			case SpartaModelPackage.THREAT_PATTERN__MAPPING:
				return mapping != null && !mapping.isEmpty();
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
		result.append(" (longDescription: ");
		result.append(longDescription);
		result.append(", patterns: ");
		result.append(patterns);
		result.append(')');
		return result.toString();
	}

} //ThreatPatternImpl
