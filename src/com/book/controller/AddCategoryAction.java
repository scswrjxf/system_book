package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/add_category")
public class AddCategoryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 接收传递过来的参数
		String category = request.getParameter("category");
		if(StringUtils.isNullOrEmpty(category)) {
			request.setAttribute("message","分类信息不能为空");
			request.getRequestDispatcher("/category_mgr").forward(request,response);
			return;
		}
		// 调用服务，完成添加分类
		int result = bookService.addNewCategory(category);
		if(result != 0) {
			request.setAttribute("message","添加分类成功");
			request.getRequestDispatcher("/category_mgr").forward(request,response);
			return;
		}
		else {
			request.setAttribute("message","添加分类失败");
			request.getRequestDispatcher("/category_mgr").forward(request,response);
			return;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
