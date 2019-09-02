package com.imdb.api.config;

import com.imdb.api.model.entity.User;
import com.imdb.api.security.domain.enumeration.AuthRole;
import com.imdb.api.service.jpa.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitDataForH2 implements CommandLineRunner {

    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) {
        userService.addUser(new User()
                .setName("Emre")
                .setSurname("Yalcin")
                .setAge(27)
                .setUsername("emreyalcin")
                .setPassword(encoder.encode("emre123"))
                .setRoles(Arrays.asList(AuthRole.ROLE_ADMIN, AuthRole.ROLE_USER)));

        userService.addUser(new User()
                .setName("EmreUser")
                .setSurname("Yalcinuser")
                .setAge(27)
                .setUsername("userofemre")
                .setPassword(encoder.encode("user123"))
                .setRoles(Arrays.asList(AuthRole.ROLE_USER)));

        userService.addUser(new User()
                .setName("EmreGuest")
                .setSurname("Yalcinguest")
                .setAge(27)
                .setUsername("guestofemre")
                .setPassword(encoder.encode("guest123"))
                .setRoles(Arrays.asList(AuthRole.ROLE_GUEST)));



    }
}
