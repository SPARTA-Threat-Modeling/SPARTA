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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatExportColumns;
import be.kuleuven.cs.distrinet.sparta.io.ThreatXlsxOutputStream;

/**
 * Export for xlsx export via the command line.
 *
 * @author Laurens
 *
 */
public class ExportXLSX implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(ExportXLSX.class);
	private final Path target;

	/**
	 * Create a new ExportXLSX step.
	 *
	 * @param target the XLSX file to write.
	 */
	public ExportXLSX(Path target) {
		this.target = target;
	}

	@Override
	public boolean export(Collection<Threat> results) {
		logger.info("Exporting to xlsx files");

		try (ThreatXlsxOutputStream tw = new ThreatXlsxOutputStream(Files.newOutputStream(target),
				ThreatExportColumns.withMetadata())) {
			tw.write(results.toArray(new Threat[] {}));

		} catch (IOException e1) {
			logger.error("Error writing xlsx: {}", e1.getMessage(), e1);
			return false;
		}
		return true;
	}
}
