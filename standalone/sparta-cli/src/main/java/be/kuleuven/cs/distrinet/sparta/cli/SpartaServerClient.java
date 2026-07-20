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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shared client for submitting SPARTA analysis results to a CTAM server over HTTP. This
 * centralizes the POST mechanics — https enforcement, connect/read timeouts, the token and
 * commit-id headers, UTF-8 body encoding, HTTP status handling and error-stream reading — so
 * that both the CLI exporter ({@code SubmitToSpartaServer}) and the CI runner ({@code SpartaCi})
 * use one implementation instead of duplicating it. Callers supply only the endpoint,
 * credentials and a {@link BodyWriter} that serializes the (differently-shaped) JSON payload.
 *
 * @author Laurens
 */
public final class SpartaServerClient {

	private static final Logger logger = LoggerFactory.getLogger(SpartaServerClient.class);

	/** Connect timeout in milliseconds for the server submission. */
	private static final int CONNECT_TIMEOUT_MS = 30_000;
	/** Read timeout in milliseconds for the server submission. */
	private static final int READ_TIMEOUT_MS = 60_000;

	private SpartaServerClient() {
		// utility class, no instances
	}

	/**
	 * Writes the JSON request body to the supplied writer. Implementations should only write
	 * (and may flush); the client owns flushing and closing the underlying stream.
	 */
	@FunctionalInterface
	public interface BodyWriter {
		void writeTo(Writer writer) throws IOException;
	}

	/**
	 * POST a JSON payload to the SPARTA server.
	 *
	 * @param serverUrl the server URL; must be {@code https} (the token would otherwise be sent
	 *                  in the clear).
	 * @param token     the submission token, sent as the {@code token} header.
	 * @param commitId  the commit id, sent as the {@code commitId} header.
	 * @param body      writes the JSON request body.
	 * @return {@code true} if the server accepted the submission (HTTP &lt; 400); {@code false}
	 *         on an insecure URL, a write error, an HTTP error status, or any I/O failure.
	 */
	public static boolean submit(String serverUrl, String token, String commitId, BodyWriter body) {
		try {
			URL url = new URL(serverUrl);
			if (!"https".equalsIgnoreCase(url.getProtocol())) {
				logger.error(
						"Refusing to submit to SPARTA server over insecure protocol '{}'; the submission token would be sent in the clear. Use an https URL.",
						url.getProtocol());
				return false;
			}
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(CONNECT_TIMEOUT_MS);
			con.setReadTimeout(READ_TIMEOUT_MS);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("token", token);
			con.setRequestProperty("commitId", commitId);
			con.setDoOutput(true);

			try (OutputStream os = con.getOutputStream();
					Writer writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8))) {
				body.writeTo(writer);
			} catch (IOException e) {
				logger.error("Error writing json: {}", e.getMessage(), e);
				return false;
			}

			int status = con.getResponseCode();
			if (status >= 400) {
				logger.error("SPARTA Server submission failed (HTTP {}): {}", status, readBody(con.getErrorStream()));
				return false;
			}
			logger.info(readBody(con.getInputStream()));
			logger.info("SPARTA Server submission successful (HTTP {}).", status);
			return true;
		} catch (IOException e) {
			logger.error("IOError submitting to SPARTA Server: {}", e.getMessage(), e);
			return false;
		}
	}

	/**
	 * Read a (possibly {@code null}) HTTP response/error stream into a trimmed string.
	 *
	 * @param stream the stream to read, may be {@code null}
	 * @return the concatenated body, or the empty string if the stream is {@code null} or unreadable
	 */
	private static String readBody(InputStream stream) {
		if (stream == null) {
			return "";
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			return response.toString();
		} catch (IOException e) {
			logger.error("Error reading SPARTA Server response: {}", e.getMessage(), e);
			return "";
		}
	}
}
