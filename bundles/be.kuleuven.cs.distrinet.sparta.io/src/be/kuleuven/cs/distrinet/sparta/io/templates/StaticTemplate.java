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

/**
 * A template without placeholders: instantiating it returns the resource text
 * verbatim. Replaces the former ReportTemplate, IntroductionTemplate,
 * DescriptionTemplate and ThreatCatalog classes, which only differed in the
 * resource name.
 */
public class StaticTemplate extends Template<Object> {

	public StaticTemplate(String filename) {
		super(filename);
	}

	@Override
	public String instantiate(Object ignored) {
		return instantiate();
	}

	public String instantiate() {
		return getTemplate();
	}
}
