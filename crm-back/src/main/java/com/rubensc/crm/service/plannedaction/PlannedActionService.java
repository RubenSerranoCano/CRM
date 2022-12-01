package com.rubensc.crm.service.plannedaction;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;

import java.util.List;

public interface PlannedActionService {

    /**
     * Retrieves a planned action by its id.
     * @param plannedActionId the id of the planned action to be retrieved.
     * @return the planned action found.
     *
     * @author Rubén Serrano Cano.
     */
    PlannedAction getPlannedActionById(Long plannedActionId);

    /**
     * Retrieves all the planned actions stored in the system.
     * @return a list of planned actions.
     *
     * @author Rubén Serrano Cano.
     */
    List<PlannedAction> getAllPlannedActions();

    /**
     * Stores a new planned action in the system.
     * @param newPlannedAction the new planned action.
     * @return the created planned action.
     *
     * @author Rubén Serrano Cano.
     */
    PlannedAction createPlannedAction(PlannedAction newPlannedAction);

    /**
     * Updates a planned action.
     * @param plannedActionId the id of the planned action to be updated.
     * @param updatedPlannedAction the updated planned action.
     * @return the updated planned action.
     *
     * @author Rubén Serrano Cano.
     */
    PlannedAction updatePlannedAction(Long plannedActionId, PlannedAction updatedPlannedAction);

    /**
     * Retrieves a planned action list of a client.
     * @param clientId the id of the client containing the planned actions.
     * @return the planned actions of a client.
     *
     * @author Rubén Serrano Cano.
     */
    List<PlannedAction> getPlannedActionsByClientId(Long clientId);

}
