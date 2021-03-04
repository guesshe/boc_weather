package com.boc.test.weather.controller;

import com.boc.test.weather.dto.PaginationRequest;
import com.boc.test.weather.dto.WeatherStationFilter;
import com.boc.test.weather.service.WeatherStationService;
import com.boc.test.weather.utils.IResponseEntityGenerator;
import com.boc.test.weather.validation.PaginationValidator;
import com.boc.test.weather.validation.WeatherStationFilterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/weatherstations", produces = {"application/json;charset=UTF-8"})
public class WeatherController implements IResponseEntityGenerator {

    @Autowired
    private WeatherStationService service;
    @Autowired() private PaginationValidator paginationValidator;
    @Autowired() private WeatherStationFilterValidator filterValidator;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return processResultBean(service.findById(id));
    }

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<Object> findAll(PaginationRequest pRequest, BindingResult result) {
        paginationValidator.validate(pRequest, result);
        return processResultBean(service.findAll(pRequest));
    }

    @CrossOrigin
    @PostMapping(path = "/filter")
    public ResponseEntity<Object> filter(@RequestBody WeatherStationFilter wStationFilter, BindingResult result){
        filterValidator.validate(wStationFilter, result);
        return processResultBean(service.filter(wStationFilter));
    }
}
