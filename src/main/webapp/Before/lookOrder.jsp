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
<title>查看订单</title>

<link rel="stylesheet" href="css/style-shopcar.css" />

<script type="text/javascript" src="js/demo.js"></script>
<link type="text/css" href="css/style-daohang.css" rel="stylesheet" />

<link type="text/css" href="css/font-awesome.css" rel="stylesheet" />
<script type="text/javascript" src="js/jQuery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="css/bootstrapPeople.min.css">
</head>
<body>

	<c:import url="daohang.jsp"></c:import>



	<center>
		<div style="padding-top: 5%">
			<h3>您的订单信息如下：</h3>
			<c:if test="${order!=null }">
		收货人：<input type="text" value="${order.orderusername }" readonly="readonly" />
		<br />
		收货地址：<input type="text" value="${order.orderaddress }" readonly="readonly" />
		<br />
		联系方式:<input type="text" value="${order.orderphone }" readonly="readonly" /><br />
		付款方式:<input type="text" value="${order.paymethod }" readonly="readonly" /><br />
		下单时间：<input type="text" value="${order.times }" readonly="readonly" /><br /><br />
			</c:if>
			<a href="index.jsp"><button class="btn">
					返回首页
				</button>
			</a>
			<a href="peoplecenter.action"><button class="btn">
					个人中心
				</button>
			</a>
		</div>
	</center>



</body>
</html>
