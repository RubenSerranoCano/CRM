package com.rubensc.crm.presentation;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping(path = "/client")
    public Client addClient(Client newClient) {
        return clientService.addClient(newClient);
    }
}
