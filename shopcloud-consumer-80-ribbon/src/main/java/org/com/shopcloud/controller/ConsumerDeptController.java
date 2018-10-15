package org.com.shopcloud.controller;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;

import org.com.commons.config.MyLoadBalanceConfig;
import org.com.vo.Dept;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name="shopcloud-provider-dept",configuration=MyLoadBalanceConfig.class)
public class ConsumerDeptController {
	public static final String DEPT_REST_TOPIC = "microcloud-provider-dept";
	@Resource
	private RestTemplate restTemplate;
	@Resource
	private HttpHeaders headers;
	@Resource
	private LoadBalancerClient loadBalancerClient;
	
	@RequestMapping(value="/consumer/dept/get")
	public Object getDept(Long id) {
		ServiceInstance serviceInstance = loadBalancerClient.choose("SHOPCLOUD-PROVIDER-DEPT");
		System.out.println("***serviceInstance***"+serviceInstance.getHost());
		System.out.println("***port***"+serviceInstance.getPort());
		System.out.println("***sId***"+serviceInstance.getServiceId());
		System.out.println("***uri***"+serviceInstance.getUri());
		URI deptUri = URI.create(String.format("http://%s:%s/dept/get/" + id,
				serviceInstance.getHost(), serviceInstance.getPort()));
		Dept dept = restTemplate
		.exchange(deptUri, HttpMethod.GET,
				new HttpEntity<Object>(this.headers),Dept.class).getBody();
		return dept;
	}
}
