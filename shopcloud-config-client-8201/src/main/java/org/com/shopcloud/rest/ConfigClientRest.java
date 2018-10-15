package org.com.shopcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConfigClientRest {
	@Value("${spring.application.name}")
	private String applicationName;//应用名称
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;//所以Eureka服务信息项
	@RequestMapping("config")
	public String getConfig() {
		return "ApplicationName = " + applicationName +" 、EurekaServers = " + eurekaServers;
	}
}
