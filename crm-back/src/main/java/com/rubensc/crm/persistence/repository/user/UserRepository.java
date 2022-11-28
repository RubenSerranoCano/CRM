package com.rubensc.crm.persistence.repository.user;

import com.rubensc.crm.persistence.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
