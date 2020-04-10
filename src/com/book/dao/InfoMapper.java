package com.book.dao;
 
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.Info; 

public interface InfoMapper {
	/**
	 * 根据bookName查询书籍是否已经存在
	 * @param bookName
	 * @return
	 */
	Info findInfoByName(@Param("bookName") String bookName);

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

	/**
	 * 查询所有的书籍
	 * @return
	 */
	List<Info> listInfos();

	/**
	 * 根据id值删除对应书籍
	 * @param id
	 * @return
	 */
	int deleteInfoById(@Param("id") Integer id);

	/**
	 * 添加新的书籍
	 * @param info
	 * @return
	 */
	int addNewInfoBook(Info info);
 
 
	
	
	
}
