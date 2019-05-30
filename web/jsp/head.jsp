<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 2019/5/16
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        #top{
            width: auto;
            height: 30px;
            background: aliceblue;
            text-align: right;
        }
        .lihead {
            width: 100px;
            height: 30px;
            border: thin dotted #6F9; /*设置<li>的边框*/
            text-align: center;
            float: left; /*设置<li>横排排列*/
        }
    </style>
</head>
<body>
<div id="top">
    <ul style="list-style-type: none">
        <c:if test="${empty loginCustomer}">
            <li class="lihead"><a href="${pageContext.request.contextPath}/CustomerServlet?method=loginUI">登录</a></li>
            <li class="lihead"><a href="${pageContext.request.contextPath}/CustomerServlet?method=registerUI">注册</a></li>
        </c:if>
        <c:if test="${not empty loginCustomer}">
            <li class="lihead"><a href="${pageContext.request.contextPath}/CartServlet?method=findCart">我的购物车</a></li>
            <li class="lihead"><a href="${pageContext.request.contextPath}/InvoiceServlet?method=findAllInvoiceByCid">我的发票</a></li>
            <li class="lihead">欢迎<a href="${pageContext.request.contextPath}/CustomerServlet?method=customerInfo">${loginCustomer.cname}</a></li>
            <li class="lihead" style="color: red">
                <c:if test="${loginCustomer.type == 1}">黄金会员</c:if>
                <c:if test="${loginCustomer.type == 2}">白银会员</c:if>
                <c:if test="${loginCustomer.type == 3}">普通会员</c:if>
            </li>
            <li class="lihead"><a href="${pageContext.request.contextPath}/CustomerServlet?method=exitLogin">退出</a></li>
        </c:if>
    </ul>

</div>

<div id="daohan">
    <ul style="list-style-type: none">
        <li class="lihead"><a href="${pageContext.request.contextPath}/IndextServlet">首页</a> </li>
        <c:forEach items="${categories}" var="c">
            <li class="lihead"><a href="${pageContext.request.contextPath}/CategoryServlet?method=findCategoryByPcid&pcid=${c.pcid}">${c.pcname}</a></li>
        </c:forEach>
    </ul>
</div>
<br/><br/><br/>
</body>
</html>
