/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.cli.ci;

/**
 * The class contains the configuration for running SPARTA in a CI context. This
 * configuration is loaded by processing the .sparta.yml file.
 * 
 * @author Laurens
 *
 */
public class CiConfiguration {

	/**
	 * The server configuration class containing the server url and the submission toke to use.
	 * @author Laurens
	 *
	 */
	public static class ServerConfiguration {
		private String url;
		private String token;

		/**
		 * Get the url of the CTAM server.
		 * @return the url of the server
		 */
		public String getUrl() {
			return url;
		}

		/**
		 * Set the url of the CTAM server.
		 * @param url the URL of the server
		 */
		public void setUrl(String url) {
			this.url = url;
		}

		/**
		 * Get the submission token for the CTAM server.
		 * @return the submission token
		 */
		public String getToken() {
			return token;
		}

		/**
		 * Set the submission token for the CTAM server.
		 * @param token the submission token to set
		 */
		public void setToken(String token) {
			this.token = token;
		}
	}

	/**
	 * The input configuration class containg the name of the spartamodel to load.
	 * @author Laurens
	 *
	 */
	public static class InputConfiguration {
		private String model;

		/**
		 * Get the filename of the sparta model to load.
		 * @return the model filename
		 */
		public String getModel() {
			return model;
		}

		/**
		 * Set the SPARTA model filename.
		 * @param model the model filename
		 */
		public void setModel(String model) {
			this.model = model;
		}
	}

	private InputConfiguration input = new InputConfiguration();

	private ServerConfiguration server = new ServerConfiguration();

	private String overrideCommit;

	private Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public InputConfiguration getInput() {
		return input;
	}

	public void setInput(InputConfiguration input) {
		this.input = input;
	}

	public ServerConfiguration getServer() {
		return server;
	}

	public void setServer(ServerConfiguration server) {
		this.server = server;
	}

	public String getOverrideCommit() {
		return overrideCommit;
	}

	public void setOverrideCommit(String overrideCommit) {
		this.overrideCommit = overrideCommit;
	}

}
