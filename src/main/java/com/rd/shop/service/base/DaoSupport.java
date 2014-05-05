package com.rd.shop.service.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public abstract class DaoSupport implements DAO{
	@PersistenceContext protected  EntityManager em;

	@Override
	public void save(Object entity) {
		// TODO Auto-generated method stub
		em.persist(entity);
		
	}

	@Override
	@Transactional(readOnly=true ,propagation=Propagation.NOT_SUPPORTED)
	public <T> T find(Class<T> entityClass, Object entityId) {
		// TODO Auto-generated method stub
		return em.find(entityClass, entityId);
	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		em.merge(entity);
	
		
	}

	@Override
	public <T> void delete(Class<T> entityClass,Object entityId) {
		// TODO Auto-generated method stub
		delete(entityClass,new Object[]{entityId});
	}

	@Override
	public <T>void delete(Class<T> entityClass,Object[] entityIds) {
		// TODO Auto-generated method stub
		for(Object id:entityIds){
			em.remove(em.getReference(entityClass, id));
		}
		
	}

}
