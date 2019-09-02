package com.imdb.api.imdb.controller;

import com.imdb.api.imdb.model.response.ImdbIdResponse;
import com.imdb.api.imdb.model.response.ImdbSearchResponse;
import com.imdb.api.imdb.service.ImdbClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imdb")
@RequiredArgsConstructor
public class ImdbController {

    private final ImdbClientService imdbClientService;

    @GetMapping(value = {"/search/{searchKey}", "/search/{searchKey}/{page}"})
    public ImdbSearchResponse searchMovies(@PathVariable("searchKey") String key, @PathVariable(value = "page", required = false) Integer page) {
        if (key.length() < 3) {
            return null;
        }
        if (!ObjectUtils.isEmpty(page)) {
            return imdbClientService.fetchData("&s=" + key + "&page=" + page, ImdbSearchResponse.class);
        }
        return imdbClientService.fetchData("&s=" + key, ImdbSearchResponse.class);
    }

    @GetMapping(value = {"/item/{itemId}"})
    public ImdbIdResponse searchMovies(@PathVariable("itemId") String itemId) {
        return imdbClientService.fetchData("&i=" + itemId, ImdbIdResponse.class);
    }
    
}
