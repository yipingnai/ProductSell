<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/25/2019
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #invoice{
            width: 70%;
            margin: 0 auto;
            background: bisque;
        }
    </style>
</head>
<body>
<%@include file="head.jsp"%>
<c:if test="${empty invoices}">
    <h1>没有订单，快去购物下单吧！</h1>
</c:if>
<c:if test="${not empty invoices}">
    <div id="invoice">
        <h1 style="color: blue;margin-left: 400px">所有订单信息</h1>
        <c:forEach items="${invoices}" var="invoiceItem">
            <table border="1" style="width: 100%">
                <tr>
                    <td colspan="2" style="width: 50%">发票编号:${invoiceItem.iid}</td>
                    <td colspan="2" style="width: 50%">发票日期:${invoiceItem.date}</td>
                </tr>
                <tr>
                    <td style="width: 25%">产品名称</td>
                    <td style="width: 25%">单价</td>
                    <td style="width: 25%">数量</td>
                    <td style="width: 25%">小计</td>
                </tr>
                <c:forEach items="${invoiceItem.list}" var="invoiceItemItem">
                    <tr>
                        <td>${invoiceItemItem.product.pname}</td>
                        <td>${invoiceItemItem.product.price}</td>
                        <td>${invoiceItemItem.quantity}</td>
                        <td>${invoiceItemItem.subTotal}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="2"><a href="#"> 删除发票</a></td>
                    <td colspan="2">总金额：${invoiceItem.total}</td>
                </tr>
            </table>
            <hr style="color: #012F68"/>
        </c:forEach>
    </div>
</c:if>
</body>
</html>
