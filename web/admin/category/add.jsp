<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/23/2019
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/AdminCategoryServlet?method=addCategory" method="post">
        <table border="1">
            <tr>
                <td>产品名</td>
                <td><input type="text" name="pcname"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="添加"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
