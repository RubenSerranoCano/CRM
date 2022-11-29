package com.rubensc.crm.service.client;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.repository.client.ClientRepository;
import com.rubensc.crm.service.client.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client addClient(Client newClient) {

        validateNewClient(newClient);

        return clientRepository.save(newClient);
    }

    private void validateNewClient(Client newClient) {
        if (newClient.getTin() == null)
            throw new ClientMissingTinException();

        if (newClient.getName() == null)
            throw new ClientMissingNameException();

        if (newClient.getEmail() == null)
            throw new ClientMissingEmailException();

        if (newClient.getStatusType() == null)
            throw new ClientMissingStatusException();

        if (newClient.getOpportunityList() == null || newClient.getOpportunityList().isEmpty())
            throw new ClientMissingOpportunityException();
    }
}
