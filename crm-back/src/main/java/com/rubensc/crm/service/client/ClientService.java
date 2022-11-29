package com.rubensc.crm.service.client;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;

import java.util.List;

public interface ClientService {

    Client getClientById(Long clientId);
    List<Client> getAllClients();
    Client createClient(Client newClient);
    Client updateClient(Long clientId, Client updatedClient);
    Client cancelClientById(Long clientId);
    List<PlannedAction> getClientPlannedActions(Long clientId);

}
