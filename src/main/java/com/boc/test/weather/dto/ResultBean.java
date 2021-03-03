package com.boc.test.weather.dto;

public class ResultBean<T> {

    private int responseCode;
    private String responseMessage = "success";
    private Object body;

    public ResultBean() {}

    public ResultBean(final int responseCode, final Object body) {
        this.responseCode = responseCode;
        this.body = body;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(final int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(final String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(final Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResultBean{"
                + "responseCode="
                + responseCode
                + ", responseMessage='"
                + responseMessage
                + '\''
                + ", body="
                + body
                + '}';
    }
}

