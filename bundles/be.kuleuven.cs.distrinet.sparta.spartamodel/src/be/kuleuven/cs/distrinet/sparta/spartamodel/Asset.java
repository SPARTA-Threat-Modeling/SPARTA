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
package be.kuleuven.cs.distrinet.sparta.spartamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Asset is a DFDModelElement which can contain one or more estomates to specify the potential loss when a threat manifests itself.
 * To allow a more precise specification, a map can contain more precise and threat type specific estimates.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getLossMagnitude <em>Loss Magnitude</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getEstimates <em>Estimates</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getBound <em>Bound</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getLossMagnitudeByID <em>Loss Magnitude By ID</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAsset()
 * @model abstract="true"
 * @generated
 */
public interface Asset extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Loss Magnitude</b></em>' map.
	 * The key is of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType},
	 * and the value is of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loss Magnitude</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loss Magnitude</em>' map.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAsset_LossMagnitude()
	 * @model mapType="be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeToEstimateMap&lt;be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType, be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate&gt;"
	 * @generated
	 */
	EMap<ThreatType, Estimate> getLossMagnitude();

	/**
	 * Returns the value of the '<em><b>Estimates</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimates</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAsset_Estimates()
	 * @model containment="true"
	 * @generated
	 */
	EList<Estimate> getEstimates();

	/**
	 * Returns the value of the '<em><b>Bound</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding}.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding#getBindsTo <em>Binds To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAsset_Bound()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding#getBindsTo
	 * @model opposite="bindsTo"
	 * @generated
	 */
	EList<RoleBinding> getBound();

	/**
	 * Returns the value of the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loss Magnitude By ID</em>' map.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAsset_LossMagnitudeByID()
	 * @model mapType="be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeIDToEstimateMap&lt;org.eclipse.emf.ecore.EString, be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate&gt;"
	 * @generated
	 */
	EMap<String, Estimate> getLossMagnitudeByID();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ttRequired="true"
	 * @generated
	 */
	Estimate getEstimate(AbstractThreatType tt);

} // Asset
