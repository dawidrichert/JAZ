package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;
import com.dawidrichert.utils.Resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/register")
public class RegisterFilter extends PermissionFilter {

    @Override
    public Permission getPermission() {
        return Permission.REGISTER;
    }

    @Override
    public void notPermissionAction(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.sendRedirect(Resources.userProfileUrl);
    }
}
