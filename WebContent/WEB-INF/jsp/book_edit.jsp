<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>图书网后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mgr.css"/>
 	<script src="${pageContext.request.contextPath}/static/js/common.js"></script>
  </head>  
  <body>
    <div id="container">
    	<!-- header -->
    	<%@ include file="admin_include/header.jsp" %>
    	<!-- /header -->
    	<div id="main">
			<div class="section-left">    	
				<h2>编辑图书信息</h2>
				<p style="color:red">${message }</p>
				<form action="${pageContext.request.contextPath}/book_edit_action"
				 enctype="multipart/form-data" method="post">
				 <c:if test="${info!=null }" > 
					<input type="hidden" name="bookId" value="${info.id }" />
					<input type="hidden" name="bphotoOld" value="${info.bphoto }" />
					<p>图书书名：<input type="text" name="btitle" value="${info.bookName }"  /></p>
					<p>图书作者：<input type="text" name="bauthor" value="${info.author }"  /></p>
					<p>图书分类：
						<select name="btypeid">
							<c:forEach items="${category }" var="cate">
								<option value="${cate.id }">${cate.category }</option>
							</c:forEach> 
						</select> 
					</p>
					<p>图书售价：<input type="text" name="bprice" value="${info.price }" /></p>
					<p>图书出版社：<input type="text" name="bpublisher" value="${info.publisher }"  /></p>  
					<p>当前图片：<img width="150" height="90" src="${pageContext.request.contextPath}/upload/${info.bphoto }" /></p> 
					<p><img style="display:none;" id="preview"/></p>
					<p>图书图片：<input type="file" name="bphoto"  onchange="viewImage(this)" /></p>    		  				 				
					<p><input type="submit" value=" 修 改 "  />&nbsp;</p>	
				 </c:if>				
				</form>
			</div>
			<div class="section-right"></div>			
			<div class="cf"></div>
		</div>  	
		<!-- footer -->
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
  </body>
</html>
