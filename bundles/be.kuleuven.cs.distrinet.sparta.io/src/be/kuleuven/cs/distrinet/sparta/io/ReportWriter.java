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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
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
	
	private List<? extends Threat> threats;
	private ResourceSet model;
	private File aird;

	
	public void performExport(File path, ResourceSet model, List<? extends Threat> threats) {
		this.threats = threats;
		this.model = model;
		
		
		try {
			
			path.mkdirs();

			setupClassFileAndLogo(path);

			String filename = "report.tex";
			File file = new File(path, filename);
			if (file.exists()) {
				
				filename = "report-empty.tex";
				file = new File(path, filename);
			}
			try (
					FileWriter fw = new FileWriter(file);
				) {
				fw.write(ReportTemplate.fill());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// introduction (do not overwrite once generated)
			filename = "introduction.tex";
			file = new File(path, filename);
			if (file.exists()) {
				filename = "introduction-empty.tex";
				file = new File(path, filename);
			}
			try (
					FileWriter fw = new FileWriter(file);
				) {
				fw.write(IntroductionTemplate.fill());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			filename = "description.tex";
			file = new File(path, filename);
			try (OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file),
					StandardCharsets.UTF_8.newEncoder()); BufferedWriter bw = new BufferedWriter(fw);) {
				writeDescriptionToFile(bw);

			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
			filename = "threatcatalog.tex";
			file = new File(path, filename);
			try (OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file),
					StandardCharsets.UTF_8.newEncoder()); BufferedWriter bw = new BufferedWriter(fw);) {
				writeThreatCatalogToFile(bw);

			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
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
	
	public void writeDescriptionToFile(BufferedWriter fw) {

		output(fw, "%%% System description, generated on " + new Date() + "\n\n");

		output(fw, DescriptionTemplate.fill());

		

	}
	
	public void writeThreatCatalogToFile(BufferedWriter fw) {

		output(fw, "%%% Threat catalog, generated on " + new Date() + "\n\n");

		output(fw, ThreatCatalog.fill());


		output(fw, "\n% Threats\n");
		
		threats.stream().map(Threat::getThreatTypeName).distinct().forEach(type -> {
			output(fw, ThreatsTemplate.fill(threats.stream().filter(t -> type.equals(t.getThreatTypeName())).collect(Collectors.toList())));
		});
		output(fw, "\n% END Threats\n");
	}



	private void copyResource(File path, String srcFile, String dstFile) throws IOException {
		if (!path.exists()) {
			path.mkdirs();
		}

		InputStream srcInputStream;
		srcInputStream = Template.class.getClassLoader().getResourceAsStream(srcFile);
		
		
		File destinationFile = new File(path, dstFile);
		Files.copy(srcInputStream, destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
	
	
	protected static void output(BufferedWriter fw, String format) {
		try {
			fw.write(format);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
