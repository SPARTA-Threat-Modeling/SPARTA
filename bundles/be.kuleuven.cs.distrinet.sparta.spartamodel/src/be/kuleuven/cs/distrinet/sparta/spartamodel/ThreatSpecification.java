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

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Threat Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getThreat <em>Threat</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getTypes <em>Types</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getPatterns <em>Patterns</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatSpecification()
 * @model
 * @generated
 */
public interface ThreatSpecification extends SecurityElement {
	/**
	 * Returns the value of the '<em><b>Threat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threat</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threat</em>' reference.
	 * @see #setThreat(AbstractThreatType)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatSpecification_Threat()
	 * @model required="true"
	 * @generated
	 */
	AbstractThreatType getThreat();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#getThreat <em>Threat</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threat</em>' reference.
	 * @see #getThreat()
	 * @generated
	 */
	void setThreat(AbstractThreatType value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatSpecification_Enabled()
	 * @model default="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecification#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Types</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Boolean},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' map.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatSpecification_Types()
	 * @model mapType="be.kuleuven.cs.distrinet.sparta.spartamodel.EStringToEBooleanMap&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EBooleanObject&gt;"
	 * @generated
	 */
	EMap<String, Boolean> getTypes();

	/**
	 * Returns the value of the '<em><b>Patterns</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Boolean},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Patterns</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Patterns</em>' map.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getThreatSpecification_Patterns()
	 * @model mapType="be.kuleuven.cs.distrinet.sparta.spartamodel.EStringToEBooleanMap&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EBooleanObject&gt;"
	 * @generated
	 */
	EMap<String, Boolean> getPatterns();

} // ThreatSpecification
