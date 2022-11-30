package com.rubensc.crm.service.opportunity;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;
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

    @Override
    public Opportunity getOpportunityById(Long opportunityId) {
        return opportunityRepository.findById(opportunityId).orElse(null);
    }

    @Override
    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    @Override
    public Opportunity createOpportunity(Opportunity newOpportunity) {
        return opportunityRepository.save(newOpportunity);
    }

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

    @Override
    public Opportunity discardOpportunity(Long opportunityId) {
        return null;
    }

    @Override
    public List<Opportunity> getOpportunitiesByClientId(Long clientId) {
        return clientService.getClientById(clientId).getOpportunityList();
    }

}
