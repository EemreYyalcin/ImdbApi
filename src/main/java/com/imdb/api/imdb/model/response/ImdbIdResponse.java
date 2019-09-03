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
public class ImdbIdResponse extends ImdbBaseResponse {

    @JsonProperty("Metascore")
    private String metascore;

    @JsonProperty("BoxOffice")
    private String boxOffice;

    @JsonProperty("Website")
    private String website;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("imdbVotes")
    private String imdbVotes;

    @JsonProperty("Ratings")
    private List<RatingsItem> ratings;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Production")
    private String production;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("DVD")
    private String dvd;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Writer")
    private String writer;
}