/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import be.kuleuven.cs.distrinet.sparta.io.ThreatXlsxOutputStream;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Process;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatType;

/**
 * Round-trip test for {@link ThreatXlsxOutputStream}: write the header and two
 * stub threats to a temporary .xlsx file, read it back with POI, and assert the
 * header row and the data rows. In particular it pins the typed-output design:
 * risk/vulnerability columns must arrive as NUMERIC cells (raw doubles), while
 * name-like columns are STRING cells with {@code ModelElement}s unwrapped to
 * their names.
 */
public class ThreatXlsxOutputStreamTest {

	private static final SpartaModelFactory FACTORY = SpartaModelFactory.eINSTANCE;

	private static final String[] HEADER = { "Type", "Name", "Location", "Flow From", "Data Flow", "Flow To",
			"Vulnerability", "Risk", "Risk (lower)", "Risk (upper)", "Risk (potential)" };

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	private static StubThreat threat(String typeName, String processName, String flowName, StubRiskModel riskModel) {
		ThreatType type = FACTORY.createThreatType();
		type.setName(typeName);
		Process sender = FACTORY.createProcess();
		sender.setName(processName);
		ExternalEntity recipient = FACTORY.createExternalEntity();
		recipient.setName("EE1");
		DataFlow flow = FACTORY.createDataFlow();
		flow.setName(flowName);
		flow.setSender(sender);
		flow.setRecipient(recipient);
		return new StubThreat(type, sender, flow, riskModel);
	}

	@Test
	public void writtenWorkbookRoundTripsHeaderAndTypedDataRows() throws IOException {
		File xlsx = tempFolder.newFile("threats.xlsx");

		StubThreat first = threat("Spoofing", "P1", "F1", new StubRiskModel());
		StubThreat second = threat("Tampering", "P2", "F2", new StubRiskModel() {
			@Override
			public double[] getRisk() {
				return new double[] { 5, 7.5, 9 };
			}
		});

		try (ThreatXlsxOutputStream out = new ThreatXlsxOutputStream(new FileOutputStream(xlsx))) {
			out.write(first, second);
		}

		try (FileInputStream in = new FileInputStream(xlsx); XSSFWorkbook wb = new XSSFWorkbook(in)) {
			Sheet sheet = wb.getSheetAt(0);
			assertEquals("header plus one row per threat", 2, sheet.getLastRowNum());

			Row header = sheet.getRow(0);
			assertEquals(HEADER.length, header.getLastCellNum());
			for (int i = 0; i < HEADER.length; i++) {
				assertEquals(CellType.STRING, header.getCell(i).getCellType());
				assertEquals(HEADER[i], header.getCell(i).getStringCellValue());
			}

			Row row = sheet.getRow(1);
			assertEquals("Spoofing", row.getCell(0).getStringCellValue());
			// The threat name defaults to the type name.
			assertEquals("Spoofing", row.getCell(1).getStringCellValue());
			// ModelElement-valued properties are unwrapped to the element name.
			assertEquals("P1", row.getCell(2).getStringCellValue());
			assertEquals("P1", row.getCell(3).getStringCellValue());
			assertEquals("F1", row.getCell(4).getStringCellValue());
			assertEquals("EE1", row.getCell(5).getStringCellValue());
			// Typed output: the numeric columns must be numeric cells, not strings.
			for (int i = 6; i < HEADER.length; i++) {
				assertEquals(HEADER[i] + " must be a numeric cell", CellType.NUMERIC,
						row.getCell(i).getCellType());
			}
			assertEquals(0.2, row.getCell(6).getNumericCellValue(), 1e-9);
			assertEquals(20d, row.getCell(7).getNumericCellValue(), 1e-9);
			assertEquals(10d, row.getCell(8).getNumericCellValue(), 1e-9);
			assertEquals(30d, row.getCell(9).getNumericCellValue(), 1e-9);
			assertEquals(100d, row.getCell(10).getNumericCellValue(), 1e-9);

			Row row2 = sheet.getRow(2);
			assertEquals("Tampering", row2.getCell(0).getStringCellValue());
			assertEquals("P2", row2.getCell(2).getStringCellValue());
			assertEquals(CellType.NUMERIC, row2.getCell(7).getCellType());
			assertEquals(7.5, row2.getCell(7).getNumericCellValue(), 1e-9);
		}
	}
}
