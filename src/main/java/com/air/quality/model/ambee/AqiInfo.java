package com.air.quality.model.ambee;

public class AqiInfo {
    String category;
    String pollutant;
    int concentration;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPollutant() {
        return pollutant;
    }

    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    @Override
    public String toString() {
        return "AqiInfo{" +
                "category='" + category + '\'' +
                ", pollutant='" + pollutant + '\'' +
                ", concentration=" + concentration +
                '}';
    }
}
