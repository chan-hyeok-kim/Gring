package com.cha.ing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileMappginConfiguration implements WebMvcConfigurer {

	@Value("${app.upload.mapping}")
	private String filePath;
	
	@Value("${app.url.path}")
	private String urlPath;
	
}
