package com.rd.shop.service.base;

public interface DAO {
	/**
	 * 
	 * @param entity
	 */
	public void save(Object entity);
	/**
	 * 
	 * @param classentity
	 * @param entityId
	 * @return
	 */
	public<T> T find(Class<T> entityClass,Object entityId);
	/**
	 * 
	 * @param entity
	 */
	public void update(Object entity);
	/**
	 * 
	 * @param entityId
	 */
	public <T>void delete(Class<T> entityClass,Object entityId);
	/**
	 * 
	 * @param entityIds
	 */
	public <T>void delete(Class<T> entityClass,Object []entityIds);

}
