<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/1/2020
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${successMessage!=null}">
    <h3>${successMessage}</h3>
</c:if>
<p><a href="customers">Back to list</a></p>
Update information:
<div>
    <form action="/customers?action=edit&id=${customer.getId()}" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${customer.getName()}"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email" value="${customer.getEmail()}"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><textarea name="address">${customer.getAddress()}</textarea></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
