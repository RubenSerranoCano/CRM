package com.rubensc.crm.service.plannedaction;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;

import java.util.List;

public interface PlannedActionService {
    PlannedAction getPlannedActionById(Long plannedActionId);
    List<PlannedAction> getAllPlannedActions(Long userId);
    PlannedAction createPlannedAction(Long userId, PlannedAction newPlannedAction);
    PlannedAction updatePlannedAction(Long plannedActionId, PlannedAction updatedPlannedAction);
    PlannedAction discardPlannedAction(Long plannedActionId);
    List<PlannedAction> getPlannedActionsByClientId(Long clientId);

}
