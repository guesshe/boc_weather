package com.boc.test.weather.utils;

import com.boc.test.weather.exception.GeneralNotAcceptableException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;

@Service()
public interface IFieldValidator {

    default boolean checkList(final List<?> inputList) {
        return inputList == null || inputList.isEmpty();
    }

    default boolean checkString(final String input) {
        return input == null || input.length() == 0;
    }

    default boolean checkInteger(final Integer number) {
        return (number == null || number < 0);
    }

    default boolean checkLong(final Long number) {
        return (number == null || number < 0);
    }

    default void checkErrors(final Errors result) {
        if (result.hasErrors()) {
            final StringBuilder sb = new StringBuilder();
            final List<FieldError> errorList = result.getFieldErrors();
            for (FieldError fe : errorList) {
                sb.append(ObjectUtils.nullSafeToString(fe.getDefaultMessage()));
                sb.append("\n");
            }
            throw new GeneralNotAcceptableException(sb.toString());
        }
    }
}
