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
<title>公司荣誉</title>

<body>
<center>
    <div class="mainright">
        <tbody>
        <tr valign="top" bordercolor="#000000">
            <td valign="top" height="29">企业荣誉</td>
        </tr>

        <tr align="center">
            <td height="89" colspan="2">
                <table border="0" width="679" height="357">
                    <tbody>
                    <tr>
                        <td width="335" height="241">
                            <div align="center"><img width="329" height="239" src="images/honor5.jpg"></div>
                        </td>
                        <td width="334">
                            <div align="center"><img width="312" height="239" src="images/honor4.jpg"></div>
                        </td>
                    </tr>
                    <tr>
                        <td height="107" colspan="2">&nbsp;</td>
                    </tr>
                    </tbody>
                </table>
                <p>&nbsp;</p></td>
        </tr>

        <tr align="center">
            <td height="52" colspan="2">
                <table border="0" width="676" height="255">
                    <tbody>
                    <c:if test="${honorList!=null}">
                        <c:forEach items="${honorList }" var="honor">
                            <tr>
                                <td width="334" height="251"><p align="center" class="style21">
                                    <img width="312" height="239" src="${honor.pic_url}"></p>
                                </td>
                                <td width="332"><p align="left">
                                        ${honor.content}
                                        <%--<img width="312" height="239" src="images/honor2.jpg"></p>--%>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </div>
</center>
</body>
</html>
