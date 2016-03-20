package com.dawidrichert.models;

import com.dawidrichert.models.enums.UserRole;

public class User {

    private String userName;
    private String password;
    private String email;
    private UserRole userRole;

    public User(String userName, String password, String email, UserRole userRole) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
