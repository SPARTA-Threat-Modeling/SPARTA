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


import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.databinding.beans.typed.PojoProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.AbstractObservableList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;
import be.kuleuven.cs.distrinet.sparta.analysis.service.AnalysisListener;
import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;
import be.kuleuven.cs.distrinet.sparta.analysis.views.sorter.ThreatSorter;


/**
 * This class provides the SPARTA Threat Analysis view to present the user with
 * a sortable list of threats and manage the risk reduction progress.
 *
 */

public class ThreatAnalysis extends ViewPart implements AnalysisListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "be.kuleuven.cs.distrinet.sparta.analysis.views.ThreatAnalysis";

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
	private Label countLabel;
	private String empty = "";
	private String riskRedur = "Risk reduction progress: ";
	private Label riskRedurLabel;
	private ProgressBar progressBar;
	private Label residualRisk;
	private Label mitigatedRisk;
	private Label totalRisk;
	private Label sleRisk;


	private Label addLabel(Composite parent, String text, GridData layout) {
		Label tmp = new Label(parent, SWT.NONE);
		tmp.setText(text);
		tmp.setLayoutData(layout);
		return tmp;
	}
	private Combo addCombo(Composite parent, int style, GridData layout) {
		Combo tmp = new Combo(parent, style);
		tmp.setLayoutData(layout);
		return tmp;
	}

	@Override
	public void createPartControl(Composite parent) {
		ThreatAnalysisService.getInstance().sub(this);
		this.parent = parent;
		GridLayout gl = new GridLayout(1,false);
		parent.setLayout(gl);

		Composite header = new Composite(parent, SWT.BORDER);
		GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
	    header.setLayout(new GridLayout(5, true));
		header.setLayoutData(gd);



		GridData gd_fillh = new GridData(SWT.FILL,SWT.TOP,true,false);
		GridData gd_r = new GridData(SWT.FILL,SWT.TOP,true,false);

		addLabel(header, "Threatcount: ", gd_r).setAlignment(SWT.TRAIL);

		countLabel = addLabel(header, empty, gd_fillh);

		addLabel(header, "", gd_r).setAlignment(SWT.TRAIL);

		GridData gdst = new GridData(SWT.FILL, SWT.CENTER, true, false);
	    gdst.horizontalSpan = 5;


		Composite statusBar = new Composite(header, SWT.BORDER);
	    statusBar.setLayout(new GridLayout(1, false));
	    statusBar.setLayoutData(gdst);

	    riskRedurLabel = addLabel(statusBar, riskRedur, gdst);

	    progressBar = new ProgressBar(statusBar, SWT.SMOOTH);
	    progressBar.setLayoutData(gdst);
	    progressBar.setMaximum(100);
	    progressBar.setSelection(0);


	    addLabel(header, "Mitigated annualized risk:", gd_r).setAlignment(SWT.TRAIL);;
	    mitigatedRisk = addLabel(header, empty, gd_fillh);
	    addLabel(header, "Total annualized risk:", gd_r).setAlignment(SWT.TRAIL);
	    totalRisk = addLabel(header, empty, gd_fillh);
	    addLabel(header, empty, gd_fillh);

	    addLabel(header, "Residual annualized risk:", gd_r).setAlignment(SWT.TRAIL);
	    residualRisk = addLabel(header, empty, gd_fillh);
	    addLabel(header, "Maximum single loss event: ", gd_r).setAlignment(SWT.TRAIL);
	    sleRisk = addLabel(header, empty, gd_fillh);
	    addLabel(header, empty, gd_fillh);



		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);

		setupTable(viewer);

		makeActions();
		hookDoubleClickAction();
		contributeToActionBars();
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
		TableViewerColumn idCol = new TableViewerColumn(viewer, SWT.NONE);

		final TableColumn tc = idCol.getColumn();
		tc.setText("Location");
		tc.setWidth(100);
		new ThreatSorter(viewer, idCol) {
			@Override
			protected int compareImpl(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof ObservableThreat && e2 instanceof ObservableThreat) {
					ObservableThreat t1 = (ObservableThreat) e1;
					ObservableThreat t2 = (ObservableThreat) e2;
					return Comparator.nullsFirst(Comparator.<String>naturalOrder())
							.compare(t1.getThreatenedElementName(), t2.getThreatenedElementName());
				} else
					return super.compareImpl(viewer, e1, e2);
			}
		};

		createCol(viewer,"Type",100, ObservableThreat::getThreatTypeName);
		createCol(viewer,"Name", 100, ObservableThreat::getThreat);
		createCol(viewer,"Flow",100, ObservableThreat::getFlow);
		createCol(viewer,"Risk",60,SWT.RIGHT, ObservableThreat::getRiskAsDouble);
