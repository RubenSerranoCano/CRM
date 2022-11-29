package com.rubensc.crm.service.client;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.client.ClientStatusType;
import com.rubensc.crm.persistence.repository.client.ClientRepository;
import com.rubensc.crm.service.client.exception.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client newClient) {

        validateNewClient(newClient);

        return clientRepository.save(newClient);
    }

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

    @Override
    public Client cancelClientById(Long clientId) {
        clientRepository.findById(clientId).ifPresent(client -> client.setStatusType(ClientStatusType.CANCELLED));
        return clientRepository.findById(clientId).orElseThrow(() -> {
            throw new IllegalArgumentException("Missing Id.");
        });
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
