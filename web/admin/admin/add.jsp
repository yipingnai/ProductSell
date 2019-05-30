<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/27/2019
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <form action="${pageContext.request.contextPath}/AdminServlet?method=addAdmin" method="post">
        <tr>
            <td>管理员名字</td>
            <td><input type="text"  name="aname"/></td>
        </tr>
        <tr>
            <td>管理员账号</td>
            <td><input type="text" name="anumber"/></td>
        </tr>
        <tr>
            <td>管理员密码</td>
            <td><input type="text" name="apassword"/></td>
        </tr>
        <tr>
            <td>管理员类型</td>
            <td>
                1<input type="radio" name="type" value="1"/>
                2<input type="radio" name="type" value="2"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"/></td>
        </tr>
    </form>
</table>

</body>
</html>
