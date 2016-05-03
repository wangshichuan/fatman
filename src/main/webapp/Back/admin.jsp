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

<body style="background-color:#CFF">

	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>管理员名</th>
				<th>权限</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>

			<c:if test="${adminlist!=null }">
				<c:forEach var="admin" items="${adminlist }">
					<tr class="info">
						<td>${admin.id }</td>
						<td>${admin.adminname }</td>
						<td>${admin.grade }</td>
						<td><button>
								<a href="updateadmin.action?adminid=${admin.id }">修改</a>
							</button>
							<button>
								<a href="deleteadmin.action?adminid=${admin.id }">删除</a>
							</button>
						</td>

					</tr>
				</c:forEach>

			</c:if>
		</tbody>
	</table>
</body>
</html>
