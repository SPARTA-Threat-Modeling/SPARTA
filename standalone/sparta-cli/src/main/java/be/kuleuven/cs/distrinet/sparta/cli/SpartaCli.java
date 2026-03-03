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

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * SPARTA command line class. This is the main entry point for the running
 * SPARTA from the command line. This class will process the command line
 * options.
 *
 * @author Laurens
 *
 */
public class SpartaCli {

	private static final Logger logger = LoggerFactory.getLogger(SpartaCli.class);
	private static final Properties properties = new Properties();

	/**
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new SimpleModule());
		try {
			properties.load(SpartaCli.class.getClassLoader().getResourceAsStream("project.properties"));

		} catch (IOException e) {
			logger.debug("Error loading application properties {}", e);
		}
		CliProcessor processor = injector.getInstance(CliProcessor.class);

		processor.process(args);

	}

}
