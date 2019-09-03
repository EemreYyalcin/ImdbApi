package com.imdb.api.imdb.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImdbSearchResponse extends ImdbBaseResponse {

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Search")
    private List<SearchItem> search;
}