package org.com.shopcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.com.vo.Dept;

/**
 * 持久化层接口
 * 注解@Mapper
 * @author heyayun
 *
 */
@Mapper
public interface IDeptDao {
	public boolean doCreate(Dept vo) ;
	public Dept findById(Long id) ;
	public List<Dept> findAll() ;
}
