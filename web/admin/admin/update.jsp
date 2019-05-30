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
    <form action="${pageContext.request.contextPath}/AdminServlet?method=updateAdminByAid" method="post">
        <input type="hidden" name="aid" value="${newAdmin2.aid}"/>
        <input type="hidden" name="type" value="${newAdmin2.type}"/>
        <tr>
            <td>管理员名字</td>
            <td><input type="text" value="${newAdmin2.aname}" name="aname"/></td>
        </tr>
        <tr>
            <td>管理员账号</td>
            <td><input type="text" value="${newAdmin2.anumber}" name="anumber"/></td>
        </tr>
        <tr>
            <td>管理员密码</td>
            <td><input type="text" value="${newAdmin2.apassword}" name="apassword"/></td>
        </tr>
        <tr>
            <td>管理员类型</td>
            <td>
                1<input type="radio" name="type" <c:if test="${newAdmin2.type == 1}">checked</c:if>/>
                2<input type="radio" name="type" <c:if test="${newAdmin2.type == 2}">checked</c:if>/>
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="修改"/></td>
        </tr>
    </form>
</table>

</body>
</html>
