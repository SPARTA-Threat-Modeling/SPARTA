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
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

import be.kuleuven.cs.distrinet.sparta.cli.CliProcessor;

/**
 * Command to print SPARTA help message.
 * @author Laurens
 *
 */
public class Help implements GenericCliCmd {

	private static final Logger logger = LoggerFactory.getLogger(Help.class);
	private final Option helpOption;
	private final HelpFormatter formatter = new HelpFormatter();
	private static final String cmdSyntax = "java -jar sparta-cli.jar";
	
	private final Provider<CliProcessor> cliProc;
	
	@Inject
	public Help(Provider<CliProcessor> cliProc) { 
		helpOption = new Option("h","help", false, "Show help");
		this.cliProc = cliProc;
	}

	@Override
	public Option[] getOptions() {
		return new Option[] {helpOption};
	}

	@Override
	public void process(CommandLine cmd) {
		if (cmd != null && (!cmd.hasOption(helpOption.getOpt()))) {
			return;
		}
		logger.debug("Showing help message.");
		formatter.printHelp(cmdSyntax, cliProc.get().getOptions(), true);
		
	}

	
}
