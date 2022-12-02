package com.rubensc.crm.service.appuser;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import org.springframework.http.ResponseEntity;

public interface AppUserService {

    /**
     * Checks if the email and password provided
     * match with the ones stored in the system.
     * @param email user's email.
     * @param rawPassword user's raw password.
     * @return a response entity with a response and the entity.
     *
     * @author Rubén Serrano Cano
     */
    ResponseEntity<AppUser> login(String email, String rawPassword);

    /**
     * Stores a user in the system with the given data.
     * @param email email to be set in the new user
     * @param rawPassword password to set in the new user once it's encoded.
     * @return a response entity with a response and the entity.
     *
     * @author Rubén Serrano Cano
     */
    ResponseEntity<AppUser> signup(String email, String rawPassword);

    /**
     * Retrieves the appUser given its id.
     * @param userId the appUser id.
     * @return the found appUser.
     *
     * @author Rubén Serrano Cano
     */
    AppUser getAppUserById(Long userId);

}
