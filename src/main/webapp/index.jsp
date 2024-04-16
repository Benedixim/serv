<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= new java.util.Date() %>
</h1>

<p>
    <%
        java.util.Date now = new java.util.Date();
        String someString = "Tekywaя data: " + now;

    %>
    <%= someString%>
    

</p>
<p >
    <%@ page import="java.util.Date, com.logic.Test" %>
    <%@ page import="com.logic.DatabaseHandler" %>
    <%@ page import="com.logic.User" %>
    <%@ page import="java.util.List" %>





</p>

<p>
</p>

<table>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>
    <% DatabaseHandler databaseHandler = new DatabaseHandler();
        List<User> users = databaseHandler.getAllUsers();
        for (User u: users) {
    %>
    <tr>
        <td><%= u.getUserName() %></td>
        <td><%= u.getPassword() %></td>
        <td>
            <form action="delete" method="post">
                <input type="hidden" name="userId" value="<%= u.getId() %>">
                <input type="submit" value="Delete">
            </form>
            <form action="update" method="get">
                <input type="hidden" name="userId" value="<%= u.getId() %>">
                <input type="submit" value="Update">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<form action="hello-servlet">
    <label for="size">Имя:</label>
    <input type="text" name="kol" id="size">
    <br>
    <label for="lines">Пароль:</label>
    <input type="text" name="px" id="lines">
    <br>
    <br>
    <button type="submit">Add</button>
</form>

<br/>

</body>
</html>