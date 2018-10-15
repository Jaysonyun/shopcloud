package org.com.service;

import java.util.List;

import org.com.commons.config.FeignClientConfig;
import org.com.service.fallback.IDeptClientServiceFallbackFactory;
import org.com.vo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//直接访问服务
//@FeignClient(value="SHOPCLOUD-PROVIDER-DEPT",configuration=FeignClientConfig.class,fallbackFactory=IDeptClientServiceFallbackFactory.class)
//通过zuul代理访问
@FeignClient(value="SHOPCLOUD-ZUUL-GATEWAY",configuration=FeignClientConfig.class,fallbackFactory=IDeptClientServiceFallbackFactory.class)
public interface IDeptClientService {
	//直接访问服务
	//@RequestMapping(method=RequestMethod.GET,value="/dept/get/{id}")
	//通过zuul代理访问
	@RequestMapping(method=RequestMethod.GET,value="/shop-proxy/dept-proxy/dept/get/{id}")
	public Dept get(@PathVariable("id") long id);
	//直接访问服务
	//@RequestMapping(method=RequestMethod.GET,value="/dept/list")
	//通过zuul代理访问
	@RequestMapping(method=RequestMethod.GET,value="/shop-proxy/dept-proxy/dept/list")
	public List<Dept> list();
	//直接访问服务
	//@RequestMapping(method=RequestMethod.POST,value="/dept/add")
	//通过zuul代理访问
	@RequestMapping(method=RequestMethod.POST,value="/shop-proxy/dept-proxy/dept/add")
	public boolean add(Dept dept);
}
