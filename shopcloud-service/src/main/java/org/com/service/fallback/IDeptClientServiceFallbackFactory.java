package org.com.service.fallback;

import java.util.List;

import org.com.service.IDeptClientService;
import org.com.vo.Dept;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
@Component
public class IDeptClientServiceFallbackFactory implements FallbackFactory<IDeptClientService>{

	@Override
	public IDeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new IDeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(long id) {
				Dept vo = new Dept();
				vo.setDeptno(8888L);
				vo.setDname("【ERRER】shopcloud-Dept-Hystrix");//错误提示
				vo.setLoc("Dept-provider");
				return vo;
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
