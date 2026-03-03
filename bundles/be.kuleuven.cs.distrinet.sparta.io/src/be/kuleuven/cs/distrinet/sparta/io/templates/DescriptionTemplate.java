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

public class DescriptionTemplate extends Template<Object> {

	protected DescriptionTemplate() {
		super("description.txt");
	}
	
	public static final DescriptionTemplate INSTANCE = new DescriptionTemplate();

	public static String fill() {
		return INSTANCE.instantiate();
	}

	@Override
	public String instantiate(Object o) {
		return instantiate();
	}
	
	public String instantiate() {
		return getTemplate();
	}

}
