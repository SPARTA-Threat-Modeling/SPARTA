/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.diagram;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Extracts the geometry of a Sirius diagram from its {@code .aird} representations file by
 * reading it as plain XML - deliberately with <em>no</em> dependency on Sirius, GMF-runtime,
 * draw2d or SWT, so it runs headlessly (RCP and standalone alike).
 *
 * <p>The mapping followed is the standard GMF/Sirius one:
 * <pre>
 *   notation:Node[@element] --uid--&gt; diagram:DNode/DNodeContainer/DNodeList
 *                                       └─ &lt;target href="model#FRAGMENT"/&gt;
 *   notation:Node/layoutConstraint (notation:Bounds x,y,width,height)
 * </pre>
 * The result maps each semantic element's resource fragment (its {@code xmi:id}, matching
 * {@link org.eclipse.emf.ecore.resource.Resource#getURIFragment}) to its absolute bounds on
 * the diagram. GMF stores child coordinates relative to the parent node, so ancestor offsets
 * are accumulated while walking the notation tree.
 *
 * <p>Any parse/IO error yields an {@linkplain #isEmpty() empty} layout rather than throwing:
 * a missing or unreadable {@code .aird} simply means "no reusable layout", and the report
 * generator falls back gracefully.
 */
public final class AirdLayout {

	/** Absolute bounds of a diagram node, in GMF coordinates (origin top-left, y downwards). */
	public static final class Box {
		public final double x;
		public final double y;
		public final double width;
		public final double height;

		public Box(double x, double y, double width, double height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		public double centerX() {
			return x + (width > 0 ? width / 2 : 0);
		}

		public double centerY() {
			return y + (height > 0 ? height / 2 : 0);
		}
	}

	private final Map<String, Box> boxesByFragment;
	private final String title;

	private AirdLayout(Map<String, Box> boxesByFragment, String title) {
		this.boxesByFragment = boxesByFragment;
		this.title = title;
	}

	/** @return bounds for the semantic element with the given resource fragment, or {@code null}. */
	public Box boxFor(String fragment) {
		return fragment == null ? null : boxesByFragment.get(fragment);
	}

	public boolean isEmpty() {
		return boxesByFragment.isEmpty();
	}

	/** @return a best-effort diagram name, or {@code null} if none was found. */
	public String title() {
		return title;
	}

	private static AirdLayout empty() {
		return new AirdLayout(Collections.emptyMap(), null);
	}

	/**
	 * Parse the given {@code .aird}. Never throws: on any error an empty layout is returned.
	 */
	public static AirdLayout parse(File aird) {
		if (aird == null || !aird.isFile()) {
			return empty();
		}
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(false);
			// Harden against XXE - this file is untrusted user content.
			setFeatureQuietly(factory, "http://apache.org/xml/features/disallow-doctype-decl", true);
			setFeatureQuietly(factory, "http://xml.org/sax/features/external-general-entities", false);
			setFeatureQuietly(factory, "http://xml.org/sax/features/external-parameter-entities", false);
			factory.setXIncludeAware(false);
			factory.setExpandEntityReferences(false);

			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(aird);
			Element root = doc.getDocumentElement();

			Map<String, Element> byId = new HashMap<>();
			indexIds(root, byId);

			// A .aird can hold several diagrams (the main DFD plus decomposition sub-diagrams).
			// Collect each independently and keep the richest one (the main DFD) - merging them
			// would mix coordinate systems and invent cross-diagram edges.
			List<Element> diagrams = new ArrayList<>();
			collectByType(root, "notation:Diagram", diagrams);

			Map<String, Box> best = new HashMap<>();
			Element bestDiagram = null;
			for (Element diagram : diagrams) {
				Map<String, Box> boxes = new HashMap<>();
				collectNodes(diagram, byId, boxes, 0.0, 0.0);
				if (boxes.size() > best.size()) {
					best = boxes;
					bestDiagram = diagram;
				}
			}
			if (bestDiagram == null) {
				// No notation:Diagram found; fall back to scanning the whole document.
				collectNodes(root, byId, best, 0.0, 0.0);
			}
			String title = bestDiagram != null ? emptyToNull(bestDiagram.getAttribute("name")) : null;
			return new AirdLayout(best, title);
		} catch (Exception e) {
			return empty();
		}
	}

	private static String emptyToNull(String value) {
		return value == null || value.isEmpty() ? null : value;
	}

	private static void collectByType(Element element, String xmiType, List<Element> acc) {
		if (xmiType.equals(element.getAttribute("xmi:type"))) {
			acc.add(element);
		}
		for (Element child : childElements(element)) {
			collectByType(child, xmiType, acc);
		}
	}

	private static void setFeatureQuietly(DocumentBuilderFactory factory, String feature, boolean value) {
		try {
			factory.setFeature(feature, value);
		} catch (Exception ignore) {
			// Feature not supported by this parser; best-effort hardening only.
		}
	}

	/** Index every element by its {@code xmi:id} and by its Sirius {@code uid}. */
	private static void indexIds(Element element, Map<String, Element> byId) {
		String xmiId = element.getAttribute("xmi:id");
		if (!xmiId.isEmpty()) {
			byId.put(xmiId, element);
		}
		String uid = element.getAttribute("uid");
		if (!uid.isEmpty()) {
			byId.put(uid, element);
		}
		for (Element child : childElements(element)) {
			indexIds(child, byId);
		}
	}

	/**
	 * Walk the notation tree. {@code offsetX/offsetY} is the absolute origin of the nearest
	 * positioned ancestor, since GMF stores child bounds relative to their parent node.
	 */
	private static void collectNodes(Element element, Map<String, Element> byId, Map<String, Box> boxes,
			double offsetX, double offsetY) {
		double childOffsetX = offsetX;
		double childOffsetY = offsetY;

		if (isNotationNode(element)) {
			Element bounds = layoutBounds(element);
			double localX = 0;
			double localY = 0;
			double w = -1;
			double h = -1;
			if (bounds != null) {
				localX = parseDouble(bounds.getAttribute("x"), 0);
				localY = parseDouble(bounds.getAttribute("y"), 0);
				w = parseDouble(bounds.getAttribute("width"), -1);
				h = parseDouble(bounds.getAttribute("height"), -1);
			}
			double absX = offsetX + localX;
			double absY = offsetY + localY;

			String elementUid = element.getAttribute("element");
			if (bounds != null && !elementUid.isEmpty()) {
				String fragment = semanticFragment(byId.get(elementUid));
				if (fragment != null && !boxes.containsKey(fragment)) {
					boxes.put(fragment, new Box(absX, absY, w, h));
				}
			}

			// Descendants are positioned relative to this node's absolute origin.
			if (bounds != null) {
				childOffsetX = absX;
				childOffsetY = absY;
			}
		}

		for (Element child : childElements(element)) {
			collectNodes(child, byId, boxes, childOffsetX, childOffsetY);
		}
	}

	private static boolean isNotationNode(Element element) {
		return "notation:Node".equals(element.getAttribute("xmi:type"));
	}

	/** The {@code layoutConstraint} child of type {@code notation:Bounds}, or {@code null}. */
	private static Element layoutBounds(Element node) {
		for (Element child : childElements(node)) {
			if ("layoutConstraint".equals(child.getTagName())
					&& "notation:Bounds".equals(child.getAttribute("xmi:type"))) {
				return child;
			}
		}
		return null;
	}

	/**
	 * Resolve a Sirius diagram element to the fragment of its semantic target. The target is
	 * normally a {@code <target href="model#FRAGMENT"/>} child; fall back to a same-document
	 * {@code target} attribute if present.
	 */
	private static String semanticFragment(Element diagramElement) {
		if (diagramElement == null) {
			return null;
		}
		for (Element child : childElements(diagramElement)) {
			if ("target".equals(child.getTagName())) {
				String href = child.getAttribute("href");
				if (!href.isEmpty()) {
					int hash = href.indexOf('#');
					return hash >= 0 ? href.substring(hash + 1) : href;
				}
			}
		}
		String targetAttr = diagramElement.getAttribute("target");
		return targetAttr.isEmpty() ? null : targetAttr;
	}

	private static List<Element> childElements(Element element) {
		List<Element> result = new ArrayList<>();
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node n = children.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				result.add((Element) n);
			}
		}
		return result;
	}

	private static double parseDouble(String value, double fallback) {
		if (value == null || value.isEmpty()) {
			return fallback;
		}
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return fallback;
		}
	}
}
