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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.cli.Options;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.cli.cmd.About;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.GenericCliCmd;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.Version;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportCQR;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportCSV;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportStatistics;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportTXT;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportXLSX;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.Exporter;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.SubmitToSpartaServer;

/**
 * Tests the options advertised by {@link SpartaCliProcessor}. Guards the removal of the dead
 * {@code -it}/{@code inputtree} option, confirms the real single-char options remain, and
 * checks that every multi-letter short option was replaced by a long-only option (so the CLI
 * no longer relies on ambiguity-prone multi-character short flags like {@code -st}/{@code -su}
 * or the {@code -v}/{@code -ve} collision).
 */
public class SpartaCliProcessorOptionsTest {

	private static SpartaCliProcessor newProcessor() {
		return new SpartaCliProcessor(Collections.<GenericCliCmd>emptySet(), Collections.<Exporter>emptySet());
	}

	/** A processor wired with the commands/exporters that own the renamed options. */
	private static Options optionsWithAllCommands() {
		Set<GenericCliCmd> gens = new HashSet<>(Arrays.asList(new About(), new Version()));
		Set<Exporter> exporters = new HashSet<>(Arrays.asList(new ExportCSV(), new ExportTXT(), new ExportXLSX(),
				new ExportCQR(), new ExportStatistics(), new SubmitToSpartaServer()));
		return new SpartaCliProcessor(gens, exporters).getOptions();
	}

	@Test
	public void inputAndVerboseOptionsRegistered() {
		SpartaCliProcessor processor = newProcessor();
		assertTrue("input option should be registered", processor.getOptions().hasOption("i"));
		assertTrue("verbose option should be registered", processor.getOptions().hasOption("v"));
	}

	@Test
	public void deadInputTreeOptionRemoved() {
		SpartaCliProcessor processor = newProcessor();
		assertFalse("The dead -it option must not be advertised", processor.getOptions().hasOption("it"));
		assertFalse("The dead inputtree option must not be advertised",
				processor.getOptions().hasOption("inputtree"));
	}

	@Test
	public void allRenamedOptionsAreAvailableByTheirLongName() {
		Options options = optionsWithAllCommands();
		for (String longOpt : new String[] { "about", "version", "outcsv", "outtxt", "outxlsx",
				"codequalityreport", "outstatistics", "token", "server", "commitid" }) {
			assertTrue("long option --" + longOpt + " should be registered", options.hasOption(longOpt));
		}
	}

	@Test
	public void multiLetterShortOptionsAreGone() {
		Options options = optionsWithAllCommands();
		for (String shortOpt : new String[] { "ab", "ve", "oc", "ot", "ox", "cqr", "os", "st", "su", "sc" }) {
			assertFalse("ambiguity-prone multi-letter short option -" + shortOpt + " must not be advertised",
					options.hasOption(shortOpt));
		}
	}
}
