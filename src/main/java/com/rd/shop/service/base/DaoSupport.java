package com.rd.shop.service.base;

import java.util.LinkedHashMap;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rd.shop.bean.QueryResult;

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
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public <T> QueryResult<T> getPageingData(Class<T> entityClass,int fristResult, int maxResult,String wheresql,Object[]params,
			LinkedHashMap<String,String>orderby) {
		// TODO Auto-generated method stub
		QueryResult<T>qr=new QueryResult<T>();
		String tableName=getTableName(entityClass);
		Query query =em.createQuery("select * from "+tableName+"o "+(wheresql==null?"":wheresql));
		if(fristResult!=-1)query.setFirstResult(fristResult);
		if(maxResult!=-1)query.setMaxResults(maxResult);
		setQueryParam(query,params);
		qr.setResultList(query.getResultList());
		query =em.createQuery("select count(*) from "+tableName+"o "+(wheresql==null?"":wheresql));
		setQueryParam(query,params);
		qr.setResultTotal((Long) query.getSingleResult());
		return qr;
	}
	@Override
	public <T> QueryResult<T> getPageingData(Class<T> entityClass,
			int firstIndex, int resultMax, String wheresql, Object[] params) {
		// TODO Auto-generated method stub
		return getPageingData(entityClass,firstIndex,resultMax,wheresql,params,null);
	}

	@Override
	public <T> QueryResult<T> getPageingData(Class<T> entityClass,
			int firstIndex, int resultMax, LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return getPageingData(entityClass,firstIndex,resultMax,null,null,orderby);
	}

	@Override
	public <T> QueryResult<T> getPageingData(Class<T> entityClass,
			int firstIndex, int resultMax) {
		// TODO Auto-generated method stub
		return getPageingData(entityClass,firstIndex,resultMax,null,null,null);
	}

	@Override
	public <T> QueryResult<T> getPageingData(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return getPageingData(entityClass,-1,-1);
	}

	protected void setQueryParam(Query query,Object[]params){
		if(!(params==null||params.length<0)){
			for(int i=0;i<params.length;i++){
				query.setParameter(i+1, params[i]);
			}
			
		}
		
	}
	protected String buildOrderby(LinkedHashMap<String,String>orderby){
		StringBuffer orderbysql=new StringBuffer("");
		if(orderby!=null&&orderby.size()>0){
			orderbysql.append("order by ");
			for(String key:orderby.keySet()){
				orderbysql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			orderbysql.deleteCharAt(orderbysql.length()-1);
		}
		return orderbysql.toString();
	}

	public <T>String getTableName(Class<T> entityClass){
		String tableName=entityClass.getSimpleName();
		Entity entity=entityClass.getAnnotation(Entity.class);
		if(entity.name()==null&&entity.name().equals("")){
			tableName=entity.name();
		}
		return tableName;
		
	}

}
