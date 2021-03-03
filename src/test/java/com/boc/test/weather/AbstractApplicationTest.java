package com.boc.test.weather;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(
        classes = WeatherApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractApplicationTest {

    @LocalServerPort
    private int port;

    protected TestRestTemplate getTestRestTemplate() {
        return new TestRestTemplate();
    }

    protected String createURLWithPort(final String url) {
        return "http://localhost:" + port + url;
    }

    protected HttpHeaders getRequestHttpHeadersForCpTokenAuthorization() {
        return new HttpHeaders();
    }
}

