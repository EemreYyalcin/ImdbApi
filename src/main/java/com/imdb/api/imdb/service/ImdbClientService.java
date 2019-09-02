package com.imdb.api.imdb.service;

import com.imdb.api.enums.RedisConfigConstraint;
import com.imdb.api.imdb.model.response.ImdbBaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImdbClientService {

    @Value("${imdb.rest.url}")
    private String url;
    @Value("${imdb.rest.apikey}")
    private String apikey;

    @Cacheable(value = "imdb_keys", key = "#query", sync = true, cacheManager = RedisConfigConstraint.expireOneHour)
    public <T extends ImdbBaseResponse> T fetchData(String query, Class<T> clazz) {
        return new RestTemplate().getForObject(url + apikey + query, clazz);
    }

}
