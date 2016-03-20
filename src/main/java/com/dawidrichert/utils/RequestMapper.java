package com.dawidrichert.utils;

import com.dawidrichert.viewModels.LoginViewModel;
import com.dawidrichert.viewModels.RegisterViewModel;

import javax.servlet.http.HttpServletRequest;

public class RequestMapper {

    public static LoginViewModel mapToLoginViewModel(HttpServletRequest req) {
        return new LoginViewModel(
                req.getParameter(LoginViewModel.userNameKey),
                req.getParameter(LoginViewModel.passwordKey));
    }

    public static RegisterViewModel mapRegisterViewModel(HttpServletRequest req) {
        return new RegisterViewModel(
                req.getParameter(RegisterViewModel.userNameKey),
                req.getParameter(RegisterViewModel.passwordKey),
                req.getParameter(RegisterViewModel.confirmPasswordKey),
                req.getParameter(RegisterViewModel.emailKey));
    }
}
