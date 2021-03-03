package com.boc.test.weather.controller;

import static org.junit.Assert.assertEquals;

import com.boc.test.weather.AbstractApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class WeatherStationControllerIntegrationTest extends AbstractApplicationTest {
    @Test
    public void testStmbsimsDeviceGetSingle() {
        final String url = "/weatherstations/1";
        final HttpHeaders requestHeaders = new HttpHeaders();
        final HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        final ResponseEntity<String> response =
                getTestRestTemplate()
                        .exchange(createURLWithPort(url), HttpMethod.GET, requestEntity, String.class);
        assertEquals(200, response.getStatusCodeValue());
    }
}
