package com.rubensc.crm.service.appuser;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.persistence.repository.appuser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public ResponseEntity<AppUser> login(String email, String rawPassword) {
        Optional<AppUser> optionalAppUser = appUserRepository.findByEmail(email);

        if (optionalAppUser.isPresent()) {
            AppUser appUser = optionalAppUser.get();

            if (appUser.getPassword().equals(rawPassword)) {
                return ResponseEntity.status(HttpStatus.OK).body(appUser);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            }

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @Override
    public ResponseEntity<AppUser> signup(String email, String rawPassword) {
        return null;
    }
}
