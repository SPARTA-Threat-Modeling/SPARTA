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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imported Threat Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition#getThreattype <em>Threattype</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getImportedThreatCondition()
 * @model
 * @generated
 */
public interface ImportedThreatCondition extends AImportedCondition {
	/**
	 * Returns the value of the '<em><b>Threattype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threattype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threattype</em>' reference.
	 * @see #setThreattype(ThreatType)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getImportedThreatCondition_Threattype()
	 * @model required="true"
	 * @generated
	 */
	ThreatType getThreattype();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ImportedThreatCondition#getThreattype <em>Threattype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threattype</em>' reference.
	 * @see #getThreattype()
	 * @generated
	 */
	void setThreattype(ThreatType value);

} // ImportedThreatCondition
