package com.book.service; 
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.dao.CategoryMapper;
import com.book.dao.InfoMapper;
import com.book.pojo.Category;
import com.book.pojo.Info;
import com.book.tools.MyBatisUtil;

public class BookService {
	// 每页数量
	public final Integer PAGESIZE = 3;
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
		//提交事务（增删改）,在关闭之前
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	} 
	
	/**
	 * 显示所有的分类
	 * @return
	 */
	public List<Category> listCategories() {  
		SqlSession sqlSession = MyBatisUtil.open();
		// 查询此分类是否存在
		List<Category> res = sqlSession.getMapper(CategoryMapper.class).listCategories();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return res;
	}

	/**
	 * 根据id值删除对应 分类
	 * @param id
	 * @return
	 */
	public int deleteCategoryById(Integer id) {
		SqlSession sqlSession = MyBatisUtil.open(); 
		int result = sqlSession.getMapper(CategoryMapper.class)
				.deleteCategoryById(id);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	}

	/**
	 * 添加新的书籍
	 * @param book
	 * @return
	 */ 
	public int addBookInfo(String bookName,String author,Integer categoryId,
			String publisher,Double price,String bphoto) {
		// 保存返回结果
		int result = 0;
		// 去除两端空格
		String Name = bookName.trim(); 
		SqlSession sqlSession = MyBatisUtil.open();
		// 查询此书籍是否存在
		Info res = sqlSession.
				getMapper(InfoMapper.class).findInfoByName(Name);
		// 不存在此分类
		if(res == null) {
			// 添加分类到数据库
			result = sqlSession.getMapper(InfoMapper.class).
					addNewInfo(bookName, author, categoryId, publisher, price, bphoto);
		}
		//提交事务（增删改）,在关闭之前
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	}
 
	/**
	 * 查询书籍信息
	 * @param currentPage--当前页
	 * @param category--分类名称
	 * @return 书籍信息列表
	 */
	public List<Info> listInfos(Integer currentPage,
			String category,String bookName) {
		SqlSession sqlSession = MyBatisUtil.open();
		// 查询此书籍是否存在
		List<Info> res = sqlSession.getMapper(InfoMapper.class).
				listInfos((currentPage-1)*PAGESIZE, PAGESIZE,category,bookName);
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return res;
	}
	/**
	 * 返回书籍数量
	 * @param category--分类名称
	 * @return
	 */
	public Integer bookCount(String category,String bookName) {
		SqlSession sqlSession = MyBatisUtil.open();
		int result = sqlSession.getMapper(InfoMapper.class)
				.bookCount(category, bookName);
		sqlSession.close();
		return result;
	}
	/**
	 * 返回书籍分页导航字符串
	 * @param currentPage--当前页码
	 * @param count--总共书籍数量
	 * @return
	 */
	public String bookNavStr(Integer currentPage,Integer count) {
		// 求得总共页数
		Integer countPage = count%PAGESIZE==0?count/PAGESIZE:count/PAGESIZE+1;
		if(currentPage==1 && countPage!=1) {
			return "<span class='fr'><a href='book_mgr?currentPage=1'>首页</a>&nbsp;<a>上一页</a>&nbsp;<a href='book_mgr?currentPage="+(currentPage+1)+"'>下一页</a>&nbsp;<a href='book_mgr?currentPage="+countPage+"'>尾页</a>&nbsp;</span>"; 
		}
		else if(currentPage==countPage && countPage!=1) {
			return "<span class='fr'><a href='book_mgr?currentPage=1'>首页</a>&nbsp;<a href='book_mgr?currentPage="+(currentPage-1)+"'>上一页</a>&nbsp;<a>下一页</a>&nbsp;<a href='book_mgr?currentPage="+countPage+"'>尾页</a>&nbsp;</span>";
		}
		else if(countPage == 1) {
			return "<span class='fr'><a href='book_mgr?currentPage=1'>首页</a>&nbsp;<a>上一页</a>&nbsp;<a>下一页</a>&nbsp;<a href='book_mgr?currentPage="+countPage+"'>尾页</a>&nbsp;</span>";
		}
		else {
			return "<span class='fr'><a href='book_mgr?currentPage=1'>首页</a>&nbsp;<a href='book_mgr?currentPage="+(currentPage-1)+"'>上一页</a>&nbsp;<a href='book_mgr?currentPage="+(currentPage+1)+"'>下一页</a>&nbsp;<a href='book_mgr?currentPage="+countPage+"'>尾页</a>&nbsp;</span>";
		}
	}
	
	/**
	 * 根据id值删除对应书籍
	 * @param id
	 * @return
	 */
	public int deleteInfoById(Integer id) {
		SqlSession sqlSession = MyBatisUtil.open(); 
		int result = sqlSession.getMapper(InfoMapper.class)
				.deleteInfoById(id);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	}

	/**
	 * 添加新的书籍
	 * @param info
	 * @return
	 */
	public int addBookInfo2(Info info) {
		// 保存返回结果
		int result = 0; 
		SqlSession sqlSession = MyBatisUtil.open();
		// 查询此书籍是否存在
		Info res = sqlSession.
				getMapper(InfoMapper.class).findInfoByName(info.getBookName());
		// 不存在此分类
		if(res == null) {
		// 添加分类到数据库
		result = sqlSession.getMapper(InfoMapper.class).
				addNewInfoBook(info); 
		}
		//提交事务（增删改）,在关闭之前
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	}
 
 
  






}






















