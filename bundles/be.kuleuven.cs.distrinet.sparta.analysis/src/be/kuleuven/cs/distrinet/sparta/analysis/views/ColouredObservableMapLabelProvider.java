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

import java.util.HashMap;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;

/**
 * Map label provider to enable colored threat list. The colors are determined
 * by the maximum potential threat value to ensure the coloring remains
 * consistent over time.
 * 
 * @author Laurens
 *
 */
public class ColouredObservableMapLabelProvider extends ObservableMapLabelProvider
		implements IColorProvider, IListChangeListener<ObservableThreat>, IChangeListener {

	private static final HashMap<Triple, Color> colormap = new HashMap<Triple, Color>();
	private double minValue = 0;
	private double medValue = 1000;
	private double maxValue = 10000;

	@SuppressWarnings("rawtypes")
	public ColouredObservableMapLabelProvider(IObservableMap attributeMap) {
		this(new IObservableMap[] { attributeMap });
	}

	@SuppressWarnings("rawtypes")
	public ColouredObservableMapLabelProvider(IObservableMap[] attributeMap) {
		super(attributeMap);
	}

	@SuppressWarnings("rawtypes")
	public ColouredObservableMapLabelProvider(IObservableMap[] attributeMap,
			IObservableList<? extends ObservableThreat> input) {
		this(attributeMap);
		input.addListChangeListener(this);
		input.addChangeListener(this);
		try {
			calcRiskBoundaries(input);
		} catch (Exception e) {

		}
	}

	private void calcRiskBoundaries(IObservableList<? extends ObservableThreat> input) {
		double min = 0;
		double max = input.stream().mapToDouble(t -> t.getPotentialRiskAsDouble()).max().getAsDouble();
		double med = (min + max) / 2;
		minValue = min;
		medValue = med;
		maxValue = max;
		if (max <= 0) {
			minValue = -1;
			medValue = 0;
			maxValue = 1;
		}
	}

	@Override
	public Color getForeground(Object element) {
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		if (element instanceof ObservableThreat) {
			double r = ((ObservableThreat) element).getRiskAsDouble();
			if (r > medValue) {
				return getColor(Triple.interPol(med, high, (r - medValue) / (maxValue - medValue)));
			} else {
				return getColor(Triple.interPol(low, med, (r - minValue) / (medValue - minValue)));
			}
		}
		return getColor(high);
	}

	private static Color getColor(Triple col) {
		if (!col.validColor())
			return new Color(Display.getDefault(), 255, 255, 255, 255);
		Color c = colormap.get(col);
		if (c == null) {
			c = new Color(Display.getDefault(), col.getX(), col.getY(), col.getZ(), 255);
			colormap.put(col, c);
		}
		return c;
	}

	public static final Triple high = new Triple(231, 76, 60);
	public static final Triple med = new Triple(230, 126, 34);
	public static final Triple low = new Triple(46, 204, 113);

	private static final class Triple {
		private Integer x;
		private Integer y;
		private Integer z;

		public Triple() {
			this(0, 0, 0);
		}

		public boolean validColor() {
			return (x >= 0 && x <= 255 && y >= 0 && y <= 255 && z >= 0 && z <= 255);
		}

		public Triple(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public Integer getX() {
			return x;
		}

		public void setX(Integer x) {
			this.x = x;
		}

		public Integer getY() {
			return y;
		}

		public void setY(Integer y) {
			this.y = y;
		}

		public Integer getZ() {
			return z;
		}

		public void setZ(Integer z) {
			this.z = z;
		}

		private static int inter(int x, int y, double pct) {
			return (int) (((1.0 - pct) * x) + (pct * y));
		}

		public static Triple interPol(Triple t1, Triple t2, double pct) {
			Triple t = new Triple();
			t.setX(inter(t1.getX(), t2.getX(), pct));
			t.setY(inter(t1.getY(), t2.getY(), pct));
			t.setZ(inter(t1.getZ(), t2.getZ(), pct));
			return t;

		}

		@Override
		public String toString() {
			return "Triple(X:" + x + " Y:" + y + " Z:" + z + ")";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((x == null) ? 0 : x.hashCode());
			result = prime * result + ((y == null) ? 0 : y.hashCode());
			result = prime * result + ((z == null) ? 0 : z.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Triple other = (Triple) obj;
			if (x == null) {
				if (other.x != null)
					return false;
			} else if (!x.equals(other.x))
				return false;
			if (y == null) {
				if (other.y != null)
					return false;
			} else if (!y.equals(other.y))
				return false;
			if (z == null) {
				if (other.z != null)
					return false;
			} else if (!z.equals(other.z))
				return false;
			return true;
		}

	}

	@Override
	public void handleListChange(ListChangeEvent<? extends ObservableThreat> event) {
		event.getObservableList().getRealm().asyncExec(new Runnable() {

			@Override
			public void run() {
				if (event.getObservable().isDisposed()) {
					return;
				}
				calcRiskBoundaries(event.getObservableList());
				fireLabelProviderChanged(new LabelProviderChangedEvent(ColouredObservableMapLabelProvider.this));

			}

		});
	}

	@Override
	public void handleChange(ChangeEvent event) {
		fireLabelProviderChanged(new LabelProviderChangedEvent(this));
	}
}
