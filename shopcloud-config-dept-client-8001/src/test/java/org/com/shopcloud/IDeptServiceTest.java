package org.com.shopcloud;

import javax.annotation.Resource;

import org.com.shopcloud.service.IDeptService;
import org.com.vo.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
/**
 * 测试类
 * 测试目标项目启动类@SpringBootTest(classes=App.class)
 * @author heyayun
 *
 */
@SpringBootTest(classes=App.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IDeptServiceTest{
	@Resource
	private IDeptService deptService;
	@Test
	public void testGet() {
		System.out.println(this.deptService.get(1));
	}
	
	@Test
	public void testAdd() {
		Dept dept = new Dept() ;
		dept.setDname("测试部-" + System.currentTimeMillis());
		System.out.println(this.deptService.add(dept)); 
	}

	@Test
	public void testList() {
		System.out.println(this.deptService.list());
	}
}
