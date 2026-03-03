/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.cli.cmd.export;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.core.model.IInteractionThreat;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatJsonWriter;

/**
 * Export for text export via the command line.
 * 
 * @author Laurens
 *
 */
public class SubmitToSpartaServer implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(SubmitToSpartaServer.class);
	private final Option token,server,commitId;

	public SubmitToSpartaServer() {
		token = new Option("st", "token", true, "Server submission token");
		server = new Option("su", "server", true, "Server submission url");
		commitId = new Option("sc", "commitid", true, "Server submission commit id");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] { token,server,commitId };
	}

	@Override
	public void process(CommandLine cmd, Collection<Threat> results) {
		if (!cmd.hasOption(token.getOpt()) || !cmd.hasOption(server.getOpt()) || !cmd.hasOption(commitId.getOpt()) ) {
			return;
		}
		logger.info("Submitting to SPARTA server");



		try {
			URL url = new URL(cmd.getOptionValue(server.getOpt()));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("token", cmd.getOptionValue(token.getOpt()));
			con.setRequestProperty("commitId", cmd.getOptionValue(commitId.getOpt()));
			con.setDoOutput(true);
	
			try (OutputStream os = con.getOutputStream();
					ThreatJsonWriter<IInteractionThreat> tw = new ThreatJsonWriter<>(
							new BufferedWriter(new OutputStreamWriter(os)), IInteractionThreat.class)) {
				tw.write(results.stream().map(IInteractionThreat.class::cast).collect(Collectors.toList()));
				
			} catch (IOException e1) {
				logger.error("Error writing json: {}", e1.getMessage());
				e1.printStackTrace();
			}
			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				logger.info(response.toString());
				logger.info("SPARTA Server submission successful.");
			}
		} catch (IOException eI) {
			eI.printStackTrace();
			logger.error("IOError submitting to SPARTA Server: {}",eI.getMessage());
		}
		
	}
}
