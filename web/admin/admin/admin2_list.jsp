<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/27/2019
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="align-content: center">
<c:if test="${empty admins}">
    没有可管理信息！
</c:if>
<c:if test="${not empty admins}">
    <table style="width: 80%" border="1">
        <tr>
            <td>管理员账号</td>
            <td>管理员名字</td>
            <td>管理员密码</td>
            <td>管理员类型</td>
                <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${admins}" var="a">
            <tr>
                <td>${a.anumber}</td>
                <td>${a.aname}</td>
                <td>${a.apassword}</td>
                <td>${a.type}</td>
                    <td><a href="${pageContext.request.contextPath}/AdminServlet?method=updateAdminUI&aid=${a.aid}">修改</a></td>
                    <td><a href="#" onclick=ondelete("${a.aid}")>删除</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>

    <script type="text/javascript">
        function ondelete(aid) {
            var flag = confirm("是否确认删除？");
            if(flag) {
                window.location.href="${pageContext.request.contextPath}/AdminServlet?method=deleteAdminByAid&aid="+aid;
            }
        }
    </script>
</body>
</html>
