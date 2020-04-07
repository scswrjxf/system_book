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
						<p>·<a href="#">全部</a></p>
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
    			<div class="box-right">
    				<div class="box-title">您目前浏览的图书【搜索条件——分类：全部；书名：无】</div>
    				<div class="paging" style="border-bottom: 1px solid  #64A26F; color: #006666; ">
    					 <span class="fr"><a href="#">首页</a>&nbsp;<a href="#">上一页</a>&nbsp;<a href="#">下一页</a>&nbsp;<a href="#">尾页</a>&nbsp;</span>
    					 共有图书1000种，分50页显示，每页显示20个商品
    				</div>
    				<div class="box-item">
    					<div class="img-box"><img src="${pageContext.request.contextPath}/static/photo/fzdxl.jpg" /></div>
    					<div class="info-box">
    						<span style="font-size: 14px; "><a href="#">非洲的旋律</a></span><br />
							作者：李艳玲&nbsp;&nbsp;著<br />
							分类：旅游<br />
							出版社：金城出版社<br />							
							售价：￥<span style="color: #990000;">128.0</span>		<br />					
    					</div>
    					<a href="cart.html" class="btn-buy">购&nbsp;&nbsp;买</a>    					
    					<div class="cf"></div>
    				</div>    
    				<div class="box-item">
    					<div class="img-box"><img src="${pageContext.request.contextPath}/static/photo/sg.jpg" /></div>
    					<div class="info-box">
    						<span style="font-size: 14px; "><a href="#">尸鬼</a></span><br />
							作者：（日）小野不由美&nbsp;&nbsp;著<br />
							分类：恐怖小说<br />
							出版社：吉林出版集团<br />							
							售价：￥<span style="color: #990000;">170.0</span>		<br />					
    					</div>
    					<a href="cart.html" class="btn-buy">购&nbsp;&nbsp;买</a>    					
    					<div class="cf"></div>
    				</div>    	
    				<div class="box-item">
    					<div class="img-box"><img src="${pageContext.request.contextPath}/static/photo/hlxj.jpg" /></div>
    					<div class="info-box">
    						<span style="font-size: 14px; "><a href="#">红楼小讲</a></span><br />
							作者：周汝昌&nbsp;&nbsp;著<br />
							分类：文学<br />
							出版社：北京出版社<br />							
							售价：￥<span style="color: #990000;">10.0</span><br />					
    					</div>
    					<a href="cart.html" class="btn-buy">购&nbsp;&nbsp;买</a>    					
    					<div class="cf"></div>
    				</div>  				
    				<div class="paging">
    					 <span class="fr"><a href="#">首页</a>&nbsp;<a href="#">上一页</a>&nbsp;<a href="#">下一页</a>&nbsp;<a href="#">尾页</a>&nbsp;</span>    					
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