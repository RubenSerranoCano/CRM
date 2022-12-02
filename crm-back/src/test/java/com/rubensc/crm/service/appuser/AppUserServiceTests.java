package com.rubensc.crm.service.appuser;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class AppUserServiceTests {

    @Autowired
    AppUserService appUserService;

    /**
     * Given a user trying to login,
     * make sure it gets a response.
     */
    @Test
    void userGetsLoginResponse() {
        Assertions.assertNotNull(appUserService.login("test@email.com", "X5#$Y3hRzkH1"));
    }

    @Test
    void signupEncodesPassword() {
        String rawPassword = "X5#$Y3hRzkH1";
        AppUser appUserResponse = appUserService.signup("test@email.com", rawPassword).getBody();

        Assertions.assertNotEquals(rawPassword, appUserResponse.getPassword());
    }

}
