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
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Role;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;

/**
 * This is the item provider adapter for a {@link be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class SolutionTypeItemProvider extends SecurityElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SolutionTypeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SpartaModelPackage.Literals.SOLUTION_TYPE__ROLES);
			childrenFeatures.add(SpartaModelPackage.Literals.SOLUTION_TYPE__COUNTERMEASURE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SolutionType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SolutionType_type") :
			getString("_UI_SolutionType_type") + " " + label;
	}
	
	

	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/SolutionType.png"));
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SolutionType.class)) {
			case SpartaModelPackage.SOLUTION_TYPE__ROLES:
			case SpartaModelPackage.SOLUTION_TYPE__COUNTERMEASURE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing
	 * the children that can be created under this object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(SpartaModelPackage.Literals.SOLUTION_TYPE__ROLES,
				SpartaModelFactory.eINSTANCE.createRole(Process.class)));

		newChildDescriptors.add(createChildParameter(SpartaModelPackage.Literals.SOLUTION_TYPE__ROLES,
				SpartaModelFactory.eINSTANCE.createRole(DataFlow.class)));

		newChildDescriptors.add(createChildParameter(SpartaModelPackage.Literals.SOLUTION_TYPE__ROLES,
				SpartaModelFactory.eINSTANCE.createRole(DataStore.class)));

		newChildDescriptors.add(createChildParameter(SpartaModelPackage.Literals.SOLUTION_TYPE__ROLES,
				SpartaModelFactory.eINSTANCE.createRole(ExternalEntity.class)));

		newChildDescriptors.add(createChildParameter(SpartaModelPackage.Literals.SOLUTION_TYPE__ROLES,
				SpartaModelFactory.eINSTANCE.createRole(DataFlowEntity.class)));

		newChildDescriptors.add(createChildParameter(SpartaModelPackage.Literals.SOLUTION_TYPE__COUNTERMEASURE,
				SpartaModelFactory.eINSTANCE.createCounterMeasure()));
	}

	/**
	 * This returns the label text for
	 * {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		if (feature == SpartaModelPackage.Literals.SOLUTION_TYPE__ROLES) {
			EList<Class<? extends DFDElement>> bt = ((Role) child).getBindingTypes();
			if (bt.size() == 1) {
				return "New " + bt.get(0).getSimpleName() + " role";
			} else {
				return "New role (" + bt.stream().map(Class::getSimpleName).collect(Collectors.joining(", ")) + ")";
			}
		}
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == SpartaModelPackage.Literals.SOLUTION_TYPE__ROLES;

		if (qualify) {
			return getString("_UI_CreateChild_text2",
					new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}