/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.views.sorter;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

/**
 * Threat sorter class to enable sorting the threats in a table.
 * @author Laurens
 *
 */
public abstract class ThreatSorter extends ViewerComparator {
		private int direction = 0;
		private final TableViewerColumn column;
		private final ColumnViewer viewer;
		
		public ThreatSorter(ColumnViewer viewer, TableViewerColumn column) {
			this.viewer = viewer;
			this.column = column;
			SelectionAdapter selectionAdapter = createSelectionAdapter();
			this.column.getColumn().addSelectionListener(selectionAdapter);
		}

		private SelectionAdapter createSelectionAdapter() {
			return new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					toggleSort();
				}
				
			};
		}
		private void setSorter() {
			Table table = column.getColumn().getParent();
			if (direction == 0) {
				table.setSortColumn(null);
				table.setSortDirection(SWT.NONE);
				viewer.setComparator(null);
			} else {
				table.setSortColumn(column.getColumn());
				// show arrows
				table.setSortDirection(direction == 1 ? SWT.UP : SWT.DOWN);;
				viewer.setComparator(this);
				viewer.refresh();
			}
			
		}
		
		public void toggleSort() {
			direction = ((direction + 2) % 3) - 1;
			setSorter();
		}


		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			return direction * compareImpl(viewer, e1, e2);
		}
		
		protected int compareImpl(Viewer viewer, Object e1, Object e2) {
			return e1.toString().compareTo(e2.toString());
		}
}