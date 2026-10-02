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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.observable.list.AbstractObservableList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.MultiList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.viatra.addon.databinding.runtime.collection.ObservablePatternMatchCollectionBuilder;
import org.eclipse.viatra.query.patternlanguage.emf.util.PatternParsingResults;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
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

	/**
	 * Generation of the most recent {@link #load(Resource, IWorkbenchPart)} or {@link #clear()}.
	 * Bumped on the UI thread; read by the load job to detect that it has been superseded and
	 * its result must be dropped instead of published.
	 */
	private final AtomicInteger loadGeneration = new AtomicInteger();

	/** The currently scheduled or running load job, if any. UI thread only. */
	private Job loadJob;
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
		// Invalidate any in-flight load first: the load job re-checks the generation between its
		// phases and again in its UI-thread completion, so a stale job can neither publish its
		// result after this teardown nor interleave with a newer load.
		loadGeneration.incrementAndGet();
		if (loadJob != null) {
			loadJob.cancel();
			loadJob = null;
		}
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
		disposeQuietly(engine);
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

	/** Dispose an engine that never reached (or already left) the service state. */
	private void disposeQuietly(Engine engine) {
		if (engine == null) {
			return;
		}
		try {
			engine.dispose();
		} catch (Exception e) {
			log("Error while disposing the analysis engine", e);
		}
	}

	/** {@link #load(Resource, IWorkbenchPart)} without an editor to attach. */
	public IStatus load(Resource resource) {
		return load(resource, null);
	}

	/**
	 * Load and analyse the given model resource, replacing any previous analysis. Must be called
	 * on the UI thread.
	 *
	 * <p>The previous analysis is torn down synchronously ({@link #clear()}). The expensive part
	 * (cross-reference scan, engine and matcher construction, pattern parsing) then runs in a
	 * background user {@link Job} with progress reporting. Its result is published on the UI
	 * thread, which builds the realm-bound databinding graph, starts the
	 * {@link RiskChangeTracker}, attaches {@code editorToAttach} and notifies the listeners. A
	 * load superseded by a newer load or clear before it completes is cancelled and its engine
	 * discarded.</p>
	 *
	 * <p>Failures reach the user: a model that cannot be analysed at all is refused here with an
	 * error status for the caller to show; a failure in the background job becomes the job's
	 * error status, which the workbench shows and logs; a failure while publishing the result is
	 * reported through the {@link StatusManager}.</p>
	 *
	 * @param resource       the model resource to analyse
	 * @param editorToAttach editor whose property changes refresh the views, attached once the
	 *                       load succeeded; or {@code null}
	 * @return {@link Status#OK_STATUS} once the load is scheduled; otherwise an error status (also
	 *         logged) explaining why the model cannot be analysed
	 */
	public IStatus load(Resource resource, IWorkbenchPart editorToAttach) {
		// Tear down any previous analysis (and cancel an in-flight load) first: clear() also
		// resets the resource field, so the new resource is only published on completion.
		clear();

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

		final int generation = loadGeneration.get();
		final Display display = Display.getDefault();
		Job job = new Job("Loading SPARTA threat analysis") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				return runLoadJob(generation, resource, editorToAttach, display, monitor);
			}
		};
		job.setUser(true);
		loadJob = job;
		job.schedule();
		return Status.OK_STATUS;
	}

	private boolean isSuperseded(int generation, IProgressMonitor monitor) {
		return monitor.isCanceled() || generation != loadGeneration.get();
	}

	/**
	 * Background phase of a load: everything expensive and databinding-free. Runs on the job
	 * thread; must not touch the service's mutable state, only publish its result via
	 * {@link #applyLoadResult}.
	 */
	private IStatus runLoadJob(int generation, Resource resource, IWorkbenchPart editorToAttach,
			Display display, IProgressMonitor monitor) {
		SubMonitor sub = SubMonitor.convert(monitor, "Loading SPARTA threat analysis", 3);
		Engine newEngine = null;
		try {
			sub.subTask("Scanning model cross-references");
			Map<EObject, Collection<Setting>> map = EcoreUtil.ExternalCrossReferencer.find(resource);
			Set<Notifier> roots = map.keySet().stream().map(o -> o.eResource()).collect(Collectors.toSet());
			roots.add(resource);
			final List<Resource> analysed = roots.stream().filter(Resource.class::isInstance)
					.map(Resource.class::cast).collect(Collectors.toList());
			sub.worked(1);
			if (isSuperseded(generation, monitor)) {
				return Status.CANCEL_STATUS;
			}

			sub.subTask("Building the threat elicitation engine");
			newEngine = new Engine(new EMFScope(resource.getResourceSet(),
					new BaseIndexOptions().withResourceFilterConfiguration(r -> !roots.contains(r))));
			newEngine.getLoopConfiguration().setUpLoopParameters(newEngine);
			final Engine e = newEngine;
			final List<ViatraQueryMatcher<?>> defaultMatchers = new ArrayList<>();
			newEngine.getPatternMatchers().stream().map(e::getVQMatcherOnEngine).forEach(defaultMatchers::add);
			sub.worked(1);
			if (isSuperseded(generation, monitor)) {
				disposeQuietly(newEngine);
				return Status.CANCEL_STATUS;
			}

			sub.subTask("Parsing threat patterns");
			final Map<ThreatPatternMatchMetadata, PatternParsingResults> newParseResults =
					new PatternProcessor(newEngine).parsePatterns(resource.getResourceSet());
			final Map<ThreatPatternMatchMetadata, List<ViatraQueryMatcher<?>>> patternMatchers = new LinkedHashMap<>();
			for (Entry<ThreatPatternMatchMetadata, PatternParsingResults> entry : newParseResults.entrySet()) {
				List<ViatraQueryMatcher<?>> matchers = new ArrayList<>();
				StreamSupport.stream(entry.getValue().getQuerySpecifications().spliterator(), false)
					.map(qs -> getVQMatchers(qs, e))
					.filter(vqm -> vqm != null)
					.forEach(matchers::add);
				patternMatchers.put(entry.getKey(), matchers);
			}
			sub.worked(1);
			if (isSuperseded(generation, monitor) || display.isDisposed()) {
				disposeQuietly(newEngine);
				return Status.CANCEL_STATUS;
			}

			display.asyncExec(() -> applyLoadResult(generation, resource, editorToAttach, e, analysed,
					defaultMatchers, newParseResults, patternMatchers));
			return Status.OK_STATUS;
		} catch (RuntimeException ex) {
			// Includes ViatraQueryException (unchecked in VIATRA 2). No service state has been
			// touched yet, so only the partial engine needs disposing. The status is returned,
			// not logged: the job framework logs it and the workbench shows it for a user job.
			disposeQuietly(newEngine);
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"The analysis engine could not analyse " + resource.getURI() + ": " + ex.getMessage(), ex);
		}
	}

	/**
	 * UI-thread completion of a load: publishes the computed engine and parse results, builds
	 * the realm-bound databinding graph (binding context, observable pattern-match lists,
	 * converted threat lists), starts the {@link RiskChangeTracker}, attaches the editor and
	 * notifies the views. Discards the result if a newer load or clear superseded it while this
	 * runnable was queued.
	 */
	private void applyLoadResult(int generation, Resource resource, IWorkbenchPart editorToAttach,
			Engine newEngine, List<Resource> analysed, List<ViatraQueryMatcher<?>> defaultMatchers,
			Map<ThreatPatternMatchMetadata, PatternParsingResults> newParseResults,
			Map<ThreatPatternMatchMetadata, List<ViatraQueryMatcher<?>>> patternMatchers) {
		if (generation != loadGeneration.get()) {
			disposeQuietly(newEngine);
			return;
		}
		this.resource = resource;
		this.engine = newEngine;
		this.parseResults = newParseResults;
		try {
			final List<IObservableList<ObservableThreat>> observableLists = new ArrayList<IObservableList<ObservableThreat>>();
			RiskAssessmentLoopConfiguration loopConfiguration = newEngine.getLoopConfiguration();

			dbc = new DataBindingContext();
			for (ViatraQueryMatcher<?> vqm : defaultMatchers) {
				IObservableList<IPatternMatch> list = ObservablePatternMatchCollectionBuilder.create(vqm).buildList();
				WritableList<ObservableThreat> obsList = new WritableList<ObservableThreat>();
				dbc.bindList(obsList, list,null,new UpdateListStrategy(UpdateListStrategy.POLICY_UPDATE).setConverter(new ThreatConverter(dbc, loopConfiguration)));
				sourceLists.add(list);
				targetLists.add(obsList);
				observableLists.add(obsList);
			}

			for (Entry<ThreatPatternMatchMetadata, List<ViatraQueryMatcher<?>>> e : patternMatchers.entrySet()) {
				for (ViatraQueryMatcher<?> vqm : e.getValue()) {
					IObservableList<IPatternMatch> list = ObservablePatternMatchCollectionBuilder.create(vqm).buildList();
					WritableList<ObservableThreat> obsList = new WritableList<ObservableThreat>();
					dbc.bindList(obsList, list,null,new UpdateListStrategy(UpdateListStrategy.POLICY_UPDATE).setConverter(new PatternThreatConverter(dbc,e.getKey(), loopConfiguration)));
					sourceLists.add(list);
					targetLists.add(obsList);
					observableLists.add(obsList);
				}
			}

			ml = new MultiList<>(observableLists);

			// Recalculate the threats affected by later edits of the analysed resources.
			tracker = new RiskChangeTracker(analysed, ml,
					() -> engine.getLoopConfiguration().setUpLoopParameters(engine), this::notifyListeners);
			tracker.start();

			// Attach only after the new state is published, so the editor's property events can
			// never observe half-built state; clear() already detached the previous editor.
			if (editorToAttach != null) {
				attachEditor(editorToAttach);
			}
		} catch (RuntimeException e) {
			// Includes ViatraQueryException. The graph was partially built; tear it back down
			// so views are not left bound to an inconsistent list, and report why.
			clear();
			StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"The analysis engine could not analyse " + resource.getURI() + ": " + e.getMessage(), e),
					StatusManager.SHOW | StatusManager.LOG);
			return;
		}

		// Outside the catch: a failing listener is not a failed load and must not
		// clear the results that were just built.
		patternsParsed();
		notifyListeners();
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
		// Only dirty-state transitions (edit and save) are relevant to the analysis;
		// other part properties (title, image, ...) must not each trigger a full
		// view rebind.
		if (propId != IEditorPart.PROP_DIRTY) {
			return;
		}
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
