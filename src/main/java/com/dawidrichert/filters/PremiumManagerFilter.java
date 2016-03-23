package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;

import javax.servlet.annotation.WebFilter;

@WebFilter("/premiumManager")
public class PremiumManagerFilter extends PermissionFilter {

    @Override
    public Permission getPermission() {
        return Permission.PREMIUM_MANAGER;
    }
}