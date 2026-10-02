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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import be.kuleuven.cs.distrinet.sparta.spartamodel.AbstractThreatType;
import be.kuleuven.cs.distrinet.sparta.spartamodel.CounterMeasure;
import be.kuleuven.cs.distrinet.sparta.spartamodel.RoleBinding;
import be.kuleuven.cs.distrinet.sparta.spartamodel.Solution;
import be.kuleuven.cs.distrinet.sparta.spartamodel.SolutionType;

/**
 * The services class used by VSM.
 *
 * <p>Besides the legacy helpers, this exposes "security coverage" services that
 * the Sirius diagram can call from AQL (e.g. {@code aql:self.coverageLabel()},
 * {@code aql:self.mitigatedThreatTypeCount()}) to show how much a solution or
 * countermeasure actually covers. All methods are null-tolerant so they are safe
 * to call on partially-built models.</p>
 *
 * <p>See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24
 * for documentation on how to write service methods.</p>
 */
public class Services {

    // ---------------------------------------------------------------------
    // Security coverage services
    // ---------------------------------------------------------------------

    /**
     * The distinct threat types a countermeasure mitigates (the resolved
     * {@code mitigates} references only; use {@link #mitigatedThreatTypeCount}
     * for the count that also accounts for id-only references).
     */
    public Collection<AbstractThreatType> mitigatedThreatTypes(CounterMeasure self) {
        Set<AbstractThreatType> result = new LinkedHashSet<>();
        if (self != null) {
            result.addAll(self.getMitigates());
        }
        return result;
    }

    /** The distinct threat types mitigated by all of a solution type's countermeasures. */
    public Collection<AbstractThreatType> mitigatedThreatTypes(SolutionType self) {
        Set<AbstractThreatType> result = new LinkedHashSet<>();
        if (self != null) {
            for (CounterMeasure cm : self.getCountermeasure()) {
                result.addAll(cm.getMitigates());
            }
        }
        return result;
    }

    /** The distinct threat types mitigated by the solution's applied pattern. */
    public Collection<AbstractThreatType> mitigatedThreatTypes(Solution self) {
        return mitigatedThreatTypes(self == null ? null : self.getSecuritypattern());
    }

    /**
     * Number of distinct threat types a countermeasure mitigates, counting both
     * resolved {@code mitigates} references and id-only
     * {@code mitigatedThreatTypeID} references (deduplicated by id).
     */
    public int mitigatedThreatTypeCount(CounterMeasure self) {
        return threatTypeKeys(self).size();
    }

    /** Number of distinct threat types a solution type mitigates across its countermeasures. */
    public int mitigatedThreatTypeCount(SolutionType self) {
        Set<String> keys = new LinkedHashSet<>();
        if (self != null) {
            for (CounterMeasure cm : self.getCountermeasure()) {
                keys.addAll(threatTypeKeys(cm));
            }
        }
        return keys.size();
    }

    /** Number of distinct threat types the solution's applied pattern mitigates. */
    public int mitigatedThreatTypeCount(Solution self) {
        return mitigatedThreatTypeCount(self == null ? null : self.getSecuritypattern());
    }

    /** Comma-separated titles of the threat types a solution type mitigates (for tooltips). */
    public String mitigatedThreatTypeNames(SolutionType self) {
        return mitigatedThreatTypes(self).stream()
                .map(this::threatTypeLabel)
                .collect(Collectors.joining(", "));
    }

    /** Comma-separated titles of the threat types the solution's pattern mitigates (for tooltips). */
    public String mitigatedThreatTypeNames(Solution self) {
        return mitigatedThreatTypeNames(self == null ? null : self.getSecuritypattern());
    }

    // ---- role-binding completeness ----

    /** Role bindings of a solution that are not yet bound to any asset. */
    public List<RoleBinding> unassignedRoleBindings(Solution self) {
        List<RoleBinding> result = new ArrayList<>();
        if (self != null) {
            for (RoleBinding rb : self.getRolebinding()) {
                if (rb.getBindsTo() == null || rb.getBindsTo().isEmpty()) {
                    result.add(rb);
                }
            }
        }
        return result;
    }

    /** Number of role bindings of a solution. */
    public int roleBindingCount(Solution self) {
        return self == null ? 0 : self.getRolebinding().size();
    }

    /** Number of role bindings that are still unassigned. */
    public int unassignedRoleCount(Solution self) {
        return unassignedRoleBindings(self).size();
    }

    /** Number of role bindings that are bound to at least one asset. */
    public int boundRoleCount(Solution self) {
        return roleBindingCount(self) - unassignedRoleCount(self);
    }

    /** {@code true} when the solution has role bindings and all of them are bound. */
    public boolean isFullyBound(Solution self) {
        return self != null && !self.getRolebinding().isEmpty() && unassignedRoleCount(self) == 0;
    }

    /**
     * A short human-readable coverage summary for a solution, suitable for a
     * node label or tooltip, e.g. {@code "3 threat types mitigated; 2/3 roles bound"}.
     */
    public String coverageLabel(Solution self) {
        int threats = mitigatedThreatTypeCount(self);
        int total = roleBindingCount(self);
        int bound = boundRoleCount(self);
        return threats + " threat type" + (threats == 1 ? "" : "s") + " mitigated; "
                + bound + "/" + total + " role" + (total == 1 ? "" : "s") + " bound";
    }

    // ---------------------------------------------------------------------
    // helpers
    // ---------------------------------------------------------------------

    /**
     * Deduplication keys for the threat types a single countermeasure mitigates.
     * Resolved threat types are keyed by their model id (falling back to object
     * identity when the id is absent); id-only references are keyed by the id
     * string, so a type referenced both ways is counted once.
     */
    private Set<String> threatTypeKeys(CounterMeasure cm) {
        Set<String> keys = new LinkedHashSet<>();
        if (cm == null) {
            return keys;
        }
        for (AbstractThreatType tt : cm.getMitigates()) {
            String id = tt.getId();
            keys.add(id != null && !id.isEmpty() ? id : "type#" + System.identityHashCode(tt));
        }
        for (String id : cm.getMitigatedThreatTypeID()) {
            if (id != null && !id.isEmpty()) {
                keys.add(id);
            }
        }
        return keys;
    }

    private String threatTypeLabel(AbstractThreatType tt) {
        if (tt.getTitle() != null && !tt.getTitle().isEmpty()) {
            return tt.getTitle();
        }
        return tt.getName() != null ? tt.getName() : "";
    }
}
