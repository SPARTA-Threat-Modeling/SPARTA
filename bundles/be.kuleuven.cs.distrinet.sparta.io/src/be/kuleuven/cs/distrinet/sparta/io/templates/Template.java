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

public abstract class Template<T> {
	private final String filename;
	private final String template;

	protected Template(String filename) {
		this.filename = filename;
		this.template = TemplateUtils.readTemplate(filename);
	}

	public String getFilename() {
		return filename;
	}

	public String getTemplate() {
		return template;
	}

	public abstract String instantiate(T obj);

	@Override
	public String toString() {
		return filename + " (" + template + ")";
	}
}