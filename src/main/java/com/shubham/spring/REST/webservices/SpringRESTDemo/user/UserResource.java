package com.shubham.spring.REST.webservices.SpringRESTDemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UsedDao userdao;

    @GetMapping(path = "/users")
    public List<User> retriveAll() {
        return userdao.getAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retriveOne(@PathVariable int id) {
        return userdao.findOne(id);
    }

    @PostMapping(path = "/users")
    public void addUser(@RequestBody User user) {
        userdao.save(user);
    }

}
