package com.air.quality.model.ambee;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Station {

    @JsonProperty("NO2")
    Double no2;

    @JsonProperty("PM10")
    Double pm10;

    @JsonProperty("PM25")
    Double pm25;

    @JsonProperty("SO2")
    Double so2;

    @JsonProperty("OZONE")
    Double ozone;

    @JsonProperty("AQI")
    String aqi;

    Long createdAt;
    String updatedAt;
    Double lat;
    Double lng;
    AqiInfo aqiInfo;
    String countryCode;
    String division;
    String placeId;
    Integer postalCode;
    String lastUpdate;
    String placeName;
    String state;
    Long updateTs;
    Double distance;

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public Double getPm25() {
        return pm25;
    }

    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public Double getOzone() {
        return ozone;
    }

    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public AqiInfo getAqiInfo() {
        return aqiInfo;
    }

    public void setAqiInfo(AqiInfo aqiInfo) {
        this.aqiInfo = aqiInfo;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Long updateTs) {
        this.updateTs = updateTs;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Station{" +
                "NO2='" + no2 + '\'' +
                ", PM10='" + pm10 + '\'' +
                ", PM25='" + pm25 + '\'' +
                ", SO2='" + so2 + '\'' +
                ", OZONE='" + ozone + '\'' +
                ", AQI='" + aqi + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", aqiInfo=" + aqiInfo +
                ", countryCode='" + countryCode + '\'' +
                ", division='" + division + '\'' +
                ", placeId='" + placeId + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", placeName='" + placeName + '\'' +
                ", state='" + state + '\'' +
                ", updateTs='" + updateTs + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
