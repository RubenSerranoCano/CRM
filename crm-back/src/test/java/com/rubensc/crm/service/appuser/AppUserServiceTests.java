package com.rubensc.crm.service.appuser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
