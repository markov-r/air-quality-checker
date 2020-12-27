package com.air.quality.entity;

import javax.persistence.*;

@Entity
@Table(name = "ambee_air_quality")
public class AmbeeAirQuality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double latitude;
    private Double longitude;
    private Double no2;
    private Double pm10;
    private Double pm25;
    private Double so2;
    private Double ozone;
    private Integer postalCode;
    private Long createdAt;
    private Long updateTimestamp;
    private Double distance;
    //    private AqiInfo aqiInfo; //todo add later
    private String comment;

    public AmbeeAirQuality() {
    }

    public AmbeeAirQuality(Double latitude, Double longitude, Double no2,
                           Double pm10, Double pm25, Double so2, Double ozone, Integer postalCode, Long createdAt,
                           Long updateTimestamp, Double distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.no2 = no2;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.so2 = so2;
        this.ozone = ozone;
        this.postalCode = postalCode;
        this.createdAt = createdAt;
        this.updateTimestamp = updateTimestamp;
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getNo2() {
        return no2;
    }

    public Double getPm10() {
        return pm10;
    }

    public Double getPm25() {
        return pm25;
    }

    public Double getSo2() {
        return so2;
    }

    public Double getOzone() {
        return ozone;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdateTimestamp() {
        return updateTimestamp;
    }

    public Double getDistance() {
        return distance;
    }

    public String getComment() {
        return comment;
    }

    public AmbeeAirQuality withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public AmbeeAirQuality withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public AmbeeAirQuality withDistance(Double distance) {
        this.distance = distance;
        return this;
    }

    public AmbeeAirQuality withNo2(Double no2) {
        this.no2 = no2;
        return this;
    }

    public AmbeeAirQuality withPm10(Double pm10) {
        this.pm10 = pm10;
        return this;
    }

    public AmbeeAirQuality withPm25(Double pm25) {
        this.pm25 = pm25;
        return this;
    }

    public AmbeeAirQuality withSo2(Double so2) {
        this.so2 = so2;
        return this;
    }

    public AmbeeAirQuality withOzone(Double ozone) {
        this.ozone = ozone;
        return this;
    }

    public AmbeeAirQuality withPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AmbeeAirQuality withCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public AmbeeAirQuality withUpdateTimestamp(Long updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
        return this;
    }

    @Override
    public String toString() {
        return "AmbeeAQEntry{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", no2=" + no2 +
                ", pm10=" + pm10 +
                ", pm25=" + pm25 +
                ", so2=" + so2 +
                ", ozone=" + ozone +
                ", postalCode=" + postalCode +
                ", createdAt=" + createdAt +
                ", updateTimestamp=" + updateTimestamp +
                ", distance=" + distance +
                ", comment='" + comment + '\'' +
                '}';
    }

    public AmbeeAirQuality build() {
        return new AmbeeAirQuality(latitude, longitude, no2, pm10, pm25, so2, ozone,
                postalCode, createdAt, updateTimestamp, distance);
    }
}
