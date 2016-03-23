package com.dawidrichert.filters;

import com.dawidrichert.models.enums.Permission;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/premium")
public class PremiumFilter extends PermissionFilter {

    @Override
    public Permission getPermission() {
        return Permission.PREMIUM;
    }
}
