package com.imdb.api.imdb.repository;

import com.imdb.api.imdb.model.entity.ImdbElementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImdbElementJpaRepository extends CrudRepository<ImdbElementEntity, Long> {

    List<ImdbElementEntity> findByImdbIDEquals(String imdbId);

    List<ImdbElementEntity> findByTitleEquals(String title);

}
