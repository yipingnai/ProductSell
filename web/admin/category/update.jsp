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
        <form action="${pageContext.request.contextPath}/AdminCategoryServlet?method=updateCategory" method="post">
            <input type="text" value="${newCategory.pcid}" name="pcid" hidden/>
            分类名：<input type="text" name="pcname" value="${newCategory.pcname}"/><br/>
            <input type="submit" value="修改"/>
        </form>
</body>
</html>
