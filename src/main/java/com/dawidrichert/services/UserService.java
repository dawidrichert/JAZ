package com.dawidrichert.services;

import com.dawidrichert.models.User;
import com.dawidrichert.models.enums.UserRole;
import com.dawidrichert.repositories.DummyUserRepository;
import com.dawidrichert.repositories.UserRepository;
import com.dawidrichert.viewModels.LoginViewModel;
import com.dawidrichert.viewModels.RegisterViewModel;

public class UserService {

    private UserRepository userRepository = new DummyUserRepository();

    public void addUser(RegisterViewModel registerViewModel) {
        userRepository.add(new User(registerViewModel.getUserName(), registerViewModel.getPassword(),
                registerViewModel.getEmail(), UserRole.BASIC));
    }
}
