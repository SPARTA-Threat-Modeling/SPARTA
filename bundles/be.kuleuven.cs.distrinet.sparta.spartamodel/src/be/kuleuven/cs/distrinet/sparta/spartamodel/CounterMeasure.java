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
 * A representation of the model object '<em><b>Counter Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getMitigates <em>Mitigates</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getSecuritysubobjective <em>Securitysubobjective</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getScope <em>Scope</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getSubject <em>Subject</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getDifficulty <em>Difficulty</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getMitigatedThreatTypeID <em>Mitigated Threat Type ID</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getCounterMeasure()
 * @model
 * @generated
 */
public interface CounterMeasure extends SecurityElement {
	/**
	 * Returns the value of the '<em><b>Mitigates</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mitigates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mitigates</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getCounterMeasure_Mitigates()
	 * @model
	 * @generated
	 */
	EList<AbstractThreatType> getMitigates();

	/**
	 * Returns the value of the '<em><b>Securitysubobjective</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Securitysubobjective</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Securitysubobjective</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getCounterMeasure_Securitysubobjective()
	 * @model containment="true"
	 * @generated
	 */
	EList<CounterMeasure> getSecuritysubobjective();

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getCounterMeasure_Scope()
	 * @model
	 * @generated
	 */
	EList<Role> getScope();

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.Role}.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.Role#getSubjected <em>Subjected</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getCounterMeasure_Subject()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.Role#getSubjected
	 * @model opposite="subjected"
	 * @generated
	 */
	EList<Role> getSubject();

	/**
	 * Returns the value of the '<em><b>Difficulty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Difficulty</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Difficulty</em>' containment reference.
	 * @see #setDifficulty(Estimate)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getCounterMeasure_Difficulty()
	 * @model containment="true"
	 * @generated
	 */
	Estimate getDifficulty();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure#getDifficulty <em>Difficulty</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Difficulty</em>' containment reference.
	 * @see #getDifficulty()
	 * @generated
	 */
	void setDifficulty(Estimate value);

	/**
	 * Returns the value of the '<em><b>Mitigated Threat Type ID</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mitigated Threat Type ID</em>' attribute list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getCounterMeasure_MitigatedThreatTypeID()
	 * @model
	 * @generated
	 */
	EList<String> getMitigatedThreatTypeID();

} // CounterMeasure
