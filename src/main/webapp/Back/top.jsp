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
<html>
<head>
<title>top.html</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<link rel="stylesheet" href="css/bootstrapPeople.min.css">
<script src="js/jqueryPeople.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body style="background-color:#CFF">
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a data-target=".navbar-responsive-collapse" data-toggle="collapse"
					class="btn btn-navbar"><span class="icon-bar"></span><span
					class="icon-bar"></span><span class="icon-bar"></span> </a> <a href="#"
					class="brand">FastNet</a>
				<div class="nav-collapse collapse navbar-responsive-collapse">
					<ul class="nav">
						<li><a>欢迎进入网上订餐，后台系统</a></li>
						

					</ul>
					<ul class="nav pull-right">
						<c:if test="${admin!=null }">
							<li><a >${admin.adminname
									}</a>
							</li>
							<li><a href="exitlogin.action" target="_parent">退出</a></li>
						</c:if>
						<c:if test="${admin==null }">
							<li><a href="loginBack.html" target="_parent">登陆</a></li>
							<li><a href="zhuceBack.html" target="_parent"></a></li>
						</c:if>
						
						<li><a href="../Before/index.jsp" target="_parent">前台主页</a>
						</li>

					</ul>
				</div>

			</div>
		</div>

	</div>
</body>
</html>
