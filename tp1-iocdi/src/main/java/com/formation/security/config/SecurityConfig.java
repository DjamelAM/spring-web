package com.formation.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserBuilder builder = User.withDefaultPasswordEncoder();
		UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		userDetailsManager.createUser(builder.username("admin").password("admin").roles("ADMIN", "USER").build());
		userDetailsManager.createUser(builder.username("user").password("user").roles("USER").build());
		return userDetailsManager;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().antMatchers("/ihm/**").authenticated().antMatchers("/ihm/**").hasAnyRole("ADMIN").and()
		// .formLogin().permitAll().and().logout().logoutUrl("/ihm/logout").logoutSuccessUrl("/ihm/home");
		http.authorizeRequests().antMatchers("/humancontact/**").authenticated().antMatchers("/humancontact/home")
				.permitAll().antMatchers("/humancontact/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/humancontact/user/**").hasAnyRole("USER").and().formLogin().and().logout()
				.logoutUrl("/humancontact/logout").logoutSuccessUrl("/humancontact/home");
	}
}
