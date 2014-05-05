package com.rd.shop.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rd.shop.entity.Book;
import com.rd.shop.entity.BookType;
import com.rd.shop.service.BookService;

public class BookTest {
	@Test
	public void insertbook(){
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		DataSource dataSource=(DataSource) act.getBean("dataSource");
		BookService bs=(BookService) act.getBean("bookServiceBean");
		System.out.println(dataSource);
		Book b=new Book();
		b.setNote(" Tingqing university  press");
		b.setDiscount(0.75f);
		b.setName("Java classics)");
		b.setPrice(100f);
		bs.save(b);
		bs.save(new BookType());

		
	}

}
