<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/5
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="guestbk" >
    <form onsubmit="return validator()" action="company_join_add.action" method="post" name="form1" id="form1">
        <div id="guestsmt">
            <textarea class="useript guestinfo" rows="10" cols="30" id="" name="content"></textarea>

            <div>
                <span>称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;呼：</span><input type="text" value="" class="useript usertel" id="name" name="name">
            </div>
            <div>
                <span>联系方式：</span><input type="text" value="" class="useript usertel" id="contact" name="contact">
            </div>
            <div>
                <p><input type="submit" class="userbtn usersbmt" value="提 交" name=""></p>
            </div>
        </div>
    </form>
</div>
</body>
</html>
