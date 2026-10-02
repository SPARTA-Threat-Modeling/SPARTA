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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

import picocli.CommandLine;
import picocli.CommandLine.Model.CommandSpec;

/**
 * Tests the declarative picocli command of {@link SpartaCli}: the advertised (typed)
 * options, the stdout/stderr separation (help and {@code --version}/{@code --about} on
 * stdout, errors and unrequested usage on stderr) and the documented exit-code mapping
 * (0 ok, 1 runtime error, 2 usage/input error). Also guards that the dead
 * {@code -it}/{@code --inputtree} option and the ambiguity-prone multi-letter short
 * options of the old commons-cli implementation did not come back.
 */
public class SpartaCliOptionsTest {

	private StringWriter out;
	private StringWriter err;
	private CommandLine cmd;

	@Before
	public void setUpCommandLine() {
		out = new StringWriter();
		err = new StringWriter();
		cmd = SpartaCli.createCommandLine();
		cmd.setOut(new PrintWriter(out));
		cmd.setErr(new PrintWriter(err));
	}

	@Test
	public void typedOptionsAreRegistered() {
		CommandSpec spec = cmd.getCommandSpec();
		for (String opt : new String[] { "-i", "--input", "-v", "--verbose", "-h", "--help", "--version",
				"--about", "--outcsv", "--outtxt", "--outxlsx", "--outreport", "--aird", "--outstatistics",
				"--token", "--server", "--commitid" }) {
			assertNotNull("option " + opt + " should be registered", spec.optionsMap().get(opt));
		}
	}

	@Test
	public void deadAndMultiLetterShortOptionsAreGone() {
		CommandSpec spec = cmd.getCommandSpec();
		for (String opt : new String[] { "-it", "--inputtree", "-ab", "-ve", "-oc", "-ot", "-ox", "-cqr",
				"-os", "-st", "-su", "-sc" }) {
			assertNull("option " + opt + " must not be advertised", spec.optionsMap().get(opt));
		}
	}

	@Test
	public void noArgsPrintsUsageToStderrAndReturnsUsageExitCode() {
		int exitCode = cmd.execute();
		assertEquals("no-args should be a usage error", 2, exitCode);
		assertTrue("usage should be printed to stderr, was: " + err, err.toString().contains("Usage:"));
		assertEquals("nothing should be printed to stdout", "", out.toString());
	}

	@Test
	public void unknownOptionPrintsUsageToStderrAndReturnsUsageExitCode() {
		int exitCode = cmd.execute("--no-such-option");
		assertEquals("an unknown option should be a usage error", 2, exitCode);
		assertTrue("the unknown option should be named on stderr, was: " + err,
				err.toString().contains("--no-such-option"));
		assertTrue("usage should be printed to stderr, was: " + err, err.toString().contains("Usage:"));
		assertEquals("nothing should be printed to stdout", "", out.toString());
	}

	@Test
	public void missingInputFileIsRejectedUpFrontWithUsageExitCode() {
		int exitCode = cmd.execute("-i", "does-not-exist-anywhere.sparta");
		assertEquals("a missing input model should be a usage/input error", 2, exitCode);
		assertTrue("the missing file should be named on stderr, was: " + err,
				err.toString().contains("does-not-exist-anywhere.sparta"));
		assertEquals("the input-file error should be a one-line message", 1,
				err.toString().strip().split("\\R").length);
	}

	@Test
	public void versionIsPrintedPlainlyToStdout() {
		int exitCode = cmd.execute("--version");
		assertEquals(0, exitCode);
		assertTrue("the version banner should be on stdout, was: " + out, out.toString().contains("SPARTA CLI"));
		assertFalse("the version must not be wrapped in slf4j log format, was: " + out,
				out.toString().contains("INFO"));
		assertEquals("nothing should be printed to stderr", "", err.toString());
	}

	@Test
	public void aboutIsPrintedPlainlyToStdout() {
		int exitCode = cmd.execute("--about");
		assertEquals(0, exitCode);
		assertTrue("the about text should be on stdout, was: " + out,
				out.toString().contains("threat analysis"));
		assertEquals("nothing should be printed to stderr", "", err.toString());
	}

	@Test
	public void requestedHelpGoesToStdoutAndDocumentsExitCodes() {
		int exitCode = cmd.execute("--help");
		assertEquals(0, exitCode);
		assertTrue("requested help should go to stdout, was: " + out, out.toString().contains("Usage:"));
		assertTrue("the help text should document the exit codes", out.toString().contains("Exit codes:"));
		assertEquals("nothing should be printed to stderr", "", err.toString());
	}

	@Test
	public void usageBannerNamesTheShadedJar() {
		cmd.execute("--help");
		assertTrue("the usage banner should name the real shaded artifact, was: " + out,
				out.toString().contains("sparta-cli-") && out.toString().contains("-shaded.jar"));
	}

	@Test
	public void partialSubmissionOptionsAreRejected() {
		int exitCode = cmd.execute("--server", "https://example.invalid/submit");
		assertEquals("a partial submission option set should be a usage error", 2, exitCode);
		assertTrue("the error should name the missing options, was: " + err,
				err.toString().contains("--token") && err.toString().contains("--commitid"));
	}
}
