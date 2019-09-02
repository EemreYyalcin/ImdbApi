package com.imdb.api.imdb.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchItem {

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Title")
    private String title;
}