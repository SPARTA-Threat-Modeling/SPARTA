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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EPackage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

/**
 * End-to-end smoke test for the standalone (non-OSGi) analysis bootstrap. It runs the CLI's
 * real EMF + VIATRA standalone setup and analyzes the bundled Contoso DFD model against the
 * STRIDE-per-interaction threat catalog, asserting that threats are actually elicited.
 *
 * <p>This guards the standalone bootstrap that OSGi normally provides but the plain-Java CLI
 * must do itself — in particular the VIATRA pattern-language registration
 * ({@code EMFPatternLanguageStandaloneSetup.doSetup()} in
 * {@link SpartaCliProcessor#setupVIATRAStandalone()}). Without it, building the pattern
 * processor fails with an "Unresolved proxy ...PatternLanguage#//PatternModel" error and no
 * threats are produced.
 */
public class CliAnalysisSmokeTest {

	/** ns-URI of the VIATRA EMF pattern-language metamodel that must be registered standalone. */
	private static final String PATTERN_LANGUAGE_NS =
			"http://www.eclipse.org/viatra/query/patternlanguage/emf/PatternLanguage";

	/** Contoso.sparta plus the two resources it cross-references (kept beside it on load). */
	private static final String[] MODEL_FILES = {
			"Contoso.sparta",
			"stride-per-interaction - Shostack.sparta",
			"SecurityPatternCatalog.sparta"
	};

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Before
	public void setUpStandaloneRuntime() {
		SpartaCliProcessor.setupEMFStandalone();
		SpartaCliProcessor.setupVIATRAStandalone();
	}

	/**
	 * Fast, targeted guard: after the VIATRA standalone setup, the pattern-language EPackage
	 * must be registered. This is precisely what {@code doSetup()} provides, so removing that
	 * call fails here immediately (in milliseconds) rather than only via the slower analysis.
	 */
	@Test
	public void patternLanguageEPackageIsRegisteredAfterViatraSetup() {
		assertTrue("VIATRA pattern-language EPackage must be registered for standalone parsing",
				EPackage.Registry.INSTANCE.containsKey(PATTERN_LANGUAGE_NS));
	}

	/**
	 * Full bootstrap: load the Contoso model through the CLI and confirm the STRIDE catalog is
	 * applied and threats are elicited with a resolvable threat-type category.
	 */
	@Test(timeout = 600_000)
	public void loadsContosoModelAndElicitsThreats() throws Exception {
		File modelDir = copyModelsToTempDir();
		String contoso = new File(modelDir, "Contoso.sparta").getAbsolutePath();

		List<Threat> results = SpartaCliProcessor.runThreatAnalysis(contoso);

		assertNotNull(results);
		assertFalse("Expected the Contoso model to elicit threats, but got none", results.isEmpty());

		Set<String> threatTypes = results.stream()
				.map(Threat::getThreatTypeName)
				.filter(name -> name != null && !name.isEmpty())
				.collect(Collectors.toSet());
		assertFalse("Elicited threats should have resolvable threat-type categories", threatTypes.isEmpty());
		assertTrue("Expected a STRIDE 'Information Disclosure' category, got: " + threatTypes,
				threatTypes.contains("Information Disclosure"));
	}

	/** Copy the model and its cross-referenced catalogs into a temp dir so relative hrefs resolve. */
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
