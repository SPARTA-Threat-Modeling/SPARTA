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

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;

/**
 * A single export step of the sparta cli. Implementations are constructed with their
 * (already parsed and typed) target and only run when the corresponding option was
 * actually provided — the option-to-exporter wiring lives in the command class.
 *
 * @author Laurens
 *
 */
public interface Exporter {

	/**
	 * Run the export on the provided collection of threats.
	 *
	 * @param results the collection of threats to export
	 * @return {@code true} if the export succeeded; {@code false} if it failed.
	 */
	boolean export(Collection<Threat> results);
}
