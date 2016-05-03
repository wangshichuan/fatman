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
<title>index.html</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/bootstrapPeople.min.css">
<script src="js/jqueryPeople.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body style="background-color:#CFF">

	<table class="table">
		<thead>
			<tr>
				<th>订单编号</th>
				<th>下单人</th>
				<th>收货人</th>
				<th>所订菜品</th>
				<th>总价</th>
				<th>下单时间</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
		
<c:if test="${menulist!=null && order!=null && user!=null}">
			<tr class="info">
				<td>${order.id }</td>
				<td>${user.username }</td>
				<td>${order.orderusername }</td>
				<td>
					<c:forEach var="menu" items="${menulist}">${menu.menuname } </c:forEach>
				</td>
				<td>${order.totalprice}</td>
				<td>${order.times }</td>
				<td>${order.status }</td>
				<td><button><a href="updateorder.action?orderid=${order.id }&&userid=${user.id }">修改</a></button><button><a href="deleteorder.action?orderid=${order.id }">删除</a></button></td>
				
			</tr>
			
	</c:if>
		</tbody>
	</table>
</body>
</html>
