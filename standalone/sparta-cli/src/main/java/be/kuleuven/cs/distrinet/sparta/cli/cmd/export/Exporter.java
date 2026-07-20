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

import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

/**
 * Interface for providing export functionality to the sparta cli.
 * 
 * @author Laurens
 *
 */
public interface Exporter {

	/**
	 * Get the options that have to be processed for determining if this command should run.
	 * @return the array of options this command relies upon.
	 */
	public Option[] getOptions();
	
	/**
	 * Process the parsed options and run the export if needed on the provided collection of threats.
	 * @param cmd the processed command line options.
	 * @param results the collection of threats to export
	 * @return {@code true} if the export succeeded or was not requested; {@code false} if it failed.
	 */
	public boolean process(CommandLine cmd, Collection<Threat> results);
}
