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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Threat Type Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getThreat <em>Threat</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getThreattypegroup <em>Threattypegroup</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getConditionlist <em>Conditionlist</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getImports <em>Imports</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getHelperPatterns <em>Helper Patterns</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getPackage <em>Package</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getPatternDependencies <em>Pattern Dependencies</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatTypeCatalog()
 * @model
 * @generated
 */
public interface ThreatTypeCatalog extends SpartaResource {
	/**
	 * Returns the value of the '<em><b>Threat</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threat</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threat</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatTypeCatalog_Threat()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractThreatType> getThreat();

	/**
	 * Returns the value of the '<em><b>Threattypegroup</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threattypegroup</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatTypeCatalog_Threattypegroup()
	 * @model containment="true"
	 * @generated
	 */
	EList<ThreatTypeGroup> getThreattypegroup();

	/**
	 * Returns the value of the '<em><b>Conditionlist</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.ConditionList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditionlist</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditionlist</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatTypeCatalog_Conditionlist()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConditionList> getConditionlist();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' attribute list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatTypeCatalog_Imports()
	 * @model
	 * @generated
	 */
	EList<String> getImports();

	/**
	 * Returns the value of the '<em><b>Helper Patterns</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helper Patterns</em>' attribute list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatTypeCatalog_HelperPatterns()
	 * @model
	 * @generated
	 */
	EList<String> getHelperPatterns();

	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute.
	 * @see #setPackage(String)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatTypeCatalog_Package()
	 * @model
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

	/**
	 * Returns the value of the '<em><b>Pattern Dependencies</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Dependencies</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatTypeCatalog_PatternDependencies()
	 * @model
	 * @generated
	 */
	EList<ThreatTypeCatalog> getPatternDependencies();

} // ThreatTypeCatalog
