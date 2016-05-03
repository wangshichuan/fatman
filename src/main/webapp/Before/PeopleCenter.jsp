<%@ page language="java" import="java.util.*,java.text.DateFormat,java.text.SimpleDateFormat,java.util.Date" pageEncoding="utf-8"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";%>


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
	<div style="background-color:#CFF;height:1400px;margin-top: -20px">
		<div class="contnt_2">

			<div
				style="width:1000px;margin-left:70px; height:250px; background-image:url(img/mpbg.jpg)">
				<!--名片段-->
				<div>
					<div>
						<h3>
							<font color="purple">您好，${user.username }</font>
						</h3>
					</div>
				</div>
				<div style="float:left; color:#039">
					<h5>
						<DIV id=time style="color:#0CC; float:left">
							当前时间
							<SCRIPT>
								document.getElementById('time').innerHTML = new Date()
										.toLocaleString()
										+ ' 星期'
										+ '日一二三四五六'.charAt(new Date().getDay());
								setInterval(
										"document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
										1000);
							</SCRIPT>
						</DIV>

						<div
							style="float:right; text-align:right;margin-top:-75px; width:850px">
							<a href="index.jsp"><button class="btn">前往选餐</button> </a>
						</div>
					</h5>
				</div>

				<!--名片段-->
				<!--切换卡-->
				<div class="tabbable" id="tabs-801866" style="padding-top:50px">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-656325" data-toggle="tab">基本信息</a>
						</li>
						<li><a href="#panel-995118" data-toggle="tab">修改信息</a>
						</li>
						<li><a href="#orderinfo" data-toggle="tab">订单信息</a>
						</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-656325">
							<c:if test="${userinfo!=null }">
								<table class="table">
									<thead>
										<tr>
											<th>地址</th>
											<th>QQ</th>
											<th>邮箱</th>
											<th>手机</th>
										</tr>
									</thead>
									<tbody>
										<tr class="info">
											<td>${userinfo.address }</td>
											<td>${userinfo.qq }</td>
											<td>${userinfo.email }</td>
											<td>${userinfo.phone }</td>
										</tr>
									</tbody>
								</table>
							</c:if>
						</div>
						<div class="tab-pane" id="panel-995118">
							<form class="form-horizontal" action="updateuser" method="post">
								<div class="control-group">
									<label class="control-label" for="inputEmail">地址</label>
									<div class="controls">
										<input id="inputEmail" type="text" name="address"
											placeholder="${userinfo.address }"
											value="${userinfo.address }" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputEmail">QQ</label>
									<div class="controls">
										<input id="inputEmail" type="text" name="qq"
											placeholder="${userinfo.qq }" value="${userinfo.qq }" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputEmail">邮箱</label>
									<div class="controls">
										<input id="inputEmail" type="text" name="email"
											placeholder="${userinfo.email }" value="${userinfo.email }" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">手机</label>
									<div class="controls">
										<input id="inputPassword" type="text" name="phone"
											placeholder="${userinfo.phone }" value="${userinfo.phone }" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">新密码</label>
									<div class="controls">
										<input id="inputPassword" type="password" name="password" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="Password">密码确认</label>
									<div class="controls">
										<input id="Password" type="password" name="repassword" />
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
										<button type="submit" class="btn">确认</button>
									</div>
								</div>
							</form>
						</div>
						<div class="tab-pane" id="orderinfo">
							<font color="red">友情提示：若30分钟内我们未对订单作出处理，那是我们实在太忙啦，下次您就是VIP！(ps:vip会员优惠多多哟！)</font>
							<table class="table">
								<thead>
									<tr>
										<th>订单号</th>
										<th>收货地址</th>
										<th>联系方式</th>
										<th>收货人</th>
										<th>下单时间</th>
										<th>付款方式</th>
										<th>状态</th>
										<th>小计</th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${orderlist!=null }">
										<c:forEach var="order" items="${orderlist }">
											<tr class="info">
												<td>${order.id }</td>
												<td>${order.orderaddress }</td>
												<td>${order.orderphone }</td>
												<td>${order.orderusername }</td>
												<td>${order.times }</td>
												<td>${order.paymethod }</td>
												<td>${order.status }</td>
												<td>${order.totalprice }</td>
												
												<td><c:if test="${order.flag==1&&order.status!='已取消'&&order.status!='已完成'&&order.status!='正在派送'&&order.status!='已过期' }"><a href="cancelorder.action?orderid=${order.id }"><button
															class="btn">取消订单</button>
												</a></c:if>
												</td>
												<!--  	<td><button class="btn"><a href="orderdetail.action?userid=${user.id }&orderid=${order.id}">查看详情</a></button></td>
												<td><button class="btn"><a href="deleteorderpeople.action?orderid=${order.id }">删除</a></button></td>-->
											</tr>

										</c:forEach>
									</c:if>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<!--切换卡-->
			</div>
		</div>
	</div>




</body>
</html>
