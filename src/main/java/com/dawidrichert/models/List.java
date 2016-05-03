package com.dawidrichert.models;

import java.util.ArrayList;

public class List {

    private int dt;
    private Main main;
    private java.util.List<Weather> weather = new ArrayList<>();
    private Clouds clouds;
    private Wind wind;
    private Sys_ sys;
    private String dt_txt;
    private Rain rain;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys_ getSys() {
        return sys;
    }

    public void setSys(Sys_ sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dt_txt;
    }

    public void setDtTxt(String dtTxt) {
        this.dt_txt = dtTxt;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }
}
