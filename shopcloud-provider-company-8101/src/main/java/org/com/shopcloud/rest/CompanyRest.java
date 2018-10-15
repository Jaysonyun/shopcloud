package org.com.shopcloud.rest;

import org.com.vo.Company;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CompanyRest {
	
	@RequestMapping(value="company/get/{title}",method=RequestMethod.GET)
	@HystrixCommand   // 如果需要性能监控，那么必须需要此注解
	public Object get(@PathVariable("title")String title) {
		Company vo = new Company();
		vo.setTitle(title);
		vo.setNote("www.shop.com");
		return vo;
	}	
		
}
