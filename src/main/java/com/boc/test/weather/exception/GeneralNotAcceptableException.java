package com.boc.test.weather.exception;

import com.boc.test.weather.config.ApiError;

public class GeneralNotAcceptableException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private ApiError apiError;

    public GeneralNotAcceptableException(final String msg) {
        super(msg);
    }

    public GeneralNotAcceptableException(final String msg, final Throwable t) {
        super(msg, t);
    }

    public GeneralNotAcceptableException(final String msg, final ApiError apiError) {
        super(msg);
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(final ApiError apiError) {
        this.apiError = apiError;
    }
}

