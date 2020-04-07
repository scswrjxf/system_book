package com.book.pojo;
public class Goods {
	private Integer bookId;
	private String bookName;
	private Double price;
	private Integer numbers;
	public Goods() {}
	public Goods(Integer bookId, String bookName, Double price, Integer numbers) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.numbers = numbers;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNumbers() {
		return numbers;
	}
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
}
