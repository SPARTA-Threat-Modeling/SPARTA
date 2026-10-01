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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import be.kuleuven.cs.distrinet.sparta.io.diagram.AirdLayout.Box;
import be.kuleuven.cs.distrinet.sparta.io.util.LaTeX;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDModel;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.TrustBoundaryContainer;

/**
 * Renders a Data Flow Diagram as a self-contained {@code tikzpicture}, reusing the node
 * geometry the user arranged in the Sirius editor (via {@link AirdLayout}). Purely
 * string-based and headless: no Sirius/GMF/draw2d/SWT, so it runs in the RCP and the
 * standalone CLI alike. The emitted styles ({@code process}/{@code datastore}/
 * {@code externalentity}/{@code trustboundary}/{@code to}) are defined in
 * {@code templates/tikz/dfdstyle.tex}, which the report preamble already {@code \input}s.
 */
public final class DfdTikzGenerator {

	/**
	 * GMF-pixel to TikZ-unit scale. Only relative consistency matters because the picture is
	 * wrapped in a {@code \resizebox} that fits it to the line width; this value merely keeps
	 * the internal coordinates in a sane numeric range.
	 */
	private static final double SCALE = 0.026;

	private DfdTikzGenerator() {
	}

	/**
	 * @param model  the DFD model root
	 * @param layout the diagram layout parsed from the {@code .aird} (may be empty)
	 * @return a LaTeX {@code tikzpicture} block, or {@code null} if there is nothing to draw
	 *         (no model, or no element has a known position).
	 */
	public static String generate(DFDModel model, AirdLayout layout) {
		if (model == null) {
			return null;
		}
		Resource resource = model.eResource();
		if (resource == null) {
			return null;
		}

		// Prefer the layout the user arranged in Sirius (via the .aird). When none is available
		// - e.g. a model built through the CLI that was never opened in the diagram editor -
		// fall back to a computed layout so the report still shows a diagram.
		Map<String, Box> computed = (layout == null || layout.isEmpty()) ? computeLayout(model, resource) : null;
		java.util.function.Function<String, Box> lookup = computed != null ? computed::get : layout::boxFor;

		StringBuilder boundaries = new StringBuilder();
		StringBuilder nodes = new StringBuilder();
		StringBuilder edges = new StringBuilder();
		Set<String> placed = new HashSet<>();
		// Fragment -> unique TikZ node name. A counter guarantees uniqueness; deriving the name
		// from the fragment text is unsafe because distinct XMI ids can collapse to the same
		// string once non-alphanumerics are stripped, merging unrelated nodes.
		Map<String, String> names = new HashMap<>();

		// Nodes (trust boundaries first, so they render behind the elements).
		for (Iterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject obj = it.next();
			String style = styleFor(obj);
			if (style == null) {
				continue;
			}
			String fragment = resource.getURIFragment(obj);
			Box box = lookup.apply(fragment);
			if (box == null) {
				continue;
			}
			placed.add(fragment);
			String name = nodeName(fragment, names);
			String label = label(obj);
			if (obj instanceof TrustBoundaryContainer) {
				appendBoundary(boundaries, name, label, box);
			} else {
				appendNode(nodes, name, style, label, box);
			}
		}

		if (placed.isEmpty()) {
			return null;
		}

		// Edges: one per data flow whose endpoints are both placed.
		for (Iterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject obj = it.next();
			if (!(obj instanceof DataFlow)) {
				continue;
			}
			DataFlow flow = (DataFlow) obj;
			String from = placedFragment(flow.getSender(), resource, placed);
			String to = placedFragment(flow.getRecipient(), resource, placed);
			if (from == null || to == null || from.equals(to)) {
				continue;
			}
			appendEdge(edges, nodeName(from, names), nodeName(to, names), flow.getName());
		}

		StringBuilder out = new StringBuilder();
		out.append("\\begin{center}\n");
		out.append("\\resizebox{\\linewidth}{!}{%\n");
		out.append("\\begin{tikzpicture}\n");
		out.append(boundaries);
		out.append(nodes);
		out.append(edges);
		out.append("\\end{tikzpicture}%\n");
		out.append("}\n");
		out.append("\\end{center}\n");
		return out.toString();
	}

	private static String styleFor(EObject obj) {
		if (obj instanceof TrustBoundaryContainer) {
			return "trustboundary";
		}
		if (obj instanceof be.kuleuven.cs.distrinet.sparta.spartamodel.Process) {
			return "process";
		}
		if (obj instanceof DataStore) {
			return "datastore";
		}
		if (obj instanceof ExternalEntity) {
			return "externalentity";
		}
		// Any other data-flow entity (e.g. a decomposed entity such as "Data Storage AC")
		// still appears on the Sirius diagram, so render it with a generic box.
		if (obj instanceof DataFlowEntity) {
			return "externalentity";
		}
		return null;
	}

