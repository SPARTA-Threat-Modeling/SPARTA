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

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog;

/**
 * This is the item provider adapter for a {@link be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ThreatTypeCatalogItemProvider extends SpartaResourceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatTypeCatalogItemProvider(AdapterFactory adapterFactory) {
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

			addImportsPropertyDescriptor(object);
			addHelperPatternsPropertyDescriptor(object);
			addPackagePropertyDescriptor(object);
			addPatternDependenciesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Imports feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThreatTypeCatalog_imports_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThreatTypeCatalog_imports_feature", "_UI_ThreatTypeCatalog_type"),
				 SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__IMPORTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Helper Patterns feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHelperPatternsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThreatTypeCatalog_helperPatterns_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThreatTypeCatalog_helperPatterns_feature", "_UI_ThreatTypeCatalog_type"),
				 SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__HELPER_PATTERNS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThreatTypeCatalog_package_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThreatTypeCatalog_package_feature", "_UI_ThreatTypeCatalog_type"),
				 SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__PACKAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pattern Dependencies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPatternDependenciesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ThreatTypeCatalog_patternDependencies_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ThreatTypeCatalog_patternDependencies_feature", "_UI_ThreatTypeCatalog_type"),
				 SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__PATTERN_DEPENDENCIES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__THREAT);
			childrenFeatures.add(SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__THREATTYPEGROUP);
			childrenFeatures.add(SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__CONDITIONLIST);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ThreatTypeCatalog.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ThreatTypeCatalog"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ThreatTypeCatalog)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ThreatTypeCatalog_type") :
			getString("_UI_ThreatTypeCatalog_type") + " " + label;
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

		switch (notification.getFeatureID(ThreatTypeCatalog.class)) {
			case SpartaModelPackage.THREAT_TYPE_CATALOG__IMPORTS:
			case SpartaModelPackage.THREAT_TYPE_CATALOG__HELPER_PATTERNS:
			case SpartaModelPackage.THREAT_TYPE_CATALOG__PACKAGE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREAT:
			case SpartaModelPackage.THREAT_TYPE_CATALOG__THREATTYPEGROUP:
			case SpartaModelPackage.THREAT_TYPE_CATALOG__CONDITIONLIST:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__THREAT,
				 SpartaModelFactory.eINSTANCE.createThreatType()));

		newChildDescriptors.add
			(createChildParameter
				(SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__THREAT,
				 SpartaModelFactory.eINSTANCE.createOrCompositeThreatType()));

		newChildDescriptors.add
			(createChildParameter
				(SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__THREAT,
				 SpartaModelFactory.eINSTANCE.createAndCompositeThreatType()));

		newChildDescriptors.add
			(createChildParameter
				(SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__THREAT,
				 SpartaModelFactory.eINSTANCE.createThreatTypeGroup()));

		newChildDescriptors.add
			(createChildParameter
				(SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__THREATTYPEGROUP,
				 SpartaModelFactory.eINSTANCE.createThreatTypeGroup()));

		newChildDescriptors.add
			(createChildParameter
				(SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__CONDITIONLIST,
				 SpartaModelFactory.eINSTANCE.createConditionList()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__THREAT ||
			childFeature == SpartaModelPackage.Literals.THREAT_TYPE_CATALOG__THREATTYPEGROUP;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
