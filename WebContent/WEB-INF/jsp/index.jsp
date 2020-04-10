<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
    	<form id="search-bar" action="${pageContext.request.contextPath}/index" method="post">
    		书名：<input type="text" class="txt" name="bookName" />
    		<input id="search-btn" type="submit" value=" 搜索图书 " />
    	</form>
    	<div id="main">
    		<div class="section-left">
    			<div class="box-left">
    				<div class="box-title">分类畅销榜</div>
    				<div class="box-content">
						<p>·<a href="${pageContext.request.contextPath}/index?category=全部&bookName=无"">全部</a></p>
						<c:forEach items="${categories }" var="cate">
    						<p>·<a href="${pageContext.request.contextPath}/index?category=${cate.category }&bookName=无">${cate.category}</a></p>  
						</c:forEach>  					
    				</div>
    			</div>
    		</div>
    		<div class="section-right">
    			<div class="box-right">
    				<div class="box-title">您目前浏览的图书【搜索条件——分类：${empty categoryMessage?"全部":categoryMessage }；书名：${empty bookName?"无":bookName }】</div>
    				<div class="paging" style="border-bottom: 1px solid  #64A26F; color: #006666; ">
    					<div class="paging">
			   				${navStr }   					
		    			</div>
    					 共有图书${count }种，分${countPage }页显示，每页显示${PAGESIZE }个商品
    				</div>
    			<c:forEach items="${info }" var="infos">
    				<div class="box-item">
    					<div class="img-box"><img src="${pageContext.request.contextPath}/upload/${infos.bphoto}" /></div>
    					<div class="info-box">
    						<span style="font-size: 14px; "><a href="#">${infos.bookName}</a></span><br />
							作者：${infos.author}&nbsp;&nbsp;著<br />
							分类：${infos.bookCategory.category }<br />
							出版社：${infos.publisher}<br />							
							售价：￥<span style="color: #990000;">${infos.price}</span>		<br />					
    					</div>
    					<a href="#?id=${infos.id}" class="btn-buy">购&nbsp;&nbsp;买</a>    					
    					<div class="cf"></div>
    				</div>   
    			</c:forEach>
    			<div class="paging">
	   				${navStr }   					
    			</div>
    			</div>
    		</div>
    		<div class="cf"></div>
    	</div>  
    	<!-- footer -->	
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
  </body>
</html>