package com.imdb.api.service.jpa;

import com.imdb.api.model.entity.User;
import com.imdb.api.repository.jpa.UserJpaRepository;
import com.imdb.api.security.domain.enumeration.AuthRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public Optional<User> findUserByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }

    public List<SimpleGrantedAuthority> getRoles(User user) {
        if (user == null || user.getRoles() == null) {
            return new ArrayList<SimpleGrantedAuthority>() {{
                add(new SimpleGrantedAuthority(AuthRole.ROLE_GUEST.name()));
            }};
        }
        return user.getRoles().stream()
                .map(AuthRole::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        userJpaRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    public User addUser(User user) {
        return userJpaRepository.save(user);
    }

}
