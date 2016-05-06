<%@ page language="java" import="java.util.*,Model.MenuModel"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>left.html</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <link rel="stylesheet" href="css/bootstrapPeople.min.css">
    <script src="js/jqueryPeople.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>

<body style="background-color:#CFF">
<div class="accordion" id="accordion-403075">
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle collapsed" data-toggle="collapse"
               data-parent="#accordion-403075" href="#order"><b>订单管理</b></a>
        </div>
        <div id="order" class="accordion-body collapse">

            <div class="accordion-inner"><a href="orderall.action" target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;查询订单</a>
            </div>

        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse"
               data-parent="#accordion-403075" href="#menu"><b>菜品管理</b></a>
        </div>
        <div id="menu" class="accordion-body collapse">
            <div class="accordion-inner"><a href="addMenu.jsp" target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;增加菜品</a>
            </div>
            <div class="accordion-inner"><a href="menuall.action" target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;查询菜品信息</a>
            </div>
        </div>
    </div>
    <c:if test="${admin.grade=='超级管理员' }">
        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                   data-parent="#accordion-403075" href="#user"><b>用户管理</b></a>
            </div>
            <div id="user" class="accordion-body collapse">
                <div class="accordion-inner"><a href="addAdmin.jsp" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;增加管理员</a></div>
                <div class="accordion-inner"><a href="adminall.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;查询管理员</a></div>
                <div class="accordion-inner"><a href="userall.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;查询所有用户</a></div>
            </div>
        </div>
        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                   data-parent="#accordion-403075" href="#money"><b>财务收支</b></a>
            </div>
            <div id="money" class="accordion-body collapse">
                <div class="accordion-inner"><a href="moneyday.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;日收入</a></div>
                <div class="accordion-inner"><a href="moneymonth.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;月收入</a></div>
                <div class="accordion-inner"><a href="moneyyear.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;年收入</a></div>
            </div>
        </div>

        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                   data-parent="#accordion-403075" href="#company_article"><b>企业资讯</b></a>
            </div>
            <div id="company_article" class="accordion-body collapse">
                <div class="accordion-inner"><a href="company_article_list.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;查看</a></div>
                <div class="accordion-inner"><a href="company_article_add.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;新增</a></div>
            </div>
        </div>

        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                   data-parent="#accordion-403075" href="#company_honor"><b>企业荣誉</b></a>
            </div>
            <div id="company_honor" class="accordion-body collapse">
                <div class="accordion-inner"><a href="company_honor_list.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;查看</a></div>
                <div class="accordion-inner"><a href="company_honor_add.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;新增</a></div>
            </div>
        </div>


        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                   data-parent="#accordion-403075" href="#user_join"><b>员工招聘</b></a>
            </div>
            <div id="user_join" class="accordion-body collapse">
                <div class="accordion-inner"><a href="moneyday.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;查看</a></div>
                <div class="accordion-inner"><a href="moneymonth.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;2</a></div>
                <div class="accordion-inner"><a href="moneyyear.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;3</a></div>
            </div>
        </div>


        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                   data-parent="#accordion-403075" href="#company_join"><b>加盟连锁</b></a>
            </div>
            <div id="company_join" class="accordion-body collapse">
                <div class="accordion-inner"><a href="company_join_list.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;查看</a></div>
                <div class="accordion-inner"><a href="moneymonth.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;2</a></div>
                <div class="accordion-inner"><a href="moneyyear.action" target="rightFrame">
                    &nbsp;&nbsp;&nbsp;&nbsp;3</a></div>
            </div>
        </div>

    </c:if>
</div>
</body>
</html>
