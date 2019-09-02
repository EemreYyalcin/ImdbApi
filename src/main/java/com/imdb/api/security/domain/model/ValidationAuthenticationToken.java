package com.imdb.api.security.domain.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class ValidationAuthenticationToken extends AbstractAuthenticationToken {

    private final String authToken;
    private final String requestURI;
    private final String requestMethod;

    public ValidationAuthenticationToken(String authToken, String requestURI, String requestMethod) {
        super(null);
        this.authToken = authToken;
        this.requestURI = requestURI;
        this.requestMethod = requestMethod;
    }

    @Override
    public Object getCredentials() {
        return authToken;
    }

    @Override
    public Object getPrincipal() {
        return authToken;
    }


}
