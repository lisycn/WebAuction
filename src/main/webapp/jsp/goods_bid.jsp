<%--@elvariable id="goodsBid" type="com.example.entity.Goods"--%>
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
                <div class="panel-heading">我要出价</div>
                <div class="panel-body">
                    <div class="row">
                        <%--<div class="col-md-12 column">--%>
                        <div class="col-md-6 column">
                            <!-- 显示在拍商品信息 -->
                            <div class="goods_pic">
                                <img width="300px" title="${goodsBid.goodsDesc}"
                                     src="/uploadImages/${goodsBid.goodsPic}">
                            </div>
                        </div>
                        <div class="col-md-6 column">
                            <p class="info_title">商品名称:&nbsp;<strong>${goodsBid.goodsName}</strong></p>
                            <p class="info_title">卖 &nbsp;&nbsp;
                                家:&nbsp;<strong>${goodsBid.seller.username}</strong>
                            </p>
                            <p class="info_title">商品描述:<p>&nbsp;&nbsp;&nbsp;&nbsp;${goodsBid.goodsDesc}</p></p>
                            <p class="info_title">起 拍 价:&nbsp;<span
                                    style="color: green;"><strong>￥${goodsBid.goodsPrice}</strong></span>
                            </p>
                            <p></p>
                            <form class="form" action="<s:url namespace="/bid" action="doBid"/>" method="POST">
                                <input type="hidden" name="goods.id" value="${goodsBid.id}">
                                <input class="form-control" type="number" name="bidPrice" placeholder="请出价...">
                                <p></p>
                                <button type="submit" class="btn btn-large btn-primary">提交</button>
                                <button type="reset" class="btn btn-large btn-danger">重置</button>
                            </form>
                        </div>
                        <div class="col-md-12 column">
                            <!-- 显示在拍商品信息 -->
                            <hr/>
                            <c:if test="${!empty goodsBid.bidSet}">
                                <div>
                                    <p>出价记录:</p>
                                    <table border="0">
                                        <s:iterator var="b" value="#request.goodsBid.bidSet">
                                            <tr>
                                                <td><strong><s:property value="#b.buyer.username"/></strong>&nbsp;&nbsp;
                                                </td>
                                                <td>于<em><s:date name="#b.bidTime" format="yyyy-MM-dd hh:mm"/></em>&nbsp;&nbsp;
                                                </td>
                                                <td>出价: &nbsp;<strong>￥<s:property value="#b.bidPrice"/></strong>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                    </table>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>