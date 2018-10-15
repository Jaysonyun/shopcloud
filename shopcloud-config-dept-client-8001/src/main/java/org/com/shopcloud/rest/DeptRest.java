package org.com.shopcloud.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.com.shopcloud.service.IDeptService;
import org.com.vo.Dept;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptRest {
	@Resource
	private IDeptService deptService;
	@Resource
	private DiscoveryClient client;
	@RequestMapping(value="dept/discover")
	public Object discover() {
		return this.client;
	}
	@RequestMapping(value="dept/sessionId")
	public Object id(HttpServletRequest request) {
		return request.getSession().getId();
	}
	@RequestMapping(value="dept/get/{id}",method=RequestMethod.GET)
	public Object get(@PathVariable("id")Long id) {
		return deptService.get(id);
	}
	@RequestMapping(value="dept/add",method=RequestMethod.GET)
	public Object add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public Object list() {
		return this.deptService.list() ;
	}
}
