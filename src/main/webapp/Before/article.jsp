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
<body>
<c:if test="${article !=null}">
    <h2>
            ${article.title }
    </h2>
    ${article.content }
</c:if>

<c:import url="footer.jsp"></c:import>
</body>
</html>
