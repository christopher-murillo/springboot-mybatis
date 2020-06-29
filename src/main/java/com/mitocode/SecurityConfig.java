package com.mitocode;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**","/js/**","/vendors/**")
		.permitAll()
		.anyRequest().authenticated()
		.and()
				// .httpBasic();
				.formLogin().loginPage("/login").defaultSuccessUrl("/especialidades", true).permitAll();
	}

}
