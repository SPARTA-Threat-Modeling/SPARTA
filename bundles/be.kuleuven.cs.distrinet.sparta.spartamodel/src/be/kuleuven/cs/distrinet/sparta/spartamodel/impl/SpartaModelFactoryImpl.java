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

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AndCompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Condition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSet;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.KVModelElementAnnotation;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElementAnnotation;
import be.kuleuven.cs.distrinet.sparta.spartamodel.NotCompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeCondition;
import be.kuleuven.cs.distrinet.sparta.spartamodel.OrCompositeThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionTypeCatalog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeGroup;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatPattern;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TransformedData;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpartaModelFactoryImpl extends EFactoryImpl implements SpartaModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpartaModelFactory init() {
		try {
			SpartaModelFactory theSpartaModelFactory = (SpartaModelFactory)EPackage.Registry.INSTANCE.getEFactory(SpartaModelPackage.eNS_URI);
			if (theSpartaModelFactory != null) {
				return theSpartaModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SpartaModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpartaModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SpartaModelPackage.DATA_FLOW: return createDataFlow();
			case SpartaModelPackage.EXTERNAL_ENTITY: return createExternalEntity();
			case SpartaModelPackage.PROCESS: return createProcess();
			case SpartaModelPackage.DATA_STORE: return createDataStore();
			case SpartaModelPackage.DFD_MODEL: return createDFDModel();
			case SpartaModelPackage.TRUST_BOUNDARY_CONTAINER: return createTrustBoundaryContainer();
			case SpartaModelPackage.SENDER_SPECIFICATION: return createSenderSpecification();
			case SpartaModelPackage.RECIPIENT_SPECIFICATION: return createRecipientSpecification();
			case SpartaModelPackage.SOLUTION_TYPE: return createSolutionType();
			case SpartaModelPackage.ROLE: return createRole();
			case SpartaModelPackage.COUNTER_MEASURE: return createCounterMeasure();
			case SpartaModelPackage.ROLE_BINDING: return createRoleBinding();
			case SpartaModelPackage.SOLUTION: return createSolution();
			case SpartaModelPackage.THREAT_TYPE_CATALOG: return createThreatTypeCatalog();
			case SpartaModelPackage.SOLUTION_TYPE_CATALOG: return createSolutionTypeCatalog();
			case SpartaModelPackage.ESTRING_TO_EBOOLEAN_MAP: return (EObject)createEStringToEBooleanMap();
			case SpartaModelPackage.THREAT_SPECIFICATION: return createThreatSpecification();
			case SpartaModelPackage.THREAT_SPECIFICATION_CATALOG: return createThreatSpecificationCatalog();
			case SpartaModelPackage.THREAT_TYPE: return createThreatType();
			case SpartaModelPackage.ESTIMATE: return createEstimate();
			case SpartaModelPackage.THREAT_TYPE_TO_ESTIMATE_MAP: return (EObject)createThreatTypeToEstimateMap();
			case SpartaModelPackage.ESTRING_TO_ESTRING_MAP: return (EObject)createEStringToEStringMap();
			case SpartaModelPackage.OR_COMPOSITE_THREAT_TYPE: return createOrCompositeThreatType();
			case SpartaModelPackage.AND_COMPOSITE_THREAT_TYPE: return createAndCompositeThreatType();
			case SpartaModelPackage.THREAT_TYPE_GROUP: return createThreatTypeGroup();
			case SpartaModelPackage.CONDITION: return createCondition();
			case SpartaModelPackage.AND_COMPOSITE_CONDITION: return createAndCompositeCondition();
			case SpartaModelPackage.OR_COMPOSITE_CONDITION: return createOrCompositeCondition();
			case SpartaModelPackage.NOT_COMPOSITE_CONDITION: return createNotCompositeCondition();
			case SpartaModelPackage.CONDITION_LIST: return createConditionList();
			case SpartaModelPackage.IMPORTED_THREAT_CONDITION: return createImportedThreatCondition();
			case SpartaModelPackage.IMPORTED_CONDITION: return createImportedCondition();
			case SpartaModelPackage.ATTACKER_MODEL: return createAttackerModel();
			case SpartaModelPackage.ATTACKER_PROFILE: return createAttackerProfile();
			case SpartaModelPackage.DATA_MODEL: return createDataModel();
			case SpartaModelPackage.DATA_TYPE: return createDataType();
			case SpartaModelPackage.TRANSFORMED_DATA: return createTransformedData();
			case SpartaModelPackage.DATA_SUBJECT_TYPE: return createDataSubjectType();
			case SpartaModelPackage.PERSONAL_DATA_TYPE: return createPersonalDataType();
			case SpartaModelPackage.DATA_SET: return createDataSet();
			case SpartaModelPackage.KV_MODEL_ELEMENT_ANNOTATION: return createKVModelElementAnnotation();
			case SpartaModelPackage.MODEL_ELEMENT_ANNOTATION: return createModelElementAnnotation();
			case SpartaModelPackage.THREAT_PATTERN: return createThreatPattern();
			case SpartaModelPackage.THREAT_TYPE_ID_TO_ESTIMATE_MAP: return (EObject)createThreatTypeIDToEstimateMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataFlow createDataFlow() {
		DataFlowImpl dataFlow = new DataFlowImpl();
		return dataFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalEntity createExternalEntity() {
		ExternalEntityImpl externalEntity = new ExternalEntityImpl();
		return externalEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public be.kuleuven.cs.distrinet.sparta.spartamodel.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataStore createDataStore() {
		DataStoreImpl dataStore = new DataStoreImpl();
		return dataStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DFDModel createDFDModel() {
		DFDModelImpl dfdModel = new DFDModelImpl();
		return dfdModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TrustBoundaryContainer createTrustBoundaryContainer() {
		TrustBoundaryContainerImpl trustBoundaryContainer = new TrustBoundaryContainerImpl();
		return trustBoundaryContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SenderSpecification createSenderSpecification() {
		SenderSpecificationImpl senderSpecification = new SenderSpecificationImpl();
		return senderSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecipientSpecification createRecipientSpecification() {
		RecipientSpecificationImpl recipientSpecification = new RecipientSpecificationImpl();
		return recipientSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SolutionType createSolutionType() {
		SolutionTypeImpl solutionType = new SolutionTypeImpl();
		return solutionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	@Override
	public Role createRole(@SuppressWarnings("unchecked") Class<? extends DFDElement>... types) {
		Role role = createRole();
		for (Class<? extends DFDElement> type : types) {
			role.getBindingTypes().add(type);
		}
		return role;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CounterMeasure createCounterMeasure() {
		CounterMeasureImpl counterMeasure = new CounterMeasureImpl();
		return counterMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RoleBinding createRoleBinding() {
		RoleBindingImpl roleBinding = new RoleBindingImpl();
		return roleBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Solution createSolution() {
		SolutionImpl solution = new SolutionImpl();
		return solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThreatTypeCatalog createThreatTypeCatalog() {
		ThreatTypeCatalogImpl threatTypeCatalog = new ThreatTypeCatalogImpl();
		return threatTypeCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SolutionTypeCatalog createSolutionTypeCatalog() {
		SolutionTypeCatalogImpl solutionTypeCatalog = new SolutionTypeCatalogImpl();
		return solutionTypeCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Boolean> createEStringToEBooleanMap() {
		EStringToEBooleanMapImpl eStringToEBooleanMap = new EStringToEBooleanMapImpl();
		return eStringToEBooleanMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThreatSpecification createThreatSpecification() {
		ThreatSpecificationImpl threatSpecification = new ThreatSpecificationImpl();
		return threatSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThreatSpecificationCatalog createThreatSpecificationCatalog() {
		ThreatSpecificationCatalogImpl threatSpecificationCatalog = new ThreatSpecificationCatalogImpl();
		return threatSpecificationCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThreatType createThreatType() {
		ThreatTypeImpl threatType = new ThreatTypeImpl();
		return threatType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Estimate createEstimate() {
		EstimateImpl estimate = new EstimateImpl();
		return estimate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<ThreatType, Estimate> createThreatTypeToEstimateMap() {
		ThreatTypeToEstimateMapImpl threatTypeToEstimateMap = new ThreatTypeToEstimateMapImpl();
		return threatTypeToEstimateMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createEStringToEStringMap() {
		EStringToEStringMapImpl eStringToEStringMap = new EStringToEStringMapImpl();
		return eStringToEStringMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrCompositeThreatType createOrCompositeThreatType() {
		OrCompositeThreatTypeImpl orCompositeThreatType = new OrCompositeThreatTypeImpl();
		return orCompositeThreatType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AndCompositeThreatType createAndCompositeThreatType() {
		AndCompositeThreatTypeImpl andCompositeThreatType = new AndCompositeThreatTypeImpl();
		return andCompositeThreatType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThreatTypeGroup createThreatTypeGroup() {
		ThreatTypeGroupImpl threatTypeGroup = new ThreatTypeGroupImpl();
		return threatTypeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AndCompositeCondition createAndCompositeCondition() {
		AndCompositeConditionImpl andCompositeCondition = new AndCompositeConditionImpl();
		return andCompositeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrCompositeCondition createOrCompositeCondition() {
		OrCompositeConditionImpl orCompositeCondition = new OrCompositeConditionImpl();
		return orCompositeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotCompositeCondition createNotCompositeCondition() {
		NotCompositeConditionImpl notCompositeCondition = new NotCompositeConditionImpl();
		return notCompositeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConditionList createConditionList() {
		ConditionListImpl conditionList = new ConditionListImpl();
		return conditionList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImportedThreatCondition createImportedThreatCondition() {
		ImportedThreatConditionImpl importedThreatCondition = new ImportedThreatConditionImpl();
		return importedThreatCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImportedCondition createImportedCondition() {
		ImportedConditionImpl importedCondition = new ImportedConditionImpl();
		return importedCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttackerModel createAttackerModel() {
		AttackerModelImpl attackerModel = new AttackerModelImpl();
		return attackerModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttackerProfile createAttackerProfile() {
		AttackerProfileImpl attackerProfile = new AttackerProfileImpl();
		return attackerProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataModel createDataModel() {
		DataModelImpl dataModel = new DataModelImpl();
		return dataModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransformedData createTransformedData() {
		TransformedDataImpl transformedData = new TransformedDataImpl();
		return transformedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSubjectType createDataSubjectType() {
		DataSubjectTypeImpl dataSubjectType = new DataSubjectTypeImpl();
		return dataSubjectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PersonalDataType createPersonalDataType() {
		PersonalDataTypeImpl personalDataType = new PersonalDataTypeImpl();
		return personalDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSet createDataSet() {
		DataSetImpl dataSet = new DataSetImpl();
		return dataSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public KVModelElementAnnotation createKVModelElementAnnotation() {
		KVModelElementAnnotationImpl kvModelElementAnnotation = new KVModelElementAnnotationImpl();
		return kvModelElementAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelElementAnnotation createModelElementAnnotation() {
		ModelElementAnnotationImpl modelElementAnnotation = new ModelElementAnnotationImpl();
		return modelElementAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThreatPattern createThreatPattern() {
		ThreatPatternImpl threatPattern = new ThreatPatternImpl();
		return threatPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Estimate> createThreatTypeIDToEstimateMap() {
		ThreatTypeIDToEstimateMapImpl threatTypeIDToEstimateMap = new ThreatTypeIDToEstimateMapImpl();
		return threatTypeIDToEstimateMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpartaModelPackage getSpartaModelPackage() {
		return (SpartaModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SpartaModelPackage getPackage() {
		return SpartaModelPackage.eINSTANCE;
	}

} //SpartaModelFactoryImpl
