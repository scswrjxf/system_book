package com.book.service;

import org.apache.ibatis.session.SqlSession;

import com.book.dao.CategoryMapper;
import com.book.pojo.Category;
import com.book.tools.MyBatisUtil;

public class BookService {
	/**
	 * 添加新的分类
	 * @param category
	 * @return 1-成功 0-失败
	 */
	public int addNewCategory(String category) {
		// 保存返回结果
		int result = 0;
		// 去除两端空格
		String name = category.trim();
		SqlSession sqlSession = MyBatisUtil.open();
		// 查询此分类是否存在
		Category res = sqlSession.getMapper(CategoryMapper.class).findCategoryByName(name);
		// 不存在此分类
		if(res == null) {
			// 添加分类到数据库
			result = sqlSession.getMapper(CategoryMapper.class).addNewCategory(name);
		}
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	}
}






















