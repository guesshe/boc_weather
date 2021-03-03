package com.boc.test.weather.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "weather_station")
public class WeatherStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "station_name", unique = true, nullable = true)
    private String name;

    @Column(name = "province", unique = true, nullable = true)
    private String province;

    @Column(name = "date", unique = true, nullable = true)
    private Timestamp date;

    @Column(name = "mean_temp", unique = true, nullable = true)
    private Double meanTemp;

    @Column(name = "highest_monthly_maxi_temp", unique = true, nullable = true)
    private Double highestMonthlyMaxTemp;

    @Column(name = "lowest_monthly_min_temp", unique = true, nullable = true)
    private Double lowestMonthlyMinTemp;

    public WeatherStation() {
    }

    public WeatherStation(String name, String province, Timestamp date, Double meanTemp, Double highestMonthlyMaxTemp, Double lowestMonthlyMinTemp) {
        this.name = name;
        this.province = province;
        this.date = date;
        this.meanTemp = meanTemp;
        this.highestMonthlyMaxTemp = highestMonthlyMaxTemp;
        this.lowestMonthlyMinTemp = lowestMonthlyMinTemp;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDate() {
        return date == null ? null : date.toString();
    }

    public void setDate(String date) {
        if (date == null || date.trim().length() == 0) {
            this.date = null;
        }
        else {
            this.date = Timestamp.valueOf(date);
        }
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

    @Override
    public String toString() {
        return "WeatherStation{" +
                "name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", date=" + date +
                ", meanTemp=" + meanTemp +
                ", highestMonthlyMaxTemp=" + highestMonthlyMaxTemp +
                ", lowestMonthlyMinTemp=" + lowestMonthlyMinTemp +
                '}';
    }
}
