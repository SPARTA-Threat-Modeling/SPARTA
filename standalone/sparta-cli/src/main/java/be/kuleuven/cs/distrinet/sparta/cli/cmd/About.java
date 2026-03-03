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

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command to print info string about SPARTA.
 * @author Laurens
 *
 */
public class About implements GenericCliCmd {

	private static final Logger logger = LoggerFactory.getLogger(About.class);
	private final Option aboutOption;
	
	public About() { 
		aboutOption = new Option("ab","about", false, "About SPARTA");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] {aboutOption};
	}

	@Override
	public void process(CommandLine cmd) {
		if (!cmd.hasOption(aboutOption.getOpt())) {
			return;
		}
		logger.info("Sparta-cli supports the automated threat analysis emf models from the command line.");


	}
}
