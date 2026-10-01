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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatExportColumns;
import be.kuleuven.cs.distrinet.sparta.io.ThreatXlsxOutputStream;

public class XLSXExportHandler extends AbstractThreatTableExportHandler {

	@Override
	protected String fileName() {
		return "threats.xlsx";
	}

	@Override
	protected String formatName() {
		return "XLSX";
	}

	@Override
	protected void export(File file, Threat[] threats) throws IOException {
		try (ThreatXlsxOutputStream tw = new ThreatXlsxOutputStream(new FileOutputStream(file),
				ThreatExportColumns.withMetadata())) {
			tw.write(threats);
		}
	}

}
