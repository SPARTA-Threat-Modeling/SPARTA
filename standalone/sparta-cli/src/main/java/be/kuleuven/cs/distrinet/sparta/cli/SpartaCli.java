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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;

import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportCSV;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportReport;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportStatistics;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportTXT;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportXLSX;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.Exporter;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.SubmitToSpartaServer;
import be.kuleuven.cs.distrinet.sparta.cli.runtime.StandaloneRuntime;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.ExitCode;
import picocli.CommandLine.IVersionProvider;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

/**
 * SPARTA command line application. This is the main entry point for running SPARTA from
 * the command line: it declares the supported options (picocli), validates the input,
 * runs the threat analysis via the shared {@link StandaloneRuntime} and hands the results
 * to the requested {@link Exporter} steps.
 *
 * <p>Exit codes: {@code 0} on success, {@code 1} when the analysis or an export/submission
 * fails, {@code 2} on a usage or input error (unknown option, missing input model, ...).
 *
 * @author Laurens
 *
 */
@Command(name = "java -jar sparta-cli-shaded.jar", sortOptions = false,
		versionProvider = SpartaCli.ProjectVersionProvider.class,
		description = "Automated SPARTA threat analysis of EMF models from the command line.",
		footer = {
				"",
				"Exit codes:",
				"  0   analysis and all requested exports succeeded",
				"  1   the analysis, an export or the server submission failed",
				"  2   usage or input error (unknown option, missing input model, ...)" })
public class SpartaCli implements Callable<Integer> {

	/** slf4j-simple freezes its log level on the first LoggerFactory call. */
	private static final String LOG_LEVEL_PROPERTY = "org.slf4j.simpleLogger.defaultLogLevel";

	@Option(names = { "-i", "--input" }, paramLabel = "<model>", description = "Model to analyze")
	private File input;

	@Option(names = { "-v", "--verbose" }, description = "Provide verbose output (debug logging)")
	private boolean verbose;

	@Option(names = "--outcsv", paramLabel = "<file>", description = "CSV export file")
	private Path outCsv;

	@Option(names = "--outxlsx", paramLabel = "<file>", description = "XLSX export file")
	private Path outXlsx;

	@Option(names = "--outtxt", paramLabel = "<dir>", description = "TXT export directory (one file per threat)")
	private Path outTxt;

	@Option(names = "--outstatistics", paramLabel = "<file>", description = "Output txt file with threat statistics")
	private Path outStatistics;

	@Option(names = "--outreport", paramLabel = "<dir>", description = "LaTeX report output directory")
	private Path outReport;

	@Option(names = "--aird", paramLabel = "<file>", description = "Sirius .aird file whose diagram layout "
			+ "is reused in the report (optional; auto-detected next to the model when omitted)")
	private File aird;

	@Option(names = "--server", paramLabel = "<url>",
			description = "Server submission url (requires --token and --commitid)")
	private String server;

	@Option(names = "--token", paramLabel = "<token>", description = "Server submission token")
	private String token;

	@Option(names = "--commitid", paramLabel = "<id>", description = "Server submission commit id")
	private String commitId;

	@Option(names = "--about", description = "About SPARTA")
	private boolean about;

	@Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit")
	private boolean helpRequested;

	@Option(names = "--version", versionHelp = true, description = "Print the version and exit")
	private boolean versionRequested;

	@Spec
	private CommandSpec spec;

	/**
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		// Must happen before anything obtains an slf4j logger (see configureLogging).
		configureLogging(args);
		System.exit(createCommandLine().execute(args));
	}

	/**
	 * Create the picocli command line for this application, with the usage banner naming
	 * the actual shaded artifact ({@code sparta-cli-<version>-shaded.jar}).
	 *
	 * @return the configured command line.
	 */
	static CommandLine createCommandLine() {
		CommandLine cmd = new CommandLine(new SpartaCli());
		cmd.getCommandSpec().name("java -jar " + shadedJarName());
		return cmd;
	}

