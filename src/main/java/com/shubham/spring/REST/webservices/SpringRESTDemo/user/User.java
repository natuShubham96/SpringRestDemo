package com.shubham.spring.REST.webservices.SpringRESTDemo.user;

import java.util.Date;

public class User {

    private Integer id;
    private String name;
    private Date DOB;

    public User(Integer id, String name, Date DOB) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
}
