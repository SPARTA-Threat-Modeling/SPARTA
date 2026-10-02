/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.handlers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatCSVWriter;
import be.kuleuven.cs.distrinet.sparta.io.ThreatExportColumns;

public class CSVExportHandler extends AbstractThreatTableExportHandler {

	@Override
	protected String fileName() {
		return "threats.csv";
	}

	@Override
	protected String formatName() {
		return "CSV";
	}

	@Override
	protected void export(File file, Threat[] threats) throws IOException {
		try (ThreatCSVWriter tw = new ThreatCSVWriter(new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8)),
				ThreatExportColumns.withMetadata())) {
			tw.writeHeader();
			tw.write(threats);
		}
	}

}
