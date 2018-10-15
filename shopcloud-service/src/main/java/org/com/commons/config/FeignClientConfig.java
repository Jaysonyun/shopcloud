package org.com.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.Logger.Level;
import feign.auth.BasicAuthRequestInterceptor;
@Configuration
public class FeignClientConfig {
	@Bean
	public Logger.Level getFeigoLoggerLevel(){
		return Level.FULL;
	}
	@Bean
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
		//直接访问
		//return new BasicAuthRequestInterceptor("shopjava", "hello");
		//访问zuul的用户名和密码
		return new BasicAuthRequestInterceptor("zdmin", "shopjava");
	}
}
