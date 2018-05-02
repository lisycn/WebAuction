<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>拍卖网</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <h3><a href="${pageContext.request.contextPath}/" style="text-decoration: none; padding-left: 10px">拍卖网</a></h3>
    <hr/>
</header>

<div id="app" class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-3 column">
            <%@include file="jsp/user.jsp" %>
        </div>
        <div class="col-md-9 column">
            <div class="panel panel-info">
                <s:action name="showOnSellGoods" namespace="/goods" executeResult="true">
                </s:action>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="style/js/auction.js"></script>
</html>
