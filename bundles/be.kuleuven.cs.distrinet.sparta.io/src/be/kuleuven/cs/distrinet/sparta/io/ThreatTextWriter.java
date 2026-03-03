/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;

/**
 * Simple textwriter for outputing threats to a set of text files. Users of this
 * class should rely a specific text format for automated processing. Other
 * output formats are more suitable for post-processing.
 * 
 * @author Laurens
 *
 */
public class ThreatTextWriter extends ThreatWriter {

	/**
	 * Create a new {@link ThreatTextWriter} to provided support for writing out a
	 * default set of threat properties to text files.
	 * 
	 * @param writer a writer
	 */
	public ThreatTextWriter(Writer writer) {
		super(writer);
	}

	/**
	 * Create a new {@link ThreatTextWriter} to provided support for writing out a
	 * default set of threat properties to text files. If any of the provided
	 * functions return a {@link ModelElement}, the {@link ThreatWriter} will
	 * attempt to retrieve the name of the element when writing it to the output
	 * writer.
	 * 
	 * @param writer     a writer
	 * @param properties a set of functions, which applied to a threat provide the
	 *                   property to write out
	 */
	public ThreatTextWriter(Writer writer, Map<String, Function<Threat, ? extends Object>> properties) {
		super(writer, properties);

	}

	/**
	 * Write-out a threat
	 * 
	 * @param threat the {@link Threat} to write out
	 * @throws IOException If an I/O error occurs.
	 */
	@Override
	public void write(Threat threat) throws IOException {
		for (Entry<String, Function<Threat, ? extends Object>> e : getProperties().entrySet()) {
			write(e.getKey());
			write(":\t");
			write("" + e.getValue().apply(threat));
			newLine();
		}
	}

	/**
	 * Provide a suggested filename for writing out the threat. This suggestion
	 * concatenates a number of the {@link Threat}'s properties to attempt to obtain
	 * unique filenames for every {@link Threat}.
	 * 
	 * @param threat The threat for which to generate a suggested filename.
	 * @return The suggested filename.
	 */
	public static String fileNameSuggestion(Threat threat) {
		List<Function<Threat, ? extends Object>> fs = Arrays.asList(Threat::getThreatType, Threat::getThreatenedElement,
				Threat::getDataFlow);
		return fs.stream().map(f -> f.apply(threat)).map(ModelElement.class::cast).map(ModelElement::getName)
				.collect(Collectors.joining("_")).replaceAll("\\W+", " ") + ".txt";
	}

}
