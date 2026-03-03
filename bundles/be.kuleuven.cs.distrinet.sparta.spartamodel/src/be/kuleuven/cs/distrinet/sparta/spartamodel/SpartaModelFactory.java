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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage
 * @generated
 */
public interface SpartaModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpartaModelFactory eINSTANCE = be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Flow</em>'.
	 * @generated
	 */
	DataFlow createDataFlow();

	/**
	 * Returns a new object of class '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Entity</em>'.
	 * @generated
	 */
	ExternalEntity createExternalEntity();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	Process createProcess();

	/**
	 * Returns a new object of class '<em>Data Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Store</em>'.
	 * @generated
	 */
	DataStore createDataStore();

	/**
	 * Returns a new object of class '<em>DFD Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD Model</em>'.
	 * @generated
	 */
	DFDModel createDFDModel();

	/**
	 * Returns a new object of class '<em>Trust Boundary Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trust Boundary Container</em>'.
	 * @generated
	 */
	TrustBoundaryContainer createTrustBoundaryContainer();

	/**
	 * Returns a new object of class '<em>Sender Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sender Specification</em>'.
	 * @generated
	 */
	SenderSpecification createSenderSpecification();

	/**
	 * Returns a new object of class '<em>Recipient Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recipient Specification</em>'.
	 * @generated
	 */
	RecipientSpecification createRecipientSpecification();

	/**
	 * Returns a new object of class '<em>Solution Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solution Type</em>'.
	 * @generated
	 */
	SolutionType createSolutionType();

	/**
	 * Returns a new object of class '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role</em>'.
	 * @generated
	 */
	Role createRole();
	
	Role createRole(@SuppressWarnings("unchecked") Class<? extends DFDElement>... types);

	/**
	 * Returns a new object of class '<em>Counter Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Counter Measure</em>'.
	 * @generated
	 */
	CounterMeasure createCounterMeasure();

	/**
	 * Returns a new object of class '<em>Role Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Binding</em>'.
	 * @generated
	 */
	RoleBinding createRoleBinding();

	/**
	 * Returns a new object of class '<em>Solution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solution</em>'.
	 * @generated
	 */
	Solution createSolution();

	/**
	 * Returns a new object of class '<em>Threat Type Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threat Type Catalog</em>'.
	 * @generated
	 */
	ThreatTypeCatalog createThreatTypeCatalog();

	/**
	 * Returns a new object of class '<em>Solution Type Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solution Type Catalog</em>'.
	 * @generated
	 */
	SolutionTypeCatalog createSolutionTypeCatalog();

	/**
	 * Returns a new object of class '<em>Threat Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threat Specification</em>'.
	 * @generated
	 */
	ThreatSpecification createThreatSpecification();

	/**
	 * Returns a new object of class '<em>Threat Specification Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threat Specification Catalog</em>'.
	 * @generated
	 */
	ThreatSpecificationCatalog createThreatSpecificationCatalog();

	/**
	 * Returns a new object of class '<em>Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threat Type</em>'.
	 * @generated
	 */
	ThreatType createThreatType();

	/**
	 * Returns a new object of class '<em>Estimate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Estimate</em>'.
	 * @generated
	 */
	Estimate createEstimate();

	/**
	 * Returns a new object of class '<em>Or Composite Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Composite Threat Type</em>'.
	 * @generated
	 */
	OrCompositeThreatType createOrCompositeThreatType();

	/**
	 * Returns a new object of class '<em>And Composite Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Composite Threat Type</em>'.
	 * @generated
	 */
	AndCompositeThreatType createAndCompositeThreatType();

	/**
	 * Returns a new object of class '<em>Threat Type Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threat Type Group</em>'.
	 * @generated
	 */
	ThreatTypeGroup createThreatTypeGroup();

	/**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated
	 */
	Condition createCondition();

	/**
	 * Returns a new object of class '<em>And Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Composite Condition</em>'.
	 * @generated
	 */
	AndCompositeCondition createAndCompositeCondition();

	/**
	 * Returns a new object of class '<em>Or Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Composite Condition</em>'.
	 * @generated
	 */
	OrCompositeCondition createOrCompositeCondition();

	/**
	 * Returns a new object of class '<em>Not Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Composite Condition</em>'.
	 * @generated
	 */
	NotCompositeCondition createNotCompositeCondition();

	/**
	 * Returns a new object of class '<em>Condition List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition List</em>'.
	 * @generated
	 */
	ConditionList createConditionList();

	/**
	 * Returns a new object of class '<em>Imported Threat Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imported Threat Condition</em>'.
	 * @generated
	 */
	ImportedThreatCondition createImportedThreatCondition();

	/**
	 * Returns a new object of class '<em>Imported Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imported Condition</em>'.
	 * @generated
	 */
	ImportedCondition createImportedCondition();

	/**
	 * Returns a new object of class '<em>Attacker Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attacker Model</em>'.
	 * @generated
	 */
	AttackerModel createAttackerModel();

	/**
	 * Returns a new object of class '<em>Attacker Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attacker Profile</em>'.
	 * @generated
	 */
	AttackerProfile createAttackerProfile();

	/**
	 * Returns a new object of class '<em>Data Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Model</em>'.
	 * @generated
	 */
	DataModel createDataModel();

	/**
	 * Returns a new object of class '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type</em>'.
	 * @generated
	 */
	DataType createDataType();

	/**
	 * Returns a new object of class '<em>Transformed Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformed Data</em>'.
	 * @generated
	 */
	TransformedData createTransformedData();

	/**
	 * Returns a new object of class '<em>Data Subject Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Subject Type</em>'.
	 * @generated
	 */
	DataSubjectType createDataSubjectType();

	/**
	 * Returns a new object of class '<em>Personal Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Personal Data Type</em>'.
	 * @generated
	 */
	PersonalDataType createPersonalDataType();

	/**
	 * Returns a new object of class '<em>Data Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Set</em>'.
	 * @generated
	 */
	DataSet createDataSet();

	/**
	 * Returns a new object of class '<em>KV Model Element Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>KV Model Element Annotation</em>'.
	 * @generated
	 */
	KVModelElementAnnotation createKVModelElementAnnotation();

	/**
	 * Returns a new object of class '<em>Model Element Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element Annotation</em>'.
	 * @generated
	 */
	ModelElementAnnotation createModelElementAnnotation();

	/**
	 * Returns a new object of class '<em>Threat Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threat Pattern</em>'.
	 * @generated
	 */
	ThreatPattern createThreatPattern();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SpartaModelPackage getSpartaModelPackage();

} //SpartaModelFactory
