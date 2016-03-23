package com.dawidrichert.utils;

import com.dawidrichert.models.User;
import com.dawidrichert.models.UserRole;
import com.dawidrichert.models.enums.Permission;
import com.dawidrichert.repositories.DummyData;
import com.dawidrichert.repositories.UserRepository;
import com.dawidrichert.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JspHelpers {

    public static String emptyIfNull(String text) {
        return text == null ? "" : text;
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static void forwardTo(HttpServletRequest req, HttpServletResponse resp, String destination)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(destination);
        rd.forward(req, resp);
    }

    public static boolean hasPermission(String username, Permission permission) {
        UserService userService = new UserService();

        if(username == null) {
            return DummyData.roleAnonymous.getPermissions().contains(permission);
        } else {
            User user = userService.findUserByUsername(username);
            for(UserRole userRole : user.getUserRoles()) {
                if(userRole.getPermissions().contains(permission)) {
                    return true;
                }
            }
            return false;
        }
    }
}
