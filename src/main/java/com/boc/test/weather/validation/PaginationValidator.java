package com.boc.test.weather.validation;

import com.boc.test.weather.dto.PaginationRequest;
import com.boc.test.weather.exception.GeneralNotAcceptableException;
import com.boc.test.weather.utils.IFieldValidator;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service()
public class PaginationValidator implements IFieldValidator, Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PaginationRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        checkErrors(errors);
        PaginationRequest pRequest = (PaginationRequest) target;
        if(pRequest.getMax() == 0 && pRequest.getPage() == 0){
            throw new GeneralNotAcceptableException("max and page must be greater than 0!");
        }
    }
}
