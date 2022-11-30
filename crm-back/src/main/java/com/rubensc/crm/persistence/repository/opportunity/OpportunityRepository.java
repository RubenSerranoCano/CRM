package com.rubensc.crm.persistence.repository.opportunity;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    Optional<List<Opportunity>> findAllByUser(AppUser user);


}
