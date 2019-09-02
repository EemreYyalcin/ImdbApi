package com.imdb.api.imdb.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImdbBaseResponse {

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Error")
    private String error;

}
