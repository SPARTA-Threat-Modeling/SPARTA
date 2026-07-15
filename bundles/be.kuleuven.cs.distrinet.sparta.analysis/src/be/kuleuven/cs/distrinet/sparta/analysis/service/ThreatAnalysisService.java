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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IPropertyListener;
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
	
	private IProject project;
	private Resource resource;
	
	private Engine engine;
	private MultiList<? extends ObservableThreat> ml;
	private Map<ThreatPatternMatchMetadata,PatternParsingResults> parseResults;

	private DataBindingContext dbc;
	private final List<WritableList<ObservableThreat>> targetLists = new ArrayList<>();
	private final List<IObservableList<IPatternMatch>> sourceLists = new ArrayList<>();

	public void clear() {
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
	
	public void load(Resource resource) {
		
		try {
			project = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resource.getURI().toPlatformString(true))).getProject();
			this.resource = resource;

			if (engine != null) {
				clear();
			}
			
			Map<EObject, Collection<Setting>> map = EcoreUtil.ExternalCrossReferencer.find(resource);
			Set<Notifier> roots = map.keySet().stream().map(o -> o.eResource()).collect(Collectors.toSet());
			roots.add(resource);

			engine = new Engine(new EMFScope(resource.getResourceSet(), new BaseIndexOptions().withResourceFilterConfiguration(r -> !roots.contains(r))));
			RiskAssessmentLoopConfiguration.getInstance().setUpLoopParameters(engine);

			
			final List<IObservableList<ObservableThreat>> observableLists = new ArrayList<IObservableList<ObservableThreat>>();//= null;

			dbc = new DataBindingContext();
			List<Function<ViatraQueryEngine,ViatraQueryMatcher<? extends IPatternMatch>>> ms = engine.getPatternMatchers();
			ms.stream().map(engine::getVQMatcherOnEngine)
						.forEach(vqm -> {
							IObservableList<IPatternMatch> list = ObservablePatternMatchCollectionBuilder.create(vqm).buildList();
							WritableList<ObservableThreat> obsList = new WritableList<ObservableThreat>();
							dbc.bindList(obsList, list,null,new UpdateListStrategy(UpdateListStrategy.POLICY_UPDATE).setConverter(new ThreatConverter(dbc)));
							sourceLists.add(list);
							targetLists.add(obsList);
							observableLists.add(obsList);
						});

			parseResults = new PatternProcessor(engine).parsePatterns(resource.getResourceSet());
			for (Entry<ThreatPatternMatchMetadata,PatternParsingResults> e : parseResults.entrySet()) {
				e.getKey();
				StreamSupport.stream(e.getValue().getQuerySpecifications().spliterator(),false)
					.map(qs -> getVQMatchers(qs, engine))
					.filter(vqm -> vqm != null)
					.forEach(vqm -> {
						IObservableList<IPatternMatch> list = ObservablePatternMatchCollectionBuilder.create(vqm).buildList();
						WritableList<ObservableThreat> obsList = new WritableList<ObservableThreat>();
						dbc.bindList(obsList, list,null,new UpdateListStrategy(UpdateListStrategy.POLICY_UPDATE).setConverter(new PatternThreatConverter(dbc,e.getKey())));
						sourceLists.add(list);
						targetLists.add(obsList);
						observableLists.add(obsList);
					});;
			}
			
			ml = new MultiList<>(observableLists);

			patternsParsed();
			notifyListeners();
		} catch (ViatraQueryException e) {
			e.printStackTrace();
		}

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
		listeners.stream().forEach(l -> l.analysisResultsAvailable());
	}
	private void notifyListenersDisposal() {
		listeners.stream().forEach(l -> l.invalidatePreviousBindings());
	}

	public void sub(AnalysisListener l)	{
		listeners.add(l);
	}
	public void unSub(AnalysisListener l)	{
		listeners.remove(l);
	}
	@Override
	public void propertyChanged(Object source, int propId) {
		notifyListeners();
		
	}
	public Resource getResource() {
		return resource;
	}
	
	public Map<ThreatPatternMatchMetadata,PatternParsingResults> parseResults() {
		return parseResults;
	}
	
	public void patternsParsed() {
		plisteners.stream().forEach(pl -> pl.parseResultsAvailable());
	}

	public void sub(PatternParseListener l)	{
		plisteners.add(l);
	}
	public void unSub(PatternParseListener  l)	{
		plisteners.remove(l);
	}


}
