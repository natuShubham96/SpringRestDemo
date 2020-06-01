package com.shubham.spring.REST.webservices.SpringRESTDemo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person") //Versioning through seperate URI
    public PersonV1 personV1() {
        return new PersonV1("Shubham Natu");
    }

    @GetMapping("v2/person") //Versioning through seperate URI
    public PersonV2 personV2() {
        return new PersonV2(new Name("Shubham","Natu"));
    }

    @GetMapping(value = "person/param", params = "Version=1") //Versioning through request param
    public PersonV1 paramV1() {
        return new PersonV1("Shubham Natu");
    }

    @GetMapping(value="person/param",params = "Version=2") //Versioning through request param
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Shubham","Natu"));
    }
}
