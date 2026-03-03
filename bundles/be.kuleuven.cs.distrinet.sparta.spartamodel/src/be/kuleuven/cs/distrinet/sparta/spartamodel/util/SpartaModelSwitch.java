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
package be.kuleuven.cs.distrinet.sparta.spartamodel.util;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AImportedCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Asset;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Condition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDBoundaryElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDContainer;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSet;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.FlowElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic;
import be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation;
import be.kuleuven.cs.distrinet.sparta.spartamodel.MultipleCompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.NotCompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaResource;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityAnnotation;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionTypeCatalog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeGroup;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage
 * @generated
 */
public class SpartaModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpartaModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpartaModelSwitch() {
		if (modelPackage == null) {
			modelPackage = SpartaModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SpartaModelPackage.DATA_FLOW: {
				DataFlow dataFlow = (DataFlow)theEObject;
				T result = caseDataFlow(dataFlow);
				if (result == null) result = caseSenderSpecifiable(dataFlow);
				if (result == null) result = caseRecipientSpecifiable(dataFlow);
				if (result == null) result = caseFlowElement(dataFlow);
				if (result == null) result = caseDFDElement(dataFlow);
				if (result == null) result = caseAsset(dataFlow);
				if (result == null) result = caseModelElement(dataFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DATA_FLOW_ENTITY: {
				DataFlowEntity dataFlowEntity = (DataFlowEntity)theEObject;
				T result = caseDataFlowEntity(dataFlowEntity);
				if (result == null) result = caseDFDContainer(dataFlowEntity);
				if (result == null) result = caseDFDElement(dataFlowEntity);
				if (result == null) result = caseAsset(dataFlowEntity);
				if (result == null) result = caseModelElement(dataFlowEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.EXTERNAL_ENTITY: {
				ExternalEntity externalEntity = (ExternalEntity)theEObject;
				T result = caseExternalEntity(externalEntity);
				if (result == null) result = caseDataFlowEntity(externalEntity);
				if (result == null) result = caseDFDContainer(externalEntity);
				if (result == null) result = caseDFDElement(externalEntity);
				if (result == null) result = caseAsset(externalEntity);
				if (result == null) result = caseModelElement(externalEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.PROCESS: {
				be.kuleuven.cs.distrinet.sparta.spartamodel.Process process = (be.kuleuven.cs.distrinet.sparta.spartamodel.Process)theEObject;
				T result = caseProcess(process);
				if (result == null) result = caseDataFlowEntity(process);
				if (result == null) result = caseDFDContainer(process);
				if (result == null) result = caseDFDElement(process);
				if (result == null) result = caseAsset(process);
				if (result == null) result = caseModelElement(process);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DATA_STORE: {
				DataStore dataStore = (DataStore)theEObject;
				T result = caseDataStore(dataStore);
				if (result == null) result = caseDataFlowEntity(dataStore);
				if (result == null) result = caseDFDContainer(dataStore);
				if (result == null) result = caseDFDElement(dataStore);
				if (result == null) result = caseAsset(dataStore);
				if (result == null) result = caseModelElement(dataStore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DFD_MODEL: {
				DFDModel dfdModel = (DFDModel)theEObject;
				T result = caseDFDModel(dfdModel);
				if (result == null) result = caseSpartaResource(dfdModel);
				if (result == null) result = caseModelElement(dfdModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DFD_ELEMENT: {
				DFDElement dfdElement = (DFDElement)theEObject;
				T result = caseDFDElement(dfdElement);
				if (result == null) result = caseAsset(dfdElement);
				if (result == null) result = caseModelElement(dfdElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.SECURITY_ELEMENT: {
				SecurityElement securityElement = (SecurityElement)theEObject;
				T result = caseSecurityElement(securityElement);
				if (result == null) result = caseModelElement(securityElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DFD_BOUNDARY_ELEMENT: {
				DFDBoundaryElement dfdBoundaryElement = (DFDBoundaryElement)theEObject;
				T result = caseDFDBoundaryElement(dfdBoundaryElement);
				if (result == null) result = caseDFDContainer(dfdBoundaryElement);
				if (result == null) result = caseDFDElement(dfdBoundaryElement);
				if (result == null) result = caseAsset(dfdBoundaryElement);
				if (result == null) result = caseModelElement(dfdBoundaryElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.TRUST_BOUNDARY_CONTAINER: {
				TrustBoundaryContainer trustBoundaryContainer = (TrustBoundaryContainer)theEObject;
				T result = caseTrustBoundaryContainer(trustBoundaryContainer);
				if (result == null) result = caseDFDBoundaryElement(trustBoundaryContainer);
				if (result == null) result = caseDFDContainer(trustBoundaryContainer);
				if (result == null) result = caseDFDElement(trustBoundaryContainer);
				if (result == null) result = caseAsset(trustBoundaryContainer);
				if (result == null) result = caseModelElement(trustBoundaryContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.SENDER_SPECIFIABLE: {
				SenderSpecifiable senderSpecifiable = (SenderSpecifiable)theEObject;
				T result = caseSenderSpecifiable(senderSpecifiable);
				if (result == null) result = caseFlowElement(senderSpecifiable);
				if (result == null) result = caseDFDElement(senderSpecifiable);
				if (result == null) result = caseAsset(senderSpecifiable);
				if (result == null) result = caseModelElement(senderSpecifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.RECIPIENT_SPECIFIABLE: {
				RecipientSpecifiable recipientSpecifiable = (RecipientSpecifiable)theEObject;
				T result = caseRecipientSpecifiable(recipientSpecifiable);
				if (result == null) result = caseFlowElement(recipientSpecifiable);
				if (result == null) result = caseDFDElement(recipientSpecifiable);
				if (result == null) result = caseAsset(recipientSpecifiable);
				if (result == null) result = caseModelElement(recipientSpecifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.SENDER_SPECIFICATION: {
				SenderSpecification senderSpecification = (SenderSpecification)theEObject;
				T result = caseSenderSpecification(senderSpecification);
				if (result == null) result = caseSenderSpecifiable(senderSpecification);
				if (result == null) result = caseFlowElement(senderSpecification);
				if (result == null) result = caseDFDElement(senderSpecification);
				if (result == null) result = caseAsset(senderSpecification);
				if (result == null) result = caseModelElement(senderSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.RECIPIENT_SPECIFICATION: {
				RecipientSpecification recipientSpecification = (RecipientSpecification)theEObject;
				T result = caseRecipientSpecification(recipientSpecification);
				if (result == null) result = caseRecipientSpecifiable(recipientSpecification);
				if (result == null) result = caseFlowElement(recipientSpecification);
				if (result == null) result = caseDFDElement(recipientSpecification);
				if (result == null) result = caseAsset(recipientSpecification);
				if (result == null) result = caseModelElement(recipientSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.FLOW_ELEMENT: {
				FlowElement flowElement = (FlowElement)theEObject;
				T result = caseFlowElement(flowElement);
				if (result == null) result = caseDFDElement(flowElement);
				if (result == null) result = caseAsset(flowElement);
				if (result == null) result = caseModelElement(flowElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DFD_CONTAINER: {
				DFDContainer dfdContainer = (DFDContainer)theEObject;
				T result = caseDFDContainer(dfdContainer);
				if (result == null) result = caseDFDElement(dfdContainer);
				if (result == null) result = caseAsset(dfdContainer);
				if (result == null) result = caseModelElement(dfdContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.SECURITY_ANNOTATION: {
				SecurityAnnotation securityAnnotation = (SecurityAnnotation)theEObject;
				T result = caseSecurityAnnotation(securityAnnotation);
				if (result == null) result = caseSecurityElement(securityAnnotation);
				if (result == null) result = caseModelElement(securityAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.SOLUTION_TYPE: {
				SolutionType solutionType = (SolutionType)theEObject;
				T result = caseSolutionType(solutionType);
				if (result == null) result = caseSecurityElement(solutionType);
				if (result == null) result = caseModelElement(solutionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ROLE: {
				Role role = (Role)theEObject;
				T result = caseRole(role);
				if (result == null) result = caseSecurityElement(role);
				if (result == null) result = caseModelElement(role);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ABSTRACT_THREAT_TYPE: {
				AbstractThreatType abstractThreatType = (AbstractThreatType)theEObject;
				T result = caseAbstractThreatType(abstractThreatType);
				if (result == null) result = caseSecurityElement(abstractThreatType);
				if (result == null) result = caseModelElement(abstractThreatType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.COUNTER_MEASURE: {
				CounterMeasure counterMeasure = (CounterMeasure)theEObject;
				T result = caseCounterMeasure(counterMeasure);
				if (result == null) result = caseSecurityElement(counterMeasure);
				if (result == null) result = caseModelElement(counterMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ROLE_BINDING: {
				RoleBinding roleBinding = (RoleBinding)theEObject;
				T result = caseRoleBinding(roleBinding);
				if (result == null) result = caseSecurityElement(roleBinding);
				if (result == null) result = caseModelElement(roleBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.SOLUTION: {
				Solution solution = (Solution)theEObject;
				T result = caseSolution(solution);
				if (result == null) result = caseSecurityElement(solution);
				if (result == null) result = caseModelElement(solution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.SPARTA_RESOURCE: {
				SpartaResource spartaResource = (SpartaResource)theEObject;
				T result = caseSpartaResource(spartaResource);
				if (result == null) result = caseModelElement(spartaResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.THREAT_TYPE_CATALOG: {
				ThreatTypeCatalog threatTypeCatalog = (ThreatTypeCatalog)theEObject;
				T result = caseThreatTypeCatalog(threatTypeCatalog);
				if (result == null) result = caseSpartaResource(threatTypeCatalog);
				if (result == null) result = caseModelElement(threatTypeCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.SOLUTION_TYPE_CATALOG: {
				SolutionTypeCatalog solutionTypeCatalog = (SolutionTypeCatalog)theEObject;
				T result = caseSolutionTypeCatalog(solutionTypeCatalog);
				if (result == null) result = caseSpartaResource(solutionTypeCatalog);
				if (result == null) result = caseModelElement(solutionTypeCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ESTRING_TO_EBOOLEAN_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, Boolean> eStringToEBooleanMap = (Map.Entry<String, Boolean>)theEObject;
				T result = caseEStringToEBooleanMap(eStringToEBooleanMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.THREAT_SPECIFICATION: {
				ThreatSpecification threatSpecification = (ThreatSpecification)theEObject;
				T result = caseThreatSpecification(threatSpecification);
				if (result == null) result = caseSecurityElement(threatSpecification);
				if (result == null) result = caseModelElement(threatSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.THREAT_SPECIFICATION_CATALOG: {
				ThreatSpecificationCatalog threatSpecificationCatalog = (ThreatSpecificationCatalog)theEObject;
				T result = caseThreatSpecificationCatalog(threatSpecificationCatalog);
				if (result == null) result = caseSpartaResource(threatSpecificationCatalog);
				if (result == null) result = caseModelElement(threatSpecificationCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ASSET: {
				Asset asset = (Asset)theEObject;
				T result = caseAsset(asset);
				if (result == null) result = caseModelElement(asset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.COMPOSITE_THREAT_TYPE: {
				CompositeThreatType compositeThreatType = (CompositeThreatType)theEObject;
				T result = caseCompositeThreatType(compositeThreatType);
				if (result == null) result = caseAbstractThreatType(compositeThreatType);
				if (result == null) result = caseSecurityElement(compositeThreatType);
				if (result == null) result = caseModelElement(compositeThreatType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.THREAT_TYPE: {
				ThreatType threatType = (ThreatType)theEObject;
				T result = caseThreatType(threatType);
				if (result == null) result = caseAbstractThreatType(threatType);
				if (result == null) result = caseSecurityElement(threatType);
				if (result == null) result = caseModelElement(threatType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ESTIMATE: {
				Estimate estimate = (Estimate)theEObject;
				T result = caseEstimate(estimate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.THREAT_TYPE_TO_ESTIMATE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<ThreatType, Estimate> threatTypeToEstimateMap = (Map.Entry<ThreatType, Estimate>)theEObject;
				T result = caseThreatTypeToEstimateMap(threatTypeToEstimateMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ESTRING_TO_ESTRING_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, String> eStringToEStringMap = (Map.Entry<String, String>)theEObject;
				T result = caseEStringToEStringMap(eStringToEStringMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.MODEL_ELEMENT: {
				ModelElement modelElement = (ModelElement)theEObject;
				T result = caseModelElement(modelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.OR_COMPOSITE_THREAT_TYPE: {
				OrCompositeThreatType orCompositeThreatType = (OrCompositeThreatType)theEObject;
				T result = caseOrCompositeThreatType(orCompositeThreatType);
				if (result == null) result = caseCompositeThreatType(orCompositeThreatType);
				if (result == null) result = caseAbstractThreatType(orCompositeThreatType);
				if (result == null) result = caseSecurityElement(orCompositeThreatType);
				if (result == null) result = caseModelElement(orCompositeThreatType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.AND_COMPOSITE_THREAT_TYPE: {
				AndCompositeThreatType andCompositeThreatType = (AndCompositeThreatType)theEObject;
				T result = caseAndCompositeThreatType(andCompositeThreatType);
				if (result == null) result = caseCompositeThreatType(andCompositeThreatType);
				if (result == null) result = caseAbstractThreatType(andCompositeThreatType);
				if (result == null) result = caseSecurityElement(andCompositeThreatType);
				if (result == null) result = caseModelElement(andCompositeThreatType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.THREAT_TYPE_GROUP: {
				ThreatTypeGroup threatTypeGroup = (ThreatTypeGroup)theEObject;
				T result = caseThreatTypeGroup(threatTypeGroup);
				if (result == null) result = caseOrCompositeThreatType(threatTypeGroup);
				if (result == null) result = caseCompositeThreatType(threatTypeGroup);
				if (result == null) result = caseAbstractThreatType(threatTypeGroup);
				if (result == null) result = caseSecurityElement(threatTypeGroup);
				if (result == null) result = caseModelElement(threatTypeGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ABSTRACT_CONDITION: {
				AbstractCondition abstractCondition = (AbstractCondition)theEObject;
				T result = caseAbstractCondition(abstractCondition);
				if (result == null) result = caseSecurityElement(abstractCondition);
				if (result == null) result = caseModelElement(abstractCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.COMPOSITE_CONDITION: {
				CompositeCondition compositeCondition = (CompositeCondition)theEObject;
				T result = caseCompositeCondition(compositeCondition);
				if (result == null) result = caseAbstractCondition(compositeCondition);
				if (result == null) result = caseSecurityElement(compositeCondition);
				if (result == null) result = caseModelElement(compositeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = caseAbstractCondition(condition);
				if (result == null) result = caseSecurityElement(condition);
				if (result == null) result = caseModelElement(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.AND_COMPOSITE_CONDITION: {
				AndCompositeCondition andCompositeCondition = (AndCompositeCondition)theEObject;
				T result = caseAndCompositeCondition(andCompositeCondition);
				if (result == null) result = caseMultipleCompositeCondition(andCompositeCondition);
				if (result == null) result = caseCompositeCondition(andCompositeCondition);
				if (result == null) result = caseAbstractCondition(andCompositeCondition);
				if (result == null) result = caseSecurityElement(andCompositeCondition);
				if (result == null) result = caseModelElement(andCompositeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.OR_COMPOSITE_CONDITION: {
				OrCompositeCondition orCompositeCondition = (OrCompositeCondition)theEObject;
				T result = caseOrCompositeCondition(orCompositeCondition);
				if (result == null) result = caseMultipleCompositeCondition(orCompositeCondition);
				if (result == null) result = caseCompositeCondition(orCompositeCondition);
				if (result == null) result = caseAbstractCondition(orCompositeCondition);
				if (result == null) result = caseSecurityElement(orCompositeCondition);
				if (result == null) result = caseModelElement(orCompositeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.NOT_COMPOSITE_CONDITION: {
				NotCompositeCondition notCompositeCondition = (NotCompositeCondition)theEObject;
				T result = caseNotCompositeCondition(notCompositeCondition);
				if (result == null) result = caseSingleCompositeCondition(notCompositeCondition);
				if (result == null) result = caseCompositeCondition(notCompositeCondition);
				if (result == null) result = caseAbstractCondition(notCompositeCondition);
				if (result == null) result = caseSecurityElement(notCompositeCondition);
				if (result == null) result = caseModelElement(notCompositeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.SINGLE_COMPOSITE_CONDITION: {
				SingleCompositeCondition singleCompositeCondition = (SingleCompositeCondition)theEObject;
				T result = caseSingleCompositeCondition(singleCompositeCondition);
				if (result == null) result = caseCompositeCondition(singleCompositeCondition);
				if (result == null) result = caseAbstractCondition(singleCompositeCondition);
				if (result == null) result = caseSecurityElement(singleCompositeCondition);
				if (result == null) result = caseModelElement(singleCompositeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.MULTIPLE_COMPOSITE_CONDITION: {
				MultipleCompositeCondition multipleCompositeCondition = (MultipleCompositeCondition)theEObject;
				T result = caseMultipleCompositeCondition(multipleCompositeCondition);
				if (result == null) result = caseCompositeCondition(multipleCompositeCondition);
				if (result == null) result = caseAbstractCondition(multipleCompositeCondition);
				if (result == null) result = caseSecurityElement(multipleCompositeCondition);
				if (result == null) result = caseModelElement(multipleCompositeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.CONDITION_LIST: {
				ConditionList conditionList = (ConditionList)theEObject;
				T result = caseConditionList(conditionList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.AIMPORTED_CONDITION: {
				AImportedCondition aImportedCondition = (AImportedCondition)theEObject;
				T result = caseAImportedCondition(aImportedCondition);
				if (result == null) result = caseCondition(aImportedCondition);
				if (result == null) result = caseAbstractCondition(aImportedCondition);
				if (result == null) result = caseSecurityElement(aImportedCondition);
				if (result == null) result = caseModelElement(aImportedCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.IMPORTED_THREAT_CONDITION: {
				ImportedThreatCondition importedThreatCondition = (ImportedThreatCondition)theEObject;
				T result = caseImportedThreatCondition(importedThreatCondition);
				if (result == null) result = caseAImportedCondition(importedThreatCondition);
				if (result == null) result = caseCondition(importedThreatCondition);
				if (result == null) result = caseAbstractCondition(importedThreatCondition);
				if (result == null) result = caseSecurityElement(importedThreatCondition);
				if (result == null) result = caseModelElement(importedThreatCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.IMPORTED_CONDITION: {
				ImportedCondition importedCondition = (ImportedCondition)theEObject;
				T result = caseImportedCondition(importedCondition);
				if (result == null) result = caseAImportedCondition(importedCondition);
				if (result == null) result = caseCondition(importedCondition);
				if (result == null) result = caseAbstractCondition(importedCondition);
				if (result == null) result = caseSecurityElement(importedCondition);
				if (result == null) result = caseModelElement(importedCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DFD_ELEMENT_ANNOTATION: {
				DFDElementAnnotation dfdElementAnnotation = (DFDElementAnnotation)theEObject;
				T result = caseDFDElementAnnotation(dfdElementAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ATTACKER_MODEL: {
				AttackerModel attackerModel = (AttackerModel)theEObject;
				T result = caseAttackerModel(attackerModel);
				if (result == null) result = caseSpartaResource(attackerModel);
				if (result == null) result = caseModelElement(attackerModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ATTACKER_PROFILE: {
				AttackerProfile attackerProfile = (AttackerProfile)theEObject;
				T result = caseAttackerProfile(attackerProfile);
				if (result == null) result = caseSecurityElement(attackerProfile);
				if (result == null) result = caseModelElement(attackerProfile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.ICHARACTERISTIC: {
				ICharacteristic iCharacteristic = (ICharacteristic)theEObject;
				T result = caseICharacteristic(iCharacteristic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DATA_MODEL: {
				DataModel dataModel = (DataModel)theEObject;
				T result = caseDataModel(dataModel);
				if (result == null) result = caseSpartaResource(dataModel);
				if (result == null) result = caseModelElement(dataModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				T result = caseDataType(dataType);
				if (result == null) result = caseAsset(dataType);
				if (result == null) result = caseDataModelElement(dataType);
				if (result == null) result = caseModelElement(dataType);
				if (result == null) result = caseDFDElementAnnotation(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.TRANSFORMED_DATA: {
				TransformedData transformedData = (TransformedData)theEObject;
				T result = caseTransformedData(transformedData);
				if (result == null) result = caseDataType(transformedData);
				if (result == null) result = caseAsset(transformedData);
				if (result == null) result = caseDataModelElement(transformedData);
				if (result == null) result = caseModelElement(transformedData);
				if (result == null) result = caseDFDElementAnnotation(transformedData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DATA_MODEL_ELEMENT: {
				DataModelElement dataModelElement = (DataModelElement)theEObject;
				T result = caseDataModelElement(dataModelElement);
				if (result == null) result = caseDFDElementAnnotation(dataModelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DATA_SUBJECT_TYPE: {
				DataSubjectType dataSubjectType = (DataSubjectType)theEObject;
				T result = caseDataSubjectType(dataSubjectType);
				if (result == null) result = caseDataModelElement(dataSubjectType);
				if (result == null) result = caseDFDElementAnnotation(dataSubjectType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.PERSONAL_DATA_TYPE: {
				PersonalDataType personalDataType = (PersonalDataType)theEObject;
				T result = casePersonalDataType(personalDataType);
				if (result == null) result = caseDataType(personalDataType);
				if (result == null) result = caseAsset(personalDataType);
				if (result == null) result = caseDataModelElement(personalDataType);
				if (result == null) result = caseModelElement(personalDataType);
				if (result == null) result = caseDFDElementAnnotation(personalDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.DATA_SET: {
				DataSet dataSet = (DataSet)theEObject;
				T result = caseDataSet(dataSet);
				if (result == null) result = caseDataModelElement(dataSet);
				if (result == null) result = caseDFDElementAnnotation(dataSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.IMODEL_ELEMENT_ANNOTATION: {
				IModelElementAnnotation iModelElementAnnotation = (IModelElementAnnotation)theEObject;
				T result = caseIModelElementAnnotation(iModelElementAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.KV_MODEL_ELEMENT_ANNOTATION: {
				KVModelElementAnnotation kvModelElementAnnotation = (KVModelElementAnnotation)theEObject;
				T result = caseKVModelElementAnnotation(kvModelElementAnnotation);
				if (result == null) result = caseIModelElementAnnotation(kvModelElementAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.MODEL_ELEMENT_ANNOTATION: {
				ModelElementAnnotation modelElementAnnotation = (ModelElementAnnotation)theEObject;
				T result = caseModelElementAnnotation(modelElementAnnotation);
				if (result == null) result = caseIModelElementAnnotation(modelElementAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.THREAT_PATTERN: {
				ThreatPattern threatPattern = (ThreatPattern)theEObject;
				T result = caseThreatPattern(threatPattern);
				if (result == null) result = caseModelElement(threatPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpartaModelPackage.THREAT_TYPE_ID_TO_ESTIMATE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, Estimate> threatTypeIDToEstimateMap = (Map.Entry<String, Estimate>)theEObject;
				T result = caseThreatTypeIDToEstimateMap(threatTypeIDToEstimateMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlow(DataFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlowEntity(DataFlowEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalEntity(ExternalEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcess(be.kuleuven.cs.distrinet.sparta.spartamodel.Process object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataStore(DataStore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDModel(DFDModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDElement(DFDElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Security Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSecurityElement(SecurityElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Boundary Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Boundary Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDBoundaryElement(DFDBoundaryElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trust Boundary Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trust Boundary Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrustBoundaryContainer(TrustBoundaryContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sender Specifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sender Specifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSenderSpecifiable(SenderSpecifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recipient Specifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recipient Specifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecipientSpecifiable(RecipientSpecifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sender Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sender Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSenderSpecification(SenderSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recipient Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recipient Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecipientSpecification(RecipientSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowElement(FlowElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDContainer(DFDContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Security Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSecurityAnnotation(SecurityAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solution Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solution Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolutionType(SolutionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRole(Role object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Threat Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractThreatType(AbstractThreatType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Counter Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Counter Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCounterMeasure(CounterMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoleBinding(RoleBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolution(Solution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sparta Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sparta Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpartaResource(SpartaResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat Type Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat Type Catalog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatTypeCatalog(ThreatTypeCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solution Type Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solution Type Catalog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolutionTypeCatalog(SolutionTypeCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EString To EBoolean Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EString To EBoolean Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStringToEBooleanMap(Map.Entry<String, Boolean> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatSpecification(ThreatSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat Specification Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat Specification Catalog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatSpecificationCatalog(ThreatSpecificationCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAsset(Asset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Threat Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeThreatType(CompositeThreatType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatType(ThreatType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Estimate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Estimate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEstimate(Estimate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat Type To Estimate Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat Type To Estimate Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatTypeToEstimateMap(Map.Entry<ThreatType, Estimate> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EString To EString Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EString To EString Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStringToEStringMap(Map.Entry<String, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElement(ModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Composite Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Composite Threat Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrCompositeThreatType(OrCompositeThreatType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Composite Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Composite Threat Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndCompositeThreatType(AndCompositeThreatType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat Type Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat Type Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatTypeGroup(ThreatTypeGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractCondition(AbstractCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeCondition(CompositeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Composite Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndCompositeCondition(AndCompositeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Composite Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrCompositeCondition(OrCompositeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Composite Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotCompositeCondition(NotCompositeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Composite Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleCompositeCondition(SingleCompositeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiple Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple Composite Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleCompositeCondition(MultipleCompositeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionList(ConditionList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AImported Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AImported Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAImportedCondition(AImportedCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imported Threat Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imported Threat Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportedThreatCondition(ImportedThreatCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imported Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imported Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportedCondition(ImportedCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Element Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Element Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDElementAnnotation(DFDElementAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attacker Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attacker Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackerModel(AttackerModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attacker Profile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attacker Profile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackerProfile(AttackerProfile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICharacteristic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICharacteristic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICharacteristic(ICharacteristic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataModel(DataModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformed Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformed Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformedData(TransformedData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataModelElement(DataModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Subject Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Subject Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSubjectType(DataSubjectType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Personal Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Personal Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePersonalDataType(PersonalDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSet(DataSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IModel Element Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IModel Element Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIModelElementAnnotation(IModelElementAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KV Model Element Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KV Model Element Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKVModelElementAnnotation(KVModelElementAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementAnnotation(ModelElementAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatPattern(ThreatPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat Type ID To Estimate Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat Type ID To Estimate Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatTypeIDToEstimateMap(Map.Entry<String, Estimate> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SpartaModelSwitch
