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

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpartaModelPackageImpl extends EPackageImpl implements SpartaModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFlowEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdBoundaryElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trustBoundaryContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass senderSpecifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recipientSpecifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass senderSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recipientSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solutionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractThreatTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass counterMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spartaResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatTypeCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solutionTypeCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToEBooleanMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatSpecificationCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeThreatTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass estimateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatTypeToEstimateMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToEStringMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orCompositeThreatTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andCompositeThreatTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatTypeGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andCompositeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orCompositeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notCompositeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleCompositeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleCompositeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aImportedConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importedThreatConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importedConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdElementAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackerModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackerProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCharacteristicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformedDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataModelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSubjectTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personalDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iModelElementAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kvModelElementAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatTypeIDToEstimateMapEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SpartaModelPackageImpl() {
		super(eNS_URI, SpartaModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link SpartaModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SpartaModelPackage init() {
		if (isInited) return (SpartaModelPackage)EPackage.Registry.INSTANCE.getEPackage(SpartaModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSpartaModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SpartaModelPackageImpl theSpartaModelPackage = registeredSpartaModelPackage instanceof SpartaModelPackageImpl ? (SpartaModelPackageImpl)registeredSpartaModelPackage : new SpartaModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSpartaModelPackage.createPackageContents();

		// Initialize created meta-data
		theSpartaModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSpartaModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SpartaModelPackage.eNS_URI, theSpartaModelPackage);
		return theSpartaModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataFlow() {
		return dataFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDataFlow__GetDataFlow() {
		return dataFlowEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataFlowEntity() {
		return dataFlowEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataFlowEntity_Send() {
		return (EReference)dataFlowEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataFlowEntity_Receive() {
		return (EReference)dataFlowEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExternalEntity() {
		return externalEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProcess() {
		return processEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataStore() {
		return dataStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDFDModel() {
		return dfdModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDFDModel_ContainedElements() {
		return (EReference)dfdModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDFDModel_Resource() {
		return (EReference)dfdModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDFDElement() {
		return dfdElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDFDElement_Securityannotation() {
		return (EReference)dfdElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDFDElement_Dfdelementannotation() {
		return (EReference)dfdElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSecurityElement() {
		return securityElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDFDBoundaryElement() {
		return dfdBoundaryElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDFDBoundaryElement_CrossingFlows() {
		return (EReference)dfdBoundaryElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTrustBoundaryContainer() {
		return trustBoundaryContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSenderSpecifiable() {
		return senderSpecifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSenderSpecifiable_SenderSpecifiedBy() {
		return (EReference)senderSpecifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSenderSpecifiable_Sender() {
		return (EReference)senderSpecifiableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRecipientSpecifiable() {
		return recipientSpecifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecipientSpecifiable_RecipientSpecifiedBy() {
		return (EReference)recipientSpecifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecipientSpecifiable_Recipient() {
		return (EReference)recipientSpecifiableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSenderSpecification() {
		return senderSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSenderSpecification_SpecifiesSenderOf() {
		return (EReference)senderSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSenderSpecification__GetDataFlow() {
		return senderSpecificationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRecipientSpecification() {
		return recipientSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecipientSpecification_SpecifiesRecipientOf() {
		return (EReference)recipientSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRecipientSpecification__GetDataFlow() {
		return recipientSpecificationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFlowElement() {
		return flowElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFlowElement__GetDataFlow() {
		return flowElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDFDContainer() {
		return dfdContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDFDContainer_ContainedElements() {
		return (EReference)dfdContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSecurityAnnotation() {
		return securityAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSolutionType() {
		return solutionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSolutionType_Roles() {
		return (EReference)solutionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSolutionType_Countermeasure() {
		return (EReference)solutionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRole_Subjected() {
		return (EReference)roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRole_BindingTypes() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractThreatType() {
		return abstractThreatTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractThreatType_Enabled() {
		return (EAttribute)abstractThreatTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractThreatType_Patterns() {
		return (EReference)abstractThreatTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractThreatType_Title() {
		return (EAttribute)abstractThreatTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractThreatType_AdditionalInfo() {
		return (EAttribute)abstractThreatTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractThreatType_Comments() {
		return (EAttribute)abstractThreatTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractThreatType_Characteristic() {
		return (EReference)abstractThreatTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractThreatType_SuperThreatType() {
		return (EReference)abstractThreatTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCounterMeasure() {
		return counterMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCounterMeasure_Mitigates() {
		return (EReference)counterMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCounterMeasure_Securitysubobjective() {
		return (EReference)counterMeasureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCounterMeasure_Scope() {
		return (EReference)counterMeasureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCounterMeasure_Subject() {
		return (EReference)counterMeasureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCounterMeasure_Difficulty() {
		return (EReference)counterMeasureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCounterMeasure_MitigatedThreatTypeID() {
		return (EAttribute)counterMeasureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRoleBinding() {
		return roleBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoleBinding_Binds() {
		return (EReference)roleBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoleBinding_BindsTo() {
		return (EReference)roleBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSolution() {
		return solutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSolution_Securitypattern() {
		return (EReference)solutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSolution_Rolebinding() {
		return (EReference)solutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpartaResource() {
		return spartaResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpartaResource_Securityannotation() {
		return (EReference)spartaResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThreatTypeCatalog() {
		return threatTypeCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatTypeCatalog_Threat() {
		return (EReference)threatTypeCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatTypeCatalog_Threattypegroup() {
		return (EReference)threatTypeCatalogEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatTypeCatalog_Conditionlist() {
		return (EReference)threatTypeCatalogEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThreatTypeCatalog_Imports() {
		return (EAttribute)threatTypeCatalogEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThreatTypeCatalog_HelperPatterns() {
		return (EAttribute)threatTypeCatalogEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThreatTypeCatalog_Package() {
		return (EAttribute)threatTypeCatalogEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatTypeCatalog_PatternDependencies() {
		return (EReference)threatTypeCatalogEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSolutionTypeCatalog() {
		return solutionTypeCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSolutionTypeCatalog_SolutionTypes() {
		return (EReference)solutionTypeCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEStringToEBooleanMap() {
		return eStringToEBooleanMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEStringToEBooleanMap_Key() {
		return (EAttribute)eStringToEBooleanMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEStringToEBooleanMap_Value() {
		return (EAttribute)eStringToEBooleanMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThreatSpecification() {
		return threatSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatSpecification_Threat() {
		return (EReference)threatSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThreatSpecification_Enabled() {
		return (EAttribute)threatSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatSpecification_Types() {
		return (EReference)threatSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatSpecification_Patterns() {
		return (EReference)threatSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThreatSpecificationCatalog() {
		return threatSpecificationCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatSpecificationCatalog_Threatspecifications() {
		return (EReference)threatSpecificationCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAsset() {
		return assetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAsset_LossMagnitude() {
		return (EReference)assetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAsset_Estimates() {
		return (EReference)assetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAsset_Bound() {
		return (EReference)assetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAsset_LossMagnitudeByID() {
		return (EReference)assetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAsset__GetEstimate__AbstractThreatType() {
		return assetEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeThreatType() {
		return compositeThreatTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeThreatType_SubThreatTypes() {
		return (EReference)compositeThreatTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThreatType() {
		return threatTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatType_Condition() {
		return (EReference)threatTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatType_Threatpattern() {
		return (EReference)threatTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getThreatType__ToString() {
		return threatTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getThreatType__GetThreatTypeAncestor() {
		return threatTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEstimate() {
		return estimateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEstimate_Minimum() {
		return (EAttribute)estimateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEstimate_Probable() {
		return (EAttribute)estimateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEstimate_Maximum() {
		return (EAttribute)estimateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEstimate_Confidence() {
		return (EAttribute)estimateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEstimate_Name() {
		return (EAttribute)estimateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEstimate__GetEstimateName() {
		return estimateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThreatTypeToEstimateMap() {
		return threatTypeToEstimateMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatTypeToEstimateMap_Key() {
		return (EReference)threatTypeToEstimateMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatTypeToEstimateMap_Value() {
		return (EReference)threatTypeToEstimateMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEStringToEStringMap() {
		return eStringToEStringMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEStringToEStringMap_Key() {
		return (EAttribute)eStringToEStringMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEStringToEStringMap_Value() {
		return (EAttribute)eStringToEStringMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelElement() {
		return modelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelElement_Name() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelElement_Description() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelElement_Annotations() {
		return (EReference)modelElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelElement_Id() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOrCompositeThreatType() {
		return orCompositeThreatTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAndCompositeThreatType() {
		return andCompositeThreatTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThreatTypeGroup() {
		return threatTypeGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractCondition() {
		return abstractConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractCondition_Title() {
		return (EAttribute)abstractConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractCondition_AdditionalInfo() {
		return (EAttribute)abstractConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractCondition_Comments() {
		return (EAttribute)abstractConditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeCondition() {
		return compositeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCondition() {
		return conditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAndCompositeCondition() {
		return andCompositeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOrCompositeCondition() {
		return orCompositeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNotCompositeCondition() {
		return notCompositeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSingleCompositeCondition() {
		return singleCompositeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSingleCompositeCondition_Subcondition() {
		return (EReference)singleCompositeConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMultipleCompositeCondition() {
		return multipleCompositeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMultipleCompositeCondition_Subcondition() {
		return (EReference)multipleCompositeConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConditionList() {
		return conditionListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConditionList_Abstractcondition() {
		return (EReference)conditionListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAImportedCondition() {
		return aImportedConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImportedThreatCondition() {
		return importedThreatConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedThreatCondition_Threattype() {
		return (EReference)importedThreatConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImportedCondition() {
		return importedConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedCondition_Condition() {
		return (EReference)importedConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDFDElementAnnotation() {
		return dfdElementAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDFDElementAnnotation_Dfdelement() {
		return (EReference)dfdElementAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttackerModel() {
		return attackerModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttackerModel_AttackerProfiles() {
		return (EReference)attackerModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttackerProfile() {
		return attackerProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttackerProfile_ThreatCapability() {
		return (EReference)attackerProfileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttackerProfile_ProbabilityOfAction() {
		return (EReference)attackerProfileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttackerProfile_ContactFrequency() {
		return (EReference)attackerProfileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttackerProfile_Insider() {
		return (EReference)attackerProfileEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttackerProfile_Enabled() {
		return (EAttribute)attackerProfileEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getICharacteristic() {
		return iCharacteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataModel() {
		return dataModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataModel_DataModelElements() {
		return (EReference)dataModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataType_Sensitive() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransformedData() {
		return transformedDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformedData_DecKey() {
		return (EReference)transformedDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformedData_EncKey() {
		return (EReference)transformedDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformedData_Datatype() {
		return (EReference)transformedDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataModelElement() {
		return dataModelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataSubjectType() {
		return dataSubjectTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSubjectType_Personaldatatype() {
		return (EReference)dataSubjectTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSubjectType_Sensitivity() {
		return (EReference)dataSubjectTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSubjectType_NbrOfSubjects() {
		return (EReference)dataSubjectTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPersonalDataType() {
		return personalDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPersonalDataType_Sensitivity() {
		return (EReference)personalDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPersonalDataType_NbrOfRecords() {
		return (EReference)personalDataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPersonalDataType_Retention() {
		return (EReference)personalDataTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataSet() {
		return dataSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataSet_Datatype() {
		return (EReference)dataSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIModelElementAnnotation() {
		return iModelElementAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIModelElementAnnotation__GetAnnotation() {
		return iModelElementAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKVModelElementAnnotation() {
		return kvModelElementAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getKVModelElementAnnotation_Key() {
		return (EAttribute)kvModelElementAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getKVModelElementAnnotation_Value() {
		return (EAttribute)kvModelElementAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKVModelElementAnnotation__GetAnnotation() {
		return kvModelElementAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelElementAnnotation() {
		return modelElementAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelElementAnnotation_Value() {
		return (EAttribute)modelElementAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getModelElementAnnotation__GetAnnotation() {
		return modelElementAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThreatPattern() {
		return threatPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThreatPattern_LongDescription() {
		return (EAttribute)threatPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThreatPattern_Patterns() {
		return (EAttribute)threatPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatPattern_Mapping() {
		return (EReference)threatPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThreatTypeIDToEstimateMap() {
		return threatTypeIDToEstimateMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThreatTypeIDToEstimateMap_Value() {
		return (EReference)threatTypeIDToEstimateMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThreatTypeIDToEstimateMap_Key() {
		return (EAttribute)threatTypeIDToEstimateMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpartaModelFactory getSpartaModelFactory() {
		return (SpartaModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		dataFlowEClass = createEClass(DATA_FLOW);
		createEOperation(dataFlowEClass, DATA_FLOW___GET_DATA_FLOW);

		dataFlowEntityEClass = createEClass(DATA_FLOW_ENTITY);
		createEReference(dataFlowEntityEClass, DATA_FLOW_ENTITY__SEND);
		createEReference(dataFlowEntityEClass, DATA_FLOW_ENTITY__RECEIVE);

		externalEntityEClass = createEClass(EXTERNAL_ENTITY);

		processEClass = createEClass(PROCESS);

		dataStoreEClass = createEClass(DATA_STORE);

		dfdModelEClass = createEClass(DFD_MODEL);
		createEReference(dfdModelEClass, DFD_MODEL__CONTAINED_ELEMENTS);
		createEReference(dfdModelEClass, DFD_MODEL__RESOURCE);

		dfdElementEClass = createEClass(DFD_ELEMENT);
		createEReference(dfdElementEClass, DFD_ELEMENT__SECURITYANNOTATION);
		createEReference(dfdElementEClass, DFD_ELEMENT__DFDELEMENTANNOTATION);

		securityElementEClass = createEClass(SECURITY_ELEMENT);

		dfdBoundaryElementEClass = createEClass(DFD_BOUNDARY_ELEMENT);
		createEReference(dfdBoundaryElementEClass, DFD_BOUNDARY_ELEMENT__CROSSING_FLOWS);

		trustBoundaryContainerEClass = createEClass(TRUST_BOUNDARY_CONTAINER);

		senderSpecifiableEClass = createEClass(SENDER_SPECIFIABLE);
		createEReference(senderSpecifiableEClass, SENDER_SPECIFIABLE__SENDER_SPECIFIED_BY);
		createEReference(senderSpecifiableEClass, SENDER_SPECIFIABLE__SENDER);

		recipientSpecifiableEClass = createEClass(RECIPIENT_SPECIFIABLE);
		createEReference(recipientSpecifiableEClass, RECIPIENT_SPECIFIABLE__RECIPIENT_SPECIFIED_BY);
		createEReference(recipientSpecifiableEClass, RECIPIENT_SPECIFIABLE__RECIPIENT);

		senderSpecificationEClass = createEClass(SENDER_SPECIFICATION);
		createEReference(senderSpecificationEClass, SENDER_SPECIFICATION__SPECIFIES_SENDER_OF);
		createEOperation(senderSpecificationEClass, SENDER_SPECIFICATION___GET_DATA_FLOW);

		recipientSpecificationEClass = createEClass(RECIPIENT_SPECIFICATION);
		createEReference(recipientSpecificationEClass, RECIPIENT_SPECIFICATION__SPECIFIES_RECIPIENT_OF);
		createEOperation(recipientSpecificationEClass, RECIPIENT_SPECIFICATION___GET_DATA_FLOW);

		flowElementEClass = createEClass(FLOW_ELEMENT);
		createEOperation(flowElementEClass, FLOW_ELEMENT___GET_DATA_FLOW);

		dfdContainerEClass = createEClass(DFD_CONTAINER);
		createEReference(dfdContainerEClass, DFD_CONTAINER__CONTAINED_ELEMENTS);

		securityAnnotationEClass = createEClass(SECURITY_ANNOTATION);

		solutionTypeEClass = createEClass(SOLUTION_TYPE);
		createEReference(solutionTypeEClass, SOLUTION_TYPE__ROLES);
		createEReference(solutionTypeEClass, SOLUTION_TYPE__COUNTERMEASURE);

		roleEClass = createEClass(ROLE);
		createEReference(roleEClass, ROLE__SUBJECTED);
		createEAttribute(roleEClass, ROLE__BINDING_TYPES);

		abstractThreatTypeEClass = createEClass(ABSTRACT_THREAT_TYPE);
		createEAttribute(abstractThreatTypeEClass, ABSTRACT_THREAT_TYPE__ENABLED);
		createEReference(abstractThreatTypeEClass, ABSTRACT_THREAT_TYPE__PATTERNS);
		createEAttribute(abstractThreatTypeEClass, ABSTRACT_THREAT_TYPE__TITLE);
		createEAttribute(abstractThreatTypeEClass, ABSTRACT_THREAT_TYPE__ADDITIONAL_INFO);
		createEAttribute(abstractThreatTypeEClass, ABSTRACT_THREAT_TYPE__COMMENTS);
		createEReference(abstractThreatTypeEClass, ABSTRACT_THREAT_TYPE__CHARACTERISTIC);
		createEReference(abstractThreatTypeEClass, ABSTRACT_THREAT_TYPE__SUPER_THREAT_TYPE);

		counterMeasureEClass = createEClass(COUNTER_MEASURE);
		createEReference(counterMeasureEClass, COUNTER_MEASURE__MITIGATES);
		createEReference(counterMeasureEClass, COUNTER_MEASURE__SECURITYSUBOBJECTIVE);
		createEReference(counterMeasureEClass, COUNTER_MEASURE__SCOPE);
		createEReference(counterMeasureEClass, COUNTER_MEASURE__SUBJECT);
		createEReference(counterMeasureEClass, COUNTER_MEASURE__DIFFICULTY);
		createEAttribute(counterMeasureEClass, COUNTER_MEASURE__MITIGATED_THREAT_TYPE_ID);

		roleBindingEClass = createEClass(ROLE_BINDING);
		createEReference(roleBindingEClass, ROLE_BINDING__BINDS);
		createEReference(roleBindingEClass, ROLE_BINDING__BINDS_TO);

		solutionEClass = createEClass(SOLUTION);
		createEReference(solutionEClass, SOLUTION__SECURITYPATTERN);
		createEReference(solutionEClass, SOLUTION__ROLEBINDING);

		spartaResourceEClass = createEClass(SPARTA_RESOURCE);
		createEReference(spartaResourceEClass, SPARTA_RESOURCE__SECURITYANNOTATION);

		threatTypeCatalogEClass = createEClass(THREAT_TYPE_CATALOG);
		createEReference(threatTypeCatalogEClass, THREAT_TYPE_CATALOG__THREAT);
		createEReference(threatTypeCatalogEClass, THREAT_TYPE_CATALOG__THREATTYPEGROUP);
		createEReference(threatTypeCatalogEClass, THREAT_TYPE_CATALOG__CONDITIONLIST);
		createEAttribute(threatTypeCatalogEClass, THREAT_TYPE_CATALOG__IMPORTS);
		createEAttribute(threatTypeCatalogEClass, THREAT_TYPE_CATALOG__HELPER_PATTERNS);
		createEAttribute(threatTypeCatalogEClass, THREAT_TYPE_CATALOG__PACKAGE);
		createEReference(threatTypeCatalogEClass, THREAT_TYPE_CATALOG__PATTERN_DEPENDENCIES);

		solutionTypeCatalogEClass = createEClass(SOLUTION_TYPE_CATALOG);
		createEReference(solutionTypeCatalogEClass, SOLUTION_TYPE_CATALOG__SOLUTION_TYPES);

		eStringToEBooleanMapEClass = createEClass(ESTRING_TO_EBOOLEAN_MAP);
		createEAttribute(eStringToEBooleanMapEClass, ESTRING_TO_EBOOLEAN_MAP__KEY);
		createEAttribute(eStringToEBooleanMapEClass, ESTRING_TO_EBOOLEAN_MAP__VALUE);

		threatSpecificationEClass = createEClass(THREAT_SPECIFICATION);
		createEReference(threatSpecificationEClass, THREAT_SPECIFICATION__THREAT);
		createEAttribute(threatSpecificationEClass, THREAT_SPECIFICATION__ENABLED);
		createEReference(threatSpecificationEClass, THREAT_SPECIFICATION__TYPES);
		createEReference(threatSpecificationEClass, THREAT_SPECIFICATION__PATTERNS);

		threatSpecificationCatalogEClass = createEClass(THREAT_SPECIFICATION_CATALOG);
		createEReference(threatSpecificationCatalogEClass, THREAT_SPECIFICATION_CATALOG__THREATSPECIFICATIONS);

		assetEClass = createEClass(ASSET);
		createEReference(assetEClass, ASSET__LOSS_MAGNITUDE);
		createEReference(assetEClass, ASSET__ESTIMATES);
		createEReference(assetEClass, ASSET__BOUND);
		createEReference(assetEClass, ASSET__LOSS_MAGNITUDE_BY_ID);
		createEOperation(assetEClass, ASSET___GET_ESTIMATE__ABSTRACTTHREATTYPE);

		compositeThreatTypeEClass = createEClass(COMPOSITE_THREAT_TYPE);
		createEReference(compositeThreatTypeEClass, COMPOSITE_THREAT_TYPE__SUB_THREAT_TYPES);

		threatTypeEClass = createEClass(THREAT_TYPE);
		createEReference(threatTypeEClass, THREAT_TYPE__CONDITION);
		createEReference(threatTypeEClass, THREAT_TYPE__THREATPATTERN);
		createEOperation(threatTypeEClass, THREAT_TYPE___TO_STRING);
		createEOperation(threatTypeEClass, THREAT_TYPE___GET_THREAT_TYPE_ANCESTOR);

		estimateEClass = createEClass(ESTIMATE);
		createEAttribute(estimateEClass, ESTIMATE__MINIMUM);
		createEAttribute(estimateEClass, ESTIMATE__PROBABLE);
		createEAttribute(estimateEClass, ESTIMATE__MAXIMUM);
		createEAttribute(estimateEClass, ESTIMATE__CONFIDENCE);
		createEAttribute(estimateEClass, ESTIMATE__NAME);
		createEOperation(estimateEClass, ESTIMATE___GET_ESTIMATE_NAME);

		threatTypeToEstimateMapEClass = createEClass(THREAT_TYPE_TO_ESTIMATE_MAP);
		createEReference(threatTypeToEstimateMapEClass, THREAT_TYPE_TO_ESTIMATE_MAP__KEY);
		createEReference(threatTypeToEstimateMapEClass, THREAT_TYPE_TO_ESTIMATE_MAP__VALUE);

		eStringToEStringMapEClass = createEClass(ESTRING_TO_ESTRING_MAP);
		createEAttribute(eStringToEStringMapEClass, ESTRING_TO_ESTRING_MAP__KEY);
		createEAttribute(eStringToEStringMapEClass, ESTRING_TO_ESTRING_MAP__VALUE);

		modelElementEClass = createEClass(MODEL_ELEMENT);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__NAME);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__DESCRIPTION);
		createEReference(modelElementEClass, MODEL_ELEMENT__ANNOTATIONS);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__ID);

		orCompositeThreatTypeEClass = createEClass(OR_COMPOSITE_THREAT_TYPE);

		andCompositeThreatTypeEClass = createEClass(AND_COMPOSITE_THREAT_TYPE);

		threatTypeGroupEClass = createEClass(THREAT_TYPE_GROUP);

		abstractConditionEClass = createEClass(ABSTRACT_CONDITION);
		createEAttribute(abstractConditionEClass, ABSTRACT_CONDITION__TITLE);
		createEAttribute(abstractConditionEClass, ABSTRACT_CONDITION__ADDITIONAL_INFO);
		createEAttribute(abstractConditionEClass, ABSTRACT_CONDITION__COMMENTS);

		compositeConditionEClass = createEClass(COMPOSITE_CONDITION);

		conditionEClass = createEClass(CONDITION);

		andCompositeConditionEClass = createEClass(AND_COMPOSITE_CONDITION);

		orCompositeConditionEClass = createEClass(OR_COMPOSITE_CONDITION);

		notCompositeConditionEClass = createEClass(NOT_COMPOSITE_CONDITION);

		singleCompositeConditionEClass = createEClass(SINGLE_COMPOSITE_CONDITION);
		createEReference(singleCompositeConditionEClass, SINGLE_COMPOSITE_CONDITION__SUBCONDITION);

		multipleCompositeConditionEClass = createEClass(MULTIPLE_COMPOSITE_CONDITION);
		createEReference(multipleCompositeConditionEClass, MULTIPLE_COMPOSITE_CONDITION__SUBCONDITION);

		conditionListEClass = createEClass(CONDITION_LIST);
		createEReference(conditionListEClass, CONDITION_LIST__ABSTRACTCONDITION);

		aImportedConditionEClass = createEClass(AIMPORTED_CONDITION);

		importedThreatConditionEClass = createEClass(IMPORTED_THREAT_CONDITION);
		createEReference(importedThreatConditionEClass, IMPORTED_THREAT_CONDITION__THREATTYPE);

		importedConditionEClass = createEClass(IMPORTED_CONDITION);
		createEReference(importedConditionEClass, IMPORTED_CONDITION__CONDITION);

		dfdElementAnnotationEClass = createEClass(DFD_ELEMENT_ANNOTATION);
		createEReference(dfdElementAnnotationEClass, DFD_ELEMENT_ANNOTATION__DFDELEMENT);

		attackerModelEClass = createEClass(ATTACKER_MODEL);
		createEReference(attackerModelEClass, ATTACKER_MODEL__ATTACKER_PROFILES);

		attackerProfileEClass = createEClass(ATTACKER_PROFILE);
		createEReference(attackerProfileEClass, ATTACKER_PROFILE__THREAT_CAPABILITY);
		createEReference(attackerProfileEClass, ATTACKER_PROFILE__PROBABILITY_OF_ACTION);
		createEReference(attackerProfileEClass, ATTACKER_PROFILE__CONTACT_FREQUENCY);
		createEReference(attackerProfileEClass, ATTACKER_PROFILE__INSIDER);
		createEAttribute(attackerProfileEClass, ATTACKER_PROFILE__ENABLED);

		iCharacteristicEClass = createEClass(ICHARACTERISTIC);

		dataModelEClass = createEClass(DATA_MODEL);
		createEReference(dataModelEClass, DATA_MODEL__DATA_MODEL_ELEMENTS);

		dataTypeEClass = createEClass(DATA_TYPE);
		createEAttribute(dataTypeEClass, DATA_TYPE__SENSITIVE);

		transformedDataEClass = createEClass(TRANSFORMED_DATA);
		createEReference(transformedDataEClass, TRANSFORMED_DATA__DEC_KEY);
		createEReference(transformedDataEClass, TRANSFORMED_DATA__ENC_KEY);
		createEReference(transformedDataEClass, TRANSFORMED_DATA__DATATYPE);

		dataModelElementEClass = createEClass(DATA_MODEL_ELEMENT);

		dataSubjectTypeEClass = createEClass(DATA_SUBJECT_TYPE);
		createEReference(dataSubjectTypeEClass, DATA_SUBJECT_TYPE__PERSONALDATATYPE);
		createEReference(dataSubjectTypeEClass, DATA_SUBJECT_TYPE__SENSITIVITY);
		createEReference(dataSubjectTypeEClass, DATA_SUBJECT_TYPE__NBR_OF_SUBJECTS);

		personalDataTypeEClass = createEClass(PERSONAL_DATA_TYPE);
		createEReference(personalDataTypeEClass, PERSONAL_DATA_TYPE__SENSITIVITY);
		createEReference(personalDataTypeEClass, PERSONAL_DATA_TYPE__NBR_OF_RECORDS);
		createEReference(personalDataTypeEClass, PERSONAL_DATA_TYPE__RETENTION);

		dataSetEClass = createEClass(DATA_SET);
		createEReference(dataSetEClass, DATA_SET__DATATYPE);

		iModelElementAnnotationEClass = createEClass(IMODEL_ELEMENT_ANNOTATION);
		createEOperation(iModelElementAnnotationEClass, IMODEL_ELEMENT_ANNOTATION___GET_ANNOTATION);

		kvModelElementAnnotationEClass = createEClass(KV_MODEL_ELEMENT_ANNOTATION);
		createEAttribute(kvModelElementAnnotationEClass, KV_MODEL_ELEMENT_ANNOTATION__KEY);
		createEAttribute(kvModelElementAnnotationEClass, KV_MODEL_ELEMENT_ANNOTATION__VALUE);
		createEOperation(kvModelElementAnnotationEClass, KV_MODEL_ELEMENT_ANNOTATION___GET_ANNOTATION);

		modelElementAnnotationEClass = createEClass(MODEL_ELEMENT_ANNOTATION);
		createEAttribute(modelElementAnnotationEClass, MODEL_ELEMENT_ANNOTATION__VALUE);
		createEOperation(modelElementAnnotationEClass, MODEL_ELEMENT_ANNOTATION___GET_ANNOTATION);

		threatPatternEClass = createEClass(THREAT_PATTERN);
		createEAttribute(threatPatternEClass, THREAT_PATTERN__LONG_DESCRIPTION);
		createEAttribute(threatPatternEClass, THREAT_PATTERN__PATTERNS);
		createEReference(threatPatternEClass, THREAT_PATTERN__MAPPING);

		threatTypeIDToEstimateMapEClass = createEClass(THREAT_TYPE_ID_TO_ESTIMATE_MAP);
		createEReference(threatTypeIDToEstimateMapEClass, THREAT_TYPE_ID_TO_ESTIMATE_MAP__VALUE);
		createEAttribute(threatTypeIDToEstimateMapEClass, THREAT_TYPE_ID_TO_ESTIMATE_MAP__KEY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataFlowEClass.getESuperTypes().add(this.getSenderSpecifiable());
		dataFlowEClass.getESuperTypes().add(this.getRecipientSpecifiable());
		dataFlowEntityEClass.getESuperTypes().add(this.getDFDContainer());
		externalEntityEClass.getESuperTypes().add(this.getDataFlowEntity());
		processEClass.getESuperTypes().add(this.getDataFlowEntity());
		dataStoreEClass.getESuperTypes().add(this.getDataFlowEntity());
		dfdModelEClass.getESuperTypes().add(this.getSpartaResource());
		dfdElementEClass.getESuperTypes().add(this.getAsset());
		securityElementEClass.getESuperTypes().add(this.getModelElement());
		dfdBoundaryElementEClass.getESuperTypes().add(this.getDFDContainer());
		trustBoundaryContainerEClass.getESuperTypes().add(this.getDFDBoundaryElement());
		senderSpecifiableEClass.getESuperTypes().add(this.getFlowElement());
		recipientSpecifiableEClass.getESuperTypes().add(this.getFlowElement());
		senderSpecificationEClass.getESuperTypes().add(this.getSenderSpecifiable());
		recipientSpecificationEClass.getESuperTypes().add(this.getRecipientSpecifiable());
		flowElementEClass.getESuperTypes().add(this.getDFDElement());
		dfdContainerEClass.getESuperTypes().add(this.getDFDElement());
		securityAnnotationEClass.getESuperTypes().add(this.getSecurityElement());
		solutionTypeEClass.getESuperTypes().add(this.getSecurityElement());
		roleEClass.getESuperTypes().add(this.getSecurityElement());
		abstractThreatTypeEClass.getESuperTypes().add(this.getSecurityElement());
		counterMeasureEClass.getESuperTypes().add(this.getSecurityElement());
		roleBindingEClass.getESuperTypes().add(this.getSecurityElement());
		solutionEClass.getESuperTypes().add(this.getSecurityElement());
		spartaResourceEClass.getESuperTypes().add(this.getModelElement());
		threatTypeCatalogEClass.getESuperTypes().add(this.getSpartaResource());
		solutionTypeCatalogEClass.getESuperTypes().add(this.getSpartaResource());
		threatSpecificationEClass.getESuperTypes().add(this.getSecurityElement());
		threatSpecificationCatalogEClass.getESuperTypes().add(this.getSpartaResource());
		assetEClass.getESuperTypes().add(this.getModelElement());
		compositeThreatTypeEClass.getESuperTypes().add(this.getAbstractThreatType());
		threatTypeEClass.getESuperTypes().add(this.getAbstractThreatType());
		orCompositeThreatTypeEClass.getESuperTypes().add(this.getCompositeThreatType());
		andCompositeThreatTypeEClass.getESuperTypes().add(this.getCompositeThreatType());
		threatTypeGroupEClass.getESuperTypes().add(this.getOrCompositeThreatType());
		abstractConditionEClass.getESuperTypes().add(this.getSecurityElement());
		compositeConditionEClass.getESuperTypes().add(this.getAbstractCondition());
		conditionEClass.getESuperTypes().add(this.getAbstractCondition());
		andCompositeConditionEClass.getESuperTypes().add(this.getMultipleCompositeCondition());
		orCompositeConditionEClass.getESuperTypes().add(this.getMultipleCompositeCondition());
		notCompositeConditionEClass.getESuperTypes().add(this.getSingleCompositeCondition());
		singleCompositeConditionEClass.getESuperTypes().add(this.getCompositeCondition());
		multipleCompositeConditionEClass.getESuperTypes().add(this.getCompositeCondition());
		aImportedConditionEClass.getESuperTypes().add(this.getCondition());
		importedThreatConditionEClass.getESuperTypes().add(this.getAImportedCondition());
		importedConditionEClass.getESuperTypes().add(this.getAImportedCondition());
		attackerModelEClass.getESuperTypes().add(this.getSpartaResource());
		attackerProfileEClass.getESuperTypes().add(this.getSecurityElement());
		dataModelEClass.getESuperTypes().add(this.getSpartaResource());
		dataTypeEClass.getESuperTypes().add(this.getAsset());
		dataTypeEClass.getESuperTypes().add(this.getDataModelElement());
		transformedDataEClass.getESuperTypes().add(this.getDataType());
		dataModelElementEClass.getESuperTypes().add(this.getDFDElementAnnotation());
		dataSubjectTypeEClass.getESuperTypes().add(this.getDataModelElement());
		personalDataTypeEClass.getESuperTypes().add(this.getDataType());
		dataSetEClass.getESuperTypes().add(this.getDataModelElement());
		kvModelElementAnnotationEClass.getESuperTypes().add(this.getIModelElementAnnotation());
		modelElementAnnotationEClass.getESuperTypes().add(this.getIModelElementAnnotation());
		threatPatternEClass.getESuperTypes().add(this.getModelElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(dataFlowEClass, DataFlow.class, "DataFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDataFlow__GetDataFlow(), this.getDataFlow(), "getDataFlow", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataFlowEntityEClass, DataFlowEntity.class, "DataFlowEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlowEntity_Send(), this.getSenderSpecifiable(), this.getSenderSpecifiable_Sender(), "send", null, 0, -1, DataFlowEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataFlowEntity_Receive(), this.getRecipientSpecifiable(), this.getRecipientSpecifiable_Recipient(), "receive", null, 0, -1, DataFlowEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalEntityEClass, ExternalEntity.class, "ExternalEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processEClass, be.kuleuven.cs.distrinet.sparta.spartamodel.Process.class, "Process", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataStoreEClass, DataStore.class, "DataStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dfdModelEClass, DFDModel.class, "DFDModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDModel_ContainedElements(), this.getModelElement(), null, "containedElements", null, 0, -1, DFDModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDModel_Resource(), this.getSpartaResource(), null, "resource", null, 0, -1, DFDModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdElementEClass, DFDElement.class, "DFDElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDElement_Securityannotation(), this.getSecurityAnnotation(), null, "securityannotation", null, 0, -1, DFDElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDElement_Dfdelementannotation(), this.getDFDElementAnnotation(), this.getDFDElementAnnotation_Dfdelement(), "dfdelementannotation", null, 0, -1, DFDElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securityElementEClass, SecurityElement.class, "SecurityElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dfdBoundaryElementEClass, DFDBoundaryElement.class, "DFDBoundaryElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDBoundaryElement_CrossingFlows(), this.getDataFlow(), null, "crossingFlows", null, 0, -1, DFDBoundaryElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trustBoundaryContainerEClass, TrustBoundaryContainer.class, "TrustBoundaryContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(senderSpecifiableEClass, SenderSpecifiable.class, "SenderSpecifiable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSenderSpecifiable_SenderSpecifiedBy(), this.getSenderSpecification(), this.getSenderSpecification_SpecifiesSenderOf(), "senderSpecifiedBy", null, 0, 1, SenderSpecifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSenderSpecifiable_Sender(), this.getDataFlowEntity(), this.getDataFlowEntity_Send(), "sender", null, 1, 1, SenderSpecifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recipientSpecifiableEClass, RecipientSpecifiable.class, "RecipientSpecifiable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecipientSpecifiable_RecipientSpecifiedBy(), this.getRecipientSpecification(), this.getRecipientSpecification_SpecifiesRecipientOf(), "recipientSpecifiedBy", null, 0, 1, RecipientSpecifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecipientSpecifiable_Recipient(), this.getDataFlowEntity(), this.getDataFlowEntity_Receive(), "recipient", null, 1, 1, RecipientSpecifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(senderSpecificationEClass, SenderSpecification.class, "SenderSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSenderSpecification_SpecifiesSenderOf(), this.getSenderSpecifiable(), this.getSenderSpecifiable_SenderSpecifiedBy(), "specifiesSenderOf", null, 1, 1, SenderSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSenderSpecification__GetDataFlow(), this.getDataFlow(), "getDataFlow", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(recipientSpecificationEClass, RecipientSpecification.class, "RecipientSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecipientSpecification_SpecifiesRecipientOf(), this.getRecipientSpecifiable(), this.getRecipientSpecifiable_RecipientSpecifiedBy(), "specifiesRecipientOf", null, 1, 1, RecipientSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRecipientSpecification__GetDataFlow(), this.getDataFlow(), "getDataFlow", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(flowElementEClass, FlowElement.class, "FlowElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getFlowElement__GetDataFlow(), this.getDataFlow(), "getDataFlow", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dfdContainerEClass, DFDContainer.class, "DFDContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDContainer_ContainedElements(), this.getDFDElement(), null, "containedElements", null, 0, -1, DFDContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securityAnnotationEClass, SecurityAnnotation.class, "SecurityAnnotation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(solutionTypeEClass, SolutionType.class, "SolutionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolutionType_Roles(), this.getRole(), null, "roles", null, 0, -1, SolutionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolutionType_Countermeasure(), this.getCounterMeasure(), null, "countermeasure", null, 0, -1, SolutionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRole_Subjected(), this.getCounterMeasure(), this.getCounterMeasure_Subject(), "subjected", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(this.getDFDElement());
		g2.setEUpperBound(g3);
		initEAttribute(getRole_BindingTypes(), g1, "bindingTypes", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractThreatTypeEClass, AbstractThreatType.class, "AbstractThreatType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractThreatType_Enabled(), theXMLTypePackage.getBoolean(), "enabled", "true", 1, 1, AbstractThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractThreatType_Patterns(), this.getEStringToEBooleanMap(), null, "patterns", null, 0, -1, AbstractThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractThreatType_Title(), ecorePackage.getEString(), "title", null, 0, 1, AbstractThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractThreatType_AdditionalInfo(), ecorePackage.getEString(), "additionalInfo", null, 0, 1, AbstractThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractThreatType_Comments(), ecorePackage.getEString(), "comments", null, 0, 1, AbstractThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractThreatType_Characteristic(), this.getICharacteristic(), null, "characteristic", null, 0, -1, AbstractThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractThreatType_SuperThreatType(), this.getCompositeThreatType(), this.getCompositeThreatType_SubThreatTypes(), "superThreatType", null, 0, 1, AbstractThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(counterMeasureEClass, CounterMeasure.class, "CounterMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCounterMeasure_Mitigates(), this.getAbstractThreatType(), null, "mitigates", null, 0, -1, CounterMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCounterMeasure_Securitysubobjective(), this.getCounterMeasure(), null, "securitysubobjective", null, 0, -1, CounterMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCounterMeasure_Scope(), this.getRole(), null, "scope", null, 0, -1, CounterMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCounterMeasure_Subject(), this.getRole(), this.getRole_Subjected(), "subject", null, 0, -1, CounterMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCounterMeasure_Difficulty(), this.getEstimate(), null, "difficulty", null, 0, 1, CounterMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCounterMeasure_MitigatedThreatTypeID(), ecorePackage.getEString(), "mitigatedThreatTypeID", null, 0, -1, CounterMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleBindingEClass, RoleBinding.class, "RoleBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleBinding_Binds(), this.getRole(), null, "binds", null, 0, 1, RoleBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleBinding_BindsTo(), this.getAsset(), this.getAsset_Bound(), "bindsTo", null, 0, -1, RoleBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solutionEClass, Solution.class, "Solution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolution_Securitypattern(), this.getSolutionType(), null, "securitypattern", null, 0, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolution_Rolebinding(), this.getRoleBinding(), null, "rolebinding", null, 0, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spartaResourceEClass, SpartaResource.class, "SpartaResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpartaResource_Securityannotation(), this.getSecurityAnnotation(), null, "securityannotation", null, 0, -1, SpartaResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatTypeCatalogEClass, ThreatTypeCatalog.class, "ThreatTypeCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatTypeCatalog_Threat(), this.getAbstractThreatType(), null, "threat", null, 0, -1, ThreatTypeCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatTypeCatalog_Threattypegroup(), this.getThreatTypeGroup(), null, "threattypegroup", null, 0, -1, ThreatTypeCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatTypeCatalog_Conditionlist(), this.getConditionList(), null, "conditionlist", null, 0, -1, ThreatTypeCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatTypeCatalog_Imports(), ecorePackage.getEString(), "imports", null, 0, -1, ThreatTypeCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatTypeCatalog_HelperPatterns(), ecorePackage.getEString(), "helperPatterns", null, 0, -1, ThreatTypeCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatTypeCatalog_Package(), ecorePackage.getEString(), "package", null, 0, 1, ThreatTypeCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatTypeCatalog_PatternDependencies(), this.getThreatTypeCatalog(), null, "patternDependencies", null, 0, -1, ThreatTypeCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solutionTypeCatalogEClass, SolutionTypeCatalog.class, "SolutionTypeCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolutionTypeCatalog_SolutionTypes(), this.getSolutionType(), null, "solutionTypes", null, 0, -1, SolutionTypeCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToEBooleanMapEClass, Map.Entry.class, "EStringToEBooleanMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToEBooleanMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEStringToEBooleanMap_Value(), ecorePackage.getEBooleanObject(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatSpecificationEClass, ThreatSpecification.class, "ThreatSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatSpecification_Threat(), this.getAbstractThreatType(), null, "threat", null, 1, 1, ThreatSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatSpecification_Enabled(), theXMLTypePackage.getBoolean(), "enabled", "true", 1, 1, ThreatSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatSpecification_Types(), this.getEStringToEBooleanMap(), null, "types", null, 0, -1, ThreatSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatSpecification_Patterns(), this.getEStringToEBooleanMap(), null, "patterns", null, 0, -1, ThreatSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatSpecificationCatalogEClass, ThreatSpecificationCatalog.class, "ThreatSpecificationCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatSpecificationCatalog_Threatspecifications(), this.getThreatSpecification(), null, "threatspecifications", null, 0, -1, ThreatSpecificationCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assetEClass, Asset.class, "Asset", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAsset_LossMagnitude(), this.getThreatTypeToEstimateMap(), null, "lossMagnitude", null, 0, -1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAsset_Estimates(), this.getEstimate(), null, "estimates", null, 0, -1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAsset_Bound(), this.getRoleBinding(), this.getRoleBinding_BindsTo(), "bound", null, 0, -1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAsset_LossMagnitudeByID(), this.getThreatTypeIDToEstimateMap(), null, "lossMagnitudeByID", null, 0, -1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getAsset__GetEstimate__AbstractThreatType(), this.getEstimate(), "getEstimate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractThreatType(), "tt", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(compositeThreatTypeEClass, CompositeThreatType.class, "CompositeThreatType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeThreatType_SubThreatTypes(), this.getAbstractThreatType(), this.getAbstractThreatType_SuperThreatType(), "subThreatTypes", null, 0, -1, CompositeThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatTypeEClass, ThreatType.class, "ThreatType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatType_Condition(), this.getAbstractCondition(), null, "condition", null, 0, 1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatType_Threatpattern(), this.getThreatPattern(), null, "threatpattern", null, 0, -1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getThreatType__ToString(), theXMLTypePackage.getString(), "toString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getThreatType__GetThreatTypeAncestor(), this.getAbstractThreatType(), "getThreatTypeAncestor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(estimateEClass, Estimate.class, "Estimate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEstimate_Minimum(), ecorePackage.getEDouble(), "minimum", null, 0, 1, Estimate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEstimate_Probable(), ecorePackage.getEDouble(), "probable", null, 0, 1, Estimate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEstimate_Maximum(), ecorePackage.getEDouble(), "maximum", null, 0, 1, Estimate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEstimate_Confidence(), ecorePackage.getEDouble(), "confidence", null, 0, 1, Estimate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEstimate_Name(), ecorePackage.getEString(), "name", null, 0, 1, Estimate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEstimate__GetEstimateName(), theXMLTypePackage.getString(), "getEstimateName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(threatTypeToEstimateMapEClass, Map.Entry.class, "ThreatTypeToEstimateMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatTypeToEstimateMap_Key(), this.getThreatType(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatTypeToEstimateMap_Value(), this.getEstimate(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToEStringMapEClass, Map.Entry.class, "EStringToEStringMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToEStringMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEStringToEStringMap_Value(), ecorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementEClass, ModelElement.class, "ModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElement_Annotations(), this.getIModelElementAnnotation(), null, "annotations", null, 0, -1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElement_Id(), ecorePackage.getEString(), "id", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orCompositeThreatTypeEClass, OrCompositeThreatType.class, "OrCompositeThreatType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andCompositeThreatTypeEClass, AndCompositeThreatType.class, "AndCompositeThreatType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(threatTypeGroupEClass, ThreatTypeGroup.class, "ThreatTypeGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractConditionEClass, AbstractCondition.class, "AbstractCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractCondition_Title(), ecorePackage.getEString(), "title", null, 0, 1, AbstractCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractCondition_AdditionalInfo(), ecorePackage.getEString(), "additionalInfo", null, 0, 1, AbstractCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractCondition_Comments(), ecorePackage.getEString(), "comments", null, 0, 1, AbstractCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeConditionEClass, CompositeCondition.class, "CompositeCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionEClass, Condition.class, "Condition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andCompositeConditionEClass, AndCompositeCondition.class, "AndCompositeCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orCompositeConditionEClass, OrCompositeCondition.class, "OrCompositeCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notCompositeConditionEClass, NotCompositeCondition.class, "NotCompositeCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(singleCompositeConditionEClass, SingleCompositeCondition.class, "SingleCompositeCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleCompositeCondition_Subcondition(), this.getAbstractCondition(), null, "subcondition", null, 1, 1, SingleCompositeCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleCompositeConditionEClass, MultipleCompositeCondition.class, "MultipleCompositeCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultipleCompositeCondition_Subcondition(), this.getAbstractCondition(), null, "subcondition", null, 1, -1, MultipleCompositeCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionListEClass, ConditionList.class, "ConditionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionList_Abstractcondition(), this.getAbstractCondition(), null, "abstractcondition", null, 0, -1, ConditionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aImportedConditionEClass, AImportedCondition.class, "AImportedCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(importedThreatConditionEClass, ImportedThreatCondition.class, "ImportedThreatCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImportedThreatCondition_Threattype(), this.getThreatType(), null, "threattype", null, 1, 1, ImportedThreatCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importedConditionEClass, ImportedCondition.class, "ImportedCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImportedCondition_Condition(), this.getAbstractCondition(), null, "condition", null, 1, 1, ImportedCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdElementAnnotationEClass, DFDElementAnnotation.class, "DFDElementAnnotation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDElementAnnotation_Dfdelement(), this.getDFDElement(), this.getDFDElement_Dfdelementannotation(), "dfdelement", null, 0, -1, DFDElementAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attackerModelEClass, AttackerModel.class, "AttackerModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttackerModel_AttackerProfiles(), this.getAttackerProfile(), null, "attackerProfiles", null, 0, -1, AttackerModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attackerProfileEClass, AttackerProfile.class, "AttackerProfile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttackerProfile_ThreatCapability(), this.getEstimate(), null, "threatCapability", null, 1, 1, AttackerProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackerProfile_ProbabilityOfAction(), this.getEstimate(), null, "probabilityOfAction", null, 1, 1, AttackerProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackerProfile_ContactFrequency(), this.getEstimate(), null, "contactFrequency", null, 1, 1, AttackerProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackerProfile_Insider(), this.getDFDElement(), null, "insider", null, 0, -1, AttackerProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackerProfile_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 1, 1, AttackerProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iCharacteristicEClass, ICharacteristic.class, "ICharacteristic", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataModelEClass, DataModel.class, "DataModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataModel_DataModelElements(), this.getDataModelElement(), null, "dataModelElements", null, 0, -1, DataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataType_Sensitive(), theXMLTypePackage.getBoolean(), "sensitive", "false", 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformedDataEClass, TransformedData.class, "TransformedData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformedData_DecKey(), this.getDataType(), null, "decKey", null, 0, 1, TransformedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformedData_EncKey(), this.getDataType(), null, "encKey", null, 0, 1, TransformedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformedData_Datatype(), this.getDataType(), null, "datatype", null, 1, 1, TransformedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataModelElementEClass, DataModelElement.class, "DataModelElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataSubjectTypeEClass, DataSubjectType.class, "DataSubjectType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSubjectType_Personaldatatype(), this.getPersonalDataType(), null, "personaldatatype", null, 0, -1, DataSubjectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSubjectType_Sensitivity(), this.getEstimate(), null, "sensitivity", null, 1, 1, DataSubjectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSubjectType_NbrOfSubjects(), this.getEstimate(), null, "nbrOfSubjects", null, 1, 1, DataSubjectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personalDataTypeEClass, PersonalDataType.class, "PersonalDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPersonalDataType_Sensitivity(), this.getEstimate(), null, "sensitivity", null, 1, 1, PersonalDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonalDataType_NbrOfRecords(), this.getEstimate(), null, "nbrOfRecords", null, 1, 1, PersonalDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonalDataType_Retention(), this.getEstimate(), null, "retention", null, 1, 1, PersonalDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataSetEClass, DataSet.class, "DataSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSet_Datatype(), this.getDataType(), null, "datatype", null, 0, -1, DataSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iModelElementAnnotationEClass, IModelElementAnnotation.class, "IModelElementAnnotation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getIModelElementAnnotation__GetAnnotation(), ecorePackage.getEString(), "getAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(kvModelElementAnnotationEClass, KVModelElementAnnotation.class, "KVModelElementAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKVModelElementAnnotation_Key(), ecorePackage.getEString(), "key", null, 1, 1, KVModelElementAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKVModelElementAnnotation_Value(), ecorePackage.getEString(), "value", null, 1, 1, KVModelElementAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getKVModelElementAnnotation__GetAnnotation(), ecorePackage.getEString(), "getAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelElementAnnotationEClass, ModelElementAnnotation.class, "ModelElementAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElementAnnotation_Value(), ecorePackage.getEString(), "value", null, 1, 1, ModelElementAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelElementAnnotation__GetAnnotation(), ecorePackage.getEString(), "getAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(threatPatternEClass, ThreatPattern.class, "ThreatPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThreatPattern_LongDescription(), ecorePackage.getEString(), "longDescription", null, 0, -1, ThreatPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatPattern_Patterns(), ecorePackage.getEString(), "patterns", null, 0, -1, ThreatPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatPattern_Mapping(), this.getEStringToEStringMap(), null, "mapping", null, 0, -1, ThreatPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatTypeIDToEstimateMapEClass, Map.Entry.class, "ThreatTypeIDToEstimateMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatTypeIDToEstimateMap_Value(), this.getEstimate(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatTypeIDToEstimateMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SpartaModelPackageImpl
