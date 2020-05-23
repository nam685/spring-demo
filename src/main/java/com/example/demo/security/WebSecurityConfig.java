package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			 .antMatchers("/").permitAll()
			 .antMatchers("/user").hasAuthority("ROLE_ADMIN")
			 .anyRequest().authenticated()
			 .and()
			.formLogin()
	         .loginPage("/login")
	         .permitAll()
	         .and()
	        .logout()
	         .permitAll()
	         .and()
	        .httpBasic();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
	    return new MyDatabaseUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
