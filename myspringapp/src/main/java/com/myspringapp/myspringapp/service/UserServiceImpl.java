package com.myspringapp.myspringapp.service;

import com.myspringapp.myspringapp.model.User;
import com.myspringapp.myspringapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(String id, User user) {
        User update = this.findOne(id);
        update.setName(user.getName());
        return repository.save(update);
    }

    @Override
    public User deleteUser(String id) {
        User delete = this.findOne(id);
        repository.delete(delete);
        return delete;
    }

    @Override
    public User getUser(String id) {
        return this.findOne(id);
    }

    @Override
    public List<User> listUsers() {
        return repository.findAll();
    }

    private User findOne(String id) {
        List<User> users = repository.findAll();
        if (users == null || users.isEmpty()) return null;

        return users.stream()
                .filter(u -> id.equalsIgnoreCase(u.getId()))
                .findFirst()
                .orElse(null);
    }
}
