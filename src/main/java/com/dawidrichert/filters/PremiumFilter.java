package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;
import com.dawidrichert.utils.Resources;

import javax.servlet.annotation.WebFilter;

@WebFilter(Resources.premiumUrl)
public class PremiumFilter extends PermissionFilter {

    @Override
    protected Permission getPermission() {
        return Permission.PREMIUM;
    }
}
