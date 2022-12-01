package com.rubensc.crm.service.appuser;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.persistence.repository.appuser.AppUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<AppUser> login(String email, String rawPassword) {
        Optional<AppUser> optionalAppUser = appUserRepository.findByEmail(email);

        if (optionalAppUser.isPresent()) {
            AppUser appUser = optionalAppUser.get();

            if (passwordEncoder.matches(rawPassword, appUser.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body(appUser);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            }

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<AppUser> signup(String email, String rawPassword) {
        Optional<AppUser> existingUser = appUserRepository.findByEmail(email);

        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(rawPassword)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (existingUser.isPresent()) {
            AppUser sentUser = existingUser.get();
            sentUser.setPassword("");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sentUser);
        }

        AppUser newAppUser = new AppUser();
        newAppUser.setEmail(email);
        newAppUser.setPassword(passwordEncoder.encode(rawPassword));

        appUserRepository.save(newAppUser);

        return ResponseEntity.status(HttpStatus.OK).body(newAppUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AppUser getAppUserById(Long userId) {
        return appUserRepository.findById(userId).orElse(null);
    }
}
