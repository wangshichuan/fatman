<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/4
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="header.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="css/news.css">
<body>
<center>
    <div class="main_content">
        <div class="conwrap">
            <div class="newshead"><h1>${article.title }</h1>

                <p>发表日期：${article.date}&nbsp;&nbsp;&nbsp;&nbsp;浏览次数：51</p>
            </div>
            <div class="dbline"></div>
            ${article.content }
            <div class="prevnext">
                <%--<a class="prev"--%>
                   <%--href="http://www.cqqq.cn/qqzx-post-id-297.html">上一篇：齐齐火锅2016年清明节放假通知</a>--%>
                <%--<a--%>
                        <%--class="next" href="http://www.cqqq.cn/qqzx-post-id-301.html">下一篇：没有了</a>--%>
            </div>
        </div>
    </div>
</center>


<%--<c:if test="${article !=null}">--%>
<%--<h2>--%>
<%--${article.title }--%>
<%--</h2>--%>
<%--${article.content }--%>
<%--</c:if>--%>

<c:import url="footer.jsp"></c:import>
</body>
</html>
