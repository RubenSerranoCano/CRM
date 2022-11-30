package com.rubensc.crm.persistence.repository.appuser;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.service.appuser.AppUserService;
import org.springframework.http.ResponseEntity;

public class AppUserServiceImpl implements AppUserService {

    @Override
    public ResponseEntity<AppUser> login(String email, String rawPassword) {
        return null;
    }
}
