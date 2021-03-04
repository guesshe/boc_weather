package com.boc.test.weather.validation;

import com.boc.test.weather.dto.PaginationRequest;
import com.boc.test.weather.dto.WeatherStationFilter;
import com.boc.test.weather.utils.IFieldValidator;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service()
public class WeatherStationFilterValidator implements IFieldValidator, Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return WeatherStationFilter.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        checkErrors(errors);
        WeatherStationFilter wsFilter = (WeatherStationFilter) target;
        wsFilter.getStartDate();
        wsFilter.getEndDate();
    }
}
