package com.dawidrichert.servlets;

import com.dawidrichert.services.UserService;
import com.dawidrichert.utils.JspHelpers;
import com.dawidrichert.utils.RequestMapper;
import com.dawidrichert.utils.Resources;
import com.dawidrichert.viewModels.RegisterViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       JspHelpers.forwardTo(req, resp, Resources.registerJsp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterViewModel registerViewModel = RequestMapper.mapRegisterViewModel(req);

        if(registerViewModel.areAllDataEntered()) {

            if(!registerViewModel.getPassword().equals(registerViewModel.getConfirmPassword())) {
                req.setAttribute("errorMessage", "'Password' and 'Confirm password' must be the same.");
                JspHelpers.forwardTo(req, resp, Resources.registerJsp);
                return;
            }

            if(!JspHelpers.isValidEmailAddress(registerViewModel.getEmail())) {
                req.setAttribute("errorMessage", "'E-mail' is not valid.");
                JspHelpers.forwardTo(req, resp, Resources.registerJsp);
                return;
            }

            userService.addUser(registerViewModel);
            resp.sendRedirect(Resources.loginUrl + "?registered=true");
        } else {
            req.setAttribute("errorMessage", "All fields are required.");
            JspHelpers.forwardTo(req, resp, Resources.registerJsp);
        }
    }
}
