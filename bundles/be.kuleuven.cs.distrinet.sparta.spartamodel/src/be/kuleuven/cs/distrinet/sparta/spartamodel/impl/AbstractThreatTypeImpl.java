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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Threat Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl#getPatterns <em>Patterns</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl#getAdditionalInfo <em>Additional Info</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl#getCharacteristic <em>Characteristic</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl#getSuperThreatType <em>Super Threat Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractThreatTypeImpl extends SecurityElementImpl implements AbstractThreatType {
	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPatterns() <em>Patterns</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatterns()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Boolean> patterns;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdditionalInfo() <em>Additional Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalInfo()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDITIONAL_INFO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdditionalInfo() <em>Additional Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalInfo()
	 * @generated
	 * @ordered
	 */
	protected String additionalInfo = ADDITIONAL_INFO_EDEFAULT;

	/**
	 * The default value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected String comments = COMMENTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCharacteristic() <em>Characteristic</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristic()
	 * @generated
	 * @ordered
	 */
	protected EList<ICharacteristic> characteristic;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractThreatTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.ABSTRACT_THREAT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ABSTRACT_THREAT_TYPE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, Boolean> getPatterns() {
		if (patterns == null) {
			patterns = new EcoreEMap<String,Boolean>(SpartaModelPackage.Literals.ESTRING_TO_EBOOLEAN_MAP, EStringToEBooleanMapImpl.class, this, SpartaModelPackage.ABSTRACT_THREAT_TYPE__PATTERNS);
		}
		return patterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ABSTRACT_THREAT_TYPE__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAdditionalInfo(String newAdditionalInfo) {
		String oldAdditionalInfo = additionalInfo;
		additionalInfo = newAdditionalInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO, oldAdditionalInfo, additionalInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getComments() {
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComments(String newComments) {
		String oldComments = comments;
		comments = newComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ABSTRACT_THREAT_TYPE__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ICharacteristic> getCharacteristic() {
		if (characteristic == null) {
			characteristic = new EObjectContainmentEList<ICharacteristic>(ICharacteristic.class, this, SpartaModelPackage.ABSTRACT_THREAT_TYPE__CHARACTERISTIC);
		}
		return characteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeThreatType getSuperThreatType() {
		if (eContainerFeatureID() != SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE) return null;
		return (CompositeThreatType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperThreatType(CompositeThreatType newSuperThreatType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSuperThreatType, SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuperThreatType(CompositeThreatType newSuperThreatType) {
		if (newSuperThreatType != eInternalContainer() || (eContainerFeatureID() != SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE && newSuperThreatType != null)) {
			if (EcoreUtil.isAncestor(this, newSuperThreatType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSuperThreatType != null)
				msgs = ((InternalEObject)newSuperThreatType).eInverseAdd(this, SpartaModelPackage.COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES, CompositeThreatType.class, msgs);
			msgs = basicSetSuperThreatType(newSuperThreatType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE, newSuperThreatType, newSuperThreatType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSuperThreatType((CompositeThreatType)otherEnd, msgs);
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
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__PATTERNS:
				return ((InternalEList<?>)getPatterns()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__CHARACTERISTIC:
				return ((InternalEList<?>)getCharacteristic()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE:
				return basicSetSuperThreatType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE:
				return eInternalContainer().eInverseRemove(this, SpartaModelPackage.COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES, CompositeThreatType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__ENABLED:
				return isEnabled();
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__PATTERNS:
				if (coreType) return getPatterns();
				else return getPatterns().map();
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__TITLE:
				return getTitle();
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO:
				return getAdditionalInfo();
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__COMMENTS:
				return getComments();
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__CHARACTERISTIC:
				return getCharacteristic();
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE:
				return getSuperThreatType();
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
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__PATTERNS:
				((EStructuralFeature.Setting)getPatterns()).set(newValue);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__TITLE:
				setTitle((String)newValue);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO:
				setAdditionalInfo((String)newValue);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__COMMENTS:
				setComments((String)newValue);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__CHARACTERISTIC:
				getCharacteristic().clear();
				getCharacteristic().addAll((Collection<? extends ICharacteristic>)newValue);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE:
				setSuperThreatType((CompositeThreatType)newValue);
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
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__PATTERNS:
				getPatterns().clear();
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO:
				setAdditionalInfo(ADDITIONAL_INFO_EDEFAULT);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__CHARACTERISTIC:
				getCharacteristic().clear();
				return;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE:
				setSuperThreatType((CompositeThreatType)null);
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
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__PATTERNS:
				return patterns != null && !patterns.isEmpty();
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO:
				return ADDITIONAL_INFO_EDEFAULT == null ? additionalInfo != null : !ADDITIONAL_INFO_EDEFAULT.equals(additionalInfo);
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__CHARACTERISTIC:
				return characteristic != null && !characteristic.isEmpty();
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE:
				return getSuperThreatType() != null;
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
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(", title: ");
		result.append(title);
		result.append(", additionalInfo: ");
		result.append(additionalInfo);
		result.append(", comments: ");
		result.append(comments);
		result.append(')');
		return result.toString();
	}

} //AbstractThreatTypeImpl
