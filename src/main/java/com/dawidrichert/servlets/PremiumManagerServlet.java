package com.dawidrichert.servlets;

import com.dawidrichert.services.UserService;
import com.dawidrichert.utils.JspHelpers;
import com.dawidrichert.utils.Resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Resources.premiumManagerUrl)
public class PremiumManagerServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.getAllUsers());
        JspHelpers.forwardTo(req, resp, Resources.premiumManagerJsp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.onOffPremium(req.getParameter("username"));
        resp.sendRedirect(Resources.premiumManagerUrl);
    }
}
