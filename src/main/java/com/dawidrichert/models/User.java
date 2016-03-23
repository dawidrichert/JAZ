package com.dawidrichert.models;

import com.dawidrichert.models.enums.Permission;
import com.dawidrichert.utils.JspHelpers;

import java.util.LinkedList;
import java.util.List;

public class User {

    private String userName;
    private String password;
    private String email;
    private LinkedList<UserRole> userRoles;

    public User(String userName, String password, String email, List<UserRole> userRoles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userRoles = new LinkedList(userRoles);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = new LinkedList(userRoles);
    }

    public void addUserRole(UserRole userRole) {
        this.userRoles.add(userRole);
    }

    public void removeUserRole(UserRole userRole) {
        this.userRoles.remove(userRole);
    }

    public boolean getHasPremiumAccess() {
        return JspHelpers.hasPermission(userName, Permission.PREMIUM);
    }

    public boolean getHasPremiumManagerAccess() {
        return JspHelpers.hasPermission(userName, Permission.PREMIUM_MANAGER);
    }
}
