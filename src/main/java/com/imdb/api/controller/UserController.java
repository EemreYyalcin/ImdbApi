package com.imdb.api.controller;

import com.imdb.api.model.entity.UserEntity;
import com.imdb.api.service.jpa.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    @Secured("ROLE_USER")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUser();
    }


}
