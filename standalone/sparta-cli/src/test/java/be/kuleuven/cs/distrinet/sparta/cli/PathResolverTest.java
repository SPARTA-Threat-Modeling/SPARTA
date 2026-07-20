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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

/**
 * Unit tests for {@link PathResolver} - relative vs absolute paths and
 * platform separator handling.
 */
public class PathResolverTest {

	@Test
	public void relativeTargetResolvedAgainstBaseDir() {
		File base = new File("base").getAbsoluteFile();
		File resolved = PathResolver.resolve(base.getPath(), "model.sparta");
		assertEquals(new File(base, "model.sparta"), resolved);
	}

	@Test
	public void relativeTargetWithSubdirectories() {
		File base = new File("base").getAbsoluteFile();
		File resolved = PathResolver.resolve(base.getPath(), "sub/dir/model.sparta");
		assertEquals(new File(base, "sub/dir/model.sparta"), resolved);
	}

	@Test
	public void absoluteTargetIgnoresBaseDir() {
		File absolute = new File("absolute-model.sparta").getAbsoluteFile();
		assertTrue(absolute.isAbsolute());
		File resolved = PathResolver.resolve(
				"some" + File.separator + "other" + File.separator + "base", absolute.getPath());
		assertEquals("An absolute target must not be prefixed with the base dir", absolute, resolved);
	}

	@Test
	public void toFileURIProducesAbsoluteFileUri() {
		File base = new File("base").getAbsoluteFile();
		URI uri = PathResolver.toFileURI(base.getPath(), "model.sparta");
		assertTrue(uri.isFile());
		// EMF file URIs always use forward slashes, regardless of platform.
		assertFalse("File URI must not contain backslashes", uri.toString().contains("\\"));
		assertTrue(uri.toString().endsWith("model.sparta"));
	}

	@Test
	public void toFileURIWithAbsoluteTargetIgnoresBaseDir() {
		File absolute = new File("abs-model.sparta").getAbsoluteFile();
		URI uri = PathResolver.toFileURI("ignored-base", absolute.getPath());
		assertEquals(URI.createFileURI(absolute.getAbsolutePath()), uri);
	}
}
