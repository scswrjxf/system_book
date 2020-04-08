package com.book.dao;
 
import org.apache.ibatis.annotations.Param;

import com.book.pojo.Info; 

public interface InfoMapper {
	/**
	 * 根据bookName查询书籍是否已经存在
	 * @param bookName
	 * @return
	 */
	Info findInfoByName(String bookName);

	/**
	 * 添加新的书籍
	 * @param bookName
	 * @param author
	 * @param categoryId
	 * @param publisher
	 * @param price
	 * @param bphoto
	 * @return
	 */
	int addNewInfo(@Param("bookName") String bookName,
			@Param("author") String author,@Param("categoryId") Integer categoryId,
			@Param("publisher") String publisher,@Param("price") Double price,
			@Param("bphoto") String bphoto);
 
 
	
	
	
}
