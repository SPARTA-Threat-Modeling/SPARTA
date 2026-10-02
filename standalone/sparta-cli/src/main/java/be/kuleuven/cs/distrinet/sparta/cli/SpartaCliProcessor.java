/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.cli;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import be.kuleuven.cs.distrinet.sparta.cli.cmd.GenericCliCmd;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.Help;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.Exporter;
import be.kuleuven.cs.distrinet.sparta.cli.runtime.StandaloneRuntime;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

/**
 * Command line processor. Every {@link GenericCliCmd} and {@link Exporter} can
 * provide a list of options and will be called with the provided arguments to
 * check if they need to perform any action. The actual EMF/VIATRA bootstrap and
 * analysis are delegated to the shared {@link StandaloneRuntime}.
 *
 * @author Laurens
 *
 */
@Singleton
public class SpartaCliProcessor implements CliProcessor {

	private static final Logger logger = LoggerFactory.getLogger(SpartaCliProcessor.class);
	private final Options options;
	private final Set<GenericCliCmd> gens;
	private final Set<Exporter> exporters;
	private final CommandLineParser parser = new DefaultParser();
	private final Option optVerbose;
	private final Option optInput;

	/**
	 * Create a new SpartaCliProcessor.
	 *
	 * @param gens Set of generic command such as help, about, etc.
	 * @param exporters Set of potential exporters to provide export functionality to csv, xlsx, etc.
	 */
	@Inject
	public SpartaCliProcessor(Set<GenericCliCmd> gens, Set<Exporter> exporters) {
		this.gens = gens;
		this.exporters = exporters;
		logger.debug("Initializing Sparta CLI processor...");
		options = new Options();
		gens.stream().forEach(this::registerGeneric);
		exporters.stream().forEach(this::registerExporter);
		optVerbose = new Option("v", "verbose", false, "Provide verbose output");
		optInput = new Option("i", "input", true, "Model to analyze");
		options.addOption(optVerbose);
		options.addOption(optInput);
	}

	/**
	 * Process the provided command line arguments.
	 *
	 * @param args the cli arguments
	 */
	@Override
	public void process(String[] args) {
		CommandLine cmd = null;

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			logger.error("Error parsing commands: {}", e.getMessage());
			new Help(() -> this).process(null);
			System.exit(1);
		}

		for (GenericCliCmd c : gens) {
			c.process(cmd);
		}

		// When help is requested, do not also run the analysis.
		if (cmd.hasOption("h")) {
			return;
		}

		if (cmd.hasOption(optInput.getOpt())) {

			StandaloneRuntime.setupEMFStandalone();
			StandaloneRuntime.setupVIATRAStandalone();

			List<Threat> results;

			String target = cmd.getOptionValue(optInput.getOpt());
			results = StandaloneRuntime.runThreatAnalysis(target);

			boolean success = true;
			for (Exporter c : exporters) {
				success &= c.process(cmd, results);
			}
			if (!success) {
				logger.error("One or more exports failed.");
				System.exit(1);
			}
		}

	}

	/**
	 * Register the exporter with this cli processor. Its options will be taken into account.
	 * @param exporter the exporter to register
	 */
	private void registerExporter(Exporter exporter) {
		logger.debug("Registering exporter: {}", exporter.getClass().getSimpleName());
		Arrays.stream(exporter.getOptions()).forEach(options::addOption);
	}
	/**
	 * Register a generic command with this cli processor. Its options will be taken into account.
	 * @param genCmd the {@link GenericCliCmd} to register
	 */
	public void registerGeneric(GenericCliCmd genCmd) {
		logger.debug("Registering generic: {}", genCmd.getClass().getSimpleName());
		Arrays.stream(genCmd.getOptions()).forEach(options::addOption);

	}

	@Override
	public Options getOptions() {
		return options;
	}

}
