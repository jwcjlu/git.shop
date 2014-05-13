package com.rd.shop.bean;

import java.util.List;

public class QueryResult<T> {
	private List<T> resultList;
	private Long resultTotal;
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public Long getResultTotal() {
		return resultTotal;
	}
	public void setResultTotal(Long resultTotal) {
		this.resultTotal = resultTotal;
	}
	
	

}
