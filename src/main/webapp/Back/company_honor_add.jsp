<%@ page language="java" import="java.util.*,Model.MenuModel"

         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<c:if test="${flag==1 }">
    <center>
        <h1 style="color: red">新增成功</h1>
    </center>
    <s:else>失败了~</s:else>
</c:if>

<div style="margin-left: 35%">

    <form name="myform" action="company_honor_add.action" method="post" enctype="multipart/form-data">
        <input type="hidden" name="menuid"/>
        <input id="root" type="hidden" name="root"/>
        <div>
            上传图片 ：<input type="file" name="file" id="file"/><br/>
        </div>
        <div>
            标题：<input type="text" name="title"/><br/>
        </div>
        <div>
            内容：<input type="text" name="content"/><br/>
        </div>
        <div>
            备注：<input type="text" name="note"/><br/>
        </div>
        </select><br/>
        <button type="submit" class="btn">确定</button>
    </form>
</div>


</body>
</html>
