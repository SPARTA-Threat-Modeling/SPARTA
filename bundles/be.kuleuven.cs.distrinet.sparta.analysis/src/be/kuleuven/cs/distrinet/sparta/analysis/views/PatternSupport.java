/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.views;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.databinding.beans.typed.PojoProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.viatra.query.patternlanguage.emf.util.PatternParsingResults;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Pattern;
import org.eclipse.xtext.validation.Issue;

import be.kuleuven.cs.distrinet.sparta.analysis.service.PatternParseListener;
import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;
import be.kuleuven.cs.distrinet.sparta.analysis.util.IssueStatus;
import be.kuleuven.cs.distrinet.sparta.core.patterns.ThreatPatternMatchMetadata;


public class PatternSupport extends AbstractThreatTableView<PatternSupport.PatternDiagnostics> implements PatternParseListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "be.kuleuven.cs.distrinet.sparta.analysis.views.PatternSupport";

	public PatternSupport() {
		super(PatternDiagnostics.class);
	}

	@Override
	public void createPartControl(Composite parent) {
		ThreatAnalysisService.getInstance().sub(this);
		this.parent = parent;
		
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				//| SWT.BORDER
				| SWT.FULL_SELECTION);

		setupTable(viewer);
		makeActions();
		hookDoubleClickAction();
	
	}
	
	@Override
	protected void createColumns(TableViewer viewer) {

		// ThreatType column
		TableViewerColumn idCol = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn tc = idCol.getColumn();
		tc.setText("ThreatType");
		tc.setWidth(100);
		addColumnSorter(viewer, idCol, Comparator.comparing(PatternDiagnostics::getThreatType,
				Comparator.nullsFirst(Comparator.<String>naturalOrder())));
		createCol(viewer,"Pattern",100, PatternDiagnostics::getPatternName);
		createCol(viewer,"Issue",500, PatternDiagnostics::getIssue);

	}

	private void makeActions() {
		doubleClickAction = new Action() {
			public void run() {
				IStructuredSelection selection = viewer.getStructuredSelection();
				Object obj = selection.getFirstElement();
				if (obj instanceof PatternDiagnostics) {
					PatternDiagnostics pd = (PatternDiagnostics) obj;
					showMessage(pd.getPatternName() + " error", pd.getIssue());
				}

			}
		};
	}

	@Override
	public void dispose() {
		ThreatAnalysisService.getInstance().unSub(this);
		super.dispose();
	}

	public void load() {

		IObservableList<? extends PatternDiagnostics> previous = parseResults;

		parseResults = convertDiagnostics(ThreatAnalysisService.getInstance().parseResults());

		bind(
				viewer,
				parseResults,
				new IValueProperty[] {
						PojoProperties.value(PatternDiagnostics.class,"threatType"),
						PojoProperties.value(PatternDiagnostics.class,"patternName"),
						PojoProperties.value(PatternDiagnostics.class,"issue"),
						}
				);

		// bind() installs a fresh content/label provider (disposing the previous
		// label provider, which detaches its listeners from `previous`). The old
		// diagnostics list is now unreferenced; dispose it so re-parses don't leak.
		if (previous != null && !previous.isDisposed()) {
			previous.dispose();
		}
		viewer.refresh();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseLabelProvider createLabelProvider(IObservableMap[] attributeMaps,
			IObservableList<? extends PatternDiagnostics> input) {
		return new IssueLabelProvider(attributeMaps, input);
	}

	private IObservableList<? extends PatternDiagnostics> parseResults;
	
	@Override
	public void parseResultsAvailable() {
		load();
	}
	
	@SuppressWarnings("restriction")
	private WritableList<PatternDiagnostics> convertDiagnostics(Map<ThreatPatternMatchMetadata,PatternParsingResults> parseResults) {
		WritableList<PatternDiagnostics> result = new WritableList<>();
		for (ThreatPatternMatchMetadata m: parseResults.keySet()) {
			String threattype = m.getThreatType().getName();
			PatternParsingResults ppr = parseResults.get(m);
			Iterator<Pattern> removedPatterns = parseResults.get(m).getRemovedPatterns().iterator();
			while (removedPatterns.hasNext()) {
				Pattern p = removedPatterns.next();
				String pName = p.getName();
				for (Issue i: ppr.getErrors(p)) {
					result.add(new PatternDiagnostics(threattype, pName, i.toString()));
				}
			}
			
			Iterator<Pattern> patterns = parseResults.get(m).getPatterns().iterator();
			while (patterns.hasNext()) {
				Pattern p = patterns.next();
				String pName = p.getName();
				for (Issue i: ppr.getErrors(p)) {
					result.add(new PatternDiagnostics(threattype, pName, i.toString()));
				}
			}
		}
		
		return result;
	}
	
	// Package-private (not private): the type argument in this view's extends
	// clause must be accessible there, and a private member is not in scope in
	// the superclass clause of its own enclosing class.
	static class PatternDiagnostics {

		// Plain immutable fields: these values are set once at construction and
		// never bound or mutated, so the previous WritableValue wrappers only
		// created throwaway observables (each touching the default realm). The
		// PojoProperties bindings read the getters reflectively either way.
		private final String threatType;
		private final String patternName;
		private final String issue;

		PatternDiagnostics(String threattype, String patternName, String issue) {
			this.threatType = threattype;
			this.patternName = patternName;
			this.issue = issue;
		}

		public String getThreatType() {
			return threatType;
		}

		public String getPatternName() {
			return patternName;
		}

		public String getIssue() {
			return issue;
		}

	}
	
	private class IssueLabelProvider extends ObservableMapLabelProvider implements IColorProvider, IChangeListener {

		private final Color red = new Color(Display.getDefault(), 255, 0, 0, 255);
		private final Color green = new Color(Display.getDefault(), 0, 255, 0, 255);
		private final Color white = new Color(Display.getDefault(), 255, 255, 255, 255);

		private IObservableList<? extends PatternDiagnostics> input;

		public IssueLabelProvider(IObservableMap<?, ?> attributeMap) {
			super(attributeMap);
		}

		@SuppressWarnings("rawtypes")
		public IssueLabelProvider(IObservableMap[] attributeMap) {
			super(attributeMap);
		}

		@SuppressWarnings("rawtypes")
		public IssueLabelProvider(IObservableMap[] attributeMap, IObservableList<? extends PatternDiagnostics> input) {
			this(attributeMap);
			this.input = input;
			input.addChangeListener(this);
		}

		@Override
		public void handleChange(ChangeEvent event) {
			fireLabelProviderChanged(new LabelProviderChangedEvent(this));

		}

		@Override
		public Color getForeground(Object element) {
			return null;
		}

		@Override
		public Color getBackground(Object element) {
			if (element instanceof PatternDiagnostics) {
				String issue = ((PatternDiagnostics) element).getIssue();
				return IssueStatus.isResolved(issue) ? green : red;
			}
			return white;
		}

		@Override
		public void dispose() {
			// Detach from the input list before disposing, mirroring
			// ColouredObservableMapLabelProvider.dispose(); otherwise the
			// discarded WritableList keeps a reference to this label provider.
			if (input != null && !input.isDisposed()) {
				input.removeChangeListener(this);
			}
			input = null;
			super.dispose();
			red.dispose();
			green.dispose();
			white.dispose();
		}

	}
	
}
