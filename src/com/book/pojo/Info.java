package com.book.pojo;

public class Info {
	private Integer id;
	private String bookName;
	private String author;
	private String publisher;
	private Double price;
	private Category bookCategory;
	private String bphoto;
	public Info() {}
	public Info(Integer id, String bookName, String author, String publisher, double price,
			Category bookCategory) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.bookCategory = bookCategory;
	}
	public Info(Integer id, String bookName, String author, String publisher, Double price,
			Category bookCategory, String bphoto) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.bookCategory = bookCategory;
		this.bphoto = bphoto;
	}
	public String getBphoto() {
		return bphoto;
	}
	public void setBphoto(String bphoto) {
		this.bphoto = bphoto;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Category getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(Category bookCategory) {
		this.bookCategory = bookCategory;
	} 
}
