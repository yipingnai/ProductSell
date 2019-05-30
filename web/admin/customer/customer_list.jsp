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
        .customer{
            width: auto;
            height: auto;
            background: aliceblue;
        }
    </style>
</head>
<body>
<br/><br/><br/><br/>
<c:if test="${empty adminFindCustomer}">
    <h2>暂无用户</h2>
</c:if>
<c:if test="${not empty adminFindCustomer}">
    <div class="customer">
        <table border="1" style="width: 100%;height: 50px">
            <tr>
                <td>名字</td>
                <td>密码</td>
                <td>电话</td>
                <td>信用</td>
                <td>类型</td>
                <td>预付款</td>
                <td>地址</td>
                <c:if test="${newAdmin.type == 1}">
                    <td colspan="2">操作</td>
                </c:if>
            </tr>
            <c:forEach items="${adminFindCustomer}" var="c">
             <tr>
                <td>${c.cname}</td>
                <td>${c.cpassword}</td>
                <td>${c.telephone}</td>
                <td>
                    <c:if test="${c.credit == 1}">优</c:if>
                    <c:if test="${c.credit == 2}">良</c:if>
                    <c:if test="${c.credit == 3}">一般</c:if>
                    <c:if test="${c.credit == 4}">差</c:if>
                </td>
                <td>
                    <c:if test="${c.type == 1}">黄金会员</c:if>
                    <c:if test="${c.type == 2}">白银会员</c:if>
                    <c:if test="${c.type == 3}">普通会员</c:if>
                </td>
                <td>${c.subsist}</td>
                <td>${c.address}</td>
                 <c:if test="${newAdmin.type == 1}">
                     <td><a href="${pageContext.request.contextPath}/AdminCustomerServlet?method=updateCustomerUI&cid=${c.cid}">修改</a></td>
                     <td><a href="#" onclick=doDelete("${c.cid}")>删除</a></td>
                 </c:if>
             </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<script type="text/javascript">
    function doDelete(cid) {
        alert(cid);
        var flag = confirm("是否确认删除？");
        if(flag) {
            window.location.href="${pageContext.request.contextPath}/AdminCustomerServlet?method=deleteCustomer&cid="+cid;
        }
    }
</script>

</body>
</html>
