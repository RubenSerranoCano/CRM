package com.rubensc.crm.service.client;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.repository.client.ClientRepository;
import com.rubensc.crm.service.client.exceptions.ClientMissingStatusException;
import com.rubensc.crm.service.client.exceptions.ClientMissingTinException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client addClient(Client newClient) {

        if (newClient.getStatusType() == null)
            throw new ClientMissingStatusException();

        if (newClient.getTin() == null)
            throw new ClientMissingTinException();

        return clientRepository.save(newClient);
    }
}
