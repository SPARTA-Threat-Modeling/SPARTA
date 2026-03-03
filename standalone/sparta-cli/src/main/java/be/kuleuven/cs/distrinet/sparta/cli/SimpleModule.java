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

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import be.kuleuven.cs.distrinet.sparta.cli.cmd.About;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.GenericCliCmd;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.Help;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.Version;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportCQR;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportCSV;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportStatistics;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportTXT;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.ExportXLSX;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.Exporter;
import be.kuleuven.cs.distrinet.sparta.cli.cmd.export.SubmitToSpartaServer;

/**
 * Module to configure Guice.
 *
 * @author Laurens
 *
 */
class SimpleModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CliProcessor.class).to(SpartaCliProcessor.class);
		Multibinder<GenericCliCmd> cliBinder = Multibinder.newSetBinder(binder(), GenericCliCmd.class);
		cliBinder.addBinding().to(About.class);
		cliBinder.addBinding().to(Help.class);
		cliBinder.addBinding().to(Version.class);
		Multibinder<Exporter> exportBinder = Multibinder.newSetBinder(binder(), Exporter.class);
	    exportBinder.addBinding().to(ExportCSV.class);
	    exportBinder.addBinding().to(ExportXLSX.class);
	    exportBinder.addBinding().to(ExportTXT.class);
	    exportBinder.addBinding().to(ExportStatistics.class);
	    exportBinder.addBinding().to(ExportCQR.class);
	    exportBinder.addBinding().to(SubmitToSpartaServer.class);
	}

}
