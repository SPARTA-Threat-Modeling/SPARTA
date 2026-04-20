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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The spartamodel package contains all the meta-model classes for creating DFDModels, Security and Privacy solution catalogs, and threat type catalogs.
 * <!-- end-model-doc -->
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory
 * @model kind="package"
 * @generated
 */
public interface SpartaModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "spartamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://distrinet.cs.kuleuven.be/spartamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "spartamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpartaModelPackage eINSTANCE = be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ModelElementImpl <em>Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ModelElementImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__ANNOTATIONS = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__ID = 3;

	/**
	 * The number of structural features of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AssetImpl <em>Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AssetImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAsset()
	 * @generated
	 */
	int ASSET = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__ANNOTATIONS = MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__ID = MODEL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__LOSS_MAGNITUDE = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__ESTIMATES = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__BOUND = MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__LOSS_MAGNITUDE_BY_ID = MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET___GET_ESTIMATE__ABSTRACTTHREATTYPE = MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_OPERATION_COUNT = MODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDElementImpl <em>DFD Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDElementImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDElement()
	 * @generated
	 */
	int DFD_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__NAME = ASSET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__DESCRIPTION = ASSET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__ANNOTATIONS = ASSET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__ID = ASSET__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__LOSS_MAGNITUDE = ASSET__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__ESTIMATES = ASSET__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__BOUND = ASSET__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__LOSS_MAGNITUDE_BY_ID = ASSET__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__SECURITYANNOTATION = ASSET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT__DFDELEMENTANNOTATION = ASSET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DFD Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT_FEATURE_COUNT = ASSET_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT___GET_ESTIMATE__ABSTRACTTHREATTYPE = ASSET___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>DFD Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT_OPERATION_COUNT = ASSET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.FlowElementImpl <em>Flow Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.FlowElementImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getFlowElement()
	 * @generated
	 */
	int FLOW_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__NAME = DFD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__DESCRIPTION = DFD_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__ANNOTATIONS = DFD_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__ID = DFD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__LOSS_MAGNITUDE = DFD_ELEMENT__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__ESTIMATES = DFD_ELEMENT__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__BOUND = DFD_ELEMENT__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__LOSS_MAGNITUDE_BY_ID = DFD_ELEMENT__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__SECURITYANNOTATION = DFD_ELEMENT__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__DFDELEMENTANNOTATION = DFD_ELEMENT__DFDELEMENTANNOTATION;

	/**
	 * The number of structural features of the '<em>Flow Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_FEATURE_COUNT = DFD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT___GET_ESTIMATE__ABSTRACTTHREATTYPE = DFD_ELEMENT___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The operation id for the '<em>Get Data Flow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT___GET_DATA_FLOW = DFD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Flow Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_OPERATION_COUNT = DFD_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable <em>Sender Specifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSenderSpecifiable()
	 * @generated
	 */
	int SENDER_SPECIFIABLE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__NAME = FLOW_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__DESCRIPTION = FLOW_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__ANNOTATIONS = FLOW_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__ID = FLOW_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__LOSS_MAGNITUDE = FLOW_ELEMENT__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__ESTIMATES = FLOW_ELEMENT__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__BOUND = FLOW_ELEMENT__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__LOSS_MAGNITUDE_BY_ID = FLOW_ELEMENT__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__SECURITYANNOTATION = FLOW_ELEMENT__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__DFDELEMENTANNOTATION = FLOW_ELEMENT__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Sender Specified By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__SENDER_SPECIFIED_BY = FLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE__SENDER = FLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sender Specifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE___GET_ESTIMATE__ABSTRACTTHREATTYPE = FLOW_ELEMENT___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The operation id for the '<em>Get Data Flow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE___GET_DATA_FLOW = FLOW_ELEMENT___GET_DATA_FLOW;

	/**
	 * The number of operations of the '<em>Sender Specifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFIABLE_OPERATION_COUNT = FLOW_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowImpl <em>Data Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataFlow()
	 * @generated
	 */
	int DATA_FLOW = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__NAME = SENDER_SPECIFIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__DESCRIPTION = SENDER_SPECIFIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__ANNOTATIONS = SENDER_SPECIFIABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__ID = SENDER_SPECIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__LOSS_MAGNITUDE = SENDER_SPECIFIABLE__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__ESTIMATES = SENDER_SPECIFIABLE__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__BOUND = SENDER_SPECIFIABLE__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__LOSS_MAGNITUDE_BY_ID = SENDER_SPECIFIABLE__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__SECURITYANNOTATION = SENDER_SPECIFIABLE__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__DFDELEMENTANNOTATION = SENDER_SPECIFIABLE__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Sender Specified By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__SENDER_SPECIFIED_BY = SENDER_SPECIFIABLE__SENDER_SPECIFIED_BY;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__SENDER = SENDER_SPECIFIABLE__SENDER;

	/**
	 * The feature id for the '<em><b>Recipient Specified By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__RECIPIENT_SPECIFIED_BY = SENDER_SPECIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Recipient</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__RECIPIENT = SENDER_SPECIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_FEATURE_COUNT = SENDER_SPECIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW___GET_ESTIMATE__ABSTRACTTHREATTYPE = SENDER_SPECIFIABLE___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The operation id for the '<em>Get Data Flow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW___GET_DATA_FLOW = SENDER_SPECIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_OPERATION_COUNT = SENDER_SPECIFIABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDContainerImpl <em>DFD Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDContainerImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDContainer()
	 * @generated
	 */
	int DFD_CONTAINER = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__NAME = DFD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__DESCRIPTION = DFD_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__ANNOTATIONS = DFD_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__ID = DFD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__LOSS_MAGNITUDE = DFD_ELEMENT__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__ESTIMATES = DFD_ELEMENT__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__BOUND = DFD_ELEMENT__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__LOSS_MAGNITUDE_BY_ID = DFD_ELEMENT__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__SECURITYANNOTATION = DFD_ELEMENT__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__DFDELEMENTANNOTATION = DFD_ELEMENT__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Contained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER__CONTAINED_ELEMENTS = DFD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DFD Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER_FEATURE_COUNT = DFD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER___GET_ESTIMATE__ABSTRACTTHREATTYPE = DFD_ELEMENT___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>DFD Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONTAINER_OPERATION_COUNT = DFD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowEntityImpl <em>Data Flow Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowEntityImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataFlowEntity()
	 * @generated
	 */
	int DATA_FLOW_ENTITY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__NAME = DFD_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__DESCRIPTION = DFD_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__ANNOTATIONS = DFD_CONTAINER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__ID = DFD_CONTAINER__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__LOSS_MAGNITUDE = DFD_CONTAINER__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__ESTIMATES = DFD_CONTAINER__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__BOUND = DFD_CONTAINER__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__LOSS_MAGNITUDE_BY_ID = DFD_CONTAINER__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__SECURITYANNOTATION = DFD_CONTAINER__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__DFDELEMENTANNOTATION = DFD_CONTAINER__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Contained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__CONTAINED_ELEMENTS = DFD_CONTAINER__CONTAINED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Send</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__SEND = DFD_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY__RECEIVE = DFD_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Flow Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY_FEATURE_COUNT = DFD_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY___GET_ESTIMATE__ABSTRACTTHREATTYPE = DFD_CONTAINER___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>Data Flow Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_ENTITY_OPERATION_COUNT = DFD_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ExternalEntityImpl <em>External Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ExternalEntityImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getExternalEntity()
	 * @generated
	 */
	int EXTERNAL_ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__NAME = DATA_FLOW_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__DESCRIPTION = DATA_FLOW_ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__ANNOTATIONS = DATA_FLOW_ENTITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__ID = DATA_FLOW_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__LOSS_MAGNITUDE = DATA_FLOW_ENTITY__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__ESTIMATES = DATA_FLOW_ENTITY__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__BOUND = DATA_FLOW_ENTITY__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__LOSS_MAGNITUDE_BY_ID = DATA_FLOW_ENTITY__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__SECURITYANNOTATION = DATA_FLOW_ENTITY__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__DFDELEMENTANNOTATION = DATA_FLOW_ENTITY__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Contained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__CONTAINED_ELEMENTS = DATA_FLOW_ENTITY__CONTAINED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Send</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__SEND = DATA_FLOW_ENTITY__SEND;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__RECEIVE = DATA_FLOW_ENTITY__RECEIVE;

	/**
	 * The number of structural features of the '<em>External Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY_FEATURE_COUNT = DATA_FLOW_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY___GET_ESTIMATE__ABSTRACTTHREATTYPE = DATA_FLOW_ENTITY___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>External Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY_OPERATION_COUNT = DATA_FLOW_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ProcessImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAME = DATA_FLOW_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DESCRIPTION = DATA_FLOW_ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ANNOTATIONS = DATA_FLOW_ENTITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ID = DATA_FLOW_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__LOSS_MAGNITUDE = DATA_FLOW_ENTITY__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ESTIMATES = DATA_FLOW_ENTITY__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__BOUND = DATA_FLOW_ENTITY__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__LOSS_MAGNITUDE_BY_ID = DATA_FLOW_ENTITY__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__SECURITYANNOTATION = DATA_FLOW_ENTITY__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DFDELEMENTANNOTATION = DATA_FLOW_ENTITY__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Contained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CONTAINED_ELEMENTS = DATA_FLOW_ENTITY__CONTAINED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Send</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__SEND = DATA_FLOW_ENTITY__SEND;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__RECEIVE = DATA_FLOW_ENTITY__RECEIVE;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = DATA_FLOW_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS___GET_ESTIMATE__ABSTRACTTHREATTYPE = DATA_FLOW_ENTITY___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OPERATION_COUNT = DATA_FLOW_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataStoreImpl <em>Data Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataStoreImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataStore()
	 * @generated
	 */
	int DATA_STORE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__NAME = DATA_FLOW_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__DESCRIPTION = DATA_FLOW_ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__ANNOTATIONS = DATA_FLOW_ENTITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__ID = DATA_FLOW_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__LOSS_MAGNITUDE = DATA_FLOW_ENTITY__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__ESTIMATES = DATA_FLOW_ENTITY__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__BOUND = DATA_FLOW_ENTITY__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__LOSS_MAGNITUDE_BY_ID = DATA_FLOW_ENTITY__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__SECURITYANNOTATION = DATA_FLOW_ENTITY__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__DFDELEMENTANNOTATION = DATA_FLOW_ENTITY__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Contained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__CONTAINED_ELEMENTS = DATA_FLOW_ENTITY__CONTAINED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Send</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__SEND = DATA_FLOW_ENTITY__SEND;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__RECEIVE = DATA_FLOW_ENTITY__RECEIVE;

	/**
	 * The number of structural features of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_FEATURE_COUNT = DATA_FLOW_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE___GET_ESTIMATE__ABSTRACTTHREATTYPE = DATA_FLOW_ENTITY___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_OPERATION_COUNT = DATA_FLOW_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaResourceImpl <em>Sparta Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaResourceImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSpartaResource()
	 * @generated
	 */
	int SPARTA_RESOURCE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARTA_RESOURCE__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARTA_RESOURCE__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARTA_RESOURCE__ANNOTATIONS = MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARTA_RESOURCE__ID = MODEL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARTA_RESOURCE__SECURITYANNOTATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sparta Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARTA_RESOURCE_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sparta Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARTA_RESOURCE_OPERATION_COUNT = MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDModelImpl <em>DFD Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDModelImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDModel()
	 * @generated
	 */
	int DFD_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_MODEL__NAME = SPARTA_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_MODEL__DESCRIPTION = SPARTA_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_MODEL__ANNOTATIONS = SPARTA_RESOURCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_MODEL__ID = SPARTA_RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_MODEL__SECURITYANNOTATION = SPARTA_RESOURCE__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Contained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_MODEL__CONTAINED_ELEMENTS = SPARTA_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_MODEL__RESOURCE = SPARTA_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DFD Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_MODEL_FEATURE_COUNT = SPARTA_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>DFD Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_MODEL_OPERATION_COUNT = SPARTA_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SecurityElementImpl <em>Security Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SecurityElementImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSecurityElement()
	 * @generated
	 */
	int SECURITY_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ELEMENT__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ELEMENT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ELEMENT__ANNOTATIONS = MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ELEMENT__ID = MODEL_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Security Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ELEMENT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Security Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ELEMENT_OPERATION_COUNT = MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDBoundaryElementImpl <em>DFD Boundary Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDBoundaryElementImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDBoundaryElement()
	 * @generated
	 */
	int DFD_BOUNDARY_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__NAME = DFD_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__DESCRIPTION = DFD_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__ANNOTATIONS = DFD_CONTAINER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__ID = DFD_CONTAINER__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__LOSS_MAGNITUDE = DFD_CONTAINER__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__ESTIMATES = DFD_CONTAINER__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__BOUND = DFD_CONTAINER__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__LOSS_MAGNITUDE_BY_ID = DFD_CONTAINER__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__SECURITYANNOTATION = DFD_CONTAINER__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__DFDELEMENTANNOTATION = DFD_CONTAINER__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Contained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__CONTAINED_ELEMENTS = DFD_CONTAINER__CONTAINED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Crossing Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT__CROSSING_FLOWS = DFD_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DFD Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT_FEATURE_COUNT = DFD_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT___GET_ESTIMATE__ABSTRACTTHREATTYPE = DFD_CONTAINER___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>DFD Boundary Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BOUNDARY_ELEMENT_OPERATION_COUNT = DFD_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TrustBoundaryContainerImpl <em>Trust Boundary Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TrustBoundaryContainerImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getTrustBoundaryContainer()
	 * @generated
	 */
	int TRUST_BOUNDARY_CONTAINER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__NAME = DFD_BOUNDARY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__DESCRIPTION = DFD_BOUNDARY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__ANNOTATIONS = DFD_BOUNDARY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__ID = DFD_BOUNDARY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__LOSS_MAGNITUDE = DFD_BOUNDARY_ELEMENT__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__ESTIMATES = DFD_BOUNDARY_ELEMENT__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__BOUND = DFD_BOUNDARY_ELEMENT__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__LOSS_MAGNITUDE_BY_ID = DFD_BOUNDARY_ELEMENT__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__SECURITYANNOTATION = DFD_BOUNDARY_ELEMENT__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__DFDELEMENTANNOTATION = DFD_BOUNDARY_ELEMENT__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Contained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__CONTAINED_ELEMENTS = DFD_BOUNDARY_ELEMENT__CONTAINED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Crossing Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER__CROSSING_FLOWS = DFD_BOUNDARY_ELEMENT__CROSSING_FLOWS;

	/**
	 * The number of structural features of the '<em>Trust Boundary Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER_FEATURE_COUNT = DFD_BOUNDARY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER___GET_ESTIMATE__ABSTRACTTHREATTYPE = DFD_BOUNDARY_ELEMENT___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>Trust Boundary Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_BOUNDARY_CONTAINER_OPERATION_COUNT = DFD_BOUNDARY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable <em>Recipient Specifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getRecipientSpecifiable()
	 * @generated
	 */
	int RECIPIENT_SPECIFIABLE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__NAME = FLOW_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__DESCRIPTION = FLOW_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__ANNOTATIONS = FLOW_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__ID = FLOW_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__LOSS_MAGNITUDE = FLOW_ELEMENT__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__ESTIMATES = FLOW_ELEMENT__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__BOUND = FLOW_ELEMENT__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__LOSS_MAGNITUDE_BY_ID = FLOW_ELEMENT__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__SECURITYANNOTATION = FLOW_ELEMENT__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__DFDELEMENTANNOTATION = FLOW_ELEMENT__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Recipient Specified By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__RECIPIENT_SPECIFIED_BY = FLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Recipient</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE__RECIPIENT = FLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Recipient Specifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE___GET_ESTIMATE__ABSTRACTTHREATTYPE = FLOW_ELEMENT___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The operation id for the '<em>Get Data Flow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE___GET_DATA_FLOW = FLOW_ELEMENT___GET_DATA_FLOW;

	/**
	 * The number of operations of the '<em>Recipient Specifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFIABLE_OPERATION_COUNT = FLOW_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SenderSpecificationImpl <em>Sender Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SenderSpecificationImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSenderSpecification()
	 * @generated
	 */
	int SENDER_SPECIFICATION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__NAME = SENDER_SPECIFIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__DESCRIPTION = SENDER_SPECIFIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__ANNOTATIONS = SENDER_SPECIFIABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__ID = SENDER_SPECIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__LOSS_MAGNITUDE = SENDER_SPECIFIABLE__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__ESTIMATES = SENDER_SPECIFIABLE__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__BOUND = SENDER_SPECIFIABLE__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__LOSS_MAGNITUDE_BY_ID = SENDER_SPECIFIABLE__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__SECURITYANNOTATION = SENDER_SPECIFIABLE__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__DFDELEMENTANNOTATION = SENDER_SPECIFIABLE__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Sender Specified By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__SENDER_SPECIFIED_BY = SENDER_SPECIFIABLE__SENDER_SPECIFIED_BY;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__SENDER = SENDER_SPECIFIABLE__SENDER;

	/**
	 * The feature id for the '<em><b>Specifies Sender Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION__SPECIFIES_SENDER_OF = SENDER_SPECIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sender Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION_FEATURE_COUNT = SENDER_SPECIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION___GET_ESTIMATE__ABSTRACTTHREATTYPE = SENDER_SPECIFIABLE___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The operation id for the '<em>Get Data Flow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION___GET_DATA_FLOW = SENDER_SPECIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sender Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_SPECIFICATION_OPERATION_COUNT = SENDER_SPECIFIABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RecipientSpecificationImpl <em>Recipient Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RecipientSpecificationImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getRecipientSpecification()
	 * @generated
	 */
	int RECIPIENT_SPECIFICATION = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__NAME = RECIPIENT_SPECIFIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__DESCRIPTION = RECIPIENT_SPECIFIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__ANNOTATIONS = RECIPIENT_SPECIFIABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__ID = RECIPIENT_SPECIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__LOSS_MAGNITUDE = RECIPIENT_SPECIFIABLE__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__ESTIMATES = RECIPIENT_SPECIFIABLE__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__BOUND = RECIPIENT_SPECIFIABLE__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__LOSS_MAGNITUDE_BY_ID = RECIPIENT_SPECIFIABLE__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__SECURITYANNOTATION = RECIPIENT_SPECIFIABLE__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Dfdelementannotation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__DFDELEMENTANNOTATION = RECIPIENT_SPECIFIABLE__DFDELEMENTANNOTATION;

	/**
	 * The feature id for the '<em><b>Recipient Specified By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__RECIPIENT_SPECIFIED_BY = RECIPIENT_SPECIFIABLE__RECIPIENT_SPECIFIED_BY;

	/**
	 * The feature id for the '<em><b>Recipient</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__RECIPIENT = RECIPIENT_SPECIFIABLE__RECIPIENT;

	/**
	 * The feature id for the '<em><b>Specifies Recipient Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF = RECIPIENT_SPECIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Recipient Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION_FEATURE_COUNT = RECIPIENT_SPECIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION___GET_ESTIMATE__ABSTRACTTHREATTYPE = RECIPIENT_SPECIFIABLE___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The operation id for the '<em>Get Data Flow</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION___GET_DATA_FLOW = RECIPIENT_SPECIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Recipient Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_SPECIFICATION_OPERATION_COUNT = RECIPIENT_SPECIFIABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SecurityAnnotationImpl <em>Security Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SecurityAnnotationImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSecurityAnnotation()
	 * @generated
	 */
	int SECURITY_ANNOTATION = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ANNOTATION__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ANNOTATION__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ANNOTATION__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ANNOTATION__ID = SECURITY_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Security Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ANNOTATION_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Security Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ANNOTATION_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionTypeImpl <em>Solution Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionTypeImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSolutionType()
	 * @generated
	 */
	int SOLUTION_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE__ID = SECURITY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE__ROLES = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Countermeasure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE__COUNTERMEASURE = SECURITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Solution Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Solution Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ID = SECURITY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Subjected</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__SUBJECTED = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binding Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__BINDING_TYPES = SECURITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl <em>Abstract Threat Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAbstractThreatType()
	 * @generated
	 */
	int ABSTRACT_THREAT_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__ID = SECURITY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__ENABLED = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__PATTERNS = SECURITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__TITLE = SECURITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO = SECURITY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__COMMENTS = SECURITY_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Characteristic</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__CHARACTERISTIC = SECURITY_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Super Threat Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE = SECURITY_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Abstract Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Abstract Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_THREAT_TYPE_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl <em>Counter Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getCounterMeasure()
	 * @generated
	 */
	int COUNTER_MEASURE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__ID = SECURITY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Mitigates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__MITIGATES = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Securitysubobjective</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__SECURITYSUBOBJECTIVE = SECURITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__SCOPE = SECURITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__SUBJECT = SECURITY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Difficulty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__DIFFICULTY = SECURITY_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Mitigated Threat Type ID</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE__MITIGATED_THREAT_TYPE_ID = SECURITY_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Counter Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Counter Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_MEASURE_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleBindingImpl <em>Role Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleBindingImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getRoleBinding()
	 * @generated
	 */
	int ROLE_BINDING = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_BINDING__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_BINDING__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_BINDING__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_BINDING__ID = SECURITY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_BINDING__BINDS = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_BINDING__BINDS_TO = SECURITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Role Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_BINDING_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Role Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_BINDING_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionImpl <em>Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ID = SECURITY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Securitypattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__SECURITYPATTERN = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rolebinding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ROLEBINDING = SECURITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl <em>Threat Type Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatTypeCatalog()
	 * @generated
	 */
	int THREAT_TYPE_CATALOG = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__NAME = SPARTA_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__DESCRIPTION = SPARTA_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__ANNOTATIONS = SPARTA_RESOURCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__ID = SPARTA_RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__SECURITYANNOTATION = SPARTA_RESOURCE__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Threat</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__THREAT = SPARTA_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Threattypegroup</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__THREATTYPEGROUP = SPARTA_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conditionlist</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__CONDITIONLIST = SPARTA_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__IMPORTS = SPARTA_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Helper Patterns</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__HELPER_PATTERNS = SPARTA_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__PACKAGE = SPARTA_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Pattern Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG__PATTERN_DEPENDENCIES = SPARTA_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Threat Type Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG_FEATURE_COUNT = SPARTA_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Threat Type Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_CATALOG_OPERATION_COUNT = SPARTA_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionTypeCatalogImpl <em>Solution Type Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionTypeCatalogImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSolutionTypeCatalog()
	 * @generated
	 */
	int SOLUTION_TYPE_CATALOG = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_CATALOG__NAME = SPARTA_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_CATALOG__DESCRIPTION = SPARTA_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_CATALOG__ANNOTATIONS = SPARTA_RESOURCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_CATALOG__ID = SPARTA_RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_CATALOG__SECURITYANNOTATION = SPARTA_RESOURCE__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Solution Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_CATALOG__SOLUTION_TYPES = SPARTA_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Solution Type Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_CATALOG_FEATURE_COUNT = SPARTA_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Solution Type Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_TYPE_CATALOG_OPERATION_COUNT = SPARTA_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EStringToEBooleanMapImpl <em>EString To EBoolean Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EStringToEBooleanMapImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getEStringToEBooleanMap()
	 * @generated
	 */
	int ESTRING_TO_EBOOLEAN_MAP = 26;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EBOOLEAN_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EBOOLEAN_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To EBoolean Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EBOOLEAN_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EString To EBoolean Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EBOOLEAN_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatSpecificationImpl <em>Threat Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatSpecificationImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatSpecification()
	 * @generated
	 */
	int THREAT_SPECIFICATION = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION__ID = SECURITY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Threat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION__THREAT = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION__ENABLED = SECURITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION__TYPES = SECURITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION__PATTERNS = SECURITY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Threat Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Threat Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatSpecificationCatalogImpl <em>Threat Specification Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatSpecificationCatalogImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatSpecificationCatalog()
	 * @generated
	 */
	int THREAT_SPECIFICATION_CATALOG = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_CATALOG__NAME = SPARTA_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_CATALOG__DESCRIPTION = SPARTA_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_CATALOG__ANNOTATIONS = SPARTA_RESOURCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_CATALOG__ID = SPARTA_RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_CATALOG__SECURITYANNOTATION = SPARTA_RESOURCE__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Threatspecifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_CATALOG__THREATSPECIFICATIONS = SPARTA_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Threat Specification Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_CATALOG_FEATURE_COUNT = SPARTA_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Threat Specification Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_SPECIFICATION_CATALOG_OPERATION_COUNT = SPARTA_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CompositeThreatTypeImpl <em>Composite Threat Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CompositeThreatTypeImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getCompositeThreatType()
	 * @generated
	 */
	int COMPOSITE_THREAT_TYPE = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__NAME = ABSTRACT_THREAT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__DESCRIPTION = ABSTRACT_THREAT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__ANNOTATIONS = ABSTRACT_THREAT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__ID = ABSTRACT_THREAT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__ENABLED = ABSTRACT_THREAT_TYPE__ENABLED;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__PATTERNS = ABSTRACT_THREAT_TYPE__PATTERNS;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__TITLE = ABSTRACT_THREAT_TYPE__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__ADDITIONAL_INFO = ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__COMMENTS = ABSTRACT_THREAT_TYPE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Characteristic</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__CHARACTERISTIC = ABSTRACT_THREAT_TYPE__CHARACTERISTIC;

	/**
	 * The feature id for the '<em><b>Super Threat Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__SUPER_THREAT_TYPE = ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Threat Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES = ABSTRACT_THREAT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE_FEATURE_COUNT = ABSTRACT_THREAT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_THREAT_TYPE_OPERATION_COUNT = ABSTRACT_THREAT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeImpl <em>Threat Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatType()
	 * @generated
	 */
	int THREAT_TYPE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__NAME = ABSTRACT_THREAT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__DESCRIPTION = ABSTRACT_THREAT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__ANNOTATIONS = ABSTRACT_THREAT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__ID = ABSTRACT_THREAT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__ENABLED = ABSTRACT_THREAT_TYPE__ENABLED;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__PATTERNS = ABSTRACT_THREAT_TYPE__PATTERNS;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__TITLE = ABSTRACT_THREAT_TYPE__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__ADDITIONAL_INFO = ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__COMMENTS = ABSTRACT_THREAT_TYPE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Characteristic</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__CHARACTERISTIC = ABSTRACT_THREAT_TYPE__CHARACTERISTIC;

	/**
	 * The feature id for the '<em><b>Super Threat Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__SUPER_THREAT_TYPE = ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__CONDITION = ABSTRACT_THREAT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Threatpattern</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__THREATPATTERN = ABSTRACT_THREAT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_FEATURE_COUNT = ABSTRACT_THREAT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE___TO_STRING = ABSTRACT_THREAT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Threat Type Ancestor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE___GET_THREAT_TYPE_ANCESTOR = ABSTRACT_THREAT_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_OPERATION_COUNT = ABSTRACT_THREAT_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EstimateImpl <em>Estimate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EstimateImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getEstimate()
	 * @generated
	 */
	int ESTIMATE = 32;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTIMATE__MINIMUM = 0;

	/**
	 * The feature id for the '<em><b>Probable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTIMATE__PROBABLE = 1;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTIMATE__MAXIMUM = 2;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTIMATE__CONFIDENCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTIMATE__NAME = 4;

	/**
	 * The number of structural features of the '<em>Estimate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTIMATE_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Get Estimate Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTIMATE___GET_ESTIMATE_NAME = 0;

	/**
	 * The number of operations of the '<em>Estimate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTIMATE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeToEstimateMapImpl <em>Threat Type To Estimate Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeToEstimateMapImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatTypeToEstimateMap()
	 * @generated
	 */
	int THREAT_TYPE_TO_ESTIMATE_MAP = 33;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_TO_ESTIMATE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_TO_ESTIMATE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Threat Type To Estimate Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_TO_ESTIMATE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Threat Type To Estimate Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_TO_ESTIMATE_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EStringToEStringMapImpl <em>EString To EString Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EStringToEStringMapImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getEStringToEStringMap()
	 * @generated
	 */
	int ESTRING_TO_ESTRING_MAP = 34;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ESTRING_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ESTRING_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To EString Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ESTRING_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EString To EString Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ESTRING_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.OrCompositeThreatTypeImpl <em>Or Composite Threat Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.OrCompositeThreatTypeImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getOrCompositeThreatType()
	 * @generated
	 */
	int OR_COMPOSITE_THREAT_TYPE = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__NAME = COMPOSITE_THREAT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__DESCRIPTION = COMPOSITE_THREAT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__ANNOTATIONS = COMPOSITE_THREAT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__ID = COMPOSITE_THREAT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__ENABLED = COMPOSITE_THREAT_TYPE__ENABLED;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__PATTERNS = COMPOSITE_THREAT_TYPE__PATTERNS;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__TITLE = COMPOSITE_THREAT_TYPE__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__ADDITIONAL_INFO = COMPOSITE_THREAT_TYPE__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__COMMENTS = COMPOSITE_THREAT_TYPE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Characteristic</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__CHARACTERISTIC = COMPOSITE_THREAT_TYPE__CHARACTERISTIC;

	/**
	 * The feature id for the '<em><b>Super Threat Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__SUPER_THREAT_TYPE = COMPOSITE_THREAT_TYPE__SUPER_THREAT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Threat Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES = COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES;

	/**
	 * The number of structural features of the '<em>Or Composite Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE_FEATURE_COUNT = COMPOSITE_THREAT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Composite Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_THREAT_TYPE_OPERATION_COUNT = COMPOSITE_THREAT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AndCompositeThreatTypeImpl <em>And Composite Threat Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AndCompositeThreatTypeImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAndCompositeThreatType()
	 * @generated
	 */
	int AND_COMPOSITE_THREAT_TYPE = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__NAME = COMPOSITE_THREAT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__DESCRIPTION = COMPOSITE_THREAT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__ANNOTATIONS = COMPOSITE_THREAT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__ID = COMPOSITE_THREAT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__ENABLED = COMPOSITE_THREAT_TYPE__ENABLED;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__PATTERNS = COMPOSITE_THREAT_TYPE__PATTERNS;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__TITLE = COMPOSITE_THREAT_TYPE__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__ADDITIONAL_INFO = COMPOSITE_THREAT_TYPE__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__COMMENTS = COMPOSITE_THREAT_TYPE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Characteristic</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__CHARACTERISTIC = COMPOSITE_THREAT_TYPE__CHARACTERISTIC;

	/**
	 * The feature id for the '<em><b>Super Threat Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__SUPER_THREAT_TYPE = COMPOSITE_THREAT_TYPE__SUPER_THREAT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Threat Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES = COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES;

	/**
	 * The number of structural features of the '<em>And Composite Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE_FEATURE_COUNT = COMPOSITE_THREAT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Composite Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_THREAT_TYPE_OPERATION_COUNT = COMPOSITE_THREAT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeGroupImpl <em>Threat Type Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeGroupImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatTypeGroup()
	 * @generated
	 */
	int THREAT_TYPE_GROUP = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__NAME = OR_COMPOSITE_THREAT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__DESCRIPTION = OR_COMPOSITE_THREAT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__ANNOTATIONS = OR_COMPOSITE_THREAT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__ID = OR_COMPOSITE_THREAT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__ENABLED = OR_COMPOSITE_THREAT_TYPE__ENABLED;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__PATTERNS = OR_COMPOSITE_THREAT_TYPE__PATTERNS;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__TITLE = OR_COMPOSITE_THREAT_TYPE__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__ADDITIONAL_INFO = OR_COMPOSITE_THREAT_TYPE__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__COMMENTS = OR_COMPOSITE_THREAT_TYPE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Characteristic</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__CHARACTERISTIC = OR_COMPOSITE_THREAT_TYPE__CHARACTERISTIC;

	/**
	 * The feature id for the '<em><b>Super Threat Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__SUPER_THREAT_TYPE = OR_COMPOSITE_THREAT_TYPE__SUPER_THREAT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Threat Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP__SUB_THREAT_TYPES = OR_COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES;

	/**
	 * The number of structural features of the '<em>Threat Type Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP_FEATURE_COUNT = OR_COMPOSITE_THREAT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Threat Type Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_GROUP_OPERATION_COUNT = OR_COMPOSITE_THREAT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractConditionImpl <em>Abstract Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAbstractCondition()
	 * @generated
	 */
	int ABSTRACT_CONDITION = 39;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION__ID = SECURITY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION__TITLE = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION__ADDITIONAL_INFO = SECURITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION__COMMENTS = SECURITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Abstract Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CompositeConditionImpl <em>Composite Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CompositeConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getCompositeCondition()
	 * @generated
	 */
	int COMPOSITE_CONDITION = 40;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__NAME = ABSTRACT_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__DESCRIPTION = ABSTRACT_CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__ANNOTATIONS = ABSTRACT_CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__ID = ABSTRACT_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__TITLE = ABSTRACT_CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__ADDITIONAL_INFO = ABSTRACT_CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__COMMENTS = ABSTRACT_CONDITION__COMMENTS;

	/**
	 * The number of structural features of the '<em>Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_FEATURE_COUNT = ABSTRACT_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_OPERATION_COUNT = ABSTRACT_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 41;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__NAME = ABSTRACT_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__DESCRIPTION = ABSTRACT_CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__ANNOTATIONS = ABSTRACT_CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__ID = ABSTRACT_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__TITLE = ABSTRACT_CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__ADDITIONAL_INFO = ABSTRACT_CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__COMMENTS = ABSTRACT_CONDITION__COMMENTS;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = ABSTRACT_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = ABSTRACT_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.MultipleCompositeConditionImpl <em>Multiple Composite Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.MultipleCompositeConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getMultipleCompositeCondition()
	 * @generated
	 */
	int MULTIPLE_COMPOSITE_CONDITION = 46;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION__NAME = COMPOSITE_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION__DESCRIPTION = COMPOSITE_CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION__ANNOTATIONS = COMPOSITE_CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION__ID = COMPOSITE_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION__TITLE = COMPOSITE_CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION__ADDITIONAL_INFO = COMPOSITE_CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION__COMMENTS = COMPOSITE_CONDITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Subcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION__SUBCONDITION = COMPOSITE_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multiple Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION_FEATURE_COUNT = COMPOSITE_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Multiple Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_COMPOSITE_CONDITION_OPERATION_COUNT = COMPOSITE_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AndCompositeConditionImpl <em>And Composite Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AndCompositeConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAndCompositeCondition()
	 * @generated
	 */
	int AND_COMPOSITE_CONDITION = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION__NAME = MULTIPLE_COMPOSITE_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION__DESCRIPTION = MULTIPLE_COMPOSITE_CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION__ANNOTATIONS = MULTIPLE_COMPOSITE_CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION__ID = MULTIPLE_COMPOSITE_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION__TITLE = MULTIPLE_COMPOSITE_CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION__ADDITIONAL_INFO = MULTIPLE_COMPOSITE_CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION__COMMENTS = MULTIPLE_COMPOSITE_CONDITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Subcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION__SUBCONDITION = MULTIPLE_COMPOSITE_CONDITION__SUBCONDITION;

	/**
	 * The number of structural features of the '<em>And Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION_FEATURE_COUNT = MULTIPLE_COMPOSITE_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_COMPOSITE_CONDITION_OPERATION_COUNT = MULTIPLE_COMPOSITE_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.OrCompositeConditionImpl <em>Or Composite Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.OrCompositeConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getOrCompositeCondition()
	 * @generated
	 */
	int OR_COMPOSITE_CONDITION = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION__NAME = MULTIPLE_COMPOSITE_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION__DESCRIPTION = MULTIPLE_COMPOSITE_CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION__ANNOTATIONS = MULTIPLE_COMPOSITE_CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION__ID = MULTIPLE_COMPOSITE_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION__TITLE = MULTIPLE_COMPOSITE_CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION__ADDITIONAL_INFO = MULTIPLE_COMPOSITE_CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION__COMMENTS = MULTIPLE_COMPOSITE_CONDITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Subcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION__SUBCONDITION = MULTIPLE_COMPOSITE_CONDITION__SUBCONDITION;

	/**
	 * The number of structural features of the '<em>Or Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION_FEATURE_COUNT = MULTIPLE_COMPOSITE_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_COMPOSITE_CONDITION_OPERATION_COUNT = MULTIPLE_COMPOSITE_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SingleCompositeConditionImpl <em>Single Composite Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SingleCompositeConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSingleCompositeCondition()
	 * @generated
	 */
	int SINGLE_COMPOSITE_CONDITION = 45;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION__NAME = COMPOSITE_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION__DESCRIPTION = COMPOSITE_CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION__ANNOTATIONS = COMPOSITE_CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION__ID = COMPOSITE_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION__TITLE = COMPOSITE_CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION__ADDITIONAL_INFO = COMPOSITE_CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION__COMMENTS = COMPOSITE_CONDITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Subcondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION__SUBCONDITION = COMPOSITE_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Single Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION_FEATURE_COUNT = COMPOSITE_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Single Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_COMPOSITE_CONDITION_OPERATION_COUNT = COMPOSITE_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.NotCompositeConditionImpl <em>Not Composite Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.NotCompositeConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getNotCompositeCondition()
	 * @generated
	 */
	int NOT_COMPOSITE_CONDITION = 44;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION__NAME = SINGLE_COMPOSITE_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION__DESCRIPTION = SINGLE_COMPOSITE_CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION__ANNOTATIONS = SINGLE_COMPOSITE_CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION__ID = SINGLE_COMPOSITE_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION__TITLE = SINGLE_COMPOSITE_CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION__ADDITIONAL_INFO = SINGLE_COMPOSITE_CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION__COMMENTS = SINGLE_COMPOSITE_CONDITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Subcondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION__SUBCONDITION = SINGLE_COMPOSITE_CONDITION__SUBCONDITION;

	/**
	 * The number of structural features of the '<em>Not Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION_FEATURE_COUNT = SINGLE_COMPOSITE_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_COMPOSITE_CONDITION_OPERATION_COUNT = SINGLE_COMPOSITE_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ConditionListImpl <em>Condition List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ConditionListImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getConditionList()
	 * @generated
	 */
	int CONDITION_LIST = 47;

	/**
	 * The feature id for the '<em><b>Abstractcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_LIST__ABSTRACTCONDITION = 0;

	/**
	 * The number of structural features of the '<em>Condition List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_LIST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Condition List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_LIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AImportedConditionImpl <em>AImported Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AImportedConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAImportedCondition()
	 * @generated
	 */
	int AIMPORTED_CONDITION = 48;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIMPORTED_CONDITION__NAME = CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIMPORTED_CONDITION__DESCRIPTION = CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIMPORTED_CONDITION__ANNOTATIONS = CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIMPORTED_CONDITION__ID = CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIMPORTED_CONDITION__TITLE = CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIMPORTED_CONDITION__ADDITIONAL_INFO = CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIMPORTED_CONDITION__COMMENTS = CONDITION__COMMENTS;

	/**
	 * The number of structural features of the '<em>AImported Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIMPORTED_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>AImported Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIMPORTED_CONDITION_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ImportedThreatConditionImpl <em>Imported Threat Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ImportedThreatConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getImportedThreatCondition()
	 * @generated
	 */
	int IMPORTED_THREAT_CONDITION = 49;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION__NAME = AIMPORTED_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION__DESCRIPTION = AIMPORTED_CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION__ANNOTATIONS = AIMPORTED_CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION__ID = AIMPORTED_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION__TITLE = AIMPORTED_CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION__ADDITIONAL_INFO = AIMPORTED_CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION__COMMENTS = AIMPORTED_CONDITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Threattype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION__THREATTYPE = AIMPORTED_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imported Threat Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION_FEATURE_COUNT = AIMPORTED_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Imported Threat Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_THREAT_CONDITION_OPERATION_COUNT = AIMPORTED_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ImportedConditionImpl <em>Imported Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ImportedConditionImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getImportedCondition()
	 * @generated
	 */
	int IMPORTED_CONDITION = 50;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION__NAME = AIMPORTED_CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION__DESCRIPTION = AIMPORTED_CONDITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION__ANNOTATIONS = AIMPORTED_CONDITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION__ID = AIMPORTED_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION__TITLE = AIMPORTED_CONDITION__TITLE;

	/**
	 * The feature id for the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION__ADDITIONAL_INFO = AIMPORTED_CONDITION__ADDITIONAL_INFO;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION__COMMENTS = AIMPORTED_CONDITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION__CONDITION = AIMPORTED_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imported Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION_FEATURE_COUNT = AIMPORTED_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Imported Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_CONDITION_OPERATION_COUNT = AIMPORTED_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation <em>DFD Element Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDElementAnnotation()
	 * @generated
	 */
	int DFD_ELEMENT_ANNOTATION = 51;

	/**
	 * The feature id for the '<em><b>Dfdelement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT_ANNOTATION__DFDELEMENT = 0;

	/**
	 * The number of structural features of the '<em>DFD Element Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT_ANNOTATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>DFD Element Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_ELEMENT_ANNOTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerModelImpl <em>Attacker Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerModelImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAttackerModel()
	 * @generated
	 */
	int ATTACKER_MODEL = 52;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_MODEL__NAME = SPARTA_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_MODEL__DESCRIPTION = SPARTA_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_MODEL__ANNOTATIONS = SPARTA_RESOURCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_MODEL__ID = SPARTA_RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_MODEL__SECURITYANNOTATION = SPARTA_RESOURCE__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Attacker Profiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_MODEL__ATTACKER_PROFILES = SPARTA_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attacker Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_MODEL_FEATURE_COUNT = SPARTA_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attacker Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_MODEL_OPERATION_COUNT = SPARTA_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl <em>Attacker Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAttackerProfile()
	 * @generated
	 */
	int ATTACKER_PROFILE = 53;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__NAME = SECURITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__DESCRIPTION = SECURITY_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__ANNOTATIONS = SECURITY_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__ID = SECURITY_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Threat Capability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__THREAT_CAPABILITY = SECURITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Probability Of Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__PROBABILITY_OF_ACTION = SECURITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contact Frequency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__CONTACT_FREQUENCY = SECURITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Insider</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__INSIDER = SECURITY_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__ENABLED = SECURITY_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Attacker Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE_FEATURE_COUNT = SECURITY_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Attacker Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE_OPERATION_COUNT = SECURITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic <em>ICharacteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getICharacteristic()
	 * @generated
	 */
	int ICHARACTERISTIC = 54;

	/**
	 * The number of structural features of the '<em>ICharacteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICHARACTERISTIC_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>ICharacteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICHARACTERISTIC_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataModelImpl <em>Data Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataModelImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataModel()
	 * @generated
	 */
	int DATA_MODEL = 55;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__NAME = SPARTA_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__DESCRIPTION = SPARTA_RESOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__ANNOTATIONS = SPARTA_RESOURCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__ID = SPARTA_RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Securityannotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__SECURITYANNOTATION = SPARTA_RESOURCE__SECURITYANNOTATION;

	/**
	 * The feature id for the '<em><b>Data Model Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL__DATA_MODEL_ELEMENTS = SPARTA_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL_FEATURE_COUNT = SPARTA_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL_OPERATION_COUNT = SPARTA_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataTypeImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 56;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = ASSET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__DESCRIPTION = ASSET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__ANNOTATIONS = ASSET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__ID = ASSET__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__LOSS_MAGNITUDE = ASSET__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__ESTIMATES = ASSET__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__BOUND = ASSET__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__LOSS_MAGNITUDE_BY_ID = ASSET__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Dfdelement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__DFDELEMENT = ASSET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__SENSITIVE = ASSET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = ASSET_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___GET_ESTIMATE__ABSTRACTTHREATTYPE = ASSET___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = ASSET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TransformedDataImpl <em>Transformed Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TransformedDataImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getTransformedData()
	 * @generated
	 */
	int TRANSFORMED_DATA = 57;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__DESCRIPTION = DATA_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__ANNOTATIONS = DATA_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__ID = DATA_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__LOSS_MAGNITUDE = DATA_TYPE__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__ESTIMATES = DATA_TYPE__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__BOUND = DATA_TYPE__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__LOSS_MAGNITUDE_BY_ID = DATA_TYPE__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Dfdelement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__DFDELEMENT = DATA_TYPE__DFDELEMENT;

	/**
	 * The feature id for the '<em><b>Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__SENSITIVE = DATA_TYPE__SENSITIVE;

	/**
	 * The feature id for the '<em><b>Dec Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__DEC_KEY = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enc Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__ENC_KEY = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA__DATATYPE = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transformed Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA___GET_ESTIMATE__ABSTRACTTHREATTYPE = DATA_TYPE___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>Transformed Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMED_DATA_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement <em>Data Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataModelElement()
	 * @generated
	 */
	int DATA_MODEL_ELEMENT = 58;

	/**
	 * The feature id for the '<em><b>Dfdelement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL_ELEMENT__DFDELEMENT = DFD_ELEMENT_ANNOTATION__DFDELEMENT;

	/**
	 * The number of structural features of the '<em>Data Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL_ELEMENT_FEATURE_COUNT = DFD_ELEMENT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MODEL_ELEMENT_OPERATION_COUNT = DFD_ELEMENT_ANNOTATION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSubjectTypeImpl <em>Data Subject Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSubjectTypeImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataSubjectType()
	 * @generated
	 */
	int DATA_SUBJECT_TYPE = 59;

	/**
	 * The feature id for the '<em><b>Dfdelement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT_TYPE__DFDELEMENT = DATA_MODEL_ELEMENT__DFDELEMENT;

	/**
	 * The feature id for the '<em><b>Personaldatatype</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT_TYPE__PERSONALDATATYPE = DATA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sensitivity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT_TYPE__SENSITIVITY = DATA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nbr Of Subjects</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS = DATA_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Subject Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT_TYPE_FEATURE_COUNT = DATA_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Data Subject Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT_TYPE_OPERATION_COUNT = DATA_MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.PersonalDataTypeImpl <em>Personal Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.PersonalDataTypeImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getPersonalDataType()
	 * @generated
	 */
	int PERSONAL_DATA_TYPE = 60;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__DESCRIPTION = DATA_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__ANNOTATIONS = DATA_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__ID = DATA_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Loss Magnitude</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__LOSS_MAGNITUDE = DATA_TYPE__LOSS_MAGNITUDE;

	/**
	 * The feature id for the '<em><b>Estimates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__ESTIMATES = DATA_TYPE__ESTIMATES;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__BOUND = DATA_TYPE__BOUND;

	/**
	 * The feature id for the '<em><b>Loss Magnitude By ID</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__LOSS_MAGNITUDE_BY_ID = DATA_TYPE__LOSS_MAGNITUDE_BY_ID;

	/**
	 * The feature id for the '<em><b>Dfdelement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__DFDELEMENT = DATA_TYPE__DFDELEMENT;

	/**
	 * The feature id for the '<em><b>Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__SENSITIVE = DATA_TYPE__SENSITIVE;

	/**
	 * The feature id for the '<em><b>Sensitivity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__SENSITIVITY = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nbr Of Records</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__NBR_OF_RECORDS = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Retention</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE__RETENTION = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Personal Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Estimate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE___GET_ESTIMATE__ABSTRACTTHREATTYPE = DATA_TYPE___GET_ESTIMATE__ABSTRACTTHREATTYPE;

	/**
	 * The number of operations of the '<em>Personal Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSetImpl <em>Data Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSetImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataSet()
	 * @generated
	 */
	int DATA_SET = 61;

	/**
	 * The feature id for the '<em><b>Dfdelement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET__DFDELEMENT = DATA_MODEL_ELEMENT__DFDELEMENT;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET__DATATYPE = DATA_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET_FEATURE_COUNT = DATA_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SET_OPERATION_COUNT = DATA_MODEL_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation <em>IModel Element Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getIModelElementAnnotation()
	 * @generated
	 */
	int IMODEL_ELEMENT_ANNOTATION = 62;

	/**
	 * The number of structural features of the '<em>IModel Element Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMODEL_ELEMENT_ANNOTATION_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMODEL_ELEMENT_ANNOTATION___GET_ANNOTATION = 0;

	/**
	 * The number of operations of the '<em>IModel Element Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMODEL_ELEMENT_ANNOTATION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.KVModelElementAnnotationImpl <em>KV Model Element Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.KVModelElementAnnotationImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getKVModelElementAnnotation()
	 * @generated
	 */
	int KV_MODEL_ELEMENT_ANNOTATION = 63;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KV_MODEL_ELEMENT_ANNOTATION__KEY = IMODEL_ELEMENT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KV_MODEL_ELEMENT_ANNOTATION__VALUE = IMODEL_ELEMENT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>KV Model Element Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KV_MODEL_ELEMENT_ANNOTATION_FEATURE_COUNT = IMODEL_ELEMENT_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KV_MODEL_ELEMENT_ANNOTATION___GET_ANNOTATION = IMODEL_ELEMENT_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>KV Model Element Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KV_MODEL_ELEMENT_ANNOTATION_OPERATION_COUNT = IMODEL_ELEMENT_ANNOTATION_OPERATION_COUNT + 1;


	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ModelElementAnnotationImpl <em>Model Element Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ModelElementAnnotationImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getModelElementAnnotation()
	 * @generated
	 */
	int MODEL_ELEMENT_ANNOTATION = 64;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ANNOTATION__VALUE = IMODEL_ELEMENT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ANNOTATION_FEATURE_COUNT = IMODEL_ELEMENT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ANNOTATION___GET_ANNOTATION = IMODEL_ELEMENT_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Model Element Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ANNOTATION_OPERATION_COUNT = IMODEL_ELEMENT_ANNOTATION_OPERATION_COUNT + 1;


	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatPatternImpl <em>Threat Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatPatternImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatPattern()
	 * @generated
	 */
	int THREAT_PATTERN = 65;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_PATTERN__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_PATTERN__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_PATTERN__ANNOTATIONS = MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_PATTERN__ID = MODEL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Long Description</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_PATTERN__LONG_DESCRIPTION = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_PATTERN__PATTERNS = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_PATTERN__MAPPING = MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Threat Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_PATTERN_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Threat Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_PATTERN_OPERATION_COUNT = MODEL_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeIDToEstimateMapImpl <em>Threat Type ID To Estimate Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeIDToEstimateMapImpl
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatTypeIDToEstimateMap()
	 * @generated
	 */
	int THREAT_TYPE_ID_TO_ESTIMATE_MAP = 66;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_ID_TO_ESTIMATE_MAP__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_ID_TO_ESTIMATE_MAP__KEY = 1;

	/**
	 * The number of structural features of the '<em>Threat Type ID To Estimate Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_ID_TO_ESTIMATE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Threat Type ID To Estimate Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_ID_TO_ESTIMATE_MAP_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow
	 * @generated
	 */
	EClass getDataFlow();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow#getDataFlow() <em>Get Data Flow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Data Flow</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow#getDataFlow()
	 * @generated
	 */
	EOperation getDataFlow__GetDataFlow();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity <em>Data Flow Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow Entity</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity
	 * @generated
	 */
	EClass getDataFlowEntity();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getSend <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Send</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getSend()
	 * @see #getDataFlowEntity()
	 * @generated
	 */
	EReference getDataFlowEntity_Send();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receive</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity#getReceive()
	 * @see #getDataFlowEntity()
	 * @generated
	 */
	EReference getDataFlowEntity_Receive();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity <em>External Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Entity</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity
	 * @generated
	 */
	EClass getExternalEntity();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore <em>Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Store</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore
	 * @generated
	 */
	EClass getDataStore();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel <em>DFD Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Model</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel
	 * @generated
	 */
	EClass getDFDModel();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel#getContainedElements <em>Contained Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Elements</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel#getContainedElements()
	 * @see #getDFDModel()
	 * @generated
	 */
	EReference getDFDModel_ContainedElements();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resource</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel#getResource()
	 * @see #getDFDModel()
	 * @generated
	 */
	EReference getDFDModel_Resource();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement <em>DFD Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Element</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement
	 * @generated
	 */
	EClass getDFDElement();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement#getSecurityannotation <em>Securityannotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Securityannotation</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement#getSecurityannotation()
	 * @see #getDFDElement()
	 * @generated
	 */
	EReference getDFDElement_Securityannotation();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement#getDfdelementannotation <em>Dfdelementannotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dfdelementannotation</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement#getDfdelementannotation()
	 * @see #getDFDElement()
	 * @generated
	 */
	EReference getDFDElement_Dfdelementannotation();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityElement <em>Security Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Element</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityElement
	 * @generated
	 */
	EClass getSecurityElement();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDBoundaryElement <em>DFD Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Boundary Element</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDBoundaryElement
	 * @generated
	 */
	EClass getDFDBoundaryElement();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDBoundaryElement#getCrossingFlows <em>Crossing Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Crossing Flows</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDBoundaryElement#getCrossingFlows()
	 * @see #getDFDBoundaryElement()
	 * @generated
	 */
	EReference getDFDBoundaryElement_CrossingFlows();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer <em>Trust Boundary Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trust Boundary Container</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer
	 * @generated
	 */
	EClass getTrustBoundaryContainer();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable <em>Sender Specifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sender Specifiable</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable
	 * @generated
	 */
	EClass getSenderSpecifiable();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSenderSpecifiedBy <em>Sender Specified By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sender Specified By</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSenderSpecifiedBy()
	 * @see #getSenderSpecifiable()
	 * @generated
	 */
	EReference getSenderSpecifiable_SenderSpecifiedBy();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sender</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable#getSender()
	 * @see #getSenderSpecifiable()
	 * @generated
	 */
	EReference getSenderSpecifiable_Sender();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable <em>Recipient Specifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recipient Specifiable</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable
	 * @generated
	 */
	EClass getRecipientSpecifiable();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipientSpecifiedBy <em>Recipient Specified By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recipient Specified By</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipientSpecifiedBy()
	 * @see #getRecipientSpecifiable()
	 * @generated
	 */
	EReference getRecipientSpecifiable_RecipientSpecifiedBy();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipient <em>Recipient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recipient</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable#getRecipient()
	 * @see #getRecipientSpecifiable()
	 * @generated
	 */
	EReference getRecipientSpecifiable_Recipient();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification <em>Sender Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sender Specification</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification
	 * @generated
	 */
	EClass getSenderSpecification();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification#getSpecifiesSenderOf <em>Specifies Sender Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specifies Sender Of</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification#getSpecifiesSenderOf()
	 * @see #getSenderSpecification()
	 * @generated
	 */
	EReference getSenderSpecification_SpecifiesSenderOf();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification#getDataFlow() <em>Get Data Flow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Data Flow</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification#getDataFlow()
	 * @generated
	 */
	EOperation getSenderSpecification__GetDataFlow();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification <em>Recipient Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recipient Specification</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification
	 * @generated
	 */
	EClass getRecipientSpecification();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification#getSpecifiesRecipientOf <em>Specifies Recipient Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specifies Recipient Of</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification#getSpecifiesRecipientOf()
	 * @see #getRecipientSpecification()
	 * @generated
	 */
	EReference getRecipientSpecification_SpecifiesRecipientOf();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification#getDataFlow() <em>Get Data Flow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Data Flow</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification#getDataFlow()
	 * @generated
	 */
	EOperation getRecipientSpecification__GetDataFlow();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.FlowElement <em>Flow Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Element</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.FlowElement
	 * @generated
	 */
	EClass getFlowElement();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.FlowElement#getDataFlow() <em>Get Data Flow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Data Flow</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.FlowElement#getDataFlow()
	 * @generated
	 */
	EOperation getFlowElement__GetDataFlow();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDContainer <em>DFD Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Container</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDContainer
	 * @generated
	 */
	EClass getDFDContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDContainer#getContainedElements <em>Contained Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Elements</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDContainer#getContainedElements()
	 * @see #getDFDContainer()
	 * @generated
	 */
	EReference getDFDContainer_ContainedElements();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityAnnotation <em>Security Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Annotation</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityAnnotation
	 * @generated
	 */
	EClass getSecurityAnnotation();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType <em>Solution Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType
	 * @generated
	 */
	EClass getSolutionType();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType#getRoles()
	 * @see #getSolutionType()
	 * @generated
	 */
	EReference getSolutionType_Roles();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType#getCountermeasure <em>Countermeasure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Countermeasure</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType#getCountermeasure()
	 * @see #getSolutionType()
	 * @generated
	 */
	EReference getSolutionType_Countermeasure();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Role#getSubjected <em>Subjected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subjected</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Role#getSubjected()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Subjected();

	/**
	 * Returns the meta object for the attribute list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Role#getBindingTypes <em>Binding Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Binding Types</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Role#getBindingTypes()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_BindingTypes();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType <em>Abstract Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Threat Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType
	 * @generated
	 */
	EClass getAbstractThreatType();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#isEnabled()
	 * @see #getAbstractThreatType()
	 * @generated
	 */
	EAttribute getAbstractThreatType_Enabled();

	/**
	 * Returns the meta object for the map '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Patterns</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getPatterns()
	 * @see #getAbstractThreatType()
	 * @generated
	 */
	EReference getAbstractThreatType_Patterns();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getTitle()
	 * @see #getAbstractThreatType()
	 * @generated
	 */
	EAttribute getAbstractThreatType_Title();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getAdditionalInfo <em>Additional Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Additional Info</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getAdditionalInfo()
	 * @see #getAbstractThreatType()
	 * @generated
	 */
	EAttribute getAbstractThreatType_AdditionalInfo();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getComments()
	 * @see #getAbstractThreatType()
	 * @generated
	 */
	EAttribute getAbstractThreatType_Comments();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getCharacteristic <em>Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Characteristic</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getCharacteristic()
	 * @see #getAbstractThreatType()
	 * @generated
	 */
	EReference getAbstractThreatType_Characteristic();

	/**
	 * Returns the meta object for the container reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getSuperThreatType <em>Super Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Super Threat Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getSuperThreatType()
	 * @see #getAbstractThreatType()
	 * @generated
	 */
	EReference getAbstractThreatType_SuperThreatType();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure <em>Counter Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Counter Measure</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure
	 * @generated
	 */
	EClass getCounterMeasure();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getMitigates <em>Mitigates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mitigates</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getMitigates()
	 * @see #getCounterMeasure()
	 * @generated
	 */
	EReference getCounterMeasure_Mitigates();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getSecuritysubobjective <em>Securitysubobjective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Securitysubobjective</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getSecuritysubobjective()
	 * @see #getCounterMeasure()
	 * @generated
	 */
	EReference getCounterMeasure_Securitysubobjective();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scope</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getScope()
	 * @see #getCounterMeasure()
	 * @generated
	 */
	EReference getCounterMeasure_Scope();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subject</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getSubject()
	 * @see #getCounterMeasure()
	 * @generated
	 */
	EReference getCounterMeasure_Subject();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getDifficulty <em>Difficulty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Difficulty</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getDifficulty()
	 * @see #getCounterMeasure()
	 * @generated
	 */
	EReference getCounterMeasure_Difficulty();

	/**
	 * Returns the meta object for the attribute list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getMitigatedThreatTypeID <em>Mitigated Threat Type ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mitigated Threat Type ID</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getMitigatedThreatTypeID()
	 * @see #getCounterMeasure()
	 * @generated
	 */
	EAttribute getCounterMeasure_MitigatedThreatTypeID();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding <em>Role Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Binding</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding
	 * @generated
	 */
	EClass getRoleBinding();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding#getBinds <em>Binds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binds</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding#getBinds()
	 * @see #getRoleBinding()
	 * @generated
	 */
	EReference getRoleBinding_Binds();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding#getBindsTo <em>Binds To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Binds To</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding#getBindsTo()
	 * @see #getRoleBinding()
	 * @generated
	 */
	EReference getRoleBinding_BindsTo();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Solution
	 * @generated
	 */
	EClass getSolution();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Solution#getSecuritypattern <em>Securitypattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Securitypattern</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Solution#getSecuritypattern()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_Securitypattern();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Solution#getRolebinding <em>Rolebinding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rolebinding</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Solution#getRolebinding()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_Rolebinding();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaResource <em>Sparta Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sparta Resource</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaResource
	 * @generated
	 */
	EClass getSpartaResource();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaResource#getSecurityannotation <em>Securityannotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Securityannotation</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaResource#getSecurityannotation()
	 * @see #getSpartaResource()
	 * @generated
	 */
	EReference getSpartaResource_Securityannotation();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog <em>Threat Type Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Type Catalog</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog
	 * @generated
	 */
	EClass getThreatTypeCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getThreat <em>Threat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Threat</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getThreat()
	 * @see #getThreatTypeCatalog()
	 * @generated
	 */
	EReference getThreatTypeCatalog_Threat();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getThreattypegroup <em>Threattypegroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Threattypegroup</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getThreattypegroup()
	 * @see #getThreatTypeCatalog()
	 * @generated
	 */
	EReference getThreatTypeCatalog_Threattypegroup();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getConditionlist <em>Conditionlist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditionlist</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getConditionlist()
	 * @see #getThreatTypeCatalog()
	 * @generated
	 */
	EReference getThreatTypeCatalog_Conditionlist();

	/**
	 * Returns the meta object for the attribute list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Imports</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getImports()
	 * @see #getThreatTypeCatalog()
	 * @generated
	 */
	EAttribute getThreatTypeCatalog_Imports();

	/**
	 * Returns the meta object for the attribute list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getHelperPatterns <em>Helper Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Helper Patterns</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getHelperPatterns()
	 * @see #getThreatTypeCatalog()
	 * @generated
	 */
	EAttribute getThreatTypeCatalog_HelperPatterns();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getPackage()
	 * @see #getThreatTypeCatalog()
	 * @generated
	 */
	EAttribute getThreatTypeCatalog_Package();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getPatternDependencies <em>Pattern Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Pattern Dependencies</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getPatternDependencies()
	 * @see #getThreatTypeCatalog()
	 * @generated
	 */
	EReference getThreatTypeCatalog_PatternDependencies();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionTypeCatalog <em>Solution Type Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution Type Catalog</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionTypeCatalog
	 * @generated
	 */
	EClass getSolutionTypeCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionTypeCatalog#getSolutionTypes <em>Solution Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Solution Types</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionTypeCatalog#getSolutionTypes()
	 * @see #getSolutionTypeCatalog()
	 * @generated
	 */
	EReference getSolutionTypeCatalog_SolutionTypes();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To EBoolean Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To EBoolean Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EBooleanObject"
	 * @generated
	 */
	EClass getEStringToEBooleanMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEBooleanMap()
	 * @generated
	 */
	EAttribute getEStringToEBooleanMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEBooleanMap()
	 * @generated
	 */
	EAttribute getEStringToEBooleanMap_Value();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification <em>Threat Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Specification</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification
	 * @generated
	 */
	EClass getThreatSpecification();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getThreat <em>Threat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Threat</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getThreat()
	 * @see #getThreatSpecification()
	 * @generated
	 */
	EReference getThreatSpecification_Threat();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#isEnabled()
	 * @see #getThreatSpecification()
	 * @generated
	 */
	EAttribute getThreatSpecification_Enabled();

	/**
	 * Returns the meta object for the map '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Types</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getTypes()
	 * @see #getThreatSpecification()
	 * @generated
	 */
	EReference getThreatSpecification_Types();

	/**
	 * Returns the meta object for the map '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Patterns</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getPatterns()
	 * @see #getThreatSpecification()
	 * @generated
	 */
	EReference getThreatSpecification_Patterns();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog <em>Threat Specification Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Specification Catalog</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog
	 * @generated
	 */
	EClass getThreatSpecificationCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog#getThreatspecifications <em>Threatspecifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Threatspecifications</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog#getThreatspecifications()
	 * @see #getThreatSpecificationCatalog()
	 * @generated
	 */
	EReference getThreatSpecificationCatalog_Threatspecifications();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asset</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Asset
	 * @generated
	 */
	EClass getAsset();

	/**
	 * Returns the meta object for the map '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getLossMagnitude <em>Loss Magnitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Loss Magnitude</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getLossMagnitude()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_LossMagnitude();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getEstimates <em>Estimates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Estimates</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getEstimates()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_Estimates();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getBound <em>Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bound</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getBound()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_Bound();

	/**
	 * Returns the meta object for the map '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getLossMagnitudeByID <em>Loss Magnitude By ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Loss Magnitude By ID</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getLossMagnitudeByID()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_LossMagnitudeByID();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getEstimate(be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType) <em>Get Estimate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Estimate</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Asset#getEstimate(be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType)
	 * @generated
	 */
	EOperation getAsset__GetEstimate__AbstractThreatType();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType <em>Composite Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Threat Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType
	 * @generated
	 */
	EClass getCompositeThreatType();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType#getSubThreatTypes <em>Sub Threat Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Threat Types</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType#getSubThreatTypes()
	 * @see #getCompositeThreatType()
	 * @generated
	 */
	EReference getCompositeThreatType_SubThreatTypes();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType <em>Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType
	 * @generated
	 */
	EClass getThreatType();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType#getCondition()
	 * @see #getThreatType()
	 * @generated
	 */
	EReference getThreatType_Condition();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType#getThreatpattern <em>Threatpattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Threatpattern</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType#getThreatpattern()
	 * @see #getThreatType()
	 * @generated
	 */
	EReference getThreatType_Threatpattern();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType#toString()
	 * @generated
	 */
	EOperation getThreatType__ToString();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType#getThreatTypeAncestor() <em>Get Threat Type Ancestor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Threat Type Ancestor</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType#getThreatTypeAncestor()
	 * @generated
	 */
	EOperation getThreatType__GetThreatTypeAncestor();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate <em>Estimate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Estimate</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate
	 * @generated
	 */
	EClass getEstimate();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getMinimum()
	 * @see #getEstimate()
	 * @generated
	 */
	EAttribute getEstimate_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getProbable <em>Probable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probable</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getProbable()
	 * @see #getEstimate()
	 * @generated
	 */
	EAttribute getEstimate_Probable();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getMaximum()
	 * @see #getEstimate()
	 * @generated
	 */
	EAttribute getEstimate_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getConfidence <em>Confidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Confidence</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getConfidence()
	 * @see #getEstimate()
	 * @generated
	 */
	EAttribute getEstimate_Confidence();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getName()
	 * @see #getEstimate()
	 * @generated
	 */
	EAttribute getEstimate_Name();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getEstimateName() <em>Get Estimate Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Estimate Name</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate#getEstimateName()
	 * @generated
	 */
	EOperation getEstimate__GetEstimateName();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Threat Type To Estimate Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Type To Estimate Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType"
	 *        valueType="be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate"
	 * @generated
	 */
	EClass getThreatTypeToEstimateMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getThreatTypeToEstimateMap()
	 * @generated
	 */
	EReference getThreatTypeToEstimateMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getThreatTypeToEstimateMap()
	 * @generated
	 */
	EReference getThreatTypeToEstimateMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To EString Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To EString Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getEStringToEStringMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEStringMap()
	 * @generated
	 */
	EAttribute getEStringToEStringMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEStringMap()
	 * @generated
	 */
	EAttribute getEStringToEStringMap_Value();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement
	 * @generated
	 */
	EClass getModelElement();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement#getName()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement#getDescription()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement#getAnnotations()
	 * @see #getModelElement()
	 * @generated
	 */
	EReference getModelElement_Annotations();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement#getId()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Id();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeThreatType <em>Or Composite Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Composite Threat Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeThreatType
	 * @generated
	 */
	EClass getOrCompositeThreatType();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeThreatType <em>And Composite Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Composite Threat Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeThreatType
	 * @generated
	 */
	EClass getAndCompositeThreatType();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeGroup <em>Threat Type Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Type Group</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeGroup
	 * @generated
	 */
	EClass getThreatTypeGroup();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition <em>Abstract Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition
	 * @generated
	 */
	EClass getAbstractCondition();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition#getTitle()
	 * @see #getAbstractCondition()
	 * @generated
	 */
	EAttribute getAbstractCondition_Title();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition#getAdditionalInfo <em>Additional Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Additional Info</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition#getAdditionalInfo()
	 * @see #getAbstractCondition()
	 * @generated
	 */
	EAttribute getAbstractCondition_AdditionalInfo();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition#getComments()
	 * @see #getAbstractCondition()
	 * @generated
	 */
	EAttribute getAbstractCondition_Comments();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeCondition <em>Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeCondition
	 * @generated
	 */
	EClass getCompositeCondition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeCondition <em>And Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Composite Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeCondition
	 * @generated
	 */
	EClass getAndCompositeCondition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeCondition <em>Or Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Composite Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeCondition
	 * @generated
	 */
	EClass getOrCompositeCondition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.NotCompositeCondition <em>Not Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Composite Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.NotCompositeCondition
	 * @generated
	 */
	EClass getNotCompositeCondition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition <em>Single Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Composite Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition
	 * @generated
	 */
	EClass getSingleCompositeCondition();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition#getSubcondition <em>Subcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subcondition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition#getSubcondition()
	 * @see #getSingleCompositeCondition()
	 * @generated
	 */
	EReference getSingleCompositeCondition_Subcondition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.MultipleCompositeCondition <em>Multiple Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple Composite Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.MultipleCompositeCondition
	 * @generated
	 */
	EClass getMultipleCompositeCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.MultipleCompositeCondition#getSubcondition <em>Subcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subcondition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.MultipleCompositeCondition#getSubcondition()
	 * @see #getMultipleCompositeCondition()
	 * @generated
	 */
	EReference getMultipleCompositeCondition_Subcondition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList <em>Condition List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition List</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList
	 * @generated
	 */
	EClass getConditionList();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList#getAbstractcondition <em>Abstractcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abstractcondition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList#getAbstractcondition()
	 * @see #getConditionList()
	 * @generated
	 */
	EReference getConditionList_Abstractcondition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AImportedCondition <em>AImported Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AImported Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AImportedCondition
	 * @generated
	 */
	EClass getAImportedCondition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition <em>Imported Threat Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imported Threat Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition
	 * @generated
	 */
	EClass getImportedThreatCondition();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition#getThreattype <em>Threattype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Threattype</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition#getThreattype()
	 * @see #getImportedThreatCondition()
	 * @generated
	 */
	EReference getImportedThreatCondition_Threattype();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedCondition <em>Imported Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imported Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedCondition
	 * @generated
	 */
	EClass getImportedCondition();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedCondition#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedCondition#getCondition()
	 * @see #getImportedCondition()
	 * @generated
	 */
	EReference getImportedCondition_Condition();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation <em>DFD Element Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Element Annotation</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation
	 * @generated
	 */
	EClass getDFDElementAnnotation();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation#getDfdelement <em>Dfdelement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dfdelement</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation#getDfdelement()
	 * @see #getDFDElementAnnotation()
	 * @generated
	 */
	EReference getDFDElementAnnotation_Dfdelement();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel <em>Attacker Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attacker Model</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel
	 * @generated
	 */
	EClass getAttackerModel();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel#getAttackerProfiles <em>Attacker Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attacker Profiles</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel#getAttackerProfiles()
	 * @see #getAttackerModel()
	 * @generated
	 */
	EReference getAttackerModel_AttackerProfiles();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile <em>Attacker Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attacker Profile</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile
	 * @generated
	 */
	EClass getAttackerProfile();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getThreatCapability <em>Threat Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Threat Capability</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getThreatCapability()
	 * @see #getAttackerProfile()
	 * @generated
	 */
	EReference getAttackerProfile_ThreatCapability();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getProbabilityOfAction <em>Probability Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Probability Of Action</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getProbabilityOfAction()
	 * @see #getAttackerProfile()
	 * @generated
	 */
	EReference getAttackerProfile_ProbabilityOfAction();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getContactFrequency <em>Contact Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contact Frequency</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getContactFrequency()
	 * @see #getAttackerProfile()
	 * @generated
	 */
	EReference getAttackerProfile_ContactFrequency();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getInsider <em>Insider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Insider</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#getInsider()
	 * @see #getAttackerProfile()
	 * @generated
	 */
	EReference getAttackerProfile_Insider();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile#isEnabled()
	 * @see #getAttackerProfile()
	 * @generated
	 */
	EAttribute getAttackerProfile_Enabled();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic <em>ICharacteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ICharacteristic</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic
	 * @generated
	 */
	EClass getICharacteristic();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Model</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataModel
	 * @generated
	 */
	EClass getDataModel();

	/**
	 * Returns the meta object for the containment reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataModel#getDataModelElements <em>Data Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Model Elements</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataModel#getDataModelElements()
	 * @see #getDataModel()
	 * @generated
	 */
	EReference getDataModel_DataModelElements();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataType#isSensitive <em>Sensitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sensitive</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataType#isSensitive()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Sensitive();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData <em>Transformed Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformed Data</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData
	 * @generated
	 */
	EClass getTransformedData();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getDecKey <em>Dec Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dec Key</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getDecKey()
	 * @see #getTransformedData()
	 * @generated
	 */
	EReference getTransformedData_DecKey();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getEncKey <em>Enc Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enc Key</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getEncKey()
	 * @see #getTransformedData()
	 * @generated
	 */
	EReference getTransformedData_EncKey();

	/**
	 * Returns the meta object for the reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Datatype</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData#getDatatype()
	 * @see #getTransformedData()
	 * @generated
	 */
	EReference getTransformedData_Datatype();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement <em>Data Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Model Element</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement
	 * @generated
	 */
	EClass getDataModelElement();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType <em>Data Subject Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Subject Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType
	 * @generated
	 */
	EClass getDataSubjectType();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getPersonaldatatype <em>Personaldatatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Personaldatatype</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getPersonaldatatype()
	 * @see #getDataSubjectType()
	 * @generated
	 */
	EReference getDataSubjectType_Personaldatatype();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getSensitivity <em>Sensitivity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sensitivity</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getSensitivity()
	 * @see #getDataSubjectType()
	 * @generated
	 */
	EReference getDataSubjectType_Sensitivity();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getNbrOfSubjects <em>Nbr Of Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Nbr Of Subjects</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType#getNbrOfSubjects()
	 * @see #getDataSubjectType()
	 * @generated
	 */
	EReference getDataSubjectType_NbrOfSubjects();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType <em>Personal Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Personal Data Type</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType
	 * @generated
	 */
	EClass getPersonalDataType();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getSensitivity <em>Sensitivity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sensitivity</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getSensitivity()
	 * @see #getPersonalDataType()
	 * @generated
	 */
	EReference getPersonalDataType_Sensitivity();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getNbrOfRecords <em>Nbr Of Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Nbr Of Records</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getNbrOfRecords()
	 * @see #getPersonalDataType()
	 * @generated
	 */
	EReference getPersonalDataType_NbrOfRecords();

	/**
	 * Returns the meta object for the containment reference '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getRetention <em>Retention</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Retention</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType#getRetention()
	 * @see #getPersonalDataType()
	 * @generated
	 */
	EReference getPersonalDataType_Retention();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSet <em>Data Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Set</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataSet
	 * @generated
	 */
	EClass getDataSet();

	/**
	 * Returns the meta object for the reference list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSet#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Datatype</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataSet#getDatatype()
	 * @see #getDataSet()
	 * @generated
	 */
	EReference getDataSet_Datatype();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation <em>IModel Element Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IModel Element Annotation</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation
	 * @generated
	 */
	EClass getIModelElementAnnotation();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation#getAnnotation() <em>Get Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Annotation</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation#getAnnotation()
	 * @generated
	 */
	EOperation getIModelElementAnnotation__GetAnnotation();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation <em>KV Model Element Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KV Model Element Annotation</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation
	 * @generated
	 */
	EClass getKVModelElementAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation#getKey()
	 * @see #getKVModelElementAnnotation()
	 * @generated
	 */
	EAttribute getKVModelElementAnnotation_Key();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation#getValue()
	 * @see #getKVModelElementAnnotation()
	 * @generated
	 */
	EAttribute getKVModelElementAnnotation_Value();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation#getAnnotation() <em>Get Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Annotation</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation#getAnnotation()
	 * @generated
	 */
	EOperation getKVModelElementAnnotation__GetAnnotation();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation <em>Model Element Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Annotation</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation
	 * @generated
	 */
	EClass getModelElementAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation#getValue()
	 * @see #getModelElementAnnotation()
	 * @generated
	 */
	EAttribute getModelElementAnnotation_Value();

	/**
	 * Returns the meta object for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation#getAnnotation() <em>Get Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Annotation</em>' operation.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation#getAnnotation()
	 * @generated
	 */
	EOperation getModelElementAnnotation__GetAnnotation();

	/**
	 * Returns the meta object for class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern <em>Threat Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Pattern</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern
	 * @generated
	 */
	EClass getThreatPattern();

	/**
	 * Returns the meta object for the attribute list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern#getLongDescription <em>Long Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Long Description</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern#getLongDescription()
	 * @see #getThreatPattern()
	 * @generated
	 */
	EAttribute getThreatPattern_LongDescription();

	/**
	 * Returns the meta object for the attribute list '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Patterns</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern#getPatterns()
	 * @see #getThreatPattern()
	 * @generated
	 */
	EAttribute getThreatPattern_Patterns();

	/**
	 * Returns the meta object for the map '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Mapping</em>'.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern#getMapping()
	 * @see #getThreatPattern()
	 * @generated
	 */
	EReference getThreatPattern_Mapping();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Threat Type ID To Estimate Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Type ID To Estimate Map</em>'.
	 * @see java.util.Map.Entry
	 * @model features="value key" 
	 *        valueType="be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate"
	 *        keyDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getThreatTypeIDToEstimateMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getThreatTypeIDToEstimateMap()
	 * @generated
	 */
	EReference getThreatTypeIDToEstimateMap_Value();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getThreatTypeIDToEstimateMap()
	 * @generated
	 */
	EAttribute getThreatTypeIDToEstimateMap_Key();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpartaModelFactory getSpartaModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowImpl <em>Data Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataFlow()
		 * @generated
		 */
		EClass DATA_FLOW = eINSTANCE.getDataFlow();

		/**
		 * The meta object literal for the '<em><b>Get Data Flow</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_FLOW___GET_DATA_FLOW = eINSTANCE.getDataFlow__GetDataFlow();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowEntityImpl <em>Data Flow Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataFlowEntityImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataFlowEntity()
		 * @generated
		 */
		EClass DATA_FLOW_ENTITY = eINSTANCE.getDataFlowEntity();

		/**
		 * The meta object literal for the '<em><b>Send</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_ENTITY__SEND = eINSTANCE.getDataFlowEntity_Send();

		/**
		 * The meta object literal for the '<em><b>Receive</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_ENTITY__RECEIVE = eINSTANCE.getDataFlowEntity_Receive();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ExternalEntityImpl <em>External Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ExternalEntityImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getExternalEntity()
		 * @generated
		 */
		EClass EXTERNAL_ENTITY = eINSTANCE.getExternalEntity();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ProcessImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataStoreImpl <em>Data Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataStoreImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataStore()
		 * @generated
		 */
		EClass DATA_STORE = eINSTANCE.getDataStore();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDModelImpl <em>DFD Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDModelImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDModel()
		 * @generated
		 */
		EClass DFD_MODEL = eINSTANCE.getDFDModel();

		/**
		 * The meta object literal for the '<em><b>Contained Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_MODEL__CONTAINED_ELEMENTS = eINSTANCE.getDFDModel_ContainedElements();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_MODEL__RESOURCE = eINSTANCE.getDFDModel_Resource();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDElementImpl <em>DFD Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDElementImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDElement()
		 * @generated
		 */
		EClass DFD_ELEMENT = eINSTANCE.getDFDElement();

		/**
		 * The meta object literal for the '<em><b>Securityannotation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_ELEMENT__SECURITYANNOTATION = eINSTANCE.getDFDElement_Securityannotation();

		/**
		 * The meta object literal for the '<em><b>Dfdelementannotation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_ELEMENT__DFDELEMENTANNOTATION = eINSTANCE.getDFDElement_Dfdelementannotation();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SecurityElementImpl <em>Security Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SecurityElementImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSecurityElement()
		 * @generated
		 */
		EClass SECURITY_ELEMENT = eINSTANCE.getSecurityElement();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDBoundaryElementImpl <em>DFD Boundary Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDBoundaryElementImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDBoundaryElement()
		 * @generated
		 */
		EClass DFD_BOUNDARY_ELEMENT = eINSTANCE.getDFDBoundaryElement();

		/**
		 * The meta object literal for the '<em><b>Crossing Flows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_BOUNDARY_ELEMENT__CROSSING_FLOWS = eINSTANCE.getDFDBoundaryElement_CrossingFlows();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TrustBoundaryContainerImpl <em>Trust Boundary Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TrustBoundaryContainerImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getTrustBoundaryContainer()
		 * @generated
		 */
		EClass TRUST_BOUNDARY_CONTAINER = eINSTANCE.getTrustBoundaryContainer();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable <em>Sender Specifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSenderSpecifiable()
		 * @generated
		 */
		EClass SENDER_SPECIFIABLE = eINSTANCE.getSenderSpecifiable();

		/**
		 * The meta object literal for the '<em><b>Sender Specified By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENDER_SPECIFIABLE__SENDER_SPECIFIED_BY = eINSTANCE.getSenderSpecifiable_SenderSpecifiedBy();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENDER_SPECIFIABLE__SENDER = eINSTANCE.getSenderSpecifiable_Sender();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable <em>Recipient Specifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getRecipientSpecifiable()
		 * @generated
		 */
		EClass RECIPIENT_SPECIFIABLE = eINSTANCE.getRecipientSpecifiable();

		/**
		 * The meta object literal for the '<em><b>Recipient Specified By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECIPIENT_SPECIFIABLE__RECIPIENT_SPECIFIED_BY = eINSTANCE.getRecipientSpecifiable_RecipientSpecifiedBy();

		/**
		 * The meta object literal for the '<em><b>Recipient</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECIPIENT_SPECIFIABLE__RECIPIENT = eINSTANCE.getRecipientSpecifiable_Recipient();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SenderSpecificationImpl <em>Sender Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SenderSpecificationImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSenderSpecification()
		 * @generated
		 */
		EClass SENDER_SPECIFICATION = eINSTANCE.getSenderSpecification();

		/**
		 * The meta object literal for the '<em><b>Specifies Sender Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENDER_SPECIFICATION__SPECIFIES_SENDER_OF = eINSTANCE.getSenderSpecification_SpecifiesSenderOf();

		/**
		 * The meta object literal for the '<em><b>Get Data Flow</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SENDER_SPECIFICATION___GET_DATA_FLOW = eINSTANCE.getSenderSpecification__GetDataFlow();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RecipientSpecificationImpl <em>Recipient Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RecipientSpecificationImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getRecipientSpecification()
		 * @generated
		 */
		EClass RECIPIENT_SPECIFICATION = eINSTANCE.getRecipientSpecification();

		/**
		 * The meta object literal for the '<em><b>Specifies Recipient Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF = eINSTANCE.getRecipientSpecification_SpecifiesRecipientOf();

		/**
		 * The meta object literal for the '<em><b>Get Data Flow</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RECIPIENT_SPECIFICATION___GET_DATA_FLOW = eINSTANCE.getRecipientSpecification__GetDataFlow();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.FlowElementImpl <em>Flow Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.FlowElementImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getFlowElement()
		 * @generated
		 */
		EClass FLOW_ELEMENT = eINSTANCE.getFlowElement();

		/**
		 * The meta object literal for the '<em><b>Get Data Flow</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FLOW_ELEMENT___GET_DATA_FLOW = eINSTANCE.getFlowElement__GetDataFlow();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDContainerImpl <em>DFD Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DFDContainerImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDContainer()
		 * @generated
		 */
		EClass DFD_CONTAINER = eINSTANCE.getDFDContainer();

		/**
		 * The meta object literal for the '<em><b>Contained Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_CONTAINER__CONTAINED_ELEMENTS = eINSTANCE.getDFDContainer_ContainedElements();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SecurityAnnotationImpl <em>Security Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SecurityAnnotationImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSecurityAnnotation()
		 * @generated
		 */
		EClass SECURITY_ANNOTATION = eINSTANCE.getSecurityAnnotation();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionTypeImpl <em>Solution Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionTypeImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSolutionType()
		 * @generated
		 */
		EClass SOLUTION_TYPE = eINSTANCE.getSolutionType();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION_TYPE__ROLES = eINSTANCE.getSolutionType_Roles();

		/**
		 * The meta object literal for the '<em><b>Countermeasure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION_TYPE__COUNTERMEASURE = eINSTANCE.getSolutionType_Countermeasure();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Subjected</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__SUBJECTED = eINSTANCE.getRole_Subjected();

		/**
		 * The meta object literal for the '<em><b>Binding Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__BINDING_TYPES = eINSTANCE.getRole_BindingTypes();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl <em>Abstract Threat Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractThreatTypeImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAbstractThreatType()
		 * @generated
		 */
		EClass ABSTRACT_THREAT_TYPE = eINSTANCE.getAbstractThreatType();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_THREAT_TYPE__ENABLED = eINSTANCE.getAbstractThreatType_Enabled();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_THREAT_TYPE__PATTERNS = eINSTANCE.getAbstractThreatType_Patterns();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_THREAT_TYPE__TITLE = eINSTANCE.getAbstractThreatType_Title();

		/**
		 * The meta object literal for the '<em><b>Additional Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO = eINSTANCE.getAbstractThreatType_AdditionalInfo();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_THREAT_TYPE__COMMENTS = eINSTANCE.getAbstractThreatType_Comments();

		/**
		 * The meta object literal for the '<em><b>Characteristic</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_THREAT_TYPE__CHARACTERISTIC = eINSTANCE.getAbstractThreatType_Characteristic();

		/**
		 * The meta object literal for the '<em><b>Super Threat Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE = eINSTANCE.getAbstractThreatType_SuperThreatType();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl <em>Counter Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CounterMeasureImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getCounterMeasure()
		 * @generated
		 */
		EClass COUNTER_MEASURE = eINSTANCE.getCounterMeasure();

		/**
		 * The meta object literal for the '<em><b>Mitigates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTER_MEASURE__MITIGATES = eINSTANCE.getCounterMeasure_Mitigates();

		/**
		 * The meta object literal for the '<em><b>Securitysubobjective</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTER_MEASURE__SECURITYSUBOBJECTIVE = eINSTANCE.getCounterMeasure_Securitysubobjective();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTER_MEASURE__SCOPE = eINSTANCE.getCounterMeasure_Scope();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTER_MEASURE__SUBJECT = eINSTANCE.getCounterMeasure_Subject();

		/**
		 * The meta object literal for the '<em><b>Difficulty</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTER_MEASURE__DIFFICULTY = eINSTANCE.getCounterMeasure_Difficulty();

		/**
		 * The meta object literal for the '<em><b>Mitigated Threat Type ID</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNTER_MEASURE__MITIGATED_THREAT_TYPE_ID = eINSTANCE.getCounterMeasure_MitigatedThreatTypeID();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleBindingImpl <em>Role Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.RoleBindingImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getRoleBinding()
		 * @generated
		 */
		EClass ROLE_BINDING = eINSTANCE.getRoleBinding();

		/**
		 * The meta object literal for the '<em><b>Binds</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_BINDING__BINDS = eINSTANCE.getRoleBinding_Binds();

		/**
		 * The meta object literal for the '<em><b>Binds To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_BINDING__BINDS_TO = eINSTANCE.getRoleBinding_BindsTo();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionImpl <em>Solution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSolution()
		 * @generated
		 */
		EClass SOLUTION = eINSTANCE.getSolution();

		/**
		 * The meta object literal for the '<em><b>Securitypattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__SECURITYPATTERN = eINSTANCE.getSolution_Securitypattern();

		/**
		 * The meta object literal for the '<em><b>Rolebinding</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__ROLEBINDING = eINSTANCE.getSolution_Rolebinding();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaResourceImpl <em>Sparta Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaResourceImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSpartaResource()
		 * @generated
		 */
		EClass SPARTA_RESOURCE = eINSTANCE.getSpartaResource();

		/**
		 * The meta object literal for the '<em><b>Securityannotation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPARTA_RESOURCE__SECURITYANNOTATION = eINSTANCE.getSpartaResource_Securityannotation();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl <em>Threat Type Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeCatalogImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatTypeCatalog()
		 * @generated
		 */
		EClass THREAT_TYPE_CATALOG = eINSTANCE.getThreatTypeCatalog();

		/**
		 * The meta object literal for the '<em><b>Threat</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE_CATALOG__THREAT = eINSTANCE.getThreatTypeCatalog_Threat();

		/**
		 * The meta object literal for the '<em><b>Threattypegroup</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE_CATALOG__THREATTYPEGROUP = eINSTANCE.getThreatTypeCatalog_Threattypegroup();

		/**
		 * The meta object literal for the '<em><b>Conditionlist</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE_CATALOG__CONDITIONLIST = eINSTANCE.getThreatTypeCatalog_Conditionlist();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_TYPE_CATALOG__IMPORTS = eINSTANCE.getThreatTypeCatalog_Imports();

		/**
		 * The meta object literal for the '<em><b>Helper Patterns</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_TYPE_CATALOG__HELPER_PATTERNS = eINSTANCE.getThreatTypeCatalog_HelperPatterns();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_TYPE_CATALOG__PACKAGE = eINSTANCE.getThreatTypeCatalog_Package();

		/**
		 * The meta object literal for the '<em><b>Pattern Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE_CATALOG__PATTERN_DEPENDENCIES = eINSTANCE.getThreatTypeCatalog_PatternDependencies();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionTypeCatalogImpl <em>Solution Type Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SolutionTypeCatalogImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSolutionTypeCatalog()
		 * @generated
		 */
		EClass SOLUTION_TYPE_CATALOG = eINSTANCE.getSolutionTypeCatalog();

		/**
		 * The meta object literal for the '<em><b>Solution Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION_TYPE_CATALOG__SOLUTION_TYPES = eINSTANCE.getSolutionTypeCatalog_SolutionTypes();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EStringToEBooleanMapImpl <em>EString To EBoolean Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EStringToEBooleanMapImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getEStringToEBooleanMap()
		 * @generated
		 */
		EClass ESTRING_TO_EBOOLEAN_MAP = eINSTANCE.getEStringToEBooleanMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_EBOOLEAN_MAP__KEY = eINSTANCE.getEStringToEBooleanMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_EBOOLEAN_MAP__VALUE = eINSTANCE.getEStringToEBooleanMap_Value();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatSpecificationImpl <em>Threat Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatSpecificationImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatSpecification()
		 * @generated
		 */
		EClass THREAT_SPECIFICATION = eINSTANCE.getThreatSpecification();

		/**
		 * The meta object literal for the '<em><b>Threat</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_SPECIFICATION__THREAT = eINSTANCE.getThreatSpecification_Threat();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_SPECIFICATION__ENABLED = eINSTANCE.getThreatSpecification_Enabled();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_SPECIFICATION__TYPES = eINSTANCE.getThreatSpecification_Types();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_SPECIFICATION__PATTERNS = eINSTANCE.getThreatSpecification_Patterns();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatSpecificationCatalogImpl <em>Threat Specification Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatSpecificationCatalogImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatSpecificationCatalog()
		 * @generated
		 */
		EClass THREAT_SPECIFICATION_CATALOG = eINSTANCE.getThreatSpecificationCatalog();

		/**
		 * The meta object literal for the '<em><b>Threatspecifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_SPECIFICATION_CATALOG__THREATSPECIFICATIONS = eINSTANCE.getThreatSpecificationCatalog_Threatspecifications();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AssetImpl <em>Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AssetImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAsset()
		 * @generated
		 */
		EClass ASSET = eINSTANCE.getAsset();

		/**
		 * The meta object literal for the '<em><b>Loss Magnitude</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSET__LOSS_MAGNITUDE = eINSTANCE.getAsset_LossMagnitude();

		/**
		 * The meta object literal for the '<em><b>Estimates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSET__ESTIMATES = eINSTANCE.getAsset_Estimates();

		/**
		 * The meta object literal for the '<em><b>Bound</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSET__BOUND = eINSTANCE.getAsset_Bound();

		/**
		 * The meta object literal for the '<em><b>Loss Magnitude By ID</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSET__LOSS_MAGNITUDE_BY_ID = eINSTANCE.getAsset_LossMagnitudeByID();

		/**
		 * The meta object literal for the '<em><b>Get Estimate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASSET___GET_ESTIMATE__ABSTRACTTHREATTYPE = eINSTANCE.getAsset__GetEstimate__AbstractThreatType();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CompositeThreatTypeImpl <em>Composite Threat Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CompositeThreatTypeImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getCompositeThreatType()
		 * @generated
		 */
		EClass COMPOSITE_THREAT_TYPE = eINSTANCE.getCompositeThreatType();

		/**
		 * The meta object literal for the '<em><b>Sub Threat Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES = eINSTANCE.getCompositeThreatType_SubThreatTypes();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeImpl <em>Threat Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatType()
		 * @generated
		 */
		EClass THREAT_TYPE = eINSTANCE.getThreatType();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE__CONDITION = eINSTANCE.getThreatType_Condition();

		/**
		 * The meta object literal for the '<em><b>Threatpattern</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE__THREATPATTERN = eINSTANCE.getThreatType_Threatpattern();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THREAT_TYPE___TO_STRING = eINSTANCE.getThreatType__ToString();

		/**
		 * The meta object literal for the '<em><b>Get Threat Type Ancestor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THREAT_TYPE___GET_THREAT_TYPE_ANCESTOR = eINSTANCE.getThreatType__GetThreatTypeAncestor();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EstimateImpl <em>Estimate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EstimateImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getEstimate()
		 * @generated
		 */
		EClass ESTIMATE = eINSTANCE.getEstimate();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTIMATE__MINIMUM = eINSTANCE.getEstimate_Minimum();

		/**
		 * The meta object literal for the '<em><b>Probable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTIMATE__PROBABLE = eINSTANCE.getEstimate_Probable();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTIMATE__MAXIMUM = eINSTANCE.getEstimate_Maximum();

		/**
		 * The meta object literal for the '<em><b>Confidence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTIMATE__CONFIDENCE = eINSTANCE.getEstimate_Confidence();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTIMATE__NAME = eINSTANCE.getEstimate_Name();

		/**
		 * The meta object literal for the '<em><b>Get Estimate Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ESTIMATE___GET_ESTIMATE_NAME = eINSTANCE.getEstimate__GetEstimateName();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeToEstimateMapImpl <em>Threat Type To Estimate Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeToEstimateMapImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatTypeToEstimateMap()
		 * @generated
		 */
		EClass THREAT_TYPE_TO_ESTIMATE_MAP = eINSTANCE.getThreatTypeToEstimateMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE_TO_ESTIMATE_MAP__KEY = eINSTANCE.getThreatTypeToEstimateMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE_TO_ESTIMATE_MAP__VALUE = eINSTANCE.getThreatTypeToEstimateMap_Value();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EStringToEStringMapImpl <em>EString To EString Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.EStringToEStringMapImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getEStringToEStringMap()
		 * @generated
		 */
		EClass ESTRING_TO_ESTRING_MAP = eINSTANCE.getEStringToEStringMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_ESTRING_MAP__KEY = eINSTANCE.getEStringToEStringMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_ESTRING_MAP__VALUE = eINSTANCE.getEStringToEStringMap_Value();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ModelElementImpl <em>Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ModelElementImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getModelElement()
		 * @generated
		 */
		EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__NAME = eINSTANCE.getModelElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__DESCRIPTION = eINSTANCE.getModelElement_Description();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT__ANNOTATIONS = eINSTANCE.getModelElement_Annotations();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__ID = eINSTANCE.getModelElement_Id();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.OrCompositeThreatTypeImpl <em>Or Composite Threat Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.OrCompositeThreatTypeImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getOrCompositeThreatType()
		 * @generated
		 */
		EClass OR_COMPOSITE_THREAT_TYPE = eINSTANCE.getOrCompositeThreatType();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AndCompositeThreatTypeImpl <em>And Composite Threat Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AndCompositeThreatTypeImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAndCompositeThreatType()
		 * @generated
		 */
		EClass AND_COMPOSITE_THREAT_TYPE = eINSTANCE.getAndCompositeThreatType();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeGroupImpl <em>Threat Type Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeGroupImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatTypeGroup()
		 * @generated
		 */
		EClass THREAT_TYPE_GROUP = eINSTANCE.getThreatTypeGroup();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractConditionImpl <em>Abstract Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AbstractConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAbstractCondition()
		 * @generated
		 */
		EClass ABSTRACT_CONDITION = eINSTANCE.getAbstractCondition();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_CONDITION__TITLE = eINSTANCE.getAbstractCondition_Title();

		/**
		 * The meta object literal for the '<em><b>Additional Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_CONDITION__ADDITIONAL_INFO = eINSTANCE.getAbstractCondition_AdditionalInfo();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_CONDITION__COMMENTS = eINSTANCE.getAbstractCondition_Comments();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CompositeConditionImpl <em>Composite Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.CompositeConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getCompositeCondition()
		 * @generated
		 */
		EClass COMPOSITE_CONDITION = eINSTANCE.getCompositeCondition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AndCompositeConditionImpl <em>And Composite Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AndCompositeConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAndCompositeCondition()
		 * @generated
		 */
		EClass AND_COMPOSITE_CONDITION = eINSTANCE.getAndCompositeCondition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.OrCompositeConditionImpl <em>Or Composite Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.OrCompositeConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getOrCompositeCondition()
		 * @generated
		 */
		EClass OR_COMPOSITE_CONDITION = eINSTANCE.getOrCompositeCondition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.NotCompositeConditionImpl <em>Not Composite Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.NotCompositeConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getNotCompositeCondition()
		 * @generated
		 */
		EClass NOT_COMPOSITE_CONDITION = eINSTANCE.getNotCompositeCondition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SingleCompositeConditionImpl <em>Single Composite Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SingleCompositeConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getSingleCompositeCondition()
		 * @generated
		 */
		EClass SINGLE_COMPOSITE_CONDITION = eINSTANCE.getSingleCompositeCondition();

		/**
		 * The meta object literal for the '<em><b>Subcondition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_COMPOSITE_CONDITION__SUBCONDITION = eINSTANCE.getSingleCompositeCondition_Subcondition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.MultipleCompositeConditionImpl <em>Multiple Composite Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.MultipleCompositeConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getMultipleCompositeCondition()
		 * @generated
		 */
		EClass MULTIPLE_COMPOSITE_CONDITION = eINSTANCE.getMultipleCompositeCondition();

		/**
		 * The meta object literal for the '<em><b>Subcondition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLE_COMPOSITE_CONDITION__SUBCONDITION = eINSTANCE.getMultipleCompositeCondition_Subcondition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ConditionListImpl <em>Condition List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ConditionListImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getConditionList()
		 * @generated
		 */
		EClass CONDITION_LIST = eINSTANCE.getConditionList();

		/**
		 * The meta object literal for the '<em><b>Abstractcondition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_LIST__ABSTRACTCONDITION = eINSTANCE.getConditionList_Abstractcondition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AImportedConditionImpl <em>AImported Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AImportedConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAImportedCondition()
		 * @generated
		 */
		EClass AIMPORTED_CONDITION = eINSTANCE.getAImportedCondition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ImportedThreatConditionImpl <em>Imported Threat Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ImportedThreatConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getImportedThreatCondition()
		 * @generated
		 */
		EClass IMPORTED_THREAT_CONDITION = eINSTANCE.getImportedThreatCondition();

		/**
		 * The meta object literal for the '<em><b>Threattype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_THREAT_CONDITION__THREATTYPE = eINSTANCE.getImportedThreatCondition_Threattype();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ImportedConditionImpl <em>Imported Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ImportedConditionImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getImportedCondition()
		 * @generated
		 */
		EClass IMPORTED_CONDITION = eINSTANCE.getImportedCondition();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_CONDITION__CONDITION = eINSTANCE.getImportedCondition_Condition();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation <em>DFD Element Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDFDElementAnnotation()
		 * @generated
		 */
		EClass DFD_ELEMENT_ANNOTATION = eINSTANCE.getDFDElementAnnotation();

		/**
		 * The meta object literal for the '<em><b>Dfdelement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_ELEMENT_ANNOTATION__DFDELEMENT = eINSTANCE.getDFDElementAnnotation_Dfdelement();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerModelImpl <em>Attacker Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerModelImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAttackerModel()
		 * @generated
		 */
		EClass ATTACKER_MODEL = eINSTANCE.getAttackerModel();

		/**
		 * The meta object literal for the '<em><b>Attacker Profiles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACKER_MODEL__ATTACKER_PROFILES = eINSTANCE.getAttackerModel_AttackerProfiles();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl <em>Attacker Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.AttackerProfileImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getAttackerProfile()
		 * @generated
		 */
		EClass ATTACKER_PROFILE = eINSTANCE.getAttackerProfile();

		/**
		 * The meta object literal for the '<em><b>Threat Capability</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACKER_PROFILE__THREAT_CAPABILITY = eINSTANCE.getAttackerProfile_ThreatCapability();

		/**
		 * The meta object literal for the '<em><b>Probability Of Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACKER_PROFILE__PROBABILITY_OF_ACTION = eINSTANCE.getAttackerProfile_ProbabilityOfAction();

		/**
		 * The meta object literal for the '<em><b>Contact Frequency</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACKER_PROFILE__CONTACT_FREQUENCY = eINSTANCE.getAttackerProfile_ContactFrequency();

		/**
		 * The meta object literal for the '<em><b>Insider</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACKER_PROFILE__INSIDER = eINSTANCE.getAttackerProfile_Insider();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACKER_PROFILE__ENABLED = eINSTANCE.getAttackerProfile_Enabled();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic <em>ICharacteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getICharacteristic()
		 * @generated
		 */
		EClass ICHARACTERISTIC = eINSTANCE.getICharacteristic();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataModelImpl <em>Data Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataModelImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataModel()
		 * @generated
		 */
		EClass DATA_MODEL = eINSTANCE.getDataModel();

		/**
		 * The meta object literal for the '<em><b>Data Model Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MODEL__DATA_MODEL_ELEMENTS = eINSTANCE.getDataModel_DataModelElements();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataTypeImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Sensitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__SENSITIVE = eINSTANCE.getDataType_Sensitive();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TransformedDataImpl <em>Transformed Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.TransformedDataImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getTransformedData()
		 * @generated
		 */
		EClass TRANSFORMED_DATA = eINSTANCE.getTransformedData();

		/**
		 * The meta object literal for the '<em><b>Dec Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMED_DATA__DEC_KEY = eINSTANCE.getTransformedData_DecKey();

		/**
		 * The meta object literal for the '<em><b>Enc Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMED_DATA__ENC_KEY = eINSTANCE.getTransformedData_EncKey();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMED_DATA__DATATYPE = eINSTANCE.getTransformedData_Datatype();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement <em>Data Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataModelElement()
		 * @generated
		 */
		EClass DATA_MODEL_ELEMENT = eINSTANCE.getDataModelElement();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSubjectTypeImpl <em>Data Subject Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSubjectTypeImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataSubjectType()
		 * @generated
		 */
		EClass DATA_SUBJECT_TYPE = eINSTANCE.getDataSubjectType();

		/**
		 * The meta object literal for the '<em><b>Personaldatatype</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SUBJECT_TYPE__PERSONALDATATYPE = eINSTANCE.getDataSubjectType_Personaldatatype();

		/**
		 * The meta object literal for the '<em><b>Sensitivity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SUBJECT_TYPE__SENSITIVITY = eINSTANCE.getDataSubjectType_Sensitivity();

		/**
		 * The meta object literal for the '<em><b>Nbr Of Subjects</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS = eINSTANCE.getDataSubjectType_NbrOfSubjects();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.PersonalDataTypeImpl <em>Personal Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.PersonalDataTypeImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getPersonalDataType()
		 * @generated
		 */
		EClass PERSONAL_DATA_TYPE = eINSTANCE.getPersonalDataType();

		/**
		 * The meta object literal for the '<em><b>Sensitivity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONAL_DATA_TYPE__SENSITIVITY = eINSTANCE.getPersonalDataType_Sensitivity();

		/**
		 * The meta object literal for the '<em><b>Nbr Of Records</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONAL_DATA_TYPE__NBR_OF_RECORDS = eINSTANCE.getPersonalDataType_NbrOfRecords();

		/**
		 * The meta object literal for the '<em><b>Retention</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONAL_DATA_TYPE__RETENTION = eINSTANCE.getPersonalDataType_Retention();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSetImpl <em>Data Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.DataSetImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getDataSet()
		 * @generated
		 */
		EClass DATA_SET = eINSTANCE.getDataSet();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SET__DATATYPE = eINSTANCE.getDataSet_Datatype();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation <em>IModel Element Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getIModelElementAnnotation()
		 * @generated
		 */
		EClass IMODEL_ELEMENT_ANNOTATION = eINSTANCE.getIModelElementAnnotation();

		/**
		 * The meta object literal for the '<em><b>Get Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IMODEL_ELEMENT_ANNOTATION___GET_ANNOTATION = eINSTANCE.getIModelElementAnnotation__GetAnnotation();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.KVModelElementAnnotationImpl <em>KV Model Element Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.KVModelElementAnnotationImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getKVModelElementAnnotation()
		 * @generated
		 */
		EClass KV_MODEL_ELEMENT_ANNOTATION = eINSTANCE.getKVModelElementAnnotation();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KV_MODEL_ELEMENT_ANNOTATION__KEY = eINSTANCE.getKVModelElementAnnotation_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KV_MODEL_ELEMENT_ANNOTATION__VALUE = eINSTANCE.getKVModelElementAnnotation_Value();

		/**
		 * The meta object literal for the '<em><b>Get Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KV_MODEL_ELEMENT_ANNOTATION___GET_ANNOTATION = eINSTANCE.getKVModelElementAnnotation__GetAnnotation();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ModelElementAnnotationImpl <em>Model Element Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ModelElementAnnotationImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getModelElementAnnotation()
		 * @generated
		 */
		EClass MODEL_ELEMENT_ANNOTATION = eINSTANCE.getModelElementAnnotation();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_ANNOTATION__VALUE = eINSTANCE.getModelElementAnnotation_Value();

		/**
		 * The meta object literal for the '<em><b>Get Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ANNOTATION___GET_ANNOTATION = eINSTANCE.getModelElementAnnotation__GetAnnotation();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatPatternImpl <em>Threat Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatPatternImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatPattern()
		 * @generated
		 */
		EClass THREAT_PATTERN = eINSTANCE.getThreatPattern();

		/**
		 * The meta object literal for the '<em><b>Long Description</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_PATTERN__LONG_DESCRIPTION = eINSTANCE.getThreatPattern_LongDescription();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_PATTERN__PATTERNS = eINSTANCE.getThreatPattern_Patterns();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_PATTERN__MAPPING = eINSTANCE.getThreatPattern_Mapping();

		/**
		 * The meta object literal for the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeIDToEstimateMapImpl <em>Threat Type ID To Estimate Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.ThreatTypeIDToEstimateMapImpl
		 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelPackageImpl#getThreatTypeIDToEstimateMap()
		 * @generated
		 */
		EClass THREAT_TYPE_ID_TO_ESTIMATE_MAP = eINSTANCE.getThreatTypeIDToEstimateMap();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE_ID_TO_ESTIMATE_MAP__VALUE = eINSTANCE.getThreatTypeIDToEstimateMap_Value();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_TYPE_ID_TO_ESTIMATE_MAP__KEY = eINSTANCE.getThreatTypeIDToEstimateMap_Key();

	}

} //SpartaModelPackage
