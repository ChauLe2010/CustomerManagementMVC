<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/1/2020
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new Customer</title>
</head>
<body>
<c:if test="${successMessage!=null}">
    <h3>${successMessage}</h3>
</c:if>
<p><a href="customers?action=list">Back to customer list</a></p>
Create new customer:
<div>
    <form action="/customers?action=create" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><textarea name="address"></textarea></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
