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

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatXlsxOutputStream;

/**
 * Export for xlsx export via the command line.
 * 
 * @author Laurens
 *
 */
public class ExportXLSX implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(ExportXLSX.class);
	private final Option xlsxoption;
	
	public ExportXLSX() { 
		xlsxoption = new Option("ox","outxlsx", true, "XLSX export file");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] {xlsxoption};
	}

	@Override
	public void process(CommandLine cmd, Collection<Threat> results) {
		if (!cmd.hasOption(xlsxoption.getOpt())) {
			return;
		}
		logger.info("Exporting to xlsx files");

		String xlsx = cmd.getOptionValue(xlsxoption.getOpt());

		try (ThreatXlsxOutputStream tw = new ThreatXlsxOutputStream(new FileOutputStream(xlsx))) {
			tw.write(results.toArray(new Threat[] {}));

		} catch (IOException e1) {
			logger.error("Error writing xlsx: {}", e1.getMessage());
		}
	}
}
