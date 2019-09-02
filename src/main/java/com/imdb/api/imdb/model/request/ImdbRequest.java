package com.imdb.api.imdb.model.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

@Getter
@Setter
public class ImdbRequest {

    private String id;

    private String title;

    private String year;

    private String search;

    @Override
    public String toString() {
        return new StringBuilder().append(ObjectUtils.isEmpty(id) ? "" : "i=" + id)
                .append(ObjectUtils.isEmpty(title) ? "" : "t=" + title)
                .append(ObjectUtils.isEmpty(year) ? "" : "y=" + year)
                .append(ObjectUtils.isEmpty(search) ? "" : "s=" + search).toString();

    }
}
