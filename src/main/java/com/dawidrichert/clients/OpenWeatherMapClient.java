package com.dawidrichert.clients;

import com.dawidrichert.models.CurrentWeatherData;
import com.dawidrichert.utils.Config;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

public class OpenWeatherMapClient {

    private static final String APPID = "2db0d53f079460a089d0eab40789e483";

    public CurrentWeatherData getCurrentWeather(String city) {
        if(Arrays.asList(Config.listOfAllowedCities).contains(city)) {
            try {
                String json = readUrl("http://api.openweathermap.org/data/2.5/forecast/city?q=" + city +
                        "&units=metric&lang=pl&APPID=" + APPID);
                return new Gson().fromJson(json, CurrentWeatherData.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
