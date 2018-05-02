<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 4.25
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="f1" action="<s:url action="login"/>" method="post">
    <table align="center">
        <tr>
            <td colspan="2">用户名：</td>
        </tr>
        <tr>
            <td colspan="2"><input type="text" name="users.username" size=10" class="editbox"></td>
        </tr>
        <tr>
            <td colspan="2">密&nbsp;&nbsp;码：</td>
        </tr>
        <tr>
            <td colspan="2"><input type="password" name="users.password" size=10"  class='editbox'></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登录" class='btn'>
                <input type="reset" value="重置" class='btn'>
            </td>
        </tr>
        <tr>
            <td><a href="/jsp/register.jsp">用户注册</a></td>
        </tr>
        <tr>
            <td width='100'><a href="/index.jsp">返回首页</a></td>
        </tr>
    </table>
</form>

</body>
</html>
