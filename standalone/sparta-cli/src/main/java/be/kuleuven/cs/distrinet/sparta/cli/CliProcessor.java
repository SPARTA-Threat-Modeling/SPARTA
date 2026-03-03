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

import org.apache.commons.cli.Options;

/**
 * Command line processor interface.
 * 
 * @author Laurens
 *
 */
public interface CliProcessor {

	/**
	 * Process the provided command line arguments.
	 * 
	 * @param args the cli arguments
	 */
	public void process(String[] args);
	
	
	/**
	 * Get the full set of command line options.
	 * @return the set of supported options.
	 */
	public Options getOptions();
}
