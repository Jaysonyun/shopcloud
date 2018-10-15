package org.com.shopcloud.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.com.shopcloud.dao.IDeptDao;
import org.com.shopcloud.service.IDeptService;
import org.com.vo.Dept;
import org.springframework.stereotype.Service;
/**
 * 逻辑层实现类
 * 注释@Service
 * 注入dao层
 * @author heyayun
 *
 */
@Service
public class DeptServiceImpl implements IDeptService {
	@Resource
	private IDeptDao deptDao;
	@Override
	public Dept get(long id) {
		return deptDao.findById(id);
	}

	@Override
	public boolean add(Dept dept) {
		return deptDao.doCreate(dept);
	}

	@Override
	public List<Dept> list() {
		return deptDao.findAll();
	}

}
