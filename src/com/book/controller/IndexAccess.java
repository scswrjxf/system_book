package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.Category;
import com.book.pojo.Info;
import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/index")
public class IndexAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService=new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String sCurrentPage=request.getParameter("currentPage");
		if(StringUtils.isNullOrEmpty(sCurrentPage)) {
			sCurrentPage="1";
		}
		Integer currentPage = Integer.valueOf(sCurrentPage);
		// 获取分类名称
		String category = request.getParameter("category");
		if(StringUtils.isNullOrEmpty(category )) {
			Object oCategory = request.getSession().getAttribute("categoryMessage");
			if(oCategory != null) {
				category = oCategory.toString();
			}
			else {
				category = "全部";
			}
		}
		// 获取搜索书籍名
		String bookName = request.getParameter("bookName");
		if(StringUtils.isNullOrEmpty(bookName)) {
			Object oBookName = request.getSession().getAttribute("bookName");
			if(oBookName != null) {
				bookName = oBookName.toString();
			}
			else {
				bookName = "无";
			}
		}
		//显示所有的分类
		List<Category> categories = bookService.listCategories(); 
		request.getSession().setAttribute("categories", categories);

		//获取书籍
		List<Info> info = bookService.listInfos(currentPage,category ,bookName); 
		request.getSession().setAttribute("info", info);
		// 获取书籍数量
		Integer count = bookService.bookCount(category, bookName);
		request.setAttribute("count", count);
		// 每页数量
		Integer PAGESIZE = 3;
		request.setAttribute("PAGESIZE", PAGESIZE);
		// 求得总共页数
		Integer countPage = count%PAGESIZE==0?count/PAGESIZE:count/PAGESIZE+1;
		request.setAttribute("countPage", countPage);
		// 调用服务，生成分页导航字符串
		String navStr = bookService.bookNavStr(currentPage, count);
		request.setAttribute("navStr", navStr);
		// 设置显示分类名称（放入session中）
		request.getSession().setAttribute("categoryMessage", category );
				
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