	private static void appendNode(StringBuilder sb, String name, String style, String label, Box box) {
		sb.append("\\node[").append(style).append(", align=center] (").append(name).append(") at (")
				.append(fmt(box.centerX() * SCALE)).append(',').append(fmt(-box.centerY() * SCALE)).append(") {")
				.append(label).append("};\n");
	}

	private static void appendBoundary(StringBuilder sb, String name, String label, Box box) {
		String minWidth = box.width > 0 ? ", minimum width=" + fmt(box.width * SCALE) + "cm" : "";
		String minHeight = box.height > 0 ? ", minimum height=" + fmt(box.height * SCALE) + "cm" : "";
		sb.append("\\node[trustboundary").append(minWidth).append(minHeight).append("] (").append(name)
				.append(") at (").append(fmt(box.centerX() * SCALE)).append(',').append(fmt(-box.centerY() * SCALE))
				.append(") {};\n");
		if (!label.isEmpty()) {
			// Boundary name at the top-left corner (the conventional DFD spot), inset slightly,
			// so it does not sit on top of the enclosed nodes/edges near the centre.
			double leftX = box.x * SCALE + 0.15;
			double topY = -box.y * SCALE - 0.15;
			sb.append("\\node[dflabel, anchor=north west] at (").append(fmt(leftX)).append(',').append(fmt(topY))
					.append(") {").append(label).append("};\n");
		}
	}

	private static void appendEdge(StringBuilder sb, String from, String to, String flowName) {
		// Bend edges so the two directions of a bidirectional pair (e.g. "A-signaling" and
		// "signaling-A") separate into distinct arcs instead of stacking their labels at the
		// same midpoint. Labels are sloped along the arc and kept small to reduce clutter.
		sb.append("\\draw[to] (").append(from).append(") to[bend left=12] ");
		String label = flowName == null ? "" : LaTeX.latexEscape(flowName).trim();
		if (!label.isEmpty()) {
			sb.append("node[sloped, above, font=\\tiny] {").append(label).append("} ");
		}
		sb.append('(').append(to).append(");\n");
	}

	/**
	 * Resolve a flow endpoint to the TikZ node name of the nearest <em>placed</em> element,
	 * walking up the containment chain when the direct endpoint itself is not drawn (e.g. a
	 * flow attached to a specification inside a decomposed entity). Returns {@code null} if no
	 * ancestor is placed.
	 */
	private static String placedFragment(EObject endpoint, Resource resource, Set<String> placed) {
		for (EObject current = endpoint; current != null; current = current.eContainer()) {
			String fragment = resource.getURIFragment(current);
			if (placed.contains(fragment)) {
				return fragment;
			}
		}
		return null;
	}

	private static String label(EObject obj) {
		String name = null;
		if (obj instanceof be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement) {
			name = ((be.kuleuven.cs.distrinet.sparta.spartamodel.ModelElement) obj).getName();
		}
		if (name == null || name.isBlank()) {
			return "";
		}
		return LaTeX.latexEscape(name).replace("\n", "\\\\");
	}

	/**
	 * Return a stable, unique, TikZ-safe node name for a fragment. Names are allocated
	 * sequentially ({@code n0}, {@code n1}, ...) and cached per generation, so two distinct
	 * fragments can never collide (which sanitizing the fragment text could cause).
	 */
	private static String nodeName(String fragment, Map<String, String> names) {
		return names.computeIfAbsent(fragment, f -> "n" + names.size());
	}

	private static String fmt(double value) {
		// Fixed, locale-independent formatting; TikZ expects '.' as the decimal separator.
		return String.format(java.util.Locale.ROOT, "%.3f", value);
	}

