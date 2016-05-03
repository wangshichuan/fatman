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
	window.location.href="searchuser.action?keyword="+document.getElementById("key").value;
	
}
</script>
<body style="background-color:#CFF">
<c:if test="${userlist==null }">
	<c:if test="${admin!=null }">
		<center>欢迎，${admin.adminname }<br>
		左边菜单可操作
		</center>
	</c:if>
	<c:if test="${admin==null }">
		请先<a href="loginBack.html" target="_parent">登录</a>后进行操作
	</c:if>
	
</c:if>
<c:if test="${userlist!=null }">
	<table class="table">
		<thead>
			<tr>
				<th>编号</th>
				<th>用户名</th>
				<th>地址</th>
				<th>电话</th>
				<th>QQ</th>
				<th>邮箱</th>
				<th><div><input type="text" id="key" placeholder="可以搜索任意属性"/><button class="btn" onclick="searchorder()">搜索</button></div></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="user" items="${userlist }">
			<tr class="info">
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.address }</td>
				<td>${user.phone }</td>
				<td>${user.qq }</td>
				<td>${user.email }</td>
				<td><button><a href="deluser.action?userid=${user.id }">删除</a></button></td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
</body>
</html>
