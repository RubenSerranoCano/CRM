package com.rubensc.crm.persistence.repository.opportunity;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
}
