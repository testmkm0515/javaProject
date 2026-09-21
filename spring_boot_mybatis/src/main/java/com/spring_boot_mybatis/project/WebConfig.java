package com.spring_boot_mybatis.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/prd_images/**")
		.addResourceLocations("file:///E:/hy9/springBootWorkspace/upload/product_image/");		
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///E:/hy9/springBootWorkspace/upload/");
	}
}
