/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;


/**
 * Outputstream to support directly writing threats to an xlsx file (e.g.,
 * {@link FileOutputStream}). This class takes care of all the conversion
 * necessary to write out an xlsx file. Users are discouraged to directly write
 * anything other than {@link #write(Threat)} or {@link #write(Threat...)} as
 * the other operations could interfere with the file format.
 * 
 * @author Laurens
 *
 */
public class ThreatXlsxOutputStream extends ThreatOutputStream {

	/**
	 * Create a new {@link ThreatXlsxOutputStream} that writes to out.
	 * 
	 * @param out the {@link OutputStream} to use.
	 */
	public ThreatXlsxOutputStream(OutputStream out) {
		this(out, null);
	}

	/**
	 * Create a new {@link ThreatXlsxOutputStream} that writes to out. If any of the
	 * provided functions return a {@link DFDModelElement}, the {@link ThreatWriter}
	 * will attempt to retrieve the name of the element when writing it to the
	 * output writer.
	 * 
	 * 
	 * @param out        the {@link OutputStream} to use.
	 * @param properties a set of functions, which applied to a threat provide the
	 *                   property to write out
	 */
	public ThreatXlsxOutputStream(OutputStream out, Map<String, Function<Threat, ? extends Object>> properties) {
		super(out, properties);
		wb = new XSSFWorkbook();
		sh = wb.createSheet();
		createHeader();
	}

	private final XSSFWorkbook wb;
	private final Sheet sh;
	private int rowIdx = 0;

	/**
	 * Create the xlsx header in row 0 based on the properties keyset.
	 */
	private void createHeader() {
		Row row = sh.createRow(rowIdx++);
		int cellIdx = 0;
		for (String name : getProperties().keySet()) {
			Cell c = row.createCell(cellIdx++);
			c.setCellValue(name);
		}
	}

	/**
	 * Write-out a threat
	 * 
	 * @param threat the {@link Threat} to write out
	 * @throws IOException If an I/O error occurs.
	 */
	@Override
	public void write(Threat threat) throws IOException {
		Row row = sh.createRow(rowIdx++);
		int cellIdx = 0;
		for (String prop : getProperties().keySet()) {
			Cell c = row.createCell(cellIdx++);
			Object r = getProperties().get(prop).apply(threat);
			if (r instanceof Double) {
				c.setCellValue((double) r);
			} else {
				c.setCellValue("" + r);
			}
		}
	}

	@Override
	public void close() throws IOException {
		try {
			wb.write(this);
		} finally {
			wb.close();
			super.close();
		}
	}

	@Override
	public void write(int arg0) throws IOException {
		this.outputStream.write(arg0);
	}

}
