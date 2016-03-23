package com.dawidrichert.servlets;

import com.dawidrichert.models.User;
import com.dawidrichert.repositories.DummyUserRepository;
import com.dawidrichert.repositories.UserRepository;
import com.dawidrichert.utils.JspHelpers;
import com.dawidrichert.utils.RequestMapper;
import com.dawidrichert.utils.Resources;
import com.dawidrichert.viewModels.LoginViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserRepository userRepository = new DummyUserRepository();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("true".equals(req.getParameter("registered"))) {
            req.setAttribute("successMessage", "Your account has been added. You can log in now.");
        }

        JspHelpers.forwardTo(req, resp, Resources.loginJsp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginViewModel loginViewModel = RequestMapper.mapToLoginViewModel(req);

        User user = userRepository.findUserByUsername(loginViewModel.getUserName());
        if(user == null) {
            req.setAttribute("errorMessage", "Doesn't exist user with this username.");
            JspHelpers.forwardTo(req, resp, Resources.loginJsp);
        } else {
            if(user.getPassword().equals(loginViewModel.getPassword())) {
                req.getSession().setAttribute("username", user.getUserName());
                resp.sendRedirect(Resources.userProfileUrl);
            } else {
                req.setAttribute("errorMessage", "Incorrect password for this user.");
                JspHelpers.forwardTo(req, resp, Resources.loginJsp);
            }
        }
    }
}
