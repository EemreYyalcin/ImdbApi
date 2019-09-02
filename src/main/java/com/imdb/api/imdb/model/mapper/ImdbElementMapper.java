package com.imdb.api.imdb.model.mapper;

import com.imdb.api.imdb.model.dto.ImdbElementDTO;
import com.imdb.api.imdb.model.entity.ImdbElementEntity;
import com.imdb.api.imdb.model.response.ImdbIdResponse;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Setter
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class ImdbElementMapper {

    public abstract ImdbElementDTO imdbElementEntityToImdbElementDTO(ImdbElementEntity imdbElementEntity);

    public abstract ImdbElementDTO imdbIdResponseToImdbElementDTO(ImdbIdResponse imdbIdResponse);

    public abstract ImdbElementEntity imdbIdResponseToImdbElementEntity(ImdbIdResponse imdbIdResponse);

}
