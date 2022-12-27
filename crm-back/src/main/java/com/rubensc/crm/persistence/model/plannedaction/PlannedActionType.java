package com.rubensc.crm.persistence.model.plannedaction;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PlannedActionType {
    EMAIL,
    PHONE_CALL,
    SALES_VISIT,
    MEETING,
    ONLINE_MEETING;

    @JsonCreator
    public static PlannedActionType fromText(String text) {
        for (PlannedActionType e : PlannedActionType.values()) {
            if (String.valueOf(e.name()).equals(text)) {
                return e;
            }
        }
        return null;
    }
}
