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
<link rel="stylesheet" type="text/css" href="css/news.css">
<body>

<center>
    <div class="article" align="center">

        <ul class="newslist">
            <%--${test }--%>
            <c:if test="${!empty articleList}">
                <c:forEach items="${articleList }" var="article">
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
        <div>
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <div class="pagination pagination-right">
                            <c:if test="${page>1}">
                                <a href="companyArticle.action?page=${page-1}">上一页</a>
                            </c:if>
                            <a href="companyArticle.action?page=${page+1}">下一页</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</center>

</body>
</html>
