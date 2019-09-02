package com.imdb.api.imdb.service;

import com.imdb.api.enums.RedisConfigConstraint;
import com.imdb.api.imdb.model.mapper.ImdbElementMapper;
import com.imdb.api.imdb.model.response.ImdbBaseResponse;
import com.imdb.api.imdb.model.response.ImdbIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ImdbClientService {

    @Value("${imdb.rest.url}")
    private String url;
    @Value("${imdb.rest.apikey}")
    private String apikey;
    private final ImdbElementService imdbElementService;
    private final ImdbElementMapper imdbElementMapper;


    @Cacheable(value = "imdb_keys", key = "#query", sync = true, cacheManager = RedisConfigConstraint.expireConfigure)
    public <T extends ImdbBaseResponse> T fetchData(String query, Class<T> clazz) {
        T imdbBaseResponse = new RestTemplate().getForObject(url + apikey + query, clazz);
        if (imdbBaseResponse instanceof ImdbIdResponse) {
            imdbElementService.saveAsync(imdbElementMapper.imdbIdResponseToImdbElementEntity((ImdbIdResponse) imdbBaseResponse));
        }
        return imdbBaseResponse;
    }
}
