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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.cli.runtime.StandaloneRuntime;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ReportWriter;

/**
 * Export the LaTeX threat report from the command line, including the Data Flow Diagram when a
 * Sirius {@code .aird} is available. The diagram is rendered headlessly from the model + the
 * {@code .aird} layout (see {@code io} {@code AirdLayout}/{@code DfdTikzGenerator}), so no
 * Eclipse workbench, Sirius runtime or SWT is required.
 */
public class ExportReport implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(ExportReport.class);

	private final Option reportOption;
	private final Option airdOption;

	public ExportReport() {
		reportOption = new Option(null, "outreport", true, "LaTeX report output directory");
		airdOption = new Option(null, "aird", true,
				"Sirius .aird file whose diagram layout is reused in the report (optional; "
						+ "auto-detected next to the model when omitted)");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] { reportOption, airdOption };
	}

	@Override
	public boolean process(CommandLine cmd, Collection<Threat> results) {
		if (!cmd.hasOption(reportOption.getLongOpt())) {
			return true;
		}
		logger.info("Exporting LaTeX report");

		String dir = cmd.getOptionValue(reportOption.getLongOpt());

		ResourceSet resourceSet = resourceSetFrom(results);
		if (resourceSet == null && cmd.hasOption("i")) {
			// No threats to borrow the model from (e.g. a clean model); reload it.
			resourceSet = StandaloneRuntime.loadModel(cmd.getOptionValue("i"));
		}
		if (resourceSet == null) {
			logger.error("No model available to export the report from");
			return false;
		}

		File aird = resolveAird(cmd);
		if (aird != null) {
			logger.info("Using diagram layout from {}", aird.getAbsolutePath());
		} else {
			logger.info("No .aird found; report will be generated without the data flow diagram");
		}

		ReportWriter writer = new ReportWriter();
		if (aird != null) {
			writer.setAird(aird);
		}
		try {
			writer.performExport(new File(dir), resourceSet, new ArrayList<>(results));
		} catch (IOException e) {
			logger.error("Report export failed: {}", e.getMessage());
			return false;
		}
		logger.info("Exported LaTeX report to {}", dir);
		return true;
	}

	/** Recover the model's {@link ResourceSet} from any threat's semantic element. */
	private ResourceSet resourceSetFrom(Collection<Threat> results) {
		for (Threat t : results) {
			if (t.getThreatenedElement() != null && t.getThreatenedElement().eResource() != null) {
				return t.getThreatenedElement().eResource().getResourceSet();
			}
		}
		return null;
	}

	/**
	 * Resolve the {@code .aird}: the explicit {@code --aird} option if given, otherwise the first
	 * {@code .aird} sitting next to the input model. Returns {@code null} if none is usable.
	 */
	private File resolveAird(CommandLine cmd) {
		if (cmd.hasOption(airdOption.getLongOpt())) {
			File f = toFile(cmd.getOptionValue(airdOption.getLongOpt()));
			return f.isFile() ? f : null;
		}
		if (!cmd.hasOption("i")) {
			return null;
		}
		File model = toFile(cmd.getOptionValue("i"));
		File dir = model.getParentFile();
		if (dir == null || !dir.isDirectory()) {
			return null;
		}
		File[] airds = dir.listFiles((d, name) -> name.toLowerCase(java.util.Locale.ROOT).endsWith(".aird"));
		return airds != null && airds.length > 0 ? airds[0] : null;
	}

	private File toFile(String path) {
		File f = new File(path);
		return f.isAbsolute() ? f : new File(System.getProperty("user.dir"), path);
	}
}
