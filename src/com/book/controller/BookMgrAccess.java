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

@WebServlet("/book_mgr")
public class BookMgrAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService=new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sCurrentPage=request.getParameter("currentPage");
		if(StringUtils.isNullOrEmpty(sCurrentPage)) {
			sCurrentPage="1";
		}
		Integer currentPage = Integer.valueOf(sCurrentPage);
		//获取分类
		List<Category> category = bookService.listCategories(); 
		request.getSession().setAttribute("category", category);
		
		//获取书籍
		List<Info> info = bookService.listInfos(currentPage,null,null); 
		request.getSession().setAttribute("info", info);
		// 获取书籍数量
		Integer count = bookService.bookCount(null,null);
		// 调用服务，生成分页导航字符串
		String navStr = bookService.bookNavStr(currentPage, count);
		request.setAttribute("navStr", navStr);
		request.getRequestDispatcher("/WEB-INF/jsp/book_mgr.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
