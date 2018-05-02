<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel-heading">拍卖商品列表</div>
<div class="panel-body">
    <div class="row">
        <s:iterator var="goods" value="#request.onSellGoodsList">
            <div class="col-md-3 column">
                <!-- 显示在拍商品信息 -->
                <div class="goods_pic">
                    <img width="150px" title="${goods.goodsDesc}"
                         src="/uploadImages/${goods.goodsPic}">
                </div>
            </div>
            <div class="col-md-3 column">
                <p class="info_title">商品名称:&nbsp;<strong>${goods.goodsName}</strong></p>
                <p class="info_title">卖 &nbsp;&nbsp; 家:&nbsp;<strong>${goods.seller.username}</strong></p>
                <p class="info_title">商品描述:&nbsp;<strong>${goods.goodsDesc}</strong></p>
                <p class="info_title">起 拍 价:&nbsp;<span
                        style="color: green;"><strong>￥${goods.goodsPrice}</strong></span></p>

                <c:if test="${!empty sessionScope.users and goods.seller.id != sessionScope.users.id }">
                    <form class="form">
                    <s:url namespace="/goods" action="doBid" var="urlTag">
                        <s:param name="goods.id">${goods.id}</s:param>
                    </s:url>
                    <a class="btn btn-info" href="<s:property value="#urlTag" />">
                        我要出价
                    </a>
                    </form>
                </c:if>
            </div>
            <div class="col-md-6 column">
                <!-- 显示在拍商品信息 -->
                <c:if test="${!empty goods.bidSet}">
                    <div>
                        <p>出价记录:</p>
                        <table border="0">
                            <s:iterator var="b" value="#goods.bidSet">
                                <tr>
                                    <td><strong><s:property value="#b.buyer.username"/></strong>&nbsp;&nbsp;</td>
                                    <td>于<em><s:date name="#b.bidTime" format="yyyy-MM-dd hh:mm"/></em>&nbsp;&nbsp;</td>
                                    <td>出价: &nbsp;<strong>￥<s:property value="#b.bidPrice"/></strong></td>
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