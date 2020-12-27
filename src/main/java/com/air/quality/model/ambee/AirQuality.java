package com.air.quality.model.ambee;

import java.util.List;

public class AirQuality {
    String message;
    int page;
    int count;
    List<Station> stations;

    public String getMessage() {
        return message;
    }

    public int getPage() {
        return page;
    }

    public int getCount() {
        return count;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "AirQuality{" +
                "message='" + message + '\'' +
                ", page=" + page +
                ", count=" + count +
                ", stations size=" + stations +
                '}';
    }
}
