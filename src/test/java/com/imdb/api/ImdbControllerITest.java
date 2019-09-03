package com.imdb.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.common.util.JacksonJsonParser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class ImdbControllerITest {

    @Value("${security.oauth2.client_id}")
    private String clientId;
    @Value("${security.oauth2.secret}")
    private String clientSecret;

    private String testUsername = "emreyalcin";
    private String testPassword = "emre123";

    private final String searchKey = "titanic";

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    private String accessToken;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        try {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(springSecurityFilterChain).build();
            accessToken = obtainAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_search_movies_with_search_key() throws Exception {
        log.info(mockMvc
                .perform(get("/imdb/search/" + searchKey).header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }

    @Test
    public void should_search_movies_with_search_key_and_page() throws Exception {
        log.info(mockMvc
                .perform(get("/imdb/search/" + searchKey + "/1").header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }

    private String obtainAccessToken() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>() {{
            add("grant_type", "password");
            add("username", testUsername);
            add("password", testPassword);
        }};
        ResultActions result = mockMvc
                .perform(post("/oauth/token").params(params).with(httpBasic(clientId, clientSecret))
                        .accept("application/x-www-form-urlencoded;charset=UTF-8"))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
        return new JacksonJsonParser().parseMap(result.andReturn().getResponse().getContentAsString()).get("access_token")
                .toString();
    }
}
