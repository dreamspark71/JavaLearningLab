package com.fireduptech.springDemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApplicationConfiguration extends WebMvcConfigurerAdapter  {

	/**
	 * This class will contain the configurations related to the application context.
	 *
	 * Eg. Use it in static cases when there is no Java controller logic to execute before the view generates the response.
	 * An example of forwarding a request for "/" to a view called "home" in Java:
	 * @ Override
   * public void addViewControllers(ViewControllerRegistry registry) {
   *    registry.addViewController("/").setViewName("home");
   *  }
   * http://docs.spring.io/spring/docs/4.0.0.RELEASE/spring-framework-reference/htmlsingle/#mvc-container-config
	 */






}