//		createCol(viewer,"risk_LB", 80,SWT.RIGHT, ObservableThreat::getRisk_lowerAsDouble);
//		createCol(viewer,"risk_UB", 80,SWT.RIGHT, ObservableThreat::getRisk_upperAsDouble);
		createCol(viewer,"SLE (Single Loss Event)", 80,SWT.RIGHT, ObservableThreat::getSleAsDouble);
		createCol(viewer,"Vulnerability",60, ObservableThreat::getVulnerabilityAsDouble);
//		createCol(viewer,"LB", 60, ObservableThreat::getVulnerability_lowerAsDouble);
//		createCol(viewer,"UB", 60,ObservableThreat::getVulnerability_upperAsDouble);
		createCol(viewer,"LEF (Loss Event Frequency)", 40,ObservableThreat::getLefAsDouble);
		createCol(viewer,"Description", 500, ObservableThreat::getDescription);
//		createCol(viewer,"mitigationstatus",80,Threat::getMitigationStatus);
//		createCol(viewer,"message",100,Threat::toString);

	}

	private <U extends Comparable<? super U>> void createCol(TableViewer viewer, final String colname, int width, Function<? super ObservableThreat, ? extends U> keyExtractor) {
		createCol(viewer, colname, width, SWT.LEFT, keyExtractor);
	}

	private <U extends Comparable<? super U>> void createCol(TableViewer viewer, final String colname, int width, int alignment, Function<? super ObservableThreat, ? extends U> keyExtractor) {
		Comparator<? super ObservableThreat> cmp = Comparator.comparing(keyExtractor,
				Comparator.nullsFirst(Comparator.naturalOrder()));
		TableViewerColumn col = new TableViewerColumn(viewer, SWT.NONE);

		final TableColumn tc = col.getColumn();
		tc.setText(colname);
		tc.setWidth(width);
		tc.setMoveable(true);
		tc.setAlignment(alignment);
		new ThreatSorter(viewer, col) {
			@Override
			protected int compareImpl(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof ObservableThreat && e2 instanceof ObservableThreat) {
					ObservableThreat t1 = (ObservableThreat) e1;
					ObservableThreat t2 = (ObservableThreat) e2;
					return cmp.compare(t1,  t2);
				} else
					return super.compareImpl(viewer, e1, e2);
			}
		};

	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalToolBar(IToolBarManager manager) {

	}


	private Resource loadedResource;

	public void load(Resource resource) {
			this.loadedResource = resource;

			ml = ThreatAnalysisService.getInstance().observableThreatList();

			bind(
					viewer,
					ml,
					new IValueProperty[] {
							PojoProperties.value(ObservableThreat.class,"threatenedElementName"),
							PojoProperties.value(ObservableThreat.class,"threatTypeName"),
							PojoProperties.value(ObservableThreat.class,"threat"),
							PojoProperties.value(ObservableThreat.class,"flow"),
							PojoProperties.value(ObservableThreat.class, "riskString"),
//							PojoProperties.value(ObservableThreat.class, "risk_lowerString"),
//							PojoProperties.value(ObservableThreat.class, "risk_upperString"),
							PojoProperties.value(ObservableThreat.class, "sleString"),
							PojoProperties.value(ObservableThreat.class, "vulnerabilityString"),
//							PojoProperties.value(ObservableThreat.class, "vulnerability_lowerString"),
//							PojoProperties.value(ObservableThreat.class, "vulnerability_upperString"),
							PojoProperties.value(ObservableThreat.class, "lefString"),
							PojoProperties.value(ObservableThreat.class, "description"),
//							PojoProperties.value(Threat.class,"mitigationStatus"),
//							PojoProperties.value(Threat.class,"message"),
							}
					);


			processRiskChange(ml);

		viewer.refresh();
		countLabel.setText("" + viewer.getTable().getItemCount());
	}

	private void processRiskChange(AbstractObservableList<? extends ObservableThreat> ml) {
		countLabel.setText("" + viewer.getTable().getItemCount());
		double max = ml.stream().mapToDouble(t -> t.getPotentialRiskAsDouble()).sum();
		double residual = ml.stream().mapToDouble(t -> t.getRiskAsDouble()).sum();
		double reduction = max - residual;
		// Scale to a fixed 0-100 range: casting the raw fractional risk sum to int
		// truncates large totals and setMaximum(0) (no potential risk) is invalid.
		progressBar.setMaximum(100);
		int reductionPercentage = (max > 0) ? (int) Math.round((reduction / max) * 100) : 0;
		progressBar.setSelection(reductionPercentage);
		NumberFormat nf = ObservableThreat.newCurrencyFormat();
		riskRedurLabel.setText(riskRedur + nf.format(reduction)+ " of total risk " + nf.format(max) + " reduced.");

		mitigatedRisk.setText(nf.format(reduction));
		residualRisk.setText(nf.format(residual));
		totalRisk.setText(nf.format(max));
		sleRisk.setText(nf.format(ml.stream().mapToDouble(t -> t.getSleAsDouble()).max().orElse(0d)));
	}

	private void bind(StructuredViewer viewer, IObservableList<? extends ObservableThreat> input, IValueProperty... labelProperties) {
		ObservableListContentProvider<ObservableThreat> contentProvider = new ObservableListContentProvider<>();
		if (viewer.getInput() != null)
			viewer.setInput(null);
		viewer.setContentProvider(contentProvider);
		ColouredObservableMapLabelProvider lp = new ColouredObservableMapLabelProvider(Properties
				.observeEach(contentProvider.getKnownElements(),
						labelProperties), input);
		viewer.setLabelProvider(lp);
		viewer.setInput(input);
	}

	private void makeActions() {
		doubleClickAction = new Action() {
			public void run() {
				IStructuredSelection selection = viewer.getStructuredSelection();
				Object obj = selection.getFirstElement();
				if (obj instanceof ObservableThreat) {
					ObservableThreat t = (ObservableThreat) obj;
					showMessage(t.getThreat() + " threat",t.getFullDescription()
							);

				}

			}
		};
	}
	private Action doubleClickAction;

	private AbstractObservableList<? extends ObservableThreat> ml;

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		showMessage("ThreatAnalysis", message);
	}
	private void showMessage(String title, String message) {
		MessageDialog.openInformation(
			parent.getShell(),
			title,
			message);
	}



    public static ThreatAnalysis getInstance(IWorkbenchWindow activeWorkbenchWindow) {
        IWorkbenchPart instance = null;
        if (activeWorkbenchWindow != null && activeWorkbenchWindow.getActivePage() != null) {
            instance = activeWorkbenchWindow.getActivePage().getActivePart();
            if (!(instance instanceof ThreatAnalysis)) {
                instance = activeWorkbenchWindow.getActivePage().findView(ID);
            }
        }
        return (ThreatAnalysis) instance;
    }

    public List<? extends ObservableThreat> getThreatList() {
    	return ml.stream().collect(Collectors.toList());
    }
    public Resource getLoadedResource() {
    	return loadedResource;
    }

	private IChangeListener changeListener = new IChangeListener() {

		@Override
		public void handleChange(ChangeEvent event) {
			// A list change may be delivered off the SWT UI thread (VIATRA match
			// propagation); marshal the widget updates onto the display thread,
			// mirroring ColouredObservableMapLabelProvider.handleListChange.
			if (viewer == null || viewer.getTable().isDisposed()) {
				return;
			}
			Display display = viewer.getTable().getDisplay();
			display.asyncExec(() -> {
				if (viewer == null || viewer.getTable().isDisposed() || ml == null) {
					return;
				}
				processRiskChange(ml);
			});
		}


	};


	@Override
	public void setFocus() {
		parent.setFocus();
	}
	@Override
	public void analysisResultsAvailable() {
		// Detach from the previously bound list before load() reassigns `ml`. On
		// plain property-change notifications the service reuses the same MultiList
		// instance, so re-adding without removing would accumulate one duplicate
		// change listener per editor edit (each firing a full risk recomputation).
		if (ml != null) {
			ml.removeChangeListener(changeListener);
		}
		load(ThreatAnalysisService.getInstance().getResource());
		ml.addChangeListener(changeListener);

	}
	@Override
	public void invalidatePreviousBindings() {
		// The service owns the MultiList lifecycle (it disposes it in clear()).
		// The view only detaches its own change listener and drops its reference.
		if (ml != null) {
			ml.removeChangeListener(changeListener);
			ml = null;
		}
		if (viewer != null && !viewer.getTable().isDisposed()) {
			viewer.setInput(null);
		}
	}

	@Override
	public void dispose() {
		ThreatAnalysisService.getInstance().unSub(this);
		if (ml != null) {
			ml.removeChangeListener(changeListener);
			ml = null;
		}
		super.dispose();
	}

}
