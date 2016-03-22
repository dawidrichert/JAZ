package com.dawidrichert.services;

import com.dawidrichert.models.User;
import com.dawidrichert.repositories.DummyData;
import com.dawidrichert.repositories.DummyUserRepository;
import com.dawidrichert.repositories.UserRepository;
import com.dawidrichert.viewModels.RegisterViewModel;

public class UserService {

    private UserRepository userRepository = new DummyUserRepository();

    public void addUser(RegisterViewModel registerViewModel) {
        userRepository.add(new User(registerViewModel.getUserName(), registerViewModel.getPassword(),
                registerViewModel.getEmail(), DummyData.roleBasic));
    }

    public User findUserByUsername(String userName) {
        return userRepository.findUserByUsername(userName);
    }
}
