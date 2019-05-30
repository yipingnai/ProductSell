<%--
  Created by IntelliJ IDEA.
  User: JYM
  Date: 5/24/2019
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AdminCustomerServlet?method=addCustomer" method="post">

    <table border="1">
        <tr>
            <td>名字</td>
            <td><input type="text" name="cname"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="cpassword"/></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="telephone"/></td>
        </tr>
        <tr>
            <td>信用</td>
            <td>
                <input type="radio" name="credit" value="1">优
                <input type="radio" name="credit" value="2">良
                <input type="radio" name="credit" value="3">一般
                <input type="radio" name="credit" value="4">差
             </td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                <input type="radio" name="type" value="1">黄金会员
                <input type="radio" name="type" value="2">白银会员
                <input type="radio" name="type" value="3">普通会员
            </td>
        </tr>
        <tr>
            <td>预付款</td>
            <td><input type="text" name="subsist"/></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="添加"/></td>
        </tr>
    </table>
</form>

</body>
</html>
