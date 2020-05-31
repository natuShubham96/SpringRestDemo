package com.shubham.spring.REST.webservices.SpringRESTDemo.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;  //Autowiring in the MessageSource returned from the bean in main class

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

//    @GetMapping(path = "/hello-world/I18N")
//    public String helloworldI18N(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {  //Taking in the requested language from the header
//        return messageSource.getMessage("good.morning.message",null,locale);  //Displaying in the message from passed Locale
//    }

    @GetMapping(path = "/hello-world/I18N")
    public String helloworldI18N() {  //Taking in the requested language from the header
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());  //Instead of getting locale from request header, reading the locale from LocaleContextHolder
    }
}
