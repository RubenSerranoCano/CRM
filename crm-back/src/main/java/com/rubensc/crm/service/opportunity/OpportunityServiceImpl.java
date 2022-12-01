package com.rubensc.crm.service.opportunity;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.client.ClientStatusType;
import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.persistence.model.opportunity.OpportunityStatusType;
import com.rubensc.crm.persistence.repository.opportunity.OpportunityRepository;
import com.rubensc.crm.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    ClientService clientService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity getOpportunityById(Long opportunityId) {
        return opportunityRepository.findById(opportunityId).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity createOpportunity(Opportunity newOpportunity) {
        return opportunityRepository.save(newOpportunity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity updateOpportunity(Long opportunityId, Opportunity updatedOpportunity) {
        Optional<Opportunity> optionalPreviousOpportunity = opportunityRepository.findById(opportunityId);
        Opportunity previousOpportunity = null;

        if (optionalPreviousOpportunity.isPresent()) {
            previousOpportunity = updatedOpportunity;
            return opportunityRepository.save(previousOpportunity);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity discardOpportunity(Long opportunityId) {
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunityId);

        if (optionalOpportunity.isPresent()) {
            Opportunity opportunity = optionalOpportunity.get();
            Client client = opportunity.getClient();

            if (client.getOpportunityList().size() == 1) {
                client.setStatusType(ClientStatusType.CANCELLED);
            }
            opportunity.setStatusType(OpportunityStatusType.DISCARDED);

            return opportunity;
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Opportunity> getOpportunitiesByClientId(Long clientId) {
        return clientService.getClientById(clientId).getOpportunityList();
    }

}
