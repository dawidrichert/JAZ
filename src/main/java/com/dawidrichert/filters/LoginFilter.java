package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;
import com.dawidrichert.utils.Resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login")
public class LoginFilter extends PermissionFilter {

    @Override
    protected Permission getPermission() {
        return Permission.LOGIN;
    }

    @Override
    public void noPermissionAction(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.sendRedirect(Resources.userProfileUrl);
    }
}
