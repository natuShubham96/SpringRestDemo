package com.shubham.spring.REST.webservices.SpringRESTDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //Since this is a configuration file
@EnableSwagger2  //To enable swagger
public class SwaggerConfig {

    @Bean
    public Docket api() {   //Bean to specify documentation type
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
