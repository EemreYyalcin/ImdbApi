package com.imdb.api.security.service;

import com.imdb.api.model.entity.User;
import com.imdb.api.service.jpa.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), userService.getRoles(user));
    }

}