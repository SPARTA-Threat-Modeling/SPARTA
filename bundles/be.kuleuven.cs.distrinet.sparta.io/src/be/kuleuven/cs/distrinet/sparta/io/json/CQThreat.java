/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
/**
 * 
 */
package be.kuleuven.cs.distrinet.sparta.io.json;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.emf.common.util.URI;

import com.fasterxml.jackson.annotation.JsonValue;

import be.kuleuven.cs.distrinet.sparta.analysis.ThreatAggregationAnalysis;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatTextWriter;

/**
 * @author Laurens
 *
 */
public class CQThreat {

	/**
	 * @author Laurens
	 *
	 */
	public class Lines {
		public Lines(int begin) {
			this.begin = begin;
		}

		private int begin;

		public int getBegin() {
			return begin;
		}

	}

	/**
	 * @author Laurens
	 *
	 */
	public class Location {

		public Location(String path, Lines lines) {
			this.path = path;
			this.lines = lines;
		}

		private String path;
		private Lines lines;

		public String getPath() {
			return path;
		}

		public Lines getLines() {
			return lines;
		}

	}

	/**
	 * @author Laurens
	 *
	 */
	public enum Severity {
		INFO("info"), MINOR("minor"), MAJOR("major"), CRITICAL("critical"), BLOCKING("blocking");

		private String name;

		/**
		 * @param string
		 */
		Severity(String name) {
			this.name = name;
		}

		@JsonValue
		public String getName() {
			return name;
		}
	}

	private String description;
	private String fingerprint;
	private Severity severity;
	private Location location;

	/**
	 * @param t
	 * @param taa
	 */
	public CQThreat(Threat t, ThreatAggregationAnalysis taa) {
		this.description = ThreatTextWriter.fileNameSuggestion(t);
		this.fingerprint = DigestUtils.md5Hex(ThreatTextWriter.fileNameSuggestion(t));
		this.severity = Severity.values()[taa.categorize(t, Severity.values().length-1)];
		URI u = (t.getThreatenedElement() != null && t.getThreatenedElement().eResource() != null)
				? t.getThreatenedElement().eResource().getURI()
				: null;
		if (u != null) {
			String fullPath = FilenameUtils.getPath(u.devicePath());
			String prefix = FilenameUtils.getPath(System.getProperty("user.dir") + "/test.test");
			String relDir = fullPath.startsWith(prefix) ? fullPath.substring(prefix.length()) : fullPath;
			if (!"".equals(relDir))
				relDir += "/";
			this.location = new Location(relDir + FilenameUtils.getName(u.devicePath()), new Lines(1));
		} else {
			this.location = new Location("", new Lines(1));
		}

	}

	public String getDescription() {
		return description;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public Severity getSeverity() {
		return severity;
	}

	public Location getLocation() {
		return location;
	}

}
