package com.dawidrichert.servlets;

import com.dawidrichert.utils.JspHelpers;
import com.dawidrichert.utils.Resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/premium")
public class PremiumServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JspHelpers.forwardTo(req, resp, Resources.premiumJsp);
    }
}
