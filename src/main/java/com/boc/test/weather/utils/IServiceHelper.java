package com.boc.test.weather.utils;

import java.beans.FeatureDescriptor;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import com.boc.test.weather.dto.ResultBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service()
public interface IServiceHelper {

    public static final String ASC = "ASC";

    default ResultBean<Object> setResultBeanSuccessContent(
            final int statusCode, final Object object) {
        return new ResultBean<>(statusCode, object);
    }

    default void copyPropertiesIgnoreNull(Object source, Object target) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        String[] ignoredNullValueProperties =
                Stream.of(src.getPropertyDescriptors())
                        .map(FeatureDescriptor::getName)
                        .filter(propertyName -> src.getPropertyValue(propertyName) == null)
                        .toArray(String[]::new);
        BeanUtils.copyProperties(source, target, ignoredNullValueProperties);
    }

    default String convertTimeStringToUTCFormat(final String inputTimeString) {
        if (inputTimeString == null) {
            return null;
        }
        final String[] spacePatternStrArr = inputTimeString.split(" ");
        final String yyyymmdd = spacePatternStrArr[0];
        final String hhmmss = spacePatternStrArr[1].split("\\.")[0];
        return yyyymmdd + "T" + hhmmss + "Z";
    }

    default Pageable createPageRequest(int page, int size, String order, String sortName) {
        Pageable pageRequest;
        if (order == null || ASC.equalsIgnoreCase(order)) {
            if (sortName == null) {
                pageRequest = PageRequest.of(page, size, Sort.by("id").ascending());
            } else {
                pageRequest = PageRequest.of(page, size, Sort.by(sortName).ascending());
            }
        } else {
            if (sortName == null) {
                pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
            } else {
                pageRequest = PageRequest.of(page, size, Sort.by(sortName).descending());
            }
        }
        return pageRequest;
    }
}

