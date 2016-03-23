package com.dawidrichert.repositories;

import com.dawidrichert.models.User;

import java.util.List;

public interface UserRepository {

    void add(User user);
    List<User> getAll();
    User findUserByUsername(String userName);
}
