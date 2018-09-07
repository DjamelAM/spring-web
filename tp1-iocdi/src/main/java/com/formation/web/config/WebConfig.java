package com.formation.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.formation.controller.view.HelloWorldController;
import com.formation.security.config.SecurityConfig;

@Configuration
@Import(SecurityConfig.class)
@EnableWebMvc
@ComponentScan(basePackageClasses = { HelloWorldController.class })
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.jsp("/WEB-INF/views/", ".jsp");

	}

}
