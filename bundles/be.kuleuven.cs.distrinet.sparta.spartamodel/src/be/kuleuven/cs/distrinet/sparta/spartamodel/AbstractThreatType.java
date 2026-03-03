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
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Threat Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getPatterns <em>Patterns</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getTitle <em>Title</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getAdditionalInfo <em>Additional Info</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getComments <em>Comments</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getCharacteristic <em>Characteristic</em>}</li>
 *   <li>{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getSuperThreatType <em>Super Threat Type</em>}</li>
 * </ul>
 *
 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAbstractThreatType()
 * @model abstract="true"
 * @generated
 */
public interface AbstractThreatType extends SecurityElement {
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
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAbstractThreatType_Enabled()
	 * @model default="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

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
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAbstractThreatType_Patterns()
	 * @model mapType="be.kuleuven.cs.distrinet.sparta.spartamodel.EStringToEBooleanMap&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EBooleanObject&gt;"
	 * @generated
	 */
	EMap<String, Boolean> getPatterns();

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAbstractThreatType_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Additional Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Info</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Info</em>' attribute.
	 * @see #setAdditionalInfo(String)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAbstractThreatType_AdditionalInfo()
	 * @model
	 * @generated
	 */
	String getAdditionalInfo();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getAdditionalInfo <em>Additional Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Additional Info</em>' attribute.
	 * @see #getAdditionalInfo()
	 * @generated
	 */
	void setAdditionalInfo(String value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' attribute.
	 * @see #setComments(String)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAbstractThreatType_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Characteristic</b></em>' containment reference list.
	 * The list contents are of type {@link be.kuleuven.cs.distrinet.sparta.spartamodel.ICharacteristic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characteristic</em>' containment reference list.
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAbstractThreatType_Characteristic()
	 * @model containment="true"
	 * @generated
	 */
	EList<ICharacteristic> getCharacteristic();

	/**
	 * Returns the value of the '<em><b>Super Threat Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType#getSubThreatTypes <em>Sub Threat Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Threat Type</em>' container reference.
	 * @see #setSuperThreatType(CompositeThreatType)
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage#getAbstractThreatType_SuperThreatType()
	 * @see be.kuleuven.cs.distrinet.sparta.spartamodel.CompositeThreatType#getSubThreatTypes
	 * @model opposite="subThreatTypes" transient="false" derived="true"
	 * @generated
	 */
	CompositeThreatType getSuperThreatType();

	/**
	 * Sets the value of the '{@link be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType#getSuperThreatType <em>Super Threat Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Threat Type</em>' container reference.
	 * @see #getSuperThreatType()
	 * @generated
	 */
	void setSuperThreatType(CompositeThreatType value);

} // AbstractThreatType
