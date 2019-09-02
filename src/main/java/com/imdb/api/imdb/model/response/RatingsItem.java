package com.imdb.api.imdb.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingsItem{

	@JsonProperty("Value")
	private String value;

	@JsonProperty("Source")
	private String source;
}