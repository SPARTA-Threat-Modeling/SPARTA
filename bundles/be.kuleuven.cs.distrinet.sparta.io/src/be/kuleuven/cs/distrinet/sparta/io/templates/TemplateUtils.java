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

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;

import org.apache.commons.io.IOUtils;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

public class TemplateUtils {
	
	public static final Comparator<? super Threat> BY_NAME = Comparator
			.comparing(e -> (e.toString() != null ? e.toString().toLowerCase() : e.toString()));
	public static final Comparator<? super Threat> BY_RISK = Comparator
			.comparing(e -> (e.getRisk() != null ? e.getRisk() : 0d));
	public static final Comparator<Threat> BY_TYPE_NAME = Comparator
			.comparing(e -> (e.getThreatTypeName() != null ? e.getThreatTypeName().toLowerCase() : e.getThreatTypeName()));


	public static String readTemplate(String filename) {
		try {
			InputStream file = Template.class.getClassLoader().getResourceAsStream("templates/" + filename);
			return new String(IOUtils.toByteArray(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "(could not read " + filename + ")";
	}
}
