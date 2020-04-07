package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.User;
import com.book.service.UserService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/login_action")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取前端信息
		String userId = request.getParameter("userId");
		String userPsw = request.getParameter("userPsw");
		if(StringUtils.isNullOrEmpty(userId) 
				|| StringUtils.isNullOrEmpty(userPsw)) {
			request.setAttribute("message", "账户或密码不能为空");
			request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp").forward(request,response);
			return;
		}
		// 调用服务，查询用户是否存在
		User user = userService.findUserByIdAndPsw(userId, userPsw);
		if(user == null) {
			request.setAttribute("message", "账户或密码错误");
			request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp").forward(request,response);
			return;
		}
		// 把user放入session
		request.getSession().setAttribute("user", user);
		if(user.getRole() == 1) {	// 一般用户
			request.getRequestDispatcher("/index").forward(request, response);
		}
		else {	// 管理员
			request.getRequestDispatcher("/WEB-INF/jsp/admin_home.jsp").forward(request,response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
