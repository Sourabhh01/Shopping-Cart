package com.jsp.Shppingcart.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages = "com")
@Configuration
	public class ConfigClass {

	@Bean
	public InternalResourceViewResolver resolver(){
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setSuffix(".jsp"); //setsuffix specifies the view technology
	    resolver.setPrefix("/");  //setprefix specifies the location of the view file

	    return resolver;
	  }
	@Bean 
	public EntityManagerFactory getEmf() {
		return Persistence.createEntityManagerFactory("dev");
	}
}
