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
				<h2>图书信息列表</h2>		
				<table class="table" cellspacing="0" style="font-size: 12px;">
			    	<tr>
			    		<td class="header" width="100">书名</td>
			    		<td class="header" width="60">作者</td>
			    		<td class="header" width="60">类型</td>
			    		<td class="header" width="60">售价</td>
			    		<td class="header" width="60">操作</td>
			    	</tr>
			    	<tr>
			    		<td>三国演义</td>
			    		<td>罗贯中</td>
			    		<td>小说</td>
			    		<td>￥52.5</td>
			    		<td><a href="#">删除</a>&nbsp;<a href="book-edit.html">编辑</a></td>
			    	</tr>
			    	<tr>
			    		<td>西游记</td>
			    		<td>吴承恩</td>
			    		<td>小说</td>
			    		<td>￥36.0</td>
			    		<td><a href="#">删除</a>&nbsp;<a href="book-edit.html">编辑</a></td>
			    	</tr>
			    	<tr>
			    		<td>史记</td>
			    		<td>司马迁</td>
			    		<td>历史</td>
			    		<td>￥78.0</td>
			    		<td><a href="#">删除</a>&nbsp;<a href="book-edit.html">编辑</a></td>
			    	</tr>
			    	<tr>
			    		<td>红楼梦</td>
			    		<td>曹雪芹</td>
			    		<td>小说</td>
			    		<td>￥92.5</td>
			    		<td><a href="#">删除</a>&nbsp;<a href="book-edit.html">编辑</a></td>
			    	</tr>
			    </table>
			</div>
			<div class="section-right">
				<h2>添加图书信息</h2>
				<form action="" method="post">
					<p>图书书名：<input type="text" name="btitle"  /></p>
					<p>图书作者：<input type="text" name="bauthor"  /></p>
					<p>图书分类：
						<select name="btypeid">
							<option value="1">小说</option>
							<option value="2">历史</option>  
							<option value="5">玄幻</option>  
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
