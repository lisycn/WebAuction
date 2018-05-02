<%@ page contentType="text/html;charset=UTF-8" %>
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
                <div class="panel-heading">我的拍卖商品列表</div>
                <div class="panel-body">
                    <div class="row">
                        <%--@elvariable id="myGoodsList" type="com.example.entity.Goods"--%>
                        <c:if test="${empty myGoodsList}">
                            <h1>您暂未发布卖品</h1>
                        </c:if>
                        <s:iterator var="goods" value="#request.myGoodsList">
                            <div class="col-md-3 column">
                                <!-- 显示在拍商品信息 -->
                                <div class="goods_pic">
                                    <img width="150px" title="${goods.goodsDesc}"
                                         src="/uploadImages/${goods.goodsPic}">
                                </div>
                            </div>
                            <div class="col-md-3 column">
                                <p class="info_title">商品名称:&nbsp;<strong>${goods.goodsName}</strong></p>
                                <p class="info_title">卖 &nbsp;&nbsp; 家:&nbsp;<strong>${goods.seller.username}</strong>
                                </p>
                                <p class="info_title">起 拍 价:&nbsp;<span
                                        style="color: green;"><strong>￥${goods.goodsPrice}</strong></span></p>
                                <p id="deal"></p>
                            </div>
                            <div class="col-md-6 column">
                                <!-- 显示在拍商品信息 -->
                                <c:if test="${!empty goods.bidSet}">
                                    <div>
                                        <p>出价记录:</p>
                                        <table border="0">
                                            <s:iterator var="b" value="#goods.bidSet">
                                                <tr>
                                                    <td><strong><s:property value="#b.buyer.username"/></strong>&nbsp;&nbsp;
                                                    </td>
                                                    <td>于<em><s:date name="#b.bidTime" format="yyyy-MM-dd hh:mm"/></em>&nbsp;&nbsp;
                                                    </td>
                                                    <td>出价: &nbsp;<strong>￥<s:property value="#b.bidPrice"/></strong>&nbsp;&nbsp;
                                                    </td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${b.bidStatus != 1}">
                                                                <s:url namespace="/bid" action="doDeal" var="doDealTag">
                                                                    <s:param name="bidId">${b.id}</s:param>
                                                                </s:url>
                                                                <a class="btn" href="<s:property value="#doDealTag"/> ">
                                                                    成交
                                                                </a>
                                                            </c:when>
                                                            <c:when test="${b.bidStatus == 1}">
                                                                <strong>已成交</strong>
                                                            </c:when>
                                                        </c:choose>
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </table>
                                    </div>
                                </c:if>
                            </div>
                            <div class="col-md-12 column">
                                <hr/>
                            </div>
                            <!-- 如果出价记录不为空，在每个商品下显示出价记录 -->
                        </s:iterator>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>