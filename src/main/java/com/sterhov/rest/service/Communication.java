package com.sterhov.rest.service;

import com.sterhov.rest.models.User;

import java.util.List;

public interface Communication {

    List<User> showAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void deleteUser(int id);
}
