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
package be.kuleuven.cs.distrinet.sparta.spartamodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AttackerProfile;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataSubjectType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.PersonalDataType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * This is the item provider adapter for a {@link be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EstimateItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EstimateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addMinimumPropertyDescriptor(object);
			addProbablePropertyDescriptor(object);
			addMaximumPropertyDescriptor(object);
			addConfidencePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Minimum feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinimumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Estimate_minimum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Estimate_minimum_feature", "_UI_Estimate_type"),
				 SpartaModelPackage.Literals.ESTIMATE__MINIMUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Probable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProbablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Estimate_probable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Estimate_probable_feature", "_UI_Estimate_type"),
				 SpartaModelPackage.Literals.ESTIMATE__PROBABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Estimate_maximum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Estimate_maximum_feature", "_UI_Estimate_type"),
				 SpartaModelPackage.Literals.ESTIMATE__MAXIMUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Confidence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfidencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Estimate_confidence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Estimate_confidence_feature", "_UI_Estimate_type"),
				 SpartaModelPackage.Literals.ESTIMATE__CONFIDENCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Estimate_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Estimate_name_feature", "_UI_Estimate_type"),
				 SpartaModelPackage.Literals.ESTIMATE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Estimate.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/Estimate.png"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Estimate estimate = (Estimate)object;
		if (estimate.eContainer() instanceof AttackerProfile) {
			AttackerProfile a = (AttackerProfile) estimate.eContainer();
			if (a.getContactFrequency() != null && a.getContactFrequency().equals(estimate)) {
				return "Contact Frequency: " + getString("_UI_Estimate_type") + " " + estimate.getEstimateName();
			} else if (a.getProbabilityOfAction() != null && a.getProbabilityOfAction().equals(estimate)) {
				return "Probability of Action: " + getString("_UI_Estimate_type") + " " + estimate.getEstimateName();
			} else if (a.getThreatCapability() != null && a.getThreatCapability().equals(estimate)) {
				return "Threat Capability: " + getString("_UI_Estimate_type") + " " + estimate.getEstimateName();
			}
		} else if (estimate.eContainer() instanceof PersonalDataType) {
			PersonalDataType a = (PersonalDataType) estimate.eContainer();
			if (a.getNbrOfRecords() != null && a.getNbrOfRecords().equals(estimate)) {
				return "Number of Records: " + getString("_UI_Estimate_type") + " " + estimate.getEstimateName();
			} else if (a.getSensitivity() != null && a.getSensitivity().equals(estimate)) {
				return "Sensitivity: " + getString("_UI_Estimate_type") + " " + estimate.getEstimateName();
			} else if (a.getRetention() != null && a.getRetention().equals(estimate)) {
				return "Retention: " + getString("_UI_Estimate_type") + " " + estimate.getEstimateName();
			}
		} else if (estimate.eContainer() instanceof DataSubjectType) {
			DataSubjectType a = (DataSubjectType) estimate.eContainer();
			if (a.getNbrOfSubjects() != null && a.getNbrOfSubjects().equals(estimate)) {
				return "Number of Subjects: " + getString("_UI_Estimate_type") + " " + estimate.getEstimateName();
			} else if (a.getSensitivity() != null && a.getSensitivity().equals(estimate)) {
				return "Sensitivity: " + getString("_UI_Estimate_type") + " " + estimate.getEstimateName();
			}
		}
		return getString("_UI_Estimate_type") + " " + estimate.getEstimateName();
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Estimate.class)) {
			case SpartaModelPackage.ESTIMATE__MINIMUM:
			case SpartaModelPackage.ESTIMATE__PROBABLE:
			case SpartaModelPackage.ESTIMATE__MAXIMUM:
			case SpartaModelPackage.ESTIMATE__CONFIDENCE:
			case SpartaModelPackage.ESTIMATE__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ((IChildCreationExtender)adapterFactory).getResourceLocator();
	}

}
