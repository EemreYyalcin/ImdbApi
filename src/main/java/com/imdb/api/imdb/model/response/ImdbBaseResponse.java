package com.imdb.api.imdb.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImdbBaseResponse {

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Error")
    private String error;

}
