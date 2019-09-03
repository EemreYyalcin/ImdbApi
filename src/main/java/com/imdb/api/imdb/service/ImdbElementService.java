package com.imdb.api.imdb.service;

import com.imdb.api.imdb.model.entity.ImdbElementEntity;
import com.imdb.api.imdb.repository.ImdbElementJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImdbElementService {

    private final ImdbElementJpaRepository imdbElementJpaRepository;

    public Optional<ImdbElementEntity> getImdbElementByImdbId(String imdbId) {
        return imdbElementJpaRepository.findByImdbIDEquals(imdbId);
    }

    public Optional<ImdbElementEntity> getImdbElementByTitle(String title) {
        return imdbElementJpaRepository.findByTitleEquals(title);
    }

    public void saveElement(ImdbElementEntity imdbElementEntity) {
        imdbElementJpaRepository.save(imdbElementEntity);
    }

    public void saveAsync(ImdbElementEntity imdbElementEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                imdbElementJpaRepository.save(imdbElementEntity);
            }
        }).start();
    }

}
