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
  <title>index.html</title>

  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="this is my page">
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">

  <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
  <link rel="stylesheet" href="css/bootstrapPeople.min.css">
  <script src="js/jqueryPeople.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
  function searchday() {
    window.location.href = "searchtimes.action?keyword=" + document.getElementById("key").value;

  }

</script>
<body style="background-color:#CFF">

<table class="table">
  <thead>
  <tr>
    <th>id</th>
    <th width="50px" height="50px">联系人</th>
    <%--<th>内容</th>--%>
    <th>联系方式</th>
    <th>留言</th>
    <th>日期</th>
    <th>操作</th>
  </tr>
  </thead>
  <tbody>
  <c:if test="${joinList!=null}">
    <c:forEach items="${joinList }" var="join">
      <tr class="info">
        <td>${join.id }</td>
        <td >${join.name}</td>
        <td>${join.contact }</td>
        <td>${join.note }</td>
        <td>${join.date }</td>
        <td>
          <a href="company_honor_pass.action?type=1&id=${join.id }">通过</a>
          <a href="company_honor_delete.action?type=-1&id=${join.id }">取消加盟</a>
            <%--<a href="company_article_edit.action/id=${article.articleId }">修改</a>--%>
        </td>
      </tr>
    </c:forEach>

  </c:if>
  </tbody>
</table>
</body>
</html>
