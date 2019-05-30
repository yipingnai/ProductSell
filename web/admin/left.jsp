<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/22/2019
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>菜单</title>
</head>
<body>
    <li  style="list-style-type:none">
        <h1>分类管理</h1>
        <dl>
            <dd><a target="rightcontext" href="${pageContext.request.contextPath}/AdminCategoryServlet?method=findAllCategory">查询分类</a></dd>
            <dd><a target="rightcontext" href="${pageContext.request.contextPath}/AdminCategoryServlet?method=addCategoryUI">添加分类</a></dd>
        </dl>
    </li>
    <li style="list-style-type:none">
        <h1>产品管理</h1>
        <dl>
            <dd><a target="rightcontext" href="${pageContext.request.contextPath}/AdminProductServlet?method=findAllProduct">查询产品</a></dd>
            <dd><a target="rightcontext" href="${pageContext.request.contextPath}/AdminProductServlet?method=addProductUI">添加产品</a></dd>
        </dl>
    </li>
    <li style="list-style-type:none">
        <h1>用户管理</h1>
        <dl>
            <dd><a target="rightcontext" href="${pageContext.request.contextPath}/AdminCustomerServlet?method=findAllCustomer">查询用户</a></dd>
            <dd><a target="rightcontext" href="${pageContext.request.contextPath}/AdminCustomerServlet?method=addCustomerUI">添加用户</a></dd>
        </dl>
    </li>
    <c:if test="${newAdmin.type == 1}">
        <li style="list-style-type:none">
        <h1>管理员管理</h1>
        <dl>
            <dd><a target="rightcontext" href="${pageContext.request.contextPath}/AdminServlet?method=findAdminByType&type=2">查询管理员</a></dd>
            <dd><a target="rightcontext" href="${pageContext.request.contextPath}/AdminServlet?method=addAdminUI">添加管理员</a></dd>
        </dl>
        </li>
    </c:if>
</body>
</html>
