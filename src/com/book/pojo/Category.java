package com.book.pojo;

public class Category {
	private Integer id;
	private String category;
	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + "]";
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Integer id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
