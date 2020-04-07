<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>图书网后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mgr.css"/>
  </head>  
  <body>
    <div id="container">
    	<!-- header -->
    	<%@ include file="admin_include/header.jsp" %>
    	<!-- /header -->
    	<div id="main">
			<div class="section-left">
				<h2>图书分类信息</h2>
				<table class="table" cellspacing="0">
			    	<tr>
			    		<td class="header" width="200">图书分类</td>
			    		<td class="header" width="60">操作</td>
			    	</tr>			    
			    	<tr>
			    		<td>小说</td>
			    		<td><a href="#">删除</a></td>
			    	</tr>			    
			    	<tr>
			    		<td>历史</td>
			    		<td><a href="#">删除</a></td>
			    	</tr>			    
			    	<tr>
			    		<td>玄幻</td>
			    		<td><a href="#">删除</a></td>
			    	</tr>			    
			    </table>
			</div>
			<div class="section-right">
				<h2>添加分类信息</h2>
				<p style="color: red;">${message }</p>
				<form action="${pageContext.request.contextPath}/add_category" method="post">
					<p>分类名称：<input type="text" name="category"  /><input type="submit" value=" 保 存 "  /></p>						
			    </form>
			</div>			
			<div class="cf"></div>
		</div>  	
		<!-- footer -->
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
  </body>
</html>
