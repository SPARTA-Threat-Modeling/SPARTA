/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.analysis.vql;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Dialog for editing the (multi-valued) {@code ThreatPattern.patterns} VQL text with
 * syntax highlighting. The list of pattern entries is shown on the left; the selected
 * entry is edited in a highlighted {@link SourceViewer} on the right. The read-only
 * package/imports context of the containing catalog is shown above so the author sees
 * the same preamble the runtime prepends when parsing.
 */
public class VqlPatternEditDialog extends TitleAreaDialog {

	private final String patternName;
	private final String contextPreamble;
	private final java.util.List<String> patterns;

	private java.util.List<String> result;

	private final VqlColorManager colorManager = new VqlColorManager();

	private org.eclipse.swt.widgets.List patternList;
	private SourceViewer viewer;
	private int currentIndex = -1;

	public VqlPatternEditDialog(Shell parentShell, String patternName, String contextPreamble,
			java.util.List<String> initialPatterns) {
		super(parentShell);
		this.patternName = patternName == null ? "" : patternName;
		this.contextPreamble = contextPreamble == null ? "" : contextPreamble;
		this.patterns = new ArrayList<>(initialPatterns);
		setShellStyle(getShellStyle() | SWT.RESIZE | SWT.MAX);
	}

	/** @return the edited pattern list, or {@code null} if the dialog was cancelled. */
	public java.util.List<String> getResult() {
		return result;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Edit VQL pattern" + (patternName.isEmpty() ? "" : ": " + patternName));
		setMessage("Edit the VIATRA query (VQL) text. The package/imports preamble below is read-only context.");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);

		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(new GridLayout(1, false));

		if (!contextPreamble.isBlank()) {
			Group ctxGroup = new Group(container, SWT.NONE);
			ctxGroup.setText("Context (read-only)");
			ctxGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
			ctxGroup.setLayout(new GridLayout(1, false));
			Text ctxText = new Text(ctxGroup, SWT.MULTI | SWT.READ_ONLY | SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
			GridData ctxData = new GridData(SWT.FILL, SWT.FILL, true, false);
			ctxData.heightHint = 60;
			ctxText.setLayoutData(ctxData);
			ctxText.setFont(JFaceResources.getTextFont());
			ctxText.setText(contextPreamble);
		}

		SashForm sash = new SashForm(container, SWT.HORIZONTAL);
		sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createListSide(sash);
		createEditorSide(sash);
		sash.setWeights(new int[] { 2, 5 });

		refreshList();
		if (!patterns.isEmpty()) {
			patternList.select(0);
			loadEntry(0);
		} else {
			updateEditorEnablement();
		}

		return area;
	}

	private void createListSide(Composite parent) {
		Composite left = new Composite(parent, SWT.NONE);
		left.setLayout(new GridLayout(1, false));

		Label label = new Label(left, SWT.NONE);
		label.setText("Patterns");
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		patternList = new org.eclipse.swt.widgets.List(left, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		patternList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		patternList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stashCurrent();
				int idx = patternList.getSelectionIndex();
				loadEntry(idx);
			}
		});

		Composite buttons = new Composite(left, SWT.NONE);
		buttons.setLayout(new GridLayout(2, true));
		buttons.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false));
		makeButton(buttons, "Add", e -> addEntry());
		makeButton(buttons, "Remove", e -> removeEntry());
		makeButton(buttons, "Up", e -> moveEntry(-1));
		makeButton(buttons, "Down", e -> moveEntry(1));
	}

	private void createEditorSide(Composite parent) {
		Composite right = new Composite(parent, SWT.NONE);
		right.setLayout(new GridLayout(1, false));

		Label label = new Label(right, SWT.NONE);
		label.setText("Pattern body");
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		viewer = new SourceViewer(right, null, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		viewer.configure(new VqlSourceViewerConfiguration(colorManager));
		viewer.setDocument(new Document(""));
		viewer.getTextWidget().setFont(JFaceResources.getTextFont());
		GridData viewerData = new GridData(SWT.FILL, SWT.FILL, true, true);
		viewerData.widthHint = 480;
		viewerData.heightHint = 320;
		viewer.getControl().setLayoutData(viewerData);
	}

	private Button makeButton(Composite parent, String text, org.eclipse.swt.widgets.Listener onClick) {
		Button b = new Button(parent, SWT.PUSH);
		b.setText(text);
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		data.minimumWidth = 80;
		data.heightHint = 28;
		b.setLayoutData(data);
		b.addListener(SWT.Selection, onClick);
		return b;
	}

	private void refreshList() {
		int sel = patternList.getSelectionIndex();
		patternList.removeAll();
		for (int i = 0; i < patterns.size(); i++) {
			patternList.add(labelFor(i, patterns.get(i)));
		}
		if (sel >= 0 && sel < patternList.getItemCount()) {
			patternList.select(sel);
		}
	}

	private String labelFor(int index, String body) {
		String firstLine = body == null ? "" : body.strip();
		int nl = firstLine.indexOf('\n');
		if (nl >= 0) {
			firstLine = firstLine.substring(0, nl).strip();
		}
		if (firstLine.isEmpty()) {
			return (index + 1) + ": (empty)";
		}
		if (firstLine.length() > 50) {
			firstLine = firstLine.substring(0, 50) + "…";
		}
		return (index + 1) + ": " + firstLine;
	}

	private void loadEntry(int index) {
		currentIndex = index;
		if (index >= 0 && index < patterns.size()) {
			viewer.setDocument(new Document(patterns.get(index)));
		} else {
			viewer.setDocument(new Document(""));
		}
		updateEditorEnablement();
	}

	private void updateEditorEnablement() {
		boolean enabled = currentIndex >= 0 && currentIndex < patterns.size();
		viewer.setEditable(enabled);
		viewer.getTextWidget().setEnabled(enabled);
	}

	private void stashCurrent() {
		if (currentIndex >= 0 && currentIndex < patterns.size()) {
			String text = viewer.getDocument().get();
			patterns.set(currentIndex, text);
			patternList.setItem(currentIndex, labelFor(currentIndex, text));
		}
	}

	private void addEntry() {
		stashCurrent();
		patterns.add("");
		refreshList();
		int idx = patterns.size() - 1;
		patternList.select(idx);
		loadEntry(idx);
		viewer.getTextWidget().setFocus();
	}

	private void removeEntry() {
		if (currentIndex < 0 || currentIndex >= patterns.size()) {
			return;
		}
		patterns.remove(currentIndex);
		int next = Math.min(currentIndex, patterns.size() - 1);
		currentIndex = -1;
		refreshList();
		if (next >= 0) {
			patternList.select(next);
			loadEntry(next);
		} else {
			loadEntry(-1);
		}
	}

	private void moveEntry(int delta) {
		stashCurrent();
		int idx = currentIndex;
		int target = idx + delta;
		if (idx < 0 || target < 0 || target >= patterns.size()) {
			return;
		}
		String moved = patterns.remove(idx);
		patterns.add(target, moved);
		currentIndex = target;
		refreshList();
		patternList.select(target);
		loadEntry(target);
	}

	@Override
	protected void okPressed() {
		stashCurrent();
		result = new ArrayList<>(patterns);
		super.okPressed();
	}

	@Override
	public boolean close() {
		boolean closed = super.close();
		if (closed) {
			colorManager.dispose();
		}
		return closed;
	}
}
