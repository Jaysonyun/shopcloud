package org.com.shopcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.com.vo.Dept;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerDeptController {
	public static final String DEPT_GET_URL = "http://SHOPCLOUD-PROVIDER-DEPT/dept/get/";
	public static final String DEPT_LIST_URL = "http://SHOPCLOUD-PROVIDER-DEPT/dept/list/";
	public static final String DEPT_ADD_URL = "http://SHOPCLOUD-PROVIDER-DEPT/dept/add";
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
		Dept dept = restTemplate
		.exchange(DEPT_GET_URL + id, HttpMethod.GET,
				new HttpEntity<Object>(this.headers),Dept.class).getBody();
		return dept;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public Object listDept() {
		List<Dept> allDepts = restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET,
				new HttpEntity<Object>(this.headers),List.class).getBody();
		return allDepts;
	}
	@RequestMapping(value = "/consumer/dept/add")
	public Object addDept(Dept dept) throws Exception {
		Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST,
				new HttpEntity<Object>(dept, this.headers), Boolean.class)
				.getBody();
		return flag;
	}
}
