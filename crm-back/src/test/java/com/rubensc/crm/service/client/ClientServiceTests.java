package com.rubensc.crm.service.client;


import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.client.ClientStatusType;
import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.persistence.repository.client.ClientRepository;
import com.rubensc.crm.persistence.repository.opportunity.OpportunityRepository;
import com.rubensc.crm.persistence.repository.appuser.AppUserRepository;
import com.rubensc.crm.service.client.exception.*;
import com.rubensc.crm.service.opportunity.OpportunityService;
import com.rubensc.crm.service.plannedaction.PlannedActionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    }

    /**
     * A client without a TIN should throw a custom exception to be handled
     * by the controller advice in order to return a response body and status
     * that's meaningful.
     */
    @Test
    void newClientMustContainTin() {
        mockupClient.setTin(null);
        Assertions.assertThrows(ClientMissingTinException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }

    /**
     * A client without a name should throw a custom exception to be handled
     * by the controller advice in order to return a response body and status
     * that's meaningful.
     */
    @Test
    void newClientMustContainName() {
        clientRepository.save(mockupClient);
        mockupClient.setName(null);

        Assertions.assertThrows(ClientMissingNameException.class, () -> {
            clientService.createClient(mockupClient);
        });
        clientRepository.delete(mockupClient);
    }

    /**
     * A client without a email should throw a custom exception to be handled
     * by the controller advice in order to return a response body and status
     * that's meaningful.
     */
    @Test
    void newClientMustContainEmail() {
        mockupClient.setEmail(null);

        Assertions.assertThrows(ClientMissingEmailException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }

    /**
     * A client without a status should throw a custom exception to be handled
     * by the controller advice in order to return a response body and status
     * that's meaningful.
     */
    @Test
    void newClientMustContainStatus() {
        mockupClient.setStatusType(null);

        Assertions.assertThrows(ClientMissingStatusException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }

    /**
     * A client without at least one opportunity should throw a custom exception to be handled
     * by the controller advice in order to return a response body and status
     * that's meaningful.
     */
    @Test
    void newClientMustContainAtLestOneOpportunity() {
        mockupClient.setOpportunityList(null);

        Assertions.assertThrows(ClientMissingOpportunityException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }
}
