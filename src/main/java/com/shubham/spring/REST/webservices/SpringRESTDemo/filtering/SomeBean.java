package com.shubham.spring.REST.webservices.SpringRESTDemo.filtering;

//@JsonIgnoreProperties(value = {"field1","field2"}) //Another way of ignoring the fields
//This is only required for static filtering, dynamic filtering is done in controller file

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("someBean")  //Specifying that, a filter named someBean, needs to be applied on this bean
public class SomeBean {

    private String field1;
    private String field2;

//    @JsonIgnore  //Will not be displayed in response body, every instance will not have this filed
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
