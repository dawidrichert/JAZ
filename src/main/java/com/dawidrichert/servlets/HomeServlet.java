package com.dawidrichert.servlets;

import com.dawidrichert.clients.OpenWeatherMapClient;
import com.dawidrichert.models.CurrentWeatherData;
import com.dawidrichert.utils.Resources;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Resources.homeUrl)
public class HomeServlet extends HttpServlet {

    private final OpenWeatherMapClient openWeatherMapClient = new OpenWeatherMapClient();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        CurrentWeatherData data = openWeatherMapClient.getCurrentWeather(city);
        forwardResult(req, resp, data);
    }

    private void forwardResult(HttpServletRequest req, HttpServletResponse resp, CurrentWeatherData currentWeatherData)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(Resources.homeJsp);
        req.setAttribute("weatherData", currentWeatherData);
        dispatcher.forward(req, resp);
    }
}