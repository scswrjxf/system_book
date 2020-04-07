<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>图书网后台管理系统--用户登录</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mgr.css"/>
  </head>  
  <body>
    <div id="container">
    	<div id="header"><h1>智远教育--图书网后台管理系统</h1></div>
    	<div id="main">
    		<h2>用户登录</h2>
			<form action="admin-home.html" method="post">
				<p>登录账号：<input name="loginId" type="text" /></p>
				<p>登录密码：<input name="loginPsw" type="password" /></p>
				<p><input name="rememberMe" type="checkbox"  />记住账号和密码</p>
				<p><input type="submit" value=" 登  录 " />&nbsp;<label class="fail"></label></p>
			</form>
    	</div>  	
		<!-- footer -->
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
  </body>
</html>