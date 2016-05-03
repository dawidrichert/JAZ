package com.dawidrichert.models;

import java.util.ArrayList;

public class CurrentWeatherData {

    private City city;
    private String cod;
    private float message;
    private int cnt;
    private java.util.List<com.dawidrichert.models.List> list = new ArrayList<>();

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public java.util.List<com.dawidrichert.models.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.dawidrichert.models.List> list) {
        this.list = list;
    }
}