	/**
	 * Deterministic force-directed fallback layout, used when no {@code .aird} is available (e.g.
	 * a model built via the CLI and never opened in the diagram editor). Leaf DFD elements are
	 * positioned with a seeded Fruchterman-Reingold pass - no randomness, so the report is
	 * reproducible - and each trust boundary is sized to the bounding box of the elements it
	 * contains (outer boundaries get more padding so nesting is preserved). Coordinates share the
	 * arbitrary unit system the {@code .aird} path uses; the picture is {@code \resizebox}'d, so
	 * only relative positions matter.
	 */
	private static Map<String, Box> computeLayout(DFDModel model, Resource resource) {
		List<EObject> nodeObjs = new ArrayList<>();
		List<EObject> boundaries = new ArrayList<>();
		for (Iterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject obj = it.next();
			if (obj instanceof TrustBoundaryContainer) {
				boundaries.add(obj);
			} else if (styleFor(obj) != null) {
				nodeObjs.add(obj);
			}
		}

		Map<String, Box> boxes = new HashMap<>();
		int n = nodeObjs.size();
		if (n == 0) {
			return boxes;
		}

		Map<EObject, Integer> index = new HashMap<>();
		for (int i = 0; i < n; i++) {
			index.put(nodeObjs.get(i), i);
		}

		double[] x = new double[n];
		double[] y = new double[n];
		double radius = 40.0 * n;
		for (int i = 0; i < n; i++) {
			double angle = 2 * Math.PI * i / n;
			x[i] = radius * Math.cos(angle);
			y[i] = radius * Math.sin(angle);
		}

		List<int[]> edges = new ArrayList<>();
		for (Iterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject obj = it.next();
			if (!(obj instanceof DataFlow)) {
				continue;
			}
			DataFlow flow = (DataFlow) obj;
			Integer u = resolveIndex(flow.getSender(), index);
			Integer v = resolveIndex(flow.getRecipient(), index);
			if (u != null && v != null && !u.equals(v)) {
				edges.add(new int[] { u, v });
			}
		}

		// Virtual edges clustering the members of each trust boundary (a clique, added with
		// extra weight). Without strong cohesion the layout interleaves elements from different
		// boundaries and their bounding boxes overlap. The clique is applied per boundary, so a
		// node in nested boundaries is pulled toward both groups.
		for (EObject boundary : boundaries) {
			List<Integer> members = new ArrayList<>();
			for (Iterator<EObject> in = boundary.eAllContents(); in.hasNext();) {
				Integer idx = index.get(in.next());
				if (idx != null) {
					members.add(idx);
				}
			}
			for (int a = 0; a < members.size(); a++) {
				for (int b = a + 1; b < members.size(); b++) {
					// Added several times to weight boundary cohesion above ordinary flow edges.
					for (int w = 0; w < 3; w++) {
						edges.add(new int[] { members.get(a), members.get(b) });
					}
				}
			}
		}

		double k = Math.sqrt(((100.0 * n) * (100.0 * n)) / n);
		double temp = 100.0 * n;
		double[] dx = new double[n];
		double[] dy = new double[n];
		for (int iter = 0; iter < 300; iter++) {
			for (int i = 0; i < n; i++) {
				dx[i] = 0;
				dy[i] = 0;
			}
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					double ddx = x[i] - x[j];
					double ddy = y[i] - y[j];
					double dist = Math.max(0.01, Math.hypot(ddx, ddy));
					double force = (k * k) / dist;
					dx[i] += (ddx / dist) * force;
					dy[i] += (ddy / dist) * force;
					dx[j] -= (ddx / dist) * force;
					dy[j] -= (ddy / dist) * force;
				}
			}
			for (int[] e : edges) {
				double ddx = x[e[0]] - x[e[1]];
				double ddy = y[e[0]] - y[e[1]];
				double dist = Math.max(0.01, Math.hypot(ddx, ddy));
				double force = (dist * dist) / k;
				dx[e[0]] -= (ddx / dist) * force;
				dy[e[0]] -= (ddy / dist) * force;
				dx[e[1]] += (ddx / dist) * force;
				dy[e[1]] += (ddy / dist) * force;
			}
			for (int i = 0; i < n; i++) {
				double disp = Math.max(0.01, Math.hypot(dx[i], dy[i]));
				x[i] += (dx[i] / disp) * Math.min(disp, temp);
				y[i] += (dy[i] / disp) * Math.min(disp, temp);
			}
			temp *= 0.95;
		}

		for (int i = 0; i < n; i++) {
			boxes.put(resource.getURIFragment(nodeObjs.get(i)), new Box(x[i], y[i], 0, 0));
		}

		int maxLevel = 0;
		for (EObject b : boundaries) {
			maxLevel = Math.max(maxLevel, boundaryLevel(b));
		}
		double basePad = 0.6 * k;
		for (EObject boundary : boundaries) {
			double minX = Double.POSITIVE_INFINITY, minY = Double.POSITIVE_INFINITY;
			double maxX = Double.NEGATIVE_INFINITY, maxY = Double.NEGATIVE_INFINITY;
			boolean any = false;
			for (Iterator<EObject> in = boundary.eAllContents(); in.hasNext();) {
				Integer idx = index.get(in.next());
				if (idx == null) {
					continue;
				}
				any = true;
				minX = Math.min(minX, x[idx]);
				minY = Math.min(minY, y[idx]);
				maxX = Math.max(maxX, x[idx]);
				maxY = Math.max(maxY, y[idx]);
			}
			if (any) {
				// Outer boundaries (lower level) get more padding so inner ones nest inside.
				double pad = basePad * (maxLevel - boundaryLevel(boundary) + 1);
				boxes.put(resource.getURIFragment(boundary),
						new Box(minX - pad, minY - pad, (maxX - minX) + 2 * pad, (maxY - minY) + 2 * pad));
			}
		}
		return boxes;
	}

	private static Integer resolveIndex(EObject endpoint, Map<EObject, Integer> index) {
		for (EObject current = endpoint; current != null; current = current.eContainer()) {
			Integer idx = index.get(current);
			if (idx != null) {
				return idx;
			}
		}
		return null;
	}

	/** Number of trust-boundary ancestors (0 = outermost), used to scale boundary padding. */
	private static int boundaryLevel(EObject boundary) {
		int level = 0;
		for (EObject c = boundary.eContainer(); c != null; c = c.eContainer()) {
			if (c instanceof TrustBoundaryContainer) {
				level++;
			}
		}
		return level;
	}
}
