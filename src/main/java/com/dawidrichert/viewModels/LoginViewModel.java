package com.dawidrichert.viewModels;

public class LoginViewModel {

    private String userName;
    private String password;

    public static final String userNameKey = "userName";
    public static final String passwordKey = "password";

    public LoginViewModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
}
