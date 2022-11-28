package com.rubensc.crm.persistence.repository.client;

import com.rubensc.crm.persistence.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
