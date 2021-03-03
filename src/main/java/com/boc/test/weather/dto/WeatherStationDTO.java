package com.boc.test.weather.dto;

import javax.persistence.Column;
import java.sql.Timestamp;

public class WeatherStationDTO {
    private Long id;
    private String name;
    private String date;
    private Double meanTemp;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
