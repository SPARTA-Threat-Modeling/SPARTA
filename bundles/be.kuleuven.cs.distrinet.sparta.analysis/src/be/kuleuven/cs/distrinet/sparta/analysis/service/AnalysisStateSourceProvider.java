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

import java.util.Map;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

/**
 * Publishes whether {@link ThreatAnalysisService} currently holds analysis results as the
 * {@value #RESULTS_AVAILABLE} variable, so commands that need results (the exports) can be
 * enabled declaratively with {@code enabledWhen}. The menu, main toolbar and view toolbar
 * items then follow the analysis state without loading their handlers.
 */
public class AnalysisStateSourceProvider extends AbstractSourceProvider implements AnalysisListener {

	public static final String RESULTS_AVAILABLE = "be.kuleuven.cs.distrinet.sparta.analysis.resultsAvailable";

	private static final String[] PROVIDED_SOURCE_NAMES = { RESULTS_AVAILABLE };

	public AnalysisStateSourceProvider() {
		ThreatAnalysisService.getInstance().sub(this);
	}

	@Override
	public Map<String, Object> getCurrentState() {
		return Map.of(RESULTS_AVAILABLE, ThreatAnalysisService.getInstance().hasResults());
	}

	@Override
	public String[] getProvidedSourceNames() {
		return PROVIDED_SOURCE_NAMES;
	}

	@Override
	public void analysisResultsAvailable() {
		fireStateChanged();
	}

	@Override
	public void invalidatePreviousBindings() {
		fireStateChanged();
	}

	@Override
	public void dispose() {
		ThreatAnalysisService.getInstance().unSub(this);
	}

	/** Source changes must be fired on the UI thread; the state is re-read when delivered. */
	private void fireStateChanged() {
		Runnable fire = () -> fireSourceChanged(ISources.WORKBENCH, RESULTS_AVAILABLE,
				ThreatAnalysisService.getInstance().hasResults());
		if (Display.getCurrent() != null) {
			fire.run();
		} else {
			Display.getDefault().asyncExec(fire);
		}
	}
}
