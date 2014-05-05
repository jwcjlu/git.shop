package com.rd.shop.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rd.shop.entity.Book;
import com.rd.shop.entity.BookType;
import com.rd.shop.service.BookService;


@Service
@Transactional
public class BookServiceBean implements BookService  {
	@PersistenceContext EntityManager em;
	public void save(Book b){
		em.persist(b);
		
	}
	@Override
	public void save(BookType bt) {
		// TODO Auto-generated method stub
		em.persist(bt);
		
	}

}
