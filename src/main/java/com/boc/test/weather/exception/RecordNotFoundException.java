package com.boc.test.weather.exception;

public class RecordNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(final String msg) {
        super(msg);
    }

    public RecordNotFoundException(final String msg, final Throwable t) {
        super(msg, t);
    }

}
