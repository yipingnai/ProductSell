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
    <style>
        .product{
            width: auto;
            height: auto;
            background: aliceblue;
        }
        .productxiao{
            float: left;
            width: 200px;
            height: 200px;
            margin-left: 30px;
            margin-top: 10px;
            background: aquamarine;
            position: relative;
        }
    </style>
</head>
<body>
<br/><br/><br/><br/>
<c:if test="${empty adminFindProducts}">
    <h2>暂无产品</h2>
</c:if>
<c:if test="${not empty adminFindProducts}">
    <div class="product">
        <c:forEach items="${adminFindProducts}" var="p">
            <div class="productxiao">
                <table border="1" style="width: 198px;height: 198px;text-align: center">
                    <tr>
                        <td colspan="2"><a href="#">${p.pname}</a></td>
                    </tr>
                    <tr style="height: 100px">
                        <td colspan="2">${p.info}</td>
                    </tr>
                    <tr>
                        <td colspan="2">${p.price}</td>
                    </tr>
                    <c:if test="${newAdmin.type == 1}">
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/AdminProductServlet?method=updateProductUI&pid=${p.pid}">修改</a> </td>
                            <td><a href="#" onclick=doDelete("${p.pid}")>删除</a> </td>
                        </tr>
                    </c:if>
                    <c:if test="${newAdmin.type == 2}">
                        <tr>
                            <td colspan="2">库存：${p.amount} </td>
                        </tr>
                    </c:if>
                </table>
            </div>
        </c:forEach>
    </div>
</c:if>
<script type="text/javascript">
    function doDelete(pid) {
        alert(pid);
        var flag = confirm("是否确认删除？");
        if(flag) {
            window.location.href="${pageContext.request.contextPath}/AdminProductServlet?method=deleteProduct&pid="+pid;
        }
    }
</script>

</body>
</html>
