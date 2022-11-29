package com.rubensc.crm.service;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.client.ClientStatusType;
import com.rubensc.crm.persistence.repository.client.ClientRepository;
import com.rubensc.crm.service.client.ClientService;
import com.rubensc.crm.service.client.exception.*;
import org.junit.jupiter.api.AfterEach;
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

    Client mockupClient;

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

    @AfterEach
    void afterEach() {
        clientRepository.deleteAll();
    }

    @Test
    void newClientMustContainTin() {
        mockupClient.setTin(null);
        Assertions.assertThrows(ClientMissingTinException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }

    @Test
    void newClientMustContainName(){
        mockupClient.setName(null);

        Assertions.assertThrows(ClientMissingNameException.class, () -> {
           clientService.createClient(mockupClient);
        });
    }

    @Test
    void newClientMustContainEmail(){
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
    void newClientMustContainAtLestOneOpportunity(){
        mockupClient.setOpportunityList(null);

        Assertions.assertThrows(ClientMissingOpportunityException.class, () -> {
            clientService.createClient(mockupClient);
        });
    }
}
