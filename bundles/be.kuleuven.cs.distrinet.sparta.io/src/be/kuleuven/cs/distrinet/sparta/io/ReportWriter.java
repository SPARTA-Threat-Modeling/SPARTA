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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.ResourceSet;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.templates.DescriptionTemplate;
import be.kuleuven.cs.distrinet.sparta.io.templates.IntroductionTemplate;
import be.kuleuven.cs.distrinet.sparta.io.templates.ReportTemplate;
import be.kuleuven.cs.distrinet.sparta.io.templates.Template;
import be.kuleuven.cs.distrinet.sparta.io.templates.ThreatCatalog;
import be.kuleuven.cs.distrinet.sparta.io.templates.ThreatsTemplate;

public class ReportWriter {

	private static final Logger LOGGER = Logger.getLogger(ReportWriter.class.getName());

	private List<? extends Threat> threats;
	private ResourceSet model;
	private File aird;


	public void performExport(File path, ResourceSet model, List<? extends Threat> threats) {
		this.threats = threats;
		this.model = model;


		try {

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
				fw.write(ReportTemplate.fill());
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
				fw.write(IntroductionTemplate.fill());
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

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e, () -> "Report export failed, aborting");
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

		output(fw, DescriptionTemplate.fill());



	}

	public void writeThreatCatalogToFile(BufferedWriter fw) throws IOException {

		output(fw, "%%% Threat catalog, generated on " + new Date() + "\n\n");

		output(fw, ThreatCatalog.fill());


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
