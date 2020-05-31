package com.shubham.spring.REST.webservices.SpringRESTDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemoApplication.class, args);
	}

	@Bean   //Configuring a bean through @Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver(); //Creating a localeResolver object for the session

		sessionLocaleResolver.setDefaultLocale(Locale.US);  //Setting up a default locale, in case a locale is not given

		return sessionLocaleResolver;  //Returning back a localeResolver
	}

	@Bean  //Bean to read and configure the messages properties defined according to the header passed
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("messages");

		return messageSource;
	}

}
