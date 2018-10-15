package org.com.shopcloud.controller;


import javax.annotation.Resource;
import org.com.service.IDeptClientService;
import org.com.vo.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerDeptController {
	@Resource
	private IDeptClientService deptService;
	
	@RequestMapping(value="/consumer/dept/get")
	public Object getDept(Long id) {
		return deptService.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public Object listDept() {
		return deptService.list();
	}
	@RequestMapping(value = "/consumer/dept/add")
	public Object addDept(Dept dept) throws Exception {
		return deptService.add(dept);
	}
}
