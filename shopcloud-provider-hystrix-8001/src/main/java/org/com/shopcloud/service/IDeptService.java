package org.com.shopcloud.service;

import java.util.List;

import org.com.vo.Dept;
/**
 * 逻辑层接口
 * @author heyayun
 *
 */
public interface IDeptService {
	public Dept get(long id) ;
	public boolean add(Dept dept) ;
	public List<Dept> list() ;
}
