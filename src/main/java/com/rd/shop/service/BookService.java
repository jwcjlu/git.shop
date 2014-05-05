package com.rd.shop.service;

import com.rd.shop.entity.Book;
import com.rd.shop.entity.BookType;

public interface BookService {
	public void save(Book b);
	public void save(BookType bt);
}