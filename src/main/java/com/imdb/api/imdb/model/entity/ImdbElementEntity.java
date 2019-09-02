package com.imdb.api.imdb.model.entity;

import com.imdb.api.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ImdbElementEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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

    private String country;

    private String genre;

    private String writer;
}
