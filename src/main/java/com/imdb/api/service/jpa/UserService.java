package com.imdb.api.service.jpa;

import com.imdb.api.model.entity.UserEntity;
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

    public Optional<UserEntity> findUserByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }

    public List<SimpleGrantedAuthority> getRoles(UserEntity userEntity) {
        if (userEntity == null || userEntity.getRoles() == null) {
            return new ArrayList<SimpleGrantedAuthority>() {{
                add(new SimpleGrantedAuthority(AuthRole.ROLE_GUEST.name()));
            }};
        }
        return userEntity.getRoles().stream()
                .map(AuthRole::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public List<UserEntity> getAllUser() {
        List<UserEntity> userEntities = new ArrayList<>();
        userJpaRepository.findAll().iterator().forEachRemaining(userEntities::add);
        return userEntities;
    }

    public UserEntity addUser(UserEntity userEntity) {
        return userJpaRepository.save(userEntity);
    }

}
