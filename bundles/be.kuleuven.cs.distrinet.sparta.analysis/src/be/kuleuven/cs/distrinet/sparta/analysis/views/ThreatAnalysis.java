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

import org.eclipse.core.databinding.beans.typed.PojoProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.AbstractObservableList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TableColumn;

import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;
import be.kuleuven.cs.distrinet.sparta.analysis.service.AnalysisListener;
import be.kuleuven.cs.distrinet.sparta.analysis.service.ThreatAnalysisService;


/**
 * This class provides the SPARTA Threat Analysis view to present the user with
 * a sortable list of threats and manage the risk reduction progress.
 *
 */

public class ThreatAnalysis extends AbstractThreatTableView<ObservableThreat> implements AnalysisListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "be.kuleuven.cs.distrinet.sparta.analysis.views.ThreatAnalysis";

	public ThreatAnalysis() {
		super(ObservableThreat.class);
	}

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
		// The service only notifies on the next load, so a view opened after an analysis
		// already ran would stay empty; bind to the existing results now that the widgets exist.
		if (ThreatAnalysisService.getInstance().hasResults()) {
			analysisResultsAvailable();
		}
	}

	@Override
	protected void createColumns(TableViewer viewer) {
		TableViewerColumn idCol = new TableViewerColumn(viewer, SWT.NONE);

		final TableColumn tc = idCol.getColumn();
		tc.setText("Location");
		tc.setWidth(100);
		addColumnSorter(viewer, idCol, Comparator.comparing(ObservableThreat::getThreatenedElementName,
				Comparator.nullsFirst(Comparator.<String>naturalOrder())));

		createCol(viewer,"Type",100, ObservableThreat::getThreatTypeName);
		createCol(viewer,"Name", 100, ObservableThreat::getThreat);
		createCol(viewer,"Flow",100, ObservableThreat::getFlow);
		createCol(viewer,"Risk",60,SWT.RIGHT, ObservableThreat::getRiskAsDouble);
		createCol(viewer,"SLE (Single Loss Event)", 80,SWT.RIGHT, ObservableThreat::getSleAsDouble);
		createCol(viewer,"Vulnerability",60, ObservableThreat::getVulnerabilityAsDouble);
		createCol(viewer,"LEF (Loss Event Frequency)", 40,ObservableThreat::getLefAsDouble);
		createCol(viewer,"Description", 500, ObservableThreat::getDescription);

	}

	private void load() {
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
							PojoProperties.value(ObservableThreat.class, "sleString"),
							PojoProperties.value(ObservableThreat.class, "vulnerabilityString"),
							PojoProperties.value(ObservableThreat.class, "lefString"),
							PojoProperties.value(ObservableThreat.class, "description"),
							}
					);


			processRiskChange(ml);

		viewer.refresh();
	}

	private void processRiskChange(AbstractObservableList<? extends ObservableThreat> ml) {
		countLabel.setText("" + viewer.getTable().getItemCount());
		double max = ml.stream().mapToDouble(t -> t.getPotentialRiskAsDouble()).sum();
		double residual = ml.stream().mapToDouble(t -> t.getRiskAsDouble()).sum();
		double reduction = max - residual;
		// Scale to the fixed 0-100 range set up in createPartControl: casting the raw
		// fractional risk sum to int truncates large totals.
		int reductionPercentage = (max > 0) ? (int) Math.round((reduction / max) * 100) : 0;
		progressBar.setSelection(reductionPercentage);
		NumberFormat nf = ObservableThreat.newCurrencyFormat();
		riskRedurLabel.setText(riskRedur + nf.format(reduction)+ " of total risk " + nf.format(max) + " reduced.");

		mitigatedRisk.setText(nf.format(reduction));
		residualRisk.setText(nf.format(residual));
		totalRisk.setText(nf.format(max));
		sleRisk.setText(nf.format(ml.stream().mapToDouble(t -> t.getSleAsDouble()).max().orElse(0d)));
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseLabelProvider createLabelProvider(IObservableMap[] attributeMaps,
			IObservableList<? extends ObservableThreat> input) {
		return new ColouredObservableMapLabelProvider(attributeMaps, input);
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

	private AbstractObservableList<? extends ObservableThreat> ml;


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
	public void analysisResultsAvailable() {
		// Detach from the previously bound list before load() reassigns `ml`. On
		// plain property-change notifications the service reuses the same MultiList
		// instance, so re-adding without removing would accumulate one duplicate
		// change listener per editor edit (each firing a full risk recomputation).
		if (ml != null) {
			ml.removeChangeListener(changeListener);
		}
		load();
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
			resetSummary();
		}
	}

	/** Restore the header to its state before any analysis, so cleared results leave no stale figures. */
	private void resetSummary() {
		countLabel.setText(empty);
		riskRedurLabel.setText(riskRedur);
		progressBar.setSelection(0);
		mitigatedRisk.setText(empty);
		residualRisk.setText(empty);
		totalRisk.setText(empty);
		sleRisk.setText(empty);
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
