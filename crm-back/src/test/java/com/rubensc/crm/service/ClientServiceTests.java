package com.rubensc.crm.service;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.client.ClientStatusType;
import com.rubensc.crm.service.client.ClientService;
import com.rubensc.crm.service.client.exceptions.ClientMissingStatusException;
import com.rubensc.crm.service.client.exceptions.ClientMissingTinException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientServiceTests {

    @Autowired
    ClientService clientService;

    Client mockupClient;

    @BeforeEach
    void init() {
        mockupClient = new Client();
        mockupClient.setTin("948790779");
        mockupClient.setName("MockupBusinessName");
        mockupClient.setPhoneNumber("123123123");
        mockupClient.setEmail("mockupClient@email.com");
        mockupClient.setAddress("mockupClientAddress");
        mockupClient.setStatusType(ClientStatusType.CURRENT);
    }

    @Test
    void newClientContainsStatus() {
       Client newClient = clientService.addClient(mockupClient);

        Assertions.assertNotNull(newClient.getStatusType());
    }

    @Test
    void newClientMustContainStatus() {
        mockupClient.setStatusType(null);

        Assertions.assertThrows(ClientMissingStatusException.class, () -> {
            clientService.addClient(mockupClient);
        });
    }

    @Test
    void newClientContainsTin() {
        Client newClient = clientService.addClient(mockupClient);

        Assertions.assertNotNull(newClient.getTin());
    }

    @Test
    void newClientMustContainTin() {
        mockupClient.setTin(null);
        Client newClient = clientService.addClient(mockupClient);

        Assertions.assertThrows(ClientMissingTinException.class, () -> {
            clientService.addClient(mockupClient);
        });
    }
}
