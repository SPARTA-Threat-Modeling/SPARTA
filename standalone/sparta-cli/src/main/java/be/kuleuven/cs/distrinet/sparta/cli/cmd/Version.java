/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.cli.cmd;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Show Sparta Cli version cmd.
 * 
 * @author Laurens
 *
 */
public class Version implements GenericCliCmd {

	private static final Logger logger = LoggerFactory.getLogger(Version.class);
	private final Option csvoption;
	private static final Properties properties = new Properties();
	
	public Version() { 
		csvoption = new Option("ve","version", false, "Show version info");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] {csvoption};
	}

	@Override
	public void process(CommandLine cmd) {
		if (!cmd.hasOption(csvoption.getOpt())) {
			return;
		}
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("project.properties"));
			logger.info("Version: " + properties.getProperty("version"));
		} catch (IOException e) {
		}

		
	}
}
