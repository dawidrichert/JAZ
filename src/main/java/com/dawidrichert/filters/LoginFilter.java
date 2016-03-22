package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;

import javax.servlet.annotation.WebFilter;

@WebFilter("/login")
public class LoginFilter extends PermissionFilter {

    @Override
    public Permission getPermission() {
        return Permission.LOGIN;
    }
}
