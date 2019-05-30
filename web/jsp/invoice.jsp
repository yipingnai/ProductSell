<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/25/2019
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #invoice{
            width: 800px;
            height: auto;
            margin: 0 auto;
            background: #E6E6E6;
        }
    </style>
</head>
<body>
<%@include file="head.jsp"%>
<c:if test="${empty invoice}">
    <h1>没有订单，快去购物下单吧！</h1>
</c:if>
<c:if test="${not empty invoice}">
    <div id="invoice">
        <table border="1" style="width: 100%">
            <tr>
                <td colspan="2">发票编号:${invoice.iid}</td>
                <td colspan="2">发票日期:${invoice.date}</td>
            </tr>
            <tr>
                <td>产品名称</td>
                <td>单价</td>
                <td>数量</td>
                <td>小计</td>
            </tr>
            <c:forEach items="${invoice.list}" var="invoiceItem">
                <tr>
                    <td>${invoiceItem.product.pname}</td>
                    <td>${invoiceItem.product.price}</td>
                    <td>${invoiceItem.quantity}</td>
                    <td>${invoiceItem.subTotal}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2"><a href="#"> 删除发票</a></td>
                <td colspan="2">总金额：${invoice.total}</td>
            </tr>
        </table>
    </div>
</c:if>
</body>
</html>
