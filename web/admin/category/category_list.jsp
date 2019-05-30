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
<div id="categorylist">

    <table border="1">
        <tr>
            <td>分类名称</td>
            <c:if test="${newAdmin.type == 1}">
                <td colspan="2">操作</td>
            </c:if>
        </tr>
        <c:forEach items="${adminFindCategory}" var="pc">
            <tr>
                <td>${pc.pcname}</td>
                <c:if test="${newAdmin.type == 1}">
                    <td><a href="${pageContext.request.contextPath}/AdminCategoryServlet?method=updateCategoryUI&pcid=${pc.pcid}">修改</a></td>
                    <td><a href="#" onclick=doDelete("${pc.pcid}")>删除</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<script type="text/javascript">
    function doDelete(pcid) {
        alert(pcid);
        var flag = confirm("是否确认删除？");
        if(flag) {
            window.location.href="${pageContext.request.contextPath}/AdminCategoryServlet?method=deleteCategory&pcid="+pcid;
        }
    }
</script>

</body>
</html>
