package com.rd.shop.service.base;

import java.util.LinkedHashMap;

import com.rd.shop.bean.QueryResult;

public interface DAO {
	/**
	 * 增加实体内容
	 * @param entity
	 */
	public void save(Object entity);
	/**
	 * 根据实体id查找实体内容
	 * @param classentity
	 * @param entityId
	 * @return
	 */
	public<T> T find(Class<T> entityClass,Object entityId);
	/**
	 * 修改实体内容
	 * @param entity
	 */
	public void update(Object entity);
	/**
	 * 根据id删除一个实体
	 * @param entityId
	 */
	public <T>void delete(Class<T> entityClass,Object entityId);
	/**
	 * 删除多个实体
	 * @param entityIds
	 */
	public <T>void delete(Class<T> entityClass,Object []entityIds);
	/**
	 * 有排序的有过滤添加的分页查询
	 * @param entityClass
	 * @param firstIndex
	 * @param resultMax
	 * @param wheresql
	 * @param params
	 * @param orderby
	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass,int firstIndex,
			int resultMax,String wheresql,Object[]params,LinkedHashMap<String,String>orderby);
	/**
	 * 有过滤条件的分页查询
	 * @param entityClass
	 * @param firstIndex
	 * @param resultMax
	 * @param wheresql
	 * @param params
	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass,int firstIndex,
			int resultMax,String wheresql,Object[]params);

	/**
	 * 有排序的分页查询
	 * @param entityClass
	 * @param firstIndex
	 * @param resultMax
	 * @param orderby
	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass,int firstIndex,
			int resultMax,LinkedHashMap<String,String>orderby);
	/**
	 * 分页查询
	 * @param entityClass
	 * @param firstIndex
	 * @param resultMax
	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass,int firstIndex,
			int resultMax);
	/**
	 * 查询所有记录
	 * @param entityClass

	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass);

}
