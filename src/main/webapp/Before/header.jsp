<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/4
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,Model.MenuModel" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>莽子特色自助老火锅</title>

    <link type="text/css" href="css/font-awesome.css" rel="stylesheet"/>
    <link type="text/css" href="css/style.css" rel="stylesheet"/>

    <script type="text/javascript" src="js/jQuery-1.10.1.min.js"></script>
    <script type="text/javascript" src="js/script.js"></script>


    <link rel="stylesheet" type="text/css" href="css/style-daohang.css">
    <link rel="stylesheet" type="text/css" href="css/style-hand.css">
    <link rel="stylesheet" type="text/css" href="css/company.css">
    <script type="text/javascript" src="js/lxMove.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/boot-css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/styles.css" type="text/css" media="screen"/>
</head>
<body>
<div class="content">
    <ul class="venus-menu">
        <li class="active"><a href="index.jsp"><i class="icon-home"></i>首页</a></li>

        <li>
            <a href="#"><i class="icon-thumbs-up"></i>美食介绍</a>
            <ul>
                <li>
                    <a href="menutype.action?type=火锅">特色火锅</a>
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
            </ul>
        </li>
        <li><a href="companyArticle.action"><i class="icon-magic"></i>企业资讯</a></li>
        <li><a href="honorDetail.action"><i class="icon-quote-right"></i>企业荣耀</a></li>
        <li><a href="user_join.action"><i class="icon-envelope-alt"></i>员工招聘</a></li>
        <li><a href="company_join.action"><i class="icon-envelope-alt"></i>加盟连锁</a></li>

        <c:if test="${user!=null }">
            <li><a href="peoplecenter.action">${user.username }</a></li>
            <li><a href="exit.action">退出</a>
            </li>
            <li><a href="order.jsp">购物车</a>
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
                       placeholder="搜索一下，你就知道"/>
                <input type="hidden" name="${typename }"/>
                <input type="submit" value="GO" class="search"/>
            </form>
        </li>
    </ul>
</div>
</body>
</html>
