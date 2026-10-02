/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.diagram.AirdLayout;
import be.kuleuven.cs.distrinet.sparta.io.diagram.DfdTikzGenerator;
import be.kuleuven.cs.distrinet.sparta.io.templates.DescriptionDiagramItemTemplate;
import be.kuleuven.cs.distrinet.sparta.io.templates.DescriptionDiagramsTemplate;
import be.kuleuven.cs.distrinet.sparta.io.templates.StaticTemplate;
import be.kuleuven.cs.distrinet.sparta.io.templates.Template;
import be.kuleuven.cs.distrinet.sparta.io.templates.ThreatsTemplate;
import be.kuleuven.cs.distrinet.sparta.io.util.LaTeX;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;

public class ReportWriter {

	private static final StaticTemplate REPORT = new StaticTemplate("report.txt");
	private static final StaticTemplate INTRODUCTION = new StaticTemplate("introduction.txt");
	private static final StaticTemplate DESCRIPTION = new StaticTemplate("description.txt");
	private static final StaticTemplate THREAT_CATALOG = new StaticTemplate("threatcatalog.txt");

	private List<? extends Threat> threats;
	private ResourceSet model;
	private File aird;

	/**
	 * Optionally supply the Sirius {@code .aird} representations file so the System-description
	 * chapter can include the Data Flow Diagram, reusing the layout the user arranged. Headless:
	 * the file is read as plain XML (see {@link AirdLayout}), so this works in the standalone CLI
	 * as well as the RCP. When {@code null} or unreadable, the diagram is simply omitted.
	 */
	public void setAird(File aird) {
		this.aird = aird;
	}


	/**
	 * Generate the LaTeX report under {@code path}.
	 *
	 * @throws IOException if any part of the export fails. The export aborts on the
	 *                     first failure rather than writing to an already-failed
	 *                     stream, and the exception is propagated so callers can
	 *                     surface it to the user instead of producing a silently
	 *                     partial report.
	 */
	public void performExport(File path, ResourceSet model, List<? extends Threat> threats) throws IOException {
		try {
			doExport(path, model, threats);
		} catch (UncheckedIOException e) {
			// Template resources are read lazily; unwrap so a missing/unreadable
			// template surfaces through the regular IOException path.
			throw e.getCause();
		}
	}

	private void doExport(File path, ResourceSet model, List<? extends Threat> threats) throws IOException {
		this.threats = threats;
		this.model = model;

		Files.createDirectories(path.toPath());

		setupClassFileAndLogo(path);

		String filename = "report.tex";
		File file = new File(path, filename);
		if (file.exists()) {

			filename = "report-empty.tex";
			file = new File(path, filename);
		}
		try (OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file),
				StandardCharsets.UTF_8)) {
			fw.write(REPORT.instantiate());
		}

		// introduction (do not overwrite once generated)
		filename = "introduction.tex";
		file = new File(path, filename);
		if (file.exists()) {
			filename = "introduction-empty.tex";
			file = new File(path, filename);
		}
		try (OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file),
				StandardCharsets.UTF_8)) {
			fw.write(INTRODUCTION.instantiate());
		}

		filename = "description.tex";
		file = new File(path, filename);
		try (OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file),
				StandardCharsets.UTF_8); BufferedWriter bw = new BufferedWriter(fw);) {
			writeDescriptionToFile(bw);

		}

		filename = "threatcatalog.tex";
		file = new File(path, filename);
		try (OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file),
				StandardCharsets.UTF_8); BufferedWriter bw = new BufferedWriter(fw);) {
			writeThreatCatalogToFile(bw);

		}
	}
	
	private void setupClassFileAndLogo(File path)  throws IOException {

		
		copyResource(path, "templates/SPARTA.png", "SPARTA.png");

		File tikzpath = new File(path, "tikz");
		copyResource(tikzpath, "templates/tikz/dfdstyle.tex", "dfdstyle.tex");
		copyResource(tikzpath, "templates/tikz/flow_template.tex", "flow_template.tex");
		copyResource(tikzpath, "templates/tikz/styles.tex", "styles.tex");
		copyResource(path, "templates/tufte-book-local.txt", "tufte-book-local.tex");
	}
	
	public void writeDescriptionToFile(BufferedWriter fw) throws IOException {

		output(fw, "%%% System description, generated on " + new Date() + "\n\n");

		output(fw, DESCRIPTION.instantiate());

		String diagrams = buildDiagramSection();
		if (diagrams != null) {
			output(fw, "\n");
			output(fw, diagrams);
		}
	}

	/**
	 * Build the "Diagrams" section for the System-description chapter: the Data Flow Diagram
	 * rendered as TikZ, reusing the {@code .aird} layout. Returns {@code null} when there is no
	 * model, no {@code .aird}, or nothing positioned to draw - in which case the section is
	 * simply omitted.
	 */
	private String buildDiagramSection() {
		DFDModel dfd = findDFDModel();
		if (dfd == null) {
			return null;
		}
		AirdLayout layout = AirdLayout.parse(aird);
		String tikz = DfdTikzGenerator.generate(dfd, layout);
		if (tikz == null) {
			return null;
		}
		String rawTitle = layout.title();
		if (rawTitle == null || rawTitle.isBlank()) {
			rawTitle = dfd.getName() != null && !dfd.getName().isBlank() ? dfd.getName() : "Data Flow Diagram";
		}
		String item = DescriptionDiagramItemTemplate.fill(LaTeX.latexEscape(rawTitle), tikz);
		return DescriptionDiagramsTemplate.fill(item);
	}

	private DFDModel findDFDModel() {
		if (model == null) {
			return null;
		}
		for (Resource resource : model.getResources()) {
			for (EObject root : resource.getContents()) {
				if (root instanceof DFDModel) {
					return (DFDModel) root;
				}
			}
		}
		return null;
	}

	public void writeThreatCatalogToFile(BufferedWriter fw) throws IOException {

		output(fw, "%%% Threat catalog, generated on " + new Date() + "\n\n");

		output(fw, THREAT_CATALOG.instantiate());


		output(fw, "\n% Threats\n");

		List<String> types = threats.stream().map(Threat::getThreatTypeName).distinct().collect(Collectors.toList());
		for (String type : types) {
			output(fw, ThreatsTemplate.fill(threats.stream().filter(t -> type.equals(t.getThreatTypeName())).collect(Collectors.toList())));
		}
		output(fw, "\n% END Threats\n");
	}



	private void copyResource(File path, String srcFile, String dstFile) throws IOException {
		Files.createDirectories(path.toPath());

		File destinationFile = new File(path, dstFile);
		try (InputStream srcInputStream = Template.class.getClassLoader().getResourceAsStream(srcFile)) {
			if (srcInputStream == null) {
				throw new IOException("Report resource not found on classpath: " + srcFile);
			}
			Files.copy(srcInputStream, destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}


	protected static void output(BufferedWriter fw, String format) throws IOException {
		fw.write(format);
		fw.flush();
	}
}
