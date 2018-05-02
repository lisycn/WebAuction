<%@ page import="com.example.entity.Users" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<c:choose>
    <c:when test="${!empty sessionScope.users}">
        <%--<%
            Users users = (Users) session.getAttribute("users");
            if (users != null) {
        %>--%>
        <div class="panel panel-info">
            <div class="panel-heading">您已登陆</div>
            <div class="panel-body">
                <p>当前用户: </p>
                <h1 align="center">${sessionScope.users.username}</h1>
                <hr/>
                <p>电话: <strong>${sessionScope.users.telephone}</strong></p>
                <p>地址: <strong>${sessionScope.users.address}</strong></p>
                <hr/>
                <a class="btn btn-info btn-block" href="${pageContext.request.contextPath}/jsp/add_goods.jsp">发布商品</a>
                <a class="btn btn-info btn-block" href="<s:url namespace="/goods" action="showMyGoods"/>">我的卖品</a>
                <a class="btn btn-info btn-block" href="${pageContext.request.contextPath}/jsp/change_detail.jsp">修改资料</a>
                <a class="btn btn-danger btn-block" href="<s:url namespace="/users" action="logout"/>">注销登录</a>
            </div>
        </div>
        <%--<%
        } else {
        %>--%>
    </c:when>
    <c:when test="${empty sessionScope.users}">
        <div class="panel panel-info">
            <div class="panel-heading">您未登录</div>
            <div class="panel-body">
                <form class="form" action="<s:url namespace="/users" action="login"/>" method="POST">
                    <div class="form-group">
                        <label class="sr-only" for="username">username</label>
                        <div class="input-group">
                            <div class="input-group-addon">账户</div>
                            <input type="text" class="form-control" name="users.username" id="username"
                                   placeholder="username">
                        </div>
                    </div>
                    <p></p>
                    <div class="form-group">
                        <label class="sr-only" for="password">password</label>
                        <div class="input-group">
                            <div class="input-group-addon">密码</div>
                            <input type="password" class="form-control" name="users.password" id="password"
                                   placeholder="password">
                        </div>
                    </div>
                    <p></p>
                    <button type="submit" class="btn btn-large btn-primary btn-block">登录</button>
                    <button type="reset" class="btn btn-large btn-danger btn-block">重置</button>
                    <a class="btn btn-large btn-info btn-block"
                       href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a>
                </form>
            </div>
        </div>
        <%--
        <%
            }
        %>--%>
    </c:when>
</c:choose>