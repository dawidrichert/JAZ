package com.dawidrichert.repositories;

import com.dawidrichert.models.User;

import java.util.ArrayList;
import java.util.List;

public class DummyUserRepository implements UserRepository {

    private static List<User> users = new ArrayList<User>();

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public User findUserByUsername(String userName) {
        for(User user : users) {
            if(user.getUserName().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        return null;
    }
}
