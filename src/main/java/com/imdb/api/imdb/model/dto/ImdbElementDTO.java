package com.imdb.api.imdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ImdbElementDTO {

    private String imdbID;

    private String title;

    private String boxOffice;

    private String imdbRating;

    private String imdbVotes;

    private String language;

    private String released;

    private String director;

    private String type;

    private String year;

    private String poster;

}
