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
import java.util.Map;

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
import be.kuleuven.cs.distrinet.sparta.analysis.util.ColorTriple;
import be.kuleuven.cs.distrinet.sparta.analysis.util.RiskBoundaries;

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

	public static final ColorTriple high = new ColorTriple(231, 76, 60);
	public static final ColorTriple med = new ColorTriple(230, 126, 34);
	public static final ColorTriple low = new ColorTriple(46, 204, 113);

	private static final ColorTriple WHITE = new ColorTriple(255, 255, 255);

	/**
	 * Per-instance cache of the SWT colours handed out by this label provider.
	 * Instance scoped (not static) so that {@link #dispose()} can release every
	 * colour when the label provider goes away, avoiding the SWT resource leak.
	 */
	private final Map<ColorTriple, Color> colormap = new HashMap<>();

	private IObservableList<? extends ObservableThreat> input;

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
		this.input = input;
		input.addListChangeListener(this);
		input.addChangeListener(this);
		calcRiskBoundaries(input);
	}

	private void calcRiskBoundaries(IObservableList<? extends ObservableThreat> input) {
		double max = input.stream().mapToDouble(ObservableThreat::getPotentialRiskAsDouble).max().orElse(0);
		double[] boundaries = RiskBoundaries.compute(max);
		minValue = boundaries[0];
		medValue = boundaries[1];
		maxValue = boundaries[2];
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
				return getColor(ColorTriple.interPol(med, high, (r - medValue) / (maxValue - medValue)));
			} else {
				return getColor(ColorTriple.interPol(low, med, (r - minValue) / (medValue - minValue)));
			}
		}
		return getColor(high);
	}

	private Color getColor(ColorTriple col) {
		ColorTriple key = col.validColor() ? col : WHITE;
		return colormap.computeIfAbsent(key,
				k -> new Color(Display.getDefault(), k.getX(), k.getY(), k.getZ(), 255));
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

	@Override
	public void dispose() {
		if (input != null && !input.isDisposed()) {
			input.removeListChangeListener(this);
			input.removeChangeListener(this);
		}
		input = null;
		for (Color color : colormap.values()) {
			if (color != null && !color.isDisposed()) {
				color.dispose();
			}
		}
		colormap.clear();
		super.dispose();
	}
}
