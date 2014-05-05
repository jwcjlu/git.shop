package com.rd.shop.service.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rd.shop.service.base.DaoSupport;
import com.rd.shop.service.base.ProductService;
@Service
@Transactional
public class ProductServiceBean extends DaoSupport implements ProductService  {

	@Override
	public <T> void delete(Class<T> entityClass, Object[] entityIds) {
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<entityIds.length;i++){
			sb.append("?").append(i+2).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		Query query=	em.createQuery("update ProductType p set p.visible=?1 where o.typeid in"+sb.toString());
		query.setParameter(1, false);
		for(int i=0;i<entityIds.length;i++){
			query.setParameter(i+2, entityIds[i]);
		}
		query.executeUpdate();
	}
	

	

}
