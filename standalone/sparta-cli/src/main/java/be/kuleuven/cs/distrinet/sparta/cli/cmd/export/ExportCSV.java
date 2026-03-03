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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatCSVWriter;
import be.kuleuven.cs.distrinet.sparta.io.ThreatWriter;

/**
 * Support for exporting to CSV via the command line.
 * @author Laurens
 *
 */
public class ExportCSV implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(ExportCSV.class);
	private final Option csvoption;
	
	
	/**
	 * Create a new ExportCSV class.
	 */
	public ExportCSV() { 
		csvoption = new Option("oc","outcsv", true, "CSV Export file");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] {csvoption};
	}

	@Override
	public void process(CommandLine cmd, Collection<Threat> results) {
		if (!cmd.hasOption(csvoption.getOpt())) {
			return;
		}
		logger.info("Exporting to csv");

		String csv = cmd.getOptionValue(csvoption.getOpt());

		try (ThreatCSVWriter tw = new ThreatCSVWriter(new BufferedWriter(new FileWriter(csv)))) {
			tw.writeHeader();
			tw.write(results.toArray(new Threat[] {}));

		} catch (IOException e1) {
			logger.error("Error writing csv: {}", e1.getMessage());
		}
	}
}
