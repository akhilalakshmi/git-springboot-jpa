package com.example.securityassignment.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan
public class ViewResolverConfiguration implements WebMvcConfigurer {
	@Override
	  public void configureViewResolvers(ViewResolverRegistry registry) {
	      registry.jsp("/WEB-INF/view/", ".jsp");
	  }

	  @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	      registry.addViewController("/").setViewName("login");	      
	      registry.addViewController("/login").setViewName("login");
	     // registry.addViewController("/404").setViewName("error/404");
	  }

}
