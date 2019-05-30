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
    <title>管理员登录</title>
    <style>

        .formGong{
            width: 500px;
            height: 300px;
            background: bisque;
            margin: 0 auto;
            text-align:center
        }
    </style>
</head>
<body>
<div class="formGong">
    <h1>产品销售管理系统</h1>
    ${msg}<br/>
    <form method="post" action="${pageContext.request.contextPath}/AdminServlet?method=adminLogin">
        账号：<input type="text" name="anumber"/><br/><br/>
        密码：<input type="password" name="apassword"/><br/><br/><br/>
        <input type="submit" value="进入管理中心"/><br/>
    </form>
</div>
</body>
