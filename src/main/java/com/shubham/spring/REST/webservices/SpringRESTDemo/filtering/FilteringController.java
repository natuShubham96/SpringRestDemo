package com.shubham.spring.REST.webservices.SpringRESTDemo.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean someBean = new SomeBean("value1","value2","value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2"); //Specifying the fields which needs to be shown, SimpleBeanPropertyFilter is abstract class

        FilterProvider filters = new SimpleFilterProvider().addFilter("someBean",filter); //Adding in the filter, someBean is the name of the filter

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);  //mapping to the bean

        mapping.setFilters(filters);  //Setting up the filter

        return mapping;
    }

    @GetMapping(path = "/filtering-list")
    public MappingJacksonValue getListOfBeans() {
        List<SomeBean> list = Arrays.asList(new SomeBean("Value1","Value2","value3"),new SomeBean("value 12","value 22","value 32"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");

        FilterProvider filters = new SimpleFilterProvider().addFilter("someBean",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);

        mapping.setFilters(filters);

        return mapping;
    }
}
