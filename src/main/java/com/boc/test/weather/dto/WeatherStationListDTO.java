package com.boc.test.weather.dto;

import com.boc.test.weather.entity.WeatherStation;

import java.util.List;

public class WeatherStationListDTO {
    private List<WeatherStationDTO> stations;
    MetaData metaData;

    public List<WeatherStationDTO> getStations() {
        return stations;
    }

    public void setStations(List<WeatherStationDTO> stations) {
        this.stations = stations;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }
}
