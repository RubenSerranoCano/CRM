package com.rubensc.crm.persistence.model.plannedAction;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PlannedActionStatusType {
    DUE,
    COMPLETED,
    MISSED,
    CANCELLED;

    @JsonCreator
    public static PlannedActionStatusType fromText(String text) {
        for (PlannedActionStatusType e : PlannedActionStatusType.values()) {
            if (String.valueOf(e.name()).equals(text)) {
                return e;
            }
        }
        return null;
    }

}
