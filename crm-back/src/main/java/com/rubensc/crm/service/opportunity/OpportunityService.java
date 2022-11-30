package com.rubensc.crm.service.opportunity;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;

import java.util.List;

public interface OpportunityService {


    Opportunity getOpportunityById(Long opportunityId);
    List<Opportunity> getAllOpportunities();
    Opportunity createOpportunity(Opportunity newOpportunity);
    Opportunity updateOpportunity(Long oppotunityId, Opportunity updatedOpportunity);
    Opportunity discardOpportunity(Long opportunityId);

    List<Opportunity> getOpportunitiesByClientId(Long clientId);
}
