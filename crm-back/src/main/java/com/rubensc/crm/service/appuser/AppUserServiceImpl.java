package com.rubensc.crm.service.appuser;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService{
    @Override
    public ResponseEntity<AppUser> login(String email, String rawPassword) {
        return null;
    }
}
