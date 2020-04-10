package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;
 
@WebServlet("/delete_info")
public class DeleteInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private BookService bookService=new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取请求的参数，转换为Integer
		String sid =request.getParameter("id");
		if(StringUtils.isNullOrEmpty(sid)) {
			request.setAttribute("message","书籍不存在，删除书籍失败");
			request.getRequestDispatcher("/book_mgr").forward(request, response);
		}
		Integer id=Integer.valueOf(sid);
		int result=bookService.deleteInfoById(id);
		if(result==0) {
			request.setAttribute("message","删除书籍失败");
			request.getRequestDispatcher("/book_mgr").forward(request, response);
		}
		request.setAttribute("message","删除书籍成功");
		request.getRequestDispatcher("/book_mgr").forward(request, response);
		return;
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
