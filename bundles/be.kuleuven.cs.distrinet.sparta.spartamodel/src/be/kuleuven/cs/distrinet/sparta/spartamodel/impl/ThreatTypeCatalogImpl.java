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
import org.eclipse.emf.ecore.util.InternalEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeGroup;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Threat Type Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl#getThreat <em>Threat</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl#getThreattypegroup <em>Threattypegroup</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl#getConditionlist <em>Conditionlist</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl#getHelperPatterns <em>Helper Patterns</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl#getPatternDependencies <em>Pattern Dependencies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThreatTypeCatalogImpl extends SpartaResourceImpl implements ThreatTypeCatalog {
	/**
	 * The cached value of the '{@link #getThreat() <em>Threat</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreat()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractThreatType> threat;

	/**
	 * The cached value of the '{@link #getThreattypegroup() <em>Threattypegroup</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreattypegroup()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreatTypeGroup> threattypegroup;

	/**
	 * The cached value of the '{@link #getConditionlist() <em>Conditionlist</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionlist()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionList> conditionlist;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<String> imports;

	/**
	 * The cached value of the '{@link #getHelperPatterns() <em>Helper Patterns</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelperPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<String> helperPatterns;

	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPatternDependencies() <em>Pattern Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreatTypeCatalog> patternDependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreatTypeCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.THREAT_TYPE_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractThreatType> getThreat() {
		if (threat == null) {
			threat = new EObjectContainmentEList<AbstractThreatType>(AbstractThreatType.class, this, SpartaModelPackage.THREAT_TYPE_CATALOG__THREAT);
		}
		return threat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ThreatTypeGroup> getThreattypegroup() {
		if (threattypegroup == null) {
			threattypegroup = new EObjectContainmentEList<ThreatTypeGroup>(ThreatTypeGroup.class, this, SpartaModelPackage.THREAT_TYPE_CATALOG__THREATTYPEGROUP);
		}
		return threattypegroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConditionList> getConditionlist() {
		if (conditionlist == null) {
			conditionlist = new EObjectContainmentEList<ConditionList>(ConditionList.class, this, SpartaModelPackage.THREAT_TYPE_CATALOG__CONDITIONLIST);
		}
		return conditionlist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getImports() {
		if (imports == null) {
			imports = new EDataTypeUniqueEList<String>(String.class, this, SpartaModelPackage.THREAT_TYPE_CATALOG__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getHelperPatterns() {
		if (helperPatterns == null) {
			helperPatterns = new EDataTypeUniqueEList<String>(String.class, this, SpartaModelPackage.THREAT_TYPE_CATALOG__HELPER_PATTERNS);
		}
		return helperPatterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.THREAT_TYPE_CATALOG__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ThreatTypeCatalog> getPatternDependencies() {
		if (patternDependencies == null) {
			patternDependencies = new EObjectResolvingEList<ThreatTypeCatalog>(ThreatTypeCatalog.class, this, SpartaModelPackage.THREAT_TYPE_CATALOG__PATTERN_DEPENDENCIES);
		}
		return patternDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREAT:
				return ((InternalEList<?>)getThreat()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREATTYPEGROUP:
				return ((InternalEList<?>)getThreattypegroup()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.THREAT_TYPE_CATALOG__CONDITIONLIST:
				return ((InternalEList<?>)getConditionlist()).basicRemove(otherEnd, msgs);
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
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREAT:
				return getThreat();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREATTYPEGROUP:
				return getThreattypegroup();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__CONDITIONLIST:
				return getConditionlist();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__IMPORTS:
				return getImports();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__HELPER_PATTERNS:
				return getHelperPatterns();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__PACKAGE:
				return getPackage();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__PATTERN_DEPENDENCIES:
				return getPatternDependencies();
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
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREAT:
				getThreat().clear();
				getThreat().addAll((Collection<? extends AbstractThreatType>)newValue);
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREATTYPEGROUP:
				getThreattypegroup().clear();
				getThreattypegroup().addAll((Collection<? extends ThreatTypeGroup>)newValue);
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__CONDITIONLIST:
				getConditionlist().clear();
				getConditionlist().addAll((Collection<? extends ConditionList>)newValue);
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends String>)newValue);
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__HELPER_PATTERNS:
				getHelperPatterns().clear();
				getHelperPatterns().addAll((Collection<? extends String>)newValue);
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__PACKAGE:
				setPackage((String)newValue);
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__PATTERN_DEPENDENCIES:
				getPatternDependencies().clear();
				getPatternDependencies().addAll((Collection<? extends ThreatTypeCatalog>)newValue);
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
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREAT:
				getThreat().clear();
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREATTYPEGROUP:
				getThreattypegroup().clear();
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__CONDITIONLIST:
				getConditionlist().clear();
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__IMPORTS:
				getImports().clear();
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__HELPER_PATTERNS:
				getHelperPatterns().clear();
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__PATTERN_DEPENDENCIES:
				getPatternDependencies().clear();
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
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREAT:
				return threat != null && !threat.isEmpty();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREATTYPEGROUP:
				return threattypegroup != null && !threattypegroup.isEmpty();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__CONDITIONLIST:
				return conditionlist != null && !conditionlist.isEmpty();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__IMPORTS:
				return imports != null && !imports.isEmpty();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__HELPER_PATTERNS:
				return helperPatterns != null && !helperPatterns.isEmpty();
			case SpartaModelPackage.THREAT_TYPE_CATALOG__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case SpartaModelPackage.THREAT_TYPE_CATALOG__PATTERN_DEPENDENCIES:
				return patternDependencies != null && !patternDependencies.isEmpty();
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
		result.append(" (imports: ");
		result.append(imports);
		result.append(", helperPatterns: ");
		result.append(helperPatterns);
		result.append(", package: ");
		result.append(package_);
		result.append(')');
		return result.toString();
	}

} //ThreatTypeCatalogImpl
