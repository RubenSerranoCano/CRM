package com.rubensc.crm.service.opportunity;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;

import java.util.List;

public interface OpportunityService {


    /**
     * Retrieve an opportunity by its id.
     * @param opportunityId the opportunity's id
     * @return the found opportunity.
     *
     * @author Rubén Serrano Cano
     */
    Opportunity getOpportunityById(Long opportunityId);

    /**
     * Retrieves all the opportunities stored in the
     * system.
     * @return al the opportunities stored in the system.
     *
     * @author Rubén Serrano Cano
     */
    List<Opportunity> getAllOpportunities();

    /**
     * Stores a new opportunity in the system.
     * @param newOpportunity the opportunity to be stored.
     * @return the created opportunity.
     *
     * @author Rubén Serrano Cano
     */
    Opportunity createOpportunity(Opportunity newOpportunity);

    /**
     * Updates the given opportunity.
     * @param oppotunityId the id of the opportunity to be updated.
     * @param updatedOpportunity the updated opportunity.
     * @return the updated opportunity.
     */
    Opportunity updateOpportunity(Long oppotunityId, Opportunity updatedOpportunity);

    /**
     * Sets the opportunity status as discarded.
     * @param opportunityId the opportunity's id.
     * @return the discarded opportunity.
     *
     * @author Rubén Serrano Cano
     */
    Opportunity discardOpportunity(Long opportunityId);

    /**
     * Retrieves a client's list of opportunities.
     * @param clientId the client's whose list will be retrieved.
     * @return a list of opportunities.
     *
     * @author Rubén Serrano Cano
     */
    List<Opportunity> getOpportunitiesByClientId(Long clientId);
}
