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
<title>购物车</title>

<link rel="stylesheet" href="css/style-shopcar.css" />

<script type="text/javascript" src="js/demo.js"></script>
<link type="text/css" href="css/style-daohang.css" rel="stylesheet" />

<link type="text/css" href="css/font-awesome.css" rel="stylesheet" />
<script type="text/javascript" src="js/jQuery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>

<script type="text/javascript">
	function orderinfo() {
		var price = document.getElementById("priceTotal").innerText;
		if (price > 0) {
			window.location.href = "orderinfo.action?totalprice="
					+ price;
		} else {
			alert("请先选择商品");
		}
	}
	
	function deletemenu(){
		alert("删除成功");
	}
</script>
</head>


<body>

	<%
		if(session.getAttribute("listMenu")!=null){
			List<MenuModel> listmenu = (List<MenuModel>) session.getAttribute("listMenu");
			List<Integer> listmenuid = new ArrayList<Integer>();
			for (MenuModel menu : listmenu) {
		listmenuid.add(menu.getMenuid());
			}
			request.setAttribute("listmenuid", listmenuid);
		}
	%>

	<div class="content">
		<ul class="venus-menu">
			<li class="active"><a href="index.jsp"><i class="icon-home"></i>首页</a>
			</li>
			<li><a href="menutype.action?type=炒饭">炒饭</a>
			</li>
			<li><a href="menutype.action?type=盖饭">盖饭</a>
			</li>
			<li><a href="menutype.action?type=甜品">甜品</a>
			</li>
			<li><a href="menutype.action?type=面食">面食</a>
			</li>
			<li><a href="menutype.action?type=饮料">饮料</a>
			</li>
			<li><a href="menutype.action?type=汤">煲汤</a>
			</li>
			<c:if test="${user!=null }">
				<li><a href="peoplecenter.action">${user.username
						}</a></li>
				<li><a href="exit.action">退出</a>
				</li>
			</c:if>
			<c:if test="${user==null }">
				<li><a href="login.html">登陆</a>
				</li>
				<li><a href="zhuce.html">注册</a>
				</li>
			</c:if>
			<li class="search">
				<form method="get" action="search">
					<input type="text" name="keyword" class="search"
						placeholder="搜索一下，你就知道" /> <input type="hidden"
						name="${typename }" /> <input type="submit" value="GO"
						class="search" />
				</form></li>
		</ul>
	</div>




	<%
		if (session.getAttribute("listMenu") == null) {
		List<MenuModel> listMenu = new ArrayList<MenuModel>();
		List<Integer> menuid = new ArrayList<Integer>();
		MenuModel menu = new MenuModel();
		menu = (MenuModel) request.getAttribute("menu");

		if (menu != null) {    //request域中传入的菜品信息
			menuid.add(menu.getMenuid());
			listMenu.add((MenuModel) request.getAttribute("menu"));
			session.setAttribute("listMenu", listMenu);
			session.setAttribute("menuid", menuid);
		}
			} else {
		List<MenuModel> listMenu = (List<MenuModel>) session
				.getAttribute("listMenu");
		List<Integer> menuid = new ArrayList<Integer>();
		if (session.getAttribute("menuid") != null)
			menuid = (List<Integer>) session.getAttribute("menuid");
		MenuModel menu = new MenuModel();
		boolean flag = true;
		menu = (MenuModel) request.getAttribute("menu");
		if (!menuid.isEmpty() && menu != null) {
			for (Integer id : menuid) {
				if (menu.getMenuid() == id)
					flag = false;
			}
		}
		if (menu != null && flag) {
			menuid.add(menu.getMenuid());
			listMenu.add((MenuModel) request.getAttribute("menu"));
			session.setAttribute("listMenu", listMenu);
			session.setAttribute("menuid", menuid);
		}
			}
	%>

	<div class="catbox">

		<table id="cartTable">
			<thead>
				<tr>
					<th><label><input class="check-all check"
							type="checkbox" />&nbsp;全选</label>
					</th>
					<th>商品</th>
					<th>单价</th>
					<th>数量</th>
					<th>小计</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${listMenu!=null }">
					<c:forEach var="m" items="${listMenu }">
						<tr>
							<td class="checkbox"><input class="check-one check"
								type="checkbox" /></td>
							<td class="goods"><img src="${m.picUrl }" /><span>${m.menuname
									}</span>
							</td>
							<td class="price">${m.price }</td>
							<td class="count"><span class="reduce"></span><input
								class="count-input" type="text" value="1" /><span class="add">+</span>
							</td>
							<td class="subtotal">${m.price }</td>
							<td class="operation"><span class="delete"><a onclick="deletemenu()"
									href="deleteMenu.action?menuid=${m.menuid }&&typename=${m.typename }">删除</a>
							</span>
							</td>
						</tr>


					</c:forEach>
				</c:if>
			</tbody>
		</table>

		<div class="foot" id="foot">
			<label class="fl select-all"><input type="checkbox"
				class="check-all check" />&nbsp;全选</label> <a href="#"
				onclick="orderinfo()"><div class="fr closing">确认收货信息</div> </a>
			<div class="fr total">
				合计：￥<span id="priceTotal">0.00</span>
			</div>
			<div class="fr selected" id="selected">
				已选商品<span id="selectedTotal">0</span>件<span class="arrow up">︽</span><span
					class="arrow down">︾</span>
			</div>
			<div class="selected-view">
				<div id="selectedViewList" class="clearfix">
					<div>
						<img src="images/1.jpg" /><span>取消选择</span>
					</div>
				</div>
				<span class="arrow">◆<span>◆</span> </span>
			</div>
		</div>

	</div>




</body>
</html>