package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.Category;
import com.book.service.BookService;

@WebServlet("/index")
public class IndexAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService=new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//显示所有的分类
		List<Category> category = bookService.listCategories(); 
		request.getSession().setAttribute("category", category);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
