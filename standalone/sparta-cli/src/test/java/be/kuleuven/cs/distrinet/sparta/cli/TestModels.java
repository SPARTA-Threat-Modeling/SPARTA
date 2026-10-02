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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Shared test fixtures for the standalone smoke tests: the Contoso DFD model plus the two
 * resources it cross-references. The model files live once, under this module's
 * {@code src/test/resources/models}, and are published in the sparta-cli test-jar so that
 * sparta-ci's tests load the exact same fixtures from the classpath instead of keeping copies.
 */
public final class TestModels {

	/** Contoso.sparta plus the two resources it cross-references (kept beside it on load). */
	public static final String[] MODEL_FILES = {
			"Contoso.sparta",
			"stride-per-interaction - Shostack.sparta",
			"SecurityPatternCatalog.sparta"
	};

	private TestModels() {
		// utility class, no instances
	}

	/**
	 * Copy the model and its cross-referenced catalogs from the classpath into {@code dir}
	 * so relative hrefs between them resolve.
	 *
	 * @param dir the (existing) directory to copy the model files into.
	 * @return {@code dir}, for chaining.
	 * @throws IOException if a fixture is missing from the classpath or cannot be copied.
	 */
	public static File copyModelsTo(File dir) throws IOException {
		for (String name : MODEL_FILES) {
			try (InputStream in = TestModels.class.getResourceAsStream("/models/" + name)) {
				if (in == null) {
					throw new FileNotFoundException("Missing test resource /models/" + name);
				}
				Files.copy(in, new File(dir, name).toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
		}
		return dir;
	}
}
