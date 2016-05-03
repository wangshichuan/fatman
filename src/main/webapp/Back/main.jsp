
<%@ page language="java" import="java.util.*,Model.MenuModel"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理主页面</title>
</head>
<frameset rows="45,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame"  noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="186,*" frameborder="no" border="0" framespacing="0">
  <c:if test="${admin!=null }">
    <frame src="left.jsp" name="leftFrame"  noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="index.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
    <frame src="menu.jsp" name="rightFrame" id="menuFrame" title="rightFrame" />
    <frame src="user.jsp" name="rightFrame" id="userFrame" title="rightFrame" />
    </c:if>
    <c:if test="${admin==null }">
    
   	 <frame src="" name="rightFrame" id="welcomeFrame" title="rightFrame" />
   	 <frame src="welcome.jsp" name="rightFrame" id="welcomeFrame" title="rightFrame" />
    </c:if>
  </frameset>
</frameset>
<noframes><body>
</body></noframes>
</html>
