/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.core.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.core.Engine;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.util.SpartaModelResourceFactoryImpl;

/**
 * End-to-end test that runs the full {@link Engine} pipeline on a real example
 * model (the LINDDUN-PRO catalog applied to the SocialNetwork DFD). It exercises
 * pattern parsing ({@code PatternProcessor}'s catalog dependency traversal), the
 * risk pipeline ({@code SpartaRiskModel}, including TEF aggregation), and the loop
 * configuration - and asserts the analysis completes without the previously-possible
 * crashes and yields finite risk figures for every threat.
 */
public class EngineIntegrationTest {

	private static final String[] FIXTURE_FILES = { "SocialNetwork.sparta", "LINDDUN-PRO.sparta" };
	private static final String ROOT_MODEL = "SocialNetwork.sparta";

	// NOTE: run this in a consistent reactor build (spartamodel+queries+core+core.tests built
	// together, as the full `mvn install` from the bundles reactor does) so the OSGi test
	// runtime resolves one coherent bundle set. Building core.tests in isolation against a
	// mixed local p2 cache can resolve mismatched queries/spartamodel versions and fail at
	// engine startup with a QueryInitializationException.
	@Test
	public void analyzesSocialNetworkCaseAndComputesFiniteRisk() throws IOException {
		// The two fixture files reference each other by relative path, so they must sit
		// side by side on the filesystem for EMF to resolve the cross-references.
		Path dir = Files.createTempDirectory("sparta-it");
		try {
			for (String name : FIXTURE_FILES) {
				copyResource("models/" + name, dir.resolve(name));
			}

			// Make the metamodel and the .sparta resource factory available (the OSGi
			// registry normally does this, but register explicitly so the test is robust).
			SpartaModelPackage.eINSTANCE.eClass();
			ResourceSet rs = new ResourceSetImpl();
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sparta",
					new SpartaModelResourceFactoryImpl());

			URI uri = URI.createFileURI(dir.resolve(ROOT_MODEL).toAbsolutePath().toString());
			Resource resource = rs.getResource(uri, true);
			resource.load(null);
			EcoreUtil.resolveAll(rs);

			Engine engine = new Engine(rs);
			try {
				List<Threat> threats = engine.runAnalysis(rs);

				assertNotNull(threats);
				assertFalse("LINDDUN-PRO applied to the SocialNetwork DFD should elicit threats",
						threats.isEmpty());

				for (Threat t : threats) {
					// risk sampling must not have produced NaN or crashed the analysis.
					// TEF must be an aggregated finite value, not left unset.
					assertTrue("risk must be finite", Double.isFinite(t.getRisk()));
					assertTrue("potential risk must be finite", Double.isFinite(t.getPotentialRisk()));
					assertTrue("SLE must be finite", Double.isFinite(t.getSle()));
					assertTrue("TEF must be finite", Double.isFinite(t.getTef()));
					assertTrue("risk must be non-negative", t.getRisk() >= 0);
				}
			} finally {
				engine.dispose();
			}
		} finally {
			deleteRecursively(dir);
		}
	}

	private void copyResource(String resourcePath, Path target) throws IOException {
		try (InputStream in = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
			assertNotNull("fixture resource missing: " + resourcePath, in);
			Files.copy(in, target);
		}
	}

	private void deleteRecursively(Path dir) {
		try {
			Files.walk(dir).sorted((a, b) -> b.getNameCount() - a.getNameCount()).forEach(p -> p.toFile().delete());
		} catch (IOException ignored) {
			// best-effort temp cleanup
		}
	}
}
