package com.rd.shop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="type")
public class BookType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1962540168351959016L;
	@Id
	@GeneratedValue()
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "BookType [id=" + id + "]";
	}
	
	

}
