<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
				<h2>图书信息列表</h2>		
				<table class="table" cellspacing="0" style="font-size: 12px;">
			    	<tr>
			    		<td class="header" width="100">书名</td>
			    		<td class="header" width="60">作者</td>
			    		<td class="header" width="60">类型</td>
			    		<td class="header" width="60">售价</td>
			    		<td class="header" width="60">操作</td>
			    	</tr>
			    	<c:forEach items="${info}" var="infos">
			    		<tr>
				    		<td>${infos.bookName }</td>
				    		<td>${infos.author }</td>
				    		<td>${infos.bookCategory.category }</td>
				    		<td>￥${infos.price }</td>
				    		<td><a href="${pageContext.request.contextPath}/delete_info?id=${infos.id }">删除</a>
				    			&nbsp;<a href="${pageContext.request.contextPath}/book_edit">编辑</a></td>
			    		</tr>
			    	</c:forEach> 
			    	<tr>
			    		<td>西游记</td>
			    		<td>吴承恩</td>
			    		<td>小说</td>
			    		<td>￥36.0</td>
			    		<td><a href="#">删除</a>&nbsp;<a href="book-edit.html">编辑</a></td>
			    	</tr> 
			    </table>
			</div>
			<div class="section-right">
				<h2>添加图书信息</h2>
				<p style="color:red">${message }</p>
				<form action="${pageContext.request.contextPath}/add_book2" enctype="multipart/form-data"  method="post">
					<p>图书书名：<input type="text" name="btitle"  /></p>
					<p>图书作者：<input type="text" name="bauthor"  /></p>
					<p>图书分类：
						<select name="btypeid">
							<c:forEach items="${category }" var="cate">
								<option value="${cate.id }">${cate.category }</option>
							</c:forEach> 
						</select>
					</p>
					<p>图书售价：<input type="text" name="bprice"  /></p>
					<p>图书出版社：<input type="text" name="bpublisher"  /></p>   
					<p>图书图片：<input type="file" name="bphoto"  /></p>    				 				
					<p><input type="submit" value=" 保 存 "  /></p>
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
