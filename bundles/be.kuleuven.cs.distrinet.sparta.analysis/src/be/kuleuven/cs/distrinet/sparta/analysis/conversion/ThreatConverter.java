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

/**
 * Converter class for enabling the automatic conversion of viatra pattern
 * matches to observable threat objects.
 * 
 * @author Laurens
 *
 */
public class ThreatConverter extends Converter<IPatternMatch, ObservableThreat> {

	protected DataBindingContext dbc;

	public ThreatConverter(DataBindingContext dbc) {
		super(IPatternMatch.class, ObservableThreat.class);
		this.dbc = dbc;
	}

	@Override
	public ObservableThreat convert(IPatternMatch fromObject) {
		if (!(fromObject instanceof IPatternMatch))
			throw new IllegalArgumentException();
		IPatternMatch pm = (IPatternMatch) fromObject;
		return new ObservableThreat(dbc, pm);
	}

}
