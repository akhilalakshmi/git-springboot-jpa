package com.example.securityassignment.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.securityassignment.repository.UserRepository;
import com.example.securityassignment.service.CustomUserDetailsService;
import com.example.securityassignment.service.InterfaceCustomUserDetailsService;
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private InterfaceCustomUserDetailsService icustomuserservice;


		@Override
	    protected void configure(HttpSecurity http) throws Exception {
			
		System.out.println("in configure****************");
			http
			.authorizeRequests()
			.antMatchers("/login","/register").permitAll()
			.antMatchers("/admin/**").authenticated()
			.anyRequest().permitAll().and()
			.formLogin().loginPage("/login").permitAll()
	        .defaultSuccessUrl("/user/success").and()
	        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
	        .and().exceptionHandling().accessDeniedPage("/error/msg")
	        .and().csrf().disable();
/*
	        http.csrf().disable();
	        http.authorizeRequests()
	                .antMatchers("/user/**").authenticated()
	                .anyRequest().permitAll()
	                .and()
	                .formLogin().permitAll();*/
	    }
		@Bean 
	    public PasswordEncoder getPasswordEncoder() {
	    	System.out.println("passwordencoder*********");
	        return new PasswordEncoder() {
	            @Override
	            public String encode(CharSequence charSequence) {
	                return charSequence.toString();
	            }

	            @Override
	            public boolean matches(CharSequence charSequence, String s) {
	                return true;
	            }
	        };
	    }
		 @Override
		    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			 System.out.println("in configure  authentication//////////////////////");
			 auth.userDetailsService(icustomuserservice)
			 .passwordEncoder(getPasswordEncoder());
		 }
		 
		/*@Bean
	    public BCryptPasswordEncoder getPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
*/
}

