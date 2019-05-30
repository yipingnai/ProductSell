<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/25/2019
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #cart{
            width: 800px;
            height: auto;
            margin: 0 auto;
            background: #E6E6E6;
        }
    </style>
</head>
<body>
<%@include file="head.jsp"%>
<c:if test="${empty cart.list}">
    <a>购物车没有产品，快去购物吧！</a>
</c:if>
<c:if test="${not empty cart.list}">
    <div id="cart">
        <table border="1" style="width: 100%">
            <tr>
                <td>产品信息</td>
                <td>产品单价</td>
                <td>产品数量</td>
                <td>产品小计</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${cart.list}" var="cartItem">
                <tr>
                    <td>${cartItem.product.pname}</td>
                    <td>${cartItem.product.price}</td>
                    <td>${cartItem.quantity}</td>
                    <td>${cartItem.subTotal}</td>
                    <td><a href="${pageContext.request.contextPath}/CartServlet?method=removeCartItem&pid=${cartItem.product.pid}">移除产品</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td>总计：${cart.total}</td>
                <td colspan="2">
                    <a href="${pageContext.request.contextPath}/CartServlet?method=removeCart" >清空购物车</a>
                </td>
                <td colspan="2">
                    <a href="${pageContext.request.contextPath}/InvoiceServlet?method=saveCartToInvoice&subsist=${loginCustomer.subsist}" style="color: orange">下单</a>
                </td>
            </tr>
        </table>
    </div>
</c:if>
</body>
</html>
