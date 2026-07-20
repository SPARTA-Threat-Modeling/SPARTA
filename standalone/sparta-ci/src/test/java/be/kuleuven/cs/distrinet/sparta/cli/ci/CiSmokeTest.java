/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.cli.ci;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import be.kuleuven.cs.distrinet.sparta.cli.SpartaCliProcessor;
import be.kuleuven.cs.distrinet.sparta.cli.ci.SpartaCi.AnalysisResults;

/**
 * Smoke test for the CI pipeline that runs <em>without</em> a CTAM server. It exercises the
 * server-independent part of {@link SpartaCi}: parsing the {@code .sparta.yml} config
 * (SnakeYAML 2.x), the (no-git) commit resolution, loading the Contoso model, running the
 * threat analysis, and serializing the pattern-stripped DFD model. The actual submission is
 * left out (it needs a live server), so this guards the config + analysis + serialization
 * path that the CLI analysis test does not cover.
 */
public class CiSmokeTest {

	private static final String[] MODEL_FILES = {
			"Contoso.sparta",
			"stride-per-interaction - Shostack.sparta",
			"SecurityPatternCatalog.sparta"
	};

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Before
	public void resetStandaloneRegistry() {
		// analyze() calls the standalone EMF/VIATRA setup itself; nothing to do here beyond
		// letting each test start from the shared static registries.
		SpartaCliProcessor.setupEMFStandalone();
	}

	@Test(timeout = 600_000)
	public void analyzesContosoFromYmlConfigWithoutSubmitting() throws Exception {
		File dir = copyModelsToTempDir();
		String modelPath = new File(dir, "Contoso.sparta").getAbsolutePath().replace('\\', '/');

		// Absolute model path so it resolves regardless of the JVM's user.dir; quoted because a
		// Windows path contains ':' which YAML would otherwise read as a mapping.
		String yml = "input:\n"
				+ "  model: \"" + modelPath + "\"\n"
				+ "server:\n"
				+ "  url: \"https://example.invalid/submit\"\n"
				+ "  token: \"dummy-token\"\n";
		Files.write(new File(dir, ".sparta.yml").toPath(), yml.getBytes(StandardCharsets.UTF_8));

		CiConfiguration conf = SpartaCi.readConfig(dir);
		assertEquals(modelPath, conf.getInput().getModel());
		assertEquals("https://example.invalid/submit", conf.getServer().getUrl());
		assertEquals("dummy-token", conf.getServer().getToken());

		AnalysisResults results = SpartaCi.analyze(conf);
		assertNotNull("the CI analysis should produce results without any server submission", results);
		assertFalse("Contoso should elicit threats", results.getThreatList().isEmpty());
		assertNotNull("a serialized model payload is expected", results.getModel());
		assertTrue("the serialized payload should be the DFD model as XMI, was: " + snippet(results.getModel()),
				results.getModel().contains("DFDModel"));
	}

	private static String snippet(String s) {
		return s == null ? "null" : s.substring(0, Math.min(80, s.length()));
	}

	private File copyModelsToTempDir() throws Exception {
		File dir = tempFolder.newFolder("contoso");
		for (String name : MODEL_FILES) {
			try (InputStream in = getClass().getResourceAsStream("/models/" + name)) {
				assertNotNull("Missing test resource /models/" + name, in);
				Files.copy(in, new File(dir, name).toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
		}
		return dir;
	}
}
