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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import be.kuleuven.cs.distrinet.sparta.io.convert.YmlToEmfConverter;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelFactoryImpl;
import be.kuleuven.cs.distrinet.sparta.spartamodel.util.SpartaModelResourceFactoryImpl;

/**
 * Tests for {@link YmlToEmfConverter#convert(File, String)}. Conversion used to be a
 * constructor side effect that wrote {@code dfd.sparta} to a fixed location without
 * reporting it, which broke the sparta-ci txt-input path (the CI then loaded a file
 * name that was never created). The converter now returns the path it wrote the
 * converted model to, and rejects empty or malformed input with an error naming the
 * offending file instead of a bare NPE or a raw parser error.
 */
public class YmlToEmfConverterConversionTest {

	private static final String THREAT_CATALOG_FILE = "ThreatSpecification.sparta";

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	private File workingDir;

	@Before
	public void createWorkingDirWithThreatCatalog() throws Exception {
		workingDir = tempFolder.newFolder("txt-input");
		// The converter loads <workingDir>/ThreatSpecification.sparta while saving the
		// converted model; provide a minimal (empty) catalog for it to pick up.
		SpartaModelFactory fac = new SpartaModelFactoryImpl();
		ThreatSpecificationCatalog catalog = fac.createThreatSpecificationCatalog();
		ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sparta",
				new SpartaModelResourceFactoryImpl());
		Resource res = resSet.createResource(
				URI.createFileURI(new File(workingDir, THREAT_CATALOG_FILE).getAbsolutePath()));
		res.getContents().add(catalog);
		res.save(null);
	}

	/**
	 * A minimal txt/yml DFD input converts, and the model file exists at the path the
	 * converter returns — the path sparta-ci feeds to its model loader.
	 */
	@Test
	public void convertsTxtDfdInputAndProducesModelAtReturnedPath() throws Exception {
		String txt = "processes:\n"
				+ "  - WebApp\n"
				+ "dataStores:\n"
				+ "  - Database\n"
				+ "externalEntities:\n"
				+ "  - User\n"
				+ "dataFlows:\n"
				+ "  - User->WebApp\n"
				+ "  - WebApp->Database\n";
		Files.write(new File(workingDir, "dfd.txt").toPath(), txt.getBytes(StandardCharsets.UTF_8));

		File converted = YmlToEmfConverter.convert(workingDir, "dfd.txt");

		assertNotNull("the converter should return the output path", converted);
		assertTrue("the converted model should exist at the returned path: " + converted, converted.isFile());
		assertEquals("the converted model should be written to the working directory",
				workingDir.getCanonicalFile(), converted.getParentFile().getCanonicalFile());

		ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sparta",
				new SpartaModelResourceFactoryImpl());
		Resource res = resSet.getResource(URI.createFileURI(converted.getAbsolutePath()), true);
		DFDModel dfd = res.getContents().stream().filter(DFDModel.class::isInstance).map(DFDModel.class::cast)
				.findAny().orElse(null);
		assertNotNull("the converted file should contain a DFDModel", dfd);
		// 3 entities + 2 bidirectional flows serialized as 2 DataFlow elements each.
		assertEquals(7, dfd.getContainedElements().size());
	}

	/** An empty (or comment-only) input used to NPE; now it fails naming the file. */
	@Test
	public void rejectsEmptyInputWithErrorNamingTheFile() throws Exception {
		Files.write(new File(workingDir, "empty.txt").toPath(),
				"# nothing here\n".getBytes(StandardCharsets.UTF_8));
		try {
			YmlToEmfConverter.convert(workingDir, "empty.txt");
			fail("expected an IOException for an empty txt model");
		} catch (IOException e) {
			assertTrue("the error should name the offending file, was: " + e.getMessage(),
					e.getMessage().contains("empty.txt"));
		}
	}

	/** Malformed YAML is wrapped in an IOException naming the file instead of a raw parser error. */
	@Test
	public void rejectsMalformedInputWithErrorNamingTheFile() throws Exception {
		Files.write(new File(workingDir, "broken.txt").toPath(),
				"processes: [unclosed\n".getBytes(StandardCharsets.UTF_8));
		try {
			YmlToEmfConverter.convert(workingDir, "broken.txt");
			fail("expected an IOException for malformed input");
		} catch (IOException e) {
			assertTrue("the error should name the offending file, was: " + e.getMessage(),
					e.getMessage().contains("broken.txt"));
		}
	}
}
