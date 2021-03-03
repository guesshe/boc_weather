package com.boc.test.weather.config;

public final class ApiError {

    private FieldError errors;

    public ApiError(String detail, String code) {
        this.errors = new FieldError(detail, code);
    }

    public FieldError getErrors() {
        return errors;
    }

    public void setErrors(FieldError errors) {
        this.errors = errors;
    }

    class FieldError {

        private String detail;
        private String code;

        FieldError(String detail, String code) {
            this.detail = detail;
            this.code = code;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    }

}

