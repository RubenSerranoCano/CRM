package com.rubensc.crm.service.appuser;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import org.springframework.http.ResponseEntity;

public interface AppUserService {

    ResponseEntity<AppUser> login(String email, String rawPassword);

    ResponseEntity<AppUser> signup(String email, String rawPassword);

    AppUser getAppUserById(Long userId);

}
