package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;

import javax.servlet.annotation.WebFilter;

@WebFilter("/profile")
public class UserProfileFilter extends PermissionFilter {

    @Override
    protected Permission getPermission() {
        return Permission.PROFILE;
    }
}
