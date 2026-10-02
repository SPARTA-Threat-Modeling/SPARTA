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
import java.util.function.Function;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import be.kuleuven.cs.distrinet.sparta.analysis.views.sorter.ThreatSorter;

/**
 * Common table-view plumbing shared by the SPARTA analysis views: table and
 * column setup with sortable columns, JFace databinding of an observable list
 * input, the double-click action hook, and the information dialog helper.
 *
 * @param <T> the row type shown in the table
 */
public abstract class AbstractThreatTableView<T> extends ViewPart {

	protected TableViewer viewer;

	protected Composite parent;

	protected Action doubleClickAction;

	private final Class<T> rowType;

	protected AbstractThreatTableView(Class<T> rowType) {
		this.rowType = rowType;
	}

	protected void setupTable(TableViewer viewer) {
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

	/** Create the view-specific columns; called once from {@link #setupTable(TableViewer)}. */
	protected abstract void createColumns(TableViewer viewer);

	/**
	 * Attach a {@link ThreatSorter} to the given column that orders rows of this
	 * view's row type with the given comparator and defers to the default
	 * (toString-based) comparison otherwise.
	 */
	protected void addColumnSorter(TableViewer viewer, TableViewerColumn col, Comparator<? super T> cmp) {
		new ThreatSorter(viewer, col) {
			@Override
			protected int compareImpl(Viewer viewer, Object e1, Object e2) {
				if (rowType.isInstance(e1) && rowType.isInstance(e2)) {
					return cmp.compare(rowType.cast(e1), rowType.cast(e2));
				} else
					return super.compareImpl(viewer, e1, e2);
			}
		};
	}

	protected <U extends Comparable<? super U>> void createCol(TableViewer viewer, final String colname, int width, Function<? super T, ? extends U> keyExtractor) {
		createCol(viewer, colname, width, SWT.LEFT, keyExtractor);
	}

	protected <U extends Comparable<? super U>> void createCol(TableViewer viewer, final String colname, int width, int alignment, Function<? super T, ? extends U> keyExtractor) {
		Comparator<? super T> cmp = Comparator.comparing(keyExtractor,
				Comparator.nullsFirst(Comparator.naturalOrder()));
		TableViewerColumn col = new TableViewerColumn(viewer, SWT.NONE);

		final TableColumn tc = col.getColumn();
		tc.setText(colname);
		tc.setWidth(width);
		tc.setMoveable(true);
		tc.setAlignment(alignment);
		addColumnSorter(viewer, col, cmp);

	}

	protected void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void bind(StructuredViewer viewer, IObservableList<? extends T> input, IValueProperty... labelProperties) {
		ObservableListContentProvider<T> contentProvider = new ObservableListContentProvider<>();
		if (viewer.getInput() != null)
			viewer.setInput(null);
		viewer.setContentProvider(contentProvider);
		IBaseLabelProvider lp = createLabelProvider(Properties
				.observeEach(contentProvider.getKnownElements(),
						labelProperties), input);
		viewer.setLabelProvider(lp);
		viewer.setInput(input);
	}

	/** Create the view-specific label provider for {@link #bind(StructuredViewer, IObservableList, IValueProperty...)}. */
	@SuppressWarnings("rawtypes")
	protected abstract IBaseLabelProvider createLabelProvider(IObservableMap[] attributeMaps,
			IObservableList<? extends T> input);

	protected void showMessage(String title, String message) {
		MessageDialog.openInformation(
			parent.getShell(),
			title,
			message);
	}

	@Override
	public void setFocus() {
		parent.setFocus();
	}

}
