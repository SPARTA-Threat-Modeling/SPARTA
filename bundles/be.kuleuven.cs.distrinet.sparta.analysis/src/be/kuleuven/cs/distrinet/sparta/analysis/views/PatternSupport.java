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
import java.util.function.Function;

import org.eclipse.core.databinding.beans.typed.PojoProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.viatra.query.patternlanguage.emf.util.PatternParsingResults;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Pattern;
import org.eclipse.xtext.validation.Issue;

import be.kuleuven.cs.distrinet.sparta.analysis.service.PatternParseListener;
import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;
import be.kuleuven.cs.distrinet.sparta.analysis.views.sorter.ThreatSorter;
import be.kuleuven.cs.distrinet.sparta.core.patterns.ThreatPatternMatchMetadata;


public class PatternSupport extends ViewPart implements PatternParseListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "be.kuleuven.cs.distrinet.sparta.analysis.views.PatternSupport";

	private TableViewer viewer;


	static class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		@Override
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		@Override
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		@Override
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	
	private Composite parent;
	
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
	
	private void setupTable(TableViewer viewer) {
		createColumns(viewer);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		GridData gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.verticalAlignment = SWT.FILL;
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.minimumHeight = 100;
		table.setLayoutData(gd);

	}
	
	private void createColumns(TableViewer viewer) {
		
		// ThreatType column
		TableViewerColumn idCol = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn tc = idCol.getColumn();
		tc.setText("ThreatType");
		tc.setWidth(100);
		new ThreatSorter(viewer, idCol) {
			@Override
			protected int compareImpl(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof PatternDiagnostics && e2 instanceof PatternDiagnostics) {
					PatternDiagnostics t1 = (PatternDiagnostics) e1;
					PatternDiagnostics t2 = (PatternDiagnostics) e2;
					return t1.getThreatType().compareTo(t2.getThreatType());
				} else
					return super.compareImpl(viewer, e1, e2);
			}
		};
		createCol(viewer,"Pattern",100, PatternDiagnostics::getPatternName);
		createCol(viewer,"Issue",500, PatternDiagnostics::getIssue);

	}
	
	private <U extends Comparable<? super U>> void createCol(TableViewer viewer, final String colname, int width, Function<? super PatternDiagnostics, ? extends U> keyExtractor) {
		createCol(viewer, colname, width, SWT.LEFT, keyExtractor);
	}

	private <U extends Comparable<? super U>> void createCol(TableViewer viewer, final String colname, int width, int alignment, Function<? super PatternDiagnostics, ? extends U> keyExtractor) {
		Comparator<? super PatternDiagnostics> cmp = Comparator.comparing(keyExtractor);
		TableViewerColumn col = new TableViewerColumn(viewer, SWT.NONE);

		final TableColumn tc = col.getColumn();
		tc.setText(colname);
		tc.setWidth(width);
		tc.setMoveable(true);
		tc.setAlignment(alignment);
		new ThreatSorter(viewer, col) {
			@Override
			protected int compareImpl(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof PatternDiagnostics && e2 instanceof PatternDiagnostics) {
					PatternDiagnostics t1 = (PatternDiagnostics) e1;
					PatternDiagnostics t2 = (PatternDiagnostics) e2;
					return cmp.compare(t1,  t2);
				} else
					return super.compareImpl(viewer, e1, e2);
			}
		};

	}

	
	private void makeActions() {
		doubleClickAction = new Action() {
			public void run() {
				IStructuredSelection selection = viewer.getStructuredSelection();
				Object obj = selection.getFirstElement();
				System.out.println(obj);
				if (obj instanceof PatternDiagnostics) {
					PatternDiagnostics pd = (PatternDiagnostics) obj;
					showMessage(pd.getPatternName() + " error", pd.getIssue());
				}

			}
		};
	}

	private Action doubleClickAction;

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String title, String message) {
		MessageDialog.openInformation(
			parent.getShell(),
			title,
			message);
	}
	
	@Override
	public void setFocus() {
		parent.setFocus();
	}
	
	public void load() {
		
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
		viewer.refresh();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void bind(StructuredViewer viewer, IObservableList<? extends PatternDiagnostics> input, IValueProperty... labelProperties) {
		ObservableListContentProvider contentProvider = new ObservableListContentProvider();
		if (viewer.getInput() != null)
			viewer.setInput(null);
		viewer.setContentProvider(contentProvider);
		IssueLabelProvider lp = new IssueLabelProvider(Properties
				.observeEach(contentProvider.getKnownElements(),
						labelProperties), input);
		viewer.setLabelProvider(lp);
		viewer.setInput(input);
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
	
	private class PatternDiagnostics {  
		
		protected WritableValue<String> threatType = new WritableValue<String>();
		protected WritableValue<String> patternName = new WritableValue<String>();
		protected WritableValue<String> issue = new WritableValue<String>();
		
		PatternDiagnostics(String threattype, String patternName, String issue) {
			this.threatType.setValue(threattype);
			this.patternName.setValue(patternName);
			this.issue.setValue(issue);
		}
		
		public String getThreatType() {
			return threatType.getValue();
		}

		public String getPatternName() {
			return patternName.getValue();
		}

		public String getIssue() {
			return issue.getValue();
		}
	   
	}  
	
	private class IssueLabelProvider extends ObservableMapLabelProvider implements IColorProvider, IListChangeListener<PatternDiagnostics>, IChangeListener {

		private final Color red = new Color(Display.getDefault(), 255, 0, 0, 255);
		private final Color green = new Color(Display.getDefault(), 0, 255, 0, 255);
		private final Color white = new Color(Display.getDefault(), 255, 255, 255, 255);
		
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
			input.addListChangeListener(this);
			input.addChangeListener(this);
		}

		@Override
		public void handleChange(ChangeEvent event) {
			fireLabelProviderChanged(new LabelProviderChangedEvent(this));
			
		}

		@Override
		public void handleListChange(ListChangeEvent<? extends PatternDiagnostics> event) {
						
		}

		@Override
		public Color getForeground(Object element) {
			return null;
		}

		@Override
		public Color getBackground(Object element) {
			if (element instanceof PatternDiagnostics) {
				if ( ((PatternDiagnostics) element).getIssue() == "" || ((PatternDiagnostics) element).getIssue() == null) {
					return green;
				} else {
					return red;
				}
			}
			return white;
		}
		
	}
	
}
