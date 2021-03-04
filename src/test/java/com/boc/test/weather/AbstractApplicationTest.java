package com.boc.test.weather;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
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

}

