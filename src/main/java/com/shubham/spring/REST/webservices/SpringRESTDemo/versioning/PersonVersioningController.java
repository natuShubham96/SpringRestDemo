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

    @GetMapping(value = "person/header", headers = "X-API-VERSION=1") //Versioning through request header
    public PersonV1 headerV1() {
        return new PersonV1("Shubham Natu");
    }

    @GetMapping(value="person/header",headers = "X-API-VERSION=2") //Versioning through request header
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Shubham","Natu"));
    }

    @GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json") //Versioning through request produces
    public PersonV1 producesV1() {
        return new PersonV1("Shubham Natu");
    }

    @GetMapping(value="person/produces",produces = "application/vnd.company.app-v2+json") //Versioning through request produces
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Shubham","Natu"));
    }
}
