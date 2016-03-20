package com.dawidrichert.viewModels;

import com.dawidrichert.utils.StringUtils;

public class RegisterViewModel {

    private String userName;
    private String password;
    private String confirmPassword;
    private String email;

    public static final String userNameKey = "userName";
    public static final String passwordKey = "password";
    public static final String confirmPasswordKey = "confirmPassword";
    public static final String emailKey = "email";

    public RegisterViewModel(String userName, String password, String confirmPassword, String email) {
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean areAllDataEntered() {
        return !StringUtils.isNullOrEmpty(userName)
                && !StringUtils.isNullOrEmpty(password)
                && !StringUtils.isNullOrEmpty(confirmPassword)
                && !StringUtils.isNullOrEmpty(email);
    }
}
