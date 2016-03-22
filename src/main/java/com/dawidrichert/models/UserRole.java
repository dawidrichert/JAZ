package com.dawidrichert.models;

import com.dawidrichert.models.enums.Permission;

import java.util.List;

public class UserRole {

    private String name;
    private List<Permission> permissions;

    public UserRole(String name, List<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
