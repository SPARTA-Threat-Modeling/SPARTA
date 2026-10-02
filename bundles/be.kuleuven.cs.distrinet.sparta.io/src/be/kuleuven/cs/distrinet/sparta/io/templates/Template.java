/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.templates;

import java.io.UncheckedIOException;

public abstract class Template<T> {
	private final String filename;
	private volatile String template;

	protected Template(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	/**
	 * The raw template text. The classpath resource is read lazily on first
	 * access and cached, so constructing a template (including the static
	 * singleton instances) never fails; a missing or unreadable resource
	 * surfaces as an {@link UncheckedIOException} when the template is used.
	 *
	 * @return the template text
	 * @throws UncheckedIOException if the template resource is missing or unreadable
	 */
	public String getTemplate() {
		String t = template;
		if (t == null) {
			t = TemplateUtils.readTemplate(filename);
			template = t;
		}
		return t;
	}

	public abstract String instantiate(T obj);

	@Override
	public String toString() {
		return filename + " (" + getTemplate() + ")";
	}
}
