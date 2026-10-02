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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.observable.list.AbstractObservableList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.MultiList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.viatra.addon.databinding.runtime.collection.ObservablePatternMatchCollectionBuilder;
import org.eclipse.viatra.query.patternlanguage.emf.util.PatternParsingResults;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import be.kuleuven.cs.distrinet.sparta.analysis.Activator;
import be.kuleuven.cs.distrinet.sparta.analysis.conversion.PatternThreatConverter;
import be.kuleuven.cs.distrinet.sparta.analysis.conversion.ThreatConverter;
import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;
import be.kuleuven.cs.distrinet.sparta.core.Engine;
import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
import be.kuleuven.cs.distrinet.sparta.core.patterns.PatternProcessor;
import be.kuleuven.cs.distrinet.sparta.core.patterns.ThreatPatternMatchMetadata;

/**
 * Analysis service for listening to changes to the model.
 *
 */
public class ThreatAnalysisService implements IPropertyListener {
	
	private static final ThreatAnalysisService INSTANCE = new ThreatAnalysisService();
	
	private ThreatAnalysisService() {
		
	}
	
	public static ThreatAnalysisService getInstance() {
		return INSTANCE;
	}

	private Set<AnalysisListener> listeners = new HashSet<AnalysisListener>();
	private Set<PatternParseListener> plisteners = new HashSet<PatternParseListener>();

	private Resource resource;
	
	private Engine engine;
	private MultiList<? extends ObservableThreat> ml;
	private Map<ThreatPatternMatchMetadata,PatternParsingResults> parseResults;

	private DataBindingContext dbc;

	/** Recalculates the threats affected by model edits; lives from load() to clear(). */
	private RiskChangeTracker tracker;
	private final List<WritableList<ObservableThreat>> targetLists = new ArrayList<>();
	private final List<IObservableList<IPatternMatch>> sourceLists = new ArrayList<>();

	/** The editor this singleton is currently registered on as property listener. */
	private IWorkbenchPart currentEditor;

	/**
	 * Registers this service as property listener on the given editor, detaching
	 * it from any previously tracked editor first so the singleton never stays
	 * subscribed to more than one editor at a time.
	 */
	public void attachEditor(IWorkbenchPart editor) {
		if (currentEditor == editor) {
			return;
		}
		detachCurrentEditor();
		if (editor != null) {
			editor.addPropertyListener(this);
			currentEditor = editor;
		}
	}

	private void detachCurrentEditor() {
		if (currentEditor != null) {
			currentEditor.removePropertyListener(this);
			currentEditor = null;
		}
	}

	public void clear() {
		// Stop listening to the editor that triggered the analysis and drop the
		// loaded state, so a late editor property event can no longer reach the
		// torn-down service and stale resources are not retained.
		detachCurrentEditor();
		if (tracker != null) {
			tracker.dispose();
			tracker = null;
		}
		resource = null;
		parseResults = null;
		if (engine == null) {
			return;
		}
		try {
			engine.dispose();
		} catch (Exception e) {
			log("Error while disposing the analysis engine", e);
		}
		engine = null;

		// Detach the views before tearing down the observable graph so they can
		// still remove their own listeners from a live list.
		notifyListenersDisposal();

		// Dispose the binding graph created per load() so it does not leak.
		if (dbc != null) {
			dbc.dispose();
			dbc = null;
		}

		// MultiList is a read-only composite view over its sublists: clear() is
		// unsupported and used to be swallowed by an empty catch. Clear and
		// dispose the underlying WritableLists directly, then the source
		// pattern-match collections that hold the VIATRA listeners.
		if (ml != null) {
			ml.dispose();
			ml = null;
		}
		for (WritableList<ObservableThreat> target : targetLists) {
			if (!target.isDisposed()) {
				target.clear();
				target.dispose();
			}
		}
		targetLists.clear();
		for (IObservableList<IPatternMatch> source : sourceLists) {
			if (!source.isDisposed()) {
				source.dispose();
			}
		}
		sourceLists.clear();
	}

