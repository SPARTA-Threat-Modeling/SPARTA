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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage
 * @generated
 */
public class SpartaModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpartaModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpartaModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SpartaModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpartaModelSwitch<Adapter> modelSwitch =
		new SpartaModelSwitch<Adapter>() {
			@Override
			public Adapter caseDataFlow(DataFlow object) {
				return createDataFlowAdapter();
			}
			@Override
			public Adapter caseDataFlowEntity(DataFlowEntity object) {
				return createDataFlowEntityAdapter();
			}
			@Override
			public Adapter caseExternalEntity(ExternalEntity object) {
				return createExternalEntityAdapter();
			}
			@Override
			public Adapter caseProcess(be.kuleuven.cs.distrinet.sparta.spartamodel.Process object) {
				return createProcessAdapter();
			}
			@Override
			public Adapter caseDataStore(DataStore object) {
				return createDataStoreAdapter();
			}
			@Override
			public Adapter caseDFDModel(DFDModel object) {
				return createDFDModelAdapter();
			}
			@Override
			public Adapter caseDFDElement(DFDElement object) {
				return createDFDElementAdapter();
			}
			@Override
			public Adapter caseSecurityElement(SecurityElement object) {
				return createSecurityElementAdapter();
			}
			@Override
			public Adapter caseDFDBoundaryElement(DFDBoundaryElement object) {
				return createDFDBoundaryElementAdapter();
			}
			@Override
			public Adapter caseTrustBoundaryContainer(TrustBoundaryContainer object) {
				return createTrustBoundaryContainerAdapter();
			}
			@Override
			public Adapter caseSenderSpecifiable(SenderSpecifiable object) {
				return createSenderSpecifiableAdapter();
			}
			@Override
			public Adapter caseRecipientSpecifiable(RecipientSpecifiable object) {
				return createRecipientSpecifiableAdapter();
			}
			@Override
			public Adapter caseSenderSpecification(SenderSpecification object) {
				return createSenderSpecificationAdapter();
			}
			@Override
			public Adapter caseRecipientSpecification(RecipientSpecification object) {
				return createRecipientSpecificationAdapter();
			}
			@Override
			public Adapter caseFlowElement(FlowElement object) {
				return createFlowElementAdapter();
			}
			@Override
			public Adapter caseDFDContainer(DFDContainer object) {
				return createDFDContainerAdapter();
			}
			@Override
			public Adapter caseSecurityAnnotation(SecurityAnnotation object) {
				return createSecurityAnnotationAdapter();
			}
			@Override
			public Adapter caseSolutionType(SolutionType object) {
				return createSolutionTypeAdapter();
			}
			@Override
			public Adapter caseRole(Role object) {
				return createRoleAdapter();
			}
			@Override
			public Adapter caseAbstractThreatType(AbstractThreatType object) {
				return createAbstractThreatTypeAdapter();
			}
			@Override
			public Adapter caseCounterMeasure(CounterMeasure object) {
				return createCounterMeasureAdapter();
			}
			@Override
			public Adapter caseRoleBinding(RoleBinding object) {
				return createRoleBindingAdapter();
			}
			@Override
			public Adapter caseSolution(Solution object) {
				return createSolutionAdapter();
			}
			@Override
			public Adapter caseSpartaResource(SpartaResource object) {
				return createSpartaResourceAdapter();
			}
			@Override
			public Adapter caseThreatTypeCatalog(ThreatTypeCatalog object) {
				return createThreatTypeCatalogAdapter();
			}
			@Override
			public Adapter caseSolutionTypeCatalog(SolutionTypeCatalog object) {
				return createSolutionTypeCatalogAdapter();
			}
			@Override
			public Adapter caseEStringToEBooleanMap(Map.Entry<String, Boolean> object) {
				return createEStringToEBooleanMapAdapter();
			}
			@Override
			public Adapter caseThreatSpecification(ThreatSpecification object) {
				return createThreatSpecificationAdapter();
			}
			@Override
			public Adapter caseThreatSpecificationCatalog(ThreatSpecificationCatalog object) {
				return createThreatSpecificationCatalogAdapter();
			}
			@Override
			public Adapter caseAsset(Asset object) {
				return createAssetAdapter();
			}
			@Override
			public Adapter caseCompositeThreatType(CompositeThreatType object) {
				return createCompositeThreatTypeAdapter();
			}
			@Override
			public Adapter caseThreatType(ThreatType object) {
				return createThreatTypeAdapter();
			}
			@Override
			public Adapter caseEstimate(Estimate object) {
				return createEstimateAdapter();
			}
			@Override
			public Adapter caseThreatTypeToEstimateMap(Map.Entry<ThreatType, Estimate> object) {
				return createThreatTypeToEstimateMapAdapter();
			}
			@Override
			public Adapter caseEStringToEStringMap(Map.Entry<String, String> object) {
				return createEStringToEStringMapAdapter();
			}
			@Override
			public Adapter caseModelElement(ModelElement object) {
				return createModelElementAdapter();
			}
			@Override
			public Adapter caseOrCompositeThreatType(OrCompositeThreatType object) {
				return createOrCompositeThreatTypeAdapter();
			}
			@Override
			public Adapter caseAndCompositeThreatType(AndCompositeThreatType object) {
				return createAndCompositeThreatTypeAdapter();
			}
			@Override
			public Adapter caseThreatTypeGroup(ThreatTypeGroup object) {
				return createThreatTypeGroupAdapter();
			}
			@Override
			public Adapter caseAbstractCondition(AbstractCondition object) {
				return createAbstractConditionAdapter();
			}
			@Override
			public Adapter caseCompositeCondition(CompositeCondition object) {
				return createCompositeConditionAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseAndCompositeCondition(AndCompositeCondition object) {
				return createAndCompositeConditionAdapter();
			}
			@Override
			public Adapter caseOrCompositeCondition(OrCompositeCondition object) {
				return createOrCompositeConditionAdapter();
			}
			@Override
			public Adapter caseNotCompositeCondition(NotCompositeCondition object) {
				return createNotCompositeConditionAdapter();
			}
			@Override
			public Adapter caseSingleCompositeCondition(SingleCompositeCondition object) {
				return createSingleCompositeConditionAdapter();
			}
			@Override
			public Adapter caseMultipleCompositeCondition(MultipleCompositeCondition object) {
				return createMultipleCompositeConditionAdapter();
			}
			@Override
			public Adapter caseConditionList(ConditionList object) {
				return createConditionListAdapter();
			}
			@Override
			public Adapter caseAImportedCondition(AImportedCondition object) {
				return createAImportedConditionAdapter();
			}
			@Override
			public Adapter caseImportedThreatCondition(ImportedThreatCondition object) {
				return createImportedThreatConditionAdapter();
			}
			@Override
			public Adapter caseImportedCondition(ImportedCondition object) {
				return createImportedConditionAdapter();
			}
			@Override
			public Adapter caseDFDElementAnnotation(DFDElementAnnotation object) {
				return createDFDElementAnnotationAdapter();
			}
			@Override
			public Adapter caseAttackerModel(AttackerModel object) {
				return createAttackerModelAdapter();
			}
			@Override
			public Adapter caseAttackerProfile(AttackerProfile object) {
				return createAttackerProfileAdapter();
			}
			@Override
			public Adapter caseICharacteristic(ICharacteristic object) {
				return createICharacteristicAdapter();
			}
			@Override
			public Adapter caseDataModel(DataModel object) {
				return createDataModelAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseTransformedData(TransformedData object) {
				return createTransformedDataAdapter();
			}
			@Override
			public Adapter caseDataModelElement(DataModelElement object) {
				return createDataModelElementAdapter();
			}
			@Override
			public Adapter caseDataSubjectType(DataSubjectType object) {
				return createDataSubjectTypeAdapter();
			}
			@Override
			public Adapter casePersonalDataType(PersonalDataType object) {
				return createPersonalDataTypeAdapter();
			}
			@Override
			public Adapter caseDataSet(DataSet object) {
				return createDataSetAdapter();
			}
			@Override
			public Adapter caseIModelElementAnnotation(IModelElementAnnotation object) {
				return createIModelElementAnnotationAdapter();
			}
			@Override
			public Adapter caseKVModelElementAnnotation(KVModelElementAnnotation object) {
				return createKVModelElementAnnotationAdapter();
			}
			@Override
			public Adapter caseModelElementAnnotation(ModelElementAnnotation object) {
				return createModelElementAnnotationAdapter();
			}
			@Override
			public Adapter caseThreatPattern(ThreatPattern object) {
				return createThreatPatternAdapter();
			}
			@Override
			public Adapter caseThreatTypeIDToEstimateMap(Map.Entry<String, Estimate> object) {
				return createThreatTypeIDToEstimateMapAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow
	 * @generated
	 */
	public Adapter createDataFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity <em>Data Flow Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity
	 * @generated
	 */
	public Adapter createDataFlowEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity <em>External Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity
	 * @generated
	 */
	public Adapter createExternalEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Process
	 * @generated
	 */
	public Adapter createProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore <em>Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore
	 * @generated
	 */
	public Adapter createDataStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel <em>DFD Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel
	 * @generated
	 */
	public Adapter createDFDModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement <em>DFD Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement
	 * @generated
	 */
	public Adapter createDFDElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityElement <em>Security Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityElement
	 * @generated
	 */
	public Adapter createSecurityElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDBoundaryElement <em>DFD Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDBoundaryElement
	 * @generated
	 */
	public Adapter createDFDBoundaryElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer <em>Trust Boundary Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer
	 * @generated
	 */
	public Adapter createTrustBoundaryContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable <em>Sender Specifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecifiable
	 * @generated
	 */
	public Adapter createSenderSpecifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable <em>Recipient Specifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecifiable
	 * @generated
	 */
	public Adapter createRecipientSpecifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification <em>Sender Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification
	 * @generated
	 */
	public Adapter createSenderSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification <em>Recipient Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification
	 * @generated
	 */
	public Adapter createRecipientSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.FlowElement <em>Flow Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.FlowElement
	 * @generated
	 */
	public Adapter createFlowElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDContainer <em>DFD Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDContainer
	 * @generated
	 */
	public Adapter createDFDContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityAnnotation <em>Security Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SecurityAnnotation
	 * @generated
	 */
	public Adapter createSecurityAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType <em>Solution Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType
	 * @generated
	 */
	public Adapter createSolutionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Role
	 * @generated
	 */
	public Adapter createRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType <em>Abstract Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType
	 * @generated
	 */
	public Adapter createAbstractThreatTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure <em>Counter Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure
	 * @generated
	 */
	public Adapter createCounterMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding <em>Role Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding
	 * @generated
	 */
	public Adapter createRoleBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Solution
	 * @generated
	 */
	public Adapter createSolutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaResource <em>Sparta Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaResource
	 * @generated
	 */
	public Adapter createSpartaResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog <em>Threat Type Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog
	 * @generated
	 */
	public Adapter createThreatTypeCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionTypeCatalog <em>Solution Type Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionTypeCatalog
	 * @generated
	 */
	public Adapter createSolutionTypeCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EString To EBoolean Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEStringToEBooleanMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification <em>Threat Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification
	 * @generated
	 */
	public Adapter createThreatSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog <em>Threat Specification Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog
	 * @generated
	 */
	public Adapter createThreatSpecificationCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Asset
	 * @generated
	 */
	public Adapter createAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType <em>Composite Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType
	 * @generated
	 */
	public Adapter createCompositeThreatTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType <em>Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType
	 * @generated
	 */
	public Adapter createThreatTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate <em>Estimate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate
	 * @generated
	 */
	public Adapter createEstimateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Threat Type To Estimate Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createThreatTypeToEstimateMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EString To EString Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEStringToEStringMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement
	 * @generated
	 */
	public Adapter createModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeThreatType <em>Or Composite Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeThreatType
	 * @generated
	 */
	public Adapter createOrCompositeThreatTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeThreatType <em>And Composite Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeThreatType
	 * @generated
	 */
	public Adapter createAndCompositeThreatTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeGroup <em>Threat Type Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeGroup
	 * @generated
	 */
	public Adapter createThreatTypeGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition <em>Abstract Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractCondition
	 * @generated
	 */
	public Adapter createAbstractConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeCondition <em>Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeCondition
	 * @generated
	 */
	public Adapter createCompositeConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeCondition <em>And Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeCondition
	 * @generated
	 */
	public Adapter createAndCompositeConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeCondition <em>Or Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeCondition
	 * @generated
	 */
	public Adapter createOrCompositeConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.NotCompositeCondition <em>Not Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.NotCompositeCondition
	 * @generated
	 */
	public Adapter createNotCompositeConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition <em>Single Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SingleCompositeCondition
	 * @generated
	 */
	public Adapter createSingleCompositeConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.MultipleCompositeCondition <em>Multiple Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.MultipleCompositeCondition
	 * @generated
	 */
	public Adapter createMultipleCompositeConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList <em>Condition List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList
	 * @generated
	 */
	public Adapter createConditionListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AImportedCondition <em>AImported Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AImportedCondition
	 * @generated
	 */
	public Adapter createAImportedConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition <em>Imported Threat Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition
	 * @generated
	 */
	public Adapter createImportedThreatConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedCondition <em>Imported Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedCondition
	 * @generated
	 */
	public Adapter createImportedConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation <em>DFD Element Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElementAnnotation
	 * @generated
	 */
	public Adapter createDFDElementAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel <em>Attacker Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel
	 * @generated
	 */
	public Adapter createAttackerModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile <em>Attacker Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile
	 * @generated
	 */
	public Adapter createAttackerProfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic <em>ICharacteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic
	 * @generated
	 */
	public Adapter createICharacteristicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataModel
	 * @generated
	 */
	public Adapter createDataModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData <em>Transformed Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData
	 * @generated
	 */
	public Adapter createTransformedDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement <em>Data Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataModelElement
	 * @generated
	 */
	public Adapter createDataModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType <em>Data Subject Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType
	 * @generated
	 */
	public Adapter createDataSubjectTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType <em>Personal Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType
	 * @generated
	 */
	public Adapter createPersonalDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.DataSet <em>Data Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.DataSet
	 * @generated
	 */
	public Adapter createDataSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation <em>IModel Element Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.IModelElementAnnotation
	 * @generated
	 */
	public Adapter createIModelElementAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation <em>KV Model Element Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation
	 * @generated
	 */
	public Adapter createKVModelElementAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation <em>Model Element Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation
	 * @generated
	 */
	public Adapter createModelElementAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern <em>Threat Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern
	 * @generated
	 */
	public Adapter createThreatPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Threat Type ID To Estimate Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createThreatTypeIDToEstimateMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SpartaModelAdapterFactory
