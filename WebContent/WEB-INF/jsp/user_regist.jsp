<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>智远图书网</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css"/>
  </head>  
  <body>
    <div id="container">
    	<!-- header -->
    	<%@ include file="user_include/header.jsp" %>
    	<!-- /header --> 
    	<div id="main">
    		<div class="box" id="register">
    			<div class="title">新用户注册</div>
<form action="" method="post" style="margin: 10px;">
	<table cellspacing="0" class="no-border">
    	<tr>
    		<td style="text-align: right;">登录账号：</td>
    		<td><input type="text" name="loginId" class="txt" value="" /></td>
    	</tr>
    	<tr>
    		<td style="text-align: right;">登录密码：</td>
    		<td><input type="password" name="loginPsw" class="txt" value="" /></td>
    	</tr>
    	<tr>
    		<td style="text-align: right;">再次输入密码：</td>
    		<td><input type="password" name="reLoginPsw" class="txt" value="" /></td>
    	</tr>
    	<tr>
    		<td style="text-align: right;">真实姓名：</td>
    		<td><input type="text" name="name" class="txt" value="" /></td>
    	</tr>
    	<tr>
    		<td style="text-align: right;">验证码：</td>
    		<td><input type="text" name="code" class="txt" /></td>
    	</tr>
    	<tr>
    		<td>&nbsp;</td>
    		<td><img id="img" src="images/code.jpg" />&nbsp;&nbsp;看不清？<a href="#" style="color: #64A26F;">换张图</a></td>
    	</tr>
    	<tr>
    		<td>&nbsp;</td>
    		<td><input type="submit" value=" 注  册 " class="btn" />&nbsp;&nbsp;</td>
    	</tr>
    </table>
</form>
    		</div>
    	</div>  	
		<!-- footer -->	
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
  </body>
</html>