	/**
	 * Enable debug logging when {@code -v}/{@code --verbose} is present. slf4j-simple reads
	 * {@value #LOG_LEVEL_PROPERTY} once, when the first logger is created, so this must run
	 * before any {@code LoggerFactory} call (which is why {@link SpartaCli} deliberately has
	 * no static logger). An explicitly passed {@code -D} system property wins.
	 *
	 * @param args the raw command line arguments.
	 */
	private static void configureLogging(String[] args) {
		for (String arg : args) {
			if (("-v".equals(arg) || "--verbose".equals(arg)) && System.getProperty(LOG_LEVEL_PROPERTY) == null) {
				System.setProperty(LOG_LEVEL_PROPERTY, "debug");
			}
		}
	}

	@Override
	public Integer call() {
		PrintWriter out = spec.commandLine().getOut();
		PrintWriter err = spec.commandLine().getErr();

		if (about) {
			out.println("Sparta-cli supports the automated threat analysis of EMF models from the command line.");
		}

		// The server submission only makes sense as a complete set; silently skipping it
		// when e.g. the token is missing would hide a misconfigured CI invocation.
		boolean anySubmission = server != null || token != null || commitId != null;
		boolean fullSubmission = server != null && token != null && commitId != null;
		if (anySubmission && !fullSubmission) {
			err.println("sparta-cli: server submission requires --server, --token and --commitid together.");
			return ExitCode.USAGE;
		}

		if (input == null) {
			if (about) {
				return ExitCode.OK;
			}
			spec.commandLine().usage(err);
			return ExitCode.USAGE;
		}
		if (!input.isFile()) {
			err.println("sparta-cli: input model '" + input + "' does not exist or is not a file.");
			return ExitCode.USAGE;
		}

		StandaloneRuntime.setupEMFStandalone();
		StandaloneRuntime.setupVIATRAStandalone();

		List<Threat> results = StandaloneRuntime.runThreatAnalysis(input.getPath());

		boolean success = true;
		for (Exporter step : exportSteps()) {
			success &= step.export(results);
		}
		if (!success) {
			LoggerFactory.getLogger(SpartaCli.class).error("One or more exports failed.");
			return ExitCode.SOFTWARE;
		}
		return ExitCode.OK;
	}

	/**
	 * Map the provided options onto the export steps to run, in a stable order.
	 *
	 * @return the exporters for the requested output formats.
	 */
	private List<Exporter> exportSteps() {
		List<Exporter> steps = new ArrayList<>();
		if (outCsv != null) {
			steps.add(new ExportCSV(outCsv));
		}
		if (outXlsx != null) {
			steps.add(new ExportXLSX(outXlsx));
		}
		if (outTxt != null) {
			steps.add(new ExportTXT(outTxt));
		}
		if (outStatistics != null) {
			steps.add(new ExportStatistics(outStatistics));
		}
		if (outReport != null) {
			steps.add(new ExportReport(outReport, aird, input));
		}
		if (server != null && token != null && commitId != null) {
			steps.add(new SubmitToSpartaServer(server, token, commitId));
		}
		return steps;
	}

	/**
	 * Name of the shaded jar this application ships as, derived from the Maven-filtered
	 * {@code project.properties} ({@code <artifactId>-<version>-shaded.jar}).
	 *
	 * @return the shaded jar file name, or a version-less fallback if the properties are missing.
	 */
	static String shadedJarName() {
		Properties properties = projectProperties();
		String artifactId = properties.getProperty("artifactId", "sparta-cli");
		String version = properties.getProperty("version");
		return version == null ? artifactId + "-shaded.jar" : artifactId + "-" + version + "-shaded.jar";
	}

	private static Properties projectProperties() {
		Properties properties = new Properties();
		try (InputStream in = SpartaCli.class.getClassLoader().getResourceAsStream("project.properties")) {
			if (in != null) {
				properties.load(in);
			}
		} catch (IOException e) {
			// fall through to the defaults; the version is informational only
		}
		return properties;
	}

	/** Supplies {@code --version} output (plain text on stdout) from {@code project.properties}. */
	public static class ProjectVersionProvider implements IVersionProvider {
		@Override
		public String[] getVersion() {
			return new String[] { "SPARTA CLI " + projectProperties().getProperty("version", "(unknown version)") };
		}
	}

}
