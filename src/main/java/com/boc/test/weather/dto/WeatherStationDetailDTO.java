package com.boc.test.weather.dto;

public class WeatherStationDetailDTO {

    private Long id;
    private String name;
    private String province;
    private String date;
    private Double meanTemp;
    private Double highestMonthlyMaxTemp;
    private Double lowestMonthlyMinTemp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDate() {
        return date.split(" ")[0];
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMeanTemp() {
        return meanTemp;
    }

    public void setMeanTemp(Double meanTemp) {
        this.meanTemp = meanTemp;
    }

    public Double getHighestMonthlyMaxTemp() {
        return highestMonthlyMaxTemp;
    }

    public void setHighestMonthlyMaxTemp(Double highestMonthlyMaxTemp) {
        this.highestMonthlyMaxTemp = highestMonthlyMaxTemp;
    }

    public Double getLowestMonthlyMinTemp() {
        return lowestMonthlyMinTemp;
    }

    public void setLowestMonthlyMinTemp(Double lowestMonthlyMinTemp) {
        this.lowestMonthlyMinTemp = lowestMonthlyMinTemp;
    }
}
