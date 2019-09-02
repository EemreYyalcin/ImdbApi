package com.imdb.api.imdb.service;

import com.imdb.api.imdb.model.entity.ImdbElementEntity;
import com.imdb.api.imdb.repository.ImdbElementJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImdbElementService {

    private final ImdbElementJpaRepository imdbElementJpaRepository;

    public List<ImdbElementEntity> getImdbElementByImdbId(String imdbId) {
        return imdbElementJpaRepository.findByImdbIDEquals(imdbId);
    }

    public List<ImdbElementEntity> getImdbElementByTitle(String title) {
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
