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
<title>收获信息</title>

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
		<div style="padding-top: 5%;margin-left: 5%">
			<h4>请确认您的收货信息,以下为默认收货地址：</h4>
			<c:if test="${user!=null }">
				<div class="tab-pane" id="panel-995118">
					<form class="form-horizontal" action="userinfo.action"
						method="post">
						<br /> 收货人: <input type="text" name="username"
							value="${user.username }" placeholder="${user.username }" /> <input
							type="hidden" name="totalprice" value="${totalprice }" /> <input
							type="hidden" name="userid" value="${user.id }" /> <br />
						<br /> 收货地址: <input type="text" name="address"
							value="${user.address }" placeholder="${user.address }" /> <br />
						<br /> 手机：<input id="inputPassword" type="text" name="phone"
							value="${user.phone }" placeholder="${user.phone }" /> <br />
						<br /> 付款方式：<select name="paymethod">
							<option>在线支付</option>
							<option>货到付款</option>
						</select>
						<br /><br />
						<center>
							<button type="submit" class="btn">确认</button>
						</center>
					</form>
				</div>
			</c:if>
		</div>
	</center>



</body>
</html>
