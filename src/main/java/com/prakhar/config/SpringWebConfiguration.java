package com.prakhar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.ViewResolver;

@Configuration
@ComponentScan(basePackages="com.prakhar")
@EnableWebMvc

public class SpringWebConfiguration {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/jsps/", ".jsp");
		return viewResolver;
	}

}
