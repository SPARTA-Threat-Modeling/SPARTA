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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;


/**
 * Writes {@link Threat}s to a character-output stream.
 * 
 * A newLine() method is provided, which uses the platform's own notion of line
 * separator as defined by the system property line.separator. Not all platforms
 * use the newline character ('\n') to terminate lines. Calling this method to
 * terminate each output line is therefore preferred to writing a newline
 * character directly.
 *
 */
public abstract class ThreatWriter extends Writer {

	protected final Writer writer;
	private final LinkedHashMap<String, Function<Threat, ? extends Object>> properties = new LinkedHashMap<>();

	/**
	 * Create a new ThreatWriter to provided support for writing out a default set
	 * of threat properties to text-based files.
	 * 
	 * @param writer a writer
	 */
	public ThreatWriter(Writer writer) {
		this(writer, null);
	}

	/**
	 * Create a new ThreatWriter to provided support for writing out a specified set
	 * of threat properties to text-based files. If any of the provided functions
	 * return a {@link ModelElement}, the {@link ThreatWriter} will attempt to
	 * retrieve the name of the element when writing it to the output writer.
	 * 
	 * @param writer     a writer
	 * @param properties a set of functions, which applied to a threat provide the
	 *                   property to write out
	 */
	public ThreatWriter(Writer writer, Map<String, Function<Threat, ? extends Object>> properties) {
		this.writer = writer;
		if (properties != null) {
			this.properties.putAll(properties);
		} else {
			this.properties.put("Type", Threat::getThreatTypeName);
			this.properties.put("Name", Threat::getThreatName);
			this.properties.put("Location", Threat::getThreatenedElement);
			this.properties.put("Flow From", Threat::getDataFlowFrom);
			this.properties.put("Data Flow", Threat::getDataFlow);
			this.properties.put("Flow To", Threat::getDataFlowTo);
			this.properties.put("Vulnerability", Threat::getVulnerability);
			this.properties.put("Risk", Threat::getRisk);
			this.properties.put("Risk (lower)", Threat::getRisk_lower);
			this.properties.put("Risk (upper)", Threat::getRisk_upper);
			this.properties.put("Risk (potential)", Threat::getPotentialRisk);
			
		}
		for (String key : this.properties.keySet()) {
			this.properties.compute(key, (k, v) -> {
				return v.andThen(o -> ((o instanceof ModelElement) ? ((ModelElement) o).getName() : o));
			});
		}
		final NumberFormat nf = DecimalFormat.getInstance();
		nf.setMaximumFractionDigits(4);
		for (String key : this.properties.keySet()) {
			this.properties.compute(key, (k, v) -> {
				return v.andThen(o -> ((o instanceof Double) ? nf.format(o) : o));
			});
		}

	}

	/**
	 * Closes the stream, flushing it first. Once the stream has been closed,
	 * further write() or flush() invocations will cause an IOException to be
	 * thrown. Closing a previously closed stream has no effect.
	 */
	@Override
	public void close() throws IOException {
		this.writer.close();

	}

	/**
	 * Flushes the stream. If the stream has saved any characters from the various
	 * write() methods in a buffer, write them immediately to their intended
	 * destination. Then, if that destination is another character or byte stream,
	 * flush it. Thus one flush() invocation will flush all the buffers in a chain
	 * of Writers and OutputStreams.
	 * 
	 * If the intended destination of this stream is an abstraction provided by the
	 * underlying operating system, for example a file, then flushing the stream
	 * guarantees only that bytes previously written to the stream are passed to the
	 * operating system for writing; it does not guarantee that they are actually
	 * written to a physical device such as a disk drive.
	 */
	@Override
	public void flush() throws IOException {
		this.writer.flush();

	}

	/**
	 * Writes a portion of an array of characters.
	 * 
	 * @param cbuf Array of characters
	 * @param off  Offset from which to start writing characters
	 * @param len  Number of characters to write
	 * @throws IndexOutOfBoundsException Implementations should throw this exception
	 *                                   if off is negative, or len is negative, or
	 *                                   off + len is negative or greater than the
	 *                                   length of the given array
	 * @throws IOException               If an I/O error occurs
	 */
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		this.writer.write(cbuf, off, len);
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

	/**
	 * Writes a line separator. The line separator string is defined by the system
	 * property line.separator, and is not necessarily a single newline ('\n')
	 * character.
	 * 
	 * @throws IOException If an I/O error occurs.
	 */
	public void newLine() throws IOException {
		write(System.getProperty("line.separator"));
	}

}
