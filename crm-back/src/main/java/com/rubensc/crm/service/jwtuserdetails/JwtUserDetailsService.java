package com.rubensc.crm.service.jwtuserdetails;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.service.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    @Lazy
    private AppUserService appUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.getAppUserByUsername(username);
        if (appUser != null) {
            return new User(appUser.getUsername(), appUser.getPassword(),
                    new ArrayList<>());
        } else
            throw new UsernameNotFoundException("User not found with email: " + username);

    }

}
