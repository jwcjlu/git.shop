package com.rd.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="book")
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2636369362805790166L;
	@Id
	@GeneratedValue()
	private int id;
	
	private String name;
	private float price;
	private float discount;
	private String note;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=20,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(nullable=false)
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	@Column(length=200,nullable=false)
	public String getNote(){
		return note;
	}
	public void setNote(String note){
		this.note=note;
	}
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", discount=" + discount + ", note=" + note+ "]";
	}
	

}
