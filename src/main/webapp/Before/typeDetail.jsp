
<%@ page language="java" import="java.util.*,Model.MenuModel"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>快餐订餐系统</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link type="text/css" href="css/font-awesome.css" rel="stylesheet" />
<script type="text/javascript" src="js/jQuery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>

<link rel="stylesheet" type="text/css" href="css/style-daohang.css">
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/font-awesome.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/templatemo-style.css">
<script src="js/vendor/modernizr-2.6.2.min.js"></script>


</head>

<body>
	<!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->




	<div id="loader-wrapper">
		<div id="loader"></div>
	</div>

	<div class="content-bg"></div>
	<div class="bg-overlay"></div>


	<div class="site-top" style="background-color:white;">
		<div class="content">
			<ul class="venus-menu">
				<li class="active"><a href="index.jsp"><i class="icon-home"></i>首页</a>
				</li>
				<li><a href="menutype.action?type=炒饭">炒饭</a>
				</li>
				<li><a href="menutype.action?type=盖饭">盖饭</a>
				</li>
				<li><a href="menutype.action?type=甜品">甜品</a>
				</li>
				<li><a href="menutype.action?type=面食">面食</a>
				</li>
				<li><a href="menutype.action?type=饮料">饮料</a>
				</li>
				<li><a href="menutype.action?type=汤">煲汤</a>
				</li>
				<c:if test="${user!=null }">
					<li><a href="peoplecenter.action">${user.username }</a></li>
					<li><a href="exit.action">退出</a>
					</li>
					<li><a href="order.jsp">购物车</a>
					</li>
				</c:if>
				<c:if test="${user==null }">
					<li><a href="login.html">登陆</a>
					</li>
					<li><a href="zhuce.html">注册</a>
					</li>
				</c:if>
				<li class="search">
					<form method="get" action="search">
						<input type="text" name="keyword" class="search"
							placeholder="搜索一下，你就知道" />
						<input type="hidden" name="${typename }" /> 
						<input type="submit" value="GO" class="search" />
					</form></li>
			</ul>
		</div>
	</div>




	<!-- MAIN POSTS -->
	<div class="main-posts">
		<div class="container">
			<div class="row">
				<div class="blog-masonry masonry-true">
					<c:if test="${listMenu!=null }">
						<c:forEach var="menu" items="${listMenu}">


							<div class="post-masonry col-md-4 col-sm-6">
								<div class="post-thumb">
									<img src="${menu.picUrl }">
									<div class="title-over">
										<h4>
											<a href="#">${menu.menuname }</a>
										</h4>
									</div>
									<div class="post-hover text-center">
										<div class="inside">
											<i class="fa fa-plus"></i> <span class="date">${menu.describes
												}</span>
											<h4>
												<a href="#">￥${menu.price }</a>
											</h4>
											<p>${menu.menuname }</p>
											<br>
											<br> <a href="joinorder.action?menuid=${menu.menuid }"><p>加入豪华套餐</p>
											</a>
										</div>
									</div>
								</div>
							</div>
							<!-- /.post-masonry -->
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
	</div>


	<!-- FOOTER -->
	<div style="padding-top: 12%">
		<footer class="site-footer">
			<div class="container">

				<div class="row">
					<div class="col-md-12 text-center">
						<p class="copyright-text">订餐系统 &copy; 2015 我们只做最好</p>
					</div>
				</div>
			</div>
		</footer>
	</div>

	<script src="js/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')
	</script>
	<script src="js/min/plugins.min.js"></script>
	<script src="js/min/main.min.js"></script>

	<!-- Preloader -->
	<script type="text/javascript">
		//         
		$(window).load(function() { // makes sure the whole site is loaded
			$('#loader').fadeOut(); // will first fade out the loading animation
			$('#loader-wrapper').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
			$('body').delay(350).css({
				'overflow-y' : 'visible'
			});
		})
		//
	</script>
	<!-- templatemo 434 masonry -->
</body>
</html>