<%@ page language="java" import="java.util.*,Model.MenuModel"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>下单成功</title>

<link rel="stylesheet" href="css/style-shopcar.css" />

<script type="text/javascript" src="js/demo.js"></script>
<link type="text/css" href="css/style-daohang.css" rel="stylesheet" />

<link type="text/css" href="css/font-awesome.css" rel="stylesheet" />
<script type="text/javascript" src="js/jQuery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="css/bootstrapPeople.min.css">
</head>
<body>

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
				<li><a href="peoplecenter.action">${user.username }</a>
				</li>
				<li><a href="exit.action">退出</a></li>
			</c:if>
			<c:if test="${user==null }">
				<li><a href="login.html">登陆</a></li>
				<li><a href="zhuce.html">注册</a></li>
			</c:if>
			<li class="search">
				<form method="get" action="search">
						<input type="text" name="keyword" class="search"
							placeholder="搜索一下，你就知道" />
						<input type="hidden" name="${typename }" /> 
						<input type="submit" value="GO" class="search" />
					</form>
			</li>
		</ul>
	</div>



	<center>
	<div style="padding-top: 12%">

	
	下单成功!<br/><br/>
	<font color="red">友情提示：下单5分钟之内，可前往<a href="peoplecenter.action"><button class="btn">个人中心</button></a>取消订单</font>
	<br/><br/>美味即将送到，请稍等片刻，我们保证会在&nbsp;<font color="red"><b>30分钟</b></font>&nbsp;内给您送到!
	<br/><br/>如有其它意见或建议，欢迎拨打客服电话：110-120-119
	<br/><br/><a href="lookOrder.action?userid=${user.id }"><button class="btn">查询订单</button></a>
	&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="index.jsp"><button class="btn">返回首页</button></a> <br/>
	</div>
	</center>
	

</body>
</html>