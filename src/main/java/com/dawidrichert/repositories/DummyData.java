package com.dawidrichert.repositories;

import com.dawidrichert.models.User;
import com.dawidrichert.models.UserRole;
import com.dawidrichert.models.enums.Permission;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DummyData {

    public static UserRole roleAnonymous = new UserRole("BASIC", Arrays.asList(
            Permission.LOGIN, Permission.REGISTER));

    public static UserRole roleBasic = new UserRole("BASIC", Collections.singletonList(
            Permission.PROFILE));

    public static UserRole rolePremium = new UserRole("PREMIUM", Arrays.asList(
            Permission.PROFILE, Permission.PREMIUM));

    public static UserRole roleAdmin = new UserRole("ADMIN", Arrays.asList(
            Permission.PROFILE, Permission.PREMIUM, Permission.PREMIUM_MANAGER));

    public static List<User> users = Arrays.asList(
            new User("john", "potato", "john@demo.com", roleBasic),
            new User("olivia", "potato", "olivia@demo.com", rolePremium),
            new User("chris", "potato", "chris@demo.com", roleAdmin));
}