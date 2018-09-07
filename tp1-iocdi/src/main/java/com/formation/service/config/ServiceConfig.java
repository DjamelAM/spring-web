package com.formation.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.formation.AppConfig;
import com.formation.controller.service.AdminRestController;

@Configuration
@Import(AppConfig.class)
@EnableWebMvc
@ComponentScan(basePackageClasses = { AdminRestController.class })
public class ServiceConfig implements WebMvcConfigurer {

	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.enableContentNegotiation(new MappingJackson2JsonView());

	}
}
