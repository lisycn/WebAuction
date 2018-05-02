<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>
    <s:if test="#request.errorMsg !=null">
        ${requestScope.errorMsg}
    </s:if>
    <s:else>
        系统发生未知异常，请联系管理员或稍后再试！
    </s:else>
</h1>
</body>
</html>
