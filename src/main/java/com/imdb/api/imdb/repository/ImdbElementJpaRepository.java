package com.imdb.api.imdb.repository;

import com.imdb.api.imdb.model.entity.ImdbElementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImdbElementJpaRepository extends CrudRepository<ImdbElementEntity, Long> {

    Optional<ImdbElementEntity> findByImdbIDEquals(String imdbId);

    Optional<ImdbElementEntity> findByTitleEquals(String title);

}
