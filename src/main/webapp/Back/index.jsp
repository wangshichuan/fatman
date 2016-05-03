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

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<link rel="stylesheet" href="css/bootstrapPeople.min.css">
<script src="js/jqueryPeople.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<script type="text/javascript">
function searchorder(){
	window.location.href="searchorder.action?keyword="+document.getElementById("key").value;
	
}
</script>
<body style="background-color:#CFF">
	<c:if test="${list==null }">
		<c:if test="${admin!=null }">
			<center>
				欢迎，${admin.adminname }<br> 左边菜单可操作
			</center>
		</c:if>
		<c:if test="${admin==null }">
		请先<a href="loginBack.html" target="_parent">登录</a>后进行操作
	</c:if>

	</c:if>
	<c:if test="${list!=null }">
		<table class="table">
			<thead>
				<tr>
					<th>订单编号</th>
					<th>下单人</th>
					<th>订单总价</th>
					<th>下单时间</th>
					<th>付款方式</th>
					<th>订单状态</th>
					<th>
							<input type="text" id="key" placeholder="可以搜索任意属性"/>
							<button class="btn" onclick="searchorder()" >搜索</button>
						
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${list }">
					<tr class="info">
						<td>${order.orderid }</td>
						<td>${order.username }</td>
						<td>${order.totalprice }</td>
						<td>${order.time }</td>
						<td>${order.paymethod }</td>
						<td>${order.status }</td>
						<td><button>
								<a
									href="updateorder.action?orderid=${order.orderid }&&userid=${order.userid }">修改</a>
							</button>
							<button>
								<a href="deleteorder.action?orderid=${order.orderid }">删除</a>
							</button>
							<button>
								<a
									href="orderdetail.action?userid=${order.userid }&orderid=${order.orderid}">查看详细</a>
							</button>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
