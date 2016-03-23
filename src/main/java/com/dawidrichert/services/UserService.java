package com.dawidrichert.services;

import com.dawidrichert.models.User;
import com.dawidrichert.models.UserRole;
import com.dawidrichert.repositories.DummyData;
import com.dawidrichert.repositories.DummyUserRepository;
import com.dawidrichert.repositories.UserRepository;
import com.dawidrichert.viewModels.RegisterViewModel;

import java.util.Collections;
import java.util.List;

public class UserService {

    private UserRepository userRepository = new DummyUserRepository();

    public void addUser(RegisterViewModel registerViewModel) {
        userRepository.add(new User(registerViewModel.getUserName(), registerViewModel.getPassword(),
                registerViewModel.getEmail(), Collections.singletonList(DummyData.roleBasic)));
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public User findUserByUsername(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    public void onOffPremium(String userName) {
        User user = findUserByUsername(userName);
        List<UserRole> userRoles = user.getUserRoles();

        if(userRoles.contains(DummyData.rolePremium)) {
            user.removeUserRole(DummyData.rolePremium);
        } else {
            user.addUserRole(DummyData.rolePremium);
        }
    }
}
