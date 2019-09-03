package com.imdb.api.imdb.controller;

import com.imdb.api.imdb.model.dto.ImdbElementDTO;
import com.imdb.api.imdb.model.mapper.ImdbElementMapper;
import com.imdb.api.imdb.model.response.ImdbSearchResponse;
import com.imdb.api.imdb.service.ImdbClientService;
import com.imdb.api.imdb.service.ImdbElementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imdb")
@RequiredArgsConstructor
@Slf4j
public class ImdbController {

    private final ImdbClientService imdbClientService;

    @GetMapping(value = {"/search/{searchKey}", "/search/{searchKey}/{page}"})
    public ImdbSearchResponse searchMovies(@PathVariable("searchKey") String key, @PathVariable(value = "page", required = false) Integer page) {
        if (key.length() < 3) {
            return null;
        }
        if (!ObjectUtils.isEmpty(page)) {
            return imdbClientService.fetchDataBySearch(key, page);
        }
        return imdbClientService.fetchDataBySearch(key, 1);
    }

    @GetMapping(value = {"/item/{itemId}"})
    public ImdbElementDTO queryMovies(@PathVariable("itemId") String itemId) {
        return imdbClientService.fetchDataById(itemId);
    }

}
