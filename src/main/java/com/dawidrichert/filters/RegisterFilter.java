package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;

import javax.servlet.annotation.WebFilter;

@WebFilter("/register")
public class RegisterFilter extends PermissionFilter {

    @Override
    public Permission getPermission() {
        return Permission.REGISTER;
    }
}
