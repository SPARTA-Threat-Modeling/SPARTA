/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import be.kuleuven.cs.distrinet.sparta.io.ReportWriter;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Filesystem tests for {@link ReportWriter#performExport}: the set of files and
 * assets a fresh export produces, the do-not-overwrite contract for the
 * user-editable {@code report.tex}/{@code introduction.tex} (a second export
 * writes {@code *-empty.tex} fallbacks instead), and the grouping of threats by
 * type in the generated threat catalog.
 */
public class ReportWriterTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	private static StubThreat namedThreat(String typeName, String threatName, String elementName) {
		ThreatType type = FACTORY.createThreatType();
		type.setName(typeName);
		Process element = FACTORY.createProcess();
		element.setName(elementName);
		ExternalEntity recipient = FACTORY.createExternalEntity();
		recipient.setName("EE1");
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName(elementName + " to EE1");
		flow.setSender(element);
		flow.setRecipient(recipient);
		return new StubThreat(type, element, flow, new StubRiskModel()) {
			@Override
			public String getThreatName() {
				return threatName;
			}
		};
	}

	private static String read(File dir, String name) throws IOException {
		return new String(Files.readAllBytes(new File(dir, name).toPath()), StandardCharsets.UTF_8);
	}

	/**
	 * A first export into a fresh (not yet existing) directory creates the
	 * directory and writes the four .tex parts plus the copied static assets
	 * (logo, document class and tikz styles).
	 */
	@Test
	public void exportIntoFreshDirectoryWritesReportPartsAndCopiedAssets() throws IOException {
		File dir = new File(tempFolder.getRoot(), "report");

		new ReportWriter().performExport(dir, null,
				Collections.singletonList(namedThreat("Spoofing", "Spoofing S1", "P1")));

		for (String name : new String[] { "report.tex", "introduction.tex", "description.tex", "threatcatalog.tex",
				"SPARTA.png", "tufte-book-local.tex", "tikz/dfdstyle.tex", "tikz/flow_template.tex",
				"tikz/styles.tex" }) {
			assertTrue(name + " should be written by the export", new File(dir, name).isFile());
		}
		assertTrue(read(dir, "report.tex").contains("\\documentclass"));
		assertTrue(read(dir, "description.tex").startsWith("%%% System description"));
		String catalog = read(dir, "threatcatalog.tex");
		assertTrue(catalog, catalog.contains("\\section{Spoofing}"));
		assertTrue(catalog, catalog.contains("\\subsection{Spoofing S1}"));
	}

	/**
	 * {@code report.tex} and {@code introduction.tex} are user-editable entry
	 * points: a second export into the same directory must not clobber them and
	 * writes {@code report-empty.tex}/{@code introduction-empty.tex} instead.
	 */
	@Test
	public void secondExportDoesNotClobberReportAndIntroductionButWritesEmptyFallbacks() throws IOException {
		File dir = tempFolder.newFolder("report");
		List<? extends StubThreat> threats = Collections
				.singletonList(namedThreat("Spoofing", "Spoofing S1", "P1"));
		new ReportWriter().performExport(dir, null, threats);

		// Simulate user edits to the generated entry points.
		Files.write(new File(dir, "report.tex").toPath(), "CUSTOM REPORT".getBytes(StandardCharsets.UTF_8));
		Files.write(new File(dir, "introduction.tex").toPath(), "CUSTOM INTRO".getBytes(StandardCharsets.UTF_8));

		new ReportWriter().performExport(dir, null, threats);

		assertEquals("report.tex must not be overwritten by a re-export", "CUSTOM REPORT", read(dir, "report.tex"));
		assertEquals("introduction.tex must not be overwritten by a re-export", "CUSTOM INTRO",
				read(dir, "introduction.tex"));
		assertTrue(new File(dir, "report-empty.tex").isFile());
		assertTrue(new File(dir, "introduction-empty.tex").isFile());
		// The fallback carries the pristine template content.
		assertTrue(read(dir, "report-empty.tex").contains("\\documentclass"));
	}

	/**
	 * The threat catalog groups threats by type: one {@code \section} per
	 * distinct type, with every threat of that type under it, even when the
	 * input list interleaves the types.
	 */
	@Test
	public void threatsAreGroupedByTypeInTheThreatCatalog() throws IOException {
		List<? extends StubThreat> threats = Arrays.asList(
				namedThreat("Spoofing", "Spoofing S1", "P1"),
				namedThreat("Tampering", "Tampering T1", "P2"),
				namedThreat("Spoofing", "Spoofing S2", "P3"));
		File dir = tempFolder.newFolder("report");

		new ReportWriter().performExport(dir, null, threats);

		String catalog = read(dir, "threatcatalog.tex");
		assertEquals("there must be exactly one section per threat type",
				catalog.indexOf("\\section{Spoofing}"), catalog.lastIndexOf("\\section{Spoofing}"));
		int spoofing = catalog.indexOf("\\section{Spoofing}");
		int s1 = catalog.indexOf("\\subsection{Spoofing S1}");
		int s2 = catalog.indexOf("\\subsection{Spoofing S2}");
		int tampering = catalog.indexOf("\\section{Tampering}");
		int t1 = catalog.indexOf("\\subsection{Tampering T1}");
		assertTrue("all sections and items must be present", spoofing >= 0 && s1 >= 0 && s2 >= 0
				&& tampering >= 0 && t1 >= 0);
		assertTrue("both Spoofing threats must be grouped under the Spoofing section, before the"
				+ " Tampering section and its threat",
				spoofing < s1 && spoofing < s2 && s1 < tampering && s2 < tampering && tampering < t1);
	}
}
