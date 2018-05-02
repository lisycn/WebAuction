<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <%@include file="user.jsp" %>
        </div>
        <div class="col-md-9 column">
            <div class="panel panel-info">
                <div class="panel-heading">修改密码</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-12 column">
                            <form class="form" action="<s:url namespace="/users" action="changePassword"/>"
                                  method="POST"
                                  enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="sr-only" for="username">账号</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">账号</div>
                                        <input type="text" class="form-control" name="users.username" id="username"
                                               value="${sessionScope.users.username}">
                                    </div>
                                </div>
                                <p></p>
                                <div class="form-group">
                                    <label class="sr-only" for="password">密码</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">密码</div>
                                        <input type="text" class="form-control" name="users.password" id="password"
                                               value="${sessionScope.users.password}">
                                    </div>
                                </div>
                                <p></p>
                                <div class="form-group">
                                    <label class="sr-only" for="telephone">电话</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">电话</div>
                                        <input type="text" class="form-control" name="users.telephone" id="telephone"
                                               value="${sessionScope.users.telephone}">
                                    </div>
                                </div>
                                <p></p>
                                <div class="form-group">
                                    <label for="address">地址</label>
                                    <textarea rows="3" class="form-control" name="users.address"
                                              id="address">${sessionScope.users.address}</textarea>
                                </div>
                                <p></p>
                                <button type="submit" class="btn btn-large btn-primary">提交</button>
                                <button type="reset" class="btn btn-large btn-danger">重置</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>