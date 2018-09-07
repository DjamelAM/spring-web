package com.formation.servlet.view;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.formation.web.config.WebConfig;

public class ViewWebApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebConfig.class);
		servletContext.addListener(new ContextLoaderListener(webContext));

		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(webContext);
		ServletRegistration.Dynamic registration = servletContext.addServlet("view", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/humancontact/*");
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("utf8­encoding",
				new CharacterEncodingFilter("UTF-8", true));

		encodingFilter.addMappingForUrlPatterns(null, false, "/*");

	}
}