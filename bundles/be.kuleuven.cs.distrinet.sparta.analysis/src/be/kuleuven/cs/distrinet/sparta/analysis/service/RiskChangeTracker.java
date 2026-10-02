/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;

import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;

/**
 * Live, incremental risk recalculation: listens to the analysed model and, after each edit,
 * recalculates exactly the threats whose risk inputs changed (see {@link RiskDependencies}).
 * Unaffected threats keep their figures. Threats that appear or disappear are handled by the
 * query engine; this tracker keeps its index in step with them through the threat list.
 *
 * <p>Model notifications may arrive on any thread. They are only collected there; resolving
 * them to threats and recalculating happens in one batch on the threat list's realm (the UI
 * thread), once the burst of notifications of an edit has been delivered.</p>
 */
final class RiskChangeTracker extends EContentAdapter implements IListChangeListener<ObservableThreat> {

	private final Collection<Resource> resources;
	private final IObservableList<? extends ObservableThreat> threats;
	private final Runnable refreshLoopParameters;
	private final Runnable afterRecalculation;

	// Realm-confined.
	private final Map<EObject, Set<ObservableThreat>> threatsByObject = new HashMap<>();
	private final Map<ObservableThreat, Set<EObject>> objectsByThreat = new HashMap<>();

	// Guarded by this.
	private final Set<EObject> changedObjects = new LinkedHashSet<>();
	private boolean scheduled;

	private volatile boolean disposed;

	/**
	 * @param resources             the analysed resources (the query engine's scope)
	 * @param threats               the live list of all threats
	 * @param refreshLoopParameters re-reads the risk loop configuration (attacker profiles,
	 *                              data types) from the model before a recalculation
	 * @param afterRecalculation    called after threats were recalculated, to refresh views
	 */
	RiskChangeTracker(Collection<Resource> resources, IObservableList<? extends ObservableThreat> threats,
			Runnable refreshLoopParameters, Runnable afterRecalculation) {
		this.resources = new ArrayList<>(resources);
		this.threats = threats;
		this.refreshLoopParameters = refreshLoopParameters;
		this.afterRecalculation = afterRecalculation;
	}

	/** Index the current threats and start listening. Call on the threat list's realm. */
	void start() {
		for (ObservableThreat threat : threats) {
			index(threat);
		}
		threats.addListChangeListener(this);
		for (Resource resource : resources) {
			resource.eAdapters().add(this);
		}
	}

	/** Stop listening and drop the index. */
	void dispose() {
		disposed = true;
		for (Resource resource : resources) {
			resource.eAdapters().remove(this);
		}
		if (!threats.isDisposed()) {
			threats.removeListChangeListener(this);
		}
		threatsByObject.clear();
		objectsByThreat.clear();
	}

	@Override
	public void handleListChange(ListChangeEvent<? extends ObservableThreat> event) {
		for (ListDiffEntry<? extends ObservableThreat> entry : event.diff.getDifferences()) {
			if (entry.isAddition()) {
				index(entry.getElement());
			} else {
				unindex(entry.getElement());
			}
		}
	}

	@Override
	public void notifyChanged(Notification notification) {
		// Keeps the adapter attached to added contents and detached from removed ones.
		super.notifyChanged(notification);
		if (disposed || RiskDependencies.isIrrelevant(notification)
				|| !(notification.getNotifier() instanceof EObject changed)) {
			return;
		}
		synchronized (this) {
			changedObjects.add(changed);
			if (scheduled) {
				return;
			}
			scheduled = true;
		}
		threats.getRealm().asyncExec(this::recalculate);
	}

	private void recalculate() {
		Set<EObject> changed;
		synchronized (this) {
			changed = new LinkedHashSet<>(changedObjects);
			changedObjects.clear();
			scheduled = false;
		}
		if (disposed || threats.isDisposed()) {
			return;
		}
		Set<ObservableThreat> affected = new LinkedHashSet<>();
		boolean all = false;
		for (EObject object : changed) {
			if (RiskDependencies.affectsAllThreats(object)) {
				all = true;
				break;
			}
			for (EObject owner : RiskDependencies.owners(object)) {
				affected.addAll(threatsByObject.getOrDefault(owner, Set.of()));
			}
		}
		if (all) {
			affected = new LinkedHashSet<>(objectsByThreat.keySet());
		}
		if (affected.isEmpty()) {
			return;
		}
		// The loop configuration caches attacker profiles and per-element data types; re-read
		// it so the recalculation sees the edit (the underlying queries are incremental).
		refreshLoopParameters.run();
		for (ObservableThreat threat : affected) {
			threat.recalculateRisk();
			// A recalculation can change what the threat depends on, e.g. a new role binding.
			unindex(threat);
			index(threat);
		}
		afterRecalculation.run();
	}

	private void index(ObservableThreat threat) {
		Set<EObject> objects = RiskDependencies.involvedObjects(threat);
		objectsByThreat.put(threat, objects);
		for (EObject object : objects) {
			threatsByObject.computeIfAbsent(object, o -> new HashSet<>()).add(threat);
		}
	}

	private void unindex(ObservableThreat threat) {
		Set<EObject> objects = objectsByThreat.remove(threat);
		if (objects == null) {
			return;
		}
		List<EObject> emptied = new ArrayList<>();
		for (EObject object : objects) {
			Set<ObservableThreat> indexed = threatsByObject.get(object);
			if (indexed != null && indexed.remove(threat) && indexed.isEmpty()) {
				emptied.add(object);
			}
		}
		emptied.forEach(threatsByObject::remove);
	}
}
