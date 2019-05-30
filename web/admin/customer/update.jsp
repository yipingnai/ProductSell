<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/24/2019
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AdminCustomerServlet?method=updateCustomer" method="post">
    <input name="cid" value="${newCustomer.cid}" type="hidden"/>
    <table border="1">
        <tr>
            <td>名字</td>
            <td><input type="text" name="cname" value="${newCustomer.cname}"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="cpassword" value="${newCustomer.cpassword}"/></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="telephone" value="${newCustomer.telephone}"/></td>
        </tr>
        <tr>
            <td>信用</td>
            <td>
                <input type="radio" name="credit" value="1" <c:if test="${newCustomer.credit == 1}">checked</c:if>/>优
                <input type="radio" name="credit" value="2" <c:if test="${newCustomer.credit == 2}">checked</c:if>/>良
                <input type="radio" name="credit" value="3" <c:if test="${newCustomer.credit == 3}">checked</c:if>/>一般
                <input type="radio" name="credit" value="4" <c:if test="${newCustomer.credit == 4}">checked</c:if>/>差
            </td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                <input type="radio" name="type" value="1" <c:if test="${newCustomer.type == 1}">checked</c:if>/>黄金会员
                <input type="radio" name="type" value="2" <c:if test="${newCustomer.type == 2}">checked</c:if>/>白银会员
                <input type="radio" name="type" value="3" <c:if test="${newCustomer.type == 3}">checked</c:if>/>普通会员
            </td>
        </tr>
        <tr>
            <td>预付款</td>
            <td><input type="text" name="subsist" value="${newCustomer.subsist}"/></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address" value="${newCustomer.address}"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改"/></td>
        </tr>
    </table>
</form>
</body>
</html>
