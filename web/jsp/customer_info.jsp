<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 2019/5/16
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="top">
    <%@include file="head.jsp"%>
    <table border="1" width="300px">
        <tr>
            <td>名称</td>
            <td>${loginCustomer.cname}</td>
        </tr>
        <tr>
            <td>地址</td>
            <td>${loginCustomer.address}</td>
        </tr>
        <tr>
            <td>电话</td>
            <td>${loginCustomer.telephone}</td>
        </tr>
        <tr>
            <td>信用</td>
            <td>${loginCustomer.credit}</td>
        </tr>
        <tr>
            <td>预付款</td>
            <td>${loginCustomer.subsist}</td>
        </tr>
        <tr>
            <td colspan="2"><a href="#">修改个人信息</a></td>
        </tr>
    </table>
</body>
</html>
