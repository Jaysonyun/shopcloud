package org.com.shopcloud.rest;

import javax.annotation.Resource;

import org.com.shopcloud.service.IDeptService;
import org.com.vo.Dept;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptRest {
	@Resource
	private IDeptService deptService;
	
	@RequestMapping(value="dept/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="getFallback")
	public Object get(@PathVariable("id")Long id) {
		Dept vo = deptService.get(id);
		if(vo==null) {
			throw new RuntimeException("部门信息不存在！");
		}
		return vo;
	}
	public Object getFallback(@PathVariable("id")Long id) {//此方法的参数与get一致
		Dept vo = new Dept();
		vo.setDeptno(9999L);
		vo.setDname("【ERRER】shopcloud-Dept-Hystrix");//错误提示
		vo.setLoc("Dept-provider");
		return vo;
	}
	
	
	
}
