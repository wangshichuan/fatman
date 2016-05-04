<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/4
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="header.jsp"></c:import>

<body>
<center>

    <div class="mainright">
        <div class="article">
            <h3>企业资讯<sub>COMPANY NEWS</sub></h3>
            <ul>
               <%--${test }--%>
                <c:if test="${!empty articleList}">
                    <c:forEach items="${articleList }" var="article" >
                        <li>
                            <a href="companyArticleDetail.action?id=${article.articleId }">
                            ${article.title }
                            </a>
                            <span> ${article.date } </span>
                        </li>
                    </c:forEach>
                    <s:else>没有文章</s:else>
                </c:if>


            </ul>
        </div>
    </div>
</center>
</body>
</html>
