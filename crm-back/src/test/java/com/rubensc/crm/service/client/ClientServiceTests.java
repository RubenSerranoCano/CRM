package com.rubensc.crm.service.client;


import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.client.ClientStatusType;
import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.persistence.model.opportunity.OpportunityStatusType;
import com.rubensc.crm.persistence.model.plannedaction.ActionType;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import com.rubensc.crm.persistence.model.plannedaction.PlannedActionStatusType;
import com.rubensc.crm.persistence.model.user.AppUser;
import com.rubensc.crm.persistence.repository.client.ClientRepository;
import com.rubensc.crm.persistence.repository.opportunity.OpportunityRepository;
import com.rubensc.crm.persistence.repository.user.AppUserRepository;
import com.rubensc.crm.service.client.exception.*;
import com.rubensc.crm.service.opportunity.OpportunityService;
import com.rubensc.crm.service.plannedaction.PlannedActionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ClientServiceTests {

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

    PlannedAction mockupPlannedAction;
    Client mockupClient;
    Opportunity mockupOpportunity;
    AppUser mockupUser;

    @BeforeEach
    void beforeEach() {
        mockupClient = new Client();
        mockupClient.setTin("948790779");
        mockupClient.setName("MockupBusinessName");
        mockupClient.setPhoneNumber("123123123");
        mockupClient.setEmail("mockupClient@email.com");
        mockupClient.setAddress("mockupClientAddress");

        mockupClient.setStatusType(ClientStatusType.CURRENT);
//        clientRepository.save(mockupClient);
    }

    @AfterEach
    void afterEach() {
//        opportunityRepository.delete(mockupOpportunity);
//        clientRepository.delete(mockupClient);
    }

    @Test
    void newClientMustContainTin() {
        mockupClient.setTin(null);
        Assertions.assertThrows(ClientMissingTinException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }

    @Test
    void newClientMustContainName() {
        clientRepository.save(mockupClient);
        mockupClient.setName(null);

        Assertions.assertThrows(ClientMissingNameException.class, () -> {
            clientService.createClient(mockupClient);
        });
        clientRepository.delete(mockupClient);
    }

    @Test
    void newClientMustContainEmail() {
        mockupClient.setEmail(null);

        Assertions.assertThrows(ClientMissingEmailException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }

    @Test
    void newClientMustContainStatus() {
        mockupClient.setStatusType(null);

        Assertions.assertThrows(ClientMissingStatusException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }

    @Test
    void newClientMustContainAtLestOneOpportunity() {
        mockupClient.setOpportunityList(null);

        Assertions.assertThrows(ClientMissingOpportunityException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }

    /**
     * Test whether planned actions can be retrieved from the user or not.
     */
    @Test
    void retrievePlannedActionsFromClient() {
        clientRepository.save(mockupClient);

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
