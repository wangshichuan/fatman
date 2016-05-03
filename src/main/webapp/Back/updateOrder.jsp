<!--<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";%>
-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN" "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心</title>
<link rel="stylesheet" href="css/bootstrapPeople.min.css">
<link rel="stylesheet" href="css/iindex.css">
<script src="js/jqueryPeople.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>
	<div style="background-color:#CFF;height:1400px;margin-top: -18px">
		<div class="contnt_2">

			<div
				style="width:1000px;margin-left:70px; height:250px; background-image:url(img/mpbg.jpg)">
				<!--名片段-->
				<div>
					<div>
						<h3>
							<font color="purple">修改订单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编号${order.id }</font>
						</h3>
					</div>
				</div>

				<!--名片段-->
				<!--切换卡-->
				<div class="tabbable" id="tabs-801866" style="padding-top:50px">
					<ul class="nav nav-tabs">
						<center><li><a href="#panel-656325" data-toggle="tab">信息如下</a>
						</li></center>
					</ul>
					<div style="margin-left: 35%">
					
					<form action="updateOrderSuccess">
						<input type="hidden" name="orderid" value="${order.id }" />
						下单人 ：<input type="text" name="username" readonly="readonly"
											placeholder="${user.username }"/><br />
						下单时间：<input type="text" 
									readonly="readonly"		placeholder="${order.times }"/><br />
						
						<c:forEach var="menu" items="${menulist }">
						包含菜品：<input type="text" readonly="readonly"
											placeholder="${menu.menuname }"/><br />
						</c:forEach>
						订单总价：<input type="text" name="totalprice" readonly="readonly"
											placeholder="${order.totalprice }"/><br />
						修改状态：<select name="status">
							<option>正在派送</option>
							<option>已完成</option>
							<option>已取消</option>
						</select><br />
											<button type="submit" class="btn">确定</button>
					</form>
					</div>
				</div>

				<!--切换卡-->
			</div>
		</div>
	</div>




</body>
</html>
