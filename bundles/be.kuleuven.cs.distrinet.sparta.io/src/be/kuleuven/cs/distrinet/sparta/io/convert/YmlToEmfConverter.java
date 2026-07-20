/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.convert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelFactory;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SpartaModelPackage;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ThreatSpecificationCatalog;
import be.kuleuven.cs.distrinet.sparta.spartamodel.impl.SpartaModelFactoryImpl;
import be.kuleuven.cs.distrinet.sparta.spartamodel.util.SpartaModelResourceFactoryImpl;

/**
 * @author Laurens
 *
 */
public class YmlToEmfConverter {

	/**
	 * The representation of a very simple txtmodel of a DFD.
	 * @author Laurens
	 *
	 */
	public static class TxtModel {
		private Set<String> processes;
		private Set<String> dataStores;
		private Set<String> externalEntities;
		private List<String> dataFlows;
		public TxtModel() {
			
		}
		public Set<String> getProcesses() {
			return processes;
		}
		public void setProcesses(Set<String> processes) {
			this.processes = processes;
		}
		public Set<String> getDataStores() {
			return dataStores;
		}
		public void setDataStores(Set<String> dataStores) {
			this.dataStores = dataStores;
		}
		public Set<String> getExternalEntities() {
			return externalEntities;
		}
		public void setExternalEntities(Set<String> externalEntities) {
			this.externalEntities = externalEntities;
		}
		public List<String> getDataFlows() {
			return dataFlows;
		}
		public void setDataFlows(List<String> dataFlows) {
			this.dataFlows = dataFlows;
		}

	}
	
	/**
	 * Run the YmlToEmfConverter from the command line. The first argument is the file name.
	 * @param args Command line arguments. The first argument should be the filename.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if (args.length < 1 || args[0] == null || args[0].isEmpty()) {
			throw new IllegalArgumentException("Usage: YmlToEmfConverter <yaml-file>");
		}
		new YmlToEmfConverter(args[0]);
	}

	public YmlToEmfConverter(String file) throws IOException {
		Representer representer = new Representer(null);
		representer.getPropertyUtils().setSkipMissingProperties(true);
		Yaml yaml = new Yaml(new Constructor(TxtModel.class, null),representer);
		File yml = new File(new File(System.getProperty("user.dir")),file);
		TxtModel model;
		try (FileInputStream in = new FileInputStream(yml)) {
			model = yaml.load(in);
		}
		saveToModel(model);
	}
	
	private Map<String, DataFlowEntity> elementMap = new HashMap<>();
	private List<DataFlow> dataflows = new ArrayList<>();
	private SpartaModelFactory fac = new SpartaModelFactoryImpl();
	private static final String dataflowTemplate = "%s->%s";
	
	public void saveToModel(TxtModel model) throws IOException {
		createProcesses(model.getProcesses());
		createDataStores(model.getDataStores());
		createExternalEntities(model.getExternalEntities());
		createDataFlows(model.getDataFlows());
		DFDModel dfd = fac.createDFDModel();
		addModelElements(dfd, elementMap.values());
		addModelElements(dfd, dataflows);
		saveDFD(dfd);
	}
	
	


	private void createProcesses(Set<String> processes) {
		if (processes == null) {
			return;
		}
		for (String proc : processes) {
			be.kuleuven.cs.distrinet.sparta.spartamodel.Process p = fac.createProcess();
			p.setName(proc);
			elementMap.put(proc, p);

		}
	}

	private void createDataStores(Set<String> datastores) {
		if (datastores == null) {
			return;
		}
		for (String store : datastores) {
			DataStore ds = fac.createDataStore();
			ds.setName(store);
			elementMap.put(store, ds);

		}
	}

	private void createExternalEntities(Set<String> externalentities) {
		if (externalentities == null) {
			return;
		}
		for (String e : externalentities) {
			ExternalEntity ee = fac.createExternalEntity();
			ee.setName(e);
			elementMap.put(e, ee);
		}
	}
	
	private void createDataFlows(List<String> dataflows) {
		if (dataflows == null) {
			return;
		}
		for (String f : dataflows) {
			String[] endpoints = parseDataFlowEndpoints(f);
			String sender = endpoints[0];
			String recipient = endpoints[1];
			if (!elementMap.containsKey(sender)) {
				throw new IllegalArgumentException("Unknown data-flow sender '" + sender + "' in entry: " + f);
			}
			if (!elementMap.containsKey(recipient)) {
				throw new IllegalArgumentException("Unknown data-flow recipient '" + recipient + "' in entry: " + f);
			}
			createDataFlow(sender, recipient);
		}
	}

	/**
	 * Parse a data-flow entry of the form {@code "sender->recipient"} into its two
	 * endpoints. The entry must contain exactly one {@code "->"} separator and both
	 * endpoints must be non-blank.
	 *
	 * @param entry the raw data-flow entry.
	 * @return a two-element array {@code [sender, recipient]} (both trimmed).
	 * @throws IllegalArgumentException if the entry is null, does not contain
	 *                                  exactly one {@code "->"} separator, or has an
	 *                                  empty endpoint.
	 */
	public static String[] parseDataFlowEndpoints(String entry) {
		if (entry == null) {
			throw new IllegalArgumentException("Data-flow entry must not be null");
		}
		String[] parts = entry.split("->", -1);
		if (parts.length != 2) {
			throw new IllegalArgumentException(
					"Data-flow entry must contain exactly one '->' separator: " + entry);
		}
		String sender = parts[0].trim();
		String recipient = parts[1].trim();
		if (sender.isEmpty() || recipient.isEmpty()) {
			throw new IllegalArgumentException("Data-flow entry has an empty endpoint: " + entry);
		}
		return new String[] { sender, recipient };
	}

	private void addModelElements(DFDModel dfd, Collection<? extends ModelElement> elements) {
		for (ModelElement e : elements) {
			dfd.getContainedElements().add(e);
		}
	}

	private void createDataFlow(String s, String r) {
		DataFlow df = fac.createDataFlow();
		String name = String.format(dataflowTemplate, s, r);
		df.setSender(elementMap.get(s));
		df.setRecipient(elementMap.get(r));
		df.setName(name);
		dataflows.add(df);

		df = fac.createDataFlow();
		name = String.format(dataflowTemplate, r, s);
		df.setSender(elementMap.get(r));
		df.setRecipient(elementMap.get(s));
		df.setName(name);
		dataflows.add(df);
	}

	private void saveDFD(DFDModel dfd) throws IOException {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		URI fileURI = URI.createFileURI(System.getProperty("user.dir") + "/dfd.sparta");
		reg.getExtensionToFactoryMap().put(fileURI.fileExtension(), new SpartaModelResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// create a resource
		Resource resource = resSet.createResource(fileURI);
		
		// load threat catalog

		SpartaModelPackage.eINSTANCE.eClass();
		URI threatcat = URI.createFileURI(System.getProperty("user.dir") + "/" + "ThreatSpecification.sparta");
		Resource threatres = resSet.getResource(threatcat, true);
		threatres.getContents().stream().filter(ThreatSpecificationCatalog.class::isInstance).map(ThreatSpecificationCatalog.class::cast).forEach(dfd.getResource()::add);

		resource.getContents().add(dfd);

		resource.save(null);
	}
}
