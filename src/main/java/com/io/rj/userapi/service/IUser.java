package com.io.rj.userapi.service;

import com.io.rj.userapi.Entity.User;

import java.util.List;

public interface IUser {
    User createUser(User user);
    List<User> listUsers();
    User updateUser(User user, Long id);
    void deleteUser(Long id);
    String login(String name, String password);
}
