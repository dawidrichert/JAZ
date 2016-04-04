package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;
import com.dawidrichert.utils.Resources;

import javax.servlet.annotation.WebFilter;

@WebFilter(Resources.premiumManagerUrl)
public class PremiumManagerFilter extends PermissionFilter {

    @Override
    protected Permission getPermission() {
        return Permission.PREMIUM_MANAGER;
    }
}
