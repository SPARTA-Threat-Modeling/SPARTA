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
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

public class TemplateUtils {

	private static final Logger LOGGER = Logger.getLogger(TemplateUtils.class.getName());

	public static final Comparator<? super Threat> BY_NAME = Comparator
			.comparing(e -> (e.toString() != null ? e.toString().toLowerCase(Locale.ROOT) : ""));
	public static final Comparator<? super Threat> BY_RISK = Comparator
			.comparing(e -> (e.getRisk() != null ? e.getRisk() : 0d));
	public static final Comparator<Threat> BY_TYPE_NAME = Comparator
			.comparing(e -> (e.getThreatTypeName() != null ? e.getThreatTypeName().toLowerCase(Locale.ROOT) : ""));


	public static String readTemplate(String filename) {
		String resource = "templates/" + filename;
		try (InputStream file = Template.class.getClassLoader().getResourceAsStream(resource)) {
			if (file == null) {
				LOGGER.log(Level.SEVERE, () -> "Template resource not found: " + resource);
				return "(could not read " + filename + ")";
			}
			return IOUtils.toString(file, StandardCharsets.UTF_8);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e, () -> "Could not read template: " + resource);
		}
		return "(could not read " + filename + ")";
	}
}
