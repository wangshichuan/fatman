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
<script type="text/javascript">
function searchorder(){
	window.location.href="searchmenu.action?keyword="+document.getElementById("key").value;
	
}

function deletemenu(){
	alert("删除成功");
}
</script>
<body style="background-color:#CFF">
<c:if test="${menulist==null }">
	<c:if test="${admin!=null }">
		<center>欢迎，${admin.adminname }<br>
		左边菜单可操作
		</center>
	</c:if>
	<c:if test="${admin==null }">
		请先<a href="loginBack.html" target="_parent">登录</a>后进行操作
	</c:if>
	
</c:if>
<c:if test="${menulist!=null }">
	<table class="table">
		<thead>
			<tr>
			<th></th>
				<th>编号</th>
				<th>菜品名</th>
				<th>成本</th>
				<th>单价</th>
				<th>描述</th>
				<th>所属类别</th>
				<th><input type="text" id="key"  placeholder="可以搜索任意属性"/><button class="btn" onclick="searchorder()">搜索</button></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="menu" items="${menulist }">
			<tr class="info">
				<td><img src="${menu.picUrl }" width="40" height="30"/></td>
				<td>${menu.id }</td>
				<td>${menu.menuname }</td>
				<td>${menu.chengben }</td>
				<td>${menu.price }</td>
				<td>${menu.describes }</td>
				<td>${menu.typename }</td>
				<td><button><a href="updatemenu.action?menuid=${menu.id }">修改</a></button><button>
								<a href="deletemenu.action?menuid=${menu.id }" onclick="deletemenu()">删除</a>
							</button></td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
</body>
</html>
