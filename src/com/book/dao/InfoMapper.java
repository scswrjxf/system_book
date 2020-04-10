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
	 * 查询书籍信息
	 * @param bookName 
	 * @param from-起始索引（0开始）
	 * @param pageSize-每页数量
	 * @return 书籍信息列表
	 */ 
	List<Info> listInfos(@Param("from") Integer from,
			@Param("pageSize") Integer pageSize,
			@Param("category") String category,
			@Param("bookName") String bookName);

	/**
	 * 返回书籍数量
	 * @param category 
	 * @return
	 */
	Integer bookCount(@Param("category") String category,
			@Param("bookName") String bookName);
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
