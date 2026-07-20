/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.io.templates;

import be.kuleuven.cs.distrinet.sparta.core.model.Threat;
import be.kuleuven.cs.distrinet.sparta.io.util.LaTeX;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlow;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataFlowEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.DataStore;
import be.kuleuven.cs.distrinet.sparta.spartamodel.ExternalEntity;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RecipientSpecification;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SenderSpecification;

public class ThreatItemDiagramTemplate extends Template<Threat> {
	public ThreatItemDiagramTemplate() {
		super("threat_item_diagram.txt");
	}

	private static final String SENDERTYPE = "$$SENDERTYPE$$";
	private static final String SENDERNAME = "$$SENDERNAME$$";
	private static final String RECIPIENTTYPE = "$$RECIPIENTTYPE$$";
	private static final String RECIPIENTNAME = "$$RECIPIENTNAME$$";
	private static final String FLOWNAME = "$$FLOWNAME$$";
	private static final String FLOWHIGHLIGHT = "$$FLOWHIGHLIGHT$$";


	public static final ThreatItemDiagramTemplate INSTANCE = new ThreatItemDiagramTemplate();

	public static String fill(Threat x) {
		
		return INSTANCE.instantiate(x);
	}

	@Override
	public String instantiate(Threat x) {
		return getTemplate().replace(SENDERTYPE, getTikzNode(x, x.getDataFlow().getSender(), getSender(x.getDataFlow())))
				.replace(RECIPIENTTYPE, getTikzNode(x, x.getDataFlow().getRecipient(), getRecipient(x.getDataFlow())))
				.replace(SENDERNAME, LaTeX.latexEscape(x.getDataFlowFromName()))
				.replace(RECIPIENTNAME, LaTeX.latexEscape(x.getDataFlowToName()))
				.replace(FLOWNAME, LaTeX.latexEscape(x.getDataFlowName()))
				.replace(FLOWHIGHLIGHT, "DataFlow".equals(x.getThreatenedElementTypeName()) ? "red" : "")
				;
	}
	
	static String getTikzNode(Threat t, DFDElement e, DFDElement specificElement) {
		String node = "";
		if (e instanceof ExternalEntity) {
			node += "externalentity";
		} else if (e instanceof be.kuleuven.cs.distrinet.sparta.spartamodel.Process) {
			node += "process";
		} else if (e instanceof DataStore) {
			node += "datastore";
		}
		
		if (t.getThreatenedElement().equals(e) || t.getThreatenedElement().equals(specificElement)) {
			node += ", red";
		}

		return node;
	}
	
	static DataFlowEntity getSender(DataFlow df) {
		SenderSpecification senderSpec = df.getSenderSpecifiedBy();
		DataFlowEntity sender = df.getSender();
		if (senderSpec != null) {
			while (senderSpec.getSenderSpecifiedBy() != null) {
				senderSpec = senderSpec.getSenderSpecifiedBy();
			}
			sender = senderSpec.getSender();
		}
		
		return sender;
	}
	
	static DataFlowEntity getRecipient(DataFlow df) {
		RecipientSpecification recipientSpec = df.getRecipientSpecifiedBy();
		DataFlowEntity recipient = df.getRecipient();
		if (recipientSpec != null) {
			while (recipientSpec.getRecipientSpecifiedBy() != null) {
				recipientSpec = recipientSpec.getRecipientSpecifiedBy();
			}
			recipient = recipientSpec.getRecipient();
		}
		
		return recipient;
	}
	
}