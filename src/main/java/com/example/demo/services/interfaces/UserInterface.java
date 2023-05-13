package com.example.demo.services.interfaces;

import com.example.demo.models.User;

import java.util.List;

public interface UserInterface {

    List<User> getAll();

    User getUserById(Long id);

    User addUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
