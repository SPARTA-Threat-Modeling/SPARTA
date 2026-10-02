/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.cli.cmd.export;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatCSVWriter;
import be.kuleuven.cs.distrinet.sparta.io.ThreatExportColumns;

/**
 * Support for exporting to CSV via the command line.
 * @author Laurens
 *
 */
public class ExportCSV implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(ExportCSV.class);
	private final Path target;

	/**
	 * Create a new ExportCSV step.
	 *
	 * @param target the CSV file to write.
	 */
	public ExportCSV(Path target) {
		this.target = target;
	}

	@Override
	public boolean export(Collection<Threat> results) {
		logger.info("Exporting to csv");

		try (ThreatCSVWriter tw = new ThreatCSVWriter(
				Files.newBufferedWriter(target, StandardCharsets.UTF_8), ThreatExportColumns.withMetadata())) {
			tw.writeHeader();
			tw.write(results.toArray(new Threat[] {}));

		} catch (IOException e1) {
			logger.error("Error writing csv: {}", e1.getMessage(), e1);
			return false;
		}
		return true;
	}
}
