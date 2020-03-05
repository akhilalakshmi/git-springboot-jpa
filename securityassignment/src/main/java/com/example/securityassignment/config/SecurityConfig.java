package com.example.securityassignment.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.securityassignment.repository.UserRepository;
import com.example.securityassignment.service.CustomUserDetailsService;
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService)
		 .passwordEncoder(getPasswordEncoder());
	 }
	 

		@Override
	    protected void configure(HttpSecurity http) throws Exception {
			
		
			http
			.authorizeRequests()
			.antMatchers("/login").permitAll()
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
	    
	    private PasswordEncoder getPasswordEncoder() {
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
		
		/*@Bean
	    public BCryptPasswordEncoder getPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
*/
}

