package com.shubham.spring.REST.webservices.SpringRESTDemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserResource {

    @Autowired
    private UsedDao userdao;

    @GetMapping(path = "/users")
    public List<User> retriveAll() {
        return userdao.getAll();
    }

    @GetMapping(path = "/users/{id}")
    public Resource<User> retriveOne(@PathVariable int id) {

        User user = userdao.findOne(id);

        if(user == null) {
            throw new UserNotFoundException("id-"+id);  // This gives status of 55 internal server not found, which is not correct, we want 404 error status
        }

        Resource<User> resource = new Resource<User>(user); //Creating a Resource to which the link will be added

        ControllerLinkBuilder linkto = ControllerLinkBuilder.linkTo(methodOn(this.getClass()).retriveAll()); //Creating a link for the resource which needs to be added with the help of it's method

        resource.add(linkto.withRel("all-users")); //Adding the link to the resource and giving the name by which it should be displayed with the help of withRel

        return resource;
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
