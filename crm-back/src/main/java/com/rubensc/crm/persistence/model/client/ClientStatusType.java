package com.rubensc.crm.persistence.model.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.rubensc.crm.persistence.model.opportunity.OpportunityStatusType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public enum ClientStatusType {
    POTENTIAL,
    CURRENT,
    CANCELLED;

    @JsonCreator
    public static ClientStatusType fromText(String text) {
        for (ClientStatusType e : ClientStatusType.values()) {
            if (String.valueOf(e.name()).equals(text)) {
                return e;
            }
        }
        return null;
    }
}
