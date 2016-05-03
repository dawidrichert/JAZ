package com.dawidrichert.models;

public class Main {

    private float temp;
    private float temp_min;
    private float temp_max;
    private float pressure;
    private float sea_level;
    private float grnd_level;
    private int humidity;
    private float temp_kf;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTempMin() {
        return temp_min;
    }

    public void setTempMin(float tempMin) {
        this.temp_min = tempMin;
    }

    public float getTempMax() {
        return temp_max;
    }

    public void setTempMax(float tempMax) {
        this.temp_max = tempMax;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getSeaLevel() {
        return sea_level;
    }

    public void setSeaLevel(float seaLevel) {
        this.sea_level = seaLevel;
    }

    public float getGrndLevel() {
        return grnd_level;
    }

    public void setGrndLevel(float grndLevel) {
        this.grnd_level = grndLevel;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getTempKf() {
        return temp_kf;
    }

    public void setTempKf(float tempKf) {
        this.temp_kf = tempKf;
    }
}
