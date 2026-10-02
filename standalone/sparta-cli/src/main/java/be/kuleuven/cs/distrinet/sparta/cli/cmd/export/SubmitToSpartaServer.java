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

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.cli.SpartaServerClient;
import be.kuleuven.cs.distrinet.sparta.core.model.IInteractionThreat;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatJsonWriter;

/**
 * Exporter that submits the analysis results to a SPARTA server via the command line. The
 * HTTP mechanics are delegated to {@link SpartaServerClient} (shared with the CI runner);
 * this class only carries the submission coordinates and serializes the threat list.
 *
 * @author Laurens
 *
 */
public class SubmitToSpartaServer implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(SubmitToSpartaServer.class);

	private final String server;
	private final String token;
	private final String commitId;

	/**
	 * Create a new server submission step.
	 *
	 * @param server   the server submission url.
	 * @param token    the server submission token.
	 * @param commitId the commit id to submit the results under.
	 */
	public SubmitToSpartaServer(String server, String token, String commitId) {
		this.server = server;
		this.token = token;
		this.commitId = commitId;
	}

	@Override
	public boolean export(Collection<Threat> results) {
		logger.info("Submitting to SPARTA server");

		List<IInteractionThreat> threats = results.stream().map(IInteractionThreat.class::cast)
				.collect(Collectors.toList());
		return SpartaServerClient.submit(server, token, commitId,
				writer -> new ThreatJsonWriter<IInteractionThreat>(writer, IInteractionThreat.class).write(threats));
	}
}
