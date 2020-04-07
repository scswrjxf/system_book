package com.book.dao;

import com.book.pojo.Category;

public interface CategoryMapper {
	/**
	 * 根据分类名称查找图书分类
	 * @param name
	 * @return 找到返回图书分类对象 失败返回null
	 */
	Category findCategoryByName(String name);
	/**
	 * 添加新的图书分类
	 * @param name
	 * @return 1-成功 0-失败
	 */
	int addNewCategory(String name);
}





