package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.book.pojo.User;
import com.book.service.UserService;
import com.mysql.jdbc.StringUtils; 

@WebServlet("/user_regist_action")
public class UserRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("loginId");
		String userPsw = request.getParameter("loginPsw");
		String reLoginPsw = request.getParameter("reLoginPsw");
		String userName = request.getParameter("name");
		String code = request.getParameter("code");
		if(StringUtils.isNullOrEmpty(userId) || StringUtils.isNullOrEmpty(userPsw) 
				|| StringUtils.isNullOrEmpty(reLoginPsw) 
				|| StringUtils.isNullOrEmpty(userName)
				|| StringUtils.isNullOrEmpty(code)) {
			request.setAttribute("message","任何信息都不能为空");
			request.getRequestDispatcher("/user_regist").forward(request, response);
			return;
		}
		if(userPsw.equals(reLoginPsw) == false) {
			request.setAttribute("message","密码和确认密码必须相同");
			request.getRequestDispatcher("/user_regist").forward(request, response);
			return;
		}
		if(code.equals("2648") == false) {
			request.setAttribute("message","验证码不对");
			request.getRequestDispatcher("/user_regist").forward(request, response);
			return;
		} 
		userId = DigestUtils.md5Hex(userId.trim()); 
		userPsw = DigestUtils.md5Hex(userPsw.trim());  
		User user = new User(userId, userPsw, userName, 1);
		int result=userService.addNewUser(user); 
		if(result != 0) {
			request.setAttribute("message","注册账号成功");
			request.getRequestDispatcher("/user_regist").forward(request,response);
			return;
		}
		else {
			request.setAttribute("message","注册账号失败");
			request.getRequestDispatcher("/user_regist").forward(request,response);
			return;
		}  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}












