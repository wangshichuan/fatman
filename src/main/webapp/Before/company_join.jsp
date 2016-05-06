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
<title>加盟连锁</title>

<body>


    <div class="main" style="align-content: center">
        <table>
            <tbody>

            <c:if test="${flag!=null}">
                <td>
                    <h4 style="color: green">成功</h4>
                </td>
            </c:if>

            <td>
                <p style="float: left;" >
                    &#12288;&#12288;为了让加盟者对加盟莽子火锅有更清楚的了解，重庆火锅加盟流程文字说明如下：<br>
                    &#12288;&#12288;1：加盟咨询，包括电话，网站留言或者来访。<br>
                    &#12288;&#12288;2：提供申请表并进行登记。<br>
                    &#12288;&#12288;3：双方初步面谈，品尝莽子火锅，总部提供加盟资料。<br>
                    &#12288;&#12288;4：签订《加盟意向书》并缴纳资格定金。<br>
                    &#12288;&#12288;5：加盟市场的考察及选址的确认，评估。<br>
                    &#12288;&#12288;6：签订《特许加盟合同》并提供管理资料。<br>
                    &#12288;&#12288;7：开业计划的拟定，包含两方面。<br>
                    &#12288;&#12288;A:开业物配清单（表）的确定，物资配送。<br>
                    &#12288;&#12288;B：营建规划及店面设计，店面装修施工人员招募及培训。<br>
                    &#12288;&#12288;8：支持人员及物资到位。<br>
                    &#12288;&#12288;9：试营业。<br>
                    &#12288;&#12288;10：正式营业。<br>
                    &#12288;&#12288;11：营运督导支持。
                </p>
                <h3>加盟请留言</h3>
                <c:import url="contact.jsp"></c:import>
            </td>
            <td>
                <img width="737" height="821" alt="莽子火锅加盟流程" title="莽子火锅加盟流程" src="images/join.jpg">
            </td>
            </tbody>
        </table>


    </div>




</body>
</html>
