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
import java.nio.file.Paths;
import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.CQThreatJSONWriter;

/**
 * Support for exporting a Code Quality Report via the command line.
 * @author Laurens
 *
 */
public class ExportCQR implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(ExportCQR.class);
	private final Option cqroption;


	/**
	 * Create a new ExportCQR class.
	 */
	public ExportCQR() {
		cqroption = new Option(null, "codequalityreport", true, "Export Code Quality Report");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] {cqroption};
	}

	@Override
	public boolean process(CommandLine cmd, Collection<Threat> results) {
		if (!cmd.hasOption(cqroption.getLongOpt())) {
			return true;
		}
		logger.info("Exporting to cqr");

		String cqr = cmd.getOptionValue(cqroption.getLongOpt());

		try (CQThreatJSONWriter tw = new CQThreatJSONWriter(
				Files.newBufferedWriter(Paths.get(cqr), StandardCharsets.UTF_8))) {
			tw.write(results.toArray(new Threat[] {}));

		} catch (IOException e1) {
			logger.error("Error writing cqr: {}", e1.getMessage(), e1);
			return false;
		}
		return true;
	}
}
