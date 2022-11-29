package com.rubensc.crm.presentation.client;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(path = "/clients")
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping(path = "/client")
    public Client getClientById(@RequestParam Long clientId) {
        return clientService.getClientById(clientId);
    }

    @PostMapping(path = "/client")
    public Client addClient(@RequestBody Client newClient) {
        return clientService.createClient(newClient);
    }

    @PutMapping(path = "/client")
    public Client updateClient(@RequestParam Long clientId, @RequestBody Client updatedClient) {
        return clientService.updateClient(clientId, updatedClient);
    }

    @PutMapping(path = "/cancelClient")
    public Client cancelClient(@RequestParam Long clientId) {
        return clientService.cancelClientById(clientId);
    }
}
