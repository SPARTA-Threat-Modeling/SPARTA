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

import org.eclipse.emf.common.util.URI;

/**
 * Small pure helper for resolving user-supplied model/output paths. Splitting
 * this out of the CLI/CI bootstrap keeps the path handling unit-testable and
 * avoids the fragile {@code user.dir + "/" + target} concatenation that
 * mishandles absolute paths and platform separators.
 *
 * @author Laurens
 *
 */
public final class PathResolver {

	private PathResolver() {
		// utility class, no instances
	}

	/**
	 * Resolve a possibly-relative {@code target} against {@code baseDir}. If
	 * {@code target} is already absolute it is returned unchanged (the base dir is
	 * ignored); otherwise it is resolved as a child of {@code baseDir}. Platform
	 * separators are handled by {@link File}.
	 *
	 * @param baseDir the base directory (typically {@code user.dir})
	 * @param target  the user-supplied path
	 * @return the resolved file
	 */
	public static File resolve(String baseDir, String target) {
		File targetFile = new File(target);
		if (targetFile.isAbsolute()) {
			return targetFile;
		}
		return new File(baseDir, target);
	}

	/**
	 * Resolve {@code target} against {@code baseDir} and turn the result into an
	 * EMF file {@link URI}. Uses {@link URI#createFileURI(String)} on the absolute
	 * path so separators and drive letters are encoded correctly.
	 *
	 * @param baseDir the base directory (typically {@code user.dir})
	 * @param target  the user-supplied path
	 * @return the file URI for the resolved path
	 */
	public static URI toFileURI(String baseDir, String target) {
		return URI.createFileURI(resolve(baseDir, target).getAbsolutePath());
	}
}
