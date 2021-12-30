package com.hieu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class ConfigApplication {
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver Resolver = new InternalResourceViewResolver();
		Resolver.setPrefix("/WEB-INF/views/");
		Resolver.setSuffix(".jsp");
		return Resolver;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		return multipartResolver;
	}
	
	@Bean
	public Cloudinary cloudinary() {
		Cloudinary c = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","k63atttvnua",
				"api_key","938581176843522",
				"api_secret","jwowXsPn0NY0kt8ecQiwfP-TLVQ",
				"secure",true
				));
		return c;
	}
}
