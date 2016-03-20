package com.dawidrichert.repositories;

import com.dawidrichert.models.User;

public interface UserRepository {

    void add(User user);
    User findUserByUsername(String userName);
}
