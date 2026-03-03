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
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;

/**
 * A {@link ThreatWriter} to export one or more threats to a csv file. This
 * writer does not automatically write a CSV header. If this is needed it can be
 * manually written out using {@link ThreatCSVWriter#write(String)} or
 * {@link ThreatCSVWriter#writeHeader()}.
 * 
 * @author Laurens
 *
 */
public class ThreatCSVWriter extends ThreatWriter {

	/**
	 * Create a new {@link ThreatCSVWriter} to provided support for writing out a
	 * default set of threat properties to text-based files.
	 * 
	 * @param writer a writer
	 */
	public ThreatCSVWriter(Writer writer) {
		super(writer);
	}

	/**
	 * Create a new {@link ThreatCSVWriter} to provided support for writing out a
	 * specified set of threat properties to text-based files. If any of the
	 * provided functions return a {@link ModelElement}, the {@link ThreatWriter}
	 * will attempt to retrieve the name of the element when writing it to the
	 * output writer.
	 * 
	 * @param writer     a writer
	 * @param properties a set of functions, which applied to a threat provide the
	 *                   property to write out
	 */
	public ThreatCSVWriter(Writer writer, Map<String, Function<Threat, ? extends Object>> properties) {
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
		write(getProperties().entrySet().stream().map(Entry::getValue).map(f -> f.apply(threat)).map(x -> Objects.toString(x,"")).map(this::wrap)
				.collect(Collectors.joining(";")));
		newLine();
	}
	
	private String wrap(String arg) {
		return "\"" + arg + "\"";
	}

	/**
	 * Write a csv header based on the provided set of property names in
	 * {@link ThreatCSVWriter#ThreatCSVWriter(Writer, Map)}
	 * 
	 * @throws IOException If an I/O error occurs
	 */
	public void writeHeader() throws IOException {
		write(getProperties().keySet().stream().map(this::wrap).collect(Collectors.joining(";")));
		newLine();
	}

}
