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

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.cli.SpartaServerClient;
import be.kuleuven.cs.distrinet.sparta.core.model.IInteractionThreat;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.ThreatJsonWriter;

/**
 * Exporter that submits the analysis results to a SPARTA server via the command line. The
 * HTTP mechanics are delegated to {@link SpartaServerClient} (shared with the CI runner);
 * this class only maps the CLI options to a submission and serializes the threat list.
 *
 * @author Laurens
 *
 */
public class SubmitToSpartaServer implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(SubmitToSpartaServer.class);

	private final Option token,server,commitId;

	public SubmitToSpartaServer() {
		token = new Option(null, "token", true, "Server submission token");
		server = new Option(null, "server", true, "Server submission url");
		commitId = new Option(null, "commitid", true, "Server submission commit id");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] { token,server,commitId };
	}

	@Override
	public boolean process(CommandLine cmd, Collection<Threat> results) {
		if (!cmd.hasOption(token.getLongOpt()) || !cmd.hasOption(server.getLongOpt()) || !cmd.hasOption(commitId.getLongOpt()) ) {
			return true;
		}
		logger.info("Submitting to SPARTA server");

		List<IInteractionThreat> threats = results.stream().map(IInteractionThreat.class::cast)
				.collect(Collectors.toList());
		return SpartaServerClient.submit(
				cmd.getOptionValue(server.getLongOpt()),
				cmd.getOptionValue(token.getLongOpt()),
				cmd.getOptionValue(commitId.getLongOpt()),
				writer -> new ThreatJsonWriter<IInteractionThreat>(writer, IInteractionThreat.class).write(threats));
	}
}
