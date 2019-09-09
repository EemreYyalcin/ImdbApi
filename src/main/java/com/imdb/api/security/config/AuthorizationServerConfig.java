package com.imdb.api.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${security.oauth2.client_id}")
    private String clientId;
    @Value("${security.oauth2.secret}")
    private String clientSecret;
    @Value("${security.oauth2.password}")
    private String grantType;
    @Value("${security.oauth2.authorization.code}")
    private String authorizationCode;
    @Value("${security.oauth2.refresh.token}")
    private String refreshToken;
    @Value("${security.oauth2.implicit}")
    private String implicit;
    @Value("${security.oauth2.read}")
    private String scopeRead;
    @Value("${security.oauth2.write}")
    private String scopeWrite;
    @Value("${security.oauth2.trust}")
    private String trust;
    @Value("${security.oauth2.token.validation.expired}")
    private int accessTokenValiditySeconds;
    @Value("${security.oauth2.refresh.token.validation.expired}")
    private int refreshTokenValiditySeconds;
    @Value("${security.oauth2.grant.type.password}")
    private String grantTypePassword;

    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

        configurer
                .inMemory()
                .withClient(clientId)
                .secret(bCryptPasswordEncoder.encode(clientSecret))
                .authorizedGrantTypes(grantTypePassword, authorizationCode, refreshToken, implicit)
                .scopes(scopeRead, scopeWrite, trust)
                .accessTokenValiditySeconds(accessTokenValiditySeconds).
                refreshTokenValiditySeconds(refreshTokenValiditySeconds);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(redisTokenStore())
                .authenticationManager(authenticationManager);
    }

    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(redisTokenStore());
        return defaultTokenServices;
    }


}