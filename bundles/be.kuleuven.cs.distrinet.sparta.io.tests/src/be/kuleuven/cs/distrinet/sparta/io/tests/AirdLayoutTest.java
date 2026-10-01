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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.io.diagram.AirdLayout;
import be.kuleuven.cs.distrinet.sparta.io.diagram.AirdLayout.Box;

/**
 * Tests for {@link AirdLayout}, driven by a hand-crafted {@code .aird} fixture that mirrors the
 * real GMF/Sirius structure: a {@code notation:Diagram} whose {@code notation:Node}s reference
 * Sirius {@code ownedDiagramElements} (by {@code uid}), each carrying a {@code <target href>} to
 * the semantic element, plus one nested node to exercise parent-offset accumulation.
 */
public class AirdLayoutTest {

	private static final String FIXTURE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<xmi:XMI xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\">\n"
			// Sirius diagram elements (target -> semantic element in the model file).
			+ "  <ownedDiagramElements xmi:type=\"diagram:DNode\" uid=\"D1\">\n"
			+ "    <target href=\"Model.sparta#FRAG1\"/>\n"
			+ "  </ownedDiagramElements>\n"
			+ "  <ownedDiagramElements xmi:type=\"diagram:DNodeContainer\" uid=\"D2\">\n"
			+ "    <target href=\"Model.sparta#FRAG2\"/>\n"
			+ "  </ownedDiagramElements>\n"
			+ "  <ownedDiagramElements xmi:type=\"diagram:DNode\" uid=\"D3\">\n"
			+ "    <target href=\"Model.sparta#FRAG3\"/>\n"
			+ "  </ownedDiagramElements>\n"
			// GMF notation side.
			+ "  <data xmi:type=\"notation:Diagram\" xmi:id=\"DIAG\" name=\"Test DFD\">\n"
			+ "    <children xmi:type=\"notation:Node\" xmi:id=\"N1\" element=\"D1\">\n"
			+ "      <layoutConstraint xmi:type=\"notation:Bounds\" x=\"100\" y=\"200\" width=\"60\" height=\"40\"/>\n"
			+ "    </children>\n"
			+ "    <children xmi:type=\"notation:Node\" xmi:id=\"N2\" element=\"D2\">\n"
			+ "      <layoutConstraint xmi:type=\"notation:Bounds\" x=\"300\" y=\"100\" width=\"200\" height=\"150\"/>\n"
			// Nested node: its bounds are relative to N2's origin (300,100).
			+ "      <children xmi:type=\"notation:Node\" xmi:id=\"N3\" element=\"D3\">\n"
			+ "        <layoutConstraint xmi:type=\"notation:Bounds\" x=\"20\" y=\"30\" width=\"50\" height=\"50\"/>\n"
			+ "      </children>\n"
			+ "    </children>\n"
			+ "  </data>\n"
			+ "</xmi:XMI>\n";

	private AirdLayout parseFixture(String xml) throws Exception {
		File temp = File.createTempFile("sparta-test", ".aird");
		temp.deleteOnExit();
		Files.write(temp.toPath(), xml.getBytes(StandardCharsets.UTF_8));
		return AirdLayout.parse(temp);
	}

	@Test
	public void topLevelNodeBounds() throws Exception {
		AirdLayout layout = parseFixture(FIXTURE);
		Box b = layout.boxFor("FRAG1");
		assertNotNull(b);
		assertEquals(100.0, b.x, 0.001);
		assertEquals(200.0, b.y, 0.001);
		assertEquals(60.0, b.width, 0.001);
		assertEquals(40.0, b.height, 0.001);
	}

	@Test
	public void nestedNodeAccumulatesParentOffset() throws Exception {
		AirdLayout layout = parseFixture(FIXTURE);
		Box b = layout.boxFor("FRAG3");
		assertNotNull(b);
		// N3 is at (20,30) relative to N2 at (300,100) => absolute (320,130).
		assertEquals(320.0, b.x, 0.001);
		assertEquals(130.0, b.y, 0.001);
	}

	@Test
	public void diagramTitleIsRead() throws Exception {
		assertEquals("Test DFD", parseFixture(FIXTURE).title());
	}

	@Test
	public void unknownFragmentIsNull() throws Exception {
		assertNull(parseFixture(FIXTURE).boxFor("NOPE"));
		assertNull(parseFixture(FIXTURE).boxFor(null));
	}

	@Test
	public void missingFileYieldsEmptyLayout() {
		AirdLayout layout = AirdLayout.parse(new File("does-not-exist-12345.aird"));
		assertTrue(layout.isEmpty());
	}

	@Test
	public void nullFileYieldsEmptyLayout() {
		assertTrue(AirdLayout.parse(null).isEmpty());
	}
}
