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

import be.kuleuven.cs.distrinet.sparta.spartamodel.Asset;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleBindingImpl#getBinds <em>Binds</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleBindingImpl#getBindsTo <em>Binds To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleBindingImpl extends SecurityElementImpl implements RoleBinding {
	/**
	 * The cached value of the '{@link #getBinds() <em>Binds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinds()
	 * @generated
	 * @ordered
	 */
	protected Role binds;

	/**
	 * The cached value of the '{@link #getBindsTo() <em>Binds To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindsTo()
	 * @generated
	 * @ordered
	 */
	protected EList<Asset> bindsTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.ROLE_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Role getBinds() {
		if (binds != null && binds.eIsProxy()) {
			InternalEObject oldBinds = (InternalEObject)binds;
			binds = (Role)eResolveProxy(oldBinds);
			if (binds != oldBinds) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpartaModelPackage.ROLE_BINDING__BINDS, oldBinds, binds));
			}
		}
		return binds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetBinds() {
		return binds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBinds(Role newBinds) {
		Role oldBinds = binds;
		binds = newBinds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpartaModelPackage.ROLE_BINDING__BINDS, oldBinds, binds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Asset> getBindsTo() {
		if (bindsTo == null) {
			bindsTo = new EObjectWithInverseResolvingEList.ManyInverse<Asset>(Asset.class, this, SpartaModelPackage.ROLE_BINDING__BINDS_TO, SpartaModelPackage.ASSET__BOUND);
		}
		return bindsTo;
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
			case SpartaModelPackage.ROLE_BINDING__BINDS_TO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBindsTo()).basicAdd(otherEnd, msgs);
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
			case SpartaModelPackage.ROLE_BINDING__BINDS_TO:
				return ((InternalEList<?>)getBindsTo()).basicRemove(otherEnd, msgs);
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
			case SpartaModelPackage.ROLE_BINDING__BINDS:
				if (resolve) return getBinds();
				return basicGetBinds();
			case SpartaModelPackage.ROLE_BINDING__BINDS_TO:
				return getBindsTo();
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
			case SpartaModelPackage.ROLE_BINDING__BINDS:
				setBinds((Role)newValue);
				return;
			case SpartaModelPackage.ROLE_BINDING__BINDS_TO:
				getBindsTo().clear();
				getBindsTo().addAll((Collection<? extends Asset>)newValue);
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
			case SpartaModelPackage.ROLE_BINDING__BINDS:
				setBinds((Role)null);
				return;
			case SpartaModelPackage.ROLE_BINDING__BINDS_TO:
				getBindsTo().clear();
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
			case SpartaModelPackage.ROLE_BINDING__BINDS:
				return binds != null;
			case SpartaModelPackage.ROLE_BINDING__BINDS_TO:
				return bindsTo != null && !bindsTo.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoleBindingImpl
