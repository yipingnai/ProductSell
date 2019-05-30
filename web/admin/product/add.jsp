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
<form action="${pageContext.request.contextPath}/AdminProductServlet?method=addProduct" method="post">
    <table>
        <tr>
            <td>产品名称</td>
            <td><input type="text" name="pname"/></td>
        </tr>
        <tr>
            <td>产品详情</td>
            <td><textarea cols="40" rows="5" name="info"></textarea></td>
        </tr>
        <tr>
            <td>产品规格</td>
            <td><input type="text" name="format"/></td>
        </tr>
        <tr>
            <td>产品价格</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>产品数量</td>
            <td><input type="text" name="amount"/></td>
        </tr>
        <tr>
            <td>所属分类</td>
            <td>
                <select name="pcid">
                    <option value="null">--请选择--</option>
                    <c:forEach items="${adminFindCategory}" var="c">
                        <option value="${c.pcid}">${c.pcname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="添加"/></td>
        </tr>
    </table>

</form>
</body>
</html>
