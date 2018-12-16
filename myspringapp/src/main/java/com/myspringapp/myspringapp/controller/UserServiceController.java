package com.myspringapp.myspringapp.controller;

import com.myspringapp.myspringapp.model.User;
import com.myspringapp.myspringapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserServiceController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable String id) {
        return service.deleteUser(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        return service.getUser(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return service.listUsers();
    }

}
