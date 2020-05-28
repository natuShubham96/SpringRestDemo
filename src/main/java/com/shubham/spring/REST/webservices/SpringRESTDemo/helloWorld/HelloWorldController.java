package com.shubham.spring.REST.webservices.SpringRESTDemo.helloWorld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")  //Instead of RequestMapping we could use GetMapping annotation with whivh we don't require to pass method, we on;y need path with it
    public String helloWorld() {
        return "Hello World!!!";   //Returning a  hard coaded String
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");  //Returning a bean, bean is automatically converted to JSON format
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }
}
