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

import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import be.kuleuven.cs.distrinet.sparta.spartamodel.Asset;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import java.lang.reflect.InvocationTargetException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AssetImpl#getLossMagnitude <em>Loss Magnitude</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AssetImpl#getEstimates <em>Estimates</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AssetImpl#getBound <em>Bound</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AssetImpl#getLossMagnitudeByID <em>Loss Magnitude By ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AssetImpl extends ModelElementImpl implements Asset {
	/**
	 * The cached value of the '{@link #getLossMagnitude() <em>Loss Magnitude</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLossMagnitude()
	 * @generated
	 * @ordered
	 */
	protected EMap<ThreatType, Estimate> lossMagnitude;

	/**
	 * The cached value of the '{@link #getEstimates() <em>Estimates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimates()
	 * @generated
	 * @ordered
	 */
	protected EList<Estimate> estimates;

	/**
	 * The cached value of the '{@link #getBound() <em>Bound</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBound()
	 * @generated
	 * @ordered
	 */
	protected EList<RoleBinding> bound;

	/**
	 * The cached value of the '{@link #getLossMagnitudeByID() <em>Loss Magnitude By ID</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLossMagnitudeByID()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Estimate> lossMagnitudeByID;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpartaModelPackage.Literals.ASSET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<ThreatType, Estimate> getLossMagnitude() {
		if (lossMagnitude == null) {
			lossMagnitude = new EcoreEMap<ThreatType,Estimate>(SpartaModelPackage.Literals.THREAT_TYPE_TO_ESTIMATE_MAP, ThreatTypeToEstimateMapImpl.class, this, SpartaModelPackage.ASSET__LOSS_MAGNITUDE);
		}
		return lossMagnitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Estimate> getEstimates() {
		if (estimates == null) {
			estimates = new EObjectContainmentEList<Estimate>(Estimate.class, this, SpartaModelPackage.ASSET__ESTIMATES);
		}
		return estimates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RoleBinding> getBound() {
		if (bound == null) {
			bound = new EObjectWithInverseResolvingEList<RoleBinding>(RoleBinding.class, this, SpartaModelPackage.ASSET__BOUND, SpartaModelPackage.ROLE_BINDING__BINDS_TO);
		}
		return bound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, Estimate> getLossMagnitudeByID() {
		if (lossMagnitudeByID == null) {
			lossMagnitudeByID = new EcoreEMap<String,Estimate>(SpartaModelPackage.Literals.THREAT_TYPE_ID_TO_ESTIMATE_MAP, ThreatTypeIDToEstimateMapImpl.class, this, SpartaModelPackage.ASSET__LOSS_MAGNITUDE_BY_ID);
		}
		return lossMagnitudeByID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate getEstimate(final AbstractThreatType tt) {
		Estimate e = null; if (tt.getId() != null || tt.getId() != "") { e = this.getLossMagnitudeByID().get(tt.getId()); } if (e == null) { e = this.getLossMagnitude().get(tt); } if (e == null) { AbstractThreatType parent = tt.getSuperThreatType(); while ( parent != null && e == null) { if (parent.getId() != null) { e = this.getLossMagnitudeByID().get(parent.getId()); } if (e == null) { e = this.getLossMagnitude().get(parent); } parent = parent.getSuperThreatType(); } } if (e == null) { if (this.getEstimates().size() >= 1) { e = this.getEstimates().get(0); } } return e;
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
			case SpartaModelPackage.ASSET__BOUND:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBound()).basicAdd(otherEnd, msgs);
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
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE:
				return ((InternalEList<?>)getLossMagnitude()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.ASSET__ESTIMATES:
				return ((InternalEList<?>)getEstimates()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.ASSET__BOUND:
				return ((InternalEList<?>)getBound()).basicRemove(otherEnd, msgs);
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE_BY_ID:
				return ((InternalEList<?>)getLossMagnitudeByID()).basicRemove(otherEnd, msgs);
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
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE:
				if (coreType) return getLossMagnitude();
				else return getLossMagnitude().map();
			case SpartaModelPackage.ASSET__ESTIMATES:
				return getEstimates();
			case SpartaModelPackage.ASSET__BOUND:
				return getBound();
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE_BY_ID:
				if (coreType) return getLossMagnitudeByID();
				else return getLossMagnitudeByID().map();
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
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE:
				((EStructuralFeature.Setting)getLossMagnitude()).set(newValue);
				return;
			case SpartaModelPackage.ASSET__ESTIMATES:
				getEstimates().clear();
				getEstimates().addAll((Collection<? extends Estimate>)newValue);
				return;
			case SpartaModelPackage.ASSET__BOUND:
				getBound().clear();
				getBound().addAll((Collection<? extends RoleBinding>)newValue);
				return;
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE_BY_ID:
				((EStructuralFeature.Setting)getLossMagnitudeByID()).set(newValue);
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
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE:
				getLossMagnitude().clear();
				return;
			case SpartaModelPackage.ASSET__ESTIMATES:
				getEstimates().clear();
				return;
			case SpartaModelPackage.ASSET__BOUND:
				getBound().clear();
				return;
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE_BY_ID:
				getLossMagnitudeByID().clear();
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
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE:
				return lossMagnitude != null && !lossMagnitude.isEmpty();
			case SpartaModelPackage.ASSET__ESTIMATES:
				return estimates != null && !estimates.isEmpty();
			case SpartaModelPackage.ASSET__BOUND:
				return bound != null && !bound.isEmpty();
			case SpartaModelPackage.ASSET__LOSS_MAGNITUDE_BY_ID:
				return lossMagnitudeByID != null && !lossMagnitudeByID.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SpartaModelPackage.ASSET___GET_ESTIMATE__ABSTRACTTHREATTYPE:
				return getEstimate((AbstractThreatType)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //AssetImpl
