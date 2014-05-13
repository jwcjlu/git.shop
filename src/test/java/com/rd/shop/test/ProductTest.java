package com.rd.shop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rd.shop.entity.ProductType;
import com.rd.shop.service.base.ProductService;
public class ProductTest {
	private static  ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
	@SuppressWarnings("unused")
	private static ProductService ps=(ProductService) act.getBean("productServiceBean");
	
	
	
	@Test
	public void insertProduct(){
		ProductService ps=(ProductService) act.getBean("productServiceBean");
		for(int i=0;i<20;i++){
		ProductType productType=new ProductType();
		productType.setName("篮球用品");
		productType.setNote(i+"好篮球");
		ps.save(productType);
		}
	
		}
		@Test
		public void getPageData(){
			
		
				
	}
}
