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

/**
 * Generic command.
 * @author Laurens
 *
 */
public interface GenericCliCmd {

	
	/**
	 * Get the options that have to be processed for determining if this command should run.
	 * @return the array of options this command relies upon.
	 */
	public Option[] getOptions();
	
	/**
	 * Process the parsed options and run the command if needed.
	 * @param cmd the processed command line options.
	 */
	public void process(CommandLine cmd);
}
