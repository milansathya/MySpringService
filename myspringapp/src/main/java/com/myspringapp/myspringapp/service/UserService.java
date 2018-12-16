package com.myspringapp.myspringapp.service;

import com.myspringapp.myspringapp.model.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);
    public User updateUser(String id, User user);
    public User deleteUser(String id);
    public User getUser(String id);
    public List<User> listUsers();

}
