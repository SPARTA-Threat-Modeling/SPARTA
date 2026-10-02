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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.UncheckedIOException;
import java.util.Collections;
import java.util.Map;

import org.junit.Test;

import be.kuleuven.cs.distrinet.sparta.io.templates.StaticTemplate;
import be.kuleuven.cs.distrinet.sparta.io.templates.TemplateUtils;
import be.kuleuven.cs.distrinet.sparta.io.templates.ThreatsTemplate;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Tests for the LaTeX template mini-engine: escaping of the section type name,
 * single-pass placeholder substitution, and error propagation for missing
 * template resources.
 */
public class LatexTemplateTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	private static StubThreat threatOfType(String typeName) {
		ThreatType type = FACTORY.createThreatType();
		type.setName(typeName);
		Process element = FACTORY.createProcess();
		element.setName("AuthService");
		return new StubThreat(type, element, null, new StubRiskModel());
	}

	@Test
	public void threatsTemplateEscapesTypeNameInSectionHeading() {
		String out = ThreatsTemplate.fill(Collections.singletonList(threatOfType("A&B_C")));

		// The raw name would break LaTeX compilation of the whole report.
		assertTrue(out, out.contains("\\section{A\\&B\\_C}"));
		assertFalse(out, out.contains("\\section{A&B_C}"));
	}

	@Test
	public void substitutionIsSinglePassAndDoesNotReexpandValues() {
		// A substituted value containing a placeholder-like string must not be
		// re-scanned and expanded by a later replacement.
		String out = TemplateUtils.substitute("$$NAME$$ and $$TYPE$$",
				Map.of("$$NAME$$", "element $$TYPE$$ literal", "$$TYPE$$", "Spoofing"));

		assertEquals("element $$TYPE$$ literal and Spoofing", out);
	}

	@Test
	public void substitutionLeavesUnknownPlaceholdersUntouched() {
		String out = TemplateUtils.substitute("$$KNOWN$$ $$UNKNOWN$$", Map.of("$$KNOWN$$", "v"));

		assertEquals("v $$UNKNOWN$$", out);
	}

	@Test
	public void missingTemplateResourceThrowsInsteadOfEmbeddingErrorText() {
		StaticTemplate missing = new StaticTemplate("does-not-exist.txt");
		try {
			missing.instantiate();
			fail("Expected an UncheckedIOException for a missing template resource");
		} catch (UncheckedIOException expected) {
			assertTrue(expected.getMessage(), expected.getCause().getMessage().contains("does-not-exist.txt"));
		}
	}
}
