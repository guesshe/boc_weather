package com.boc.test.weather.dto;


import org.springframework.lang.Nullable;

public class PaginationRequest {

    private int max;
    private int page;

    @Nullable
    private String order;
    @Nullable
    private String sort;

    public PaginationRequest() {
    }

    public PaginationRequest(int max, int page) {
        this.max = max;
        this.page = page;
    }

    public PaginationRequest(int max, int page, @Nullable String order, @Nullable String sort) {
        this.max = max;
        this.page = page;
        this.order = order;
        this.sort = sort;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "PaginationRequest{" +
                "max=" + max +
                ", page=" + page +
                ", order='" + order + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}

