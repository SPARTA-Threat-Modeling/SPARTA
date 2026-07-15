/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.conversion;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;
import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;

/**
 * Converter class for enabling the automatic conversion of viatra pattern
 * matches to observable threat objects.
 *
 * @author Laurens
 *
 */
public class ThreatConverter extends Converter<IPatternMatch, ObservableThreat> {

	protected DataBindingContext dbc;
	protected final RiskAssessmentLoopConfiguration loopConfiguration;

	public ThreatConverter(DataBindingContext dbc, RiskAssessmentLoopConfiguration loopConfiguration) {
		super(IPatternMatch.class, ObservableThreat.class);
		this.dbc = dbc;
		this.loopConfiguration = loopConfiguration;
	}

	@Override
	public ObservableThreat convert(IPatternMatch fromObject) {
		return new ObservableThreat(dbc, fromObject, loopConfiguration);
	}

}
