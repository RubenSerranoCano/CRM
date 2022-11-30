package com.rubensc.crm.service.plannedaction;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.client.ClientStatusType;
import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.persistence.model.opportunity.OpportunityStatusType;
import com.rubensc.crm.persistence.model.plannedaction.ActionType;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import com.rubensc.crm.persistence.model.plannedaction.PlannedActionStatusType;
import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.persistence.repository.client.ClientRepository;
import com.rubensc.crm.persistence.repository.opportunity.OpportunityRepository;
import com.rubensc.crm.persistence.repository.appuser.AppUserRepository;
import com.rubensc.crm.service.client.ClientService;
import com.rubensc.crm.service.opportunity.OpportunityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PlannedActionServiceTests {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OpportunityService opportunityService;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    PlannedActionService plannedActionService;

    @Autowired
    AppUserRepository appUserRepository;

    Client mockupClient;

    Opportunity mockupOpportunity;

    @BeforeEach
    void beforeEach() {
        mockupClient = new Client();
        mockupClient.setTin("948790779");
        mockupClient.setName("MockupBusinessName");
        mockupClient.setPhoneNumber("123123123");
        mockupClient.setEmail("mockupClient@email.com");
        mockupClient.setAddress("mockupClientAddress");

        mockupClient.setStatusType(ClientStatusType.CURRENT);
        clientRepository.save(mockupClient);
    }

    /**
     * Test whether planned actions can be retrieved from a client or not.
     */
    @Test
    void retrievePlannedActionsFromClient() {

        AppUser user = new AppUser();
        user.setEmail("email@example.com");
        user.setPassword("password");

        PlannedAction plannedAction = new PlannedAction();
        plannedAction.setActionType(ActionType.EMAIL);
        plannedAction.setStatusType(PlannedActionStatusType.DUE);
        plannedAction.setCreationDateTime(LocalDateTime.of(2022, 11, 30, 0, 0));
        plannedAction.setClient(mockupClient);

        List<PlannedAction> plannedActionList = new ArrayList<>();
        plannedActionList.add(plannedAction);

        mockupOpportunity = new Opportunity();
        mockupOpportunity.setName("OpportunityName");
        mockupOpportunity.setClient(mockupClient);
        mockupOpportunity.setPlannedActionList(plannedActionList);
        mockupOpportunity.setStatusType(OpportunityStatusType.IN_PROGRESS);
        mockupOpportunity.setCreationDateTime(LocalDateTime.of(2022, 11, 30, 0, 0));
        mockupOpportunity.setUser(user);
        mockupClient.setPlannedActionList(plannedActionList);
        List<Opportunity> opportunityList = new ArrayList<>();
        opportunityList.add(mockupOpportunity);
        mockupClient.setOpportunityList(opportunityList);

        appUserRepository.save(user);
        opportunityService.createOpportunity(mockupOpportunity);
        plannedActionService.createPlannedAction(plannedAction);

        List<PlannedAction> serviceClientPlannedActions = plannedActionService.getPlannedActionsByClientId(mockupClient.getId());

        Assertions.assertEquals(mockupClient.getPlannedActionList().size(), serviceClientPlannedActions.size());
        for (int i = 0; i < mockupClient.getPlannedActionList().size(); i++) {
            Assertions.assertEquals(mockupClient.getPlannedActionList().get(i), serviceClientPlannedActions.get(i));
        }
    }

}
