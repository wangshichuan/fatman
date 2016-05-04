<%@ page language="java" import="java.util.*,Model.MenuModel" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:import url="header.jsp"></c:import>
<body>


<%--<div class="content">--%>
    <%--<ul class="venus-menu">--%>
        <%--<li class="active"><a href="index.jsp"><i class="icon-home"></i>首页</a></li>--%>

        <%--<li>--%>
            <%--<a href="#"><i class="icon-thumbs-up"></i>美食介绍</a>--%>
            <%--<ul>--%>
                <%--<li>--%>
                    <%--<a href="menutype.action?type=火锅">特色火锅</a>--%>
                <%--</li>--%>
                <%--<li><a href="menutype.action?type=炒饭">炒饭</a>--%>
                <%--</li>--%>
                <%--<li><a href="menutype.action?type=盖饭">盖饭</a>--%>
                <%--</li>--%>
                <%--<li><a href="menutype.action?type=甜品">甜品</a>--%>
                <%--</li>--%>
                <%--<li><a href="menutype.action?type=面食">面食</a>--%>
                <%--</li>--%>
                <%--<li><a href="menutype.action?type=饮料">饮料</a>--%>
                <%--</li>--%>
                <%--<li><a href="menutype.action?type=汤">煲汤</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <%--<li><a href="company.action"><i class="icon-magic"></i>企业资讯</a></li>--%>
        <%--<li><a href="company_honor.action"><i class="icon-quote-right"></i>企业荣耀</a></li>--%>
        <%--<li><a href="user_join.action"><i class="icon-envelope-alt"></i>员工招聘</a></li>--%>
        <%--<li><a href="company_join.action"><i class="icon-envelope-alt"></i>加盟连锁</a></li>--%>

        <%--<c:if test="${user!=null }">--%>
            <%--<li><a href="peoplecenter.action">${user.username }</a></li>--%>
            <%--<li><a href="exit.action">退出</a>--%>
            <%--</li>--%>
            <%--<li><a href="order.jsp">购物车</a>--%>
            <%--</li>--%>
        <%--</c:if>--%>
        <%--<c:if test="${user==null }">--%>
            <%--<li><a href="login.html">登陆</a>--%>
            <%--</li>--%>
            <%--<li><a href="zhuce.html">注册</a>--%>
            <%--</li>--%>
        <%--</c:if>--%>
        <%--<li class="search">--%>
            <%--<form method="get" action="search">--%>
                <%--<input type="text" name="keyword" class="search"--%>
                       <%--placeholder="搜索一下，你就知道"/>--%>
                <%--<input type="hidden" name="${typename }"/>--%>
                <%--<input type="submit" value="GO" class="search"/>--%>
            <%--</form>--%>
        <%--</li>--%>
    <%--</ul>--%>
<%--</div>--%>

<div id="wrap">
    <img src="images/1.jpg" alt="" class="pos_1" name="img1"/>
    <img src="images/2.jpg" alt="" class="pos_2" name="img1"/>
    <img src="images/4.jpg" alt="" class="pos_3" name="img1"/>
    <img src="images/6.jpg" alt="" class="pos_4" name="img1"/>
    <img src="images/7.jpg" alt="" class="pos_5" name="img1"/>
    <img src="images/9.jpg" alt="" class="pos_6" name="img1"/>
    <img src="images/10.jpg" alt="" class="pos_7" name="img1"/>

    <div id="left"></div>
    <div id="right"></div>
    <img id="prev" src="images/prev.png"/>
    <img id="prev_txt" src="images/prev_txt.png"/>
    <img id="next" src="images/next.png"/>
    <img id="next_txt" src="images/next_txt.png"/>
    <ul class="leige">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
    <img id="footer" src="images/1.jpg"></img>

    <div id="btn"></div>
</div>


<div class="case-content">

    <div class="case-item">
        <div class="ih-item circle effect1">
            <a href="menutype.action?type=炒饭">
                <div class="spinner"></div>
                <div class="img"><img src="images/1.jpg" height=200 width=200></div>
                <div class="info">
                    <div class="info-back">
                        <h3>炒饭类</h3>

                        <p></p>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <div class="case-item">
        <div class="ih-item circle effect1">
            <a href="menutype.action?type=面食">
                <div class="spinner"></div>
                <div class="img"><img src="images/2.jpg" height=200 width=200></div>
                <div class="info">
                    <div class="info-back">
                        <h3>面条</h3>

                        <p></p>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <div class="case-item">
        <div class="ih-item circle effect1">
            <a href="menutype.action?type=汤">
                <div class="spinner"></div>
                <div class="img"><img src="images/3.jpg" height=200 width=200></div>
                <div class="info">
                    <div class="info-back">
                        <h3>炖汤</h3>

                        <p></p>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <div class="case-item">
        <div class="ih-item circle effect1">
            <a href="menutype.action?type=甜品">
                <div class="spinner"></div>
                <div class="img"><img src="images/4.jpg" height=200 width=200></div>
                <div class="info">
                    <div class="info-back">
                        <h3>甜品</h3>

                        <p></p>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <div class="case-item">
        <div class="ih-item circle effect1">
            <a href="menutype.action?type=饮料">
                <div class="spinner"></div>
                <div class="img"><img src="images/5.jpg" height=200 width=200></div>
                <div class="info">
                    <div class="info-back">
                        <h3>饮料类</h3>

                        <p></p>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <div class="case-item">
        <div class="ih-item circle effect1">
            <a href="menutype.action?type=炒饭">
                <div class="spinner"></div>
                <div class="img"><img src="images/6.jpg" height=200 width=200></div>
                <div class="info">
                    <div class="info-back">
                        <h3>炒饭类</h3>

                        <p></p>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <div class="case-item">
        <div class="ih-item circle effect1">
            <a href="menutype.action?type=炒饭">
                <div class="spinner"></div>
                <div class="img"><img src="images/7.jpg" height=200 width=200></div>
                <div class="info">
                    <div class="info-back">
                        <h3>炒饭</h3>

                        <p></p>
                    </div>
                </div>
            </a>
        </div>
    </div>

    <div class="case-item">
        <div class="ih-item circle effect1">
            <a href="menutype.action?type=汤">
                <div class="spinner"></div>
                <div class="img"><img src="images/8.jpg" height=200 width=200></div>
                <div class="info">
                    <div class="info-back">
                        <h3>煲汤</h3>

                        <p></p>
                    </div>
                </div>
            </a>
        </div>
    </div>

</div>


</body>
</html>
