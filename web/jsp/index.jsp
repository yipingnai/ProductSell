<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 2019/5/16
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品首页</title>
    <style>
        .product{
            width: auto;
            height: 1200px;
            background: aliceblue;
        }
        .productxiao{
            float: left;
            width: 300px;
            height: 300px;
            margin-left: 100px;
            margin-top: 100px;
            background: aquamarine;
            position: relative;
        }
    </style>
</head>
<body>
<%@include file="head.jsp"%>
<br/><br/><br/><br/>
    <c:if test="${empty products}">
        <h2>暂无产品</h2>
    </c:if>
    <c:if test="${not empty products}">
        <div class="product">
            <c:forEach items="${products}" var="p">
                <div class="productxiao">
                    <table border="1" style="width: 298px;height: 298px;text-align: center">
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/ProductServlet?method=productInfo&pid=${p.pid}">${p.pname}</a></td>
                        </tr>
                        <tr style="height: 150px">
                            <td>${p.info}</td>
                        </tr>
                        <tr>
                            <td>${p.price}</td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/ProductServlet?method=productInfo&pid=${p.pid}">购买</a> </td>
                        </tr>
                    </table>
                </div>
            </c:forEach>
        </div>
    </c:if>
</body>
</html>
