<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/21/2019
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品销售管理系统</title>
    <style>
        #page{
            width: 80%;
            height: auto;
            margin: 0 auto;
        }
        #top{
            width: 100%;
            height: 30px;
            background: aquamarine;
        }
        #leftdiv{
            width: 30%;
            height: 100%;
            background: #66FF99;
            float: left;
        }
        #rightdiv {
            width: 70%;
            height: 100%;
            background: bisque;
            float: left;
        }
    </style>
</head>
<body>

    <h1>产品销售管理系统</h1>
    <div id="page">
        <div id="top">
            <%@include file="top.jsp"%>
        </div>
        <div id="leftdiv">
            <%@include file="left.jsp"%>
        </div>
        <div id="rightdiv">
            <iframe name="rightcontext" src="${pageContext.request.contextPath}/admin/right.jsp" width="100%" height="100%"></iframe>
        </div>
    </div>
</body>
