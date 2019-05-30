<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 2019/5/16
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        #customer{
            width: 500px;
            height: 280px;
            margin: 0 auto;
            background: bisque;
            align-content: center;
        }
    </style>
</head>
<body>
<div id="customer">
    <form action="${pageContext.request.contextPath}/CustomerServlet?method=login" method="post">
        <table border="1">
            <c:if test="${not empty msg}">
                <tr>
                    <td colspan="2"><h1 style="color: brown">${msg}</h1></td>
                </tr>
            </c:if>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="cname"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="cpassword"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>


    </form>
</div>

</body>
</html>
