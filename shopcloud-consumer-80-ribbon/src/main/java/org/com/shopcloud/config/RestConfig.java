package org.com.shopcloud.config;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	@Bean
	public HttpHeaders getHeaders() {//要进行一个Http头信息配置
		HttpHeaders headers = new HttpHeaders();//定义一个HTTP的头信息
		String auth = "shopjava:hello";//认证的原始信息
		byte[] encodeAuth = Base64.getEncoder()
				.encode(auth.getBytes(Charset.forName("US-ASCII")));
		//在授权头信息Basic后面空格注意
		String authHeader = "Basic " + new String(encodeAuth);
		headers.set("Authorization", authHeader);
		return headers;
	}
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
