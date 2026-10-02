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
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;

/**
 * As not all output files are text-based (for example, xlsx),
 * {@link ThreatOutputStream} enables the use of {@link OutputStream} to export
 * information on elicited {@link Threat}s.
 * 
 * @author Laurens
 *
 */
public abstract class ThreatOutputStream extends OutputStream {

	protected final OutputStream outputStream;
	private final LinkedHashMap<String, Function<Threat, ? extends Object>> properties;

	/**
	 * Create a new {@link ThreatOutputStream} that writes to out.
	 * 
	 * @param out the {@link OutputStream} to use.
	 */
	public ThreatOutputStream(OutputStream out) {
		this(out, null);
	}

	/**
	 * Create a new {@link ThreatOutputStream} that writes to out. If any of the
	 * provided functions return a {@link ModelElement}, the {@link ThreatWriter}
	 * will attempt to retrieve the name of the element when writing it to the
	 * output writer. Unlike the text-based {@link ThreatWriter} hierarchy, Double
	 * values are deliberately left raw so subclasses can emit typed (numeric)
	 * cells (see {@link ThreatProperties#forTypedOutput(Map)}).
	 *
	 *
	 * @param out        the {@link OutputStream} to use.
	 * @param properties a set of functions, which applied to a threat provide the
	 *                   property to write out
	 */
	public ThreatOutputStream(OutputStream out, Map<String, Function<Threat, ? extends Object>> properties) {
		this.outputStream = out;
		this.properties = ThreatProperties.forTypedOutput(properties);
	}

	@Override
	public void close() throws IOException {
		this.outputStream.close();

	}

	@Override
	public void flush() throws IOException {
		this.outputStream.flush();

	}

	/**
	 * Retrieve the set of properties that are being exported by this
	 * {@link ThreatWriter}.
	 * 
	 * @return a {@link Map} containing the property name and the function to apply
	 *         on a threat to retrieve that property
	 */
	protected Map<String, Function<Threat, ? extends Object>> getProperties() {
		return properties;
	}

	/**
	 * Write-out a threat
	 * 
	 * @param threat the {@link Threat} to write out
	 * @throws IOException If an I/O error occurs.
	 */
	public abstract void write(Threat threat) throws IOException;

	/**
	 * Write-out multiple threats
	 * 
	 * @param threats the {@link Threat}s to write out
	 * @throws IOException If an I/O error occurs.
	 */
	public void write(Threat... threats) throws IOException {
		for (Threat t : threats) {
			write(t);
		}
	}
}
