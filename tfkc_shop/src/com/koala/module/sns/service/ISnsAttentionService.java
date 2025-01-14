﻿package com.koala.module.sns.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.koala.core.query.support.IPageList;
import com.koala.core.query.support.IQueryObject;
import com.koala.module.sns.domain.SnsAttention;



public interface ISnsAttentionService {
	/**
	 * 保存一个SnsAttention，如果保存成功返回true，否则返回false
	 * 
	 * @param instance
	 * @return 是否保存成功
	 */
	boolean save(SnsAttention instance);
	
	/**
	 * 根据一个ID得到SnsAttention
	 * 
	 * @param id
	 * @return
	 */
	SnsAttention getObjById(Long id);
	
	/**
	 * 删除一个SnsAttention
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Long id);
	
	/**
	 * 批量删除SnsAttention
	 * 
	 * @param ids
	 * @return
	 */
	boolean batchDelete(List<Serializable> ids);
	
	/**
	 * 通过一个查询对象得到SnsAttention
	 * 
	 * @param properties
	 * @return
	 */
	IPageList list(IQueryObject properties);
	
	/**
	 * 更新一个SnsAttention
	 * 
	 * @param id
	 *            需要更新的SnsAttention的id
	 * @param dir
	 *            需要更新的SnsAttention
	 */
	boolean update(SnsAttention instance);
	/**
	 * 
	 * @param query
	 * @param params
	 * @param begin
	 * @param max
	 * @return
	 */
	List<SnsAttention> query(String query, Map params, int begin, int max);
}
