package com.rubensc.crm.service.client;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;

import java.util.List;

public interface ClientService {

    /**
     * Retrieves a client by its id.
     * @param clientId the client's id.
     * @return the found client.
     *
     * @author Rubén Serrano Cano
     */
    Client getClientById(Long clientId);

    /**
     * Retrieves all the existing clients.
     * @return the existing clients.
     *
     * @author Rubén Serrano Cano
     */
    List<Client> getAllClients();

    /**
     * Stores a new client in the system.
     * @param newClient the client to be stored.
     * @return the created client.
     *
     * @author Rubén Serrano Cano
     */
    Client createClient(Client newClient);

    /**
     * Updates an existing client.
     * @param clientId the client to be updated.
     * @param updatedClient the updated client.
     * @return the updated client.
     *
     * @author Rubén Serrano Cano
     */
    Client updateClient(Long clientId, Client updatedClient);

    /**
     * Sets a client's status as cancelled.
     * @param clientId the id of the client to be cancelled.
     * @return the cancelled client.
     *
     * @author Rubén Serrano Cano
     */
    Client cancelClientById(Long clientId);

    /**
     * Retrieves all the planned actions of a client.
     * @param clientId the id of the client containing the planned actions.
     * @return a list of planned actions.
     *
     * @author Rubén Serrano Cano
     */
    List<PlannedAction> getClientPlannedActions(Long clientId);

}
