package com.boc.test.weather.dto;

import org.springframework.lang.NonNull;

public class WeatherStationFilter {

    @NonNull
    private String startDate;

    @NonNull
    private String endDate;

    @NonNull
    private PaginationRequest page;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public PaginationRequest getPage() {
        return page;
    }

    public void setPage(PaginationRequest page) {
        this.page = page;
    }
}
