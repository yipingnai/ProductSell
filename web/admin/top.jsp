<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/21/2019
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>top</title>
</head>
<body>

<ul style="list-style-type:none">
    <li style="float: right">
        <a href="${pageContext.request.contextPath}/AdminServlet?method=exitLogin">退出</a>
    </li>
    <li style="float: right;margin-right: 20px">
        <c:if test="${newAdmin.type == 1}">
            欢迎<a href="#" style="color: red">${newAdmin.aname}</a>超级管理员
        </c:if>
        <c:if test="${newAdmin.type == 2}">
            欢迎<a href="#" style="color: red">${newAdmin.aname}</a>普通管理员
        </c:if>
    </li>
    <li style="float: right;margin-right: 20px"><a href="#">产品首页</a></li>
</ul>
</body>
