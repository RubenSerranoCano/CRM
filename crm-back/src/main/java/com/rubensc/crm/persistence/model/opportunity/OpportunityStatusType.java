package com.rubensc.crm.persistence.model.opportunity;

import com.fasterxml.jackson.annotation.JsonCreator;


public enum OpportunityStatusType {
    IN_PROGRESS,
    DONE,
    DISCARDED;

    @JsonCreator
    public static OpportunityStatusType fromText(String text) {
        for (OpportunityStatusType e : OpportunityStatusType.values()) {
            if (String.valueOf(e.name()).equals(text)) {
                return e;
            }
        }
        return null;
    }

}
