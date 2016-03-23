package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;

import javax.servlet.annotation.WebFilter;

@WebFilter("/premiumManager")
public class PremiumManagerFilter extends PermissionFilter {

    @Override
    protected Permission getPermission() {
        return Permission.PREMIUM_MANAGER;
    }
}
