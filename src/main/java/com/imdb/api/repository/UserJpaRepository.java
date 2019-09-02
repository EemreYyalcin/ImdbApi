package com.imdb.api.repository;

import com.imdb.api.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

}
