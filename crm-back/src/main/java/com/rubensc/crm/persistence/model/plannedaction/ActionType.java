package com.rubensc.crm.persistence.model.plannedaction;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ActionType {
    EMAIL,
    PHONE_CALL,
    SALES_VISIT,
    MEETING,
    ONLINE_MEETING;

    @JsonCreator
    public static ActionType fromText(String text) {
        for (ActionType e : ActionType.values()) {
            if (String.valueOf(e.name()).equals(text)) {
                return e;
            }
        }
        return null;
    }
}