	private void log(String message, Throwable t) {
		Activator activator = Activator.getDefault();
		if (activator != null) {
			activator.getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, t));
		}
	}
	
	/**
	 * Load and analyse the given model resource, replacing any previous analysis.
	 *
	 * @return {@link Status#OK_STATUS} when the analysis results are available; otherwise an
	 *         error status (also logged) with a user-facing explanation of why the model could
	 *         not be analysed, for the caller to report
	 */
	public IStatus load(Resource resource) {
		// Tear down any previous analysis first: clear() also resets the
		// resource field, so it must be assigned afterwards.
		if (engine != null) {
			clear();
		}

		if (resource == null || resource.getURI() == null) {
			return error("There is no model to analyse.", null);
		}
		// toPlatformString returns null for non-platform URIs (e.g. file: URIs),
		// i.e. models that are not part of the workspace.
		String platformString = resource.getURI().toPlatformString(true);
		if (platformString == null) {
			return error(resource.getURI() + " is not a resource in the workspace. "
					+ "Open the model from a workspace project to analyse it.", null);
		}

		try {
			this.resource = resource;

			Map<EObject, Collection<Setting>> map = EcoreUtil.ExternalCrossReferencer.find(resource);
			Set<Notifier> roots = map.keySet().stream().map(o -> o.eResource()).collect(Collectors.toSet());
			roots.add(resource);

			engine = new Engine(new EMFScope(resource.getResourceSet(), new BaseIndexOptions().withResourceFilterConfiguration(r -> !roots.contains(r))));
			RiskAssessmentLoopConfiguration loopConfiguration = engine.getLoopConfiguration();
			loopConfiguration.setUpLoopParameters(engine);

			
			final List<IObservableList<ObservableThreat>> observableLists = new ArrayList<IObservableList<ObservableThreat>>();//= null;

			dbc = new DataBindingContext();
			List<Function<ViatraQueryEngine,ViatraQueryMatcher<? extends IPatternMatch>>> ms = engine.getPatternMatchers();
			ms.stream().map(engine::getVQMatcherOnEngine)
						.forEach(vqm -> {
							IObservableList<IPatternMatch> list = ObservablePatternMatchCollectionBuilder.create(vqm).buildList();
							WritableList<ObservableThreat> obsList = new WritableList<ObservableThreat>();
							dbc.bindList(obsList, list,null,new UpdateListStrategy(UpdateListStrategy.POLICY_UPDATE).setConverter(new ThreatConverter(dbc, loopConfiguration)));
							sourceLists.add(list);
							targetLists.add(obsList);
							observableLists.add(obsList);
						});

			parseResults = new PatternProcessor(engine).parsePatterns(resource.getResourceSet());
			for (Entry<ThreatPatternMatchMetadata,PatternParsingResults> e : parseResults.entrySet()) {
				StreamSupport.stream(e.getValue().getQuerySpecifications().spliterator(),false)
					.map(qs -> getVQMatchers(qs, engine))
					.filter(vqm -> vqm != null)
					.forEach(vqm -> {
						IObservableList<IPatternMatch> list = ObservablePatternMatchCollectionBuilder.create(vqm).buildList();
						WritableList<ObservableThreat> obsList = new WritableList<ObservableThreat>();
						dbc.bindList(obsList, list,null,new UpdateListStrategy(UpdateListStrategy.POLICY_UPDATE).setConverter(new PatternThreatConverter(dbc,e.getKey(), loopConfiguration)));
						sourceLists.add(list);
						targetLists.add(obsList);
						observableLists.add(obsList);
					});
			}
			
			ml = new MultiList<>(observableLists);

			// Recalculate the threats affected by later edits of the analysed resources.
			List<Resource> analysed = roots.stream().filter(Resource.class::isInstance).map(Resource.class::cast)
					.collect(Collectors.toList());
			tracker = new RiskChangeTracker(analysed, ml,
					() -> engine.getLoopConfiguration().setUpLoopParameters(engine), this::notifyListeners);
			tracker.start();
		} catch (RuntimeException e) {
			// Includes ViatraQueryException (unchecked in VIATRA 2). Loading failed after
			// the engine and observable graph were partially built; tear the half-built
			// state back down so views are not left bound to an inconsistent list, and
			// report why.
			clear();
			return error("The analysis engine could not analyse " + resource.getURI() + ": " + e.getMessage(), e);
		}

		// Outside the catch: a failing listener is not a failed load and must not
		// clear the results that were just built.
		patternsParsed();
		notifyListeners();
		return Status.OK_STATUS;
	}

	/** Log an error and return it as a status for the caller to report. */
	private IStatus error(String message, Throwable t) {
		IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, t);
		Activator activator = Activator.getDefault();
		if (activator != null) {
			activator.getLog().log(status);
		}
		return status;
	}
	
	private ViatraQueryMatcher<?> getVQMatchers(IQuerySpecification<?> qs, Engine engine) {
		try {
			return engine.getVQMatcherOnEngine(qs::getMatcher);
		} catch (ViatraQueryException e) {
			return null;
		}
	}

	
	public AbstractObservableList<? extends ObservableThreat> observableThreatList() {
		return ml;
	}
	
	private void notifyListeners() {
		// Iterate over a snapshot: a listener callback may (un)subscribe during
		// notification (e.g. a view disposing), which would otherwise throw a
		// ConcurrentModificationException on the live set.
		new ArrayList<>(listeners).forEach(l -> l.analysisResultsAvailable());
	}
	private void notifyListenersDisposal() {
		new ArrayList<>(listeners).forEach(l -> l.invalidatePreviousBindings());
	}

	public void sub(AnalysisListener l)	{
		listeners.add(l);
	}
	public void unSub(AnalysisListener l)	{
		listeners.remove(l);
	}
	@Override
	public void propertyChanged(Object source, int propId) {
		// After clear() the observable graph is gone (ml == null); a late editor
		// property event must not trigger a view reload against torn-down state.
		if (ml == null) {
			return;
		}
		notifyListeners();

	}
	public Resource getResource() {
		return resource;
	}

	/**
	 * @return {@code true} while analysis results are available, i.e. between a successful
	 *         {@link #load(Resource)} and the next {@link #clear()}. Before the first load,
	 *         after a clear, or after a failed load there is nothing to export.
	 */
	public boolean hasResults() {
		return engine != null && ml != null && resource != null;
	}
	
	public Map<ThreatPatternMatchMetadata,PatternParsingResults> parseResults() {
		return parseResults;
	}
	
	public void patternsParsed() {
		new ArrayList<>(plisteners).forEach(pl -> pl.parseResultsAvailable());
	}

	public void sub(PatternParseListener l)	{
		plisteners.add(l);
	}
	public void unSub(PatternParseListener  l)	{
		plisteners.remove(l);
	}


}
