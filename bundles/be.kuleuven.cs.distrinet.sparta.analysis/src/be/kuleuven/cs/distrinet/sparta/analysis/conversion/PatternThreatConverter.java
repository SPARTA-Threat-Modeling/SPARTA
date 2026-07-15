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

import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservablePatternThreat;
import be.kuleuven.cs.distrinet.sparta.analysis.model.ObservableThreat;
import be.kuleuven.cs.distrinet.sparta.core.analysis.RiskAssessmentLoopConfiguration;
import be.kuleuven.cs.distrinet.sparta.core.patterns.ThreatPatternMatchMetadata;

public class PatternThreatConverter extends Converter<IPatternMatch, ObservableThreat> {

	protected DataBindingContext dbc;
	protected ThreatPatternMatchMetadata metadata;
	protected final RiskAssessmentLoopConfiguration loopConfiguration;

	public PatternThreatConverter(DataBindingContext dbc, ThreatPatternMatchMetadata metadata,
			RiskAssessmentLoopConfiguration loopConfiguration) {
		super(IPatternMatch.class, ObservableThreat.class);
		this.dbc = dbc;
		this.metadata = metadata;
		this.loopConfiguration = loopConfiguration;
	}

	@Override
	public ObservableThreat convert(IPatternMatch fromObject) {
		return new ObservablePatternThreat(dbc, fromObject, metadata, loopConfiguration);
	}
}
