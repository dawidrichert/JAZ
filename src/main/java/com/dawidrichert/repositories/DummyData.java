package com.dawidrichert.repositories;

import com.dawidrichert.models.User;
import com.dawidrichert.models.UserRole;
import com.dawidrichert.models.enums.Permission;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DummyData {

    public static final UserRole roleAnonymous = new UserRole("BASIC", Arrays.asList(
            Permission.LOGIN, Permission.REGISTER));

    public static final UserRole roleBasic = new UserRole("BASIC", Collections.singletonList(
            Permission.PROFILE));

    public static final UserRole rolePremium = new UserRole("PREMIUM", Arrays.asList(
            Permission.PROFILE, Permission.PREMIUM));

    public static final UserRole roleAdmin = new UserRole("ADMIN", Arrays.asList(
            Permission.PROFILE, Permission.PREMIUM, Permission.PREMIUM_MANAGER));

    public static final List<User> users = new LinkedList<>(Arrays.asList(
            new User("john", "potato", "john@demo.com", Collections.singletonList(roleBasic)),
            new User("olivia", "potato", "olivia@demo.com", Arrays.asList(roleBasic, rolePremium)),
            new User("chris", "potato", "chris@demo.com", Arrays.asList(roleBasic, rolePremium, roleAdmin))));
}
