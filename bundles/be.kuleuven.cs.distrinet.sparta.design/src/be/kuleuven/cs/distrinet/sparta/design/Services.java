/*
 * Copyright (c) 2018-2026 DistriNet, KU Leuven (sparta@cs.kuleuven.be)
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package be.kuleuven.cs.distrinet.sparta.design;

import org.eclipse.emf.ecore.EObject;

import be.kuleuven.cs.distrinet.sparta.spartamodel.DFDElement;

/**
 * The services class used by VSM.
 */
public class Services {
    
    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }
    
    /**
     * Ideas
     * 
     * Include a stride mapping table in the model, for a custom definition of which types of threats for which elements have to be considered.
     * ?? Same for threat generation expressions? Some kind of profile?
     * 
     * 
     * @param self
     * @return
     */
    public int getNbrOfApplicableThreatCategories(DFDElement self) {
    		return 0;
    }
}
