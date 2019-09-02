package com.imdb.api.imdb.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ImdbSearchResponse extends ImdbBaseResponse{

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Search")
    private List<SearchItem> search;
}