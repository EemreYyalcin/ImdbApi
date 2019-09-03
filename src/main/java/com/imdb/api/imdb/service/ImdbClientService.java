package com.imdb.api.imdb.service;

import com.imdb.api.enums.RedisConfigConstraint;
import com.imdb.api.imdb.model.dto.ImdbElementDTO;
import com.imdb.api.imdb.model.entity.ImdbElementEntity;
import com.imdb.api.imdb.model.mapper.ImdbElementMapper;
import com.imdb.api.imdb.model.response.ImdbIdResponse;
import com.imdb.api.imdb.model.response.ImdbSearchResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImdbClientService {

    @Value("${imdb.rest.url}")
    private String url;
    @Value("${imdb.rest.apikey}")
    private String apikey;
    private final ImdbElementService imdbElementService;
    private final ImdbElementMapper imdbElementMapper;


    @Cacheable(value = "imdb_items", key = "#imdbId", sync = true, cacheManager = RedisConfigConstraint.expireConfigure)
    public ImdbElementDTO fetchDataById(String imdbId) {
        Optional<ImdbElementEntity> imdbElementEntityOptional = imdbElementService.getImdbElementByImdbId(imdbId);
        if (imdbElementEntityOptional.isPresent()) {
            log.info("Fetching DB");
            return imdbElementMapper.imdbElementEntityToImdbElementDTO(imdbElementEntityOptional.get());
        }
        log.info("Fetching Rest IMDB");
        ImdbIdResponse imdbIdResponse = new RestTemplate().getForObject(url + apikey + "&i=" + imdbId, ImdbIdResponse.class);
        imdbElementService.saveAsync(imdbElementMapper.imdbIdResponseToImdbElementEntity(imdbIdResponse));
        return imdbElementMapper.imdbIdResponseToImdbElementDTO(imdbIdResponse);
    }

    @Cacheable(value = "imdb_search", key = "#searchKey + '_' + #page", sync = true, cacheManager = RedisConfigConstraint.expireConfigure)
    public ImdbSearchResponse fetchDataBySearch(String searchKey, Integer page) {
        log.info("Fetching Rest IMDB");
        return new RestTemplate().getForObject(url + apikey + "&s=" + searchKey + "&page=" + page, ImdbSearchResponse.class);
    }

}
