<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN" "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改管理员</title>
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
							<font color="purple">修改管理员信息</font>
						</h3>
					</div>
				</div>

				<!--名片段-->
				<!--切换卡-->
				<div class="tabbable" id="tabs-801866" style="padding-top:50px">
					<ul class="nav nav-tabs">
						<center>
							<li><a href="#panel-656325" data-toggle="tab">填写管理员信息</a></li>
						</center>
					</ul>
					<div style="margin-left: 35%">

						<form name="myform" action="updateAdminsuccess" method="post">
						<input type="hidden" name="adminid" value="${admin.id }" />
							管理员名：<input type="text" value="${admin.adminname }"
								placeholder="${admin.adminname }"
								name="adminname"  /><br /> 密码：<input type="password"
								name="password"  /><br />
							确认密码：<input type="password" name="repassword"  /><br />
							权限：<select name="grade">
								<option>超级管理员</option>
								<option>普通管理员</option>
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
