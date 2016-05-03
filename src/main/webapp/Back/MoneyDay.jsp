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
function searchday(){
	window.location.href="searchtimes.action?keyword="+document.getElementById("key").value;
	
}

</script>
<body style="background-color:#CFF">

	<table class="table">
		<thead>
			<tr>
				<th>日期</th>
				<th>总成本</th>
				<th>总收入</th>
				<th>盈利</th>
				<th><input type="text" id="key" name="key" placeholder="格式：yyyy/mm/dd"><button class="btn" onclick="searchday()">搜索</button></th>
			</tr>
		</thead>
		<tbody>
			<tr class="info">
				<td>${nowTime }</td>
				<td>${money.chengben }</td>
				<td>${money.shouru }</td>
				<td>${money.yinli }</td>
				<td></td>
			</tr>
		</tbody>
	</table>
</body>
</html>
