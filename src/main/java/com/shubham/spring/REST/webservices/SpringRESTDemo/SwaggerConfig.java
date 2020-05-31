package com.shubham.spring.REST.webservices.SpringRESTDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration //Since this is a configuration file
@EnableSwagger2  //To enable swagger
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Shubham Natu","https://github.com/natuShubham96/SpringRestDemo","natushubham96@gmail.com"); //This is the contact info, here. first arg is name, second is url, third is e-mail id

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title","Awesome API Documentation","1.0","urn:tos",DEFAULT_CONTACT,"Apache 2.0","http://www.apache.org/licenses/LICENSE-2.0");
//This is the api info, here, first arg is title, second is description, third is version, fourth is terms of services url, fifth is contact info created above, sixth is license, seventh is license url

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));
//Configuring produces and consumes values

    @Bean
    public Docket api() {   //Bean to specify documentation type
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES); //.apiInfo() for changing the api info
    }
}
