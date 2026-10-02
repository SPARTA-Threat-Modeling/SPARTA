/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.spartamodel.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Estimate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatTypeCatalog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;
import be.kuleuven.cs.distrinet.sparta.spartamodel.util.SpartaModelResourceFactoryImpl;

/**
 * Round-trip tests for the SPARTA metamodel's XMI serialization: a DFD model
 * built programmatically with {@link SpartaModelFactory} must survive a save
 * to a {@code .sparta} file and a reload in a fresh {@link ResourceSet} with
 * its structure intact (elements, containment, flow endpoints and estimate
 * values), and the bundled SocialNetwork example fixture must load with the
 * expected shape.
 */
public class SpartaModelRoundTripTest {

	private Path dir;

	@Before
	public void createTempDir() throws IOException {
		dir = Files.createTempDirectory("sparta-model-roundtrip");
	}

	@After
	public void deleteTempDir() {
		try {
			Files.walk(dir).sorted((a, b) -> b.getNameCount() - a.getNameCount()).forEach(p -> p.toFile().delete());
		} catch (IOException ignored) {
			// best-effort temp cleanup
		}
	}

	@Test
	public void savedModelReloadsStructurallyEqual() throws IOException {
		SpartaModelFactory factory = SpartaModelFactory.eINSTANCE;

		// A miniature DFD: User -> Portal (in a trust boundary) -> DB.
		DFDModel model = factory.createDFDModel();

		ExternalEntity user = factory.createExternalEntity();
		user.setName("User");

		TrustBoundaryContainer boundary = factory.createTrustBoundaryContainer();
		boundary.setName("Trust Boundary");

		Process portal = factory.createProcess();
		portal.setName("Portal");

		DataStore db = factory.createDataStore();
		db.setName("DB");

		boundary.getContainedElements().add(portal);
		boundary.getContainedElements().add(db);

		DataFlow userToPortal = factory.createDataFlow();
		userToPortal.setName("UserToPortal");
		userToPortal.setSender(user);
		userToPortal.setRecipient(portal);

		DataFlow portalToDb = factory.createDataFlow();
		portalToDb.setName("PortalToDB");
		portalToDb.setSender(portal);
		portalToDb.setRecipient(db);

		Estimate estimate = factory.createEstimate();
		estimate.setName("attack frequency");
		estimate.setMinimum(0.1);
		estimate.setProbable(0.5);
		estimate.setMaximum(0.9);
		estimate.setConfidence(4.0);
		portal.getEstimates().add(estimate);

		model.getContainedElements().add(user);
		model.getContainedElements().add(boundary);
		model.getContainedElements().add(userToPortal);
		model.getContainedElements().add(portalToDb);

		// Save as .sparta XMI ...
		URI uri = URI.createFileURI(dir.resolve("roundtrip.sparta").toAbsolutePath().toString());
		Resource out = newResourceSet().createResource(uri);
		out.getContents().add(model);
		out.save(null);

		// ... and reload it in a completely fresh resource set.
		Resource in = newResourceSet().getResource(uri, true);
		assertEquals(1, in.getContents().size());
		DFDModel reloaded = (DFDModel) in.getContents().get(0);

		// Top-level elements survived in order.
		assertEquals(4, reloaded.getContainedElements().size());
		ExternalEntity rUser = (ExternalEntity) reloaded.getContainedElements().get(0);
		TrustBoundaryContainer rBoundary = (TrustBoundaryContainer) reloaded.getContainedElements().get(1);
		DataFlow rUserToPortal = (DataFlow) reloaded.getContainedElements().get(2);
		DataFlow rPortalToDb = (DataFlow) reloaded.getContainedElements().get(3);
		assertEquals("User", rUser.getName());
		assertEquals("Trust Boundary", rBoundary.getName());

		// Containment: the boundary still holds the process and the store.
		assertEquals(2, rBoundary.getContainedElements().size());
		Process rPortal = (Process) rBoundary.getContainedElements().get(0);
		DataStore rDb = (DataStore) rBoundary.getContainedElements().get(1);
		assertEquals("Portal", rPortal.getName());
		assertEquals("DB", rDb.getName());

		// Flow endpoints resolve to the reloaded elements (incl. the send/receive
		// opposites maintained by EMF).
		assertEquals("UserToPortal", rUserToPortal.getName());
		assertEquals(rUser, rUserToPortal.getSender());
		assertEquals(rPortal, rUserToPortal.getRecipient());
		assertEquals(rPortal, rPortalToDb.getSender());
		assertEquals(rDb, rPortalToDb.getRecipient());
		assertTrue("sender opposite must be wired", rUser.getSend().contains(rUserToPortal));
		assertTrue("receive opposite must be wired", rDb.getReceive().contains(rPortalToDb));

		// The Estimate value survived on the process.
		assertEquals(1, rPortal.getEstimates().size());
		Estimate rEstimate = rPortal.getEstimates().get(0);
		assertEquals("attack frequency", rEstimate.getName());
		assertEquals(0.1, rEstimate.getMinimum(), 1e-9);
		assertEquals(0.5, rEstimate.getProbable(), 1e-9);
		assertEquals(0.9, rEstimate.getMaximum(), 1e-9);
		assertEquals(4.0, rEstimate.getConfidence(), 1e-9);

		// And the whole tree is structurally equal to what was saved.
		assertTrue("reloaded model must be structurally equal to the original",
				EcoreUtil.equals(model, reloaded));
	}

	@Test
	public void loadsBundledSocialNetworkFixture() throws IOException {
		// The DFD references the catalog by relative path, so both fixture files
		// must sit side by side on the filesystem for EMF to resolve the link.
		copyResource("models/SocialNetwork.sparta", dir.resolve("SocialNetwork.sparta"));
		copyResource("models/LINDDUN-PRO.sparta", dir.resolve("LINDDUN-PRO.sparta"));

		ResourceSet rs = newResourceSet();
		URI uri = URI.createFileURI(dir.resolve("SocialNetwork.sparta").toAbsolutePath().toString());
		Resource resource = rs.getResource(uri, true);
		EcoreUtil.resolveAll(rs);

		assertEquals(1, resource.getContents().size());
		DFDModel root = (DFDModel) resource.getContents().get(0);

		// Root: the User entity, the trust boundary and the UserToPortal flow.
		assertEquals(3, root.getContainedElements().size());
		TrustBoundaryContainer boundary = (TrustBoundaryContainer) root.getContainedElements().get(1);
		// Boundary: Portal, Service, DB + the five internal flows.
		assertEquals(8, boundary.getContainedElements().size());

		// The cross-document reference to the LINDDUN-PRO catalog resolved.
		assertEquals(1, root.getResource().size());
		ThreatTypeCatalog catalog = (ThreatTypeCatalog) root.getResource().get(0);
		assertEquals("LINDDUN-per-interaction", catalog.getName());
	}

	private ResourceSet newResourceSet() {
		// Make the metamodel and the .sparta resource factory available (the OSGi
		// registry normally does this, but register explicitly so the test is
		// robust when run standalone).
		SpartaModelPackage.eINSTANCE.eClass();
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sparta",
				new SpartaModelResourceFactoryImpl());
		return rs;
	}

	private void copyResource(String resourcePath, Path target) throws IOException {
		try (InputStream in = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
			assertNotNull("fixture resource missing: " + resourcePath, in);
			Files.copy(in, target);
		}
	}
}
