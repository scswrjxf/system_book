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

@WebServlet("/book_edit")
public class BookEditAccess extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8"); 
		// 获取前端信息
		String sid = request.getParameter("id");
		if(StringUtils.isNullOrEmpty(sid)) {
			request.getSession().setAttribute("message", "id不能为空"); 
		}
		//获取分类
		List<Category> category = bookService.listCategories(); 
		request.getSession().setAttribute("category", category); 
		Integer id=Integer.valueOf(sid);
		//根据id获取书籍的信息
		Info info=bookService.findInfoById(id);
		request.getSession().setAttribute("info",info);
		
		request.getRequestDispatcher("/WEB-INF/jsp/book_edit.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
