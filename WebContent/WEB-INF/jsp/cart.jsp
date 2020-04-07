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
    	<form id="search-bar" action="" method="post">
	    		书名：<input type="text" class="txt" name="condition" />
	    		<input id="search-btn" type="submit" value=" 搜索图书 " />
    	</form>   	
    	<div id="main">
    		<div class="section-left">
    			<div class="box-left">
    				<div class="box-title">分类畅销榜</div>
    				<div class="box-content">
    					<p>·<a href="#">文学</a></p>
    					<p>·<a href="#">小说</a></p>
    					<p>·<a href="#">青春文学</a></p>
    					<p>·<a href="#">旅游</a></p>
    					<p>·<a href="#">哲学</a></p>
    					<p>·<a href="#">百科</a></p>
    					<p>·<a href="#">恐怖小说</a></p>    		
    				</div>
    			</div>
    		</div>
    		<div class="section-right">
    			<h3 align="center" style="margin-bottom: 20px; ">您选购的商品如下：</h3>
    			<table  align="center"  cellpadding="0" cellspacing="0">
    				<tr>
    					<td class="header" width="200">书名</td>
    					<td class="header"  width="60">单价</td>
    					<td class="header"  width="60">购物数量</td>
    					<td class="header"  width="60">小计</td>
    				</tr>
    				<tr>
    					<td>《红楼小讲》</td>
    					<td>￥15.0</td>
    					<td>7 本</td>
    					<td>￥105.0</td>
    				</tr>
    				<tr>
    					<td>《尸鬼》</td>
    					<td>￥170.0</td>
    					<td>1 本</td>
    					<td>￥170.0</td>
    				</tr>
    				<tr>
    					<td colspan="4" class="header" style="text-align: right;">总计：￥275.0</td>
    				</tr>
    			</table>	
    			<div style="text-align: center; font-size: 14px; line-height: 40px;">
    				<a href="#" style="text-decoration: underline;">去结账</a>
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