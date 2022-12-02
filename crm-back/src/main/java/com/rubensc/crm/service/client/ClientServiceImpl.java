package com.rubensc.crm.service.client;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.client.ClientStatusType;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import com.rubensc.crm.persistence.repository.client.ClientRepository;
import com.rubensc.crm.service.client.exception.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Client createClient(Client newClient) {

        validateNewClient(newClient);

        return clientRepository.save(newClient);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Client updateClient(Long clientId, Client updatedClient) {
        Optional<Client> optionalPreviousClient = clientRepository.findById(clientId);
        Client previousClient = null;

        if (optionalPreviousClient.isPresent()) {
            previousClient = updatedClient;
            return clientRepository.save(previousClient);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Client cancelClientById(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            optionalClient.get().setStatusType(ClientStatusType.CANCELLED);
            return optionalClient.get();
        } else {
            throw new IllegalArgumentException("Missing client's id.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PlannedAction> getClientPlannedActions(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            System.out.println("method "+client.getPlannedActionList());
            return client.getPlannedActionList();
        } else {
            throw new IllegalArgumentException("Missing client's id.");
        }
    }

    private void validateNewClient(Client newClient) {
        if (StringUtils.isEmpty(newClient.getTin()))
            throw new ClientMissingTinException();

        if (StringUtils.isEmpty(newClient.getName()))
            throw new ClientMissingNameException();

        if (StringUtils.isEmpty(newClient.getEmail()))
            throw new ClientMissingEmailException();

        if (newClient.getStatusType() == null)
            throw new ClientMissingStatusException();

        if (newClient.getOpportunityList() == null || newClient.getOpportunityList().isEmpty())
            throw new ClientMissingOpportunityException();
    }
}
