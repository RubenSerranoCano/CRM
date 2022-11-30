package com.rubensc.crm.presentation.opportunity;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.service.opportunity.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OpportunityController {

    @Autowired
    OpportunityService opportunityService;

    @GetMapping("opportunities")
    List<Opportunity> getAllUserOpportunities() {
       return opportunityService.getAllOpportunities();
    }

}
