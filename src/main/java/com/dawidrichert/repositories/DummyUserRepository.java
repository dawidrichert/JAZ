package com.dawidrichert.repositories;

import com.dawidrichert.models.User;
import java.util.List;

public class DummyUserRepository implements UserRepository {

    private static List<User> users = DummyData.users;

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public List<User> getAll() {
        return users;
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
