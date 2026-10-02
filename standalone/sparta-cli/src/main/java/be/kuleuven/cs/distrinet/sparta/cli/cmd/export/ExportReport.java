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
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

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

	private final Path targetDir;
	private final File aird;
	private final File input;

	/**
	 * Create a new ExportReport step.
	 *
	 * @param targetDir the directory to write the LaTeX report into.
	 * @param aird      the Sirius {@code .aird} whose diagram layout to reuse, or {@code null} to
	 *                  use the first {@code .aird} next to the input model (if any).
	 * @param input     the analysed input model.
	 */
	public ExportReport(Path targetDir, File aird, File input) {
		this.targetDir = targetDir;
		this.aird = aird;
		this.input = input;
	}

	@Override
	public boolean export(Collection<Threat> results) {
		logger.info("Exporting LaTeX report");

		ResourceSet resourceSet = resourceSetFrom(results);
		if (resourceSet == null) {
			// No threats to borrow the model from (e.g. a clean model); reload it.
			resourceSet = StandaloneRuntime.loadModel(input.getPath());
		}

		File layout = resolveAird();
		if (layout != null) {
			logger.info("Using diagram layout from {}", layout.getAbsolutePath());
		} else {
			logger.info("No .aird found; report will be generated without the data flow diagram");
		}

		ReportWriter writer = new ReportWriter();
		if (layout != null) {
			writer.setAird(layout);
		}
		try {
			writer.performExport(targetDir.toFile(), resourceSet, new ArrayList<>(results));
		} catch (IOException e) {
			logger.error("Report export failed: {}", e.getMessage());
			return false;
		}
		logger.info("Exported LaTeX report to {}", targetDir);
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
	 * Resolve the {@code .aird}: the explicit {@code --aird} file if given, otherwise the first
	 * {@code .aird} sitting next to the input model. Returns {@code null} if none is usable.
	 */
	private File resolveAird() {
		if (aird != null) {
			if (!aird.isFile()) {
				logger.warn("--aird file {} does not exist; generating the report without the diagram",
						aird.getAbsolutePath());
				return null;
			}
			return aird;
		}
		File dir = input.getAbsoluteFile().getParentFile();
		if (dir == null || !dir.isDirectory()) {
			return null;
		}
		File[] airds = dir.listFiles((d, name) -> name.toLowerCase(Locale.ROOT).endsWith(".aird"));
		return airds != null && airds.length > 0 ? airds[0] : null;
	}
}
