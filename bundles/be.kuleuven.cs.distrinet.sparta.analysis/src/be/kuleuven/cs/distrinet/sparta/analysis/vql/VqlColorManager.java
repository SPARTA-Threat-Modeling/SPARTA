/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.vql;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Small cache of {@link Color} resources keyed by {@link RGB}. SWT colors are OS
 * resources and must be disposed; callers create one manager per editor/dialog and
 * {@link #dispose()} it when the widget is torn down.
 */
public class VqlColorManager {

	private final Map<RGB, Color> colors = new HashMap<>();

	public Color getColor(RGB rgb) {
		return colors.computeIfAbsent(rgb, r -> new Color(Display.getCurrent(), r));
	}

	public void dispose() {
		colors.values().forEach(Color::dispose);
		colors.clear();
	}
}
