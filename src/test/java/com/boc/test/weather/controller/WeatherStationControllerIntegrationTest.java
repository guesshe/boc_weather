package com.boc.test.weather.controller;

import com.boc.test.weather.AbstractApplicationTest;
import com.boc.test.weather.dto.PaginationRequest;
import com.boc.test.weather.dto.WeatherStationFilter;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherStationControllerIntegrationTest extends AbstractApplicationTest {
    @Test
    public void testWeatherStationGetSingle() {
        final String url = "/weatherstations/1";
        final HttpHeaders requestHeaders = new HttpHeaders();
        final HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        final ResponseEntity<String> response =
                getTestRestTemplate()
                        .exchange(createURLWithPort(url), HttpMethod.GET, requestEntity, String.class);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testWeatherStationGetAll() {
        final String url = "/weatherstations?max=100&page=2";
        final HttpHeaders requestHeaders = new HttpHeaders();
        final HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        final ResponseEntity<String> response =
                getTestRestTemplate()
                        .exchange(createURLWithPort(url), HttpMethod.GET, requestEntity, String.class);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testWeatherStationGetAllWithBadParams() {
        final String url = "/weatherstations?min=100";
        final HttpHeaders requestHeaders = new HttpHeaders();
        final HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        final ResponseEntity<String> response =
                getTestRestTemplate()
                        .exchange(createURLWithPort(url), HttpMethod.GET, requestEntity, String.class);
        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    public void testWeatherStationFilter() {
        final String url = "/weatherstations/filter";
        final HttpHeaders requestHeaders = new HttpHeaders();
        WeatherStationFilter wsF = new WeatherStationFilter();
        wsF.setStartDate("2016-01-08");
        wsF.setEndDate("2017-02-08");
        wsF.setPage(new PaginationRequest(100, 1));
        final HttpEntity<WeatherStationFilter> requestEntity = new HttpEntity<>(wsF, requestHeaders);
        final ResponseEntity<String> response =
                getTestRestTemplate()
                        .exchange(createURLWithPort(url), HttpMethod.POST, requestEntity, String.class);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testWeatherStationFilterWithBadDateFormat() {
        final String url = "/weatherstations/filter";
        final HttpHeaders requestHeaders = new HttpHeaders();
        WeatherStationFilter wsF = new WeatherStationFilter();
        wsF.setStartDate("01-08-2019");
        wsF.setEndDate("2017-02-08");
        wsF.setPage(new PaginationRequest(100, 1));
        final HttpEntity<WeatherStationFilter> requestEntity = new HttpEntity<>(wsF, requestHeaders);
        final ResponseEntity<String> response =
                getTestRestTemplate()
                        .exchange(createURLWithPort(url), HttpMethod.POST, requestEntity, String.class);
        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    public void testWeatherStationGetNotFound() {
        final String url = "/weatherstations/100000";
        final HttpHeaders requestHeaders = new HttpHeaders();
        final HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        final ResponseEntity<String> response =
                getTestRestTemplate()
                        .exchange(createURLWithPort(url), HttpMethod.GET, requestEntity, String.class);
        assertEquals(404, response.getStatusCodeValue());
    }
}
