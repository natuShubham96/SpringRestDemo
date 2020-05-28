package com.shubham.spring.REST.webservices.SpringRESTDemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity addUser(@RequestBody User user) {
        User savedUser = userdao.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

        //Last 2 steps are done to return the response and set the location of returned user
    }

}
