package com.rubensc.crm.service.opportunity;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.persistence.repository.opportunity.OpportunityRepository;
import com.rubensc.crm.service.opportunity.OpportunityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpportunityServiceTests {

    @Autowired
    OpportunityService opportunityService;

    @Autowired
    OpportunityRepository opportunityRepository;

    Opportunity mockupOpportunity;

    @BeforeEach
    void baforeEach() {
//        mockupOpportunity = new Opportunity();
//        mockupOpportunity.setName("MockupOpportunity");
    }

}
