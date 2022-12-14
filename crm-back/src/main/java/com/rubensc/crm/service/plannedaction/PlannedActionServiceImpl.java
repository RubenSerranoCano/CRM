package com.rubensc.crm.service.plannedaction;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.persistence.model.opportunity.OpportunityStatusType;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import com.rubensc.crm.persistence.model.plannedaction.PlannedActionStatusType;
import com.rubensc.crm.persistence.repository.plannedaction.PlannedActionRepository;
import com.rubensc.crm.service.appuser.AppUserService;
import com.rubensc.crm.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlannedActionServiceImpl implements PlannedActionService {

    @Autowired
    PlannedActionRepository plannedActionRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    AppUserService appUserService;

    /**
     * {@inheritDoc}
     */
    @Override
    public PlannedAction getPlannedActionById(Long plannedActionId) {
        return plannedActionRepository.findById(plannedActionId).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PlannedAction> getAllPlannedActions() {
        return plannedActionRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlannedAction createPlannedAction(PlannedAction newPlannedAction) {
        return plannedActionRepository.save(newPlannedAction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlannedAction updatePlannedAction(Long plannedActionId, PlannedAction updatedPlannedAction) {
        Optional<PlannedAction> optionalPreviousPlannedAction = plannedActionRepository.findById(plannedActionId);
        PlannedAction previousPlannedAction = null;

        if (optionalPreviousPlannedAction.isPresent()) {
            previousPlannedAction = updatedPlannedAction;
            return plannedActionRepository.save(previousPlannedAction);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PlannedAction> getPlannedActionsByClientId(Long clientId) {
        return clientService.getClientById(clientId).getPlannedActionList();
    }
}
