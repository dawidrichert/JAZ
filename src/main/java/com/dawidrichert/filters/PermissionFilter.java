package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;
import com.dawidrichert.services.UserService;
import com.dawidrichert.utils.JspHelpers;
import com.dawidrichert.utils.Resources;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

abstract class PermissionFilter implements Filter {

    public abstract Permission getPermission();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(JspHelpers.hasPermission((String)request.getSession().getAttribute("username"), getPermission())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            notPermissionAction(response);
        }
    }

    public void notPermissionAction(HttpServletResponse response) throws IOException {
        response.sendRedirect(Resources.userProfileUrl);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}