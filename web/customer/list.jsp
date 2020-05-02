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
    <title>Customers List</title>
</head>
<body>

<a href="/customers?action=create">Add new customer</a>
<h1>Customers List:</h1>
<table style="width: 30%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td><a href="customers?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="customers?action=edit&id=${customer.getId()}">Edit</a></td>
            <td><a href="customers?action=delete&id=${customer.getId()}">Delete</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
