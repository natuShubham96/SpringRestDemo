package com.shubham.spring.REST.webservices.SpringRESTDemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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

        User user = userdao.findOne(id);

        if(user == null) {
            throw new UserNotFoundException("id-"+id);  // This gives status of 55 internal server not found, which is not correct, we want 404 error status
        }
        return userdao.findOne(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity addUser(@Valid  @RequestBody User user) {
        User savedUser = userdao.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

        //Last 2 steps are done to return the response and set the location of returned user
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userdao.deleteById(id);

        if(user == null) {
            throw new UserNotFoundException("id-"+id);
        }
    }

}
