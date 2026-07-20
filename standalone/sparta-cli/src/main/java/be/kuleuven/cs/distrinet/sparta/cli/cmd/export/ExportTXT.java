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

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatTextWriter;
import be.kuleuven.cs.distrinet.sparta.io.ThreatWriter;

/**
 * Export for text export via the command line.
 * @author Laurens
 *
 */
public class ExportTXT implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(ExportTXT.class);
	private final Option txtoption;
	
	public ExportTXT() { 
		txtoption = new Option(null, "outtxt", true, "TXT export files");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] {txtoption};
	}

	@Override
	public boolean process(CommandLine cmd, Collection<Threat> results) {
		if (!cmd.hasOption(txtoption.getLongOpt())) {
			return true;
		}
		logger.info("Exporting to txt files");

		String dir = cmd.getOptionValue(txtoption.getLongOpt());
		File f = new File(dir);
		if (!f.isDirectory() && !f.mkdirs()) {
			logger.error("Could not create output directory: {}", f.getAbsolutePath());
			return false;
		}
		boolean success = true;
		for (Threat t : results) {
			try (ThreatWriter tw = new ThreatTextWriter(Files.newBufferedWriter(
					new File(f, ThreatTextWriter.fileNameSuggestion(t)).toPath(), StandardCharsets.UTF_8))) {
				tw.write(t);
			} catch (IOException e1) {
				logger.error("Error writing txt: {}", e1.getMessage(), e1);
				success = false;
			}
		}
		return success;
	}
}
