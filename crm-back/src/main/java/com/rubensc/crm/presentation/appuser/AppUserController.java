package com.rubensc.crm.presentation.appuser;

import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.service.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping("/login")
    ResponseEntity<AppUser> login(@RequestBody AppUser userDto) {
        return appUserService.login(userDto.getEmail(), userDto.getPassword());
    }

    @PostMapping("/signup")
    ResponseEntity<AppUser> signup(@RequestBody AppUser userDto) {
        return appUserService.signup(userDto.getEmail(), userDto.getPassword());
    }

}
