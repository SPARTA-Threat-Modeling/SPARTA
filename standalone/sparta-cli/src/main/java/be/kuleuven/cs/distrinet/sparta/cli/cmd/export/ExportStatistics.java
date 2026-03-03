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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.kuleuven.cs.distrinet.sparta.analysis.ThreatAggregationAnalysis;
import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Export for text export via the command line.
 * 
 * @author Laurens
 *
 */
public class ExportStatistics implements Exporter {

	private static final Logger logger = LoggerFactory.getLogger(ExportStatistics.class);
	private final Option txtoption;

	public ExportStatistics() {
		txtoption = new Option("os", "outstatistics", true, "Output txt file with threat statistics");
	}

	@Override
	public Option[] getOptions() {
		return new Option[] { txtoption };
	}

	@Override
	public void process(CommandLine cmd, Collection<Threat> results) {
		if (!cmd.hasOption(txtoption.getOpt())) {
			return;
		}
		logger.info("Exporting threat statistics");

		String trgt = cmd.getOptionValue(txtoption.getOpt());

		ThreatAggregationAnalysis taa = new ThreatAggregationAnalysis(results);

		try (BufferedWriter w = new BufferedWriter(new FileWriter(new File(trgt)));) {
			w.write("SPARTA Threat Statistics Report");
			w.newLine();
			w.write("===============================");
			w.newLine();
			w.newLine();
			w.write(String.format("%d threats encountered (%d threat types, %d element types)", taa.getThreatCount(),
					taa.getThreatTypeCount(), taa.getDFDElementTypeCount()));
			w.newLine();
			w.newLine();
			w.write(String.format("Risk reduction:\t%3$.2f%% (%1$.2f/%2$.2f)", taa.getTotalRisk(),
					taa.getTotalPotentialRisk(), taa.getTotalRiskReductionPct()*100d));
			w.newLine();
			w.newLine();
			w.write(String.format("Average threat count:\t%.2f", taa.getAverageThreatCounterPerElement()));
			w.newLine();
			w.newLine();
			w.write("Threat Type Reduction Progress");
			w.newLine();
			w.write("------------------------------");
			w.newLine();
			for (ThreatType t : taa.getPotentialRiskPerThreatType().keySet()) {
				w.write(String.format("%s%n\t\t%.2f%% (%.2f/%.2f)", t.getName(),
						taa.getRiskReductionPctPerThreatType().get(t)*100d, taa.getRiskPerThreatType().get(t),
						taa.getPotentialRiskPerThreatType().get(t)));
				w.newLine();
			}
			w.newLine();
			w.write("Element Type Reduction Progress");
			w.newLine();
			w.write("-------------------------------");
			w.newLine();
			for (Class<? extends ModelElement> c : taa.getPotentialRiskPerModelElementType().keySet()) {
				w.write(String.format("%s%n\t\t%.2f%% (%.2f/%.2f)", c.getSimpleName().substring(0, c.getSimpleName().length()-4),
						taa.getRiskReductionPctPerModelElementType().get(c)*100d,
						taa.getRiskPerModelElementType().get(c),
						taa.getPotentialRiskPerModelElementType().get(c)));
				w.newLine();
			}
			w.newLine();
			w.newLine();
			w.write("Threat Type Threat Counts");
			w.newLine();
			w.write("-------------------------");
			w.newLine();
			for (ThreatType t : taa.getThreatCountPerThreatType().keySet()) {
				w.write(String.format("%s%n\t\t%d\t(%.2f%%)", t.getName(),
						taa.getThreatCountPerThreatType().get(t),
						taa.getThreatCountPctPerThreatType().get(t)*100d));
				w.newLine();
			}
			w.newLine();
			w.write("Element Type Threat Counts");
			w.newLine();
			w.write("--------------------------");
			w.newLine();
			for (Class<? extends ModelElement> c : taa.getThreatCountPerModelElementType().keySet()) {
				w.write(String.format("%s%n\t\t%d\t(%.2f%%)", c.getSimpleName().substring(0, c.getSimpleName().length()-4),
						taa.getThreatCountPerModelElementType().get(c),
						taa.getThreatCountPctPerModelElementType().get(c)*100d));
				w.newLine();
			}
			w.newLine();
		} catch (IOException e1) {
			logger.error("Error writing statistics report: {}", e1.getMessage());
		}
	}
}
