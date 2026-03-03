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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attacker Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl#getThreatCapability <em>Threat Capability</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl#getProbabilityOfAction <em>Probability Of Action</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl#getContactFrequency <em>Contact Frequency</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl#getInsider <em>Insider</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackerProfileImpl extends SecurityElementImpl implements AttackerProfile {
	/**
	 * The cached value of the '{@link #getThreatCapability() <em>Threat Capability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreatCapability()
	 * @generated
	 * @ordered
	 */
	protected Estimate threatCapability;

	/**
	 * The cached value of the '{@link #getProbabilityOfAction() <em>Probability Of Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbabilityOfAction()
	 * @generated
	 * @ordered
	 */
	protected Estimate probabilityOfAction;

	/**
	 * The cached value of the '{@link #getContactFrequency() <em>Contact Frequency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContactFrequency()
	 * @generated
	 * @ordered
	 */
	protected Estimate contactFrequency;

	/**
	 * The cached value of the '{@link #getInsider() <em>Insider</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsider()
	 * @generated
	 * @ordered
	 */
	protected EList<DFDElement> insider;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackerProfileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.ATTACKER_PROFILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate getThreatCapability() {
		return threatCapability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThreatCapability(Estimate newThreatCapability, NotificationChain msgs) {
		Estimate oldThreatCapability = threatCapability;
		threatCapability = newThreatCapability;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ATTACKER_PROFILE__THREAT_CAPABILITY, oldThreatCapability, newThreatCapability);
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
	public void setThreatCapability(Estimate newThreatCapability) {
		if (newThreatCapability != threatCapability) {
			NotificationChain msgs = null;
			if (threatCapability != null)
				msgs = ((InternalEObject)threatCapability).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.ATTACKER_PROFILE__THREAT_CAPABILITY, null, msgs);
			if (newThreatCapability != null)
				msgs = ((InternalEObject)newThreatCapability).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.ATTACKER_PROFILE__THREAT_CAPABILITY, null, msgs);
			msgs = basicSetThreatCapability(newThreatCapability, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ATTACKER_PROFILE__THREAT_CAPABILITY, newThreatCapability, newThreatCapability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate getProbabilityOfAction() {
		return probabilityOfAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProbabilityOfAction(Estimate newProbabilityOfAction, NotificationChain msgs) {
		Estimate oldProbabilityOfAction = probabilityOfAction;
		probabilityOfAction = newProbabilityOfAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ATTACKER_PROFILE__PROBABILITY_OF_ACTION, oldProbabilityOfAction, newProbabilityOfAction);
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
	public void setProbabilityOfAction(Estimate newProbabilityOfAction) {
		if (newProbabilityOfAction != probabilityOfAction) {
			NotificationChain msgs = null;
			if (probabilityOfAction != null)
				msgs = ((InternalEObject)probabilityOfAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.ATTACKER_PROFILE__PROBABILITY_OF_ACTION, null, msgs);
			if (newProbabilityOfAction != null)
				msgs = ((InternalEObject)newProbabilityOfAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.ATTACKER_PROFILE__PROBABILITY_OF_ACTION, null, msgs);
			msgs = basicSetProbabilityOfAction(newProbabilityOfAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ATTACKER_PROFILE__PROBABILITY_OF_ACTION, newProbabilityOfAction, newProbabilityOfAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate getContactFrequency() {
		return contactFrequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContactFrequency(Estimate newContactFrequency, NotificationChain msgs) {
		Estimate oldContactFrequency = contactFrequency;
		contactFrequency = newContactFrequency;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ATTACKER_PROFILE__CONTACT_FREQUENCY, oldContactFrequency, newContactFrequency);
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
	public void setContactFrequency(Estimate newContactFrequency) {
		if (newContactFrequency != contactFrequency) {
			NotificationChain msgs = null;
			if (contactFrequency != null)
				msgs = ((InternalEObject)contactFrequency).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.ATTACKER_PROFILE__CONTACT_FREQUENCY, null, msgs);
			if (newContactFrequency != null)
				msgs = ((InternalEObject)newContactFrequency).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpartaModelPackage.ATTACKER_PROFILE__CONTACT_FREQUENCY, null, msgs);
			msgs = basicSetContactFrequency(newContactFrequency, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ATTACKER_PROFILE__CONTACT_FREQUENCY, newContactFrequency, newContactFrequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DFDElement> getInsider() {
		if (insider == null) {
			insider = new EObjectResolvingEList<DFDElement>(DFDElement.class, this, SpartaModelPackage.ATTACKER_PROFILE__INSIDER);
		}
		return insider;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ATTACKER_PROFILE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpartaModelPackage.ATTACKER_PROFILE__THREAT_CAPABILITY:
				return basicSetThreatCapability(null, msgs);
			case SpartaModelPackage.ATTACKER_PROFILE__PROBABILITY_OF_ACTION:
				return basicSetProbabilityOfAction(null, msgs);
			case SpartaModelPackage.ATTACKER_PROFILE__CONTACT_FREQUENCY:
				return basicSetContactFrequency(null, msgs);
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
			case SpartaModelPackage.ATTACKER_PROFILE__THREAT_CAPABILITY:
				return getThreatCapability();
			case SpartaModelPackage.ATTACKER_PROFILE__PROBABILITY_OF_ACTION:
				return getProbabilityOfAction();
			case SpartaModelPackage.ATTACKER_PROFILE__CONTACT_FREQUENCY:
				return getContactFrequency();
			case SpartaModelPackage.ATTACKER_PROFILE__INSIDER:
				return getInsider();
			case SpartaModelPackage.ATTACKER_PROFILE__ENABLED:
				return isEnabled();
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
			case SpartaModelPackage.ATTACKER_PROFILE__THREAT_CAPABILITY:
				setThreatCapability((Estimate)newValue);
				return;
			case SpartaModelPackage.ATTACKER_PROFILE__PROBABILITY_OF_ACTION:
				setProbabilityOfAction((Estimate)newValue);
				return;
			case SpartaModelPackage.ATTACKER_PROFILE__CONTACT_FREQUENCY:
				setContactFrequency((Estimate)newValue);
				return;
			case SpartaModelPackage.ATTACKER_PROFILE__INSIDER:
				getInsider().clear();
				getInsider().addAll((Collection<? extends DFDElement>)newValue);
				return;
			case SpartaModelPackage.ATTACKER_PROFILE__ENABLED:
				setEnabled((Boolean)newValue);
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
			case SpartaModelPackage.ATTACKER_PROFILE__THREAT_CAPABILITY:
				setThreatCapability((Estimate)null);
				return;
			case SpartaModelPackage.ATTACKER_PROFILE__PROBABILITY_OF_ACTION:
				setProbabilityOfAction((Estimate)null);
				return;
			case SpartaModelPackage.ATTACKER_PROFILE__CONTACT_FREQUENCY:
				setContactFrequency((Estimate)null);
				return;
			case SpartaModelPackage.ATTACKER_PROFILE__INSIDER:
				getInsider().clear();
				return;
			case SpartaModelPackage.ATTACKER_PROFILE__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
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
			case SpartaModelPackage.ATTACKER_PROFILE__THREAT_CAPABILITY:
				return threatCapability != null;
			case SpartaModelPackage.ATTACKER_PROFILE__PROBABILITY_OF_ACTION:
				return probabilityOfAction != null;
			case SpartaModelPackage.ATTACKER_PROFILE__CONTACT_FREQUENCY:
				return contactFrequency != null;
			case SpartaModelPackage.ATTACKER_PROFILE__INSIDER:
				return insider != null && !insider.isEmpty();
			case SpartaModelPackage.ATTACKER_PROFILE__ENABLED:
				return enabled != ENABLED_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

} //AttackerProfileImpl
