<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 2019/5/16
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <style>
        #product_info{
            width: 500px;
            height: 500px;
            background: bisque;
            margin: 0 auto;
        }
    </style>
</head>
<body>

    <%@include file="head.jsp"%>
    <div id="product_info">
        <form action="${pageContext.request.contextPath}/CartServlet?method=addCartItemToCart" method="post">
            <table style="width: 100%;height: 100%" border="1">
                <tr style="height: 10%;align-content: center">
                    <td colspan="2">${productNewInfo.pname}</td>
                </tr>
                <tr style="height: 70%;align-content: center">
                    <td colspan="2">${productNewInfo.info}</td>
                </tr>
                <tr style="height: 10%;align-content: center">
                    <td>库存：${productNewInfo.amount}</td>
                    <td>
                        <input type="hidden" name="pid" value="${productNewInfo.pid}"/>
                        购买数量<input id="quantity" name="quantity" value="1" maxlength="4" size="10" type="text"/>
                    </td>
                </tr>
                <tr style="height: 10%;align-content: center">
                    <td>价格：${productNewInfo.price}</td>
                    <td>
                        <input id="btnId" style="height:36px;width:127px;" value="加入购物车" type="submit">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
